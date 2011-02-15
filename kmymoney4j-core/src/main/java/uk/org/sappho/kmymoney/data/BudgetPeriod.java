package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.lang.math.Fraction;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class BudgetPeriod extends AbstractItem {

    private final Value startDate;
    private final Value amount;

    public BudgetPeriod(DataNode node) throws DataNodeException, IllegalArgumentException, SecurityException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        super(node);
        startDate = node.getAttribute("start");
        amount = node.getAttribute("amount");
    }

    public Date getStartDate() throws DataNodeException {

        return startDate.getDate();
    }

    public Fraction getAmount() throws DataNodeException {

        return amount.getFraction();
    }

    @Override
    protected String getTag() {

        return "PERIOD";
    }
}
