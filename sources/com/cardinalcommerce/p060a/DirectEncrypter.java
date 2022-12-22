package com.cardinalcommerce.p060a;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* renamed from: com.cardinalcommerce.a.DirectEncrypter */
public class DirectEncrypter implements JWEObject {

    /* renamed from: a */
    private Provider f2395a;

    public DirectEncrypter(Provider provider) {
        this.f2395a = provider;
    }

    public final CertificateFactory cca_continue(String str) throws CertificateException {
        return CertificateFactory.getInstance(str, this.f2395a);
    }

    public final AlgorithmParameters configure(String str) throws NoSuchAlgorithmException {
        return AlgorithmParameters.getInstance(str, this.f2395a);
    }

    public final Signature getInstance(String str) throws NoSuchAlgorithmException {
        return Signature.getInstance(str, this.f2395a);
    }

    public final KeyFactory init(String str) throws NoSuchAlgorithmException {
        return KeyFactory.getInstance(str, this.f2395a);
    }
}
