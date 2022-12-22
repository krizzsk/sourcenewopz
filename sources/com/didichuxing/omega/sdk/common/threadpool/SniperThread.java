package com.didichuxing.omega.sdk.common.threadpool;

import android.os.Handler;
import android.os.HandlerThread;

public class SniperThread extends HandlerThread {
    private static Handler sHandler;
    private static SniperThread sInstance;

    public SniperThread() {
        super("SniperThread", 0);
    }

    private static void ensureThreadLocked() {
        if (sInstance == null) {
            SniperThread sniperThread = new SniperThread();
            sInstance = sniperThread;
            sniperThread.start();
            sHandler = new Handler(sInstance.getLooper());
        }
    }

    public static void post(Runnable runnable) {
        synchronized (SniperThread.class) {
            ensureThreadLocked();
            sHandler.post(runnable);
        }
    }

    public static void postDelayed(Runnable runnable, long j) {
        synchronized (SniperThread.class) {
            ensureThreadLocked();
            sHandler.postDelayed(runnable, j);
        }
    }

    public static void removeTask(Runnable runnable) {
        synchronized (SniperThread.class) {
            ensureThreadLocked();
            sHandler.removeCallbacks(runnable);
        }
    }
}
