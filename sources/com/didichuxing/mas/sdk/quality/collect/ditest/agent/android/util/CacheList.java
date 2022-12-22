package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheList {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static int f48061a = 1000;

    /* renamed from: b */
    private static Map<String, Long> f48062b = new LinkedHashMap<String, Long>() {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<String, Long> entry) {
            return size() > CacheList.f48061a;
        }
    };

    public static boolean hit(String str) {
        boolean containsKey = f48062b.containsKey(str);
        if (!containsKey) {
            f48062b.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return containsKey;
    }
}
