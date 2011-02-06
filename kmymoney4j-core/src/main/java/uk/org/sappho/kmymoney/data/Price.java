package uk.org.sappho.kmymoney.data;

import java.util.Date;

import org.apache.commons.lang.math.Fraction;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class Price extends AbstractItem {

    private final Value price;
    private final Value date;

    public Price(DataNode node) throws DataNodeException {

        super(node);
        price = node.getAttribute("price");
        date = node.getAttribute("date");
    }

    public Fraction getPrice() throws DataNodeException {

        return price.getFraction();
    }

    public Date getSymbol() throws DataNodeException {

        return date.getDate();
    }

    @Override
    protected String getTag() {

        return "PRICE";
    }
}
