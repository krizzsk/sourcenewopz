package com.didichuxing.omega.tracker;

import android.os.SystemClock;
import com.didichuxing.omega.tracker.ViewTracker;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EvictingQueue extends ConcurrentLinkedQueue<ViewTracker.TrackedEvent> {
    private Map<String, ViewTracker.TrackedEvent> eventIds = new ConcurrentHashMap();
    private int limited = 256;

    public EvictingQueue(int i) {
        this.limited = i;
    }

    public EvictingQueue() {
    }

    public boolean add(ViewTracker.TrackedEvent trackedEvent) {
        super.add(trackedEvent);
        this.eventIds.put(trackedEvent.getEventId(), trackedEvent);
        while (size() > this.limited) {
            super.remove();
        }
        return true;
    }

    public ViewTracker.TrackedEvent remove() {
        ViewTracker.TrackedEvent trackedEvent = (ViewTracker.TrackedEvent) super.remove();
        if (trackedEvent != null) {
            this.eventIds.remove(trackedEvent.getEventId());
        }
        return trackedEvent;
    }

    public boolean containsEvent(String str, long j) {
        ViewTracker.TrackedEvent trackedEvent = this.eventIds.get(str);
        if (trackedEvent == null) {
            return false;
        }
        if (j <= 0 || trackedEvent.getTime() + j >= SystemClock.elapsedRealtime()) {
            return true;
        }
        return false;
    }
}
