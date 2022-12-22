package com.didi.dimina.container.secondparty.http;

import com.didi.dimina.container.secondparty.http.ProgressRequestBody;
import com.didi.dimina.container.service.NetworkService;

class UploadTask$1 implements ProgressRequestBody.ProgressListener {
    final /* synthetic */ C7534d this$0;
    final /* synthetic */ NetworkService.ITaskCallback val$callback;

    UploadTask$1(C7534d dVar, NetworkService.ITaskCallback iTaskCallback) {
        this.this$0 = dVar;
        this.val$callback = iTaskCallback;
    }

    public void onProgressUpdate(long j, long j2) {
        this.val$callback.onProgressUpdate(j, (float) j2);
    }
}
