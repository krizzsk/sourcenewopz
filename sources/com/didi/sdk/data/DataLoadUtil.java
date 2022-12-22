package com.didi.sdk.data;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class DataLoadUtil {

    /* renamed from: a */
    private static Logger f35773a = LoggerFactory.getLogger("NLogger");

    public static <T> T loadGenerator(Class<T> cls) {
        return loadGenerator(cls, "nimble");
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [java.lang.Class, java.lang.Object, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T loadGenerator(java.lang.Class<T> r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "nimble"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0028
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "other alias: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r4 = r0.toString()
            java.lang.Throwable r5 = new java.lang.Throwable
            r5.<init>()
            r2 = 3
            r7 = 33
            java.lang.String r3 = "NLogger"
            java.lang.String r6 = "com.didi.sdk.data.DataLoadUtil"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x0028:
            com.didi.drouter.service.ServiceLoader r0 = com.didi.drouter.api.DRouter.build(r8)
            com.didi.drouter.service.ServiceLoader r0 = r0.setFilter(r9)
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.Object r0 = r0.getService(r2)
            if (r0 == 0) goto L_0x003a
            return r0
        L_0x003a:
            com.didichuxing.foundation.spi.ServiceLoader r0 = com.didichuxing.foundation.spi.ServiceLoader.load(r8, r9)
            java.util.Iterator r0 = r0.iterator()
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004d
            java.lang.Object r8 = r0.next()
            return r8
        L_0x004d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r9)
            java.lang.String r2 = "AppFrameEnd"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.didichuxing.foundation.spi.ServiceLoader r0 = com.didichuxing.foundation.spi.ServiceLoader.load(r8, r0)
            java.util.Iterator r0 = r0.iterator()
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0071
            java.lang.Object r8 = r0.next()
            return r8
        L_0x0071:
            com.didichuxing.foundation.spi.ServiceLoader r0 = com.didichuxing.foundation.spi.ServiceLoader.load(r8)
            java.util.Iterator r0 = r0.iterator()
            boolean r2 = r0.hasNext()
            java.lang.String r3 = " by alias "
            java.lang.String r4 = "not found "
            if (r2 == 0) goto L_0x00ac
            java.lang.Object r0 = r0.next()
            com.didi.sdk.logging.Logger r2 = f35773a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r8)
            r5.append(r3)
            r5.append(r9)
            java.lang.String r8 = " ,load others = "
            r5.append(r8)
            r5.append(r0)
            java.lang.String r8 = r5.toString()
            java.lang.Object[] r9 = new java.lang.Object[r1]
            r2.warn((java.lang.String) r8, (java.lang.Object[]) r9)
            return r0
        L_0x00ac:
            com.didi.sdk.logging.Logger r0 = f35773a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r8)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r8 = r2.toString()
            java.lang.Object[] r9 = new java.lang.Object[r1]
            r0.error((java.lang.String) r8, (java.lang.Object[]) r9)
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.data.DataLoadUtil.loadGenerator(java.lang.Class, java.lang.String):java.lang.Object");
    }
}
