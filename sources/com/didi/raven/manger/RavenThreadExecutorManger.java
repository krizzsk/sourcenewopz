package com.didi.raven.manger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RavenThreadExecutorManger {

    /* renamed from: a */
    private final ScheduledExecutorService f33106a = new ScheduledThreadPoolExecutor(1, $$Lambda$RavenThreadExecutorManger$_n2Tt3Z4ZaW4yzoiS_gFbYu8rCM.INSTANCE);

    /* renamed from: b */
    private final ExecutorService f33107b = new ThreadPoolExecutor(1, 3, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), $$Lambda$RavenThreadExecutorManger$XkxRNCgSvd0E8QsCaA1i7Nwb0NM.INSTANCE);

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static final RavenThreadExecutorManger INSTANCE = new RavenThreadExecutorManger();

        private SingleTon() {
        }
    }

    public static RavenThreadExecutorManger getInstance() {
        return SingleTon.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ Thread m23313b(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("RavenPoolManger-Schedule");
        return thread;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ Thread m23312a(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("RavenPoolManger-event-pool");
        return thread;
    }

    public ExecutorService getEventExecutor() {
        return this.f33107b;
    }

    public ScheduledExecutorService getService() {
        return this.f33106a;
    }
}
