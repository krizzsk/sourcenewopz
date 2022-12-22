package com.didi.mapbizinterface.utils;

import android.os.Handler;
import android.os.Looper;

public class ThreadDispatcher {

    /* renamed from: a */
    private static final Handler f29085a = new Handler(Looper.getMainLooper());

    public static void runOnMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            postOnMainThread(runnable);
        } else {
            runnable.run();
        }
    }

    public static void postOnMainThread(Runnable runnable) {
        if (runnable != null) {
            f29085a.post(runnable);
        }
    }
}
