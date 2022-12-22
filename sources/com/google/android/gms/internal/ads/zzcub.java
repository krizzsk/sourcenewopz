package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzad;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcub implements zzesa<zzcts> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzcja> zzgiz;
    private final zzesn<zzboa> zzgvz;
    private final zzesn<zzdxw<zzdot, zzad>> zzgwi;

    public zzcub(zzesn<zzboa> zzesn, zzesn<Context> zzesn2, zzesn<Executor> zzesn3, zzesn<zzcja> zzesn4, zzesn<zzdpm> zzesn5, zzesn<zzdxw<zzdot, zzad>> zzesn6) {
        this.zzgvz = zzesn;
        this.zzeyq = zzesn2;
        this.zzfxf = zzesn3;
        this.zzgiz = zzesn4;
        this.zzfxn = zzesn5;
        this.zzgwi = zzesn6;
    }

    public final /* synthetic */ Object get() {
        return new zzcts(this.zzgvz.get(), this.zzeyq.get(), this.zzfxf.get(), this.zzgiz.get(), this.zzfxn.get(), this.zzgwi.get());
    }
}
