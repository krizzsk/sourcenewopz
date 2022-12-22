package com.didichuxing.comp.telecom.biz.p176ui.voipcall;

import com.didichuxing.comp.telecom.core.CallState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u0004¨\u0006\u0005"}, mo175978d2 = {"toStr", "", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;", "toUiState", "Lcom/didichuxing/comp/telecom/core/CallState;", "voip-biz_release"}, mo175979k = 2, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageStateKt */
/* compiled from: VoipCallPageState.kt */
public final class VoipCallPageStateKt {

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageStateKt$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VoipCallPageState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[VoipCallPageState.OUTGOING_CALLING.ordinal()] = 1;
            $EnumSwitchMapping$0[VoipCallPageState.OUTGOING_CALLING_WAITING.ordinal()] = 2;
            $EnumSwitchMapping$0[VoipCallPageState.INCOME_RINGING.ordinal()] = 3;
            $EnumSwitchMapping$0[VoipCallPageState.INCOME_CALLING.ordinal()] = 4;
            $EnumSwitchMapping$0[VoipCallPageState.IN_CALL.ordinal()] = 5;
        }
    }

    public static final String toStr(VoipCallPageState voipCallPageState) {
        Intrinsics.checkParameterIsNotNull(voipCallPageState, "receiver$0");
        int i = WhenMappings.$EnumSwitchMapping$0[voipCallPageState.ordinal()];
        if (i == 1 || i == 2) {
            return "Call";
        }
        if (i == 3 || i == 4) {
            return "Ring";
        }
        return i != 5 ? "" : "Conversation";
    }

    public static final VoipCallPageState toUiState(CallState callState) {
        Intrinsics.checkParameterIsNotNull(callState, "receiver$0");
        return VoipCallPageState.Companion.fromCallState(callState);
    }
}
