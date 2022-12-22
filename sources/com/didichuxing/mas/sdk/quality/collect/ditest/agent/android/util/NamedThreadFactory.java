package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {

    /* renamed from: a */
    final ThreadGroup f48065a;

    /* renamed from: b */
    final String f48066b;

    /* renamed from: c */
    final AtomicInteger f48067c = new AtomicInteger(1);

    public NamedThreadFactory(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f48065a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f48066b = "NR_" + str + "-";
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f48065a;
        Thread thread = new Thread(threadGroup, runnable, this.f48066b + this.f48067c.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
