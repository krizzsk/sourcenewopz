package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcxt implements zzesa<zzcxm> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzcis> zzgvz;

    public zzcxt(zzesn<Context> zzesn, zzesn<Executor> zzesn2, zzesn<zzcis> zzesn3) {
        this.zzeyq = zzesn;
        this.zzfxf = zzesn2;
        this.zzgvz = zzesn3;
    }

    public final /* synthetic */ Object get() {
        return new zzcxm(this.zzeyq.get(), this.zzfxf.get(), this.zzgvz.get());
    }
}
