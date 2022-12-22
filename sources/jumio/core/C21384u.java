package jumio.core;

import com.jumio.analytics.Analytics;
import com.jumio.analytics.C19937a;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.log.Log;
import java.lang.Thread;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.u */
/* compiled from: ExceptionHandler.kt */
public final class C21384u implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public final Thread.UncaughtExceptionHandler f59675a;

    public C21384u(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f59675a = uncaughtExceptionHandler;
        Log.m39471v(Analytics.LOGTAG, Intrinsics.stringPlus("Wrapping handler :", uncaughtExceptionHandler == null ? null : uncaughtExceptionHandler.getClass()));
    }

    /* renamed from: a */
    public final void mo175878a() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            Thread.setDefaultUncaughtExceptionHandler(this.f59675a);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(th, "ex");
        if (th instanceof Exception) {
            Log.m39456d(Analytics.LOGTAG, Intrinsics.stringPlus("uncaught exception: ", th));
            Analytics.Companion companion = Analytics.Companion;
            companion.add(MobileEvents.exception((Exception) th));
            companion.add(MobileEvents.lifecycle$default(C19937a.ABORTED, (Object) null, 2, (Object) null));
            companion.flush();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f59675a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
