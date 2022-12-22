package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyLengthException;
import com.cardinalcommerce.p060a.PrivateKeyInfo;
import com.cardinalcommerce.p060a.X509CertUtils;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;

public class BCDSTU4145PrivateKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF, KeyLengthException, ECPrivateKey {
    private transient ECParameterSpec Cardinal;
    private transient PrivateKeyInfo cca_continue;
    private transient BigInteger getInstance;
    private String init = "DSTU4145";

    protected BCDSTU4145PrivateKey() {
        new PKCS12BagAttributeCarrierImpl();
    }

    BCDSTU4145PrivateKey(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo privateKeyInfo) throws IOException {
        new PKCS12BagAttributeCarrierImpl();
        init(privateKeyInfo);
    }

    public BCDSTU4145PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        new PKCS12BagAttributeCarrierImpl();
        this.getInstance = eCPrivateKeySpec.getS();
        this.Cardinal = eCPrivateKeySpec.getParams();
    }

    private static void init(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - 1) - i];
            bArr[(bArr.length - 1) - i] = b;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo.init(setLocationDataConsentGiven.getInstance((byte[]) objectInputStream.readObject())));
        new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final Container Cardinal() {
        ECParameterSpec eCParameterSpec = this.Cardinal;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.cca_continue(eCParameterSpec);
    }

    public String getAlgorithm() {
        return this.init;
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public final BigInteger getInstance() {
        return this.getInstance;
    }

    public ECParameterSpec getParams() {
        return this.Cardinal;
    }

    public BigInteger getS() {
        return this.getInstance;
    }

    public BCDSTU4145PrivateKey(X509CertUtils x509CertUtils) {
        ECParameterSpec eCParameterSpec;
        new PKCS12BagAttributeCarrierImpl();
        this.getInstance = x509CertUtils.Cardinal;
        if (x509CertUtils.cca_continue != null) {
            getSDKAppID getsdkappid = x509CertUtils.cca_continue.init;
            x509CertUtils.cca_continue.getInstance();
            eCParameterSpec = EC5Util.Cardinal(EC5Util.getInstance(getsdkappid), x509CertUtils.cca_continue);
        } else {
            eCParameterSpec = null;
        }
        this.Cardinal = eCParameterSpec;
    }

    public BCDSTU4145PrivateKey(String str, DigestSignatureSpi.MD2 md2, BCDSTU4145PublicKey bCDSTU4145PublicKey, ECParameterSpec eCParameterSpec) {
        new PKCS12BagAttributeCarrierImpl();
        BCRSAPublicKey bCRSAPublicKey = md2.init;
        this.init = str;
        this.getInstance = md2.Cardinal;
        if (eCParameterSpec == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
        } else {
            this.Cardinal = eCParameterSpec;
        }
        this.cca_continue = init(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(String str, DigestSignatureSpi.MD2 md2, BCDSTU4145PublicKey bCDSTU4145PublicKey, Container container) {
        new PKCS12BagAttributeCarrierImpl();
        BCRSAPublicKey bCRSAPublicKey = md2.init;
        this.init = str;
        this.getInstance = md2.Cardinal;
        if (container == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
        } else {
            getSDKAppID getsdkappid2 = container.init;
            container.getInstance();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid2), EC5Util.init(container.Cardinal), container.getInstance, container.cca_continue.intValue());
        }
        this.cca_continue = init(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(String str, DigestSignatureSpi.MD2 md2) {
        new PKCS12BagAttributeCarrierImpl();
        this.init = str;
        this.getInstance = md2.Cardinal;
        this.Cardinal = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: com.cardinalcommerce.a.EncryptedJWT} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: com.cardinalcommerce.a.Container} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: com.cardinalcommerce.a.EncryptedJWT} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: com.cardinalcommerce.a.EncryptedJWT} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r14) throws java.io.IOException {
        /*
            r13 = this;
            com.cardinalcommerce.a.DSASigner$stdDSA r0 = r14.cca_continue
            com.cardinalcommerce.a.getProxyAddress r0 = r0.cca_continue
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r0 = com.cardinalcommerce.p060a.KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo.init(r0)
            boolean r1 = r0.Cardinal()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0064
            com.cardinalcommerce.a.setLocationDataConsentGiven r0 = r0.configure
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r0)
            com.cardinalcommerce.a.KeyAgreementSpi$DH r1 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.init((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r0)
            if (r1 != 0) goto L_0x003f
            com.cardinalcommerce.a.BCRSAPublicKey r1 = com.cardinalcommerce.p060a.DSASigner.detDSASha3_512.init(r0)
            com.cardinalcommerce.a.getSDKAppID r4 = r1.Cardinal
            r1.init()
            java.security.spec.EllipticCurve r7 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getInstance(r4)
            com.cardinalcommerce.a.Base64URL r4 = new com.cardinalcommerce.a.Base64URL
            java.lang.String r6 = r0.init
            com.cardinalcommerce.a.ChallengeParameters r0 = r1.init
            java.security.spec.ECPoint r8 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init(r0)
            java.math.BigInteger r9 = r1.cca_continue
            java.math.BigInteger r10 = r1.getInstance
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            r13.Cardinal = r4
            goto L_0x0142
        L_0x003f:
            com.cardinalcommerce.a.getSDKAppID r4 = r1.cca_continue
            r1.init()
            java.security.spec.EllipticCurve r7 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getInstance(r4)
            com.cardinalcommerce.a.Base64URL r4 = new com.cardinalcommerce.a.Base64URL
            java.lang.String r6 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getInstance((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r0)
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo r0 = r1.getInstance
            com.cardinalcommerce.a.ChallengeParameters r0 = r0.cca_continue()
            java.security.spec.ECPoint r8 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init(r0)
            java.math.BigInteger r9 = r1.Cardinal
            java.math.BigInteger r10 = r1.init
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            r13.Cardinal = r4
            goto L_0x0142
        L_0x0064:
            boolean r1 = r0.cca_continue()
            if (r1 == 0) goto L_0x006e
            r13.Cardinal = r2
            goto L_0x0142
        L_0x006e:
            com.cardinalcommerce.a.setLocationDataConsentGiven r1 = r0.configure
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r1 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r1)
            r4 = 0
            com.cardinalcommerce.a.getProxyAddress r4 = r1.Cardinal((int) r4)
            boolean r4 = r4 instanceof com.cardinalcommerce.p060a.setProxyAddress
            if (r4 == 0) goto L_0x00a7
            com.cardinalcommerce.a.setLocationDataConsentGiven r0 = r0.configure
            com.cardinalcommerce.a.KeyAgreementSpi$DH r0 = com.cardinalcommerce.p060a.KeyAgreementSpi.C1970DH.configure(r0)
            com.cardinalcommerce.a.getSDKAppID r1 = r0.cca_continue
            r0.init()
            java.security.spec.EllipticCurve r1 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getInstance(r1)
            java.security.spec.ECParameterSpec r4 = new java.security.spec.ECParameterSpec
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo r5 = r0.getInstance
            com.cardinalcommerce.a.ChallengeParameters r5 = r5.cca_continue()
            java.security.spec.ECPoint r5 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init(r5)
            java.math.BigInteger r6 = r0.Cardinal
            java.math.BigInteger r0 = r0.init
            int r0 = r0.intValue()
            r4.<init>(r1, r5, r6, r0)
            r13.Cardinal = r4
            goto L_0x0142
        L_0x00a7:
            com.cardinalcommerce.a.DSASigner$dsa224 r0 = com.cardinalcommerce.p060a.DSASigner.dsa224.configure(r1)
            boolean r1 = r0.configure()
            if (r1 == 0) goto L_0x00cc
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = r0.Cardinal
            com.cardinalcommerce.a.BCRSAPublicKey r1 = com.cardinalcommerce.p060a.DSASigner.detDSASha3_512.init(r0)
            com.cardinalcommerce.a.EncryptedJWT r11 = new com.cardinalcommerce.a.EncryptedJWT
            java.lang.String r5 = r0.init
            com.cardinalcommerce.a.getSDKAppID r6 = r1.Cardinal
            com.cardinalcommerce.a.ChallengeParameters r7 = r1.init
            java.math.BigInteger r8 = r1.cca_continue
            java.math.BigInteger r9 = r1.getInstance
            byte[] r10 = r1.init()
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            goto L_0x0124
        L_0x00cc:
            com.cardinalcommerce.a.DSASigner$dsa384 r0 = r0.getInstance
            byte[] r1 = r0.init()
            com.cardinalcommerce.a.DSASigner$stdDSA r4 = r14.cca_continue
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r4 = r4.init
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r5 = com.cardinalcommerce.p060a.DSASigner.dsaSha3_512.configure
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00e1
            init((byte[]) r1)
        L_0x00e1:
            com.cardinalcommerce.a.DSASigner$detDSASha3_384 r4 = r0.Cardinal
            com.cardinalcommerce.a.getSDKAppID$cca_continue r12 = new com.cardinalcommerce.a.getSDKAppID$cca_continue
            int r6 = r4.getInstance
            int r7 = r4.cca_continue
            int r8 = r4.configure
            int r9 = r4.init
            com.cardinalcommerce.a.setProxyAddress r4 = r0.cca_continue
            java.math.BigInteger r10 = new java.math.BigInteger
            byte[] r4 = r4.Cardinal
            r10.<init>(r4)
            java.math.BigInteger r11 = new java.math.BigInteger
            r11.<init>(r3, r1)
            r5 = r12
            r5.<init>((int) r6, (int) r7, (int) r8, (int) r9, (java.math.BigInteger) r10, (java.math.BigInteger) r11)
            byte[] r1 = r0.cca_continue()
            com.cardinalcommerce.a.DSASigner$stdDSA r4 = r14.cca_continue
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r4 = r4.init
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r5 = com.cardinalcommerce.p060a.DSASigner.dsaSha3_512.configure
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0112
            init((byte[]) r1)
        L_0x0112:
            com.cardinalcommerce.a.Container r11 = new com.cardinalcommerce.a.Container
            com.cardinalcommerce.a.ChallengeParameters r1 = com.cardinalcommerce.p060a.DSASigner.dsa256.cca_continue((com.cardinalcommerce.p060a.getSDKAppID) r12, (byte[]) r1)
            com.cardinalcommerce.a.setProxyAddress r0 = r0.init
            java.math.BigInteger r4 = new java.math.BigInteger
            byte[] r0 = r0.Cardinal
            r4.<init>(r0)
            r11.<init>(r12, r1, r4)
        L_0x0124:
            com.cardinalcommerce.a.getSDKAppID r0 = r11.init
            r11.getInstance()
            java.security.spec.EllipticCurve r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getInstance(r0)
            java.security.spec.ECParameterSpec r1 = new java.security.spec.ECParameterSpec
            com.cardinalcommerce.a.ChallengeParameters r4 = r11.Cardinal
            java.security.spec.ECPoint r4 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init(r4)
            java.math.BigInteger r5 = r11.getInstance
            java.math.BigInteger r6 = r11.cca_continue
            int r6 = r6.intValue()
            r1.<init>(r0, r4, r5, r6)
            r13.Cardinal = r1
        L_0x0142:
            com.cardinalcommerce.a.isEnableDFSync r14 = r14.init
            byte[] r14 = r14.cca_continue()
            com.cardinalcommerce.a.setLocationDataConsentGiven r14 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r14)
            boolean r0 = r14 instanceof com.cardinalcommerce.p060a.setProxyAddress
            if (r0 == 0) goto L_0x015e
            com.cardinalcommerce.a.setProxyAddress r14 = com.cardinalcommerce.p060a.setProxyAddress.Cardinal((java.lang.Object) r14)
            java.math.BigInteger r0 = new java.math.BigInteger
            byte[] r14 = r14.Cardinal
            r0.<init>(r14)
            r13.getInstance = r0
            return
        L_0x015e:
            if (r14 == 0) goto L_0x0169
            com.cardinalcommerce.a.DSASigner$detDSASha3_256 r2 = new com.cardinalcommerce.a.DSASigner$detDSASha3_256
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r14 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r14)
            r2.<init>(r14)
        L_0x0169:
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r14 = r2.init
            com.cardinalcommerce.a.getProxyAddress r14 = r14.Cardinal((int) r3)
            com.cardinalcommerce.a.isEnableDFSync r14 = (com.cardinalcommerce.p060a.isEnableDFSync) r14
            java.math.BigInteger r0 = new java.math.BigInteger
            byte[] r14 = r14.cca_continue()
            r0.<init>(r3, r14)
            r13.getInstance = r0
            com.cardinalcommerce.a.PrivateKeyInfo r14 = r2.cca_continue()
            r13.cca_continue = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey.init(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a1 A[Catch:{ IOException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b6 A[Catch:{ IOException -> 0x00d1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getEncoded() {
        /*
            r9 = this;
            java.security.spec.ECParameterSpec r0 = r9.Cardinal
            boolean r1 = r0 instanceof com.cardinalcommerce.p060a.Base64URL
            r2 = 0
            if (r1 == 0) goto L_0x0022
            com.cardinalcommerce.a.Base64URL r0 = (com.cardinalcommerce.p060a.Base64URL) r0
            java.lang.String r0 = r0.getInstance
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.cca_continue(r0)
            if (r0 != 0) goto L_0x001c
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier
            java.security.spec.ECParameterSpec r1 = r9.Cardinal
            com.cardinalcommerce.a.Base64URL r1 = (com.cardinalcommerce.p060a.Base64URL) r1
            java.lang.String r1 = r1.getInstance
            r0.<init>((java.lang.String) r1)
        L_0x001c:
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r1 = new com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo
            r1.<init>((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r0)
            goto L_0x006e
        L_0x0022:
            if (r0 != 0) goto L_0x0036
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r1 = new com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo
            com.cardinalcommerce.a.ECGOST$Mappings r0 = com.cardinalcommerce.p060a.ECGOST.Mappings.Cardinal
            r1.<init>((com.cardinalcommerce.p060a.setUiType) r0)
            com.cardinalcommerce.a.NHKeyFactorySpi r0 = com.cardinalcommerce.p060a.JWK.getInstance
            java.math.BigInteger r3 = r9.getS()
            int r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.init(r0, r2, r3)
            goto L_0x007e
        L_0x0036:
            java.security.spec.EllipticCurve r0 = r0.getCurve()
            com.cardinalcommerce.a.getSDKAppID r4 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.Cardinal(r0)
            com.cardinalcommerce.a.KeyAgreementSpi$DH r0 = new com.cardinalcommerce.a.KeyAgreementSpi$DH
            java.security.spec.ECParameterSpec r1 = r9.Cardinal
            java.security.spec.ECPoint r1 = r1.getGenerator()
            com.cardinalcommerce.a.ChallengeParameters r5 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init((com.cardinalcommerce.p060a.getSDKAppID) r4, (java.security.spec.ECPoint) r1)
            java.security.spec.ECParameterSpec r1 = r9.Cardinal
            java.math.BigInteger r6 = r1.getOrder()
            java.security.spec.ECParameterSpec r1 = r9.Cardinal
            int r1 = r1.getCofactor()
            long r7 = (long) r1
            java.math.BigInteger r7 = java.math.BigInteger.valueOf(r7)
            java.security.spec.ECParameterSpec r1 = r9.Cardinal
            java.security.spec.EllipticCurve r1 = r1.getCurve()
            byte[] r8 = r1.getSeed()
            r3 = r0
            r3.<init>((com.cardinalcommerce.p060a.getSDKAppID) r4, (com.cardinalcommerce.p060a.ChallengeParameters) r5, (java.math.BigInteger) r6, (java.math.BigInteger) r7, (byte[]) r8)
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r1 = new com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo
            r1.<init>((com.cardinalcommerce.p060a.KeyAgreementSpi.C1970DH) r0)
        L_0x006e:
            com.cardinalcommerce.a.NHKeyFactorySpi r0 = com.cardinalcommerce.p060a.JWK.getInstance
            java.security.spec.ECParameterSpec r3 = r9.Cardinal
            java.math.BigInteger r3 = r3.getOrder()
            java.math.BigInteger r4 = r9.getS()
            int r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.init(r0, r3, r4)
        L_0x007e:
            com.cardinalcommerce.a.PrivateKeyInfo r3 = r9.cca_continue
            if (r3 == 0) goto L_0x008e
            com.cardinalcommerce.a.DSASigner$detDSASha3_256 r3 = new com.cardinalcommerce.a.DSASigner$detDSASha3_256
            java.math.BigInteger r4 = r9.getS()
            com.cardinalcommerce.a.PrivateKeyInfo r5 = r9.cca_continue
            r3.<init>(r0, r4, r5, r1)
            goto L_0x0097
        L_0x008e:
            com.cardinalcommerce.a.DSASigner$detDSASha3_256 r3 = new com.cardinalcommerce.a.DSASigner$detDSASha3_256
            java.math.BigInteger r4 = r9.getS()
            r3.<init>(r0, r4, r1)
        L_0x0097:
            java.lang.String r0 = r9.init     // Catch:{ IOException -> 0x00d1 }
            java.lang.String r4 = "DSTU4145"
            boolean r0 = r0.equals(r4)     // Catch:{ IOException -> 0x00d1 }
            if (r0 == 0) goto L_0x00b6
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r0 = new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x00d1 }
            com.cardinalcommerce.a.DSASigner$stdDSA r4 = new com.cardinalcommerce.a.DSASigner$stdDSA     // Catch:{ IOException -> 0x00d1 }
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r5 = com.cardinalcommerce.p060a.DSASigner.dsaSha3_512.cca_continue     // Catch:{ IOException -> 0x00d1 }
            com.cardinalcommerce.a.setLocationDataConsentGiven r1 = r1.values()     // Catch:{ IOException -> 0x00d1 }
            r4.<init>(r5, r1)     // Catch:{ IOException -> 0x00d1 }
            com.cardinalcommerce.a.setLocationDataConsentGiven r1 = r3.values()     // Catch:{ IOException -> 0x00d1 }
            r0.<init>(r4, r1)     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00ca
        L_0x00b6:
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r0 = new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x00d1 }
            com.cardinalcommerce.a.DSASigner$stdDSA r4 = new com.cardinalcommerce.a.DSASigner$stdDSA     // Catch:{ IOException -> 0x00d1 }
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r5 = com.cardinalcommerce.p060a.KeyAgreementSpi.ECKAEGwithSHA1KDF.CardinalUiType     // Catch:{ IOException -> 0x00d1 }
            com.cardinalcommerce.a.setLocationDataConsentGiven r1 = r1.values()     // Catch:{ IOException -> 0x00d1 }
            r4.<init>(r5, r1)     // Catch:{ IOException -> 0x00d1 }
            com.cardinalcommerce.a.setLocationDataConsentGiven r1 = r3.values()     // Catch:{ IOException -> 0x00d1 }
            r0.<init>(r4, r1)     // Catch:{ IOException -> 0x00d1 }
        L_0x00ca:
            java.lang.String r1 = "DER"
            byte[] r0 = r0.init(r1)     // Catch:{ IOException -> 0x00d1 }
            return r0
        L_0x00d1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey.getEncoded():byte[]");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PrivateKey)) {
            return false;
        }
        BCDSTU4145PrivateKey bCDSTU4145PrivateKey = (BCDSTU4145PrivateKey) obj;
        if (this.getInstance.equals(bCDSTU4145PrivateKey.getInstance)) {
            ECParameterSpec eCParameterSpec = this.Cardinal;
            Container cca_continue2 = eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue();
            ECParameterSpec eCParameterSpec2 = bCDSTU4145PrivateKey.Cardinal;
            if (cca_continue2.equals(eCParameterSpec2 != null ? EC5Util.cca_continue(eCParameterSpec2) : JWK.getInstance.cca_continue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.getInstance.hashCode();
        ECParameterSpec eCParameterSpec = this.Cardinal;
        return hashCode ^ (eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue()).hashCode();
    }

    public String toString() {
        String str = this.init;
        BigInteger bigInteger = this.getInstance;
        ECParameterSpec eCParameterSpec = this.Cardinal;
        return ECUtil.configure(str, bigInteger, eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue());
    }

    private static PrivateKeyInfo init(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        try {
            return SubjectPublicKeyInfo.init(setLocationDataConsentGiven.getInstance(bCDSTU4145PublicKey.getEncoded())).getInstance;
        } catch (IOException unused) {
            return null;
        }
    }
}
