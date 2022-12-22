package com.didiglobal.enginecore.cache.concurrent;

import com.didiglobal.enginecore.cache.C16883Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 #2\u00020\u0001:\u0003\"#$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u001c\u001a\u00020\u0016J\u0015\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001fJ\u0006\u0010 \u001a\u00020\tJ\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner;", "", "backend", "Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner$Backend;", "(Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner$Backend;)V", "getBackend", "()Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner$Backend;", "busyQueues", "", "Lcom/didiglobal/enginecore/cache/concurrent/TaskQueue;", "coordinatorWaiting", "", "coordinatorWakeUpAt", "", "nextQueueName", "", "readyQueues", "runnable", "Ljava/lang/Runnable;", "activeQueues", "", "afterRun", "", "task", "Lcom/didiglobal/enginecore/cache/concurrent/Task;", "delayNanos", "awaitTaskToRun", "beforeRun", "cancelAll", "kickCoordinator", "taskQueue", "kickCoordinator$engine_core_release", "newQueue", "runTask", "Backend", "Companion", "RealBackend", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TaskRunner.kt */
public final class TaskRunner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final TaskRunner INSTANCE = new TaskRunner(new RealBackend(C16883Util.threadFactory("XEngine TaskRunner", true)));
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final Logger f50146h;

    /* renamed from: a */
    private int f50147a = 10000;

    /* renamed from: b */
    private boolean f50148b;

    /* renamed from: c */
    private long f50149c;

    /* renamed from: d */
    private final List<TaskQueue> f50150d = new ArrayList();

    /* renamed from: e */
    private final List<TaskQueue> f50151e = new ArrayList();

    /* renamed from: f */
    private final Runnable f50152f = new TaskRunner$runnable$1(this);

    /* renamed from: g */
    private final Backend f50153g;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\tH&¨\u0006\u000e"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner$Backend;", "", "beforeTask", "", "taskRunner", "Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: TaskRunner.kt */
    public interface Backend {
        void beforeTask(TaskRunner taskRunner);

        void coordinatorNotify(TaskRunner taskRunner);

        void coordinatorWait(TaskRunner taskRunner, long j);

        void execute(Runnable runnable);

        long nanoTime();
    }

    public TaskRunner(Backend backend) {
        Intrinsics.checkParameterIsNotNull(backend, "backend");
        this.f50153g = backend;
    }

    public final Backend getBackend() {
        return this.f50153g;
    }

    public final void kickCoordinator$engine_core_release(TaskQueue taskQueue) {
        Intrinsics.checkParameterIsNotNull(taskQueue, "taskQueue");
        if (taskQueue.getActiveTask$engine_core_release() == null) {
            if (!taskQueue.getFutureTasks$engine_core_release().isEmpty()) {
                C16883Util.addIfAbsent(this.f50151e, taskQueue);
            } else {
                this.f50151e.remove(taskQueue);
            }
        }
        if (this.f50148b) {
            this.f50153g.coordinatorNotify(this);
        } else {
            this.f50153g.execute(this.f50152f);
        }
    }

    /* renamed from: a */
    private final void m36137a(Task task) {
        task.setNextExecuteNanoTime$engine_core_release(-1);
        TaskQueue queue$engine_core_release = task.getQueue$engine_core_release();
        if (queue$engine_core_release == null) {
            Intrinsics.throwNpe();
        }
        queue$engine_core_release.getFutureTasks$engine_core_release().remove(task);
        this.f50151e.remove(queue$engine_core_release);
        queue$engine_core_release.setActiveTask$engine_core_release(task);
        this.f50150d.add(queue$engine_core_release);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m36139b(Task task) {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        String name = currentThread.getName();
        currentThread.setName(task.getName());
        try {
            long runOnce = task.runOnce();
            synchronized (this) {
                m36138a(task, runOnce);
                Unit unit = Unit.INSTANCE;
            }
            currentThread.setName(name);
        } catch (Throwable th) {
            synchronized (this) {
                m36138a(task, -1);
                Unit unit2 = Unit.INSTANCE;
                currentThread.setName(name);
                throw th;
            }
        }
    }

    /* renamed from: a */
    private final void m36138a(Task task, long j) {
        TaskQueue queue$engine_core_release = task.getQueue$engine_core_release();
        if (queue$engine_core_release == null) {
            Intrinsics.throwNpe();
        }
        if (queue$engine_core_release.getActiveTask$engine_core_release() == task) {
            boolean cancelActiveTask$engine_core_release = queue$engine_core_release.getCancelActiveTask$engine_core_release();
            queue$engine_core_release.setCancelActiveTask$engine_core_release(false);
            queue$engine_core_release.setActiveTask$engine_core_release((Task) null);
            this.f50150d.remove(queue$engine_core_release);
            if (j != -1 && !cancelActiveTask$engine_core_release && !queue$engine_core_release.getShutdown$engine_core_release()) {
                queue$engine_core_release.scheduleAndDecide$engine_core_release(task, j, true);
            }
            if (!queue$engine_core_release.getFutureTasks$engine_core_release().isEmpty()) {
                this.f50151e.add(queue$engine_core_release);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0090 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didiglobal.enginecore.cache.concurrent.Task awaitTaskToRun() {
        /*
            r15 = this;
        L_0x0000:
            java.util.List<com.didiglobal.enginecore.cache.concurrent.TaskQueue> r0 = r15.f50151e
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            com.didiglobal.enginecore.cache.concurrent.TaskRunner$Backend r0 = r15.f50153g
            long r2 = r0.nanoTime()
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r0 = r1
            com.didiglobal.enginecore.cache.concurrent.Task r0 = (com.didiglobal.enginecore.cache.concurrent.Task) r0
            java.util.List<com.didiglobal.enginecore.cache.concurrent.TaskQueue> r6 = r15.f50151e
            java.util.Iterator r6 = r6.iterator()
        L_0x001e:
            boolean r7 = r6.hasNext()
            r8 = 1
            r9 = 0
            if (r7 == 0) goto L_0x0050
            java.lang.Object r7 = r6.next()
            com.didiglobal.enginecore.cache.concurrent.TaskQueue r7 = (com.didiglobal.enginecore.cache.concurrent.TaskQueue) r7
            java.util.List r7 = r7.getFutureTasks$engine_core_release()
            java.lang.Object r7 = r7.get(r9)
            com.didiglobal.enginecore.cache.concurrent.Task r7 = (com.didiglobal.enginecore.cache.concurrent.Task) r7
            long r10 = r7.getNextExecuteNanoTime$engine_core_release()
            long r10 = r10 - r2
            r12 = 0
            long r10 = java.lang.Math.max(r12, r10)
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x004a
            long r4 = java.lang.Math.min(r10, r4)
            goto L_0x001e
        L_0x004a:
            if (r0 == 0) goto L_0x004e
            r6 = 1
            goto L_0x0051
        L_0x004e:
            r0 = r7
            goto L_0x001e
        L_0x0050:
            r6 = 0
        L_0x0051:
            if (r0 == 0) goto L_0x006f
            r15.m36137a(r0)
            if (r6 != 0) goto L_0x0067
            boolean r1 = r15.f50148b
            if (r1 != 0) goto L_0x006e
            java.util.List<com.didiglobal.enginecore.cache.concurrent.TaskQueue> r1 = r15.f50151e
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r8
            if (r1 == 0) goto L_0x006e
        L_0x0067:
            com.didiglobal.enginecore.cache.concurrent.TaskRunner$Backend r1 = r15.f50153g
            java.lang.Runnable r2 = r15.f50152f
            r1.execute(r2)
        L_0x006e:
            return r0
        L_0x006f:
            boolean r0 = r15.f50148b
            if (r0 == 0) goto L_0x0080
            long r6 = r15.f50149c
            long r6 = r6 - r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x007f
            com.didiglobal.enginecore.cache.concurrent.TaskRunner$Backend r0 = r15.f50153g
            r0.coordinatorNotify(r15)
        L_0x007f:
            return r1
        L_0x0080:
            r15.f50148b = r8
            long r2 = r2 + r4
            r15.f50149c = r2
            com.didiglobal.enginecore.cache.concurrent.TaskRunner$Backend r0 = r15.f50153g     // Catch:{ InterruptedException -> 0x0090 }
            r0.coordinatorWait(r15, r4)     // Catch:{ InterruptedException -> 0x0090 }
        L_0x008a:
            r15.f50148b = r9
            goto L_0x0000
        L_0x008e:
            r0 = move-exception
            goto L_0x0094
        L_0x0090:
            r15.cancelAll()     // Catch:{ all -> 0x008e }
            goto L_0x008a
        L_0x0094:
            r15.f50148b = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.concurrent.TaskRunner.awaitTaskToRun():com.didiglobal.enginecore.cache.concurrent.Task");
    }

    public final TaskQueue newQueue() {
        int i;
        synchronized (this) {
            i = this.f50147a;
            this.f50147a = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i);
        return new TaskQueue(this, sb.toString());
    }

    public final List<TaskQueue> activeQueues() {
        List<TaskQueue> plus;
        synchronized (this) {
            plus = CollectionsKt.plus(this.f50150d, this.f50151e);
        }
        return plus;
    }

    public final void cancelAll() {
        for (int size = this.f50150d.size() - 1; size >= 0; size--) {
            this.f50150d.get(size).cancelAllAndDecide$engine_core_release();
        }
        for (int size2 = this.f50151e.size() - 1; size2 >= 0; size2--) {
            TaskQueue taskQueue = this.f50151e.get(size2);
            taskQueue.cancelAllAndDecide$engine_core_release();
            if (taskQueue.getFutureTasks$engine_core_release().isEmpty()) {
                this.f50151e.remove(size2);
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner$RealBackend;", "Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner$Backend;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(Ljava/util/concurrent/ThreadFactory;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "beforeTask", "", "taskRunner", "Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "shutdown", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: TaskRunner.kt */
    public static final class RealBackend implements Backend {
        private final ThreadPoolExecutor executor;

        public void beforeTask(TaskRunner taskRunner) {
            Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
        }

        public RealBackend(ThreadFactory threadFactory) {
            Intrinsics.checkParameterIsNotNull(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        public long nanoTime() {
            return System.nanoTime();
        }

        public void coordinatorWait(TaskRunner taskRunner, long j) throws InterruptedException {
            Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                taskRunner.wait(j2, (int) j3);
            }
        }

        public void execute(Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(runnable, "runnable");
            this.executor.execute(runnable);
        }

        public final void shutdown() {
            this.executor.shutdown();
        }

        public void coordinatorNotify(TaskRunner taskRunner) {
            Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
            taskRunner.notify();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner$Companion;", "", "()V", "INSTANCE", "Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: TaskRunner.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger getLogger() {
            return TaskRunner.f50146h;
        }
    }

    static {
        Logger logger = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkExpressionValueIsNotNull(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f50146h = logger;
    }
}
