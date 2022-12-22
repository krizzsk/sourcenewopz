package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzjy implements zzkf {
    private final int length;
    private final long zzaiz;
    private final int[] zzape;
    private final long[] zzapf;
    private final long[] zzapg;
    private final long[] zzaph;

    public zzjy(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzape = iArr;
        this.zzapf = jArr;
        this.zzapg = jArr2;
        this.zzaph = jArr3;
        int length2 = iArr.length;
        this.length = length2;
        if (length2 > 0) {
            this.zzaiz = jArr2[length2 - 1] + jArr3[length2 - 1];
        } else {
            this.zzaiz = 0;
        }
    }

    public final boolean isSeekable() {
        return true;
    }

    public final long getDurationUs() {
        return this.zzaiz;
    }

    public final long zzdz(long j) {
        return this.zzapf[zzpt.zza(this.zzaph, j, true, true)];
    }
}
