package com.didichuxing.dfbasesdk.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiSafetyThreadManager {

    /* renamed from: a */
    private static volatile Handler f46672a;

    /* renamed from: b */
    private static volatile Handler f46673b;

    /* renamed from: c */
    private static volatile ExecutorService f46674c;

    /* renamed from: d */
    private static volatile ExecutorService f46675d;

    public static Handler getUiHandler() {
        if (f46672a == null) {
            synchronized (DiSafetyThreadManager.class) {
                if (f46672a == null) {
                    f46672a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f46672a;
    }

    public static Handler getWorkHandler() {
        if (f46673b == null) {
            synchronized (DiSafetyThreadManager.class) {
                if (f46673b == null) {
                    HandlerThread handlerThread = new HandlerThread("DiSafetyThreadManager");
                    handlerThread.start();
                    f46673b = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f46673b;
    }

    public static ExecutorService getCachedThreadPool() {
        if (f46674c == null) {
            synchronized (DiSafetyThreadManager.class) {
                if (f46674c == null) {
                    f46674c = Executors.newCachedThreadPool();
                }
            }
        }
        return f46674c;
    }

    public static ExecutorService getSingleThreadExecutor() {
        if (f46675d == null) {
            synchronized (DiSafetyThreadManager.class) {
                if (f46675d == null) {
                    f46675d = Executors.newSingleThreadExecutor();
                }
            }
        }
        return f46675d;
    }
}
