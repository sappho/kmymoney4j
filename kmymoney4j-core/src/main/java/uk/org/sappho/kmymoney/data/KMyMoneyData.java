package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

public class KMyMoneyData {

    private final AccountGroup accounts;
    private final PayeeGroup payees;
    private final TransactionGroup transactions;
    private final Value lastUpdated;
    private final long version;
    private final long fixVersion;

    public KMyMoneyData(DataNode node) throws DataNodeException, IllegalArgumentException,
            SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        node.checkTag("KMYMONEY-FILE");
        accounts = new AccountGroup(node.getChildNode(AccountGroup.tag));
        payees = new PayeeGroup(node.getChildNode(PayeeGroup.tag));
        transactions = new TransactionGroup(node.getChildNode(TransactionGroup.tag));
        DataNode infoNode = node.getChildNode("FILEINFO");
        lastUpdated = infoNode.getChildNode("LAST_MODIFIED_DATE").getAttribute("date");
        version = infoNode.getChildNode("VERSION").getAttribute("id").getLong();
        fixVersion = infoNode.getChildNode("FIXVERSION").getAttribute("id").getLong();
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

    public Date getLastUpdated() throws DataNodeException {

        return lastUpdated.getDate();
    }

    public long getVersion() throws DataNodeException {

        return version;
    }

    public long getFixVersion() throws DataNodeException {

        return fixVersion;
    }
}
