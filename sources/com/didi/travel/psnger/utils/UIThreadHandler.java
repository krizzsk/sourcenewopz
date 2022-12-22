package com.didi.travel.psnger.utils;

import android.os.Handler;
import android.os.Looper;

public class UIThreadHandler {

    /* renamed from: a */
    private static Handler f44242a = new Handler(Looper.getMainLooper());

    public static void post(Runnable runnable) {
        if (runnable != null) {
            m31441a();
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
                return;
            }
            Handler handler = f44242a;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    public static void post(Runnable runnable, long j) {
        if (runnable != null) {
            m31441a();
            Handler handler = f44242a;
            if (handler != null) {
                handler.postDelayed(runnable, j);
            }
        }
    }

    /* renamed from: a */
    private static void m31441a() {
        if (f44242a == null) {
            f44242a = new Handler(Looper.getMainLooper());
        }
    }
}
