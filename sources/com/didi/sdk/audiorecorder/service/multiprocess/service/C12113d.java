package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.ISpeechDetectListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import java.util.concurrent.ExecutorService;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.service.d */
/* compiled from: WordsDetectListenerWrapper */
final class C12113d implements AudioRecorder.WordsDetectListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ISpeechDetectListener f35537a;

    /* renamed from: b */
    private ExecutorService f35538b;

    C12113d(ExecutorService executorService) {
        this.f35538b = executorService;
    }

    /* renamed from: a */
    public void mo91225a(ISpeechDetectListener iSpeechDetectListener) {
        this.f35537a = iSpeechDetectListener;
    }

    public void onWordDetected(String str) {
        if (this.f35537a != null) {
            this.f35538b.execute(new WordsDetectListenerWrapper$1(this, str));
        }
    }
}
