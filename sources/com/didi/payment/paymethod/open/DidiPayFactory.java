package com.didi.payment.paymethod.open;

import com.didi.payment.paymethod.impl.PayApiImpl;

public class DidiPayFactory {
    private DidiPayFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static IPayApi createPayApi() {
        return new PayApiImpl();
    }
}
