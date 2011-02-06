package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class PricePairGroup extends AbstractGroup<Price> {

    public static final String tag = "PRICEPAIR";

    private final Value fromCurrencyId;
    private final Value toCurrencyId;

    public PricePairGroup(DataNode node) throws IllegalArgumentException, SecurityException, DataNodeException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node, Price.class);
        fromCurrencyId = node.getAttribute("from");
        toCurrencyId = node.getAttribute("to");
    }

    public String getFromCurrencyId() {

        return fromCurrencyId.getValue();
    }

    public String getToCurrencyId() {

        return toCurrencyId.getValue();
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
