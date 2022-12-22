package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcqx implements zzbsz, zzbuj, zzbvm {
    private final zzdtw zzdjf;
    private final zzbac zzedz;
    private final zzdtx zzgsu;

    public zzcqx(zzdtx zzdtx, zzdtw zzdtw, zzbac zzbac) {
        this.zzgsu = zzdtx;
        this.zzdjf = zzdtw;
        this.zzedz = zzbac;
    }

    public final void onAdLoaded() {
        this.zzdjf.zzb(this.zzgsu.zzw("action", "loaded"));
    }

    public final void zzd(zzvh zzvh) {
        this.zzgsu.zzw("action", "ftl").zzw("ftl", String.valueOf(zzvh.errorCode)).zzw("ed", zzvh.zzcht);
        this.zzdjf.zzb(this.zzgsu);
    }

    public final void zzd(zzauj zzauj) {
        this.zzgsu.zzq(zzauj.zzdys);
    }

    public final void zzd(zzdpi zzdpi) {
        this.zzgsu.zza(zzdpi, this.zzedz);
    }
}
