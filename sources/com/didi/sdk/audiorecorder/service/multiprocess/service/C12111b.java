package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.IFileSliceListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import java.util.concurrent.ExecutorService;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.service.b */
/* compiled from: FileSliceListenerWrapper */
final class C12111b implements AudioRecorder.FileSliceListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IFileSliceListener f35525a;

    /* renamed from: b */
    private ExecutorService f35526b;

    C12111b(ExecutorService executorService) {
        this.f35526b = executorService;
    }

    /* renamed from: a */
    public void mo91218a(IFileSliceListener iFileSliceListener) {
        this.f35525a = iFileSliceListener;
    }

    public void onAudioFileCreated(String str) {
        if (this.f35525a != null) {
            this.f35526b.execute(new FileSliceListenerWrapper$1(this, str));
        }
    }

    public void onAudioFileSliced(String str) {
        if (this.f35525a != null) {
            this.f35526b.execute(new FileSliceListenerWrapper$2(this, str));
        }
    }
}
