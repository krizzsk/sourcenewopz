package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcbg implements zzesa<zzcbh> {
    private final zzesn<zzbur> zzfjr;
    private final zzesn<zzbzh> zzfnp;

    private zzcbg(zzesn<zzbur> zzesn, zzesn<zzbzh> zzesn2) {
        this.zzfjr = zzesn;
        this.zzfnp = zzesn2;
    }

    public static zzcbg zzt(zzesn<zzbur> zzesn, zzesn<zzbzh> zzesn2) {
        return new zzcbg(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzcbh(this.zzfjr.get(), this.zzfnp.get());
    }
}
