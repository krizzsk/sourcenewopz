package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.utils.LogUtil;

class ErrorListenerWrapper$1 implements Runnable {
    final /* synthetic */ C12110a this$0;
    final /* synthetic */ int val$errorCode;

    ErrorListenerWrapper$1(C12110a aVar, int i) {
        this.this$0 = aVar;
        this.val$errorCode = i;
    }

    public void run() {
        try {
            this.this$0.f35523a.onError(this.val$errorCode);
        } catch (Exception e) {
            LogUtil.log("ErrorListenerWrapper -> callback onError fail. code = " + this.val$errorCode, e.getMessage());
        }
    }
}
