package com.cardinalcommerce.p060a;

import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/* renamed from: com.cardinalcommerce.a.AsymmetricKeyInfoConverter */
public abstract class AsymmetricKeyInfoConverter extends AlgorithmParametersSpi {
    protected static boolean init(String str) {
        return str == null || str.equals("ASN.1");
    }

    /* access modifiers changed from: protected */
    public abstract AlgorithmParameterSpec configure(Class cls) throws InvalidParameterSpecException;

    /* access modifiers changed from: protected */
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls != null) {
            return configure(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }
}
