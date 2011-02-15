package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class AccountList extends AbstractList<Account> {

    public static final String tag = "ACCOUNTS";

    public AccountList(DataNode node) throws IllegalArgumentException, SecurityException,
            DataNodeException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node, Account.class);
    }

    @Override
    public String getTag() {

        return tag;
    }
}
