package com.didi.hawaii.p118ar.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.hawaii.ar.utils.ARThreadPool */
public final class ARThreadPool {

    /* renamed from: a */
    private static ThreadPoolExecutor f23301a = new ThreadPoolExecutor(1, 10, 10000, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new ThreadFactory() {

        /* renamed from: a */
        private final AtomicInteger f23302a = new AtomicInteger();

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "HWThreadPool-" + this.f23302a.getAndIncrement());
        }
    });

    private ARThreadPool() {
    }

    public static void execute(Runnable runnable) {
        f23301a.execute(runnable);
    }
}
