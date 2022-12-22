package com.cardinalcommerce.emvco.events;

import com.cardinalcommerce.p060a.setSecondaryProgressTintMode;
import com.cardinalcommerce.shared.models.ErrorMessage;

public class ProtocolErrorEvent extends setSecondaryProgressTintMode {

    /* renamed from: a */
    private final ErrorMessage f3249a;

    /* renamed from: b */
    private final String f3250b;

    public ProtocolErrorEvent(String str, ErrorMessage errorMessage) {
        this.f3249a = errorMessage;
        this.f3250b = str;
    }

    public String getSDKTransactionID() {
        return this.f3250b;
    }

    public ErrorMessage getErrorMessage() {
        return this.f3249a;
    }
}
