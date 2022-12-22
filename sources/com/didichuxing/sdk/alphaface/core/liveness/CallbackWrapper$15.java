package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$15 implements Runnable {
    final /* synthetic */ C16337c this$0;

    CallbackWrapper$15(C16337c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        if (this.this$0.f48730a != null) {
            this.this$0.f48730a.onActionFailed();
        }
    }
}
