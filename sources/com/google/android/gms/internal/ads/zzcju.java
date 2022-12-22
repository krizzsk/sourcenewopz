package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcju implements zzesa<zzbzl<zzbtp>> {
    private final zzesn<zzcjt> zzfvz;
    private final zzcjv zzgms;

    private zzcju(zzcjv zzcjv, zzesn<zzcjt> zzesn) {
        this.zzgms = zzcjv;
        this.zzfvz = zzesn;
    }

    public static zzcju zza(zzcjv zzcjv, zzesn<zzcjt> zzesn) {
        return new zzcju(zzcjv, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), zzbat.zzeki));
    }
}
