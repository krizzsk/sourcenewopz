package com.didi.map.sdk.utils;

import android.os.Looper;

public class Utils {
    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
