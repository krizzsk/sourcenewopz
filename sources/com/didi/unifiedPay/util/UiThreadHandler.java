package com.didi.unifiedPay.util;

import android.os.Handler;
import android.os.Looper;

public class UiThreadHandler {

    /* renamed from: a */
    private static Handler f44609a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static Object f44610b = new Object();

    public static final boolean post(Runnable runnable) {
        Handler handler = f44609a;
        if (handler == null) {
            return false;
        }
        return handler.post(runnable);
    }

    public static final boolean postDelayed(Runnable runnable, long j) {
        Handler handler = f44609a;
        if (handler == null) {
            return false;
        }
        return handler.postDelayed(runnable, j);
    }

    public static final Handler getsUiHandler() {
        return f44609a;
    }

    public static final boolean postOnceDelayed(Runnable runnable, long j) {
        Handler handler = f44609a;
        if (handler == null) {
            return false;
        }
        handler.removeCallbacks(runnable, f44610b);
        return f44609a.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        Handler handler = f44609a;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
