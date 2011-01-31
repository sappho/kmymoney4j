package uk.org.sappho.kmymoney.data;

import java.util.ArrayList;
import java.util.List;

public class KMyMoneyDataNode {

    private final String nodeId;
    private final List<NameValuePair> attributes;
    private final List<KMyMoneyDataNode> childNodes = new ArrayList<KMyMoneyDataNode>();

    public KMyMoneyDataNode(String nodeId, List<NameValuePair> attributes) {

        this.nodeId = nodeId;
        this.attributes = attributes;
    }

    public String getNodeId() {

        return nodeId;
    }

    public List<NameValuePair> getAttributes() {

        return attributes;
    }

    public List<KMyMoneyDataNode> getChildNodes() {

        return childNodes;
    }
}
