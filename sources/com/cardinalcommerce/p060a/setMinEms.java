package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setMinEms */
public final class setMinEms extends RuntimeException {
    private final Throwable Cardinal;
    private final String init;

    public final String getMessage() {
        return this.init;
    }

    public final Throwable getCause() {
        return this.Cardinal;
    }

    public setMinEms(String str, Throwable th) {
        this.init = str;
        this.Cardinal = th;
    }
}
