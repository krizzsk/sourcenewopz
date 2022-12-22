package com.didichuxing.mas.sdk.quality.report.threadpool;

import com.didichuxing.mas.sdk.quality.report.threadpool.builder.CachedBuilder;
import com.didichuxing.mas.sdk.quality.report.threadpool.builder.CustomBuilder;
import com.didichuxing.mas.sdk.quality.report.threadpool.builder.FixedBuilder;
import com.didichuxing.mas.sdk.quality.report.threadpool.builder.ScheduledBuilder;
import com.didichuxing.mas.sdk.quality.report.threadpool.builder.SingleBuilder;
import com.didichuxing.mas.sdk.quality.report.threadpool.builder.ThreadPoolBuilder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPoolHelp {

    public static class Builder {
        private int mCorePoolSize = 1;
        private long mKeepAliveTime = 60;
        private int mMaximumPoolSize = Integer.MAX_VALUE;
        private String mName = null;
        private int mSize = 1;
        private ThreadPoolBuilder<ExecutorService> mThreadPoolBuilder = null;
        private ThreadPoolType mType = null;
        private TimeUnit mUnit = TimeUnit.SECONDS;
        private BlockingQueue<Runnable> mWorkQueue = new SynchronousQueue();

        public Builder(ThreadPoolType threadPoolType) {
            this.mType = threadPoolType;
        }

        public Builder(ThreadPoolType threadPoolType, int i) {
            this.mType = threadPoolType;
            this.mSize = i;
        }

        public Builder(ThreadPoolType threadPoolType, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
            this.mType = threadPoolType;
            this.mCorePoolSize = i;
            this.mMaximumPoolSize = i2;
            this.mKeepAliveTime = j;
            this.mUnit = timeUnit;
            this.mWorkQueue = blockingQueue;
        }

        public static Builder cached() {
            return new Builder(ThreadPoolType.CACHED);
        }

        public static Builder fixed(int i) {
            return new Builder(ThreadPoolType.FIXED, i);
        }

        public static Builder single() {
            return new Builder(ThreadPoolType.SINGLE);
        }

        public static Builder schedule(int i) {
            return new Builder(ThreadPoolType.SCHEDULED, i);
        }

        public static Builder custom(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
            return new Builder(ThreadPoolType.CUSTOM, i, i2, j, timeUnit, blockingQueue);
        }

        public Builder name(String str) {
            this.mName = str;
            return this;
        }

        public ExecutorService builder() {
            createThreadPoolBuilder();
            return this.mThreadPoolBuilder.builder();
        }

        public ScheduledExecutorService scheduleBuilder() {
            createThreadPoolBuilder();
            if (this.mThreadPoolBuilder.builder() instanceof ScheduledExecutorService) {
                return (ScheduledExecutorService) this.mThreadPoolBuilder.builder();
            }
            return null;
        }

        private void createThreadPoolBuilder() {
            if (this.mType == ThreadPoolType.CACHED) {
                this.mThreadPoolBuilder = new CachedBuilder().poolName(this.mName);
            } else if (this.mType == ThreadPoolType.FIXED) {
                this.mThreadPoolBuilder = new FixedBuilder().setSize(this.mSize).poolName(this.mName);
            } else if (this.mType == ThreadPoolType.SCHEDULED) {
                this.mThreadPoolBuilder = new ScheduledBuilder().poolName(this.mName);
            } else if (this.mType == ThreadPoolType.SINGLE) {
                this.mThreadPoolBuilder = new SingleBuilder().poolName(this.mName);
            } else if (this.mType == ThreadPoolType.CUSTOM) {
                this.mThreadPoolBuilder = new CustomBuilder().corePoolSize(this.mCorePoolSize).maximumPoolSize(this.mMaximumPoolSize).keepAliveTime(this.mKeepAliveTime).unit(this.mUnit).workQueue(this.mWorkQueue).poolName(this.mName);
            }
        }
    }

    public static void renameThread(Thread thread, String str) {
        if (str != null && !str.equals("")) {
            thread.setName(str);
        }
    }
}
