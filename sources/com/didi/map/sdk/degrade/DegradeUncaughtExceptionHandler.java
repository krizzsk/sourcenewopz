package com.didi.map.sdk.degrade;

import android.text.TextUtils;
import android.util.Log;
import com.didi.map.sdk.navtracker.log.DLog;
import java.lang.Thread;

public class DegradeUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f28090a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: b */
    private ICrashListener f28091b;

    public DegradeUncaughtExceptionHandler(ICrashListener iCrashListener) {
        this.f28091b = iCrashListener;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        m19962a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f28090a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* renamed from: a */
    private void m19962a(Throwable th) {
        if (th == null) {
            DLog.m20199d("ccc", "throwable is null", new Object[0]);
            return;
        }
        String stackTraceString = Log.getStackTraceString(th);
        if (TextUtils.isEmpty(stackTraceString)) {
            DLog.m20199d("ccc", "crash msg is empty", new Object[0]);
            return;
        }
        ICrashListener iCrashListener = this.f28091b;
        if (iCrashListener != null) {
            iCrashListener.onCrashed(stackTraceString);
        }
    }
}
