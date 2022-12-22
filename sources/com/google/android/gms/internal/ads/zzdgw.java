package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdgw implements zzesa<zzdgu> {
    private final zzesn<zzdmp> zzgan;

    private zzdgw(zzesn<zzdmp> zzesn) {
        this.zzgan = zzesn;
    }

    public static zzdgw zzap(zzesn<zzdmp> zzesn) {
        return new zzdgw(zzesn);
    }

    public static zzdgu zzb(zzdmp zzdmp) {
        return new zzdgu(zzdmp);
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzgan.get());
    }
}
