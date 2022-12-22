package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfe implements zzesa<zzdfc> {
    private final zzesn<zzebs> zzeyl;

    private zzdfe(zzesn<zzebs> zzesn) {
        this.zzeyl = zzesn;
    }

    public static zzdfe zzao(zzesn<zzebs> zzesn) {
        return new zzdfe(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzdfc(this.zzeyl.get());
    }
}
