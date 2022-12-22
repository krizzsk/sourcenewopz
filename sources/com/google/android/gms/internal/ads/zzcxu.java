package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcxu extends zzcxb {
    private final zzbwx zzgza;

    public zzcxu(zzbst zzbst, zzbtl zzbtl, zzbty zzbty, zzbui zzbui, zzbtb zzbtb, zzbxe zzbxe, zzcaa zzcaa, zzbur zzbur, zzbzv zzbzv, zzbwx zzbwx) {
        super(zzbst, zzbtl, zzbty, zzbui, zzbtb, zzbxe, zzcaa, zzbur, zzbzv, zzbwx);
        this.zzgza = zzbwx;
    }

    public final void onAdImpression() {
        this.zzgza.zzaly();
    }
}
