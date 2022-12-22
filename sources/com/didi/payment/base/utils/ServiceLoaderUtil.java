package com.didi.payment.base.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceLoaderUtil {

    /* renamed from: a */
    private Map<Class, Object> f30016a;

    private ServiceLoaderUtil() {
        this.f30016a = new ConcurrentHashMap();
    }

    public static ServiceLoaderUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    private static class SingleHolder {
        /* access modifiers changed from: private */
        public static ServiceLoaderUtil INSTANCE = new ServiceLoaderUtil();

        private SingleHolder() {
        }
    }

    public <T> T load(Class<T> cls) {
        return load(cls, (String) null);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T load(java.lang.Class<T> r2, java.lang.String r3) {
        /*
            r1 = this;
            java.util.Map<java.lang.Class, java.lang.Object> r0 = r1.f30016a
            java.lang.Object r0 = r0.get(r2)
            if (r0 == 0) goto L_0x0009
            goto L_0x0022
        L_0x0009:
            com.didichuxing.foundation.spi.ServiceLoader r3 = com.didichuxing.foundation.spi.ServiceLoader.load(r2, r3)
            java.util.Iterator r3 = r3.iterator()
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0021
            java.lang.Object r0 = r3.next()
            java.util.Map<java.lang.Class, java.lang.Object> r3 = r1.f30016a
            r3.put(r2, r0)
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.utils.ServiceLoaderUtil.load(java.lang.Class, java.lang.String):java.lang.Object");
    }
}
