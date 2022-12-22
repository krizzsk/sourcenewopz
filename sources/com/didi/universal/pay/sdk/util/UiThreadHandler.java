package com.didi.universal.pay.sdk.util;

import android.os.Handler;
import android.os.Looper;

public class UiThreadHandler {
    private static Object sToken = new Object();
    private static Handler sUiHandler = new Handler(Looper.getMainLooper());

    public static final boolean post(Runnable runnable) {
        Handler handler = sUiHandler;
        if (handler == null) {
            return false;
        }
        return handler.post(runnable);
    }

    public static final boolean postDelayed(Runnable runnable, long j) {
        Handler handler = sUiHandler;
        if (handler == null) {
            return false;
        }
        return handler.postDelayed(runnable, j);
    }

    public static final Handler getsUiHandler() {
        return sUiHandler;
    }

    public static final boolean postOnceDelayed(Runnable runnable, long j) {
        Handler handler = sUiHandler;
        if (handler == null) {
            return false;
        }
        handler.removeCallbacks(runnable, sToken);
        return sUiHandler.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        Handler handler = sUiHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
