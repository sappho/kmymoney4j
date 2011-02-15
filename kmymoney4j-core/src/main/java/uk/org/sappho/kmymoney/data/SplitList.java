package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class SplitList extends AbstractList<Split> {

    public static final String tag = "SPLITS";

    public SplitList(DataNode node) throws IllegalArgumentException, SecurityException, DataNodeException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node, Split.class);
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
