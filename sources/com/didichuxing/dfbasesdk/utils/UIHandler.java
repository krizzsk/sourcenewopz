package com.didichuxing.dfbasesdk.utils;

import android.os.Handler;
import android.os.Looper;

@Deprecated
public class UIHandler {

    /* renamed from: a */
    private static Handler f46763a = new Handler(Looper.getMainLooper());

    public static Handler getHandler() {
        return f46763a;
    }

    public static void postDelayed(long j, Runnable runnable) {
        f46763a.postDelayed(runnable, j);
    }

    public static void post(Runnable runnable) {
        f46763a.post(runnable);
    }

    public static void removeCallbacks(Runnable runnable) {
        f46763a.removeCallbacks(runnable);
    }
}
