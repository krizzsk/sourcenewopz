package com.didi.dimina.container.mina;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nJ0\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J8\u0010\u0010\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/dimina/container/mina/DMSingleTaskExecutor;", "", "()V", "singleTaskExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "execute", "", "T", "task", "Lcom/didi/dimina/container/mina/ITask;", "schedule", "delay", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "scheduleAtFixedRate", "period", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DMSingleTaskExecutor.kt */
public final class DMSingleTaskExecutor {
    public static final DMSingleTaskExecutor INSTANCE = new DMSingleTaskExecutor();

    /* renamed from: a */
    private static final ScheduledExecutorService f16939a = Executors.newSingleThreadScheduledExecutor(new SingleThreadFactory());

    public final <T> void schedule(ITask<T> iTask, long j) {
        schedule$default(this, iTask, j, (TimeUnit) null, 4, (Object) null);
    }

    public final <T> void scheduleAtFixedRate(ITask<T> iTask, long j, long j2) {
        scheduleAtFixedRate$default(this, iTask, j, j2, (TimeUnit) null, 8, (Object) null);
    }

    private DMSingleTaskExecutor() {
    }

    public final <T> void execute(ITask<T> iTask) {
        Intrinsics.checkParameterIsNotNull(iTask, "task");
        f16939a.execute(new SingleTaskRunnable(iTask));
    }

    public static /* synthetic */ void schedule$default(DMSingleTaskExecutor dMSingleTaskExecutor, ITask iTask, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 4) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        dMSingleTaskExecutor.schedule(iTask, j, timeUnit);
    }

    public final <T> void schedule(ITask<T> iTask, long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        f16939a.schedule(new SingleTaskRunnable(iTask), j, timeUnit);
    }

    public static /* synthetic */ void scheduleAtFixedRate$default(DMSingleTaskExecutor dMSingleTaskExecutor, ITask iTask, long j, long j2, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 8) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        dMSingleTaskExecutor.scheduleAtFixedRate(iTask, j, j2, timeUnit);
    }

    public final <T> void scheduleAtFixedRate(ITask<T> iTask, long j, long j2, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        f16939a.scheduleAtFixedRate(new SingleTaskRunnable(iTask), j, j2, timeUnit);
    }
}
