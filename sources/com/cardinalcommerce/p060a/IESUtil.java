package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyFactorySpi;

/* renamed from: com.cardinalcommerce.a.IESUtil */
public final class IESUtil {

    /* renamed from: a */
    private KeyFactorySpi.ECGOST3410_2012 f2450a;
    public ExtendedInvalidKeySpecException init;

    IESUtil() {
    }

    public IESUtil(ExtendedInvalidKeySpecException extendedInvalidKeySpecException, KeyFactorySpi.ECGOST3410_2012 ecgost3410_2012) {
        this.init = extendedInvalidKeySpecException;
        this.f2450a = ecgost3410_2012;
    }

    public final byte[] getInstance() {
        return this.f2450a.cca_continue(this.init.Cardinal);
    }
}
