package uk.org.sappho.kmymoney.rawdata.persistence.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.NameValuePair;
import uk.org.sappho.kmymoney.rawdata.RawData;
import uk.org.sappho.kmymoney.rawdata.Value;
import uk.org.sappho.kmymoney.rawdata.persistence.RawDataPersistence;

public abstract class AbstractRawDataPersistence implements RawDataPersistence {

    private final static Pattern xmlRegex = Pattern.compile("^<(.*)>$");
    private final static Pattern nodeRegex = Pattern.compile("^(/|)([A-Z-_]+)(( +[a-zA-Z]+=\".*?\")*)(/|)$");
    private final static Pattern nameValueRegex = Pattern.compile("^ +([a-zA-Z]+)=\"(.*?)\"(.*)$");

    protected RawData load(InputStream inputStream) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        boolean readingHeader = true;
        List<String> header = new ArrayList<String>();
        DataNode node = new DataNode("", new ArrayList<NameValuePair>());
        List<DataNode> nodeStack = new ArrayList<DataNode>();
        nodeStack.add(node);
        List<DataNode> nodes = node.getChildNodes();
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            line = line.trim();
            Matcher matcher = xmlRegex.matcher(line);
            if (!matcher.matches())
                throw new IOException("Content not XML: " + line);
            matcher = nodeRegex.matcher(matcher.group(1));
            if (matcher.matches()) {
                readingHeader = false;
                String tag = matcher.group(2);
                // start node?
                if (matcher.group(1).length() == 0) {
                    // yes, it's a start node
                    List<NameValuePair> attributes = new ArrayList<NameValuePair>();
                    String attrStr = matcher.group(3);
                    while (attrStr.length() > 0) {
                        Matcher nameValueMatcher = nameValueRegex.matcher(attrStr);
                        if (!nameValueMatcher.matches())
                            throw new IOException("Incorrect KMyMoney attributes: " + line);
                        String name = nameValueMatcher.group(1);
                        String value = StringEscapeUtils.unescapeXml(nameValueMatcher.group(2));
                        attrStr = nameValueMatcher.group(3);
                        attributes.add(new NameValuePair(name, new Value(value)));
                    }
                    node = new DataNode(tag, attributes);
                    nodes.add(node);
                    // also a closer?
                    if (matcher.group(5).length() == 0) {
                        // no, so will have child nodes
                        nodeStack.add(node);
                        nodes = node.getChildNodes();
                    }
                } else {
                    // close node
                    if (matcher.group(3).length() > 0)
                        throw new IOException("Incorrect KMyMoney node close: " + line);
                    int nodeStackTop = nodeStack.size() - 1;
                    if (nodeStackTop < 1)
                        throw new IOException("KMyMoney node close mismatch: " + line);
                    node = nodeStack.get(nodeStackTop);
                    if (!tag.equals(node.getTag()))
                        throw new IOException("KMyMoney node close mismatch: " + line);
                    nodeStack.remove(nodeStackTop);
                    node = nodeStack.get(nodeStackTop - 1);
                    nodes = node.getChildNodes();
                }
            } else {
                if (readingHeader)
                    header.add(line);
                else
                    throw new IOException("Incorrect KMyMoney data: " + line);
            }
        }
        reader.close();
        if (nodeStack.size() != 1 || nodes.size() == 0)
            throw new IOException("KMyMoney data is incomplete");
        if (nodes.size() > 1)
            throw new IOException("KMyMoney data has more than one root element");
        node = nodes.get(0);
        return new RawData(header, node);
    }

    protected void save(RawData rawData, OutputStream outputStream) throws IOException {

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (String line : rawData.getHeader()) {
            writer.write(line);
            writer.write(10);
        }
        save(writer, 0, rawData.getRootNode());
        writer.close();
    }

    private void save(BufferedWriter writer, int indent, DataNode node) throws IOException {

        for (int ic = 0; ic < indent; ic++)
            writer.write(" ");
        writer.write("<" + node.getTag());
        for (NameValuePair nameValuePair : node.getAttributes()) {
            writer.write(" " + nameValuePair.getName() + "=\"");
            String value = nameValuePair.getValue().toString();
            for (char ch : value.toCharArray())
                switch (ch) {
                case 10:
                    writer.write("&#xa;");
                    break;
                case '"':
                    writer.write("&quot;");
                    break;
                case '&':
                    writer.write("&amp;");
                    break;
                case '<':
                    writer.write("&lt;");
                    break;
                case '>':
                    writer.write("&gt;");
                    break;
                default:
                    writer.write(ch);
                }
            writer.write("\"");
        }
        List<DataNode> childNodes = node.getChildNodes();
        if (childNodes.size() == 0)
            writer.write("/");
        writer.write(">");
        writer.write(10);
        for (DataNode childNode : childNodes)
            save(writer, indent + 1, childNode);
        if (childNodes.size() != 0) {
            for (int ic = 0; ic < indent; ic++)
                writer.write(" ");
            writer.write("</" + node.getTag() + ">");
            writer.write(10);
        }
    }
}
