package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbln implements zzesa<zzbli> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzamx> zzfve;
    private final zzesn<zzblg> zzfvf;
    private final zzesn<zzbld> zzfvg;
    private final zzesn<Clock> zzfvh;

    private zzbln(zzesn<zzamx> zzesn, zzesn<zzblg> zzesn2, zzesn<Executor> zzesn3, zzesn<zzbld> zzesn4, zzesn<Clock> zzesn5) {
        this.zzfve = zzesn;
        this.zzfvf = zzesn2;
        this.zzeyl = zzesn3;
        this.zzfvg = zzesn4;
        this.zzfvh = zzesn5;
    }

    public static zzbln zza(zzesn<zzamx> zzesn, zzesn<zzblg> zzesn2, zzesn<Executor> zzesn3, zzesn<zzbld> zzesn4, zzesn<Clock> zzesn5) {
        return new zzbln(zzesn, zzesn2, zzesn3, zzesn4, zzesn5);
    }

    public final /* synthetic */ Object get() {
        return new zzbli(this.zzfve.get(), this.zzfvf.get(), this.zzeyl.get(), this.zzfvg.get(), this.zzfvh.get());
    }
}
