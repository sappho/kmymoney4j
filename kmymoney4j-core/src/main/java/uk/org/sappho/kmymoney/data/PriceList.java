package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class PriceList extends AbstractList<PricePairList> {

    public static final String tag = "PRICES";

    public PriceList(DataNode node) throws IllegalArgumentException, SecurityException, DataNodeException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node, PricePairList.class);
    }

    @Override
    public String getTag() {

        return tag;
    }
}
