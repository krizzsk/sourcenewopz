package com.didi.component.service.util.verifycard;

import com.didi.payment.creditcard.open.DidiGlobalCheckCardData;

public abstract class IVerifyOperation {
    public void onChangePayMethod() {
    }

    public void onReVerfiry() {
    }

    public void onSuccess() {
    }

    public void onVerify(DidiGlobalCheckCardData.CheckCardParam checkCardParam) {
    }
}
