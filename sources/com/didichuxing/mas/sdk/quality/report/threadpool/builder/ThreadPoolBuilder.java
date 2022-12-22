package com.didichuxing.mas.sdk.quality.report.threadpool.builder;

import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public abstract class ThreadPoolBuilder<T extends ExecutorService> {
    protected static Map<String, ExecutorService> mThreadPoolMap = new ConcurrentHashMap();
    protected ExecutorService mExecutorService = null;
    protected String mPoolName = "default";

    /* access modifiers changed from: protected */
    public abstract T create();

    /* access modifiers changed from: protected */
    public abstract ThreadPoolType getType();

    public ExecutorService builder() {
        String str = "OMG_" + getType() + "_" + this.mPoolName;
        if (mThreadPoolMap.get(str) != null) {
            this.mExecutorService = mThreadPoolMap.get(str);
        } else {
            ExecutorService create = create();
            this.mExecutorService = create;
            mThreadPoolMap.put(str, create);
        }
        return this.mExecutorService;
    }

    public ThreadPoolBuilder<T> poolName(String str) {
        if (str != null && str.length() > 0) {
            this.mPoolName = str;
        }
        return this;
    }
}
