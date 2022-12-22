package com.didi.hawaii.log;

import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class HWThreadPool {

    /* renamed from: a */
    private static ThreadPoolExecutor f23466a = new ThreadPoolExecutor(f23468c, f23469d, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new ThreadFactory() {

        /* renamed from: id */
        private final AtomicInteger f23471id = new AtomicInteger();

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "HWThreadPool-" + this.f23471id.getAndIncrement());
        }
    });

    /* renamed from: b */
    private static final int f23467b;

    /* renamed from: c */
    private static final int f23468c;

    /* renamed from: d */
    private static final int f23469d = ((f23467b * 2) + 1);

    /* renamed from: e */
    private static final int f23470e = 30;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f23467b = availableProcessors;
        f23468c = Math.max(2, Math.min(availableProcessors - 1, 4));
    }

    private HWThreadPool() {
    }

    public static void execute(Runnable runnable) {
        SystemUtils.excuteThreadPool(f23466a, runnable);
    }
}
