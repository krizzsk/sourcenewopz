package com.didiglobal.enginecore.cache.concurrent;

import com.adyen.checkout.components.status.api.StatusResponseUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00013B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\r\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0002\b$J5\u0010%\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u000e2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0*H\bJ\u0006\u0010+\u001a\u00020,J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020'J+\u0010-\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0004\u0010)\u001a\b\u0012\u0004\u0012\u00020'0*H\bJ%\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u00100\u001a\u00020\u000eH\u0000¢\u0006\u0002\b1J\u0006\u0010\u001c\u001a\u00020\"J\b\u00102\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00064"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/concurrent/TaskQueue;", "", "taskRunner", "Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner;", "name", "", "(Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner;Ljava/lang/String;)V", "activeTask", "Lcom/didiglobal/enginecore/cache/concurrent/Task;", "getActiveTask$engine_core_release", "()Lcom/didiglobal/enginecore/cache/concurrent/Task;", "setActiveTask$engine_core_release", "(Lcom/didiglobal/enginecore/cache/concurrent/Task;)V", "cancelActiveTask", "", "getCancelActiveTask$engine_core_release", "()Z", "setCancelActiveTask$engine_core_release", "(Z)V", "futureTasks", "", "getFutureTasks$engine_core_release", "()Ljava/util/List;", "getName$engine_core_release", "()Ljava/lang/String;", "scheduledTasks", "", "getScheduledTasks", "shutdown", "getShutdown$engine_core_release", "setShutdown$engine_core_release", "getTaskRunner$engine_core_release", "()Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner;", "cancelAll", "", "cancelAllAndDecide", "cancelAllAndDecide$engine_core_release", "execute", "delayNanos", "", "cancelable", "block", "Lkotlin/Function0;", "idleLatch", "Ljava/util/concurrent/CountDownLatch;", "schedule", "task", "scheduleAndDecide", "recurrence", "scheduleAndDecide$engine_core_release", "toString", "AwaitIdleTask", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TaskQueue.kt */
public final class TaskQueue {

    /* renamed from: a */
    private boolean f50140a;

    /* renamed from: b */
    private Task f50141b;

    /* renamed from: c */
    private final List<Task> f50142c = new ArrayList();

    /* renamed from: d */
    private boolean f50143d;

    /* renamed from: e */
    private final TaskRunner f50144e;

    /* renamed from: f */
    private final String f50145f;

    public TaskQueue(TaskRunner taskRunner, String str) {
        Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics.checkParameterIsNotNull(str, "name");
        this.f50144e = taskRunner;
        this.f50145f = str;
    }

    public final TaskRunner getTaskRunner$engine_core_release() {
        return this.f50144e;
    }

    public final String getName$engine_core_release() {
        return this.f50145f;
    }

    public final boolean getShutdown$engine_core_release() {
        return this.f50140a;
    }

    public final void setShutdown$engine_core_release(boolean z) {
        this.f50140a = z;
    }

    public final Task getActiveTask$engine_core_release() {
        return this.f50141b;
    }

    public final void setActiveTask$engine_core_release(Task task) {
        this.f50141b = task;
    }

    public final List<Task> getFutureTasks$engine_core_release() {
        return this.f50142c;
    }

    public final boolean getCancelActiveTask$engine_core_release() {
        return this.f50143d;
    }

    public final void setCancelActiveTask$engine_core_release(boolean z) {
        this.f50143d = z;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> list;
        synchronized (this.f50144e) {
            list = CollectionsKt.toList(this.f50142c);
        }
        return list;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        taskQueue.schedule(task, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void schedule(com.didiglobal.enginecore.cache.concurrent.Task r3, long r4) {
        /*
            r2 = this;
            java.lang.String r0 = "task"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            com.didiglobal.enginecore.cache.concurrent.TaskRunner r0 = r2.f50144e
            monitor-enter(r0)
            boolean r1 = r2.f50140a     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x0042
            boolean r4 = r3.getCancelable()     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x0027
            com.didiglobal.enginecore.cache.concurrent.TaskRunner$Companion r4 = com.didiglobal.enginecore.cache.concurrent.TaskRunner.Companion     // Catch:{ all -> 0x0052 }
            java.util.logging.Logger r4 = r4.getLogger()     // Catch:{ all -> 0x0052 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0052 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x0025
            java.lang.String r4 = "schedule canceled (queue is shutdown)"
            com.didiglobal.enginecore.cache.concurrent.TaskLoggerKt.m36136a(r3, r2, r4)     // Catch:{ all -> 0x0052 }
        L_0x0025:
            monitor-exit(r0)
            return
        L_0x0027:
            com.didiglobal.enginecore.cache.concurrent.TaskRunner$Companion r4 = com.didiglobal.enginecore.cache.concurrent.TaskRunner.Companion     // Catch:{ all -> 0x0052 }
            java.util.logging.Logger r4 = r4.getLogger()     // Catch:{ all -> 0x0052 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0052 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x003a
            java.lang.String r4 = "schedule failed (queue is shutdown)"
            com.didiglobal.enginecore.cache.concurrent.TaskLoggerKt.m36136a(r3, r2, r4)     // Catch:{ all -> 0x0052 }
        L_0x003a:
            java.util.concurrent.RejectedExecutionException r3 = new java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x0052 }
            r3.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ all -> 0x0052 }
            throw r3     // Catch:{ all -> 0x0052 }
        L_0x0042:
            r1 = 0
            boolean r3 = r2.scheduleAndDecide$engine_core_release(r3, r4, r1)     // Catch:{ all -> 0x0052 }
            if (r3 == 0) goto L_0x004e
            com.didiglobal.enginecore.cache.concurrent.TaskRunner r3 = r2.f50144e     // Catch:{ all -> 0x0052 }
            r3.kickCoordinator$engine_core_release(r2)     // Catch:{ all -> 0x0052 }
        L_0x004e:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0052 }
            monitor-exit(r0)
            return
        L_0x0052:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.concurrent.TaskQueue.schedule(com.didiglobal.enginecore.cache.concurrent.Task, long):void");
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        taskQueue.schedule(new TaskQueue$schedule$2(function0, str, str), j);
    }

    public final void schedule(String str, long j, Function0<Long> function0) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        schedule(new TaskQueue$schedule$2(function0, str, str), j);
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        boolean z2 = (i & 4) != 0 ? true : z;
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        taskQueue.schedule(new TaskQueue$execute$1(function0, str, z2, str, z2), j);
    }

    public final void execute(String str, long j, boolean z, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        schedule(new TaskQueue$execute$1(function0, str, z, str, z), j);
    }

    public final CountDownLatch idleLatch() {
        synchronized (this.f50144e) {
            if (this.f50141b != null || !this.f50142c.isEmpty()) {
                Task task = this.f50141b;
                if (task instanceof AwaitIdleTask) {
                    CountDownLatch latch = ((AwaitIdleTask) task).getLatch();
                    return latch;
                }
                for (Task next : this.f50142c) {
                    if (next instanceof AwaitIdleTask) {
                        CountDownLatch latch2 = ((AwaitIdleTask) next).getLatch();
                        return latch2;
                    }
                }
                AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
                if (scheduleAndDecide$engine_core_release(awaitIdleTask, 0, false)) {
                    this.f50144e.kickCoordinator$engine_core_release(this);
                }
                CountDownLatch latch3 = awaitIdleTask.getLatch();
                return latch3;
            }
            CountDownLatch countDownLatch = new CountDownLatch(0);
            return countDownLatch;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/concurrent/TaskQueue$AwaitIdleTask;", "Lcom/didiglobal/enginecore/cache/concurrent/Task;", "()V", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "runOnce", "", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: TaskQueue.kt */
    private static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch = new CountDownLatch(1);

        public AwaitIdleTask() {
            super("XEngine awaitIdle", false);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        public long runOnce() {
            this.latch.countDown();
            return -1;
        }
    }

    public final boolean scheduleAndDecide$engine_core_release(Task task, long j, boolean z) {
        String str;
        Intrinsics.checkParameterIsNotNull(task, "task");
        task.initQueue$engine_core_release(this);
        long nanoTime = this.f50144e.getBackend().nanoTime();
        long j2 = nanoTime + j;
        int indexOf = this.f50142c.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime$engine_core_release() <= j2) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.m36136a(task, this, "already scheduled");
                }
                return false;
            }
            this.f50142c.remove(indexOf);
        }
        task.setNextExecuteNanoTime$engine_core_release(j2);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            if (z) {
                str = "run again after " + TaskLoggerKt.formatDuration(j2 - nanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j2 - nanoTime);
            }
            TaskLoggerKt.m36136a(task, this, str);
        }
        Iterator<Task> it = this.f50142c.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().getNextExecuteNanoTime$engine_core_release() - nanoTime > j) {
                break;
            }
            i++;
        }
        if (i == -1) {
            i = this.f50142c.size();
        }
        this.f50142c.add(i, task);
        if (i == 0) {
            return true;
        }
        return false;
    }

    public final void cancelAll() {
        synchronized (this.f50144e) {
            if (cancelAllAndDecide$engine_core_release()) {
                this.f50144e.kickCoordinator$engine_core_release(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void shutdown() {
        synchronized (this.f50144e) {
            this.f50140a = true;
            if (cancelAllAndDecide$engine_core_release()) {
                this.f50144e.kickCoordinator$engine_core_release(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean cancelAllAndDecide$engine_core_release() {
        Task task = this.f50141b;
        if (task != null) {
            if (task == null) {
                Intrinsics.throwNpe();
            }
            if (task.getCancelable()) {
                this.f50143d = true;
            }
        }
        boolean z = false;
        for (int size = this.f50142c.size() - 1; size >= 0; size--) {
            if (this.f50142c.get(size).getCancelable()) {
                Task task2 = this.f50142c.get(size);
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.m36136a(task2, this, StatusResponseUtils.RESULT_CANCELED);
                }
                this.f50142c.remove(size);
                z = true;
            }
        }
        return z;
    }

    public String toString() {
        return this.f50145f;
    }
}
