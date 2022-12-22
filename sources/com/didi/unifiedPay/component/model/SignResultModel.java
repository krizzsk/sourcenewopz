package com.didi.unifiedPay.component.model;

import java.io.Serializable;

public class SignResultModel implements Serializable {
    public static final int HANDLE_CODE = 5;
    public static final int RESULT_CANCEL = 2;
    public static final int RESULT_FAILED = 4;
    public static final int RESULT_HANDING = 3;
    public static final int RESULT_SUCCESS = 1;
    public int code;
    public String message;
    public int result;
}
