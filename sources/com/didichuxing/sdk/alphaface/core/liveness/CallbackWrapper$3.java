package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.liveness.IMirrorCallback;

class CallbackWrapper$3 implements Runnable {
    final /* synthetic */ C16337c this$0;
    final /* synthetic */ IMirrorCallback.FaceInfo val$faceInfo;

    CallbackWrapper$3(C16337c cVar, IMirrorCallback.FaceInfo faceInfo) {
        this.this$0 = cVar;
        this.val$faceInfo = faceInfo;
    }

    public void run() {
        if (this.this$0.f48730a != null) {
            this.this$0.f48730a.onDetectFace(this.val$faceInfo);
        }
    }
}
