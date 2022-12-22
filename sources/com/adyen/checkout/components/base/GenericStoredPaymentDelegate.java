package com.adyen.checkout.components.base;

import com.adyen.checkout.components.model.paymentmethods.StoredPaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/adyen/checkout/components/base/GenericStoredPaymentDelegate;", "Lcom/adyen/checkout/components/base/PaymentMethodDelegate;", "storedPaymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;", "(Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;)V", "getStoredPaymentMethod", "()Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;", "getPaymentMethodType", "", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GenericStoredPaymentDelegate.kt */
public final class GenericStoredPaymentDelegate implements PaymentMethodDelegate {

    /* renamed from: a */
    private final StoredPaymentMethod f660a;

    public GenericStoredPaymentDelegate(StoredPaymentMethod storedPaymentMethod) {
        Intrinsics.checkNotNullParameter(storedPaymentMethod, "storedPaymentMethod");
        this.f660a = storedPaymentMethod;
    }

    public final StoredPaymentMethod getStoredPaymentMethod() {
        return this.f660a;
    }

    public String getPaymentMethodType() {
        String type = this.f660a.getType();
        return type == null ? "unknown" : type;
    }
}
