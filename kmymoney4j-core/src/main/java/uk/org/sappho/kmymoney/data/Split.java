package uk.org.sappho.kmymoney.data;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class Split extends AbstractItemWithId {

    public Split(DataNode node) throws DataNodeException {

        super(node);
    }

    @Override
    protected String getTag() {

        return "SPLIT";
    }

    @Override
    protected String getIdPrefix() {

        return "S";
    }
}
