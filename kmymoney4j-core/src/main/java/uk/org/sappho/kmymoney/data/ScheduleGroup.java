package uk.org.sappho.kmymoney.data;

import java.lang.reflect.InvocationTargetException;

import uk.org.sappho.kmymoney.rawdata.DataNode;
import uk.org.sappho.kmymoney.rawdata.DataNodeException;

public class ScheduleGroup extends AbstractGroup<Schedule> {

    public static final String tag = "SCHEDULES";

    public ScheduleGroup(DataNode node) throws IllegalArgumentException, SecurityException,
            DataNodeException, InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        super(node, Schedule.class);
    }

    @Override
    public String getTag() {

        return tag;
    }
}
