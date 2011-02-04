package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class KMyMoneyData {

    private final AccountGroup accounts;
    private final PayeeGroup payees;
    private final TransactionGroup transactions;

    public KMyMoneyData(DataNode node) throws DataNodeException, IllegalArgumentException,
            SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        node.checkTag("KMYMONEY-FILE");
        accounts = new AccountGroup(node.getChildNode(AccountGroup.tag));
        payees = new PayeeGroup(node.getChildNode(PayeeGroup.tag));
        transactions = new TransactionGroup(node.getChildNode(TransactionGroup.tag));
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
}
