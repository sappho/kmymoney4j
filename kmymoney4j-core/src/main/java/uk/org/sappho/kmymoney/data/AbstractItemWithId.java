package uk.org.sappho.kmymoney.data;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public abstract class AbstractItemWithId extends AbstractItem {

    private final Long id;
    private final String idString;

    protected AbstractItemWithId(DataNode node) throws DataNodeException {

        super(node);
        Value value = node.getAttribute("id");
        idString = value.getValue();
        boolean isReserved = false;
        for (String candidate : getReservedIds())
            if (candidate.equals(idString)) {
                isReserved = true;
                break;
            }
        id = isReserved ? 0L : value.getId(getIdPrefix());
    }

    public Long getId() {
        return id;
    }

    protected String[] getReservedIds() {

        return new String[] {};
    }

    abstract protected String getIdPrefix();
}
