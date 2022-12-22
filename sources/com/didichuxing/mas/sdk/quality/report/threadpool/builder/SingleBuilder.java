package com.didichuxing.mas.sdk.quality.report.threadpool.builder;

import com.didichuxing.mas.sdk.quality.report.threadpool.NamedThreadFactory;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolType;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleBuilder extends ThreadPoolBuilder<ExecutorService> {
    /* access modifiers changed from: protected */
    public ExecutorService create() {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory("Omega-Single"));
    }

    /* access modifiers changed from: protected */
    public ThreadPoolType getType() {
        return ThreadPoolType.SINGLE;
    }
}
