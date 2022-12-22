package com.didi.sdk.common;

import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class DDThreadPool {

    /* renamed from: a */
    private static final String f35622a = "DDThreadPool";

    /* renamed from: b */
    private static final int f35623b = 3;

    /* renamed from: c */
    private ThreadPoolExecutor f35624c;

    /* renamed from: d */
    private ThreadPoolExecutor f35625d;

    private static class SingletonHolder {
        public static final DDThreadPool INSTANCE = new DDThreadPool();

        private SingletonHolder() {
        }
    }

    private static class PoolThreadFactory implements ThreadFactory {
        private AtomicInteger mCount = new AtomicInteger(1);
        private boolean mUiTask;

        public PoolThreadFactory(boolean z) {
            this.mUiTask = z;
        }

        public Thread newThread(Runnable runnable) {
            if (this.mUiTask) {
                return new Thread(runnable, "DDThreadPool#" + this.mCount.getAndIncrement());
            }
            return new Thread(runnable, "DDThreadPool#" + this.mCount.getAndIncrement());
        }
    }

    public static DDThreadPool getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private DDThreadPool() {
        int a = m25232a();
        this.f35624c = new ThreadPoolExecutor(a, a, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(), new PoolThreadFactory(true));
        this.f35625d = new ThreadPoolExecutor(3, 3, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(), new PoolThreadFactory(false));
        m25233b();
    }

    /* renamed from: a */
    private int m25232a() {
        return Math.max(2, Runtime.getRuntime().availableProcessors() / 2);
    }

    /* renamed from: b */
    private void m25233b() {
        int availableProcessors = Runtime.getRuntime().availableProcessors() / 2;
        int max = Math.max(4, availableProcessors);
        this.f35624c.setCorePoolSize(max);
        this.f35624c.setMaximumPoolSize(max);
        int max2 = Math.max(4, availableProcessors);
        this.f35625d.setCorePoolSize(max2);
        this.f35625d.setMaximumPoolSize(max2);
    }

    public void addUiTask(Runnable runnable) {
        ThreadPoolTask threadPoolTask = new ThreadPoolTask(runnable, true);
        threadPoolTask.mo91321a(System.currentTimeMillis());
        SystemUtils.excuteThreadPool(this.f35624c, threadPoolTask);
    }

    public void addUiTask(Runnable runnable, int i) {
        ThreadPoolTask threadPoolTask = new ThreadPoolTask(runnable, true, i);
        threadPoolTask.mo91321a(System.currentTimeMillis());
        SystemUtils.excuteThreadPool(this.f35624c, threadPoolTask);
    }

    public void addBkgTask(Runnable runnable) {
        ThreadPoolTask threadPoolTask = new ThreadPoolTask(runnable, false);
        threadPoolTask.mo91321a(System.currentTimeMillis());
        SystemUtils.excuteThreadPool(this.f35625d, threadPoolTask);
    }

    public void addBkgTask(Runnable runnable, int i) {
        ThreadPoolTask threadPoolTask = new ThreadPoolTask(runnable, false, i);
        threadPoolTask.mo91321a(System.currentTimeMillis());
        SystemUtils.excuteThreadPool(this.f35625d, threadPoolTask);
    }

    public void dumpState(String str) {
        SystemUtils.log(3, f35622a, str + "-UiTaskPool, PoolCoreSize: " + this.f35625d.getCorePoolSize() + ", ActiveThreadCount: " + this.f35625d.getActiveCount() + ", CompletedTaskCount: " + this.f35625d.getCompletedTaskCount() + ", CurPoolSize:" + this.f35625d.getPoolSize() + ", ScheduledTaskCount: " + this.f35625d.getTaskCount() + ", QueueSize: " + this.f35625d.getQueue().size(), (Throwable) null, "com.didi.sdk.common.DDThreadPool", 124);
        SystemUtils.log(3, f35622a, str + "-BkgTaskPool, PoolCoreSize: " + this.f35625d.getCorePoolSize() + ", ActiveThreadCount: " + this.f35625d.getActiveCount() + ", CompletedTaskCount: " + this.f35625d.getCompletedTaskCount() + ", CurPoolSize:" + this.f35625d.getPoolSize() + ", ScheduledTaskCount: " + this.f35625d.getTaskCount() + ", QueueSize: " + this.f35625d.getQueue().size(), (Throwable) null, "com.didi.sdk.common.DDThreadPool", 130);
    }

    public boolean isIncludeAliveThread() {
        return this.f35624c.getActiveCount() > 0 || this.f35625d.getActiveCount() > 0;
    }
}
