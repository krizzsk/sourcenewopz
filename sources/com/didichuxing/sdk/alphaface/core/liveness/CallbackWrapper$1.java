package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$1 implements Runnable {
    final /* synthetic */ C16337c this$0;
    final /* synthetic */ int val$type;

    CallbackWrapper$1(C16337c cVar, int i) {
        this.this$0 = cVar;
        this.val$type = i;
    }

    public void run() {
        if (this.this$0.f48730a != null) {
            this.this$0.f48730a.onFaceError(this.val$type);
        }
    }
}
