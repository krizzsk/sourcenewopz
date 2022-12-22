package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdst<E, V> implements zzebt<V> {
    private final E zzhsw;
    private final String zzhsx;
    private final zzebt<V> zzhsy;

    public zzdst(E e, String str, zzebt<V> zzebt) {
        this.zzhsw = e;
        this.zzhsx = str;
        this.zzhsy = zzebt;
    }

    public final void addListener(Runnable runnable, Executor executor) {
        this.zzhsy.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.zzhsy.cancel(z);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.zzhsy.get();
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzhsy.get(j, timeUnit);
    }

    public final boolean isCancelled() {
        return this.zzhsy.isCancelled();
    }

    public final boolean isDone() {
        return this.zzhsy.isDone();
    }

    public final E zzayg() {
        return this.zzhsw;
    }

    public final String zzayh() {
        return this.zzhsx;
    }

    public final String toString() {
        String str = this.zzhsx;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }
}
