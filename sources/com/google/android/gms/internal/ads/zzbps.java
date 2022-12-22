package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbps {
    private final String zzcja;
    private final zzdpi zzfbh;
    private final zzdot zzftr;

    public zzbps(zzdpi zzdpi, zzdot zzdot, String str) {
        this.zzfbh = zzdpi;
        this.zzftr = zzdot;
        this.zzcja = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzdpi zzalq() {
        return this.zzfbh;
    }

    public final zzdot zzalr() {
        return this.zzftr;
    }

    public final zzdoy zzals() {
        return this.zzfbh.zzhnt.zzeuy;
    }

    public final String zzalt() {
        return this.zzcja;
    }
}
