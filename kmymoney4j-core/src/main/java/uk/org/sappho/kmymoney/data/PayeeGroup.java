package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.NameValuePair;
import uk.org.sappho.kmymoney.rawdata.Value;

public class PayeeGroup extends AbstractGroup<Payee> {

    public static final String tag = "PAYEES";

    public PayeeGroup(DataNode node) throws IllegalArgumentException, SecurityException,
            DataNodeException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node, Payee.class);
    }

    public Payee add(String name) throws IllegalArgumentException, SecurityException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchMethodException, DataNodeException {

        List<NameValuePair> payeeAttributes = new ArrayList<NameValuePair>();
        payeeAttributes.add(new NameValuePair("matchingenabled", new Value("0")));
        payeeAttributes.add(new NameValuePair("email", new Value("")));
        payeeAttributes.add(new NameValuePair("id", new Value("")));
        payeeAttributes.add(new NameValuePair("name", new Value(name)));
        payeeAttributes.add(new NameValuePair("reference", new Value("")));
        DataNode payeeNode = new DataNode(Payee.tag, payeeAttributes);
        List<NameValuePair> addressAttributes = new ArrayList<NameValuePair>();
        addressAttributes.add(new NameValuePair("street", new Value("")));
        addressAttributes.add(new NameValuePair("postcode", new Value("")));
        addressAttributes.add(new NameValuePair("telephone", new Value("")));
        addressAttributes.add(new NameValuePair("city", new Value("")));
        addressAttributes.add(new NameValuePair("state", new Value("")));
        DataNode addressNode = new DataNode("ADDRESS", addressAttributes);
        payeeNode.getChildNodes().add(addressNode);
        addById(payeeNode, Payee.class);
        return null;
    }

    @Override
    public String getTag() {

        return tag;
    }
}
