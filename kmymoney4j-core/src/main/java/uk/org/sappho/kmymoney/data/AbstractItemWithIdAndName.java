package uk.org.sappho.kmymoney.data;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public abstract class AbstractItemWithIdAndName extends AbstractItemWithId {

    private final Value name;

    protected AbstractItemWithIdAndName(DataNode node) throws DataNodeException {

        super(node);
        name = node.getAttribute("name");
    }

    @Override
    public String getName() {

        return name.toString();
    }
}
