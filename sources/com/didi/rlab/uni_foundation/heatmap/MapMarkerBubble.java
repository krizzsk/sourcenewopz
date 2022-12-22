package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class MapMarkerBubble extends UniModel {

    /* renamed from: a */
    private String f34029a;

    /* renamed from: b */
    private String f34030b;

    /* renamed from: c */
    private String f34031c;

    /* renamed from: d */
    private String f34032d;

    public String getText() {
        return this.f34029a;
    }

    public void setText(String str) {
        this.f34029a = str;
    }

    public String getIcon() {
        return this.f34030b;
    }

    public void setIcon(String str) {
        this.f34030b = str;
    }

    public String getIcon2() {
        return this.f34031c;
    }

    public void setIcon2(String str) {
        this.f34031c = str;
    }

    public String getColor() {
        return this.f34032d;
    }

    public void setColor(String str) {
        this.f34032d = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("text", this.f34029a);
        hashMap.put("icon", this.f34030b);
        hashMap.put("icon2", this.f34031c);
        hashMap.put("color", this.f34032d);
        return hashMap;
    }

    public static MapMarkerBubble fromMap(Map<String, Object> map) {
        MapMarkerBubble mapMarkerBubble = new MapMarkerBubble();
        String str = "";
        mapMarkerBubble.f34029a = (!map.containsKey("text") || map.get("text") == null) ? str : (String) map.get("text");
        mapMarkerBubble.f34030b = (!map.containsKey("icon") || map.get("icon") == null) ? str : (String) map.get("icon");
        mapMarkerBubble.f34031c = (!map.containsKey("icon2") || map.get("icon2") == null) ? str : (String) map.get("icon2");
        if (map.containsKey("color") && map.get("color") != null) {
            str = (String) map.get("color");
        }
        mapMarkerBubble.f34032d = str;
        return mapMarkerBubble;
    }
}
