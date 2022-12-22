package com.didi.rlab.uni_foundation.passport;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class LevelInfo extends UniModel {

    /* renamed from: a */
    private String f34092a;

    /* renamed from: b */
    private String f34093b;

    public String getLevel() {
        return this.f34092a;
    }

    public void setLevel(String str) {
        this.f34092a = str;
    }

    public String getTitle() {
        return this.f34093b;
    }

    public void setTitle(String str) {
        this.f34093b = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("level", this.f34092a);
        hashMap.put("title", this.f34093b);
        return hashMap;
    }

    public static LevelInfo fromMap(Map<String, Object> map) {
        LevelInfo levelInfo = new LevelInfo();
        String str = "";
        levelInfo.f34092a = (!map.containsKey("level") || map.get("level") == null) ? str : (String) map.get("level");
        if (map.containsKey("title") && map.get("title") != null) {
            str = (String) map.get("title");
        }
        levelInfo.f34093b = str;
        return levelInfo;
    }
}
