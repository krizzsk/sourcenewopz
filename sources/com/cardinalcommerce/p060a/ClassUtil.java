package com.cardinalcommerce.p060a;

import java.security.cert.CRLException;

/* renamed from: com.cardinalcommerce.a.ClassUtil */
final class ClassUtil extends CRLException {
    private Throwable getInstance;

    ClassUtil(String str, Throwable th) {
        super(str);
        this.getInstance = th;
    }

    public final Throwable getCause() {
        return this.getInstance;
    }
}
