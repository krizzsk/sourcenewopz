package com.cardinalcommerce.emvco.events;

import com.cardinalcommerce.p060a.setSecondaryProgressTintMode;

public class CompletionEvent extends setSecondaryProgressTintMode {

    /* renamed from: a */
    private final String f3247a;

    /* renamed from: b */
    private final String f3248b;

    public CompletionEvent(String str, String str2) {
        this.f3247a = str;
        this.f3248b = str2;
    }

    public String getSDKTransactionID() {
        return this.f3247a;
    }

    public String getTransactionStatus() {
        return this.f3248b;
    }
}
