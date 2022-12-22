package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import android.os.Handler;
import com.didi.sdk.audiorecorder.ISpeechDetectListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.conn.d */
/* compiled from: BinderSpeechDetectListener */
final class C12103d extends ISpeechDetectListener.Stub {

    /* renamed from: b */
    private static final String f35496b = "BinderSpeechDetectListener -> ";

    /* renamed from: a */
    AudioRecorder.WordsDetectListener f35497a;

    /* renamed from: c */
    private Handler f35498c;

    C12103d(Handler handler) {
        this.f35498c = handler;
    }

    public void onWordDetected(String str) {
        LogUtil.log("BinderSpeechDetectListener -> onWordDetected : " + str);
        if (this.f35497a != null) {
            this.f35498c.post(new BinderSpeechDetectListener$1(this, str));
        }
    }
}
