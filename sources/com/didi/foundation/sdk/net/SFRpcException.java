package com.didi.foundation.sdk.net;

import java.io.IOException;

public class SFRpcException extends IOException {
    private int mCode;
    private SFRpcResult mResult;

    public SFRpcException(SFRpcResult sFRpcResult) {
        this(sFRpcResult.getCode(), sFRpcResult.getMessage());
        this.mResult = sFRpcResult;
    }

    public SFRpcException(int i, String str) {
        super(str);
        this.mCode = -1;
        this.mCode = i;
    }

    public SFRpcException(Throwable th) {
        super(th);
        this.mCode = -1;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMessage() {
        return super.getMessage();
    }

    public SFRpcResult getResult() {
        return this.mResult;
    }
}
