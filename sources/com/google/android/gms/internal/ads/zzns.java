package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzns extends zzid {
    private static final Object zzbha = new Object();
    private final boolean zzaiu;
    private final boolean zzaiv;
    private final long zzbhb;
    private final long zzbhc;
    private final long zzbhd;
    private final long zzbhe;

    public zzns(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    public final int zzfj() {
        return 1;
    }

    public final int zzfk() {
        return 1;
    }

    private zzns(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.zzbhb = j;
        this.zzbhc = j2;
        this.zzbhd = 0;
        this.zzbhe = 0;
        this.zzaiu = z;
        this.zzaiv = false;
    }

    public final zzie zza(int i, zzie zzie, boolean z, long j) {
        zzpg.zzc(i, 0, 1);
        boolean z2 = this.zzaiu;
        long j2 = this.zzbhc;
        zzie.zzair = null;
        zzie.zzais = -9223372036854775807L;
        zzie.zzait = -9223372036854775807L;
        zzie.zzaiu = z2;
        zzie.zzaiv = false;
        zzie.zzaiy = 0;
        zzie.zzaiz = j2;
        zzie.zzaiw = 0;
        zzie.zzaix = 0;
        zzie.zzaja = 0;
        return zzie;
    }

    public final zzif zza(int i, zzif zzif, boolean z) {
        zzpg.zzc(i, 0, 1);
        Object obj = z ? zzbha : null;
        return zzif.zza(obj, obj, 0, this.zzbhb, 0, false);
    }

    public final int zzc(Object obj) {
        return zzbha.equals(obj) ? 0 : -1;
    }
}
