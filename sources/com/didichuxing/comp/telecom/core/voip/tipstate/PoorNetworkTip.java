package com.didichuxing.comp.telecom.core.voip.tipstate;

import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/tipstate/PoorNetworkTip;", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/AStateTip;", "voipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "mPoorNetworkStr", "", "getTipStr", "component", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/TipStateComponent;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: TipStateChain.kt */
public final class PoorNetworkTip extends AStateTip {

    /* renamed from: a */
    private String f46458a;

    public PoorNetworkTip(VoipAudioCall voipAudioCall) {
        super(voipAudioCall);
    }

    public String getTipStr(TipStateComponent tipStateComponent) {
        Intrinsics.checkParameterIsNotNull(tipStateComponent, "component");
        VoipAudioCall mVoipCall = getMVoipCall();
        if (mVoipCall == null || mVoipCall.getState() == CallState.END_CALL || !tipStateComponent.getNetworkPoor()) {
            return null;
        }
        if (this.f46458a == null) {
            this.f46458a = CallManager.Companion.getInstance().getAppContext().getString(R.string.GDriver_IBT_Your_network_EfMe);
        }
        return this.f46458a;
    }
}
