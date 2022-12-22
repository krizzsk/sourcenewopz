package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$6 implements Runnable {
    final /* synthetic */ C16337c this$0;
    final /* synthetic */ int val$p;

    CallbackWrapper$6(C16337c cVar, int i) {
        this.this$0 = cVar;
        this.val$p = i;
    }

    public void run() {
        if (this.this$0.f48730a != null) {
            this.this$0.f48730a.onMirrorProcess((long) this.val$p);
        }
    }
}
