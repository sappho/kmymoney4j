package uk.org.sappho.kmymoney.data;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public abstract class AbstractItemWithIdAndName extends AbstractItemWithId {

    private final String name;

    protected AbstractItemWithIdAndName(DataNode node) throws DataNodeException {

        super(node);
        name = node.getAttribute("name").getValue();
        if (name.length() == 0)
            throw new DataNodeException("Payee " + getId() + " has a blank name");
    }

    public String getName() {
        return name;
    }
}
