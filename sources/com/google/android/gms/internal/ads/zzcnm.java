package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcnm implements zzesa<zzcna> {
    private final zzesn<zzckb> zzeyj;
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcmk> zzezp;
    private final zzesn<zzbyr> zzezt;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<Executor> zzfxf;
    private final zzesn<Context> zzgpv;
    private final zzesn<WeakReference<Context>> zzgpw;

    public zzcnm(zzesn<Executor> zzesn, zzesn<Context> zzesn2, zzesn<WeakReference<Context>> zzesn3, zzesn<Executor> zzesn4, zzesn<zzckb> zzesn5, zzesn<ScheduledExecutorService> zzesn6, zzesn<zzcmk> zzesn7, zzesn<zzbar> zzesn8, zzesn<zzbyr> zzesn9) {
        this.zzfxf = zzesn;
        this.zzgpv = zzesn2;
        this.zzgpw = zzesn3;
        this.zzeyl = zzesn4;
        this.zzeyj = zzesn5;
        this.zzfty = zzesn6;
        this.zzezp = zzesn7;
        this.zzfvj = zzesn8;
        this.zzezt = zzesn9;
    }

    public final /* synthetic */ Object get() {
        return new zzcna(this.zzfxf.get(), this.zzgpv.get(), this.zzgpw.get(), this.zzeyl.get(), this.zzeyj.get(), this.zzfty.get(), this.zzezp.get(), this.zzfvj.get(), this.zzezt.get());
    }
}
