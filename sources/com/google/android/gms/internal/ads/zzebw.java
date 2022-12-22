package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzebw extends zzebx implements zzebs, ScheduledExecutorService {
    private final ScheduledExecutorService zzidx;

    zzebw(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.zzidx = (ScheduledExecutorService) zzdyi.checkNotNull(scheduledExecutorService);
    }

    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzeby zzeby = new zzeby(runnable);
        return new zzebz(zzeby, this.zzidx.scheduleWithFixedDelay(zzeby, j, j2, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzeby zzeby = new zzeby(runnable);
        return new zzebz(zzeby, this.zzidx.scheduleAtFixedRate(zzeby, j, j2, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzece zzf = zzece.zzf(callable);
        return new zzebz(zzf, this.zzidx.schedule(zzf, j, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzece zza = zzece.zza(runnable, null);
        return new zzebz(zza, this.zzidx.schedule(zza, j, timeUnit));
    }
}
