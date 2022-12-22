package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcid implements zzebi<zzbfi> {
    private final /* synthetic */ zzdot zzglp;
    private final /* synthetic */ zzdoy zzglq;

    zzcid(zzchu zzchu, zzdot zzdot, zzdoy zzdoy) {
        this.zzglp = zzdot;
        this.zzglq = zzdoy;
    }

    public final void zzb(Throwable th) {
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbfi) obj).zza(this.zzglp, this.zzglq);
    }
}
