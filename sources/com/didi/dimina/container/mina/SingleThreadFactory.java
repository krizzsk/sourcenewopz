package com.didi.dimina.container.mina;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/dimina/container/mina/SingleThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "()V", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DMSingleTaskExecutor.kt */
public final class SingleThreadFactory implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f16951a = new AtomicInteger(0);

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "[Thread-Saga]-" + this.f16951a);
    }
}
