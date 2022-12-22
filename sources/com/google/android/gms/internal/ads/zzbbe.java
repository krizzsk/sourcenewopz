package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbbe<T> implements zzebt<T> {
    private final zzecb<T> zzekp = zzecb.zzbbf();

    public final boolean set(T t) {
        return zzaw(this.zzekp.set(t));
    }

    public final boolean setException(Throwable th) {
        return zzaw(this.zzekp.setException(th));
    }

    private static boolean zzaw(boolean z) {
        if (!z) {
            zzr.zzkz().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.zzekp.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        return this.zzekp.cancel(z);
    }

    public boolean isCancelled() {
        return this.zzekp.isCancelled();
    }

    public boolean isDone() {
        return this.zzekp.isDone();
    }

    public T get() throws ExecutionException, InterruptedException {
        return this.zzekp.get();
    }

    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zzekp.get(j, timeUnit);
    }
}
