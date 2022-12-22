package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setAccessibilityHeading */
public final class setAccessibilityHeading extends setKeyboardNavigationCluster {
    private byte[] Cardinal;

    public setAccessibilityHeading(byte[] bArr) {
        super(false);
        this.Cardinal = setForegroundTintBlendMode.cca_continue(bArr);
    }

    public final byte[] configure() {
        return setForegroundTintBlendMode.cca_continue(this.Cardinal);
    }
}
