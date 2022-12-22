package com.didichuxing.omega.sdk.analysis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterStorage {
    private static Map<String, AtomicInteger> counterMap = new ConcurrentHashMap();

    public static void incrementCounter(String str) {
        addCounter(str, 1);
    }

    public static void addCounter(String str, int i) {
        AtomicInteger atomicInteger = counterMap.get(str);
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            counterMap.put(str, atomicInteger);
        }
        atomicInteger.addAndGet(i);
    }

    public static Map<String, Object> getAllCounterAndClean() {
        HashMap hashMap = new HashMap();
        for (String next : counterMap.keySet()) {
            AtomicInteger atomicInteger = counterMap.get(next);
            hashMap.put(next, Integer.valueOf(atomicInteger != null ? atomicInteger.get() : 0));
        }
        counterMap.clear();
        return hashMap;
    }
}
