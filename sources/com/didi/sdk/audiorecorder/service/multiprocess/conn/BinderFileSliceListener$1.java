package com.didi.sdk.audiorecorder.service.multiprocess.conn;

class BinderFileSliceListener$1 implements Runnable {
    final /* synthetic */ C12101b this$0;
    final /* synthetic */ String val$filePath;

    BinderFileSliceListener$1(C12101b bVar, String str) {
        this.this$0 = bVar;
        this.val$filePath = str;
    }

    public void run() {
        if (this.this$0.f35492a != null) {
            this.this$0.f35492a.onAudioFileCreated(this.val$filePath);
        }
    }
}
