package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbpn {
    private final Executor executor;
    private volatile boolean zzafk = true;
    private final ScheduledExecutorService zzftq;
    private final zzebt<zzbpi> zzfyv;

    public zzbpn(Executor executor2, ScheduledExecutorService scheduledExecutorService, zzebt<zzbpi> zzebt) {
        this.executor = executor2;
        this.zzftq = scheduledExecutorService;
        this.zzfyv = zzebt;
    }

    public final void zza(zzebi<zzbpc> zzebi) {
        zzebh.zza(this.zzfyv, new zzbpq(this, zzebi), this.executor);
    }

    /* access modifiers changed from: private */
    public final void zza(List<? extends zzebt<? extends zzbpc>> list, zzebi<zzbpc> zzebi) {
        if (list == null || list.isEmpty()) {
            this.executor.execute(new zzbpm(zzebi));
            return;
        }
        zzebt<O> zzag = zzebh.zzag(null);
        for (zzebt zzbpo : list) {
            zzag = zzebh.zzb(zzebh.zzb(zzag, Throwable.class, new zzbpp(zzebi), this.executor), new zzbpo(this, zzebi, zzbpo), this.executor);
        }
        zzebh.zza(zzag, new zzbpt(this, zzebi), this.executor);
    }

    public final boolean isLoading() {
        return this.zzafk;
    }

    /* access modifiers changed from: private */
    public final void zzalo() {
        zzbat.zzeki.execute(new zzbpr(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzalp() {
        this.zzafk = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzebi zzebi, zzebt zzebt, zzbpc zzbpc) throws Exception {
        if (zzbpc != null) {
            zzebi.onSuccess(zzbpc);
        }
        return zzebh.zza(zzebt, zzadw.zzdgd.get().longValue(), TimeUnit.MILLISECONDS, this.zzftq);
    }
}
