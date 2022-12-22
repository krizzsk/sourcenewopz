package com.didi.universal.pay.sdk.model;

public enum ThirdPayResult {
    NOT_SUPPORT(-1),
    PAY_CANCEL(0),
    PAY_SUCCESS(1),
    PAY_FAIL(2),
    PAY_UNKNOW(3);
    
    public int result;

    private ThirdPayResult(int i) {
        this.result = i;
    }
}
