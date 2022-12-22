package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
class zzebx extends zzeai {
    private final ExecutorService zzidy;

    zzebx(ExecutorService executorService) {
        this.zzidy = (ExecutorService) zzdyi.checkNotNull(executorService);
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.zzidy.awaitTermination(j, timeUnit);
    }

    public final boolean isShutdown() {
        return this.zzidy.isShutdown();
    }

    public final boolean isTerminated() {
        return this.zzidy.isTerminated();
    }

    public final void shutdown() {
        this.zzidy.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.zzidy.shutdownNow();
    }

    public final void execute(Runnable runnable) {
        this.zzidy.execute(runnable);
    }
}
