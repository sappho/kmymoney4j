package uk.org.sappho.kmymoney.data;

import java.util.List;

public class KMyMoneyRawData {

    private final List<String> header;
    private final KMyMoneyDataNode rootNode;

    public KMyMoneyRawData(List<String> header, KMyMoneyDataNode rootNode) {

        this.header = header;
        this.rootNode = rootNode;
    }

    public List<String> getHeader() {

        return header;
    }

    public KMyMoneyDataNode getRootNode() {

        return rootNode;
    }
}
