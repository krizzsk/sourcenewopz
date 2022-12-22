package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcvg implements zzesa<zzcve> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzcbj> zzgvz;

    public zzcvg(zzesn<Context> zzesn, zzesn<zzbar> zzesn2, zzesn<zzcbj> zzesn3, zzesn<Executor> zzesn4) {
        this.zzeyq = zzesn;
        this.zzfvj = zzesn2;
        this.zzgvz = zzesn3;
        this.zzfxf = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzcve(this.zzeyq.get(), this.zzfvj.get(), this.zzgvz.get(), this.zzfxf.get());
    }
}
