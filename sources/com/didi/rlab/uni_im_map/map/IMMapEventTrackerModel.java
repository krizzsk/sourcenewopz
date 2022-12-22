package com.didi.rlab.uni_im_map.map;

import com.didi.raven.config.RavenKey;
import com.didi.rlab.uni_im_map.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class IMMapEventTrackerModel extends UniModel {

    /* renamed from: a */
    private String f34204a;

    /* renamed from: b */
    private Map<String, Object> f34205b;

    public String getEventId() {
        return this.f34204a;
    }

    public void setEventId(String str) {
        this.f34204a = str;
    }

    public Map<String, Object> getAttrs() {
        return this.f34205b;
    }

    public void setAttrs(Map<String, Object> map) {
        this.f34205b = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("eventId", this.f34204a);
        hashMap.put(RavenKey.ATTRS, this.f34205b);
        return hashMap;
    }

    public static IMMapEventTrackerModel fromMap(Map<String, Object> map) {
        IMMapEventTrackerModel iMMapEventTrackerModel = new IMMapEventTrackerModel();
        iMMapEventTrackerModel.f34204a = (!map.containsKey("eventId") || map.get("eventId") == null) ? "" : (String) map.get("eventId");
        iMMapEventTrackerModel.f34205b = (!map.containsKey(RavenKey.ATTRS) || map.get(RavenKey.ATTRS) == null) ? new HashMap<>() : (Map) map.get(RavenKey.ATTRS);
        return iMMapEventTrackerModel;
    }
}
