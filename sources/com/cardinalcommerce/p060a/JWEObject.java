package com.cardinalcommerce.p060a;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* renamed from: com.cardinalcommerce.a.JWEObject */
public interface JWEObject {
    CertificateFactory cca_continue(String str) throws NoSuchProviderException, CertificateException;

    AlgorithmParameters configure(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    Signature getInstance(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    KeyFactory init(String str) throws NoSuchAlgorithmException, NoSuchProviderException;
}
