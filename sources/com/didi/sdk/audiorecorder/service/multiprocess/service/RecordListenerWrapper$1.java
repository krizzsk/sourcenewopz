package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.utils.LogUtil;

class RecordListenerWrapper$1 implements Runnable {
    final /* synthetic */ C12112c this$0;

    RecordListenerWrapper$1(C12112c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        try {
            this.this$0.f35531e.onStart();
        } catch (Exception e) {
            LogUtil.log("RecordListenerWrapper -> ", "Failed to callback onStart. ", e.getMessage());
        }
    }
}
