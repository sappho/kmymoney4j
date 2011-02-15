package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class BudgetAccount extends AbstractList<BudgetPeriod> {

    private final Value accountId;
    private final Value budgetLevel;

    public static final String tag = "ACCOUNT";

    public BudgetAccount(DataNode node) throws IllegalArgumentException, SecurityException,
            DataNodeException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node, BudgetPeriod.class);
        accountId = node.getAttribute("id");
        budgetLevel = node.getAttribute("budgetlevel");
    }

    public String getAccountId() {

        return accountId.toString();
    }

    public String getBudgetLevel() {

        return budgetLevel.toString();
    }

    @Override
    public String getTag() {

        return tag;
    }

    @Override
    protected boolean hasChildCount() {

        return false;
    }
}
