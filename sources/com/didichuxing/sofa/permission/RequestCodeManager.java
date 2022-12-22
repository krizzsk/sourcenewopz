package com.didichuxing.sofa.permission;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class RequestCodeManager {

    /* renamed from: a */
    private static AtomicInteger f49149a = new AtomicInteger(0);

    /* renamed from: b */
    private static Map<String[], Integer> f49150b = new HashMap();

    /* renamed from: a */
    private static boolean m35426a(int i) {
        return i <= 0;
    }

    private RequestCodeManager() {
    }

    /* renamed from: a */
    private static int m35425a() {
        if (f49149a.get() >= 20) {
            f49149a.set(0);
        }
        return f49149a.incrementAndGet();
    }

    public static int get(String... strArr) {
        int intValue = f49150b.containsKey(strArr) ? f49150b.get(strArr).intValue() : 0;
        if (!m35426a(intValue)) {
            return intValue;
        }
        int a = m35425a();
        f49150b.put(strArr, Integer.valueOf(a));
        return a;
    }
}
