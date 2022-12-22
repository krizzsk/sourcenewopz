package com.didi.sdk.apm.utils;

import android.os.Handler;
import android.os.HandlerThread;

public final class BackgroundThread extends HandlerThread {

    /* renamed from: a */
    private static BackgroundThread f35057a;

    /* renamed from: b */
    private static Handler f35058b;

    private BackgroundThread() {
        super("apm-BackgroundThread", 10);
    }

    /* renamed from: a */
    private static void m24768a() {
        if (f35057a == null) {
            BackgroundThread backgroundThread = new BackgroundThread();
            f35057a = backgroundThread;
            backgroundThread.start();
            f35058b = new Handler(f35057a.getLooper());
        }
    }

    public static BackgroundThread get() {
        BackgroundThread backgroundThread;
        synchronized (BackgroundThread.class) {
            m24768a();
            backgroundThread = f35057a;
        }
        return backgroundThread;
    }

    public static Handler getHandler() {
        Handler handler;
        synchronized (BackgroundThread.class) {
            m24768a();
            handler = f35058b;
        }
        return handler;
    }
}
