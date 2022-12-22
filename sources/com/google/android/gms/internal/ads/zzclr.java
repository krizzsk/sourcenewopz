package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzclr implements zzbsz, zzbuj, zzbvm {
    private final zzclz zzgoa;
    private final zzcmg zzgob;

    public zzclr(zzclz zzclz, zzcmg zzcmg) {
        this.zzgoa = zzclz;
        this.zzgob = zzcmg;
    }

    public final void onAdLoaded() {
        this.zzgoa.zzsx().put("action", "loaded");
        this.zzgob.zzo(this.zzgoa.zzsx());
    }

    public final void zzd(zzvh zzvh) {
        this.zzgoa.zzsx().put("action", "ftl");
        this.zzgoa.zzsx().put("ftl", String.valueOf(zzvh.errorCode));
        this.zzgoa.zzsx().put("ed", zzvh.zzcht);
        this.zzgob.zzo(this.zzgoa.zzsx());
    }

    public final void zzd(zzauj zzauj) {
        this.zzgoa.zzi(zzauj.zzdys);
    }

    public final void zzd(zzdpi zzdpi) {
        this.zzgoa.zze(zzdpi);
    }
}
