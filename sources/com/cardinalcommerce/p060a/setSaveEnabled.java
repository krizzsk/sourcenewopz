package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setSaveEnabled */
public final class setSaveEnabled extends setKeyboardNavigationCluster {
    public int configure;
    private byte[] init;

    public final byte[] configure() {
        return setForegroundTintBlendMode.cca_continue(this.init);
    }

    public setSaveEnabled(int i, byte[] bArr) {
        super(true);
        int i2;
        int length = bArr.length;
        if (i == 0) {
            i2 = 1344;
        } else if (i == 1) {
            i2 = 2112;
        } else if (i == 2) {
            i2 = 2368;
        } else if (i == 3) {
            i2 = 5184;
        } else if (i == 4) {
            i2 = 12352;
        } else {
            throw new IllegalArgumentException("unknown security category: ".concat(String.valueOf(i)));
        }
        if (length == i2) {
            this.configure = i;
            this.init = setForegroundTintBlendMode.cca_continue(bArr);
            return;
        }
        throw new IllegalArgumentException("invalid key size for security category");
    }
}
