package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class Schedule extends AbstractItemWithIdAndName {

    public final static String tag = "SCHEDULED_TX";
    private final static DecimalFormat idNumberFormat = new DecimalFormat("000000");

    private final Transaction transaction;

    public Schedule(DataNode node) throws DataNodeException, IllegalArgumentException, SecurityException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node);
        transaction = new Transaction(node.getChildNode(Transaction.tag));
    }

    public Transaction getTransaction() {

        return transaction;
    }

    @Override
    protected String getTag() {

        return tag;
    }

    @Override
    protected String getIdPrefix() {

        return "SCH";
    }

    @Override
    protected DecimalFormat getIdNumberFormat() {

        return idNumberFormat;
    }
}
