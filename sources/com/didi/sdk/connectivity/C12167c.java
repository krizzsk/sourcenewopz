package com.didi.sdk.connectivity;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.Map;

/* renamed from: com.didi.sdk.connectivity.c */
/* compiled from: Logger */
class C12167c {

    /* renamed from: a */
    private static Logger f35762a = LoggerFactory.getLogger(f35763b);

    /* renamed from: b */
    private static final String f35763b = "didi-connectivity";

    C12167c() {
    }

    /* renamed from: a */
    private static void m25332a(Map<?, ?> map) {
        f35762a.infoEvent(f35763b, map);
    }

    /* renamed from: a */
    static void m25331a(String str) {
        m25333a("log", str);
    }

    /* renamed from: a */
    private static void m25333a(Object... objArr) {
        f35762a.infoEvent(f35763b, objArr);
    }
}
