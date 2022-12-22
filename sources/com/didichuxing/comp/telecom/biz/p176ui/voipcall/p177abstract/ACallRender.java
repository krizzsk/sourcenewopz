package com.didichuxing.comp.telecom.biz.p176ui.voipcall.p177abstract;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageState;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0015J\u0006\u0010\u0016\u001a\u00020\u0014J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0017R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/abstract/ACallRender;", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallListener;", "mCurCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getMCurCall", "()Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "setMCurCall", "<set-?>", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;", "mUiState", "getMUiState", "()Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;", "setMUiState", "(Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;)V", "notifyPageStateChange", "", "newState", "onDestroy", "onStateChange", "call", "state", "Lcom/didichuxing/comp/telecom/core/CallState;", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.abstract.ACallRender */
/* compiled from: ACallRender.kt */
public abstract class ACallRender implements VoipCallListener {

    /* renamed from: a */
    private final String f46314a = "ACallRender";

    /* renamed from: b */
    private VoipCallPageState f46315b = VoipCallPageState.INITIALED;

    /* renamed from: c */
    private VoipAudioCall f46316c;

    /* access modifiers changed from: protected */
    public void notifyPageStateChange(VoipCallPageState voipCallPageState) {
        Intrinsics.checkParameterIsNotNull(voipCallPageState, "newState");
    }

    public ACallRender(VoipAudioCall voipAudioCall) {
        this.f46316c = voipAudioCall;
        VoipAudioCall voipAudioCall2 = this.f46316c;
        CallState callState = null;
        if (voipAudioCall2 != null) {
            voipAudioCall2.bindCallListener(this, (LifecycleOwner) null, false);
        }
        VoipCallPageState.Companion companion = VoipCallPageState.Companion;
        VoipAudioCall voipAudioCall3 = this.f46316c;
        VoipCallPageState fromCallState = companion.fromCallState(voipAudioCall3 != null ? voipAudioCall3.getState() : callState);
        this.f46315b = fromCallState == null ? VoipCallPageState.INITIALED : fromCallState;
    }

    /* access modifiers changed from: protected */
    public final VoipAudioCall getMCurCall() {
        return this.f46316c;
    }

    public void notifyStateDes(String str) {
        VoipCallListener.DefaultImpls.notifyStateDes(this, str);
    }

    public void onAudioDeviceChange(VoipAudioCall voipAudioCall, int i) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
        VoipCallListener.DefaultImpls.onAudioDeviceChange(this, voipAudioCall, i);
    }

    public void onMicStateChange(VoipAudioCall voipAudioCall, boolean z) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, "voipAudioCall");
        VoipCallListener.DefaultImpls.onMicStateChange(this, voipAudioCall, z);
    }

    /* access modifiers changed from: protected */
    public final void setMCurCall(VoipAudioCall voipAudioCall) {
        this.f46316c = voipAudioCall;
    }

    /* access modifiers changed from: protected */
    public String getTAG() {
        return this.f46314a;
    }

    public final VoipCallPageState getMUiState() {
        return this.f46315b;
    }

    /* access modifiers changed from: protected */
    public final void setMUiState(VoipCallPageState voipCallPageState) {
        Intrinsics.checkParameterIsNotNull(voipCallPageState, "<set-?>");
        this.f46315b = voipCallPageState;
    }

    public final void onDestroy() {
        VoipAudioCall voipAudioCall = this.f46316c;
        if (voipAudioCall != null) {
            voipAudioCall.unbindCallListener(this);
        }
        this.f46316c = null;
    }

    public void onStateChange(VoipAudioCall voipAudioCall, CallState callState) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(callState, "state");
        VoipCallListener.DefaultImpls.onStateChange(this, voipAudioCall, callState);
        VoipCallPageState fromCallState = VoipCallPageState.Companion.fromCallState(callState);
        if (fromCallState != null && fromCallState != this.f46315b) {
            String tag = getTAG();
            CallLogUtil.logI(tag, "notifyPageStateChange - cur:" + this.f46315b + " new:" + fromCallState);
            this.f46315b = fromCallState;
            notifyPageStateChange(fromCallState);
        }
    }
}
