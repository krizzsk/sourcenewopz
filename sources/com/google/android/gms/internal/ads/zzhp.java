package com.google.android.gms.internal.ads;

import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzhp {
    public final int index;
    private final zzhy[] zzaex;
    private final zzoh zzaey;
    private final zzib[] zzafu;
    private final zzhx zzafv;
    private final zzne zzagb;
    public int zzags;
    public long zzagt;
    public final zznc zzagw;
    public final Object zzagx;
    public final zznn[] zzagy;
    private final boolean[] zzagz;
    public final long zzaha;
    public boolean zzahb;
    public boolean zzahc;
    public boolean zzahd;
    public zzhp zzahe;
    public zzoj zzahf;
    private zzoj zzahg;

    public zzhp(zzhy[] zzhyArr, zzib[] zzibArr, long j, zzoh zzoh, zzhx zzhx, zzne zzne, Object obj, int i, int i2, boolean z, long j2) {
        this.zzaex = zzhyArr;
        this.zzafu = zzibArr;
        this.zzaha = j;
        this.zzaey = zzoh;
        this.zzafv = zzhx;
        this.zzagb = zzne;
        this.zzagx = zzpg.checkNotNull(obj);
        this.index = i;
        this.zzags = i2;
        this.zzahb = z;
        this.zzagt = j2;
        this.zzagy = new zznn[zzhyArr.length];
        this.zzagz = new boolean[zzhyArr.length];
        this.zzagw = zzne.zza(i2, zzhx.zzfh());
    }

    public final long zzfa() {
        return this.zzaha - this.zzagt;
    }

    public final void zzc(int i, boolean z) {
        this.zzags = i;
        this.zzahb = z;
    }

    public final boolean zzfb() {
        if (this.zzahc) {
            return !this.zzahd || this.zzagw.zzhv() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfc() throws com.google.android.gms.internal.ads.zzhe {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzoh r0 = r6.zzaey
            com.google.android.gms.internal.ads.zzib[] r1 = r6.zzafu
            com.google.android.gms.internal.ads.zznc r2 = r6.zzagw
            com.google.android.gms.internal.ads.zznu r2 = r2.zzht()
            com.google.android.gms.internal.ads.zzoj r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zzoj r1 = r6.zzahg
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r1 = 0
            goto L_0x0028
        L_0x0016:
            r4 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zzoi r5 = r0.zzbii
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0027
            boolean r5 = r0.zza(r1, r4)
            if (r5 != 0) goto L_0x0024
            goto L_0x0014
        L_0x0024:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0027:
            r1 = 1
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            return r3
        L_0x002b:
            r6.zzahf = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhp.zzfc():boolean");
    }

    public final long zzb(long j, boolean z) {
        return zza(j, false, new boolean[this.zzaex.length]);
    }

    public final long zza(long j, boolean z, boolean[] zArr) {
        zzoi zzoi = this.zzahf.zzbii;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzoi.length) {
                break;
            }
            boolean[] zArr2 = this.zzagz;
            if (z || !this.zzahf.zza(this.zzahg, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.zzagw.zza(zzoi.zziq(), this.zzagz, this.zzagy, zArr, j);
        this.zzahg = this.zzahf;
        this.zzahd = false;
        int i2 = 0;
        while (true) {
            zznn[] zznnArr = this.zzagy;
            if (i2 < zznnArr.length) {
                if (zznnArr[i2] != null) {
                    zzpg.checkState(zzoi.zzbh(i2) != null);
                    this.zzahd = true;
                } else {
                    zzpg.checkState(zzoi.zzbh(i2) == null);
                }
                i2++;
            } else {
                this.zzafv.zza(this.zzaex, this.zzahf.zzbih, zzoi);
                return zza;
            }
        }
    }

    public final void release() {
        try {
            this.zzagb.zzb(this.zzagw);
        } catch (RuntimeException e) {
            SystemUtils.log(6, "ExoPlayerImplInternal", "Period release failed.", e, "com.google.android.gms.internal.ads.zzhp", 59);
        }
    }
}
