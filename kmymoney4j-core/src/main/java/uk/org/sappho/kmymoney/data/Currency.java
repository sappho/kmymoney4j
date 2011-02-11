package uk.org.sappho.kmymoney.data;

import java.text.DecimalFormat;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class Currency extends AbstractItemWithId {

    private final Value symbol;

    public Currency(DataNode node) throws DataNodeException {

        super(node);
        symbol = node.getAttribute("symbol");
    }

    public String getSymbol() {

        return symbol.toString();
    }

    @Override
    protected String getTag() {

        return "CURRENCY";
    }

    @Override
    protected String getIdPrefix() {

        return null;
    }

    @Override
    protected DecimalFormat getIdNumberFormat() {

        return null;
    }
}
