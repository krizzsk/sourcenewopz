package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzctk implements zzdxw {
    private final zzdot zzfxi;
    private final zzbfi zzgji;
    private final zzctg zzgvs;
    private final zzbmr zzgvw;

    zzctk(zzctg zzctg, zzbfi zzbfi, zzdot zzdot, zzbmr zzbmr) {
        this.zzgvs = zzctg;
        this.zzgji = zzbfi;
        this.zzfxi = zzdot;
        this.zzgvw = zzbmr;
    }

    public final Object apply(Object obj) {
        zzbfi zzbfi = this.zzgji;
        zzdot zzdot = this.zzfxi;
        zzbmr zzbmr = this.zzgvw;
        if (zzdot.zzead) {
            zzbfi.zzaes();
        }
        zzbfi.zzadz();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpo)).booleanValue()) {
            zzbfi.onPause();
        }
        return zzbmr.zzahx();
    }
}
