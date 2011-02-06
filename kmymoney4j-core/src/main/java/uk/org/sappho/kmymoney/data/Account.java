package uk.org.sappho.kmymoney.data;

import java.util.Date;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class Account extends AbstractItemWithIdAndName {

    private final Value parentAccountId;
    private final Value lastModified;

    public Account(DataNode node) throws DataNodeException {

        super(node);
        parentAccountId = node.getAttribute("parentaccount");
        lastModified = node.getAttribute("lastmodified");
    }

    public String getParentAccountId() {

        return parentAccountId.getValue();
    }

    public Date getLastModified() throws DataNodeException {

        return lastModified.getDate();
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
