package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbrs implements zzesa<zzbzl<zzbvm>> {
    private final zzesn<zzbrr> zzeyk;
    private final zzbrt zzgae;

    private zzbrs(zzbrt zzbrt, zzesn<zzbrr> zzesn) {
        this.zzgae = zzbrt;
        this.zzeyk = zzesn;
    }

    public static zzbrs zza(zzbrt zzbrt, zzesn<zzbrr> zzesn) {
        return new zzbrs(zzbrt, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), zzbat.zzekj));
    }
}
