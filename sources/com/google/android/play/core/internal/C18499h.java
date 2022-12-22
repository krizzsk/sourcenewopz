package com.google.android.play.core.internal;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.h */
class C18499h extends X509Certificate {

    /* renamed from: a */
    private final X509Certificate f53189a;

    public C18499h(X509Certificate x509Certificate) {
        this.f53189a = x509Certificate;
    }

    public final void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.f53189a.checkValidity();
    }

    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        this.f53189a.checkValidity(date);
    }

    public final int getBasicConstraints() {
        return this.f53189a.getBasicConstraints();
    }

    public final Set<String> getCriticalExtensionOIDs() {
        return this.f53189a.getCriticalExtensionOIDs();
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return this.f53189a.getEncoded();
    }

    public final byte[] getExtensionValue(String str) {
        return this.f53189a.getExtensionValue(str);
    }

    public final Principal getIssuerDN() {
        return this.f53189a.getIssuerDN();
    }

    public final boolean[] getIssuerUniqueID() {
        return this.f53189a.getIssuerUniqueID();
    }

    public final boolean[] getKeyUsage() {
        return this.f53189a.getKeyUsage();
    }

    public final Set<String> getNonCriticalExtensionOIDs() {
        return this.f53189a.getNonCriticalExtensionOIDs();
    }

    public final Date getNotAfter() {
        return this.f53189a.getNotAfter();
    }

    public final Date getNotBefore() {
        return this.f53189a.getNotBefore();
    }

    public final PublicKey getPublicKey() {
        return this.f53189a.getPublicKey();
    }

    public final BigInteger getSerialNumber() {
        return this.f53189a.getSerialNumber();
    }

    public final String getSigAlgName() {
        return this.f53189a.getSigAlgName();
    }

    public final String getSigAlgOID() {
        return this.f53189a.getSigAlgOID();
    }

    public final byte[] getSigAlgParams() {
        return this.f53189a.getSigAlgParams();
    }

    public final byte[] getSignature() {
        return this.f53189a.getSignature();
    }

    public final Principal getSubjectDN() {
        return this.f53189a.getSubjectDN();
    }

    public final boolean[] getSubjectUniqueID() {
        return this.f53189a.getSubjectUniqueID();
    }

    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.f53189a.getTBSCertificate();
    }

    public final int getVersion() {
        return this.f53189a.getVersion();
    }

    public final boolean hasUnsupportedCriticalExtension() {
        return this.f53189a.hasUnsupportedCriticalExtension();
    }

    public final String toString() {
        return this.f53189a.toString();
    }

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f53189a.verify(publicKey);
    }

    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f53189a.verify(publicKey, str);
    }
}
