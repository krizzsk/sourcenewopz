package com.didi.payment.base.net;

import java.io.Serializable;

public class HttpError implements Serializable {
    public String errCode;
    public String errMsg;

    public HttpError(String str, String str2) {
        this.errCode = str;
        this.errMsg = str2;
    }
}
