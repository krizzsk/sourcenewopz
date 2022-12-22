package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzciy implements zzesa<String> {
    private final zzesn<zzdpm> zzfxn;

    public zzciy(zzesn<zzdpm> zzesn) {
        this.zzfxn = zzesn;
    }

    public static String zzb(zzdpm zzdpm) {
        return (String) zzesg.zzbd(zzdpm.zzhof.zzhnj == zzdpe.zzhnn ? "rewarded_interstitial" : "rewarded");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzfxn.get());
    }
}
