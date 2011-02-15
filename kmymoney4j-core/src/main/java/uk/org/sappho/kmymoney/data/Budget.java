package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.Date;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class Budget extends AbstractItemWithIdAndName {

    private final Value startDate;
    private final Value version;
    private final BudgetAccountList budgetAccounts;

    public static final String tag = "BUDGET";
    private final static DecimalFormat idNumberFormat = new DecimalFormat("000000");

    public Budget(DataNode node) throws DataNodeException, IllegalArgumentException, SecurityException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node);
        startDate = node.getAttribute("start");
        version = node.getAttribute("version");
        budgetAccounts = new BudgetAccountList(node);
    }

    public Date getStartDate() throws DataNodeException {

        return startDate.getDate();
    }

    public long getVersion() throws DataNodeException {

        return version.getLong();
    }

    public BudgetAccountList getBudgetAccounts() {

        return budgetAccounts;
    }

    @Override
    protected String getTag() {

        return tag;
    }

    @Override
    protected String getIdPrefix() {

        return "B";
    }

    @Override
    protected DecimalFormat getIdNumberFormat() {

        return idNumberFormat;
    }
}
