package com.didi.dimina.starbox.p107ui.windowpop;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.didi.dimina.starbox.ui.windowpop.GlobalDispatcher */
public class GlobalDispatcher {

    /* renamed from: a */
    private static volatile Handler f18150a;

    /* renamed from: b */
    private static volatile HandlerThread f18151b;

    /* renamed from: a */
    private static void m13546a() {
        if (f18150a == null) {
            synchronized (GlobalDispatcher.class) {
                if (f18150a == null) {
                    f18151b = new HandlerThread("ForegroundCheck");
                    f18151b.start();
                    f18150a = new Handler(f18151b.getLooper());
                }
            }
        } else if (f18151b == null || !f18151b.isAlive()) {
            f18150a = null;
            m13546a();
        }
    }

    public static void post(Runnable runnable) {
        m13546a();
        f18150a.post(runnable);
    }

    public static void postDelay(Runnable runnable, long j) {
        m13546a();
        f18150a.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        m13546a();
        f18150a.removeCallbacks(runnable);
    }
}
