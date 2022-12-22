package com.android.didi.bfflib;

public class BffExtra {
    public String abilityId;
    public int errNo;
    public int errType;
    public Exception exception;
    public String traceId;

    public BffExtra(String str, String str2) {
        this.traceId = str;
        this.abilityId = str2;
    }

    public BffExtra(String str, int i, String str2, Exception exc) {
        this.traceId = str;
        this.errType = i;
        this.exception = exc;
        this.abilityId = str2;
    }

    public BffExtra(String str, int i, String str2, Exception exc, int i2) {
        this.traceId = str;
        this.errType = i;
        this.exception = exc;
        this.abilityId = str2;
        this.errNo = i2;
    }
}
