package com.didichuxing.xpanel.models;

import java.util.HashMap;

public class XPanelModelRegister {
    public static HashMap<String, Class<? extends AbsXPanelModelAssemble>> sMap = new HashMap<>();
    public static HashMap<String, Integer> sModelIdMap = new HashMap<>();

    public static void registerXPanelModel(String str, Class<? extends AbsXPanelModelAssemble> cls) {
        sMap.put(str, cls);
    }

    public static Class<? extends AbsXPanelModelAssemble> getXPanelModel(String str) {
        return sMap.get(str);
    }

    public static void registerXPanelModelID(String str, Integer num) {
        sModelIdMap.put(str, num);
    }

    public static int getModelID(String str) {
        Integer num = sModelIdMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
