package com.didi.global.ninja.crash;

import android.content.Context;
import com.didi.global.ninja.strategy.StrategyManager;
import java.lang.Thread;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f22866a;

    /* renamed from: b */
    private Context f22867b;

    public void init(Context context) {
        this.f22867b = context.getApplicationContext();
        this.f22866a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        m16446a(thread, th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f22866a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* renamed from: a */
    private void m16446a(Thread thread, Throwable th) {
        StrategyManager.getInstance(this.f22867b).filterException(th.getStackTrace());
    }
}
