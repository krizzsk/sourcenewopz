package com.didichuxing.mas.sdk.quality.report.threadpool.builder;

import com.didichuxing.mas.sdk.quality.report.threadpool.NamedThreadFactory;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolType;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomBuilder extends ThreadPoolBuilder<ExecutorService> {
    private int mCorePoolSize = 1;
    private long mKeepAliveTime = 60;
    private int mMaximumPoolSize = Integer.MAX_VALUE;
    private TimeUnit mUnit = TimeUnit.SECONDS;
    private BlockingQueue<Runnable> mWorkQueue = new SynchronousQueue();
    private NamedThreadFactory threadFactory = new NamedThreadFactory("Omega-Custom");

    /* access modifiers changed from: protected */
    public ExecutorService create() {
        return new ThreadPoolExecutor(this.mCorePoolSize, this.mMaximumPoolSize, this.mKeepAliveTime, this.mUnit, this.mWorkQueue, this.threadFactory);
    }

    /* access modifiers changed from: protected */
    public ThreadPoolType getType() {
        return ThreadPoolType.CUSTOM;
    }

    public CustomBuilder corePoolSize(int i) {
        this.mCorePoolSize = i;
        return this;
    }

    public CustomBuilder maximumPoolSize(int i) {
        this.mMaximumPoolSize = i;
        return this;
    }

    public CustomBuilder keepAliveTime(long j) {
        this.mKeepAliveTime = j;
        return this;
    }

    public CustomBuilder unit(TimeUnit timeUnit) {
        this.mUnit = timeUnit;
        return this;
    }

    public CustomBuilder workQueue(BlockingQueue<Runnable> blockingQueue) {
        this.mWorkQueue = blockingQueue;
        return this;
    }
}
