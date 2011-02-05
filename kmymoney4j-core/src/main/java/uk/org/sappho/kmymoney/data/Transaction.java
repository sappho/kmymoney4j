package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class Transaction extends AbstractItemWithId {

    private final Value postDate;
    private final Value entryDate;
    private final Value commodity;
    private final Value memo;
    private final SplitGroup splits;

    public Transaction(DataNode node) throws DataNodeException, IllegalArgumentException, SecurityException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node);
        postDate = node.getAttribute("postdate");
        entryDate = node.getAttribute("entrydate");
        commodity = node.getAttribute("commodity");
        memo = node.getAttribute("memo");
        splits = new SplitGroup(node.getChildNode(SplitGroup.tag));
    }

    public Date getPostDate() throws DataNodeException {

        return postDate.getDate();
    }

    public Date getEntryDate() throws DataNodeException {

        return entryDate.getDate();
    }

    public String getCommodity() {

        return commodity.getValue();
    }

    public String getMemo() {

        return memo.getValue();
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
