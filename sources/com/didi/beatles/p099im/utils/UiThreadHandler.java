package com.didi.beatles.p099im.utils;

import android.os.Handler;
import android.os.Looper;

@Deprecated
/* renamed from: com.didi.beatles.im.utils.UiThreadHandler */
public class UiThreadHandler {

    /* renamed from: a */
    private static Handler f9829a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static Object f9830b = new Object();

    public static final boolean post(Runnable runnable) {
        Handler handler = f9829a;
        if (handler == null) {
            return false;
        }
        return handler.post(runnable);
    }

    public static final boolean postDelayed(Runnable runnable, long j) {
        Handler handler = f9829a;
        if (handler == null) {
            return false;
        }
        return handler.postDelayed(runnable, j);
    }

    public static final Handler getsUiHandler() {
        return f9829a;
    }

    public static final boolean postOnceDelayed(Runnable runnable, long j) {
        Handler handler = f9829a;
        if (handler == null) {
            return false;
        }
        handler.removeCallbacks(runnable, f9830b);
        return f9829a.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        Handler handler = f9829a;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
