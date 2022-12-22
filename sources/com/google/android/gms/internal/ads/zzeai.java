package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzeai extends AbstractExecutorService implements zzebs {
    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return zzece.zza(runnable, t);
    }

    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return zzece.zzf(callable);
    }

    /* renamed from: zzg */
    public final zzebt<?> submit(Runnable runnable) {
        return (zzebt) super.submit(runnable);
    }

    /* renamed from: zze */
    public final <T> zzebt<T> submit(Callable<T> callable) {
        return (zzebt) super.submit(callable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @NullableDecl Object obj) {
        return (zzebt) super.submit(runnable, obj);
    }
}
