package uk.org.sappho.kmymoney.data;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public abstract class AbstractItem {

    private final DataNode node;

    protected AbstractItem(DataNode node) throws DataNodeException {

        node.checkTag(getTag());
        this.node = node;
    }

    protected DataNode getNode() {

        return node;
    }

    abstract protected String getTag();
}
