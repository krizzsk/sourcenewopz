package com.didichuxing.ditest.agent.android.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheList {
    /* access modifiers changed from: private */
    public static int MAX_CACHE_SIZE = 1000;
    private static Map<String, Long> cacheMap = new LinkedHashMap<String, Long>() {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<String, Long> entry) {
            return size() > CacheList.MAX_CACHE_SIZE;
        }
    };

    public static boolean hit(String str) {
        boolean containsKey = cacheMap.containsKey(str);
        if (!containsKey) {
            cacheMap.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return containsKey;
    }
}
