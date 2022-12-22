package com.didi.unifiedPay.component.model;

import java.io.Serializable;

public class PayResult implements Serializable {
    public static final int RESULT_CANCEL = 3;
    public static final int RESULT_FAIL = 2;
    public static final int RESULT_SUCCESS = 1;
    public String msg;
    public int result;
}
