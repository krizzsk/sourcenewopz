package com.didichuxing.omega.sdk.common.record;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EventsRecord extends Record {
    public EventsRecord() {
        put("es", new LinkedList());
    }

    public List<Map<String, Object>> getEvents() {
        List<Map<String, Object>> list = (List) get("es");
        if (list != null) {
            return list;
        }
        LinkedList linkedList = new LinkedList();
        put("es", linkedList);
        return linkedList;
    }

    public void addEvent(Event event) {
        if (event != null) {
            getEvents().add(event.eventMap());
        }
    }

    public void addAllEvents(Collection<Event> collection) {
        if (collection != null) {
            List<Map<String, Object>> events = getEvents();
            for (Event eventMap : collection) {
                events.add(eventMap.eventMap());
            }
        }
    }

    public void addAllEventsAndClean(Collection<Event> collection) {
        if (collection != null) {
            List<Map<String, Object>> events = getEvents();
            Iterator<Event> it = collection.iterator();
            while (it.hasNext()) {
                events.add(it.next().eventMap());
                it.remove();
            }
        }
    }
}
