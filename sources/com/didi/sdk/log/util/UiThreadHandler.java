package com.didi.sdk.log.util;

import android.os.Handler;
import android.os.Looper;

public class UiThreadHandler {

    /* renamed from: a */
    private static Handler f36463a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static Object f36464b = new Object();

    public static boolean post(Runnable runnable) {
        Handler handler = f36463a;
        if (handler == null) {
            return false;
        }
        return handler.post(runnable);
    }

    public static boolean postDelayed(Runnable runnable, long j) {
        Handler handler = f36463a;
        if (handler == null) {
            return false;
        }
        return handler.postDelayed(runnable, j);
    }

    public static Handler getsUiHandler() {
        return f36463a;
    }

    public static boolean postOnceDelayed(Runnable runnable, long j) {
        Handler handler = f36463a;
        if (handler == null) {
            return false;
        }
        handler.removeCallbacks(runnable, f36464b);
        return f36463a.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        Handler handler = f36463a;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
