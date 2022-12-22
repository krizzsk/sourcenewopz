package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcgi implements zzear {
    private final zzebt zzgkr;

    zzcgi(zzebt zzebt) {
        this.zzgkr = zzebt;
    }

    public final zzebt zzf(Object obj) {
        zzebt zzebt = this.zzgkr;
        zzbfi zzbfi = (zzbfi) obj;
        if (zzbfi != null && zzbfi.zzabv() != null) {
            return zzebt;
        }
        throw new zzcwo(zzdqj.INTERNAL_ERROR, "Retrieve video view in instream ad response failed.");
    }
}
