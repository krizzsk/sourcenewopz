package com.didi.global.globalgenerickit.utils;

import android.os.Handler;
import android.os.Looper;

public class UIThreadHandler {

    /* renamed from: a */
    private static Handler f22335a = new Handler(Looper.getMainLooper());

    public static void post(Runnable runnable) {
        if (runnable != null) {
            m16109a();
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
                return;
            }
            Handler handler = f22335a;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    public static void post(Runnable runnable, long j) {
        if (runnable != null) {
            m16109a();
            Handler handler = f22335a;
            if (handler != null) {
                handler.postDelayed(runnable, j);
            }
        }
    }

    /* renamed from: a */
    private static void m16109a() {
        if (f22335a == null) {
            f22335a = new Handler(Looper.getMainLooper());
        }
    }
}
