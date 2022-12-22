package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdna implements zzesa<zzdmr> {
    private final zzesn<zzbhh> zzeym;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzczm> zzhbp;
    private final zzesn<Context> zzhie;
    private final zzesn<zzdpo> zzhig;
    private final zzesn<zzdnb> zzhla;

    public zzdna(zzesn<Context> zzesn, zzesn<Executor> zzesn2, zzesn<zzbhh> zzesn3, zzesn<zzczm> zzesn4, zzesn<zzdnb> zzesn5, zzesn<zzdpo> zzesn6) {
        this.zzhie = zzesn;
        this.zzfxf = zzesn2;
        this.zzeym = zzesn3;
        this.zzhbp = zzesn4;
        this.zzhla = zzesn5;
        this.zzhig = zzesn6;
    }

    public final /* synthetic */ Object get() {
        return new zzdmr(this.zzhie.get(), this.zzfxf.get(), this.zzeym.get(), this.zzhbp.get(), this.zzhla.get(), this.zzhig.get());
    }
}
