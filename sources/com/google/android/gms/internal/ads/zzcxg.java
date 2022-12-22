package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcxg implements zzdxw {
    private final zzdot zzfxi;
    private final zzbfi zzgji;
    private final zzcxc zzgyn;
    private final zzcir zzgyo;

    zzcxg(zzcxc zzcxc, zzbfi zzbfi, zzdot zzdot, zzcir zzcir) {
        this.zzgyn = zzcxc;
        this.zzgji = zzbfi;
        this.zzfxi = zzdot;
        this.zzgyo = zzcir;
    }

    public final Object apply(Object obj) {
        zzbfi zzbfi = this.zzgji;
        zzdot zzdot = this.zzfxi;
        zzcir zzcir = this.zzgyo;
        if (zzdot.zzead) {
            zzbfi.zzaes();
        }
        zzbfi.zzadz();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpo)).booleanValue()) {
            zzbfi.onPause();
        }
        return zzcir.zzaja();
    }
}
