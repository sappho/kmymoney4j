package uk.org.sappho.kmymoney.data;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class Account extends AbstractItemWithIdAndName {

    //private final Date lastModified;

    public Account(DataNode node) throws DataNodeException {

        super(node);
    }

    @Override
    protected String getTag() {

        return "ACCOUNT";
    }

    @Override
    protected String getIdPrefix() {

        return "A";
    }

    @Override
    protected String[] getReservedIds() {

        return new String[] { "AStd::Asset", "AStd::Liability", "AStd::Expense", "AStd::Income", "AStd::Equity" };
    }
}
