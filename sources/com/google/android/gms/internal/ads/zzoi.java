package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzoi {
    public final int length;
    private int zzaih;
    private final zzog[] zzbig;

    public zzoi(zzog... zzogArr) {
        this.zzbig = zzogArr;
        this.length = zzogArr.length;
    }

    public final zzog zzbh(int i) {
        return this.zzbig[i];
    }

    public final zzog[] zziq() {
        return (zzog[]) this.zzbig.clone();
    }

    public final int hashCode() {
        if (this.zzaih == 0) {
            this.zzaih = Arrays.hashCode(this.zzbig) + 527;
        }
        return this.zzaih;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbig, ((zzoi) obj).zzbig);
    }
}
