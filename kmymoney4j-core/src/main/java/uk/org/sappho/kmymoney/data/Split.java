package uk.org.sappho.kmymoney.data;

import java.text.DecimalFormat;

import org.apache.commons.lang.math.Fraction;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class Split extends AbstractItemWithId {

    private final Value payeeId;
    private final Value accountId;
    private final Value memo;
    private final Value shares;
    private final Value value;

    private final static DecimalFormat idNumberFormat = new DecimalFormat("0000");

    public Split(DataNode node) throws DataNodeException {

        super(node);
        payeeId = node.getAttribute("payee");
        accountId = node.getAttribute("account");
        memo = node.getAttribute("memo");
        shares = node.getAttribute("shares");
        value = node.getAttribute("value");
    }

    public String getPayeeId() {

        return payeeId.toString();
    }

    public String getAccountId() {

        return accountId.toString();
    }

    public String getMemo() {

        return memo.toString();
    }

    public Fraction getShares() throws DataNodeException {

        return shares.getFraction();
    }

    public Fraction getValue() throws DataNodeException {

        return value.getFraction();
    }

    @Override
    protected String getTag() {

        return "SPLIT";
    }

    @Override
    protected String getIdPrefix() {

        return "S";
    }

    @Override
    protected DecimalFormat getIdNumberFormat() {

        return idNumberFormat;
    }
}
