package com.didi.sdk.audiorecorder.service.mainprocess;

import android.os.RemoteException;
import com.didi.sdk.audiorecorder.IFileSliceListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;

/* renamed from: com.didi.sdk.audiorecorder.service.mainprocess.a */
/* compiled from: FileSliceListenerWrapper */
final class C12087a implements AudioRecorder.FileSliceListener {

    /* renamed from: a */
    private IFileSliceListener f35445a;

    C12087a() {
    }

    /* renamed from: a */
    public void mo91159a(IFileSliceListener iFileSliceListener) {
        this.f35445a = iFileSliceListener;
    }

    public void onAudioFileCreated(String str) {
        try {
            this.f35445a.onAudioFileCreated(str);
        } catch (RemoteException e) {
            LogUtil.log("FileSliceListenerWrapper -> callback onAudioFileCreated fail. ", e);
        }
    }

    public void onAudioFileSliced(String str) {
        try {
            this.f35445a.onAudioFileSliced(str);
        } catch (RemoteException e) {
            LogUtil.log("Failed to callback onAudioFileSliced listener", e);
        }
    }
}
