package com.didichuxing.sdk.alphaface.utils;

import android.os.Handler;
import android.os.Looper;

public class UIHandler {

    /* renamed from: a */
    private static Handler f48762a = new Handler(Looper.getMainLooper());

    public static Handler getHandler() {
        return f48762a;
    }

    public static void postDelayed(long j, Runnable runnable) {
        f48762a.postDelayed(runnable, j);
    }

    public static void post(Runnable runnable) {
        f48762a.post(runnable);
    }

    public static void removeCallbacks(Runnable runnable) {
        f48762a.removeCallbacks(runnable);
    }
}
