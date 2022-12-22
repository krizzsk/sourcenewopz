package com.didi.sdk.apm.ext;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import rui.config.RConfigConstants;

public class NamedThreadFactory implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f35030a = new AtomicInteger(1);

    /* renamed from: b */
    private String f35031b;

    public NamedThreadFactory(String str) {
        this.f35031b = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f35031b + RConfigConstants.KEYWORD_COLOR_SIGN + this.f35030a.getAndIncrement());
        thread.setPriority(3);
        return thread;
    }
}
