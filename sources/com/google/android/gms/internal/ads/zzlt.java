package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzlt {
    public final int[] zzape;
    public final long[] zzapf;
    public final int zzaxm;
    public final int zzayt;
    public final int[] zzayv;
    public final long[] zzbax;

    public zzlt(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        zzpg.checkArgument(iArr.length == jArr2.length);
        zzpg.checkArgument(jArr.length == jArr2.length);
        zzpg.checkArgument(iArr2.length != jArr2.length ? false : z);
        this.zzapf = jArr;
        this.zzape = iArr;
        this.zzayt = i;
        this.zzbax = jArr2;
        this.zzayv = iArr2;
        this.zzaxm = jArr.length;
    }

    public final int zzec(long j) {
        for (int zza = zzpt.zza(this.zzbax, j, true, false); zza >= 0; zza--) {
            if ((this.zzayv[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    public final int zzed(long j) {
        for (int zzb = zzpt.zzb(this.zzbax, j, true, false); zzb < this.zzbax.length; zzb++) {
            if ((this.zzayv[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
