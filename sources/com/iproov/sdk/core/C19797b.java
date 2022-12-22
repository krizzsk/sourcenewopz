package com.iproov.sdk.core;

import com.iproov.sdk.core.C19798break;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.iproov.sdk.core.b */
/* compiled from: SecurityResultsStore */
class C19797b {

    /* renamed from: a */
    private static final Map<C19898import, Boolean> f54085a = new HashMap();

    /* renamed from: b */
    private static final Map<C19798break.C19799do, Boolean> f54086b = new HashMap();

    /* renamed from: c */
    private static final Map<C19904super, Object> f54087c = new HashMap();

    /* renamed from: a */
    static synchronized void m38873a() {
        synchronized (C19797b.class) {
            f54085a.clear();
            f54086b.clear();
            f54087c.clear();
        }
    }

    /* renamed from: a */
    public static Boolean m38871a(C19898import importR) {
        return f54085a.get(importR);
    }

    /* renamed from: a */
    public static void m38875a(C19898import importR, Boolean bool) {
        f54085a.put(importR, bool);
    }

    /* renamed from: a */
    public static Boolean m38870a(C19798break.C19799do doVar) {
        return f54086b.get(doVar);
    }

    /* renamed from: a */
    public static void m38874a(C19798break.C19799do doVar, Boolean bool) {
        f54086b.put(doVar, bool);
    }

    /* renamed from: a */
    public static Object m38872a(C19904super superR) {
        return f54087c.get(superR);
    }

    /* renamed from: a */
    public static void m38876a(C19904super superR, Object obj) {
        f54087c.put(superR, obj);
    }
}
