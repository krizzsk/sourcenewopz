package org.xidea.p087el.impl;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* renamed from: org.xidea.el.impl.DefaultConvertor */
/* compiled from: Convertor */
class DefaultConvertor implements Convertor<Object> {
    private static Log log = LogFactory.getLog(DefaultConvertor.class);

    DefaultConvertor() {
    }

    static Map<Class<?>, Convertor<?>> toMap() {
        Class[] clsArr = {File.class, URL.class, URI.class, Long.TYPE, Long.class, Integer.TYPE, Integer.class, Double.TYPE, Double.class, Short.TYPE, Short.class, Byte.TYPE, Byte.class, Boolean.TYPE, Boolean.class, Character.TYPE, Character.class, String.class, Object.class};
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 19; i++) {
            hashMap.put(clsArr[i], Convertor.DEFAULT);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:72|73|(2:75|76)|77) */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r6 = java.lang.Class.forName(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00fa, code lost:
        if (r7.isAssignableFrom(r6) != false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0100, code lost:
        return r6.newInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0101, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x00f2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getValue(java.lang.String r6, java.lang.Class<? extends java.lang.Object> r7, java.lang.Object r8, java.lang.String r9) {
        /*
            r5 = this;
            boolean r8 = r7.isPrimitive()
            r9 = 0
            if (r6 != 0) goto L_0x000d
            if (r8 == 0) goto L_0x000c
            java.lang.String r6 = ""
            goto L_0x000d
        L_0x000c:
            return r9
        L_0x000d:
            java.lang.Class r0 = org.xidea.p087el.impl.ReflectUtil.toWrapper(r7)
            java.lang.Class<java.lang.Number> r1 = java.lang.Number.class
            boolean r1 = r1.isAssignableFrom(r0)
            java.lang.String r2 = "0"
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0069
            int r1 = r6.length()
            if (r1 != 0) goto L_0x0028
            if (r8 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0028
        L_0x0027:
            return r9
        L_0x0028:
            java.lang.Class<java.lang.Long> r8 = java.lang.Long.class
            if (r0 != r8) goto L_0x0035
            long r6 = java.lang.Long.parseLong(r6)
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            return r6
        L_0x0035:
            java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.class
            if (r0 != r8) goto L_0x0042
            int r6 = java.lang.Integer.parseInt(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            return r6
        L_0x0042:
            java.lang.Class<java.lang.Byte> r8 = java.lang.Byte.class
            if (r0 != r8) goto L_0x004f
            byte r6 = java.lang.Byte.parseByte(r6)
            java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
            return r6
        L_0x004f:
            java.lang.Class<java.lang.Double> r8 = java.lang.Double.class
            if (r0 != r8) goto L_0x005c
            double r6 = java.lang.Double.parseDouble(r6)
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
            return r6
        L_0x005c:
            java.lang.Class<java.lang.Short> r8 = java.lang.Short.class
            if (r0 != r8) goto L_0x00d8
            short r6 = java.lang.Short.parseShort(r6)
            java.lang.Short r6 = java.lang.Short.valueOf(r6)
            return r6
        L_0x0069:
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            if (r1 != r0) goto L_0x00bb
            java.lang.String r6 = r6.toLowerCase()
            java.lang.String r7 = "false"
            boolean r0 = r7.equals(r6)
            if (r0 == 0) goto L_0x007e
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            return r6
        L_0x007e:
            java.lang.String r0 = "true"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x008b
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r3)
            return r6
        L_0x008b:
            if (r8 != 0) goto L_0x0094
            int r8 = r6.length()
            if (r8 != 0) goto L_0x0094
            return r9
        L_0x0094:
            org.apache.commons.logging.Log r8 = log
            java.lang.String r9 = "非标准的boolean字面量！！"
            r8.info(r9)
            int r8 = r6.length()
            if (r8 == 0) goto L_0x00b5
            boolean r8 = r2.equals(r6)
            if (r8 != 0) goto L_0x00b5
            java.lang.String r8 = "0.0"
            boolean r8 = r8.equals(r6)
            if (r8 != 0) goto L_0x00b5
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x00b6
        L_0x00b5:
            r3 = 0
        L_0x00b6:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r3)
            return r6
        L_0x00bb:
            java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
            if (r1 != r0) goto L_0x00d8
            int r7 = r6.length()
            if (r7 != 0) goto L_0x00cb
            if (r8 == 0) goto L_0x00ca
            java.lang.String r6 = "\u0000"
            goto L_0x00cb
        L_0x00ca:
            return r9
        L_0x00cb:
            java.lang.String r6 = r6.toLowerCase()
            char r6 = r6.charAt(r4)
            java.lang.Character r6 = java.lang.Character.valueOf(r6)
            return r6
        L_0x00d8:
            boolean r8 = r7.isInstance(r6)
            if (r8 == 0) goto L_0x00df
            return r6
        L_0x00df:
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x00f2 }
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r8[r4] = r0     // Catch:{ NoSuchMethodException -> 0x00f2 }
            java.lang.reflect.Constructor r8 = r7.getConstructor(r8)     // Catch:{ NoSuchMethodException -> 0x00f2 }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x00f2 }
            r0[r4] = r6     // Catch:{ NoSuchMethodException -> 0x00f2 }
            java.lang.Object r6 = r8.newInstance(r0)     // Catch:{ NoSuchMethodException -> 0x00f2 }
            return r6
        L_0x00f2:
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x0101 }
            boolean r7 = r7.isAssignableFrom(r6)     // Catch:{ Exception -> 0x0101 }
            if (r7 == 0) goto L_0x0101
            java.lang.Object r6 = r6.newInstance()     // Catch:{ Exception -> 0x0101 }
            return r6
        L_0x0101:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xidea.p087el.impl.DefaultConvertor.getValue(java.lang.String, java.lang.Class, java.lang.Object, java.lang.String):java.lang.Object");
    }
}
