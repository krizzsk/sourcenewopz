package com.adyen.checkout.components;

import com.adyen.checkout.components.model.payments.request.PaymentComponentData;
import com.adyen.checkout.components.model.payments.request.PaymentMethodDetails;

public abstract class PaymentComponentState<PaymentMethodDetailsT extends PaymentMethodDetails> {

    /* renamed from: a */
    private final PaymentComponentData<PaymentMethodDetailsT> f590a;

    /* renamed from: b */
    private final boolean f591b;

    /* renamed from: c */
    private final boolean f592c;

    public PaymentComponentState(PaymentComponentData<PaymentMethodDetailsT> paymentComponentData, boolean z, boolean z2) {
        this.f590a = paymentComponentData;
        this.f591b = z;
        this.f592c = z2;
    }

    public PaymentComponentData<PaymentMethodDetailsT> getData() {
        return this.f590a;
    }

    public boolean isValid() {
        return this.f591b && this.f592c;
    }

    public boolean isInputValid() {
        return this.f591b;
    }

    public boolean isReady() {
        return this.f592c;
    }
}
