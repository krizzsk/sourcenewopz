package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdik implements zzesa<zzdig> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzazo> zzfad;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzazs> zzhdo;
    private final zzesn<Integer> zzhgz;

    public zzdik(zzesn<zzazo> zzesn, zzesn<Integer> zzesn2, zzesn<Context> zzesn3, zzesn<zzazs> zzesn4, zzesn<ScheduledExecutorService> zzesn5, zzesn<Executor> zzesn6) {
        this.zzfad = zzesn;
        this.zzhgz = zzesn2;
        this.zzeyq = zzesn3;
        this.zzhdo = zzesn4;
        this.zzfty = zzesn5;
        this.zzeyl = zzesn6;
    }

    public final /* synthetic */ Object get() {
        return new zzdig(this.zzfad.get(), this.zzhgz.get().intValue(), this.zzeyq.get(), this.zzhdo.get(), this.zzfty.get(), this.zzeyl.get());
    }
}
