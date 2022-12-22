package com.cardinalcommerce.emvco.events;

import com.cardinalcommerce.p060a.setSecondaryProgressTintMode;

public class RuntimeErrorEvent extends setSecondaryProgressTintMode {

    /* renamed from: a */
    private String f3251a;

    /* renamed from: b */
    private String f3252b;

    public RuntimeErrorEvent(String str) {
        this.f3252b = str;
    }

    public RuntimeErrorEvent(String str, String str2) {
        this.f3251a = str;
        this.f3252b = str2;
    }

    public String getErrorCode() {
        return this.f3251a;
    }

    public void setErrorCode(String str) {
        this.f3251a = str;
    }

    public String getErrorMessage() {
        return this.f3252b;
    }

    public void setErrorMessage(String str) {
        this.f3252b = str;
    }
}
