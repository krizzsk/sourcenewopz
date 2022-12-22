package com.didichuxing.dfbasesdk.ottoevent;

public class SignFaceAgreementEvent {
    public static final int AGREE = 1;
    public static final int AGREE_CANCEL = 2;
    public static final int AGREE_NO = 0;
    public final int agree;

    public SignFaceAgreementEvent() {
        this(2);
    }

    public SignFaceAgreementEvent(int i) {
        this.agree = i;
    }

    public boolean isAgree() {
        return this.agree == 1;
    }

    public boolean isDeny() {
        return this.agree == 0;
    }
}
