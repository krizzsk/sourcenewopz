package com.didi.soda.customer.foundation.util;

import android.os.Handler;
import android.os.Looper;

public final class UiHandlerUtil {

    /* renamed from: a */
    private static Handler f41260a = new Handler(Looper.getMainLooper());

    private UiHandlerUtil() {
    }

    public static boolean post(Runnable runnable) {
        Handler handler = f41260a;
        return handler != null && handler.post(runnable);
    }

    public static boolean postDelayed(Runnable runnable, long j) {
        Handler handler = f41260a;
        return handler != null && handler.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        Handler handler = f41260a;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
