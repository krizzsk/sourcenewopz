package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzebe<V> extends zzebc<V> {
    private final zzebt<V> zzidn;

    zzebe(zzebt<V> zzebt) {
        this.zzidn = (zzebt) zzdyi.checkNotNull(zzebt);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        this.zzidn.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.zzidn.cancel(z);
    }

    public final boolean isCancelled() {
        return this.zzidn.isCancelled();
    }

    public final boolean isDone() {
        return this.zzidn.isDone();
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.zzidn.get();
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzidn.get(j, timeUnit);
    }

    public final String toString() {
        return this.zzidn.toString();
    }
}
