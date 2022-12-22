package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.IErrorListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import java.util.concurrent.ExecutorService;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.service.a */
/* compiled from: ErrorListenerWrapper */
final class C12110a implements AudioRecorder.OnErrorListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IErrorListener f35523a;

    /* renamed from: b */
    private ExecutorService f35524b;

    C12110a(ExecutorService executorService) {
        this.f35524b = executorService;
    }

    /* renamed from: a */
    public void mo91217a(IErrorListener iErrorListener) {
        this.f35523a = iErrorListener;
    }

    public void onError(int i) {
        if (this.f35523a != null) {
            this.f35524b.execute(new ErrorListenerWrapper$1(this, i));
        }
    }
}
