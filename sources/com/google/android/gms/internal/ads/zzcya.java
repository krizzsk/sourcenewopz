package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbug;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcya<AdT, AdapterT, ListenerT extends zzbug> implements zzesa<zzcxw<AdT, AdapterT, ListenerT>> {
    private final zzesn<zzcta<AdapterT, ListenerT>> zzfsx;
    private final zzesn<zzebs> zzfxf;
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<zzcth<AdT, AdapterT, ListenerT>> zzgzf;

    private zzcya(zzesn<zzdtg> zzesn, zzesn<zzebs> zzesn2, zzesn<zzcta<AdapterT, ListenerT>> zzesn3, zzesn<zzcth<AdT, AdapterT, ListenerT>> zzesn4) {
        this.zzfxq = zzesn;
        this.zzfxf = zzesn2;
        this.zzfsx = zzesn3;
        this.zzgzf = zzesn4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbug> zzcya<AdT, AdapterT, ListenerT> zzf(zzesn<zzdtg> zzesn, zzesn<zzebs> zzesn2, zzesn<zzcta<AdapterT, ListenerT>> zzesn3, zzesn<zzcth<AdT, AdapterT, ListenerT>> zzesn4) {
        return new zzcya<>(zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        return new zzcxw(this.zzfxq.get(), this.zzfxf.get(), this.zzfsx.get(), this.zzgzf.get());
    }
}
