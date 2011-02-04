package uk.org.sappho.kmymoney.data;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class Payee extends AbstractItemWithIdAndName {

    public Payee(DataNode node) throws DataNodeException {

        super(node);
    }

    @Override
    protected String getTag() {

        return "PAYEE";
    }

    @Override
    protected String getIdPrefix() {

        return "P";
    }
}
