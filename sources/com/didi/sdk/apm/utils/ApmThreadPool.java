package com.didi.sdk.apm.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ApmThreadPool {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static AtomicInteger f35047a = new AtomicInteger(1);

    /* renamed from: b */
    private static final String f35048b = "ApmPool—";

    /* renamed from: c */
    private static ScheduledThreadPoolExecutor f35049c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Handler f35050d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private static HandlerThread f35051e;

    /* renamed from: f */
    private static Handler f35052f = new Handler(f35051e.getLooper());

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, ApmThreadPool.f35048b + ApmThreadPool.f35047a.getAndIncrement());
            }
        });
        f35049c = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        f35049c.allowCoreThreadTimeOut(true);
        HandlerThread handlerThread = new HandlerThread("apm-work-looper", -2);
        f35051e = handlerThread;
        handlerThread.start();
    }

    public static ScheduledThreadPoolExecutor getExecutorService() {
        return f35049c;
    }

    public static void postDelay(Runnable runnable, int i) {
        f35049c.schedule(runnable, (long) i, TimeUnit.MILLISECONDS);
        m24767c();
    }

    public static void remove(Runnable runnable) {
        f35049c.remove(runnable);
    }

    public static void execute(Runnable runnable) {
        f35049c.execute(runnable);
        m24767c();
    }

    public static void excuteOnUiThread(Runnable runnable) {
        f35050d.post(runnable);
    }

    public static void postDelayOnUiThread(Runnable runnable, int i) {
        f35050d.postDelayed(runnable, (long) i);
    }

    public static void executeOnSingle(Runnable runnable) {
        f35052f.post(runnable);
    }

    public static void postDelayOnSingle(Runnable runnable, int i) {
        f35052f.postDelayed(runnable, (long) i);
    }

    /* renamed from: c */
    private static void m24767c() {
        int activeCount = f35049c.getActiveCount();
        long taskCount = f35049c.getTaskCount();
        Log.d(f35048b, "active count = " + activeCount + "; task count = " + taskCount);
    }

    public static void execute(IORunnable iORunnable) {
        execute((Runnable) new RunWrapper(iORunnable));
    }

    private static class RunWrapper implements Runnable {

        /* renamed from: r */
        final IORunnable f35053r;

        private RunWrapper(IORunnable iORunnable) {
            this.f35053r = iORunnable;
        }

        public void run() {
            this.f35053r.execute();
        }
    }

    public static abstract class IORunnable<T> {
        public abstract void postRun(T t);

        public abstract T run();

        /* access modifiers changed from: private */
        public void execute() {
            final Object run = run();
            ApmThreadPool.f35050d.post(new Runnable() {
                public void run() {
                    IORunnable.this.postRun(run);
                }
            });
        }
    }
}
