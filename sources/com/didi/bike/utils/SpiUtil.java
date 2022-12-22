package com.didi.bike.utils;

import android.text.TextUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.ServiceRegistry;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class SpiUtil {
    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T load(java.lang.Class<T> r0) {
        /*
            com.didichuxing.foundation.spi.ServiceLoader r0 = com.didichuxing.foundation.spi.ServiceLoader.load(r0)
            java.lang.Object r0 = r0.get()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.bike.utils.SpiUtil.load(java.lang.Class):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T load(java.lang.Class<T> r3, java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x000b
            java.lang.Object r3 = load(r3)
            return r3
        L_0x000b:
            com.didichuxing.foundation.spi.ServiceLoader r3 = com.didichuxing.foundation.spi.ServiceLoader.load(r3)
            java.util.Iterator r3 = r3.iterator()
        L_0x0013:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0037
            java.lang.Object r0 = r3.next()
            java.lang.Class r1 = r0.getClass()
            java.lang.Class<com.didichuxing.foundation.spi.annotation.ServiceProvider> r2 = com.didichuxing.foundation.spi.annotation.ServiceProvider.class
            java.lang.annotation.Annotation r1 = r1.getAnnotation(r2)
            com.didichuxing.foundation.spi.annotation.ServiceProvider r1 = (com.didichuxing.foundation.spi.annotation.ServiceProvider) r1
            if (r1 != 0) goto L_0x002c
            goto L_0x0013
        L_0x002c:
            java.lang.String r1 = r1.alias()
            boolean r1 = android.text.TextUtils.equals(r4, r1)
            if (r1 == 0) goto L_0x0013
            return r0
        L_0x0037:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.bike.utils.SpiUtil.load(java.lang.Class, java.lang.String):java.lang.Object");
    }

    public static <T> Iterable<T> loadList(Class<T> cls, String str) {
        ServiceLoader<S> load = ServiceLoader.load(cls);
        ArrayList arrayList = new ArrayList();
        Iterator<S> it = load.iterator();
        while (it.hasNext()) {
            S next = it.next();
            ServiceProvider serviceProvider = (ServiceProvider) next.getClass().getAnnotation(ServiceProvider.class);
            if (serviceProvider != null && TextUtils.equals(str, serviceProvider.alias())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <T> Iterable<T> loadList(Class<T> cls) {
        ServiceLoader<S> load = ServiceLoader.load(cls);
        ArrayList arrayList = new ArrayList();
        Iterator<S> it = load.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <S> Set<Class<? extends S>> loadAllType(Class<S> cls) {
        return ServiceRegistry.get(cls);
    }

    public static <S> Class<? extends S> loadFirstType(Class<S> cls, String str) {
        for (Class<? extends S> next : ServiceRegistry.get(cls)) {
            ServiceProvider serviceProvider = (ServiceProvider) next.getAnnotation(ServiceProvider.class);
            if (serviceProvider != null && TextUtils.equals(str, serviceProvider.alias())) {
                return next;
            }
        }
        return null;
    }

    public static <S> Iterable<Class<? extends S>> loadAllTypes(Class<S> cls, String str) {
        Set<Class<? extends S>> set = ServiceRegistry.get(cls);
        ArrayList arrayList = new ArrayList();
        for (Class next : set) {
            ServiceProvider serviceProvider = (ServiceProvider) next.getAnnotation(ServiceProvider.class);
            if (serviceProvider != null) {
                if (TextUtils.isEmpty(str)) {
                    arrayList.add(next);
                } else if (TextUtils.equals(str, serviceProvider.alias())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }
}
