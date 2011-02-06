package uk.org.sappho.kmymoney.data;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class Currency extends AbstractItem {

    private final Value id;
    private final Value symbol;

    public Currency(DataNode node) throws DataNodeException {

        super(node);
        id = node.getAttribute("id");
        symbol = node.getAttribute("symbol");
    }

    public String getId() {

        return id.getValue();
    }

    public String getSymbol() {

        return symbol.getValue();
    }

    @Override
    protected String getTag() {

        return "CURRENCY";
    }
}
