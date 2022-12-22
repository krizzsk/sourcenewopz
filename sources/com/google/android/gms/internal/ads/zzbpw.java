package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbpw implements zzesa<zzdpi> {
    private final zzbps zzfzb;

    private zzbpw(zzbps zzbps) {
        this.zzfzb = zzbps;
    }

    public static zzbpw zze(zzbps zzbps) {
        return new zzbpw(zzbps);
    }

    public static zzdpi zzf(zzbps zzbps) {
        return (zzdpi) zzesg.zzbd(zzbps.zzalq());
    }

    public final /* synthetic */ Object get() {
        return zzf(this.zzfzb);
    }
}
