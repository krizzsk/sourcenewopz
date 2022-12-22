package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzblm implements zzesa<zzbld> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzqt> zzfvc;
    private final zzesn<zzamx> zzfvd;

    private zzblm(zzesn<zzqt> zzesn, zzesn<zzamx> zzesn2, zzesn<Executor> zzesn3) {
        this.zzfvc = zzesn;
        this.zzfvd = zzesn2;
        this.zzeyl = zzesn3;
    }

    public static zzblm zza(zzesn<zzqt> zzesn, zzesn<zzamx> zzesn2, zzesn<Executor> zzesn3) {
        return new zzblm(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return (zzbld) zzesg.zzbd(new zzbld(this.zzfvc.get().getUniqueId(), this.zzfvd.get(), this.zzeyl.get()));
    }
}
