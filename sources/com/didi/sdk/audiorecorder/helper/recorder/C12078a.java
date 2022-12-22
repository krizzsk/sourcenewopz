package com.didi.sdk.audiorecorder.helper.recorder;

import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.recorder.modules.MicRecorderApi28;
import com.didi.sdk.audiorecorder.helper.recorder.modules.PcmRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedPcmRecorder;
import com.didi.sdk.audiorecorder.model.AudioRecordContextParcel;
import com.didi.sdk.audiorecorder.utils.LogUtil;

/* renamed from: com.didi.sdk.audiorecorder.helper.recorder.a */
/* compiled from: PcmRecorderFactory */
class C12078a {
    C12078a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PcmRecorder mo91068a(AudioRecordContext audioRecordContext, AudioRecordContextParcel audioRecordContextParcel) {
        boolean z = false;
        if ((audioRecordContextParcel != null ? audioRecordContextParcel.pcmConvertSwitch : 0) == 1) {
            z = true;
        }
        LogUtil.log("PcmRecorderFactory create : " + z);
        if (z) {
            return new FixedPcmRecorder();
        }
        return new MicRecorderApi28();
    }
}
