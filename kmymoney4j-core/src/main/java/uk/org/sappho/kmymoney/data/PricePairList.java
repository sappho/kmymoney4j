package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class PricePairList extends AbstractList<Price> {

    public static final String tag = "PRICEPAIR";

    private final Value fromCurrencyId;
    private final Value toCurrencyId;

    public PricePairList(DataNode node) throws IllegalArgumentException, SecurityException, DataNodeException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node, Price.class);
        fromCurrencyId = node.getAttribute("from");
        toCurrencyId = node.getAttribute("to");
    }

    public String getFromCurrencyId() {

        return fromCurrencyId.toString();
    }

    public String getToCurrencyId() {

        return toCurrencyId.toString();
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
