package com.didi.component.common.exception;

public class BizException extends RuntimeException {
    private int code;

    public BizException() {
    }

    public int getCode() {
        return this.code;
    }

    public BizException(int i, String str) {
        super(str);
        this.code = i;
    }
}
