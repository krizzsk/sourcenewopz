package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbry implements zzesa<zzbrx> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbtl> zzgam;
    private final zzesn<zzdot> zzgan;
    private final zzesn<ScheduledExecutorService> zzgao;

    private zzbry(zzesn<zzbtl> zzesn, zzesn<zzdot> zzesn2, zzesn<ScheduledExecutorService> zzesn3, zzesn<Executor> zzesn4) {
        this.zzgam = zzesn;
        this.zzgan = zzesn2;
        this.zzgao = zzesn3;
        this.zzeyl = zzesn4;
    }

    public static zzbry zzb(zzesn<zzbtl> zzesn, zzesn<zzdot> zzesn2, zzesn<ScheduledExecutorService> zzesn3, zzesn<Executor> zzesn4) {
        return new zzbry(zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        return new zzbrx(this.zzgam.get(), this.zzgan.get(), this.zzgao.get(), this.zzeyl.get());
    }
}
