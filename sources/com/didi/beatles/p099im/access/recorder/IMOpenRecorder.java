package com.didi.beatles.p099im.access.recorder;

import android.text.TextUtils;
import com.didi.beatles.p099im.common.IMChatHelper;
import com.didi.beatles.p099im.common.audio.IMFileHelper;
import com.didi.beatles.p099im.common.audio.IMRecorderManager;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import java.io.File;

/* renamed from: com.didi.beatles.im.access.recorder.IMOpenRecorder */
public class IMOpenRecorder {

    /* renamed from: a */
    private static final String f8842a = "IMOpenRecorder";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IMOpenRecorderCallback f8843b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMOpenRecorderTip f8844c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f8845d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IMRecorderManager.Callback f8846e;

    public void setCallback(IMOpenRecorderCallback iMOpenRecorderCallback) {
        this.f8843b = iMOpenRecorderCallback;
    }

    public void setTip(IMOpenRecorderTip iMOpenRecorderTip) {
        this.f8844c = iMOpenRecorderTip;
    }

    public void startRecorder() {
        this.f8845d = IMRecorderManager.createFileId();
        this.f8846e = new IMRecorderManager.Callback() {
            public void onError(int i, String str) {
                if (IMOpenRecorder.this.f8843b == null) {
                    return;
                }
                if (i == 1) {
                    IMOpenRecorder.this.f8843b.onRecorderError(3);
                } else if (i == 2) {
                    IMOpenRecorder.this.f8843b.onRecorderError(1);
                } else if (i != 3) {
                    IMOpenRecorder.this.f8843b.onRecorderError(-1);
                } else {
                    IMOpenRecorder.this.f8843b.onRecorderError(2);
                }
            }

            public void onSuccess(String str, long j) {
                IMLog.m6635i(IMOpenRecorder.f8842a, C4234I.m6591t("recorder success ", str, " ", Long.valueOf(j)));
                File audioFile = IMFileHelper.getAudioFile(str);
                if (audioFile == null) {
                    IMLog.m6632e(IMOpenRecorder.f8842a, C4234I.m6591t("recorder file is empty ", str));
                    if (IMOpenRecorder.this.f8843b != null) {
                        IMOpenRecorder.this.f8843b.onRecorderError(-1);
                        return;
                    }
                    return;
                }
                IMOpenRecorder.this.f8843b.onRecorderFinish(audioFile.getAbsolutePath(), (int) (Math.min(j, (long) IMChatHelper.AUDIO_RECORD_MAX_DURATION) / 1000));
            }

            public void onStartRecord() {
                if (IMOpenRecorder.this.f8843b != null) {
                    IMOpenRecorder.this.f8843b.onRecorderStart();
                }
            }

            public void onSoundLevelChange(int i) {
                if (IMOpenRecorder.this.f8844c != null && IMOpenRecorder.this.f8844c.isShowing()) {
                    IMOpenRecorder.this.f8844c.mo41675a().changeBackGroundBySound(i);
                }
            }

            public void onResidueTimeChange(String str) {
                if (IMOpenRecorder.this.f8844c != null && IMOpenRecorder.this.f8844c.isShowing()) {
                    IMOpenRecorder.this.f8844c.mo41675a().showResidueTime(str);
                }
            }

            public void onEndRecord() {
                String unused = IMOpenRecorder.this.f8845d = null;
                IMRecorderManager.Callback unused2 = IMOpenRecorder.this.f8846e = null;
            }
        };
        IMRecorderManager.getInstance().recorder(this.f8845d, this.f8846e);
    }

    public void stopRecorder() {
        if (TextUtils.isEmpty(this.f8845d) || this.f8846e == null) {
            IMLog.m6637w(f8842a, "stopRecorder but recorder is already release");
            IMOpenRecorderCallback iMOpenRecorderCallback = this.f8843b;
            if (iMOpenRecorderCallback != null) {
                iMOpenRecorderCallback.onRecorderError(-1);
                return;
            }
            return;
        }
        IMRecorderManager.getInstance().stop(this.f8845d, this.f8846e);
    }
}
