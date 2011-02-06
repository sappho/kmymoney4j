package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class PriceGroup extends AbstractGroup<PricePairGroup> {

    public static final String tag = "PRICES";

    public PriceGroup(DataNode node) throws IllegalArgumentException, SecurityException, DataNodeException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node, PricePairGroup.class);
    }

    @Override
    public String getTag() {

        return tag;
    }
}
