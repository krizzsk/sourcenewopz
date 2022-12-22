package com.didi.sdk.apm;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;

class MainThreadWatcher$1 implements Runnable {
    final /* synthetic */ C11887c this$0;

    MainThreadWatcher$1(C11887c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                Log.d(C11887c.f34976a, "main thread idle");
                return true;
            }
        });
    }
}
