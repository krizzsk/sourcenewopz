package com.didichuxing.sofa.permission;

import com.didichuxing.sofa.permission.PermissionResultCallback;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didichuxing.sofa.permission.d */
/* compiled from: PermHelperRegistry */
class C16481d {

    /* renamed from: a */
    private static final Map<String, Class<? extends C16480c>> f49151a = new HashMap();

    /* renamed from: b */
    private static final Map<String, C16480c> f49152b = new HashMap();

    C16481d() {
    }

    /* renamed from: a */
    static synchronized void m35437a(String str, Class<? extends C16480c> cls) {
        synchronized (C16481d.class) {
            f49151a.put(str, cls);
        }
    }

    /* renamed from: a */
    static synchronized C16480c m35436a(String str) {
        synchronized (C16481d.class) {
            C16480c cVar = f49152b.get(str);
            if (cVar == null) {
                Class cls = f49151a.get(str);
                if (cls == null) {
                    return null;
                }
                try {
                    C16480c cVar2 = (C16480c) cls.newInstance();
                    try {
                        f49152b.put(str, cVar2);
                        cVar = cVar2;
                    } catch (Exception e) {
                        e = e;
                        cVar = cVar2;
                        e.printStackTrace();
                        return cVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return cVar;
                }
            }
        }
    }

    /* renamed from: a */
    static synchronized C16480c m35435a() {
        C16480c cVar;
        synchronized (C16481d.class) {
            String canonicalName = PermissionResultCallback.class.getCanonicalName();
            cVar = f49152b.get(canonicalName);
            if (cVar == null) {
                cVar = new PermissionResultCallback.PermissionHelper();
                f49152b.put(canonicalName, cVar);
            }
        }
        return cVar;
    }
}
