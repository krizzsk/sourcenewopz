package com.didi.bike.utils;

import android.os.Handler;
import android.os.Looper;

public class UIHandler {

    /* renamed from: a */
    private static Handler f10670a = new Handler(Looper.getMainLooper());

    public static Handler getHandler() {
        return f10670a;
    }

    public static void postDelayed(Runnable runnable, long j) {
        f10670a.postDelayed(runnable, j);
    }

    public static void post(Runnable runnable) {
        f10670a.post(runnable);
    }

    public static void removeCallbacks(Runnable runnable) {
        f10670a.removeCallbacks(runnable);
    }
}
