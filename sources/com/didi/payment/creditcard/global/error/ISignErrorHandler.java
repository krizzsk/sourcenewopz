package com.didi.payment.creditcard.global.error;

import com.didi.payment.creditcard.global.model.bean.SignResult;

public interface ISignErrorHandler {
    public static final int CODE_CARD_EXPIRED = 16104;
    public static final int CODE_CARD_INVALID = 16105;
    public static final int CODE_CVC_INVALID = 16106;
    public static final int CODE_INSUFFICIENT_FUNDS = 16103;
    public static final int CODE_LIMITED = 16102;
    public static final int CODE_PAYMENT_SYSTEM_ERROR = 16107;
    public static final int CODE_REJECTED = 16101;
    public static final int CODE_SECURITY = 16108;
    public static final int CODE_SYSTEM_BUSY = 16120;
    public static final int CODE_SYSTEM_ERROR = 16100;

    public interface Callback {
        void onResult(int i, SignResult signResult);
    }

    void handleError(SignResult signResult);

    void setCallback(Callback callback);
}
