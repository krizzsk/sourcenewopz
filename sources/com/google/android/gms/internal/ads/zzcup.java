package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcup implements zzesa<zzcuk> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzcbj> zzgvz;
    private final zzesn<zzdor> zzgww;

    public zzcup(zzesn<Context> zzesn, zzesn<Executor> zzesn2, zzesn<zzcbj> zzesn3, zzesn<zzdor> zzesn4) {
        this.zzeyq = zzesn;
        this.zzfxf = zzesn2;
        this.zzgvz = zzesn3;
        this.zzgww = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzcuk(this.zzeyq.get(), this.zzfxf.get(), this.zzgvz.get(), this.zzgww.get());
    }
}
