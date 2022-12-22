package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbpu implements zzesa<String> {
    private final zzbps zzfzb;

    private zzbpu(zzbps zzbps) {
        this.zzfzb = zzbps;
    }

    public static zzbpu zza(zzbps zzbps) {
        return new zzbpu(zzbps);
    }

    public static String zzb(zzbps zzbps) {
        return (String) zzesg.zzbd(zzbps.zzalt());
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzfzb);
    }
}
