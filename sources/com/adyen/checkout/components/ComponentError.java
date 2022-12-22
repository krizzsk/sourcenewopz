package com.adyen.checkout.components;

import com.adyen.checkout.core.exception.CheckoutException;

public class ComponentError {

    /* renamed from: a */
    private final CheckoutException f589a;

    public ComponentError(CheckoutException checkoutException) {
        this.f589a = checkoutException;
    }

    public String getErrorMessage() {
        return this.f589a.getMessage();
    }

    public CheckoutException getException() {
        return this.f589a;
    }
}
