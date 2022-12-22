package com.didi.global.globalgenerickit.config;

import java.util.HashMap;
import java.util.Map;

public class GGKConfigProcessor {
    public static final String ALERT = "passenger_newPopup";
    public static final String SHEET = "passenger_newSheet";

    /* renamed from: a */
    private static Map<String, IConfig> f22054a;

    static {
        HashMap hashMap = new HashMap();
        f22054a = hashMap;
        hashMap.put("passenger_newPopup", new AlertConfig());
        f22054a.put("passenger_newSheet", new SheetConfig());
    }

    public static Map<String, IConfig> getMaps() {
        return f22054a;
    }
}
