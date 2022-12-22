package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdtf implements zzebi<O> {
    private final /* synthetic */ zzdst zzhth;
    private final /* synthetic */ zzdsy zzhti;

    zzdtf(zzdsy zzdsy, zzdst zzdst) {
        this.zzhti = zzdsy;
        this.zzhth = zzdst;
    }

    public final void onSuccess(O o) {
        this.zzhti.zzhta.zzhsv.zzc(this.zzhth);
    }

    public final void zzb(Throwable th) {
        this.zzhti.zzhta.zzhsv.zza(this.zzhth, th);
    }
}
