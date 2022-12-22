package com.didi.sdk.apm;

import android.os.SystemClock;
import android.util.Log;

class MainThreadWatcher$2 implements Runnable {
    final /* synthetic */ C11887c this$0;

    MainThreadWatcher$2(C11887c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.this$0.f34987l;
        Log.i(C11887c.f34976a, "loop for " + uptimeMillis + " ms");
        this.this$0.f34981f.set(true);
    }
}
