package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class PayeeGroup extends AbstractGroup<Payee> {

    public static final String tag = "PAYEES";

    public PayeeGroup(DataNode node) throws IllegalArgumentException, SecurityException,
            DataNodeException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node, Payee.class);
    }

    @Override
    public String getTag() {

        return tag;
    }
}
