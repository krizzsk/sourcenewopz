package com.cardinalcommerce.p060a;

import com.didi.soda.customer.C13565R2;

/* renamed from: com.cardinalcommerce.a.setImportantForAccessibility */
public final class setImportantForAccessibility extends setKeyboardNavigationCluster {
    private byte[] Cardinal;
    public int getInstance;

    public final byte[] init() {
        return setForegroundTintBlendMode.cca_continue(this.Cardinal);
    }

    public setImportantForAccessibility(int i, byte[] bArr) {
        super(false);
        int i2;
        int length = bArr.length;
        if (i == 0) {
            i2 = 1504;
        } else if (i == 1) {
            i2 = 2976;
        } else if (i == 2) {
            i2 = 3104;
        } else if (i == 3) {
            i2 = 14880;
        } else if (i == 4) {
            i2 = C13565R2.styleable.TextInputLayout_suffixTextColor;
        } else {
            throw new IllegalArgumentException("unknown security category: ".concat(String.valueOf(i)));
        }
        if (length == i2) {
            this.getInstance = i;
            this.Cardinal = setForegroundTintBlendMode.cca_continue(bArr);
            return;
        }
        throw new IllegalArgumentException("invalid key size for security category");
    }
}
