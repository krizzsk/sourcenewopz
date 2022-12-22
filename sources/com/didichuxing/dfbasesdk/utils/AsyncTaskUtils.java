package com.didichuxing.dfbasesdk.utils;

import android.os.Handler;
import android.os.HandlerThread;

@Deprecated
public class AsyncTaskUtils {

    /* renamed from: a */
    private static volatile Handler f46690a;

    public static void runOnWorkThread(Runnable runnable) {
        m33537a().post(runnable);
    }

    public static void runOnWorkThread(Runnable runnable, long j) {
        m33537a().postDelayed(runnable, j);
    }

    public static void removeCallback(Runnable runnable) {
        m33537a().removeCallbacks(runnable);
    }

    /* renamed from: a */
    private static Handler m33537a() {
        if (f46690a == null) {
            synchronized (AsyncTaskUtils.class) {
                if (f46690a == null) {
                    HandlerThread handlerThread = new HandlerThread("diface");
                    handlerThread.start();
                    f46690a = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f46690a;
    }
}
