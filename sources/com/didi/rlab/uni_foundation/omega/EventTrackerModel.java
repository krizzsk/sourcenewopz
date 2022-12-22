package com.didi.rlab.uni_foundation.omega;

import com.didi.raven.config.RavenKey;
import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class EventTrackerModel extends UniModel {

    /* renamed from: a */
    private String f34090a;

    /* renamed from: b */
    private Map<String, Object> f34091b;

    public String getEventId() {
        return this.f34090a;
    }

    public void setEventId(String str) {
        this.f34090a = str;
    }

    public Map<String, Object> getAttrs() {
        return this.f34091b;
    }

    public void setAttrs(Map<String, Object> map) {
        this.f34091b = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("eventId", this.f34090a);
        hashMap.put(RavenKey.ATTRS, this.f34091b);
        return hashMap;
    }

    public static EventTrackerModel fromMap(Map<String, Object> map) {
        EventTrackerModel eventTrackerModel = new EventTrackerModel();
        eventTrackerModel.f34090a = (!map.containsKey("eventId") || map.get("eventId") == null) ? "" : (String) map.get("eventId");
        eventTrackerModel.f34091b = (!map.containsKey(RavenKey.ATTRS) || map.get(RavenKey.ATTRS) == null) ? new HashMap<>() : (Map) map.get(RavenKey.ATTRS);
        return eventTrackerModel;
    }
}
