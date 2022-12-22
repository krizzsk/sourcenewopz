package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcdm {
    private zzaer zzclt;

    public zzcdm(zzcdd zzcdd) {
        this.zzclt = zzcdd;
    }

    public final synchronized zzaer zzue() {
        return this.zzclt;
    }

    public final synchronized void zza(zzaer zzaer) {
        this.zzclt = zzaer;
    }
}
