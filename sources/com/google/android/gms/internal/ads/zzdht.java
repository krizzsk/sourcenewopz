package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdht implements zzesa<zzdhs> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzazo> zzfad;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<Integer> zzhgz;

    public zzdht(zzesn<zzazo> zzesn, zzesn<Context> zzesn2, zzesn<ScheduledExecutorService> zzesn3, zzesn<Executor> zzesn4, zzesn<Integer> zzesn5) {
        this.zzfad = zzesn;
        this.zzeyq = zzesn2;
        this.zzfty = zzesn3;
        this.zzeyl = zzesn4;
        this.zzhgz = zzesn5;
    }

    public final /* synthetic */ Object get() {
        return new zzdhs(this.zzfad.get(), this.zzeyq.get(), this.zzfty.get(), this.zzeyl.get(), this.zzhgz.get().intValue());
    }
}
