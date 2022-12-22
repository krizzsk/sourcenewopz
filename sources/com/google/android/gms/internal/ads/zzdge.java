package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdge implements zzesa<zzdgb> {
    private final zzesn<String> zzgno;
    private final zzesn<String> zzhfp;

    private zzdge(zzesn<String> zzesn, zzesn<String> zzesn2) {
        this.zzgno = zzesn;
        this.zzhfp = zzesn2;
    }

    public static zzdge zzba(zzesn<String> zzesn, zzesn<String> zzesn2) {
        return new zzdge(zzesn, zzesn2);
    }

    public static zzdgb zzv(String str, String str2) {
        return new zzdgb(str, str2);
    }

    public final /* synthetic */ Object get() {
        return zzv(this.zzgno.get(), this.zzhfp.get());
    }
}
