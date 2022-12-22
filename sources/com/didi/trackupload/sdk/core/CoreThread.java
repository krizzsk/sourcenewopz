package com.didi.trackupload.sdk.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.didi.trackupload.sdk.utils.TrackLog;

public class CoreThread {

    /* renamed from: a */
    private static final String f37002a = "TrackCoreThread";

    /* renamed from: b */
    private static Handler f37003b;

    public static void create() {
        if (f37003b == null) {
            HandlerThread handlerThread = new HandlerThread("TrackSDKCoreThread", -1);
            handlerThread.start();
            f37003b = new Handler(handlerThread.getLooper());
        }
    }

    public static void destory() {
        Handler handler = f37003b;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            f37003b.getLooper().quit();
            f37003b = null;
        }
    }

    public static boolean ensureCoreThread() {
        Handler handler = f37003b;
        boolean z = handler != null && handler.getLooper() == Looper.myLooper();
        if (!z) {
            TrackLog.m31343d(f37002a, "ensureCoreThread vaild=false trace=" + Log.getStackTraceString(new Throwable()));
        }
        return z;
    }

    public static void post(Runnable runnable) {
        postDelayed(runnable, 0);
    }

    public static void postDelayed(Runnable runnable, long j) {
        Handler handler = f37003b;
        if (handler != null && runnable != null && j >= 0) {
            handler.postDelayed(runnable, j);
        }
    }

    public static void cancel(Runnable runnable) {
        Handler handler = f37003b;
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
