package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.cardinalcommerce.p060a.DSA;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.GMCipherSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.KeyFactory */
public final class KeyFactory extends X509Certificate implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    private BCECPublicKey Cardinal;
    private JWEObject cca_continue;
    private BCECPrivateKey configure;
    private boolean getInstance;
    private int getWarnings;
    private boolean[] init;

    public final void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(new Date());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeyFactory)) {
            return super.equals(obj);
        }
        KeyFactory keyFactory = (KeyFactory) obj;
        if (!this.getInstance || !keyFactory.getInstance || this.getWarnings == keyFactory.getWarnings) {
            return this.Cardinal.equals(keyFactory.Cardinal);
        }
        return false;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        try {
            return this.Cardinal.init(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    public final boolean[] getKeyUsage() {
        return this.init;
    }

    public final synchronized int hashCode() {
        if (!this.getInstance) {
            this.getWarnings = super.hashCode();
            this.getInstance = true;
        }
        return this.getWarnings;
    }

    public KeyFactory(JWEObject jWEObject, BCECPublicKey bCECPublicKey) throws CertificateParsingException {
        new PKCS12BagAttributeCarrierImpl();
        this.cca_continue = jWEObject;
        this.Cardinal = bCECPublicKey;
        try {
            byte[] init2 = init("2.5.29.19");
            if (init2 != null) {
                setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(init2);
                this.configure = instance != null ? new BCECPrivateKey(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
            }
            try {
                byte[] init3 = init("2.5.29.15");
                if (init3 != null) {
                    PrivateKeyInfo Cardinal2 = PrivateKeyInfo.Cardinal(setLocationDataConsentGiven.getInstance(init3));
                    byte[] instance2 = Cardinal2.getInstance();
                    int length = (instance2.length << 3) - Cardinal2.cleanup();
                    int i = 9;
                    if (length >= 9) {
                        i = length;
                    }
                    this.init = new boolean[i];
                    for (int i2 = 0; i2 != length; i2++) {
                        this.init[i2] = (instance2[i2 / 8] & (128 >>> (i2 % 8))) != 0;
                    }
                    return;
                }
                this.init = null;
            } catch (Exception e) {
                throw new CertificateParsingException("cannot construct KeyUsage: ".concat(String.valueOf(e)));
            }
        } catch (Exception e2) {
            throw new CertificateParsingException("cannot construct BasicConstraints: ".concat(String.valueOf(e2)));
        }
    }

    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        if (date.getTime() > getNotAfter().getTime()) {
            StringBuilder sb = new StringBuilder("certificate expired on ");
            GMCipherSpi.SM2withSha512 sM2withSha512 = this.Cardinal.configure.getSDKVersion;
            boolean z = sM2withSha512.configure instanceof Payment;
            setLocationDataConsentGiven setlocationdataconsentgiven = sM2withSha512.configure;
            sb.append(z ? ((Payment) setlocationdataconsentgiven).init() : ((setRenderType) setlocationdataconsentgiven).getInstance());
            throw new CertificateExpiredException(sb.toString());
        } else if (date.getTime() < getNotBefore().getTime()) {
            StringBuilder sb2 = new StringBuilder("certificate not valid till ");
            GMCipherSpi.SM2withSha512 sM2withSha5122 = this.Cardinal.configure.getInstance;
            boolean z2 = sM2withSha5122.configure instanceof Payment;
            setLocationDataConsentGiven setlocationdataconsentgiven2 = sM2withSha5122.configure;
            sb2.append(z2 ? ((Payment) setlocationdataconsentgiven2).init() : ((setRenderType) setlocationdataconsentgiven2).getInstance());
            throw new CertificateNotYetValidException(sb2.toString());
        }
    }

    public final int getVersion() {
        return new BigInteger(this.Cardinal.configure.init.Cardinal).intValue() + 1;
    }

    public final BigInteger getSerialNumber() {
        return new BigInteger(this.Cardinal.configure.cca_continue.Cardinal);
    }

    public final Principal getIssuerDN() {
        try {
            return new DirectDecrypter(DSASigner.dsaSha3_224.getInstance(this.Cardinal.configure.configure.getEncoded()));
        } catch (IOException unused) {
            return null;
        }
    }

    public final X500Principal getIssuerX500Principal() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new setEnableDFSync(byteArrayOutputStream).init(this.Cardinal.configure.configure);
            return new X500Principal(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public final Principal getSubjectDN() {
        return new DirectDecrypter(DSASigner.dsaSha3_224.getInstance(this.Cardinal.configure.values.values()));
    }

    public final X500Principal getSubjectX500Principal() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new setEnableDFSync(byteArrayOutputStream).init(this.Cardinal.configure.values);
            return new X500Principal(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public final Date getNotBefore() {
        return this.Cardinal.configure.getInstance.configure();
    }

    public final Date getNotAfter() {
        return this.Cardinal.configure.getSDKVersion.configure();
    }

    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        try {
            return this.Cardinal.configure.init(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    public final byte[] getSignature() {
        return this.Cardinal.cca_continue.cca_continue();
    }

    public final String getSigAlgName() {
        return C1994e.m1841a(this.Cardinal.getInstance);
    }

    public final String getSigAlgOID() {
        return this.Cardinal.getInstance.init.init;
    }

    public final byte[] getSigAlgParams() {
        if (this.Cardinal.getInstance.cca_continue != null) {
            try {
                return this.Cardinal.getInstance.cca_continue.values().init(ASN1Encoding.DER);
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public final boolean[] getIssuerUniqueID() {
        PrivateKeyInfo privateKeyInfo = this.Cardinal.configure.cleanup;
        if (privateKeyInfo == null) {
            return null;
        }
        byte[] instance = privateKeyInfo.getInstance();
        int length = (instance.length << 3) - privateKeyInfo.cleanup();
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            zArr[i] = (instance[i / 8] & (128 >>> (i % 8))) != 0;
        }
        return zArr;
    }

    public final boolean[] getSubjectUniqueID() {
        PrivateKeyInfo privateKeyInfo = this.Cardinal.configure.CardinalError;
        if (privateKeyInfo == null) {
            return null;
        }
        byte[] instance = privateKeyInfo.getInstance();
        int length = (instance.length << 3) - privateKeyInfo.cleanup();
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            zArr[i] = (instance[i / 8] & (128 >>> (i % 8))) != 0;
        }
        return zArr;
    }

    public final List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] init2 = init("2.5.29.37");
        if (init2 == null) {
            return null;
        }
        try {
            setThreeDSRequestorAppURL setthreedsrequestorappurl = (setThreeDSRequestorAppURL) new getUiType(init2).cca_continue();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i != setthreedsrequestorappurl.getInstance(); i++) {
                arrayList.add(((ASN1ObjectIdentifier) setthreedsrequestorappurl.Cardinal(i)).init);
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception unused) {
            throw new CertificateParsingException("error processing extended key usage extension");
        }
    }

    public final int getBasicConstraints() {
        BCECPrivateKey bCECPrivateKey = this.configure;
        if (bCECPrivateKey == null || !bCECPrivateKey.getInstance()) {
            return -1;
        }
        BCECPrivateKey bCECPrivateKey2 = this.configure;
        BigInteger bigInteger = null;
        if ((bCECPrivateKey2.Cardinal != null ? new BigInteger(bCECPrivateKey2.Cardinal.Cardinal) : null) == null) {
            return Integer.MAX_VALUE;
        }
        BCECPrivateKey bCECPrivateKey3 = this.configure;
        if (bCECPrivateKey3.Cardinal != null) {
            bigInteger = new BigInteger(bCECPrivateKey3.Cardinal.Cardinal);
        }
        return bigInteger.intValue();
    }

    public final Collection getSubjectAlternativeNames() throws CertificateParsingException {
        return configure(init(GMCipherSpi.SM2withSha384.configure.init));
    }

    public final Collection getIssuerAlternativeNames() throws CertificateParsingException {
        return configure(init(GMCipherSpi.SM2withSha384.init.init));
    }

    public final Set getCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        GMCipherSpi.SM2withSha224 sM2withSha224 = this.Cardinal.configure.CardinalUiType;
        if (sM2withSha224 == null) {
            return null;
        }
        Enumeration elements = sM2withSha224.configure.elements();
        while (elements.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) elements.nextElement();
            if (((GMCipherSpi.SM2withSha384) sM2withSha224.cca_continue.get(aSN1ObjectIdentifier)).init()) {
                hashSet.add(aSN1ObjectIdentifier.init);
            }
        }
        return hashSet;
    }

    private byte[] init(String str) {
        GMCipherSpi.SM2withSha224 sM2withSha224 = this.Cardinal.configure.CardinalUiType;
        if (sM2withSha224 == null) {
            return null;
        }
        GMCipherSpi.SM2withSha384 sM2withSha384 = (GMCipherSpi.SM2withSha384) sM2withSha224.cca_continue.get(new ASN1ObjectIdentifier(str));
        if (sM2withSha384 != null) {
            return sM2withSha384.getRequestTimeout.cca_continue();
        }
        return null;
    }

    public final byte[] getExtensionValue(String str) {
        GMCipherSpi.SM2withSha224 sM2withSha224 = this.Cardinal.configure.CardinalUiType;
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

    public final Set getNonCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        GMCipherSpi.SM2withSha224 sM2withSha224 = this.Cardinal.configure.CardinalUiType;
        if (sM2withSha224 == null) {
            return null;
        }
        Enumeration elements = sM2withSha224.configure.elements();
        while (elements.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) elements.nextElement();
            if (!((GMCipherSpi.SM2withSha384) sM2withSha224.cca_continue.get(aSN1ObjectIdentifier)).init()) {
                hashSet.add(aSN1ObjectIdentifier.init);
            }
        }
        return hashSet;
    }

    public final boolean hasUnsupportedCriticalExtension() {
        GMCipherSpi.SM2withSha224 sM2withSha224;
        if (getVersion() != 3 || (sM2withSha224 = this.Cardinal.configure.CardinalUiType) == null) {
            return false;
        }
        Enumeration elements = sM2withSha224.configure.elements();
        while (elements.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) elements.nextElement();
            if (!aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.Cardinal) && !aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.CardinalRenderType) && !aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.CardinalEnvironment) && !aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.getString) && !aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.valueOf) && !aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.getSDKVersion) && !aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.cleanup) && !aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.CardinalUiType) && !aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.cca_continue) && !aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.configure) && !aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.CardinalError) && ((GMCipherSpi.SM2withSha384) sM2withSha224.cca_continue.get(aSN1ObjectIdentifier)).init()) {
                return true;
            }
        }
        return false;
    }

    public final PublicKey getPublicKey() {
        try {
            return JWK.getInstance(this.Cardinal.configure.getWarnings);
        } catch (IOException unused) {
            return null;
        }
    }

    public final String toString() {
        Object mQVwithSHA224CKDF;
        StringBuffer stringBuffer = new StringBuffer();
        String instance = setAnimation.getInstance();
        stringBuffer.append("  [0]         Version: ");
        stringBuffer.append(getVersion());
        stringBuffer.append(instance);
        stringBuffer.append("         SerialNumber: ");
        stringBuffer.append(getSerialNumber());
        stringBuffer.append(instance);
        stringBuffer.append("             IssuerDN: ");
        stringBuffer.append(getIssuerDN());
        stringBuffer.append(instance);
        stringBuffer.append("           Start Date: ");
        stringBuffer.append(getNotBefore());
        stringBuffer.append(instance);
        stringBuffer.append("           Final Date: ");
        stringBuffer.append(getNotAfter());
        stringBuffer.append(instance);
        stringBuffer.append("            SubjectDN: ");
        stringBuffer.append(getSubjectDN());
        stringBuffer.append(instance);
        stringBuffer.append("           Public Key: ");
        stringBuffer.append(getPublicKey());
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
        GMCipherSpi.SM2withSha224 sM2withSha224 = this.Cardinal.configure.CardinalUiType;
        if (sM2withSha224 != null) {
            Enumeration elements = sM2withSha224.configure.elements();
            if (elements.hasMoreElements()) {
                stringBuffer.append("       Extensions: \n");
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
                        Object obj = null;
                        if (aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.cca_continue)) {
                            setLocationDataConsentGiven cca_continue2 = getuitype.cca_continue();
                            if (cca_continue2 != null) {
                                obj = new BCECPrivateKey(setThreeDSRequestorAppURL.cca_continue((Object) cca_continue2));
                            }
                            stringBuffer.append(obj);
                            stringBuffer.append(instance);
                        } else {
                            if (aSN1ObjectIdentifier.equals(GMCipherSpi.SM2withSha384.Cardinal)) {
                                setLocationDataConsentGiven cca_continue3 = getuitype.cca_continue();
                                if (cca_continue3 != null) {
                                    obj = new GMCipherSpi.SM2withWhirlpool(PrivateKeyInfo.Cardinal(cca_continue3));
                                }
                                stringBuffer.append(obj);
                            } else {
                                if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA512KDF.Cardinal)) {
                                    mQVwithSHA224CKDF = new KeyAgreementSpi.MQVwithSHA1KDF((PrivateKeyInfo) getuitype.cca_continue());
                                } else if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA512KDF.init)) {
                                    mQVwithSHA224CKDF = new KeyAgreementSpi.MQVwithSHA1CKDF((DSA.Mappings) getuitype.cca_continue());
                                } else if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA512KDF.configure)) {
                                    mQVwithSHA224CKDF = new KeyAgreementSpi.MQVwithSHA224CKDF((DSA.Mappings) getuitype.cca_continue());
                                } else {
                                    stringBuffer.append(aSN1ObjectIdentifier.init);
                                    stringBuffer.append(" value = ");
                                    stringBuffer.append(DSASigner.dsaSha3_384.cca_continue((Object) getuitype.cca_continue()));
                                    stringBuffer.append(instance);
                                }
                                stringBuffer.append(mQVwithSHA224CKDF);
                            }
                            stringBuffer.append(instance);
                        }
                    } catch (Exception unused) {
                        stringBuffer.append(aSN1ObjectIdentifier.init);
                        stringBuffer.append(" value = *****");
                    }
                }
                stringBuffer.append(instance);
            }
        }
        return stringBuffer.toString();
    }

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        String a = C1994e.m1841a(this.Cardinal.getInstance);
        try {
            signature = this.cca_continue.getInstance(a);
        } catch (Exception unused) {
            signature = Signature.getInstance(a);
        }
        init(publicKey, signature);
    }

    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        String a = C1994e.m1841a(this.Cardinal.getInstance);
        init(publicKey, str != null ? Signature.getInstance(a, str) : Signature.getInstance(a));
    }

    public final void verify(PublicKey publicKey, Provider provider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        String a = C1994e.m1841a(this.Cardinal.getInstance);
        init(publicKey, provider != null ? Signature.getInstance(a, provider) : Signature.getInstance(a));
    }

    private void init(PublicKey publicKey, Signature signature) throws CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (getInstance(this.Cardinal.getInstance, this.Cardinal.configure.Cardinal)) {
            C1994e.m1843a(signature, this.Cardinal.getInstance.cca_continue);
            signature.initVerify(publicKey);
            signature.update(getTBSCertificate());
            if (!signature.verify(getSignature())) {
                throw new SignatureException("certificate does not verify with supplied key");
            }
            return;
        }
        throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
    }

    private static boolean getInstance(DSASigner.stdDSA stddsa, DSASigner.stdDSA stddsa2) {
        if (!stddsa.init.equals(stddsa2.init)) {
            return false;
        }
        if (stddsa.cca_continue == null) {
            if (stddsa2.cca_continue == null || stddsa2.cca_continue.equals(ECGOST.Mappings.Cardinal)) {
                return true;
            }
            return false;
        } else if (stddsa2.cca_continue != null) {
            return stddsa.cca_continue.equals(stddsa2.cca_continue);
        } else {
            if (stddsa.cca_continue == null || stddsa.cca_continue.equals(ECGOST.Mappings.Cardinal)) {
                return true;
            }
            return false;
        }
    }

    private static Collection configure(byte[] bArr) throws CertificateParsingException {
        if (bArr == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration cca_continue2 = setThreeDSRequestorAppURL.cca_continue((Object) bArr).cca_continue();
            while (cca_continue2.hasMoreElements()) {
                GMCipherSpi.SM2withRMD Cardinal2 = GMCipherSpi.SM2withRMD.Cardinal(cca_continue2.nextElement());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(Integer.valueOf(Cardinal2.init));
                switch (Cardinal2.init) {
                    case 0:
                    case 3:
                    case 5:
                        arrayList2.add(Cardinal2.getEncoded());
                        break;
                    case 1:
                    case 2:
                    case 6:
                        arrayList2.add(((getExtendedData) Cardinal2.Cardinal).init());
                        break;
                    case 4:
                        arrayList2.add(DSASigner.dsaSha3_224.cca_continue(BCDSTU4145PrivateKey.getInstance, Cardinal2.Cardinal).toString());
                        break;
                    case 7:
                        try {
                            arrayList2.add(InetAddress.getByAddress(EdEC.init(Cardinal2.Cardinal).cca_continue()).getHostAddress());
                            break;
                        } catch (UnknownHostException unused) {
                            break;
                        }
                    case 8:
                        arrayList2.add(ASN1ObjectIdentifier.getInstance(Cardinal2.Cardinal).init);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder("Bad tag number: ");
                        sb.append(Cardinal2.init);
                        throw new IOException(sb.toString());
                }
                arrayList.add(Collections.unmodifiableList(arrayList2));
            }
            if (arrayList.size() == 0) {
                return null;
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (Exception e) {
            throw new CertificateParsingException(e.getMessage());
        }
    }
}
