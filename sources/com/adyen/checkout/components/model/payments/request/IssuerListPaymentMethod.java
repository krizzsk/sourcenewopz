package com.adyen.checkout.components.model.payments.request;

public abstract class IssuerListPaymentMethod extends PaymentMethodDetails {

    /* renamed from: a */
    static final String f770a = "issuer";

    /* renamed from: b */
    private String f771b;

    public String getIssuer() {
        return this.f771b;
    }

    public void setIssuer(String str) {
        this.f771b = str;
    }
}
