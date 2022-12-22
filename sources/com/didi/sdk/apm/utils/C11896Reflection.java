package com.didi.sdk.apm.utils;

import android.os.Build;
import java.lang.reflect.Method;

/* renamed from: com.didi.sdk.apm.utils.Reflection */
public class C11896Reflection {

    /* renamed from: a */
    private static final String f35062a = "Reflection";

    /* renamed from: b */
    private static final int f35063b = -1;

    /* renamed from: c */
    private static Object f35064c;

    /* renamed from: d */
    private static Method f35065d;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0063 }
            r1 = 28
            if (r0 < r1) goto L_0x006b
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            java.lang.String r1 = "forName"
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x0063 }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r5 = 0
            r3[r5] = r4     // Catch:{ all -> 0x0063 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r3)     // Catch:{ all -> 0x0063 }
            java.lang.Class<java.lang.Class> r1 = java.lang.Class.class
            java.lang.String r3 = "getDeclaredMethod"
            r4 = 2
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ all -> 0x0063 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r5] = r7     // Catch:{ all -> 0x0063 }
            java.lang.Class<java.lang.Class[]> r7 = java.lang.Class[].class
            r6[r2] = r7     // Catch:{ all -> 0x0063 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r6)     // Catch:{ all -> 0x0063 }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0063 }
            java.lang.String r6 = "dalvik.system.VMRuntime"
            r3[r5] = r6     // Catch:{ all -> 0x0063 }
            r6 = 0
            java.lang.Object r0 = r0.invoke(r6, r3)     // Catch:{ all -> 0x0063 }
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x0063 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = "getRuntime"
            r3[r5] = r7     // Catch:{ all -> 0x0063 }
            r3[r2] = r6     // Catch:{ all -> 0x0063 }
            java.lang.Object r3 = r1.invoke(r0, r3)     // Catch:{ all -> 0x0063 }
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3     // Catch:{ all -> 0x0063 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = "setHiddenApiExemptions"
            r4[r5] = r7     // Catch:{ all -> 0x0063 }
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ all -> 0x0063 }
            java.lang.Class<java.lang.String[]> r8 = java.lang.String[].class
            r7[r5] = r8     // Catch:{ all -> 0x0063 }
            r4[r2] = r7     // Catch:{ all -> 0x0063 }
            java.lang.Object r0 = r1.invoke(r0, r4)     // Catch:{ all -> 0x0063 }
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch:{ all -> 0x0063 }
            f35065d = r0     // Catch:{ all -> 0x0063 }
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ all -> 0x0063 }
            java.lang.Object r0 = r3.invoke(r6, r0)     // Catch:{ all -> 0x0063 }
            f35064c = r0     // Catch:{ all -> 0x0063 }
            goto L_0x006b
        L_0x0063:
            r0 = move-exception
            java.lang.String r1 = "Reflection"
            java.lang.String r2 = "reflect bootstrap failed:"
            android.util.Log.i(r1, r2, r0)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.apm.utils.C11896Reflection.<clinit>():void");
    }

    public static int unseal() {
        if (Build.VERSION.SDK_INT >= 28 && !exemptAll()) {
            return -1;
        }
        return 0;
    }

    public static boolean exempt(String str) {
        return exempt(str);
    }

    public static boolean exempt(String... strArr) {
        Method method;
        Object obj = f35064c;
        if (!(obj == null || (method = f35065d) == null)) {
            try {
                method.invoke(obj, new Object[]{strArr});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean exemptAll() {
        return exempt("L");
    }
}
