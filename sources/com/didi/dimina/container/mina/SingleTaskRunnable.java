package com.didi.dimina.container.mina;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/dimina/container/mina/SingleTaskRunnable;", "T", "Ljava/lang/Runnable;", "task", "Lcom/didi/dimina/container/mina/ITask;", "(Lcom/didi/dimina/container/mina/ITask;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "result", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getTask", "()Lcom/didi/dimina/container/mina/ITask;", "run", "", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DMSingleTaskExecutor.kt */
public final class SingleTaskRunnable<T> implements Runnable {

    /* renamed from: a */
    private final Handler f16948a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private T f16949b;

    /* renamed from: c */
    private final ITask<T> f16950c;

    public SingleTaskRunnable(ITask<T> iTask) {
        this.f16950c = iTask;
    }

    public final ITask<T> getTask() {
        return this.f16950c;
    }

    public final Handler getHandler() {
        return this.f16948a;
    }

    public final T getResult() {
        return this.f16949b;
    }

    public final void setResult(T t) {
        this.f16949b = t;
    }

    public void run() {
        ITask<T> iTask = this.f16950c;
        this.f16949b = iTask != null ? iTask.runTaskInBackground() : null;
        this.f16948a.post(new SingleTaskRunnable$run$1(this));
    }
}
