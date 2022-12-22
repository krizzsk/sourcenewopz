package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$9 implements Runnable {
    final /* synthetic */ C16337c this$0;
    final /* synthetic */ int val$time;

    CallbackWrapper$9(C16337c cVar, int i) {
        this.this$0 = cVar;
        this.val$time = i;
    }

    public void run() {
        this.this$0.f48730a.onActionCountdown(this.val$time);
    }
}
