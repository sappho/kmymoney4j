package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class TransactionGroup extends AbstractGroup<Transaction> {

    public static final String tag = "TRANSACTIONS";

    public TransactionGroup(DataNode node) throws IllegalArgumentException, SecurityException,
            DataNodeException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node, Transaction.class);
    }

    @Override
    public String getTag() {

        return tag;
    }
}
