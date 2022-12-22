package com.didi.sdk.apm;

import android.util.Log;
import android.util.Printer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

class MainThreadWatcher$3 implements Printer {
    final /* synthetic */ C11887c this$0;
    final /* synthetic */ AtomicReference val$lastMsg;
    final /* synthetic */ AtomicLong val$msgCount;

    MainThreadWatcher$3(C11887c cVar, AtomicLong atomicLong, AtomicReference atomicReference) {
        this.this$0 = cVar;
        this.val$msgCount = atomicLong;
        this.val$lastMsg = atomicReference;
    }

    public void println(String str) {
        if (this.val$msgCount.getAndIncrement() < 15) {
            Log.e(C11887c.f34976a, str);
        }
        this.val$lastMsg.set(str);
    }
}
