package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
abstract class zzeax<T> extends zzebp<T> {
    private final Executor zzidi;
    private final /* synthetic */ zzeav zzidj;

    zzeax(zzeav zzeav, Executor executor) {
        this.zzidj = zzeav;
        this.zzidi = (Executor) zzdyi.checkNotNull(executor);
    }

    /* access modifiers changed from: package-private */
    public abstract void setValue(T t);

    /* access modifiers changed from: package-private */
    public final boolean isDone() {
        return this.zzidj.isDone();
    }

    /* access modifiers changed from: package-private */
    public final void execute() {
        try {
            this.zzidi.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzidj.setException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(T t, Throwable th) {
        zzeax unused = this.zzidj.zzidh = null;
        if (th == null) {
            setValue(t);
        } else if (th instanceof ExecutionException) {
            this.zzidj.setException(th.getCause());
        } else if (th instanceof CancellationException) {
            this.zzidj.cancel(false);
        } else {
            this.zzidj.setException(th);
        }
    }
}
