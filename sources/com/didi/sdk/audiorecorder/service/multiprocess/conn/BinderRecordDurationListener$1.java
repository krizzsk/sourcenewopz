package com.didi.sdk.audiorecorder.service.multiprocess.conn;

class BinderRecordDurationListener$1 implements Runnable {
    final /* synthetic */ C12102c this$0;
    final /* synthetic */ int val$recordDuration;

    BinderRecordDurationListener$1(C12102c cVar, int i) {
        this.this$0 = cVar;
        this.val$recordDuration = i;
    }

    public void run() {
        if (this.this$0.f35494a != null) {
            this.this$0.f35494a.onTimeTick(this.val$recordDuration);
        }
    }
}
