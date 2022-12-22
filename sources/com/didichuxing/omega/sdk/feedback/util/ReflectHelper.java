package com.didichuxing.omega.sdk.feedback.util;

import java.lang.reflect.Constructor;

public class ReflectHelper {
    public static Object invokeConstructor(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r6 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object invokeMethodStrictly(java.lang.Object r5, java.lang.String r6, java.lang.Class[] r7, java.lang.Object[] r8) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0038
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L_0x000a
            goto L_0x0038
        L_0x000a:
            r1 = 0
            java.lang.Class r2 = r5.getClass()
        L_0x000f:
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            if (r2 == r3) goto L_0x0028
            int r3 = r1 + 1
            r4 = 3
            if (r1 <= r4) goto L_0x0019
            goto L_0x0028
        L_0x0019:
            java.lang.reflect.Method r6 = r2.getDeclaredMethod(r6, r7)     // Catch:{ Exception -> 0x001e }
            goto L_0x0029
        L_0x001e:
            r1 = move-exception
            r1.printStackTrace()
            java.lang.Class r2 = r2.getSuperclass()
            r1 = r3
            goto L_0x000f
        L_0x0028:
            r6 = r0
        L_0x0029:
            if (r6 == 0) goto L_0x0038
            r7 = 1
            r6.setAccessible(r7)     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r0 = r6.invoke(r5, r8)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0038:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.util.ReflectHelper.invokeMethodStrictly(java.lang.Object, java.lang.String, java.lang.Class[], java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object invokeStaticMethod(java.lang.Class<?> r1, java.lang.String r2, java.lang.Class[] r3, java.lang.Object[] r4) {
        /*
            r0 = 0
            if (r1 == 0) goto L_0x000c
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch:{ NoSuchMethodException -> 0x0008 }
            goto L_0x000d
        L_0x0008:
            r1 = move-exception
            r1.printStackTrace()
        L_0x000c:
            r1 = r0
        L_0x000d:
            if (r1 == 0) goto L_0x001c
            r2 = 1
            r1.setAccessible(r2)
            java.lang.Object r0 = r1.invoke(r0, r4)     // Catch:{ Exception -> 0x0018 }
            goto L_0x001c
        L_0x0018:
            r1 = move-exception
            r1.printStackTrace()
        L_0x001c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.util.ReflectHelper.invokeStaticMethod(java.lang.Class, java.lang.String, java.lang.Class[], java.lang.Object[]):java.lang.Object");
    }
}
