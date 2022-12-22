package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.p060a.JWEObject;
import com.cardinalcommerce.p060a.JWSObject;
import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public abstract class BaseAlgorithmParameterGeneratorSpi extends AlgorithmParameterGeneratorSpi {

    /* renamed from: a */
    private final JWEObject f3216a = new JWSObject();

    /* access modifiers changed from: protected */
    public final AlgorithmParameters init(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.f3216a.configure(str);
    }
}
