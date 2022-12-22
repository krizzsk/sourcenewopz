package com.didi.safetoolkit.util;

import android.os.Handler;
import android.os.Looper;

public class SfUIThreadHelper {

    /* renamed from: a */
    private static Handler f34538a = new Handler(Looper.getMainLooper());

    public static void post(Runnable runnable) {
        f34538a.post(runnable);
    }

    public static void postDelay(Runnable runnable, long j) {
        f34538a.postDelayed(runnable, j);
    }
}
