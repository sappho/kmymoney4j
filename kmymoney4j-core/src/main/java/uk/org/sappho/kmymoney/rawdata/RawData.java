package uk.org.sappho.kmymoney.rawdata;

import java.util.List;

public class RawData {

    private final List<String> header;
    private final DataNode rootNode;

    public RawData(List<String> header, DataNode rootNode) {

        this.header = header;
        this.rootNode = rootNode;
    }

    public List<String> getHeader() {

        return header;
    }

    public DataNode getRootNode() {

        return rootNode;
    }
}
