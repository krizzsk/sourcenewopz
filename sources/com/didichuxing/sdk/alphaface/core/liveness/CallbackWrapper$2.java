package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$2 implements Runnable {
    final /* synthetic */ C16337c this$0;
    final /* synthetic */ int[] val$actions;

    CallbackWrapper$2(C16337c cVar, int[] iArr) {
        this.this$0 = cVar;
        this.val$actions = iArr;
    }

    public void run() {
        if (this.this$0.f48730a != null) {
            this.this$0.f48730a.onStartAction(this.val$actions);
        }
    }
}
