package uk.org.sappho.kmymoney.data;

import java.text.DecimalFormat;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public abstract class AbstractItemWithId extends AbstractItem {

    private final Value id;

    protected AbstractItemWithId(DataNode node) throws DataNodeException {

        super(node);
        id = node.getAttribute("id");
    }

    @Override
    public long getId() throws DataNodeException {

        return id.getId(getIdPrefix(), getReservedIds());
    }

    @Override
    public String getIdString() {

        return id.getValue();
    }

    @Override
    public void setId(long id) {

        this.id.setId(id, getIdPrefix(), getIdNumberFormat());
    }

    protected String[] getReservedIds() {

        return new String[] {};
    }

    abstract protected String getIdPrefix();

    abstract protected DecimalFormat getIdNumberFormat();
}
