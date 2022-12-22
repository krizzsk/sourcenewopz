package com.didiglobal.ddmirror.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DDMirrorThreadPool {
    private static final String TAG = "DDMirror—";
    private static ScheduledThreadPoolExecutor sExecutorService;
    private static Handler sHandler = new Handler(sHandlerThread.getLooper());
    private static HandlerThread sHandlerThread;
    /* access modifiers changed from: private */
    public static Handler sUiHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static AtomicInteger threadNumber = new AtomicInteger(1);

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, DDMirrorThreadPool.TAG + DDMirrorThreadPool.threadNumber.getAndIncrement());
            }
        });
        sExecutorService = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        sExecutorService.allowCoreThreadTimeOut(true);
        HandlerThread handlerThread = new HandlerThread("ddmirror-work-looper", -2);
        sHandlerThread = handlerThread;
        handlerThread.start();
    }

    public static ScheduledThreadPoolExecutor getExecutorService() {
        return sExecutorService;
    }

    public static void postDelay(Runnable runnable, int i) {
        sExecutorService.schedule(runnable, (long) i, TimeUnit.MILLISECONDS);
        logStatus();
    }

    public static void remove(Runnable runnable) {
        sExecutorService.remove(runnable);
    }

    public static void execute(Runnable runnable) {
        sExecutorService.execute(runnable);
        logStatus();
    }

    public static void excuteOnUiThread(Runnable runnable) {
        sUiHandler.post(runnable);
    }

    public static void postDelayOnUiThread(Runnable runnable, int i) {
        sUiHandler.postDelayed(runnable, (long) i);
    }

    public static void executeOnSingle(Runnable runnable) {
        sHandler.post(runnable);
    }

    public static void postDelayOnSingle(Runnable runnable, int i) {
        sHandler.postDelayed(runnable, (long) i);
    }

    private static void logStatus() {
        int activeCount = sExecutorService.getActiveCount();
        long taskCount = sExecutorService.getTaskCount();
        SystemUtils.log(3, TAG, "active count = " + activeCount + "; task count = " + taskCount, (Throwable) null, "com.didiglobal.ddmirror.utils.DDMirrorThreadPool", 81);
    }

    public static void execute(IORunnable iORunnable) {
        execute((Runnable) new RunWrapper(iORunnable));
    }

    private static class RunWrapper implements Runnable {

        /* renamed from: r */
        final IORunnable f49857r;

        private RunWrapper(IORunnable iORunnable) {
            this.f49857r = iORunnable;
        }

        public void run() {
            this.f49857r.execute();
        }
    }

    public static abstract class IORunnable<T> {
        public abstract void postRun(T t);

        public abstract T run();

        /* access modifiers changed from: private */
        public void execute() {
            final Object run = run();
            DDMirrorThreadPool.sUiHandler.post(new Runnable() {
                public void run() {
                    IORunnable.this.postRun(run);
                }
            });
        }
    }
}
