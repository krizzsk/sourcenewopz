package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcgk implements zzear {
    private final zzebt zzgkr;

    zzcgk(zzebt zzebt) {
        this.zzgkr = zzebt;
    }

    public final zzebt zzf(Object obj) {
        zzebt zzebt = this.zzgkr;
        if (obj != null) {
            return zzebt;
        }
        return zzebh.immediateFailedFuture(new zzcwo(zzdqj.INTERNAL_ERROR, "Retrieve required value in native ad response failed."));
    }
}
