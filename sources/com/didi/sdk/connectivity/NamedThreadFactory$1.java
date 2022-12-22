package com.didi.sdk.connectivity;

import com.didi.sdk.apm.SystemUtils;

class NamedThreadFactory$1 extends Thread {
    final /* synthetic */ C12169e this$0;
    final /* synthetic */ Runnable val$runnable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NamedThreadFactory$1(C12169e eVar, String str, Runnable runnable) {
        super(str);
        this.this$0 = eVar;
        this.val$runnable = runnable;
    }

    public void run() {
        SystemUtils.setProcessThreadPriority(10);
        this.val$runnable.run();
    }
}
