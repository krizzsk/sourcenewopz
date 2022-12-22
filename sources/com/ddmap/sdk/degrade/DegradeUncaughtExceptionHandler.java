package com.ddmap.sdk.degrade;

import android.text.TextUtils;
import android.util.Log;
import java.lang.Thread;

public class DegradeUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private final Thread.UncaughtExceptionHandler f4277a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: b */
    private final ICrashListener f4278b;

    public DegradeUncaughtExceptionHandler(ICrashListener iCrashListener) {
        this.f4278b = iCrashListener;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        m2605a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f4277a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* renamed from: a */
    private void m2605a(Throwable th) {
        ICrashListener iCrashListener;
        if (th != null) {
            String stackTraceString = Log.getStackTraceString(th);
            if (!TextUtils.isEmpty(stackTraceString) && (iCrashListener = this.f4278b) != null) {
                iCrashListener.onCrashed(stackTraceString);
            }
        }
    }
}
