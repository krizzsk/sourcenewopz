package com.didi.dimina.starbox.module.jsbridge.performance.perfs;

/* renamed from: com.didi.dimina.starbox.module.jsbridge.performance.perfs.a */
/* compiled from: ShellTopCommand */
class C7745a {
    C7745a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC, Splitter:B:42:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0089 A[SYNTHETIC, Splitter:B:50:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String m13513a(java.lang.String r7) {
        /*
            r0 = 0
            int r1 = android.os.Process.myPid()     // Catch:{ IOException -> 0x006f, all -> 0x006c }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x006f, all -> 0x006c }
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x006f, all -> 0x006c }
            java.lang.String r3 = "top -n 1"
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ IOException -> 0x006f, all -> 0x006c }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x006a }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x006a }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ IOException -> 0x006a }
            r4.<init>(r5)     // Catch:{ IOException -> 0x006a }
            r3.<init>(r4)     // Catch:{ IOException -> 0x006a }
            r0 = -1
            r4 = -1
        L_0x0024:
            java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            if (r5 == 0) goto L_0x0059
            java.lang.String r5 = r5.trim()     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            if (r6 == 0) goto L_0x0035
            goto L_0x0024
        L_0x0035:
            int r6 = m13512a(r5, r7)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            if (r4 != r0) goto L_0x003d
            r4 = r6
            goto L_0x0024
        L_0x003d:
            boolean r6 = r5.startsWith(r1)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            if (r6 == 0) goto L_0x0024
            java.lang.String r7 = "\\s+"
            java.lang.String[] r7 = r5.split(r7)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            r7 = r7[r4]     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            r3.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0053:
            if (r2 == 0) goto L_0x0058
            r2.destroy()
        L_0x0058:
            return r7
        L_0x0059:
            r3.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0061:
            if (r2 == 0) goto L_0x0083
            goto L_0x0080
        L_0x0064:
            r7 = move-exception
            r0 = r3
            goto L_0x0087
        L_0x0067:
            r7 = move-exception
            r0 = r3
            goto L_0x0071
        L_0x006a:
            r7 = move-exception
            goto L_0x0071
        L_0x006c:
            r7 = move-exception
            r2 = r0
            goto L_0x0087
        L_0x006f:
            r7 = move-exception
            r2 = r0
        L_0x0071:
            r7.printStackTrace()     // Catch:{ all -> 0x0086 }
            if (r0 == 0) goto L_0x007e
            r0.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r7 = move-exception
            r7.printStackTrace()
        L_0x007e:
            if (r2 == 0) goto L_0x0083
        L_0x0080:
            r2.destroy()
        L_0x0083:
            java.lang.String r7 = "0"
            return r7
        L_0x0086:
            r7 = move-exception
        L_0x0087:
            if (r0 == 0) goto L_0x0091
            r0.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0091:
            if (r2 == 0) goto L_0x0096
            r2.destroy()
        L_0x0096:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.starbox.module.jsbridge.performance.perfs.C7745a.m13513a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static int m13512a(String str, String str2) {
        if (!str.contains(str2)) {
            return -1;
        }
        int i = (!"CPU".equals(str2) || !str.contains("S[%")) ? 0 : 1;
        String[] split = str.split("\\s+");
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].contains(str2)) {
                return str.trim().startsWith("[7m") ? (i2 - 1) + i : i2 + i;
            }
        }
        return -1;
    }
}
