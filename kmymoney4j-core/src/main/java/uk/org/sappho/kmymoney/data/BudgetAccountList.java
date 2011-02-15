package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class BudgetAccountList extends AbstractList<BudgetAccount> {

    public BudgetAccountList(DataNode node) throws IllegalArgumentException, SecurityException,
            DataNodeException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node, BudgetAccount.class);
    }

    @Override
    public String getTag() {

        return Budget.tag;
    }

    @Override
    protected boolean hasChildCount() {

        return false;
    }
}
