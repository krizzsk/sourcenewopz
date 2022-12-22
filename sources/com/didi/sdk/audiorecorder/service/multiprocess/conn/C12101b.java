package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import android.os.Handler;
import com.didi.sdk.audiorecorder.IFileSliceListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.conn.b */
/* compiled from: BinderFileSliceListener */
final class C12101b extends IFileSliceListener.Stub {

    /* renamed from: a */
    AudioRecorder.FileSliceListener f35492a;

    /* renamed from: b */
    private Handler f35493b;

    C12101b(Handler handler) {
        this.f35493b = handler;
    }

    public void onAudioFileCreated(String str) {
        if (this.f35492a != null) {
            this.f35493b.post(new BinderFileSliceListener$1(this, str));
        }
    }

    public void onAudioFileSliced(String str) {
        if (this.f35492a != null) {
            this.f35493b.post(new BinderFileSliceListener$2(this, str));
        }
    }
}
