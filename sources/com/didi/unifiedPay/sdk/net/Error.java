package com.didi.unifiedPay.sdk.net;

import java.io.Serializable;

public class Error implements Serializable {
    public final int code;
    public final String msg;

    public Error(int i, String str) {
        this.code = i;
        this.msg = str;
    }
}
