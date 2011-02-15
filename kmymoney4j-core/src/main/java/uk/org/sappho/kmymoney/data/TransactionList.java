package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.lang.math.Fraction;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class TransactionList extends AbstractList<Transaction> {

    public static final String tag = "TRANSACTIONS";

    public TransactionList(DataNode node) throws IllegalArgumentException, SecurityException,
            DataNodeException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node, Transaction.class);
    }

    public void add(Date postDate, Date entryDate, Account account, Payee payee, String memo, Fraction value,
            String commodity) {

    }

    @Override
    public String getTag() {

        return tag;
    }
}
