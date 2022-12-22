package com.didichuxing.dfbasesdk.logupload2;

import android.content.Context;
import java.lang.Thread;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static CrashHandler f46615a = new CrashHandler();

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f46616b;

    /* renamed from: c */
    private Context f46617c;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return f46615a;
    }

    public void init(Context context) {
        this.f46616b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f46617c = context.getApplicationContext();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            LogInnerTask.m33492a().mo115693b();
        } catch (Throwable unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f46616b;
        if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
