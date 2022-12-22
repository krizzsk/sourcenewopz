package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcxx extends zzcyd {
    private final zzbwx zzgza;

    public zzcxx(zzbst zzbst, zzbtl zzbtl, zzbty zzbty, zzbui zzbui, zzbxe zzbxe, zzbur zzbur, zzcaa zzcaa, zzbwx zzbwx, zzbtb zzbtb) {
        super(zzbst, zzbtl, zzbty, zzbui, zzbxe, zzbur, zzcaa, zzbwx, zzbtb);
        this.zzgza = zzbwx;
    }

    public final void onAdImpression() {
        this.zzgza.zzaly();
    }
}
