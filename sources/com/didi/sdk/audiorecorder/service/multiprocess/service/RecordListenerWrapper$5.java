package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.utils.LogUtil;

class RecordListenerWrapper$5 implements Runnable {
    final /* synthetic */ C12112c this$0;
    final /* synthetic */ int val$recordDuration;

    RecordListenerWrapper$5(C12112c cVar, int i) {
        this.this$0 = cVar;
        this.val$recordDuration = i;
    }

    public void run() {
        try {
            this.this$0.f35532f.onTimeTick(this.val$recordDuration);
        } catch (Exception e) {
            LogUtil.log("RecordListenerWrapper -> ", "Failed to callback onTimeTick listener, recordDuration = " + this.val$recordDuration, e.getMessage());
        }
    }
}
