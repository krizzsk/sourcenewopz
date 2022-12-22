package com.didichuxing.bigdata.p173dp.locsdk.ntp;

import org.mozilla.javascript.typedarrays.Conversions;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.a */
/* compiled from: SntpClient */
class C15147a {

    /* renamed from: a */
    private static final String f46037a = "SntpClient";

    /* renamed from: b */
    private static final int f46038b = 16;

    /* renamed from: c */
    private static final int f46039c = 24;

    /* renamed from: d */
    private static final int f46040d = 32;

    /* renamed from: e */
    private static final int f46041e = 40;

    /* renamed from: f */
    private static final int f46042f = 48;

    /* renamed from: g */
    private static final int f46043g = 123;

    /* renamed from: h */
    private static final int f46044h = 3;

    /* renamed from: i */
    private static final int f46045i = 3;

    /* renamed from: j */
    private static final long f46046j = 2208988800L;

    /* renamed from: k */
    private long f46047k;

    /* renamed from: l */
    private long f46048l;

    /* renamed from: m */
    private long f46049m;

    C15147a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0075  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo114625a(java.lang.String r20, int r21) {
        /*
            r19 = this;
            r1 = r19
            r0 = 0
            r2 = 0
            java.net.DatagramSocket r3 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x0072, all -> 0x006b }
            r3.<init>()     // Catch:{ Exception -> 0x0072, all -> 0x006b }
            r2 = r21
            r3.setSoTimeout(r2)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            java.net.InetAddress r2 = java.net.InetAddress.getByName(r20)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r4 = 48
            byte[] r5 = new byte[r4]     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r7 = 123(0x7b, float:1.72E-43)
            r6.<init>(r5, r4, r2, r7)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r2 = 27
            r5[r0] = r2     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r2 = 40
            r1.m33053a(r5, r2, r7)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r3.send(r6)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r6.<init>(r5, r4)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r3.receive(r6)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r9 = r11 - r9
            long r7 = r7 + r9
            r4 = 24
            long r13 = r1.m33054b(r5, r4)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r4 = 32
            long r15 = r1.m33054b(r5, r4)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r4 = r1.m33054b(r5, r2)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r17 = r4 - r15
            long r9 = r9 - r17
            long r15 = r15 - r13
            long r4 = r4 - r7
            long r15 = r15 + r4
            r4 = 2
            long r15 = r15 / r4
            long r7 = r7 + r15
            r1.f46047k = r7     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r1.f46048l = r11     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r1.f46049m = r9     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            r3.close()
            r0 = 1
            return r0
        L_0x0066:
            r0 = move-exception
            r2 = r3
            goto L_0x006c
        L_0x0069:
            r2 = r3
            goto L_0x0073
        L_0x006b:
            r0 = move-exception
        L_0x006c:
            if (r2 == 0) goto L_0x0071
            r2.close()
        L_0x0071:
            throw r0
        L_0x0072:
        L_0x0073:
            if (r2 == 0) goto L_0x0078
            r2.close()
        L_0x0078:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.ntp.C15147a.mo114625a(java.lang.String, int):boolean");
    }

    /* renamed from: a */
    public long mo114624a() {
        return this.f46047k;
    }

    /* renamed from: b */
    public long mo114626b() {
        return this.f46048l;
    }

    /* renamed from: c */
    public long mo114627c() {
        return this.f46049m;
    }

    /* renamed from: a */
    private long m33052a(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        byte b5 = b & true;
        int i2 = b;
        if (b5 == true) {
            i2 = (b & Byte.MAX_VALUE) + 128;
        }
        byte b6 = b2 & true;
        int i3 = b2;
        if (b6 == true) {
            i3 = (b2 & Byte.MAX_VALUE) + 128;
        }
        byte b7 = b3 & true;
        int i4 = b3;
        if (b7 == true) {
            i4 = (b3 & Byte.MAX_VALUE) + 128;
        }
        byte b8 = b4 & true;
        int i5 = b4;
        if (b8 == true) {
            i5 = (b4 & Byte.MAX_VALUE) + 128;
        }
        return (((long) i2) << 24) + (((long) i3) << 16) + (((long) i4) << 8) + ((long) i5);
    }

    /* renamed from: b */
    private long m33054b(byte[] bArr, int i) {
        return ((m33052a(bArr, i) - f46046j) * 1000) + ((m33052a(bArr, i + 4) * 1000) / Conversions.THIRTYTWO_BIT);
    }

    /* renamed from: a */
    private void m33053a(byte[] bArr, int i, long j) {
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + f46046j;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) (j4 >> 24));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j4 >> 16));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) (j4 >> 8));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) (j4 >> 0));
        long j5 = (j3 * Conversions.THIRTYTWO_BIT) / 1000;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) (j5 >> 24));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) (j5 >> 16));
        bArr[i7] = (byte) ((int) (j5 >> 8));
        bArr[i7 + 1] = (byte) ((int) (Math.random() * 255.0d));
    }
}
