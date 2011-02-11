package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class KMyMoneyData extends AbstractItem {

    private final AccountGroup accounts;
    private final PayeeGroup payees;
    private final TransactionGroup transactions;
    private final ScheduleGroup schedules;
    private final CurrencyGroup currencies;
    private final PriceGroup prices;
    private final Value lastUpdated;
    private final long version;
    private final long fixVersion;
    private final String baseCurrency;

    public KMyMoneyData(DataNode node) throws DataNodeException, IllegalArgumentException,
            SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node);
        accounts = new AccountGroup(node.getChildNode(AccountGroup.tag));
        payees = new PayeeGroup(node.getChildNode(PayeeGroup.tag));
        transactions = new TransactionGroup(node.getChildNode(TransactionGroup.tag));
        schedules = new ScheduleGroup(node.getChildNode(ScheduleGroup.tag));
        currencies = new CurrencyGroup(node.getChildNode(CurrencyGroup.tag));
        prices = new PriceGroup(node.getChildNode(PriceGroup.tag));
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

    public AccountGroup getAccounts() {

        return accounts;
    }

    public PayeeGroup getPayees() {

        return payees;
    }

    public TransactionGroup getTransactions() {

        return transactions;
    }

    public ScheduleGroup getSchedules() {
        return schedules;
    }

    public CurrencyGroup getCurrencies() {

        return currencies;
    }

    public PriceGroup getPrices() {

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
