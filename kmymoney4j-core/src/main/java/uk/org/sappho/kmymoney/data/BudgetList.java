package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class BudgetList extends AbstractList<Budget> {

    public static final String tag = "BUDGETS";

    public BudgetList(DataNode node) throws IllegalArgumentException, SecurityException,
            DataNodeException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node, Budget.class);
    }

    @Override
    public String getTag() {

        return tag;
    }
}
