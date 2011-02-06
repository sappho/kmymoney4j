package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;
import uk.org.sappho.kmymoney.rawdata.Value;

abstract public class AbstractGroup<T extends AbstractItem> extends AbstractItem {

    private final Value count;
    private final List<T> items = new LinkedList<T>();
    private final Map<String, T> idMap = new HashMap<String, T>();
    private final Map<String, T> nameMap = new HashMap<String, T>();

    private final static Class<?>[] constructorParameterTypes = { DataNode.class };

    protected AbstractGroup(DataNode node, Class<T> itemClass) throws DataNodeException,
            IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {

        super(node);
        if (hasChildCount())
            this.count = node.getAttribute("count");
        else
            this.count = new Value("0");
        Long count = this.count.getLong();
        for (DataNode childNode : node.getChildNodes())
            index(add(childNode, itemClass));
        if (hasChildCount() && items.size() != count)
            throw new DataNodeException(getTag() + " node should have " + count + " item(s) but has "
                        + items.size() + " instead");
    }

    public T addById(DataNode childNode, Class<T> itemClass) throws IllegalArgumentException, SecurityException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            DataNodeException {

        long id = 0;
        for (T item : items)
            if (item.getId() > id)
                id = item.getId();
        T item = add(childNode, itemClass);
        item.setId(id + 1);
        index(item);
        getNode().getChildNodes().add(childNode);
        count.setLong(count.getLong() + 1);
        return item;
    }

    private T add(DataNode childNode, Class<T> itemClass) throws IllegalArgumentException, SecurityException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        T item = itemClass.getConstructor(constructorParameterTypes).newInstance(childNode);
        items.add(item);
        return item;
    }

    private void index(T item) {

        String key = item.getIdString();
        if (key != null)
            idMap.put(key, item);
        key = item.getName();
        if (key != null)
            nameMap.put(key, item);
    }

    public List<T> getItems() {

        return items;
    }

    public Map<String, T> getIdMap() {

        return idMap;
    }

    public Map<String, T> getNameMap() {

        return nameMap;
    }

    protected boolean hasChildCount() {

        return true;
    }
}
