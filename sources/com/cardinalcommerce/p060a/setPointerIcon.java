package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setPointerIcon */
public final class setPointerIcon extends IllegalStateException {
    private Throwable cca_continue;

    setPointerIcon(String str, Throwable th) {
        super(str);
        this.cca_continue = th;
    }

    public final Throwable getCause() {
        return this.cca_continue;
    }
}
