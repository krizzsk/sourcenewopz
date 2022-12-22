package com.didi.unifiedPay.sdk.internal;

import java.io.Serializable;

public class PayError implements Serializable {
    public static final int BANLANCE_INSUFFICIENT = 500101;
    public static final int BILL_CHANGE = 82153;
    public static final int BIND_REAL_BODY_FAIL = 11;
    public static final int CANCEL_BY_USER = 1;
    public static final int CANNOT_GET_PAY_RESULT = 3;
    public static final int EXCEED_MAX_PERIOD = 1059;
    public static final int INNER_PAY_NOT_SUFFICIENT = 4;
    public static final int NOT_BIND_VISA_CARD = 80200;
    public static final int NOT_SUPPORT_PAY = 2;
    public static final int NO_REASON = 0;
    public static final int PAY_CLOSED = 6;
    public static final int PAY_ERROR_RISK = 80201;
    public static final int PAY_ERR_ICE = 3042;
    public static final int PAY_ERR_NEED_PWD = 10902;
    public static final int PAY_FAILED = 5;
    public static final int PAY_RESULT_UNKNOWN = 7;
    public static final int PAY_SERVICE_NOT_USABLE = 82205;
    public static final int PRE_PAY_TIMEOUT = 12004;
    public static final int SHOULD_BIND_REAL_MESSAGE = 1302;
    public int errorCode;

    public PayError(int i) {
        this.errorCode = i;
    }
}
