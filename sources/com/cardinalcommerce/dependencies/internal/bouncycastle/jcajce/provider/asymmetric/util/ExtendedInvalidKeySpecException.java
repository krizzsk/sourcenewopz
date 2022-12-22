package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.spec.InvalidKeySpecException;

public class ExtendedInvalidKeySpecException extends InvalidKeySpecException {
    private Throwable configure;

    public ExtendedInvalidKeySpecException(String str, Throwable th) {
        super(str);
        this.configure = th;
    }

    public Throwable getCause() {
        return this.configure;
    }
}
