package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

abstract public class AbstractGroup<T> extends AbstractItem {

    private final List<T> items = new ArrayList<T>();

    private final static Class<?>[] constructorParameterTypes = { DataNode.class };

    protected AbstractGroup(DataNode node, Class<T> itemClass) throws DataNodeException,
            IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {

        super(node);
        node.checkTag(getTag());
        Long count = null;
        if (hasChildCount())
            count = node.getAttribute("count").getLong();
        for (DataNode childNode : node.getChildNodes()) {
            items.add(itemClass.getConstructor(constructorParameterTypes).newInstance(childNode));
        }
        if (hasChildCount() && items.size() != count)
            throw new DataNodeException(getTag() + " node should have " + count + " item(s) but has "
                        + items.size() + " instead");
    }

    public List<T> getItems() {

        return items;
    }

    protected boolean hasChildCount() {

        return true;
    }
}
