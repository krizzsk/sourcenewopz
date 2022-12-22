package com.didichuxing.comp.telecom.biz.p176ui.voipcall;

import com.didichuxing.comp.telecom.core.CallState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;", "", "(Ljava/lang/String;I)V", "INITIALED", "OUTGOING_CALLING", "OUTGOING_CALLING_WAITING", "INCOME_RINGING", "INCOME_CALLING", "IN_CALL", "Companion", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState */
/* compiled from: VoipCallPageState.kt */
public enum VoipCallPageState {
    INITIALED,
    OUTGOING_CALLING,
    OUTGOING_CALLING_WAITING,
    INCOME_RINGING,
    INCOME_CALLING,
    IN_CALL;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState$Companion;", "", "()V", "fromCallState", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;", "callState", "Lcom/didichuxing/comp/telecom/core/CallState;", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState$Companion */
    /* compiled from: VoipCallPageState.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VoipCallPageState fromCallState(CallState callState) {
            if (callState == null) {
                return null;
            }
            if (callState == CallState.INITIALED) {
                return VoipCallPageState.INITIALED;
            }
            if (callState == CallState.OUTGOING_CALL) {
                return VoipCallPageState.OUTGOING_CALLING;
            }
            Comparable comparable = CallState.OUTGOING_CALL_CANCELING;
            Comparable comparable2 = callState;
            if (comparable2.compareTo(CallState.OUTGOING_CALL_WAITING) >= 0 && comparable2.compareTo(comparable) <= 0) {
                return VoipCallPageState.OUTGOING_CALLING_WAITING;
            }
            if (callState == CallState.INCOME_RINGING) {
                return VoipCallPageState.INCOME_RINGING;
            }
            Comparable comparable3 = CallState.INCOMING_CALL_CANCELING;
            if (comparable2.compareTo(CallState.INCOMING_CALL) >= 0 && comparable2.compareTo(comparable3) <= 0) {
                return VoipCallPageState.INCOME_CALLING;
            }
            if (callState == CallState.IN_CALL) {
                return VoipCallPageState.IN_CALL;
            }
            return null;
        }
    }
}
