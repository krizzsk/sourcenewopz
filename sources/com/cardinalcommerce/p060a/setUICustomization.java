package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setUICustomization */
public final class setUICustomization extends IllegalStateException {
    private Throwable getInstance;

    public setUICustomization(String str) {
        super(str);
    }

    public setUICustomization(String str, Throwable th) {
        super(str);
        this.getInstance = th;
    }

    public final Throwable getCause() {
        return this.getInstance;
    }
}
