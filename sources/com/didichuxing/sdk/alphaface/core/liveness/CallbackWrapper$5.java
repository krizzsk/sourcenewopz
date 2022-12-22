package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$5 implements Runnable {
    final /* synthetic */ C16337c this$0;

    CallbackWrapper$5(C16337c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        if (this.this$0.f48730a != null) {
            this.this$0.f48730a.onMirrorFaceQualityError();
        }
    }
}
