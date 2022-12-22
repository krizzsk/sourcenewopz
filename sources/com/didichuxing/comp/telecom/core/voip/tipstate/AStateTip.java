package com.didichuxing.comp.telecom.core.voip.tipstate;

import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\f"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/tipstate/AStateTip;", "", "mVoipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "getMVoipCall", "()Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "setMVoipCall", "getTipStr", "", "component", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/TipStateComponent;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: TipStateChain.kt */
public abstract class AStateTip {

    /* renamed from: a */
    private VoipAudioCall f46454a;

    public abstract String getTipStr(TipStateComponent tipStateComponent);

    public AStateTip(VoipAudioCall voipAudioCall) {
        this.f46454a = voipAudioCall;
    }

    /* access modifiers changed from: protected */
    public final VoipAudioCall getMVoipCall() {
        return this.f46454a;
    }

    /* access modifiers changed from: protected */
    public final void setMVoipCall(VoipAudioCall voipAudioCall) {
        this.f46454a = voipAudioCall;
    }
}
