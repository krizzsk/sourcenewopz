package com.example.uploadrule.utils;

import java.util.HashMap;
import java.util.Map;

public class ApolloCache {
    private static Map<String, Map<String, Object>> sApolloCacheMap = new HashMap();

    public static <T> T getValueFromCache(String str, String str2) {
        T t;
        Map map = sApolloCacheMap.get(str);
        if (map == null || (t = map.get(str2)) == null) {
            return null;
        }
        return t;
    }

    public static <T> void putValueToCache(String str, String str2, T t) {
        Map map = sApolloCacheMap.get(str);
        if (map == null) {
            map = new HashMap();
            sApolloCacheMap.put(str, map);
        }
        if (map != null) {
            map.put(str2, t);
        }
    }
}
