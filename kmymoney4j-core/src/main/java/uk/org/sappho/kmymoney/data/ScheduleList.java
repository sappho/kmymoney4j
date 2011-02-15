package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class ScheduleList extends AbstractList<Schedule> {

    public static final String tag = "SCHEDULES";

    public ScheduleList(DataNode node) throws IllegalArgumentException, SecurityException,
            DataNodeException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node, Schedule.class);
    }

    @Override
    public String getTag() {

        return tag;
    }
}
