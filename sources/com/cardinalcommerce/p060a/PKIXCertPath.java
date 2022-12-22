package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.GMCipherSpi;
import com.cardinalcommerce.p060a.GMSignatureSpi;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.PKIXCertPath */
public final class PKIXCertPath extends X509CRL {

    /* renamed from: a */
    private JWEObject f2461a;

    /* renamed from: b */
    private GMCipherSpi.SM2withBlake2b f2462b;

    /* renamed from: c */
    private String f2463c;

    /* renamed from: d */
    private byte[] f2464d;

    /* renamed from: e */
    private boolean f2465e;

    /* renamed from: f */
    private boolean f2466f = false;

    /* renamed from: g */
    private int f2467g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X509CRL)) {
            return false;
        }
        if (!(obj instanceof PKIXCertPath)) {
            return super.equals(obj);
        }
        PKIXCertPath pKIXCertPath = (PKIXCertPath) obj;
        if (!this.f2466f || !pKIXCertPath.f2466f || pKIXCertPath.f2467g == this.f2467g) {
            return this.f2462b.equals(pKIXCertPath.f2462b);
        }
        return false;
    }

    public final Set getCriticalExtensionOIDs() {
        return m1819a(true);
    }

    public final byte[] getEncoded() throws CRLException {
        try {
            return this.f2462b.init(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public final Set getNonCriticalExtensionOIDs() {
        return m1819a(false);
    }

    public final String getSigAlgName() {
        return this.f2463c;
    }

    public final byte[] getSigAlgParams() {
        byte[] bArr = this.f2464d;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public final int hashCode() {
        if (!this.f2466f) {
            this.f2466f = true;
            this.f2467g = super.hashCode();
        }
        return this.f2467g;
    }

    public final void verify(PublicKey publicKey) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        try {
            signature = this.f2461a.getInstance(getSigAlgName());
        } catch (Exception unused) {
            signature = Signature.getInstance(getSigAlgName());
        }
        m1820a(publicKey, signature);
    }

    public final void verify(PublicKey publicKey, String str) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        m1820a(publicKey, str != null ? Signature.getInstance(getSigAlgName(), str) : Signature.getInstance(getSigAlgName()));
    }

    public final void verify(PublicKey publicKey, Provider provider) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        m1820a(publicKey, provider != null ? Signature.getInstance(getSigAlgName(), provider) : Signature.getInstance(getSigAlgName()));
    }

    /* renamed from: a */
    private static boolean m1821a(X509CRL x509crl) throws CRLException {
        try {
            byte[] extensionValue = x509crl.getExtensionValue(GMCipherSpi.SM2withSha384.getSDKVersion.init);
            if (extensionValue == null) {
                return false;
            }
            byte[] cca_continue = isEnableDFSync.init(extensionValue).cca_continue();
            return (cca_continue != null ? new GMCipherSpi.SM2withSha1(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue)) : null).Cardinal();
        } catch (Exception e) {
            throw new ClassUtil("Exception reading IssuingDistributionPoint", e);
        }
    }

    public PKIXCertPath(JWEObject jWEObject, GMCipherSpi.SM2withBlake2b sM2withBlake2b) throws CRLException {
        this.f2461a = jWEObject;
        this.f2462b = sM2withBlake2b;
        try {
            this.f2463c = C1994e.m1841a(sM2withBlake2b.configure);
            if (sM2withBlake2b.configure.cca_continue != null) {
                this.f2464d = sM2withBlake2b.configure.cca_continue.values().init(ASN1Encoding.DER);
            } else {
                this.f2464d = null;
            }
            this.f2465e = m1821a((X509CRL) this);
        } catch (Exception e) {
            throw new CRLException("CRL contents invalid: ".concat(String.valueOf(e)));
        }
    }

    public final boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        criticalExtensionOIDs.remove(GMCipherSpi.SM2withSha384.getSDKVersion.init);
        criticalExtensionOIDs.remove(GMCipherSpi.SM2withSha384.cleanup.init);
        if (!criticalExtensionOIDs.isEmpty()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private Set m1819a(boolean z) {
        GMCipherSpi.SM2withSha224 sM2withSha224;
        if (getVersion() != 2 || (sM2withSha224 = this.f2462b.cca_continue.cleanup) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration elements = sM2withSha224.configure.elements();
        while (elements.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) elements.nextElement();
            if (z == ((GMCipherSpi.SM2withSha384) sM2withSha224.cca_continue.get(aSN1ObjectIdentifier)).init()) {
                hashSet.add(aSN1ObjectIdentifier.init);
            }
        }
        return hashSet;
    }

    public final byte[] getExtensionValue(String str) {
        GMCipherSpi.SM2withSha224 sM2withSha224 = this.f2462b.cca_continue.cleanup;
        if (sM2withSha224 == null) {
            return null;
        }
        GMCipherSpi.SM2withSha384 sM2withSha384 = (GMCipherSpi.SM2withSha384) sM2withSha224.cca_continue.get(new ASN1ObjectIdentifier(str));
        if (sM2withSha384 == null) {
            return null;
        }
        try {
            return sM2withSha384.getRequestTimeout.getEncoded();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("error parsing ");
            sb.append(e.toString());
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: a */
    private void m1820a(PublicKey publicKey, Signature signature) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        if (this.f2462b.configure.equals(this.f2462b.cca_continue.init)) {
            byte[] bArr = this.f2464d;
            if (bArr != null) {
                try {
                    C1994e.m1843a(signature, setLocationDataConsentGiven.getInstance(bArr));
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder("cannot decode signature parameters: ");
                    sb.append(e.getMessage());
                    throw new SignatureException(sb.toString());
                }
            }
            signature.initVerify(publicKey);
            signature.update(getTBSCertList());
            if (!signature.verify(getSignature())) {
                throw new SignatureException("CRL does not verify with supplied public key.");
            }
            return;
        }
        throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
    }

    public final int getVersion() {
        GMSignatureSpi.sha256WithSM2 sha256withsm2 = this.f2462b.cca_continue;
        if (sha256withsm2.cca_continue == null) {
            return 1;
        }
        return new BigInteger(sha256withsm2.cca_continue.Cardinal).intValue() + 1;
    }

    public final Principal getIssuerDN() {
        return new DirectDecrypter(DSASigner.dsaSha3_224.getInstance(this.f2462b.cca_continue.getInstance.values()));
    }

    public final X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.f2462b.cca_continue.getInstance.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public final Date getThisUpdate() {
        return this.f2462b.cca_continue.configure.configure();
    }

    public final Date getNextUpdate() {
        if (this.f2462b.cca_continue.Cardinal != null) {
            return this.f2462b.cca_continue.Cardinal.configure();
        }
        return null;
    }

    public final X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        Enumeration init = this.f2462b.init();
        DSASigner.dsaSha3_224 dsasha3_224 = null;
        while (init.hasMoreElements()) {
            GMSignatureSpi.sha256WithSM2.C1945configure configure = (GMSignatureSpi.sha256WithSM2.C1945configure) init.nextElement();
            if (bigInteger.equals(new BigInteger(setProxyAddress.Cardinal((Object) configure.configure.Cardinal(0)).Cardinal))) {
                return new C1987b(configure, this.f2465e, dsasha3_224);
            }
            if (this.f2465e && configure.Cardinal()) {
                GMCipherSpi.SM2withSha384 sM2withSha384 = (GMCipherSpi.SM2withSha384) configure.configure().cca_continue.get(GMCipherSpi.SM2withSha384.getWarnings);
                if (sM2withSha384 != null) {
                    setLocationDataConsentGiven cca_continue = GMCipherSpi.SM2withSha384.cca_continue(sM2withSha384);
                    GMCipherSpi.SM2withRMD[] sM2withRMDArr = (cca_continue != null ? new GMCipherSpi.SM2withSha256(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue)) : null).cca_continue;
                    int length = sM2withRMDArr.length;
                    GMCipherSpi.SM2withRMD[] sM2withRMDArr2 = new GMCipherSpi.SM2withRMD[length];
                    System.arraycopy(sM2withRMDArr, 0, sM2withRMDArr2, 0, length);
                    dsasha3_224 = DSASigner.dsaSha3_224.getInstance(sM2withRMDArr2[0].Cardinal);
                }
            }
        }
        return null;
    }

    public final Set getRevokedCertificates() {
        HashSet hashSet = new HashSet();
        Enumeration init = this.f2462b.init();
        DSASigner.dsaSha3_224 dsasha3_224 = null;
        while (init.hasMoreElements()) {
            GMSignatureSpi.sha256WithSM2.C1945configure configure = (GMSignatureSpi.sha256WithSM2.C1945configure) init.nextElement();
            hashSet.add(new C1987b(configure, this.f2465e, dsasha3_224));
            if (this.f2465e && configure.Cardinal()) {
                GMCipherSpi.SM2withSha384 sM2withSha384 = (GMCipherSpi.SM2withSha384) configure.configure().cca_continue.get(GMCipherSpi.SM2withSha384.getWarnings);
                if (sM2withSha384 != null) {
                    setLocationDataConsentGiven cca_continue = GMCipherSpi.SM2withSha384.cca_continue(sM2withSha384);
                    GMCipherSpi.SM2withRMD[] sM2withRMDArr = (cca_continue != null ? new GMCipherSpi.SM2withSha256(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue)) : null).cca_continue;
                    int length = sM2withRMDArr.length;
                    GMCipherSpi.SM2withRMD[] sM2withRMDArr2 = new GMCipherSpi.SM2withRMD[length];
                    System.arraycopy(sM2withRMDArr, 0, sM2withRMDArr2, 0, length);
                    dsasha3_224 = DSASigner.dsaSha3_224.getInstance(sM2withRMDArr2[0].Cardinal);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            return Collections.unmodifiableSet(hashSet);
        }
        return null;
    }

    public final byte[] getTBSCertList() throws CRLException {
        try {
            return this.f2462b.cca_continue.init(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public final byte[] getSignature() {
        return this.f2462b.getInstance.cca_continue();
    }

    public final String getSigAlgOID() {
        return this.f2462b.configure.init.init;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        stringBuffer.append("              Version: ");
        stringBuffer.append(getVersion());
        stringBuffer.append(instance);
        stringBuffer.append("             IssuerDN: ");
        stringBuffer.append(getIssuerDN());
        stringBuffer.append(instance);
        stringBuffer.append("          This update: ");
        stringBuffer.append(getThisUpdate());
        stringBuffer.append(instance);
        stringBuffer.append("          Next update: ");
        stringBuffer.append(getNextUpdate());
        stringBuffer.append(instance);
        stringBuffer.append("  Signature Algorithm: ");
        stringBuffer.append(getSigAlgName());
        stringBuffer.append(instance);
        byte[] signature = getSignature();
        stringBuffer.append("            Signature: ");
        stringBuffer.append(new String(setTextDirection.init(signature, 0, 20)));
        stringBuffer.append(instance);
        int i = 20;
        while (i < signature.length) {
            int length = signature.length - 20;
            stringBuffer.append("                       ");
            stringBuffer.append(i < length ? new String(setTextDirection.init(signature, i, 20)) : new String(setTextDirection.init(signature, i, signature.length - i)));
            stringBuffer.append(instance);
            i += 20;
        }
        GMCipherSpi.SM2withSha224 sM2withSha224 = this.f2462b.cca_continue.cleanup;
        if (sM2withSha224 != null) {
            Enumeration elements = sM2withSha224.configure.elements();
            if (elements.hasMoreElements()) {
                stringBuffer.append("           Extensions: ");
                stringBuffer.append(instance);
            }
            while (elements.hasMoreElements()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) elements.nextElement();
                GMCipherSpi.SM2withSha384 sM2withSha384 = (GMCipherSpi.SM2withSha384) sM2withSha224.cca_continue.get(aSN1ObjectIdentifier);
                if (sM2withSha384.getRequestTimeout != null) {
                    getUiType getuitype = new getUiType(sM2withSha384.getRequestTimeout.cca_continue());
                    stringBuffer.append("                       critical(");
                    stringBuffer.append(sM2withSha384.init());
                    stringBuffer.append(") ");
                    try {
                        if (aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.getInstance)) {
                            stringBuffer.append(new GMCipherSpi(new BigInteger(1, setProxyAddress.Cardinal((Object) getuitype.cca_continue()).Cardinal)));
                            stringBuffer.append(instance);
                        } else if (aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.cleanup)) {
                            StringBuilder sb = new StringBuilder("Base CRL: ");
                            sb.append(new GMCipherSpi(new BigInteger(1, setProxyAddress.Cardinal((Object) getuitype.cca_continue()).Cardinal)));
                            stringBuffer.append(sb.toString());
                            stringBuffer.append(instance);
                        } else {
                            Object obj = null;
                            if (aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.getSDKVersion)) {
                                setLocationDataConsentGiven cca_continue = getuitype.cca_continue();
                                if (cca_continue != null) {
                                    obj = new GMCipherSpi.SM2withSha1(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue));
                                }
                                stringBuffer.append(obj);
                                stringBuffer.append(instance);
                            } else if (aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.valueOf)) {
                                setLocationDataConsentGiven cca_continue2 = getuitype.cca_continue();
                                if (cca_continue2 != null) {
                                    obj = new SignatureSpi(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue2));
                                }
                                stringBuffer.append(obj);
                                stringBuffer.append(instance);
                            } else if (aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.CardinalActionCode)) {
                                setLocationDataConsentGiven cca_continue3 = getuitype.cca_continue();
                                if (cca_continue3 != null) {
                                    obj = new SignatureSpi(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue3));
                                }
                                stringBuffer.append(obj);
                                stringBuffer.append(instance);
                            } else {
                                stringBuffer.append(aSN1ObjectIdentifier.init);
                                stringBuffer.append(" value = ");
                                stringBuffer.append(DSASigner.dsaSha3_384.cca_continue((Object) getuitype.cca_continue()));
                                stringBuffer.append(instance);
                            }
                        }
                    } catch (Exception unused) {
                        stringBuffer.append(aSN1ObjectIdentifier.init);
                        stringBuffer.append(" value = *****");
                    }
                }
                stringBuffer.append(instance);
            }
        }
        Set<? extends X509CRLEntry> revokedCertificates = getRevokedCertificates();
        if (revokedCertificates != null) {
            for (Object append : revokedCertificates) {
                stringBuffer.append(append);
                stringBuffer.append(instance);
            }
        }
        return stringBuffer.toString();
    }

    public final boolean isRevoked(Certificate certificate) {
        DSASigner.dsaSha3_224 dsasha3_224;
        if (certificate.getType().equals("X.509")) {
            Enumeration init = this.f2462b.init();
            DSASigner.dsaSha3_224 dsasha3_2242 = this.f2462b.cca_continue.getInstance;
            if (init.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) certificate;
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                while (init.hasMoreElements()) {
                    Object nextElement = init.nextElement();
                    BCECPublicKey bCECPublicKey = null;
                    GMSignatureSpi.sha256WithSM2.C1945configure configure = nextElement instanceof GMSignatureSpi.sha256WithSM2.C1945configure ? (GMSignatureSpi.sha256WithSM2.C1945configure) nextElement : nextElement != null ? new GMSignatureSpi.sha256WithSM2.C1945configure(setThreeDSRequestorAppURL.cca_continue(nextElement)) : null;
                    if (this.f2465e && configure.Cardinal()) {
                        GMCipherSpi.SM2withSha384 sM2withSha384 = (GMCipherSpi.SM2withSha384) configure.configure().cca_continue.get(GMCipherSpi.SM2withSha384.getWarnings);
                        if (sM2withSha384 != null) {
                            setLocationDataConsentGiven cca_continue = GMCipherSpi.SM2withSha384.cca_continue(sM2withSha384);
                            GMCipherSpi.SM2withRMD[] sM2withRMDArr = (cca_continue != null ? new GMCipherSpi.SM2withSha256(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue)) : null).cca_continue;
                            int length = sM2withRMDArr.length;
                            GMCipherSpi.SM2withRMD[] sM2withRMDArr2 = new GMCipherSpi.SM2withRMD[length];
                            System.arraycopy(sM2withRMDArr, 0, sM2withRMDArr2, 0, length);
                            dsasha3_2242 = DSASigner.dsaSha3_224.getInstance(sM2withRMDArr2[0].Cardinal);
                        }
                    }
                    if (new BigInteger(setProxyAddress.Cardinal((Object) configure.configure.Cardinal(0)).Cardinal).equals(serialNumber)) {
                        if (certificate instanceof X509Certificate) {
                            dsasha3_224 = DSASigner.dsaSha3_224.getInstance(x509Certificate.getIssuerX500Principal().getEncoded());
                        } else {
                            try {
                                byte[] encoded = certificate.getEncoded();
                                if (encoded != null) {
                                    bCECPublicKey = new BCECPublicKey(setThreeDSRequestorAppURL.cca_continue((Object) encoded));
                                }
                                dsasha3_224 = bCECPublicKey.configure.configure;
                            } catch (CertificateEncodingException e) {
                                StringBuilder sb = new StringBuilder("Cannot process certificate: ");
                                sb.append(e.getMessage());
                                throw new IllegalArgumentException(sb.toString());
                            }
                        }
                        return dsasha3_2242.equals(dsasha3_224);
                    }
                }
            }
            return false;
        }
        throw new IllegalArgumentException("X.509 CRL used with non X.509 Cert");
    }
}
