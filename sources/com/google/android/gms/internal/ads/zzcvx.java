package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcvx implements zzesa<zzcvu> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzccf> zzgvz;

    public zzcvx(zzesn<Context> zzesn, zzesn<zzccf> zzesn2, zzesn<Executor> zzesn3) {
        this.zzeyq = zzesn;
        this.zzgvz = zzesn2;
        this.zzfxf = zzesn3;
    }

    public final /* synthetic */ Object get() {
        return new zzcvu(this.zzeyq.get(), this.zzgvz.get(), this.zzfxf.get());
    }
}
