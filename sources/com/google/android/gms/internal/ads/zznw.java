package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zznw {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zza(long r16, com.google.android.gms.internal.ads.zzpn r18, com.google.android.gms.internal.ads.zzkh[] r19) {
        /*
            r0 = r18
            r1 = r19
        L_0x0004:
            int r2 = r18.zziz()
            r3 = 1
            if (r2 <= r3) goto L_0x009d
            int r2 = zzf(r18)
            int r4 = zzf(r18)
            r5 = -1
            if (r4 == r5) goto L_0x0088
            int r5 = r18.zziz()
            if (r4 <= r5) goto L_0x001e
            goto L_0x0088
        L_0x001e:
            r5 = 4
            r6 = 3
            r7 = 8
            r8 = 0
            if (r2 != r5) goto L_0x0050
            if (r4 >= r7) goto L_0x0028
            goto L_0x0050
        L_0x0028:
            int r2 = r18.getPosition()
            int r5 = r18.readUnsignedByte()
            int r9 = r18.readUnsignedShort()
            int r10 = r18.readInt()
            int r11 = r18.readUnsignedByte()
            r0.zzbl(r2)
            r2 = 181(0xb5, float:2.54E-43)
            if (r5 != r2) goto L_0x0050
            r2 = 49
            if (r9 != r2) goto L_0x0050
            r2 = 1195456820(0x47413934, float:49465.203)
            if (r10 != r2) goto L_0x0050
            if (r11 != r6) goto L_0x0050
            r2 = 1
            goto L_0x0051
        L_0x0050:
            r2 = 0
        L_0x0051:
            if (r2 == 0) goto L_0x0083
            r0.zzbm(r7)
            int r2 = r18.readUnsignedByte()
            r2 = r2 & 31
            r0.zzbm(r3)
            int r2 = r2 * 3
            int r3 = r18.getPosition()
            int r5 = r1.length
        L_0x0066:
            if (r8 >= r5) goto L_0x007c
            r9 = r1[r8]
            r0.zzbl(r3)
            r9.zza(r0, r2)
            r12 = 1
            r14 = 0
            r15 = 0
            r10 = r16
            r13 = r2
            r9.zza(r10, r12, r13, r14, r15)
            int r8 = r8 + 1
            goto L_0x0066
        L_0x007c:
            int r2 = r2 + 10
            int r4 = r4 - r2
            r0.zzbm(r4)
            goto L_0x0004
        L_0x0083:
            r0.zzbm(r4)
            goto L_0x0004
        L_0x0088:
            r5 = 5
            r8 = 0
            r10 = 5
            java.lang.String r6 = "CeaUtil"
            java.lang.String r7 = "Skipping remainder of malformed SEI NAL unit."
            java.lang.String r9 = "com.google.android.gms.internal.ads.zznw"
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
            int r2 = r18.limit()
            r0.zzbl(r2)
            goto L_0x0004
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznw.zza(long, com.google.android.gms.internal.ads.zzpn, com.google.android.gms.internal.ads.zzkh[]):void");
    }

    private static int zzf(zzpn zzpn) {
        int i = 0;
        while (zzpn.zziz() != 0) {
            int readUnsignedByte = zzpn.readUnsignedByte();
            i += readUnsignedByte;
            if (readUnsignedByte != 255) {
                return i;
            }
        }
        return -1;
    }
}
