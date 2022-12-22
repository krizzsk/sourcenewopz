package com.didichuxing.comp.telecom.core;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/CallState;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "INITIALED", "OUTGOING_CALL", "OUTGOING_CALL_WAITING", "OUTGOING_CALL_ANSWERING", "OUTGOING_CALL_CANCELING", "INCOME_RINGING", "INCOMING_CALL", "INCOMING_CALL_WAITING", "INCOMING_CALL_ESTABLISHED", "INCOMING_CALL_CANCELING", "IN_CALL", "END_CALL", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallState.kt */
public enum CallState {
    INITIALED(0),
    OUTGOING_CALL(101),
    OUTGOING_CALL_WAITING(102),
    OUTGOING_CALL_ANSWERING(103),
    OUTGOING_CALL_CANCELING(104),
    INCOME_RINGING(201),
    INCOMING_CALL(202),
    INCOMING_CALL_WAITING(203),
    INCOMING_CALL_ESTABLISHED(204),
    INCOMING_CALL_CANCELING(205),
    IN_CALL(301),
    END_CALL(401);
    
    private final int value;

    private CallState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
