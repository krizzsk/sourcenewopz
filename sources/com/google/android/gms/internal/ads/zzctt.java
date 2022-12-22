package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzctt implements zzesa<zzctp> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzcja> zzgiz;
    private final zzesn<zzbmg> zzgvz;

    public zzctt(zzesn<zzbmg> zzesn, zzesn<Context> zzesn2, zzesn<Executor> zzesn3, zzesn<zzcja> zzesn4) {
        this.zzgvz = zzesn;
        this.zzeyq = zzesn2;
        this.zzfxf = zzesn3;
        this.zzgiz = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzctp(this.zzgvz.get(), this.zzeyq.get(), this.zzfxf.get(), this.zzgiz.get());
    }
}
