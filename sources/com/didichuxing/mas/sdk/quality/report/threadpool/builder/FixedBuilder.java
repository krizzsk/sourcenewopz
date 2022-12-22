package com.didichuxing.mas.sdk.quality.report.threadpool.builder;

import com.didichuxing.mas.sdk.quality.report.threadpool.NamedThreadFactory;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolType;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedBuilder extends ThreadPoolBuilder<ExecutorService> {
    private int mSize = 1;

    /* access modifiers changed from: protected */
    public ExecutorService create() {
        return Executors.newFixedThreadPool(this.mSize, new NamedThreadFactory("Omega-Fixed"));
    }

    /* access modifiers changed from: protected */
    public ThreadPoolType getType() {
        return ThreadPoolType.FIXED;
    }

    public FixedBuilder setSize(int i) {
        this.mSize = i;
        return this;
    }
}
