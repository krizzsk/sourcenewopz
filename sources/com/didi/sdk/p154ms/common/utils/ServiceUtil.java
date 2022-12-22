package com.didi.sdk.p154ms.common.utils;

import com.didi.sdk.p154ms.common.type.IMSType;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;

/* renamed from: com.didi.sdk.ms.common.utils.ServiceUtil */
public class ServiceUtil {
    private static final String TAG = ServiceUtil.class.getSimpleName();

    public static <T> int getServiceImpCount(Class<T> cls) {
        Iterator<S> it = ServiceLoader.load(cls).iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next() != null) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Class, java.lang.Object, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T getServiceImp(java.lang.Class<T> r4, java.lang.String r5) {
        /*
            com.didichuxing.foundation.spi.ServiceLoader r0 = com.didichuxing.foundation.spi.ServiceLoader.load(r4, r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0015
            java.lang.Object r1 = r0.next()
            if (r1 != 0) goto L_0x0016
            goto L_0x0008
        L_0x0015:
            r1 = 0
        L_0x0016:
            java.lang.String r0 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getServiceImp : clz = "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r4 = ", alias = "
            r2.append(r4)
            r2.append(r5)
            java.lang.String r4 = ", result = "
            r2.append(r4)
            r2.append(r1)
            java.lang.String r4 = r2.toString()
            com.didi.sdk.p154ms.common.utils.LogUtil.m26099i(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.p154ms.common.utils.ServiceUtil.getServiceImp(java.lang.Class, java.lang.String):java.lang.Object");
    }

    public static <T> T getServiceImp(Class<T> cls) {
        T serviceImp = getServiceImp(cls, IMSType.GMS);
        if (serviceImp != null) {
            String str = TAG;
            LogUtil.m26099i(str, "getServiceImp : gms variant is load, clz = " + cls + ", gmsT = " + serviceImp);
            return serviceImp;
        }
        T serviceImp2 = getServiceImp(cls, IMSType.HMS);
        if (serviceImp2 != null) {
            String str2 = TAG;
            LogUtil.m26099i(str2, "getServiceImp : hms variant is load, clz = " + cls + ", hmsT = " + serviceImp2);
            return serviceImp2;
        }
        String str3 = TAG;
        LogUtil.m26099i(str3, "getServiceImp : no variant is load, clz = " + cls);
        return null;
    }
}
