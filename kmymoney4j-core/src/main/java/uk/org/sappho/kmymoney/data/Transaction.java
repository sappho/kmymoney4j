package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.Date;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class Transaction extends AbstractItemWithId {

    private final Value postDate;
    private final Value entryDate;
    private final Value commodity;
    private final SplitList splits;

    public final static String tag = "TRANSACTION";
    private final static DecimalFormat idNumberFormat = new DecimalFormat("000000000000000000");

    public Transaction(DataNode node) throws DataNodeException, IllegalArgumentException, SecurityException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node);
        postDate = node.getAttribute("postdate");
        entryDate = node.getAttribute("entrydate");
        commodity = node.getAttribute("commodity");
        splits = new SplitList(node.getChildNode(SplitList.tag));
    }

    public Date getPostDate() throws DataNodeException {

        return postDate.getDate();
    }

    public Date getEntryDate() throws DataNodeException {

        return entryDate.getDate();
    }

    public String getCommodity() {

        return commodity.toString();
    }

    public SplitList getSplits() {
        return splits;
    }

    @Override
    protected String getTag() {

        return tag;
    }

    @Override
    protected String getIdPrefix() {

        return "T";
    }

    @Override
    protected DecimalFormat getIdNumberFormat() {

        return idNumberFormat;
    }
}
