package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdjc implements zzesa<zzdja> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzasp> zzfad;
    private final zzesn<ScheduledExecutorService> zzfty;

    public zzdjc(zzesn<zzasp> zzesn, zzesn<ScheduledExecutorService> zzesn2, zzesn<Context> zzesn3) {
        this.zzfad = zzesn;
        this.zzfty = zzesn2;
        this.zzeyq = zzesn3;
    }

    public final /* synthetic */ Object get() {
        return new zzdja(this.zzfad.get(), this.zzfty.get(), this.zzeyq.get());
    }
}
