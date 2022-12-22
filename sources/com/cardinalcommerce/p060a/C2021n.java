package com.cardinalcommerce.p060a;

import android.content.Context;

/* renamed from: com.cardinalcommerce.a.n */
class C2021n {

    /* renamed from: c */
    private static int f2614c = 0;

    /* renamed from: d */
    private static int f2615d = 1;

    /* renamed from: a */
    private final String f2616a = C2021n.class.getSimpleName();

    /* renamed from: b */
    private Context f2617b = setShadowLayer.cca_continue;

    C2021n() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0 = r7.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
        r7 = f2614c;
        r8 = ((r7 | 118) << 1) - (r7 ^ 118);
        r7 = (r8 ^ -1) + ((r8 & -1) << 1);
        f2615d = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008d, code lost:
        r6 = f2615d;
        r7 = ((r6 & 50) + (r6 | 50)) - 1;
        f2614c = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r7.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a0, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012f, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0133, code lost:
        r5 = (f2614c + 68) - 1;
        f2615d = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x013f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r6.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0143, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0146, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0147, code lost:
        if (r4 != null) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x014b, code lost:
        if (74 != 74) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0150, code lost:
        r4 = f2614c;
        r7 = r4 & 59;
        r5 = ((r4 ^ 59) | r7) << 1;
        r4 = -((r4 | 59) & (~r7));
        r7 = ((r5 | r4) << 1) - (r4 ^ r5);
        f2615d = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0169, code lost:
        r7 = f2615d;
        r8 = r7 & 87;
        r7 = (r7 | 87) & (~r8);
        r8 = -(-(r8 << 1));
        r9 = (r7 ^ r8) + ((r7 & r8) << 1);
        f2614c = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0182, code lost:
        r4 = f2615d;
        r5 = (r4 & 31) + (r4 | 31);
        f2614c = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0194, code lost:
        throw r6;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo18284a() {
        /*
            r12 = this;
            java.lang.String r0 = ""
            r1 = 0
            r2 = 0
            r3 = 1
            android.content.Context r4 = r12.f2617b     // Catch:{ IOException -> 0x0195 }
            java.lang.String r5 = "cca_logs.txt"
            java.io.FileInputStream r4 = r4.openFileInput(r5)     // Catch:{ IOException -> 0x0195 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x0144 }
            r5.<init>(r4)     // Catch:{ all -> 0x0144 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x012d }
            r6.<init>(r5)     // Catch:{ all -> 0x012d }
            if (r4 == 0) goto L_0x00a1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r7.<init>()     // Catch:{ all -> 0x0087 }
            int r8 = f2614c
            r9 = r8 | 81
            int r9 = r9 << r3
            r8 = r8 ^ 81
            int r8 = -r8
            r10 = r9 & r8
            r8 = r8 | r9
            int r10 = r10 + r8
        L_0x002a:
            int r8 = r10 % 128
            f2615d = r8
            int r10 = r10 % 2
            java.lang.String r8 = r6.readLine()     // Catch:{ all -> 0x0087 }
            if (r8 == 0) goto L_0x0038
            r9 = 1
            goto L_0x0039
        L_0x0038:
            r9 = 0
        L_0x0039:
            if (r9 == 0) goto L_0x006e
            int r9 = f2614c
            r10 = r9 ^ 123(0x7b, float:1.72E-43)
            r11 = r9 & 123(0x7b, float:1.72E-43)
            r10 = r10 | r11
            int r10 = r10 << r3
            r11 = r9 & -124(0xffffffffffffff84, float:NaN)
            int r9 = ~r9
            r9 = r9 & 123(0x7b, float:1.72E-43)
            r9 = r9 | r11
            int r9 = -r9
            int r9 = ~r9
            int r10 = r10 - r9
            int r10 = r10 - r3
            int r9 = r10 % 128
            f2615d = r9
            int r10 = r10 % 2
            r7.append(r8)     // Catch:{ all -> 0x0087 }
            java.lang.String r8 = "\n"
            r7.append(r8)     // Catch:{ all -> 0x0087 }
            int r8 = f2614c
            r9 = r8 ^ 61
            r10 = r8 & 61
            r9 = r9 | r10
            int r9 = r9 << r3
            int r10 = ~r10
            r8 = r8 | 61
            r8 = r8 & r10
            int r8 = -r8
            r10 = r9 | r8
            int r10 = r10 << r3
            r8 = r8 ^ r9
            int r10 = r10 - r8
            goto L_0x002a
        L_0x006e:
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0087 }
            int r7 = f2614c
            r8 = r7 | 118(0x76, float:1.65E-43)
            int r8 = r8 << r3
            r7 = r7 ^ 118(0x76, float:1.65E-43)
            int r8 = r8 - r7
            r7 = r8 ^ -1
            r8 = r8 & -1
            int r8 = r8 << r3
            int r7 = r7 + r8
            int r8 = r7 % 128
            f2615d = r8
            int r7 = r7 % 2
            goto L_0x00a1
        L_0x0087:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r8 = move-exception
            r6.close()     // Catch:{ all -> 0x009c }
            int r6 = f2615d
            r7 = r6 & 50
            r6 = r6 | 50
            int r7 = r7 + r6
            int r7 = r7 - r3
            int r6 = r7 % 128
            f2614c = r6
            int r7 = r7 % 2
            goto L_0x00a0
        L_0x009c:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch:{ all -> 0x012d }
        L_0x00a0:
            throw r8     // Catch:{ all -> 0x012d }
        L_0x00a1:
            r6.close()     // Catch:{ all -> 0x012d }
            int r6 = f2615d
            r7 = r6 ^ 55
            r8 = r6 & 55
            r7 = r7 | r8
            int r7 = r7 << r3
            int r8 = ~r8
            r6 = r6 | 55
            r6 = r6 & r8
            int r7 = r7 - r6
            int r6 = r7 % 128
            f2614c = r6
            int r7 = r7 % 2
            int r6 = f2615d
            r7 = r6 | 32
            int r7 = r7 << r3
            r6 = r6 ^ 32
            int r7 = r7 - r6
            r6 = r7 ^ -1
            r7 = r7 & -1
            int r7 = r7 << r3
            int r6 = r6 + r7
            int r7 = r6 % 128
            f2614c = r7
            int r6 = r6 % 2
            r7 = 54
            if (r6 == 0) goto L_0x00d2
            r6 = 13
            goto L_0x00d4
        L_0x00d2:
            r6 = 54
        L_0x00d4:
            if (r6 == r7) goto L_0x00dd
            r5.close()     // Catch:{ all -> 0x0144 }
            super.hashCode()     // Catch:{ all -> 0x0144 }
            goto L_0x00e0
        L_0x00dd:
            r5.close()     // Catch:{ all -> 0x0144 }
        L_0x00e0:
            int r5 = f2615d
            int r5 = r5 + 109
            int r6 = r5 % 128
            f2614c = r6
            int r5 = r5 % 2
            if (r4 == 0) goto L_0x00ee
            r5 = 0
            goto L_0x00ef
        L_0x00ee:
            r5 = 1
        L_0x00ef:
            if (r5 == r3) goto L_0x0117
            int r5 = f2614c
            r6 = r5 ^ 105(0x69, float:1.47E-43)
            r5 = r5 & 105(0x69, float:1.47E-43)
            r5 = r5 | r6
            int r5 = r5 << r3
            int r6 = -r6
            int r6 = ~r6
            int r5 = r5 - r6
            int r5 = r5 - r3
            int r6 = r5 % 128
            f2615d = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x0107
            r5 = 0
            goto L_0x0108
        L_0x0107:
            r5 = 1
        L_0x0108:
            if (r5 == r3) goto L_0x0112
            r4.close()     // Catch:{ IOException -> 0x0195 }
            int r4 = r1.length     // Catch:{ all -> 0x0110 }
            goto L_0x01b3
        L_0x0110:
            r0 = move-exception
            throw r0
        L_0x0112:
            r4.close()     // Catch:{ IOException -> 0x0195 }
            goto L_0x01b3
        L_0x0117:
            int r4 = f2614c
            r5 = r4 ^ 84
            r4 = r4 & 84
            int r4 = r4 << r3
            int r5 = r5 + r4
            r4 = r5 ^ -1
            r5 = r5 & -1
            int r5 = r5 << r3
            int r4 = r4 + r5
            int r5 = r4 % 128
            f2615d = r5
            int r4 = r4 % 2
            goto L_0x01b3
        L_0x012d:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x012f }
        L_0x012f:
            r7 = move-exception
            r5.close()     // Catch:{ all -> 0x013f }
            int r5 = f2614c
            int r5 = r5 + 68
            int r5 = r5 - r3
            int r6 = r5 % 128
            f2615d = r6
            int r5 = r5 % 2
            goto L_0x0143
        L_0x013f:
            r5 = move-exception
            r6.addSuppressed(r5)     // Catch:{ all -> 0x0144 }
        L_0x0143:
            throw r7     // Catch:{ all -> 0x0144 }
        L_0x0144:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0146 }
        L_0x0146:
            r6 = move-exception
            if (r4 == 0) goto L_0x0194
            r7 = 74
            if (r7 == r7) goto L_0x0169
            r4.close()     // Catch:{ IOException -> 0x0195 }
            int r4 = f2614c
            r5 = r4 ^ 59
            r7 = r4 & 59
            r5 = r5 | r7
            int r5 = r5 << r3
            int r7 = ~r7
            r4 = r4 | 59
            r4 = r4 & r7
            int r4 = -r4
            r7 = r5 | r4
            int r7 = r7 << r3
            r4 = r4 ^ r5
            int r7 = r7 - r4
            int r4 = r7 % 128
            f2615d = r4
            int r7 = r7 % 2
            goto L_0x0194
        L_0x0169:
            int r7 = f2615d
            r8 = r7 & 87
            int r9 = ~r8
            r7 = r7 | 87
            r7 = r7 & r9
            int r8 = r8 << r3
            int r8 = -r8
            int r8 = -r8
            r9 = r7 ^ r8
            r7 = r7 & r8
            int r7 = r7 << r3
            int r9 = r9 + r7
            int r7 = r9 % 128
            f2614c = r7
            int r9 = r9 % 2
            r4.close()     // Catch:{ all -> 0x0190 }
            int r4 = f2615d
            r5 = r4 & 31
            r4 = r4 | 31
            int r5 = r5 + r4
            int r4 = r5 % 128
            f2614c = r4
            int r5 = r5 % 2
            goto L_0x0194
        L_0x0190:
            r4 = move-exception
            r5.addSuppressed(r4)     // Catch:{ IOException -> 0x0195 }
        L_0x0194:
            throw r6     // Catch:{ IOException -> 0x0195 }
        L_0x0195:
            r4 = move-exception
            java.lang.String r6 = r12.f2616a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Exception during closing log file. Error: "
            r5.<init>(r7)
            java.lang.String r4 = r4.getLocalizedMessage()
            r5.append(r4)
            java.lang.String r7 = r5.toString()
            r5 = 6
            r8 = 0
            r10 = 38
            java.lang.String r9 = "com.cardinalcommerce.a.setHintTextColor"
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
        L_0x01b3:
            java.lang.String r0 = r0.trim()
            int r4 = f2614c
            r5 = r4 & 41
            r4 = r4 | 41
            int r5 = r5 + r4
            int r4 = r5 % 128
            f2615d = r4
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x01c7
            goto L_0x01c8
        L_0x01c7:
            r2 = 1
        L_0x01c8:
            if (r2 == r3) goto L_0x01ce
            int r1 = r1.length     // Catch:{ all -> 0x01cc }
            return r0
        L_0x01cc:
            r0 = move-exception
            throw r0
        L_0x01ce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2021n.mo18284a():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r7 = f2615d;
        r0 = r7 ^ 37;
        r7 = ((r7 & 37) | r0) << 1;
        r0 = -r0;
        r2 = (r7 & r0) + (r7 | r0);
        f2614c = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        throw r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo18285a(java.lang.String r7) {
        /*
            r6 = this;
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x004d }
            android.content.Context r1 = r6.f2617b     // Catch:{ IOException -> 0x004d }
            java.lang.String r2 = "cca_logs.txt"
            r3 = 0
            java.io.FileOutputStream r1 = r1.openFileOutput(r2, r3)     // Catch:{ IOException -> 0x004d }
            r0.<init>(r1)     // Catch:{ IOException -> 0x004d }
            r0.append(r7)     // Catch:{ all -> 0x002d }
            r0.close()     // Catch:{ IOException -> 0x004d }
            int r7 = f2614c
            r0 = 91
            r1 = r7 & -92
            int r2 = ~r7
            r2 = r2 & r0
            r1 = r1 | r2
            r7 = r7 & r0
            int r7 = r7 << 1
            int r7 = -r7
            int r7 = -r7
            r0 = r1 & r7
            r7 = r7 | r1
            int r0 = r0 + r7
            int r7 = r0 % 128
            f2615d = r7
            int r0 = r0 % 2
            return
        L_0x002d:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x002f }
        L_0x002f:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0048 }
            int r7 = f2615d
            r0 = r7 ^ 37
            r7 = r7 & 37
            r7 = r7 | r0
            int r7 = r7 << 1
            int r0 = -r0
            r2 = r7 & r0
            r7 = r7 | r0
            int r2 = r2 + r7
            int r7 = r2 % 128
            f2614c = r7
            int r2 = r2 % 2
            goto L_0x004c
        L_0x0048:
            r0 = move-exception
            r7.addSuppressed(r0)     // Catch:{ IOException -> 0x004d }
        L_0x004c:
            throw r1     // Catch:{ IOException -> 0x004d }
        L_0x004d:
            r7 = move-exception
            java.lang.String r1 = r6.f2616a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Exception during adding to log file. Error: "
            r0.<init>(r2)
            java.lang.String r7 = r7.getLocalizedMessage()
            r0.append(r7)
            java.lang.String r2 = r0.toString()
            r0 = 6
            r3 = 0
            r5 = 55
            java.lang.String r4 = "com.cardinalcommerce.a.setHintTextColor"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2021n.mo18285a(java.lang.String):void");
    }
}
