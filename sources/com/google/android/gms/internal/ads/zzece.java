package com.google.android.gms.internal.ads;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzece<V> extends zzebb<V> implements RunnableFuture<V> {
    private volatile zzebp<?> zziee;

    static <V> zzece<V> zzf(Callable<V> callable) {
        return new zzece<>(callable);
    }

    static <V> zzece<V> zza(Runnable runnable, @NullableDecl V v) {
        return new zzece<>(Executors.callable(runnable, v));
    }

    private zzece(Callable<V> callable) {
        this.zziee = new zzecg(this, callable);
    }

    zzece(zzeas<V> zzeas) {
        this.zziee = new zzech(this, zzeas);
    }

    public final void run() {
        zzebp<?> zzebp = this.zziee;
        if (zzebp != null) {
            zzebp.run();
        }
        this.zziee = null;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        zzebp<?> zzebp;
        super.afterDone();
        if (wasInterrupted() && (zzebp = this.zziee) != null) {
            zzebp.interruptTask();
        }
        this.zziee = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzebp<?> zzebp = this.zziee;
        if (zzebp == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(zzebp);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
        sb.append("task=[");
        sb.append(valueOf);
        sb.append(Const.jaRight);
        return sb.toString();
    }
}
