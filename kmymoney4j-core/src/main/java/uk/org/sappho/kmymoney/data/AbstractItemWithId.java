package uk.org.sappho.kmymoney.data;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public abstract class AbstractItemWithId extends AbstractItem {

    private final Value id;

    protected AbstractItemWithId(DataNode node) throws DataNodeException {

        super(node);
        id = node.getAttribute("id");
    }

    public long getId() throws DataNodeException {

        return id.getId(getIdPrefix(), getReservedIds());
    }

    abstract protected String getIdPrefix();

    protected String[] getReservedIds() {

        return new String[] {};
    }
}
