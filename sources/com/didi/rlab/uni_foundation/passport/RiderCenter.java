package com.didi.rlab.uni_foundation.passport;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class RiderCenter extends UniModel {

    /* renamed from: a */
    private String f34103a;

    /* renamed from: b */
    private String f34104b;

    /* renamed from: c */
    private String f34105c;

    public String getColor() {
        return this.f34103a;
    }

    public void setColor(String str) {
        this.f34103a = str;
    }

    public String getUrl() {
        return this.f34104b;
    }

    public void setUrl(String str) {
        this.f34104b = str;
    }

    public String getText() {
        return this.f34105c;
    }

    public void setText(String str) {
        this.f34105c = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("color", this.f34103a);
        hashMap.put("url", this.f34104b);
        hashMap.put("text", this.f34105c);
        return hashMap;
    }

    public static RiderCenter fromMap(Map<String, Object> map) {
        RiderCenter riderCenter = new RiderCenter();
        String str = "";
        riderCenter.f34103a = (!map.containsKey("color") || map.get("color") == null) ? str : (String) map.get("color");
        riderCenter.f34104b = (!map.containsKey("url") || map.get("url") == null) ? str : (String) map.get("url");
        if (map.containsKey("text") && map.get("text") != null) {
            str = (String) map.get("text");
        }
        riderCenter.f34105c = str;
        return riderCenter;
    }
}
