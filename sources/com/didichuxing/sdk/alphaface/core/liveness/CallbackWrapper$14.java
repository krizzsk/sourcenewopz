package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$14 implements Runnable {
    final /* synthetic */ C16337c this$0;
    final /* synthetic */ int val$action;

    CallbackWrapper$14(C16337c cVar, int i) {
        this.this$0 = cVar;
        this.val$action = i;
    }

    public void run() {
        if (this.this$0.f48730a != null) {
            this.this$0.f48730a.onActionTip(this.val$action);
        }
    }
}
