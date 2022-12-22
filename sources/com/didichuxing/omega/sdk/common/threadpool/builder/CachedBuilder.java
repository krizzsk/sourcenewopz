package com.didichuxing.omega.sdk.common.threadpool.builder;

import com.didichuxing.omega.sdk.common.threadpool.NamedThreadFactory;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolType;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedBuilder extends ThreadPoolBuilder<ExecutorService> {
    /* access modifiers changed from: protected */
    public ExecutorService create() {
        return Executors.newCachedThreadPool(new NamedThreadFactory("Omega-Cached"));
    }

    /* access modifiers changed from: protected */
    public ThreadPoolType getType() {
        return ThreadPoolType.CACHED;
    }
}
