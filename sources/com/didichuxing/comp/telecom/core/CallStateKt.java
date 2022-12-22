package com.didichuxing.comp.telecom.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"inInitState", "", "state", "Lcom/didichuxing/comp/telecom/core/CallState;", "toStr", "", "Lcom/didichuxing/comp/telecom/core/CallRole;", "voip-core_release"}, mo175979k = 2, mo175980mv = {1, 1, 13})
/* compiled from: CallState.kt */
public final class CallStateKt {

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CallRole.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CallRole.CALL_MAKER.ordinal()] = 1;
            $EnumSwitchMapping$0[CallRole.CALLEE.ordinal()] = 2;
        }
    }

    public static final String toStr(CallRole callRole) {
        Intrinsics.checkParameterIsNotNull(callRole, "receiver$0");
        int i = WhenMappings.$EnumSwitchMapping$0[callRole.ordinal()];
        if (i != 1) {
            return i != 2 ? "" : "Called";
        }
        return "Calling";
    }

    public static final boolean inInitState(CallState callState) {
        Intrinsics.checkParameterIsNotNull(callState, "state");
        return callState == CallState.INITIALED;
    }
}
