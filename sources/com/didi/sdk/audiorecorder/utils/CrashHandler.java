package com.didi.sdk.audiorecorder.utils;

import android.content.Context;
import android.os.Process;
import java.lang.Thread;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "CrashHandler -> ";

    /* renamed from: a */
    private static CrashHandler f35568a = new CrashHandler();

    /* renamed from: b */
    private Context f35569b;

    /* renamed from: c */
    private Thread.UncaughtExceptionHandler f35570c;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return f35568a;
    }

    public void init(Context context) {
        this.f35569b = context.getApplicationContext();
        this.f35570c = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        LogUtil.log(TAG, "uncaughtException occur. " + th);
        Process.killProcess(Process.myPid());
    }
}
