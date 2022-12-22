package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zznv implements zzog {
    private final int length;
    private int zzaih;
    private final zzht[] zzbgb;
    private final zznr zzbhh;
    private final int[] zzbhi;
    private final long[] zzbhj;

    public zznv(zznr zznr, int... iArr) {
        int i = 0;
        zzpg.checkState(iArr.length > 0);
        this.zzbhh = (zznr) zzpg.checkNotNull(zznr);
        int length2 = iArr.length;
        this.length = length2;
        this.zzbgb = new zzht[length2];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzbgb[i2] = zznr.zzbe(iArr[i2]);
        }
        Arrays.sort(this.zzbgb, new zznx());
        this.zzbhi = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i < i3) {
                this.zzbhi[i] = zznr.zzh(this.zzbgb[i]);
                i++;
            } else {
                this.zzbhj = new long[i3];
                return;
            }
        }
    }

    public final zznr zzip() {
        return this.zzbhh;
    }

    public final int length() {
        return this.zzbhi.length;
    }

    public final zzht zzbe(int i) {
        return this.zzbgb[i];
    }

    public final int zzbg(int i) {
        return this.zzbhi[0];
    }

    public int hashCode() {
        if (this.zzaih == 0) {
            this.zzaih = (System.identityHashCode(this.zzbhh) * 31) + Arrays.hashCode(this.zzbhi);
        }
        return this.zzaih;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznv zznv = (zznv) obj;
            return this.zzbhh == zznv.zzbhh && Arrays.equals(this.zzbhi, zznv.zzbhi);
        }
    }
}
