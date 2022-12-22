package com.dmap.navigation.engine.p207a;

import com.didi.hawaii.utils.Md5Util;
import com.dmap.navigation.jni.swig.CharArray;
import com.dmap.navigation.jni.swig.SWIGTYPE_p_unsigned_char;

/* renamed from: com.dmap.navigation.engine.a.m */
/* compiled from: DataUtil */
public final class C17400m {
    /* renamed from: a */
    public static byte[] m37040a(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, int i) {
        byte[] bArr = new byte[i];
        CharArray frompointer = CharArray.frompointer(sWIGTYPE_p_unsigned_char);
        if (frompointer != null) {
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) frompointer.getitem(i2);
            }
        }
        return bArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m37039a(java.lang.String r5) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.util.Random r1 = new java.util.Random
            r1.<init>()
            int r1 = r1.nextInt()
            int r1 = java.lang.Math.abs(r1)
            if (r1 >= 0) goto L_0x0018
            r1 = 1
        L_0x0018:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r0)
            r2.append(r1)
            java.lang.String r5 = r2.toString()
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r1 = "UTF-8"
            byte[] r5 = r5.getBytes(r1)     // Catch:{ Exception -> 0x0069 }
            byte[] r5 = r0.digest(r5)     // Catch:{ Exception -> 0x0069 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0069 }
            r0.<init>()     // Catch:{ Exception -> 0x0069 }
            int r1 = r5.length     // Catch:{ Exception -> 0x0069 }
            r2 = 0
        L_0x0041:
            if (r2 >= r1) goto L_0x005c
            byte r3 = r5[r2]     // Catch:{ Exception -> 0x0069 }
            if (r3 >= 0) goto L_0x0049
            int r3 = r3 + 256
        L_0x0049:
            r4 = 16
            if (r3 >= r4) goto L_0x0052
            java.lang.String r4 = "0"
            r0.append(r4)     // Catch:{ Exception -> 0x0069 }
        L_0x0052:
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ Exception -> 0x0069 }
            r0.append(r3)     // Catch:{ Exception -> 0x0069 }
            int r2 = r2 + 1
            goto L_0x0041
        L_0x005c:
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r5 = r5.toUpperCase()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r5 = r5.toUpperCase()     // Catch:{ Exception -> 0x0069 }
            return r5
        L_0x0069:
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dmap.navigation.engine.p207a.C17400m.m37039a(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static String m37041b(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append(str);
        String l = Long.toString(System.currentTimeMillis());
        int length = l.length();
        sb.append(l.substring(length - 6, length));
        sb.append((int) (((Math.random() * 9.0d) + 1.0d) * 100000.0d));
        return Md5Util.getMD5(sb.toString()).toUpperCase();
    }
}
