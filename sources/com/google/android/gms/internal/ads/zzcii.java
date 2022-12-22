package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcii implements zzesa<zzcih> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdup> zzfab;
    private final zzesn<zzcmb> zzfac;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzbar> zzgbl;
    private final zzesn<zzei> zzgfg;
    private final zzesn<zzb> zzgkt;
    private final zzesn<zzbfq> zzgly;
    private final zzesn<zzcsh> zzglz;
    private final zzesn<zzdtw> zzgma;

    public zzcii(zzesn<Context> zzesn, zzesn<Executor> zzesn2, zzesn<zzei> zzesn3, zzesn<zzbar> zzesn4, zzesn<zzb> zzesn5, zzesn<zzbfq> zzesn6, zzesn<zzcsh> zzesn7, zzesn<zzdup> zzesn8, zzesn<zzcmb> zzesn9, zzesn<zzdtw> zzesn10) {
        this.zzeyq = zzesn;
        this.zzfxf = zzesn2;
        this.zzgfg = zzesn3;
        this.zzgbl = zzesn4;
        this.zzgkt = zzesn5;
        this.zzgly = zzesn6;
        this.zzglz = zzesn7;
        this.zzfab = zzesn8;
        this.zzfac = zzesn9;
        this.zzgma = zzesn10;
    }

    public final /* synthetic */ Object get() {
        return new zzcih(this.zzeyq.get(), this.zzfxf.get(), this.zzgfg.get(), this.zzgbl.get(), this.zzgkt.get(), this.zzgly.get(), this.zzglz.get(), this.zzfab.get(), this.zzfac.get(), this.zzgma.get());
    }
}
