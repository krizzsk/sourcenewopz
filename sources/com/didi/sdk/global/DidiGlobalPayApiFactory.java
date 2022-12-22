package com.didi.sdk.global;

public class DidiGlobalPayApiFactory {
    public static IDidiGlobalPayApi createDidiPay() {
        return new DidiGlobalPayApiImpl();
    }

    private DidiGlobalPayApiFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }
}
