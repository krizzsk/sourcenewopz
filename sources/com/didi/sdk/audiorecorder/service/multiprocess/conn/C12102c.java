package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import android.os.Handler;
import com.didi.sdk.audiorecorder.IDurationChangedListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.conn.c */
/* compiled from: BinderRecordDurationListener */
final class C12102c extends IDurationChangedListener.Stub {

    /* renamed from: a */
    AudioRecorder.DurationChangedListener f35494a;

    /* renamed from: b */
    private Handler f35495b;

    C12102c(Handler handler) {
        this.f35495b = handler;
    }

    public void onTimeTick(int i) {
        if (this.f35494a != null) {
            this.f35495b.post(new BinderRecordDurationListener$1(this, i));
        }
    }
}
