package com.didi.payment.creditcard.open;

import com.didi.payment.creditcard.global.GlobalCreditCardImpl;

public class DidiCreditCardFactory {
    private DidiCreditCardFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static IGlobalCreditCardApi createGlobalCreditCardApi() {
        return new GlobalCreditCardImpl();
    }
}
