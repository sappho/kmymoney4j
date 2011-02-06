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

    public long getId() throws DataNodeException {

        return 0L;
    }

    public String getIdString() {

        return null;
    }

    public void setId(@SuppressWarnings("unused") long id) {
    }

    public String getName() {

        return null;
    }
}
