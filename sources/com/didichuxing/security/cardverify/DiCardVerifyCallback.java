package com.didichuxing.security.cardverify;

public interface DiCardVerifyCallback {
    public static final int CODE_CANCEL_RANDOM_PAY = 2;
    public static final int CODE_CUSTOMER_SERVICE = 4;
    public static final int CODE_INSUFFICIENT = 3;
    public static final int CODE_INVALID_PARAM = 4;
    public static final int CODE_NET_EXCEPTION = 7;
    public static final int CODE_PAYMENT_NOT_FINISH = 1;
    public static final int CODE_POLLING_FAIL = 9;
    public static final int CODE_RANDOM_PAY_FAIL = 8;
    public static final int CODE_REMOVE_CARD = 3;
    public static final int CODE_REQUEST_PAY_STATUS_FINISH = 1;
    public static final int CODE_SERVICE_EXCEPTION = 6;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNKNOWN_ERROR = -1;
    public static final int CODE_USER_CANCEL = 2;
    public static final int CODE_VERIFY_FAIL = 5;

    void onCallback(int i, String str);
}
