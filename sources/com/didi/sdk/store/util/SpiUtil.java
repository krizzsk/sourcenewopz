package com.didi.sdk.store.util;

public class SpiUtil {
    /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|(2:13|(1:15))|16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0035 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object makeInstance(java.lang.ClassLoader r3, java.lang.String r4, java.lang.Class r5) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0008
            java.lang.Class r3 = java.lang.Class.forName(r4)     // Catch:{  }
            goto L_0x000c
        L_0x0008:
            java.lang.Class r3 = r3.loadClass(r4)     // Catch:{  }
        L_0x000c:
            if (r5 == 0) goto L_0x0015
            boolean r4 = r5.isAssignableFrom(r3)     // Catch:{  }
            if (r4 != 0) goto L_0x0015
            return r0
        L_0x0015:
            r4 = 1
            r5 = 0
            java.lang.String r1 = "getInstance"
            java.lang.Class[] r2 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0035 }
            java.lang.reflect.Method r1 = r3.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x0035 }
            int r2 = r1.getModifiers()     // Catch:{ Exception -> 0x0035 }
            boolean r2 = java.lang.reflect.Modifier.isStatic(r2)     // Catch:{ Exception -> 0x0035 }
            if (r2 == 0) goto L_0x0035
            r1.setAccessible(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0035 }
            java.lang.Object r1 = r1.invoke(r0, r2)     // Catch:{ Exception -> 0x0035 }
            if (r1 == 0) goto L_0x0035
            return r1
        L_0x0035:
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x0045 }
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r1)     // Catch:{ ClassNotFoundException -> 0x0045 }
            r3.setAccessible(r4)     // Catch:{ ClassNotFoundException -> 0x0045 }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException -> 0x0045 }
            java.lang.Object r3 = r3.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x0045 }
            return r3
        L_0x0045:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.store.util.SpiUtil.makeInstance(java.lang.ClassLoader, java.lang.String, java.lang.Class):java.lang.Object");
    }
}
