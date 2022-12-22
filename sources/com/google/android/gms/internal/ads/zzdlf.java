package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdlf implements zzesa<zzdlc> {
    private final zzesn<zzbhh> zzeym;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzczm> zzhbp;
    private final zzesn<Context> zzhie;
    private final zzesn<zzdpo> zzhig;
    private final zzesn<zzvt> zzhjo;
    private final zzesn<zzdaj> zzhjp;

    public zzdlf(zzesn<Context> zzesn, zzesn<Executor> zzesn2, zzesn<zzvt> zzesn3, zzesn<zzbhh> zzesn4, zzesn<zzczm> zzesn5, zzesn<zzdaj> zzesn6, zzesn<zzdpo> zzesn7) {
        this.zzhie = zzesn;
        this.zzfxf = zzesn2;
        this.zzhjo = zzesn3;
        this.zzeym = zzesn4;
        this.zzhbp = zzesn5;
        this.zzhjp = zzesn6;
        this.zzhig = zzesn7;
    }

    public final /* synthetic */ Object get() {
        return new zzdlc(this.zzhie.get(), this.zzfxf.get(), this.zzhjo.get(), this.zzeym.get(), this.zzhbp.get(), this.zzhjp.get(), this.zzhig.get());
    }
}
