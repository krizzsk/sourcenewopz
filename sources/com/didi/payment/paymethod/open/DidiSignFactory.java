package com.didi.payment.paymethod.open;

import com.didi.payment.paymethod.impl.SignApiImpl;

public class DidiSignFactory {
    private DidiSignFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static ISignApi createSignApi() {
        return new SignApiImpl();
    }
}
