package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcut implements zzebi<zzbne> {
    private final /* synthetic */ zzcuo zzgwz;

    zzcut(zzcuo zzcuo) {
        this.zzgwz = zzcuo;
    }

    public final void zzb(Throwable th) {
        zzvh zze = this.zzgwz.zzgwu.zzahd().zze(th);
        this.zzgwz.zzgcz.zzd(zze);
        zzdqa.zza(zze.errorCode, th, "DelayedBannerAd.onFailure");
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbne) obj).zzakv();
    }
}
