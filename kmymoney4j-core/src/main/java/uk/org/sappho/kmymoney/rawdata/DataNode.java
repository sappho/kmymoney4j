package uk.org.sappho.kmymoney.rawdata;

import java.util.ArrayList;
import java.util.List;

public class DataNode {

    private final String tag;
    private final List<NameValuePair> attributes;
    private final List<DataNode> childNodes = new ArrayList<DataNode>();

    public DataNode(String nodeId, List<NameValuePair> attributes) {

        this.tag = nodeId;
        this.attributes = attributes;
    }

    public void checkTag(String requiredTag) throws DataNodeException {

        if (!tag.equals(requiredTag))
            throw new DataNodeException("Data node " + tag + " is not " + requiredTag + " as expected");
    }

    public String getTag() {

        return tag;
    }

    public List<NameValuePair> getAttributes() {

        return attributes;
    }

    public Value getAttribute(String name) throws DataNodeException {

        Value value = null;
        for (NameValuePair nameValuePair : attributes)
            if (nameValuePair.getName().equals(name)) {
                if (value != null)
                    throw new DataNodeException("Data attribute " + name + " is duplicated in " + tag + " node");
                value = nameValuePair.getValue();
            }
        if (value == null)
            throw new DataNodeException("Data attribute " + name + " is missing from " + tag + " node");
        return value;
    }

    public List<DataNode> getChildNodes() {

        return childNodes;
    }

    public DataNode getChildNode(String requiredTag) throws DataNodeException {

        DataNode childNode = null;
        for (DataNode node : childNodes)
            if (node.getTag().equals(requiredTag)) {
                if (childNode != null)
                    throw new DataNodeException("Child node " + requiredTag + " is duplicated in " + tag
                            + " node");
                childNode = node;
            }
        if (childNode == null)
            throw new DataNodeException("Child node " + requiredTag + " is missing from " + tag + " node");
        return childNode;
    }
}
