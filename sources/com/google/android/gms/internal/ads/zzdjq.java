package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdjq implements zzesa<zzdjn> {
    private final zzesn<zzbhh> zzeym;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdkd> zzhbp;
    private final zzesn<Context> zzhie;
    private final zzesn<zzdmh<zzbmg, zzbmp>> zzhif;
    private final zzesn<zzdpo> zzhig;

    public zzdjq(zzesn<Context> zzesn, zzesn<Executor> zzesn2, zzesn<zzbhh> zzesn3, zzesn<zzdmh<zzbmg, zzbmp>> zzesn4, zzesn<zzdkd> zzesn5, zzesn<zzdpo> zzesn6) {
        this.zzhie = zzesn;
        this.zzfxf = zzesn2;
        this.zzeym = zzesn3;
        this.zzhif = zzesn4;
        this.zzhbp = zzesn5;
        this.zzhig = zzesn6;
    }

    public final /* synthetic */ Object get() {
        return new zzdjn(this.zzhie.get(), this.zzfxf.get(), this.zzeym.get(), this.zzhif.get(), this.zzhbp.get(), this.zzhig.get());
    }
}
