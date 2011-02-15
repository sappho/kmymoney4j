package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class CurrencyList extends AbstractList<Currency> {

    public static final String tag = "CURRENCIES";

    public CurrencyList(DataNode node) throws IllegalArgumentException, SecurityException, DataNodeException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node, Currency.class);
    }

    @Override
    public String getTag() {

        return tag;
    }
}
