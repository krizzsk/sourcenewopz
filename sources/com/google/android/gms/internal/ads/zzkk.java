package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzkk {
    public final int zzapr = 1;
    public final byte[] zzaps;

    public zzkk(int i, byte[] bArr) {
        this.zzaps = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzkk zzkk = (zzkk) obj;
            return this.zzapr == zzkk.zzapr && Arrays.equals(this.zzaps, zzkk.zzaps);
        }
    }

    public final int hashCode() {
        return (this.zzapr * 31) + Arrays.hashCode(this.zzaps);
    }
}
