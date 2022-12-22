package com.didichuxing.comp.telecom.core.voip.tipstate;

import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/tipstate/TipStateComponent;", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallListener;", "mVoipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "TAG", "", "<set-?>", "curTipStr", "getCurTipStr", "()Ljava/lang/String;", "mHandler", "Landroid/os/Handler;", "mTipStateChain", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/TipStateChain;", "", "networkPoor", "getNetworkPoor", "()Z", "checkStateString", "", "destroy", "onStateChange", "call", "state", "Lcom/didichuxing/comp/telecom/core/CallState;", "showNetworkUnstable", "show", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: TipStateComponent.kt */
public final class TipStateComponent implements VoipCallListener {

    /* renamed from: a */
    private final String f46461a = "TipStateComponent";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f46462b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private TipStateChain f46463c = new TipStateChain(this.f46466f);

    /* renamed from: d */
    private String f46464d;

    /* renamed from: e */
    private boolean f46465e;

    /* renamed from: f */
    private VoipAudioCall f46466f;

    public TipStateComponent(VoipAudioCall voipAudioCall) {
        this.f46466f = voipAudioCall;
        VoipAudioCall voipAudioCall2 = this.f46466f;
        if (voipAudioCall2 != null) {
            VoipAudioCall.bindCallListener$default(voipAudioCall2, this, (LifecycleOwner) null, false, 6, (Object) null);
        }
        TipStateComponent$runnable$1 tipStateComponent$runnable$1 = new TipStateComponent$runnable$1(this);
        Handler handler = this.f46462b;
        if (handler != null) {
            handler.postDelayed(tipStateComponent$runnable$1, 200);
        }
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

    public final String getCurTipStr() {
        return this.f46464d;
    }

    public final boolean getNetworkPoor() {
        return this.f46465e;
    }

    public final void destroy() {
        Handler handler = this.f46462b;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.f46462b = null;
        VoipAudioCall voipAudioCall = this.f46466f;
        if (voipAudioCall != null) {
            voipAudioCall.unbindCallListener(this);
        }
        this.f46466f = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33308a() {
        VoipAudioCall voipAudioCall = this.f46466f;
        if (voipAudioCall != null) {
            String tipStr = this.f46463c.getTipStr(this);
            this.f46464d = tipStr;
            voipAudioCall.updateStateString(tipStr);
        }
    }

    public final void showNetworkUnstable(boolean z) {
        this.f46465e = z;
        m33308a();
    }

    public void onStateChange(VoipAudioCall voipAudioCall, CallState callState) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(callState, "state");
        m33308a();
    }
}
