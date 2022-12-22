package com.didichuxing.mas.sdk.quality.report.threadpool.builder;

import com.didichuxing.mas.sdk.quality.report.threadpool.NamedThreadFactory;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolType;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduledBuilder extends ThreadPoolBuilder<ExecutorService> {
    protected ScheduledExecutorService mExecutorService = null;
    private int mSize = 1;

    /* access modifiers changed from: protected */
    public ScheduledExecutorService create() {
        return Executors.newScheduledThreadPool(this.mSize, new NamedThreadFactory("Omega-Scheduled"));
    }

    /* access modifiers changed from: protected */
    public ThreadPoolType getType() {
        return ThreadPoolType.SCHEDULED;
    }

    public ScheduledExecutorService builder() {
        String str = "OMG_" + getType() + "_" + this.mPoolName;
        if (mThreadPoolMap.get(str) != null) {
            this.mExecutorService = (ScheduledExecutorService) mThreadPoolMap.get(str);
        } else {
            this.mExecutorService = create();
            mThreadPoolMap.put(str, this.mExecutorService);
        }
        return this.mExecutorService;
    }

    public ScheduledExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    public ScheduledBuilder size(int i) {
        this.mSize = i;
        return this;
    }
}
