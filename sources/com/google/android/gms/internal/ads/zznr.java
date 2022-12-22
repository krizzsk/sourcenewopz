package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zznr {
    public final int length;
    private int zzaih;
    private final zzht[] zzbgb;

    public zznr(zzht... zzhtArr) {
        zzpg.checkState(zzhtArr.length > 0);
        this.zzbgb = zzhtArr;
        this.length = zzhtArr.length;
    }

    public final zzht zzbe(int i) {
        return this.zzbgb[i];
    }

    public final int zzh(zzht zzht) {
        int i = 0;
        while (true) {
            zzht[] zzhtArr = this.zzbgb;
            if (i >= zzhtArr.length) {
                return -1;
            }
            if (zzht == zzhtArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final int hashCode() {
        if (this.zzaih == 0) {
            this.zzaih = Arrays.hashCode(this.zzbgb) + 527;
        }
        return this.zzaih;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznr zznr = (zznr) obj;
            return this.length == zznr.length && Arrays.equals(this.zzbgb, zznr.zzbgb);
        }
    }
}
