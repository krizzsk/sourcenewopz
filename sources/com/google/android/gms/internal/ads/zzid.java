package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzid {
    public static final zzid zzaiq = new zzic();

    public abstract zzie zza(int i, zzie zzie, boolean z, long j);

    public abstract zzif zza(int i, zzif zzif, boolean z);

    public abstract int zzc(Object obj);

    public abstract int zzfj();

    public abstract int zzfk();

    public final boolean isEmpty() {
        return zzfj() == 0;
    }

    public final zzie zza(int i, zzie zzie, boolean z) {
        return zza(i, zzie, false, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        if ((zzfj() - 1) == 0) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(int r3, com.google.android.gms.internal.ads.zzif r4, com.google.android.gms.internal.ads.zzie r5, int r6) {
        /*
            r2 = this;
            r0 = 0
            r2.zza((int) r3, (com.google.android.gms.internal.ads.zzif) r4, (boolean) r0)
            r2.zza((int) r0, (com.google.android.gms.internal.ads.zzie) r5, (boolean) r0)
            r4 = 1
            if (r3 != 0) goto L_0x0031
            r3 = -1
            if (r6 == 0) goto L_0x0022
            if (r6 == r4) goto L_0x0020
            r1 = 2
            if (r6 != r1) goto L_0x001a
            int r6 = r2.zzfj()
            int r6 = r6 - r4
            if (r6 != 0) goto L_0x002a
            goto L_0x0020
        L_0x001a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>()
            throw r3
        L_0x0020:
            r4 = 0
            goto L_0x002a
        L_0x0022:
            int r6 = r2.zzfj()
            int r6 = r6 - r4
            if (r6 != 0) goto L_0x002a
            r4 = -1
        L_0x002a:
            if (r4 != r3) goto L_0x002d
            return r3
        L_0x002d:
            r2.zza((int) r4, (com.google.android.gms.internal.ads.zzie) r5, (boolean) r0)
            return r0
        L_0x0031:
            int r3 = r3 + r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzid.zza(int, com.google.android.gms.internal.ads.zzif, com.google.android.gms.internal.ads.zzie, int):int");
    }
}
