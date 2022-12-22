package com.didichuxing.security.cardverify.globalpay.utils;

import android.os.Handler;
import android.os.Looper;

public class UiHandlerUtil {

    /* renamed from: a */
    private static volatile Handler f48926a;

    public static Handler getHandler() {
        if (f48926a == null) {
            synchronized (UiHandlerUtil.class) {
                if (f48926a == null) {
                    f48926a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f48926a;
    }

    public static void removeCallbacks(Runnable runnable) {
        getHandler().removeCallbacks(runnable);
    }

    public static final boolean postDelayed(Runnable runnable, long j) {
        return getHandler().postDelayed(runnable, j);
    }
}
