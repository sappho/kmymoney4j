package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class KMyMoneyData extends AbstractItem {

    private final AccountList accounts;
    private final PayeeList payees;
    private final TransactionList transactions;
    private final ScheduleList schedules;
    private final CurrencyList currencies;
    private final PriceList prices;
    private final Value lastUpdated;
    private final long version;
    private final long fixVersion;
    private final String baseCurrency;

    public KMyMoneyData(DataNode node) throws DataNodeException, IllegalArgumentException,
            SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node);
        accounts = new AccountList(node.getChildNode(AccountList.tag));
        payees = new PayeeList(node.getChildNode(PayeeList.tag));
        transactions = new TransactionList(node.getChildNode(TransactionList.tag));
        schedules = new ScheduleList(node.getChildNode(ScheduleList.tag));
        currencies = new CurrencyList(node.getChildNode(CurrencyList.tag));
        prices = new PriceList(node.getChildNode(PriceList.tag));
        DataNode infoNode = node.getChildNode("FILEINFO");
        lastUpdated = infoNode.getChildNode("LAST_MODIFIED_DATE").getAttribute("date");
        version = infoNode.getChildNode("VERSION").getAttribute("id").getLong();
        fixVersion = infoNode.getChildNode("FIXVERSION").getAttribute("id").getLong();
        DataNode keyValuePairsNode = node.getChildNode("KEYVALUEPAIRS");
        String baseCurrency = null;
        for (DataNode keyValuePairNode : keyValuePairsNode.getChildNodes())
            if (keyValuePairNode.getTag().equals("PAIR")
                    && keyValuePairNode.getAttribute("key").toString().equals("kmm-baseCurrency"))
                baseCurrency = keyValuePairNode.getAttribute("value").toString();
        if (baseCurrency == null)
            throw new DataNodeException("Base currency is missing from key/value pair table");
        this.baseCurrency = baseCurrency;
    }

    public AccountList getAccounts() {

        return accounts;
    }

    public PayeeList getPayees() {

        return payees;
    }

    public TransactionList getTransactions() {

        return transactions;
    }

    public ScheduleList getSchedules() {
        return schedules;
    }

    public CurrencyList getCurrencies() {

        return currencies;
    }

    public PriceList getPrices() {

        return prices;
    }

    public Date getLastUpdated() throws DataNodeException {

        return lastUpdated.getDate();
    }

    public long getVersion() throws DataNodeException {

        return version;
    }

    public long getFixVersion() throws DataNodeException {

        return fixVersion;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setLastUpdated(Date date) {

        lastUpdated.setDate(date);
    }

    @Override
    protected String getTag() {

        return "KMYMONEY-FILE";
    }
}
