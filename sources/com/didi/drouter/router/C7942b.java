package com.didi.drouter.router;

import android.os.Handler;
import android.os.HandlerThread;
import com.didi.drouter.utils.RouterLogger;

/* renamed from: com.didi.drouter.router.b */
/* compiled from: Monitor */
class C7942b {

    /* renamed from: a */
    private static Handler f19198a;

    C7942b() {
    }

    /* renamed from: a */
    static void m14366a(Request request, Result result) {
        long j = request.f19184f;
        if (j > 0) {
            m14365a();
            RouterLogger.getCoreLogger().mo59000d("monitor for request \"%s\" start, count down \"%sms\"", request.getNumber(), Long.valueOf(j));
            f19198a.postDelayed(new Monitor$1(request), j);
        }
    }

    /* renamed from: a */
    private static void m14365a() {
        if (f19198a == null) {
            synchronized (C7942b.class) {
                if (f19198a == null) {
                    HandlerThread handlerThread = new HandlerThread("timeout-monitor-thread");
                    handlerThread.start();
                    f19198a = new Handler(handlerThread.getLooper());
                }
            }
        }
    }
}
