package com.didichuxing.sdk.alphaface.core.liveness;

class CallbackWrapper$13 implements Runnable {
    final /* synthetic */ C16337c this$0;
    final /* synthetic */ int val$action;
    final /* synthetic */ int[] val$info;
    final /* synthetic */ int val$pass;
    final /* synthetic */ int val$type;

    CallbackWrapper$13(C16337c cVar, int i, int i2, int i3, int[] iArr) {
        this.this$0 = cVar;
        this.val$pass = i;
        this.val$type = i2;
        this.val$action = i3;
        this.val$info = iArr;
    }

    public void run() {
        if (this.this$0.f48730a != null) {
            this.this$0.f48730a.onActionInfo(this.val$pass, this.val$type, this.val$action, this.val$info);
        }
    }
}
