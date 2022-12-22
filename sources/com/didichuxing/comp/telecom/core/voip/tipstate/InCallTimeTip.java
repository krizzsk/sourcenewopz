package com.didichuxing.comp.telecom.core.voip.tipstate;

import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/tipstate/InCallTimeTip;", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/AStateTip;", "voipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "getTipStr", "", "component", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/TipStateComponent;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: TipStateChain.kt */
public final class InCallTimeTip extends AStateTip {
    public InCallTimeTip(VoipAudioCall voipAudioCall) {
        super(voipAudioCall);
    }

    public String getTipStr(TipStateComponent tipStateComponent) {
        Object obj;
        Object obj2;
        Intrinsics.checkParameterIsNotNull(tipStateComponent, "component");
        VoipAudioCall mVoipCall = getMVoipCall();
        if (mVoipCall == null || mVoipCall.getState() != CallState.IN_CALL || mVoipCall.getCallStartTime() <= 0) {
            return null;
        }
        long currentTimeMillis = (System.currentTimeMillis() - mVoipCall.getCallStartTime()) / 1000;
        long j = (long) 60;
        long j2 = currentTimeMillis / j;
        long j3 = (long) 10;
        if (j2 < j3) {
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            sb.append(j2);
            obj = sb.toString();
        } else {
            obj = Long.valueOf(j2);
        }
        long j4 = currentTimeMillis % j;
        if (j4 < j3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('0');
            sb2.append(j4);
            obj2 = sb2.toString();
        } else {
            obj2 = Long.valueOf(j4);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append(':');
        sb3.append(obj2);
        return sb3.toString();
    }
}
