package com.didi.payment.kycservice.kyc.fragment;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/EResultPageBtnAction;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ACTION_OK", "ACTION_OK_REQ_CONTACT", "ACTION_TRY_AGAIN", "ACTION_CONTINUE", "ACTION_NULL", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EResultPageBtnAction.kt */
public enum EResultPageBtnAction {
    ACTION_OK(1),
    ACTION_OK_REQ_CONTACT(2),
    ACTION_TRY_AGAIN(3),
    ACTION_CONTINUE(4),
    ACTION_NULL(5);
    
    private final int value;

    private EResultPageBtnAction(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
