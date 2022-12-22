package com.didi.sdk.resource.warehouse.tools;

import android.os.Handler;
import android.os.Looper;

public class HandlerUtil {

    /* renamed from: a */
    private static final Handler f37121a = new Handler(Looper.getMainLooper());

    public static void postRunnable(Runnable runnable) {
        if (runnable != null) {
            f37121a.post(runnable);
        }
    }

    public static void postRunnableDelayed(Runnable runnable, long j) {
        if (runnable != null) {
            f37121a.postDelayed(runnable, j);
        }
    }
}
