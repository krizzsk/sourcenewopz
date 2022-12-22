package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbsl implements zzesa<String> {
    private final zzesn<zzbqr> zzfdm;
    private final zzbsj zzgbg;

    private zzbsl(zzbsj zzbsj, zzesn<zzbqr> zzesn) {
        this.zzgbg = zzbsj;
        this.zzfdm = zzesn;
    }

    public static zzbsl zzb(zzbsj zzbsj, zzesn<zzbqr> zzesn) {
        return new zzbsl(zzbsj, zzesn);
    }

    public static String zza(zzbsj zzbsj, zzbqr zzbqr) {
        return (String) zzesg.zzbd(zzbqr.zzye());
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzgbg, this.zzfdm.get());
    }
}
