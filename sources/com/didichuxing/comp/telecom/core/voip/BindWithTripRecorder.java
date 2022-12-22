package com.didichuxing.comp.telecom.core.voip;

import android.os.Looper;
import com.didi.sdk.audiorecorder.AudioRecordManager;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecordActionListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.mlcp.drtc.interfaces.InCallingService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u001a\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u000eJ\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/BindWithTripRecorder;", "Lcom/didi/sdk/audiorecorder/helper/recorder/AudioRecorder$RecordListener;", "Lcom/didi/sdk/audiorecorder/helper/recorder/Supporter$Pcm16kConsumer;", "Lcom/didi/sdk/audiorecorder/helper/recorder/AudioRecordActionListener;", "()V", "TAG", "", "lastTickTime", "", "service", "Lcom/didichuxing/mlcp/drtc/interfaces/InCallingService;", "session", "Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl;", "bindWithTripRecorder", "", "isRecording", "", "onPause", "onPcm16kFeed", "bytes", "", "length", "", "onRelease", "onResume", "onStart", "onStop", "onTriggerResume", "onTriggerStart", "setPcm16kProvider", "p0", "Lcom/didi/sdk/audiorecorder/helper/recorder/Supporter$Pcm16kProvider;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: BindWithTripRecorder.kt */
public final class BindWithTripRecorder implements AudioRecordActionListener, AudioRecorder.RecordListener, Supporter.Pcm16kConsumer {

    /* renamed from: a */
    private final String f46424a = "BindWithTripRecorder";

    /* renamed from: b */
    private VoipSessionImpl f46425b;

    /* renamed from: c */
    private InCallingService f46426c;

    /* renamed from: d */
    private long f46427d;

    public void setPcm16kProvider(Supporter.Pcm16kProvider pcm16kProvider) {
    }

    public final boolean isRecording() {
        try {
            AudioRecordManager audioRecordManager = AudioRecordManager.get();
            Intrinsics.checkExpressionValueIsNotNull(audioRecordManager, "AudioRecordManager.get()");
            return audioRecordManager.isRecording();
        } catch (Exception e) {
            CallLogUtil.logError(this.f46424a, "isRecording error", e);
            return false;
        }
    }

    public final void bindWithTripRecorder(VoipSessionImpl voipSessionImpl, InCallingService inCallingService) {
        Intrinsics.checkParameterIsNotNull(voipSessionImpl, "session");
        Intrinsics.checkParameterIsNotNull(inCallingService, "service");
        CallLogUtil.logI(this.f46424a, "bindWithTripRecorder");
        this.f46425b = voipSessionImpl;
        this.f46426c = inCallingService;
        try {
            AudioRecordManager audioRecordManager = AudioRecordManager.get();
            audioRecordManager.setRecordListener(this);
            audioRecordManager.addRecordActionListener(this);
            audioRecordManager.register16kPcmConsumer(this);
        } catch (Exception e) {
            CallLogUtil.logError(this.f46424a, "bindWithTripRecorder error", e);
        }
    }

    public final void onRelease() {
        try {
            AudioRecordManager audioRecordManager = AudioRecordManager.get();
            audioRecordManager.removeRecordListener(this);
            audioRecordManager.removeRecordActionListener(this);
            audioRecordManager.unregister16kPcmConsumer(this);
        } catch (Exception e) {
            CallLogUtil.logError(this.f46424a, "onRelease error", e);
        }
        this.f46426c = null;
        this.f46425b = null;
    }

    public void onTriggerStart() {
        CallLogUtil.logI(this.f46424a, "trip audio record - onTriggerStart");
        InCallingService inCallingService = this.f46426c;
        if (inCallingService != null) {
            inCallingService.stopExAudioRec();
        }
    }

    public void onTriggerResume() {
        CallLogUtil.logI(this.f46424a, "trip audio record - onTriggerResume");
        InCallingService inCallingService = this.f46426c;
        if (inCallingService != null) {
            inCallingService.stopExAudioRec();
        }
    }

    public void onStart() {
        CallLogUtil.logI(this.f46424a, "trip audio record - onStart");
        InCallingService inCallingService = this.f46426c;
        if (inCallingService != null) {
            inCallingService.stopExAudioRec();
        }
    }

    public void onResume() {
        CallLogUtil.logI(this.f46424a, "trip audio record - onResume");
        InCallingService inCallingService = this.f46426c;
        if (inCallingService != null) {
            inCallingService.stopExAudioRec();
        }
    }

    public void onPause() {
        CallLogUtil.logI(this.f46424a, "trip audio record - onPause");
        InCallingService inCallingService = this.f46426c;
        if (inCallingService != null) {
            inCallingService.restartExAudioRec();
        }
    }

    public void onStop() {
        CallLogUtil.logI(this.f46424a, "trip audio record - onStop");
        InCallingService inCallingService = this.f46426c;
        if (inCallingService != null) {
            inCallingService.restartExAudioRec();
        }
    }

    public void onPcm16kFeed(byte[] bArr, int i) {
        InCallingService inCallingService;
        try {
            VoipSessionImpl voipSessionImpl = this.f46425b;
            if ((voipSessionImpl != null ? voipSessionImpl.getState() : null) == CallState.IN_CALL) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f46427d > 2000) {
                    this.f46427d = currentTimeMillis;
                    String str = this.f46424a;
                    CallLogUtil.logDebug(str, "AudioRecordManager - onPcm16kFeed onUiThread:" + Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.myLooper()) + " length:" + i);
                }
                if (bArr != null && (inCallingService = this.f46426c) != null) {
                    inCallingService.pushExternalAudioFrame(bArr);
                }
            }
        } catch (Exception e) {
            CallLogUtil.logError(this.f46424a, "onPcm16kFeed error", e);
        }
    }
}
