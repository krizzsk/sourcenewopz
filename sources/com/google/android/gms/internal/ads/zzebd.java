package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzebd<V> extends zzdyt implements Future<V> {
    protected zzebd() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbbc */
    public abstract Future<? extends V> zzbae();

    public boolean cancel(boolean z) {
        return zzbae().cancel(z);
    }

    public boolean isCancelled() {
        return zzbae().isCancelled();
    }

    public boolean isDone() {
        return zzbae().isDone();
    }

    public V get() throws InterruptedException, ExecutionException {
        return zzbae().get();
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return zzbae().get(j, timeUnit);
    }
}
