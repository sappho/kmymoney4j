package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class CurrencyGroup extends AbstractGroup<Currency> {

    public static final String tag = "CURRENCIES";

    public CurrencyGroup(DataNode node) throws IllegalArgumentException, SecurityException, DataNodeException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node, Currency.class);
    }

    @Override
    public String getTag() {

        return tag;
    }
}
