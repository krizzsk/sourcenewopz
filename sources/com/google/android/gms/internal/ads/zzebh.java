package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebn;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzebh extends zzebo {
    public static <V> zzebt<V> zzag(@NullableDecl V v) {
        if (v == null) {
            return zzebn.zzidr;
        }
        return new zzebn(v);
    }

    public static <V> zzebt<V> immediateFailedFuture(Throwable th) {
        zzdyi.checkNotNull(th);
        return new zzebn.zza(th);
    }

    public static <O> zzebt<O> zza(Callable<O> callable, Executor executor) {
        zzece<O> zzf = zzece.zzf(callable);
        executor.execute(zzf);
        return zzf;
    }

    public static <O> zzebt<O> zza(zzeas<O> zzeas, Executor executor) {
        zzece zzece = new zzece(zzeas);
        executor.execute(zzece);
        return zzece;
    }

    public static <V, X extends Throwable> zzebt<V> zzb(zzebt<? extends V> zzebt, Class<X> cls, zzear<? super X, ? extends V> zzear, Executor executor) {
        return zzead.zza(zzebt, cls, zzear, executor);
    }

    public static <V> zzebt<V> zza(zzebt<V> zzebt, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (zzebt.isDone()) {
            return zzebt;
        }
        return zzeca.zzb(zzebt, j, timeUnit, scheduledExecutorService);
    }

    public static <I, O> zzebt<O> zzb(zzebt<I> zzebt, zzear<? super I, ? extends O> zzear, Executor executor) {
        return zzeak.zza(zzebt, zzear, executor);
    }

    public static <I, O> zzebt<O> zzb(zzebt<I> zzebt, zzdxw<? super I, ? extends O> zzdxw, Executor executor) {
        return zzeak.zza(zzebt, zzdxw, executor);
    }

    public static <V> zzebt<List<V>> zzi(Iterable<? extends zzebt<? extends V>> iterable) {
        return new zzeat(zzdza.zzh(iterable), true);
    }

    @SafeVarargs
    public static <V> zzebm<V> zza(zzebt<? extends V>... zzebtArr) {
        return new zzebm<>(false, zzdza.zzb((E[]) zzebtArr), (zzebk) null);
    }

    public static <V> zzebm<V> zzj(Iterable<? extends zzebt<? extends V>> iterable) {
        return new zzebm<>(false, zzdza.zzh(iterable), (zzebk) null);
    }

    @SafeVarargs
    public static <V> zzebm<V> zzb(zzebt<? extends V>... zzebtArr) {
        return new zzebm<>(true, zzdza.zzb((E[]) zzebtArr), (zzebk) null);
    }

    public static <V> zzebm<V> zzk(Iterable<? extends zzebt<? extends V>> iterable) {
        return new zzebm<>(true, zzdza.zzh(iterable), (zzebk) null);
    }

    public static <V> void zza(zzebt<V> zzebt, zzebi<? super V> zzebi, Executor executor) {
        zzdyi.checkNotNull(zzebi);
        zzebt.addListener(new zzebj(zzebt, zzebi), executor);
    }

    public static <V> V zza(Future<V> future) throws ExecutionException {
        if (future.isDone()) {
            return zzeci.getUninterruptibly(future);
        }
        throw new IllegalStateException(zzdyq.zzb("Future was expected to be done: %s", future));
    }

    public static <V> V zzb(Future<V> future) {
        zzdyi.checkNotNull(future);
        try {
            return zzeci.getUninterruptibly(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzeaz((Error) cause);
            }
            throw new zzecj(cause);
        }
    }
}
