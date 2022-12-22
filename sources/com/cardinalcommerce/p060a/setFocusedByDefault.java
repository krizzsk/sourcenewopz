package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setFocusedByDefault */
public final class setFocusedByDefault extends setAccessibilityLiveRegion {
    private final byte[] cca_continue;

    public setFocusedByDefault(byte[] bArr, String str) {
        super(true, str);
        this.cca_continue = setForegroundTintBlendMode.cca_continue(bArr);
    }

    public final byte[] cca_continue() {
        return setForegroundTintBlendMode.cca_continue(this.cca_continue);
    }
}
