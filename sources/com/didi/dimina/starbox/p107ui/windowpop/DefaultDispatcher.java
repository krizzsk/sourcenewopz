package com.didi.dimina.starbox.p107ui.windowpop;

/* renamed from: com.didi.dimina.starbox.ui.windowpop.DefaultDispatcher */
public class DefaultDispatcher implements Dispatcher {
    public void post(Runnable runnable) {
        GlobalDispatcher.post(runnable);
    }

    public void postDelay(Runnable runnable, long j) {
        GlobalDispatcher.postDelay(runnable, j);
    }
}
