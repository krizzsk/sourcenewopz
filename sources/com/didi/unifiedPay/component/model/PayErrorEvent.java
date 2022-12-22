package com.didi.unifiedPay.component.model;

import java.io.Serializable;

public class PayErrorEvent implements Serializable {
    public int errorCode;
    public String message;

    public PayErrorEvent(int i, String str) {
        this.errorCode = i;
        this.message = str;
    }
}
