package com.didi.sdk.schedule;

import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ScheduleTaskHelper {

    /* renamed from: a */
    private static final int f37146a;

    /* renamed from: b */
    private static final int f37147b;

    /* renamed from: c */
    private static final int f37148c = 5;

    /* renamed from: d */
    private static final RejectedExecutionHandler f37149d = new RejectedExecutionHandler() {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            runnable.run();
        }
    };

    /* renamed from: e */
    private static final ThreadFactory f37150e = new ScheduleThreadFactory();

    /* renamed from: f */
    private static final ExecutorService f37151f = new PriorityThreadPoolExecutor(0, f37147b, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), f37150e, f37149d);

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f37146a = availableProcessors;
        f37147b = (availableProcessors << 1) + 1;
    }

    private static final class ScheduleThreadFactory implements ThreadFactory {
        private AtomicInteger mPoolCount;

        private ScheduleThreadFactory() {
            this.mPoolCount = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "ScheduleTask#" + this.mPoolCount.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    }

    private static final class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ScheduleTaskHelper INSTANCE = new ScheduleTaskHelper();

        private SingletonHolder() {
        }
    }

    private ScheduleTaskHelper() {
    }

    public static ScheduleTaskHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void schedule(Runnable runnable) {
        f37151f.execute(runnable);
    }

    public Future<?> submit(Runnable runnable) {
        return f37151f.submit(runnable);
    }

    private static class PriorityThreadPoolExecutor extends ThreadPoolExecutor {
        public PriorityThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        }

        /* access modifiers changed from: protected */
        public void beforeExecute(Thread thread, Runnable runnable) {
            SystemUtils.setProcessThreadPriority(5);
            super.beforeExecute(thread, runnable);
        }
    }
}
