package uk.org.sappho.kmymoney.data;

import java.text.DecimalFormat;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class Payee extends AbstractItemWithIdAndName {

    public static final String tag = "PAYEE";
    private final static DecimalFormat idNumberFormat = new DecimalFormat("000000");

    public Payee(DataNode node) throws DataNodeException {

        super(node);
    }

    @Override
    protected String getTag() {

        return tag;
    }

    @Override
    protected String getIdPrefix() {

        return "P";
    }

    @Override
    protected DecimalFormat getIdNumberFormat() {

        return idNumberFormat;
    }
}
