package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> timeEntryHashMap = new HashMap<>();
    long id = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        /*int size = timeEntryHashMap.size();*/
        timeEntry.setId(id);
        timeEntryHashMap.put(id, timeEntry);
        id ++;
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        TimeEntry te = timeEntryHashMap.get(id);
        if(null != te) {
            return te;
        }
        return null;
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> timeEntryList = new ArrayList(timeEntryHashMap.values());
        return timeEntryList;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry te = timeEntryHashMap.get(id);
        if(null != te) {
            timeEntry.setId(id);
            timeEntryHashMap.put(id, timeEntry);
            return timeEntry;
        }
        return null;
    }

    @Override
    public void delete(long id) {
        timeEntryHashMap.remove(id);
    }
}
