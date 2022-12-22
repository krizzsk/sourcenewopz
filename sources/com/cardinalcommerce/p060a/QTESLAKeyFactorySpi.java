package com.cardinalcommerce.p060a;

import javax.crypto.BadPaddingException;

/* renamed from: com.cardinalcommerce.a.QTESLAKeyFactorySpi */
public final class QTESLAKeyFactorySpi extends BadPaddingException {
    private final Throwable configure;

    public QTESLAKeyFactorySpi(String str, Throwable th) {
        super(str);
        this.configure = th;
    }

    public final Throwable getCause() {
        return this.configure;
    }
}
