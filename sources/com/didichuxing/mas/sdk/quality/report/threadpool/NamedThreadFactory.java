package com.didichuxing.mas.sdk.quality.report.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import rui.config.RConfigConstants;

public class NamedThreadFactory implements ThreadFactory {
    private final AtomicInteger mCount = new AtomicInteger(1);
    private String mPoolNamePrefix;

    public NamedThreadFactory(String str) {
        this.mPoolNamePrefix = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.mPoolNamePrefix + RConfigConstants.KEYWORD_COLOR_SIGN + this.mCount.getAndIncrement());
        thread.setPriority(3);
        return thread;
    }
}
