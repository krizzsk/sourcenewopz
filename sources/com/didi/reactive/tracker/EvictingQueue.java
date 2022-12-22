package com.didi.reactive.tracker;

import android.os.SystemClock;
import com.didi.reactive.tracker.EventTracker;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EvictingQueue extends ConcurrentLinkedQueue<EventTracker.TrackedEvent> {
    private Map<String, EventTracker.TrackedEvent> eventIds = new ConcurrentHashMap();
    private int limited = 256;

    public EvictingQueue(int i) {
        this.limited = i;
    }

    public EvictingQueue() {
    }

    public boolean add(EventTracker.TrackedEvent trackedEvent) {
        super.add(trackedEvent);
        this.eventIds.put(trackedEvent.getEventId(), trackedEvent);
        while (size() > this.limited) {
            super.remove();
        }
        return true;
    }

    public EventTracker.TrackedEvent remove() {
        EventTracker.TrackedEvent trackedEvent = (EventTracker.TrackedEvent) super.remove();
        if (trackedEvent != null) {
            this.eventIds.remove(trackedEvent.getEventId());
        }
        return trackedEvent;
    }

    public boolean containsEvent(String str, long j) {
        EventTracker.TrackedEvent trackedEvent = this.eventIds.get(str);
        if (trackedEvent == null) {
            return false;
        }
        if (j <= 0 || trackedEvent.getTime() + j >= SystemClock.elapsedRealtime()) {
            return true;
        }
        return false;
    }
}
