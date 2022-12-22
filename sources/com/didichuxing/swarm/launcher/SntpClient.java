package com.didichuxing.swarm.launcher;

import org.mozilla.javascript.typedarrays.Conversions;

public class SntpClient {

    /* renamed from: a */
    private static final String f49158a = "SntpClient";

    /* renamed from: b */
    private static final int f49159b = 16;

    /* renamed from: c */
    private static final int f49160c = 24;

    /* renamed from: d */
    private static final int f49161d = 32;

    /* renamed from: e */
    private static final int f49162e = 40;

    /* renamed from: f */
    private static final int f49163f = 48;

    /* renamed from: g */
    private static final int f49164g = 123;

    /* renamed from: h */
    private static final int f49165h = 3;

    /* renamed from: i */
    private static final int f49166i = 3;

    /* renamed from: j */
    private static final long f49167j = 2208988800L;

    /* renamed from: k */
    private long f49168k;

    /* renamed from: l */
    private long f49169l;

    /* renamed from: m */
    private long f49170m;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean requestTime(java.lang.String r20, int r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = 0
            r3 = 0
            java.net.DatagramSocket r4 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x008c }
            r4.<init>()     // Catch:{ Exception -> 0x008c }
            r0 = r21
            r4.setSoTimeout(r0)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            java.net.InetAddress r0 = java.net.InetAddress.getByName(r20)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r3 = 48
            byte[] r5 = new byte[r3]     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r7 = 123(0x7b, float:1.72E-43)
            r6.<init>(r5, r3, r0, r7)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r0 = 27
            r5[r2] = r0     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r0 = 40
            r1.m35450a(r5, r0, r7)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r4.send(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r6.<init>(r5, r3)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r4.receive(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            long r9 = r11 - r9
            long r7 = r7 + r9
            r3 = 24
            long r13 = r1.m35451b(r5, r3)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r3 = 32
            long r15 = r1.m35451b(r5, r3)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            long r5 = r1.m35451b(r5, r0)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            long r17 = r5 - r15
            long r9 = r9 - r17
            long r15 = r15 - r13
            long r5 = r5 - r7
            long r15 = r15 + r5
            r5 = 2
            long r5 = r15 / r5
            java.lang.String r14 = "Daniel---"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r0.<init>()     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            java.lang.String r3 = "clockOffset: "
            r0.append(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r0.append(r5)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            java.lang.String r15 = r0.toString()     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r13 = 3
            r16 = 0
            java.lang.String r17 = "com.didichuxing.swarm.launcher.SntpClient"
            r18 = 101(0x65, float:1.42E-43)
            com.didi.sdk.apm.SystemUtils.log(r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            long r7 = r7 + r5
            r1.f49168k = r7     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r1.f49169l = r11     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r1.f49170m = r9     // Catch:{ Exception -> 0x0087, all -> 0x0084 }
            r4.close()
            r0 = 1
            return r0
        L_0x0084:
            r0 = move-exception
            r3 = r4
            goto L_0x00af
        L_0x0087:
            r0 = move-exception
            r3 = r4
            goto L_0x008d
        L_0x008a:
            r0 = move-exception
            goto L_0x00af
        L_0x008c:
            r0 = move-exception
        L_0x008d:
            java.lang.String r5 = "Daniel---"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r4.<init>()     // Catch:{ all -> 0x008a }
            java.lang.String r6 = "request time failed: "
            r4.append(r6)     // Catch:{ all -> 0x008a }
            r4.append(r0)     // Catch:{ all -> 0x008a }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x008a }
            r4 = 3
            r7 = 0
            java.lang.String r8 = "com.didichuxing.swarm.launcher.SntpClient"
            r9 = 111(0x6f, float:1.56E-43)
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x00ae
            r3.close()
        L_0x00ae:
            return r2
        L_0x00af:
            if (r3 == 0) goto L_0x00b4
            r3.close()
        L_0x00b4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.swarm.launcher.SntpClient.requestTime(java.lang.String, int):boolean");
    }

    public long getNtpTime() {
        return this.f49168k;
    }

    public long getNtpTimeReference() {
        return this.f49169l;
    }

    public long getRoundTripTime() {
        return this.f49170m;
    }

    /* renamed from: a */
    private long m35449a(byte[] bArr, int i) {
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
    private long m35451b(byte[] bArr, int i) {
        return ((m35449a(bArr, i) - f49167j) * 1000) + ((m35449a(bArr, i + 4) * 1000) / Conversions.THIRTYTWO_BIT);
    }

    /* renamed from: a */
    private void m35450a(byte[] bArr, int i, long j) {
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + f49167j;
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
