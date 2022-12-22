package com.didi.soda.customer.foundation.rpc.net;

import java.io.IOException;

public class SFRpcException extends IOException {
    private static final long serialVersionUID = 9209934764663322766L;
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
        return ExceptionFormator.formatException(getOriginalMessage());
    }

    public String getOriginalMessage() {
        return super.getMessage();
    }

    public SFRpcResult getResult() {
        return this.mResult;
    }
}
