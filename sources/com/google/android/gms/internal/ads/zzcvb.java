package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcvb implements zzdxw {
    private final zzdot zzfxi;
    private final zzbfi zzgji;
    private final zzcux zzgxd;
    private final zzcal zzgxe;

    zzcvb(zzcux zzcux, zzbfi zzbfi, zzdot zzdot, zzcal zzcal) {
        this.zzgxd = zzcux;
        this.zzgji = zzbfi;
        this.zzfxi = zzdot;
        this.zzgxe = zzcal;
    }

    public final Object apply(Object obj) {
        zzbfi zzbfi = this.zzgji;
        zzdot zzdot = this.zzfxi;
        zzcal zzcal = this.zzgxe;
        if (zzdot.zzead) {
            zzbfi.zzaes();
        }
        zzbfi.zzadz();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpo)).booleanValue()) {
            zzbfi.onPause();
        }
        return zzcal.zzait();
    }
}
