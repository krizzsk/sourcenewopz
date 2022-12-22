package com.didichuxing.comp.telecom.core.voip.tipstate;

import android.content.Context;
import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/tipstate/CallStateTip;", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/AStateTip;", "voipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "mCurState", "Lcom/didichuxing/comp/telecom/core/CallState;", "mStateStr", "", "getTipStr", "component", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/TipStateComponent;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: TipStateChain.kt */
public final class CallStateTip extends AStateTip {

    /* renamed from: a */
    private CallState f46456a;

    /* renamed from: b */
    private String f46457b;

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CallState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CallState.INCOME_RINGING.ordinal()] = 1;
            $EnumSwitchMapping$0[CallState.INCOMING_CALL.ordinal()] = 2;
            $EnumSwitchMapping$0[CallState.OUTGOING_CALL.ordinal()] = 3;
            $EnumSwitchMapping$0[CallState.END_CALL.ordinal()] = 4;
        }
    }

    public CallStateTip(VoipAudioCall voipAudioCall) {
        super(voipAudioCall);
    }

    public String getTipStr(TipStateComponent tipStateComponent) {
        CallState state;
        Intrinsics.checkParameterIsNotNull(tipStateComponent, "component");
        VoipAudioCall mVoipCall = getMVoipCall();
        if (mVoipCall == null || (state = mVoipCall.getState()) == CallState.IN_CALL) {
            return null;
        }
        if (state == this.f46456a) {
            return this.f46457b;
        }
        this.f46456a = state;
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        int i2 = -1;
        if (i == 1) {
            CallManagerAssist instance = CallManagerAssist.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
            Integer num = instance.getResources().get("voip_call_opposite_role");
            if (num != null) {
                i2 = num.intValue();
            }
            Context appContext = CallManager.Companion.getInstance().getAppContext();
            this.f46457b = appContext.getString(R.string.GDriver_IBT_Please_answer_OXoN, new Object[]{i2 > 0 ? appContext.getString(i2) : ""});
        } else if (i == 2) {
            this.f46457b = CallManager.Companion.getInstance().getAppContext().getString(R.string.GDriver_IBT_Please_connection_ywKQ);
        } else if (i == 3) {
            CallManagerAssist instance2 = CallManagerAssist.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance2, "CallManagerAssist.getInstance()");
            Integer num2 = instance2.getResources().get("voip_call_page_string_call_waiting");
            if (num2 != null) {
                i2 = num2.intValue();
            }
            if (i2 > 0) {
                try {
                    this.f46457b = CallManager.Companion.getInstance().getAppContext().getString(i2);
                } catch (Exception unused) {
                }
            }
        } else if (i == 4) {
            this.f46457b = CallManager.Companion.getInstance().getAppContext().getString(R.string.GDriver_IBT_End_of_FFpF);
        }
        return this.f46457b;
    }
}
