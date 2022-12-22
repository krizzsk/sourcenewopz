package com.didi.sdk.audiorecorder.service.multiprocess.conn;

class BinderErrorListener$1 implements Runnable {
    final /* synthetic */ C12100a this$0;
    final /* synthetic */ int val$errorCode;

    BinderErrorListener$1(C12100a aVar, int i) {
        this.this$0 = aVar;
        this.val$errorCode = i;
    }

    public void run() {
        if (this.this$0.f35489a != null) {
            this.this$0.f35489a.onError(this.val$errorCode);
        }
    }
}
