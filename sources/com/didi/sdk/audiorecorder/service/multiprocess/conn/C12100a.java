package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import android.os.Handler;
import com.didi.sdk.audiorecorder.IErrorListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.conn.a */
/* compiled from: BinderErrorListener */
final class C12100a extends IErrorListener.Stub {

    /* renamed from: a */
    AudioRecorder.OnErrorListener f35489a;

    /* renamed from: b */
    private Handler f35490b;

    /* renamed from: c */
    private C12104e f35491c;

    C12100a(Handler handler, C12104e eVar) {
        this.f35490b = handler;
        this.f35491c = eVar;
    }

    public void onError(int i) {
        LogUtil.log("onError : " + i);
        if (this.f35489a != null) {
            this.f35490b.post(new BinderErrorListener$1(this, i));
        }
        if (i == 16) {
            this.f35491c.mo91197a();
        }
    }
}
