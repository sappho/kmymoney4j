package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class Transaction extends AbstractItemWithId {

    //private final Date postDate;
    //private final Date entryDate;
    private final SplitGroup splits;

    public Transaction(DataNode node) throws DataNodeException, IllegalArgumentException, SecurityException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node);
        splits = new SplitGroup(node.getChildNode(SplitGroup.tag));
    }

    public SplitGroup getSplits() {
        return splits;
    }

    @Override
    protected String getTag() {

        return "TRANSACTION";
    }

    @Override
    protected String getIdPrefix() {

        return "T";
    }
}
