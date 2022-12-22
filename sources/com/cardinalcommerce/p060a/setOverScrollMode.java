package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setOverScrollMode */
public final class setOverScrollMode extends IllegalStateException {
    private Throwable cca_continue;

    setOverScrollMode(String str, Throwable th) {
        super(str);
        this.cca_continue = th;
    }

    public final Throwable getCause() {
        return this.cca_continue;
    }
}
