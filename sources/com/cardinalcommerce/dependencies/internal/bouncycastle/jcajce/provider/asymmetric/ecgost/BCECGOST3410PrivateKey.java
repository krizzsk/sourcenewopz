package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost;

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
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;

public class BCECGOST3410PrivateKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF, KeyLengthException, ECPrivateKey {
    private transient ECParameterSpec Cardinal;
    private transient getProxyAddress cca_continue;
    private transient PrivateKeyInfo configure;
    private transient BigInteger getInstance;
    private String init = "ECGOST3410";

    protected BCECGOST3410PrivateKey() {
        new PKCS12BagAttributeCarrierImpl();
    }

    BCECGOST3410PrivateKey(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo privateKeyInfo) throws IOException {
        new PKCS12BagAttributeCarrierImpl();
        init(privateKeyInfo);
    }

    public BCECGOST3410PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        new PKCS12BagAttributeCarrierImpl();
        this.getInstance = eCPrivateKeySpec.getS();
        this.Cardinal = eCPrivateKeySpec.getParams();
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

    public BCECGOST3410PrivateKey(X509CertUtils x509CertUtils) {
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

    public BCECGOST3410PrivateKey(String str, DigestSignatureSpi.MD2 md2, BCECGOST3410PublicKey bCECGOST3410PublicKey, ECParameterSpec eCParameterSpec) {
        new PKCS12BagAttributeCarrierImpl();
        this.init = str;
        this.getInstance = md2.Cardinal;
        if (eCParameterSpec == null) {
            BCRSAPublicKey bCRSAPublicKey = md2.init;
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            eCParameterSpec = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
        }
        this.Cardinal = eCParameterSpec;
        this.cca_continue = bCECGOST3410PublicKey.init();
        this.configure = getInstance(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(String str, DigestSignatureSpi.MD2 md2, BCECGOST3410PublicKey bCECGOST3410PublicKey, Container container) {
        new PKCS12BagAttributeCarrierImpl();
        this.init = str;
        this.getInstance = md2.Cardinal;
        if (container == null) {
            BCRSAPublicKey bCRSAPublicKey = md2.init;
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
        } else {
            getSDKAppID getsdkappid2 = container.init;
            container.getInstance();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid2), EC5Util.init(container.Cardinal), container.getInstance, container.cca_continue.intValue());
        }
        this.cca_continue = bCECGOST3410PublicKey.init();
        this.configure = getInstance(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(String str, DigestSignatureSpi.MD2 md2) {
        new PKCS12BagAttributeCarrierImpl();
        this.init = str;
        this.getInstance = md2.Cardinal;
        this.Cardinal = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.cardinalcommerce.a.DSASigner$detDSASha3_256} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r12) throws java.io.IOException {
        /*
            r11 = this;
            com.cardinalcommerce.a.DSASigner$stdDSA r0 = r12.cca_continue
            com.cardinalcommerce.a.getProxyAddress r0 = r0.cca_continue
            com.cardinalcommerce.a.setLocationDataConsentGiven r1 = r0.values()
            boolean r2 = r1 instanceof com.cardinalcommerce.p060a.setThreeDSRequestorAppURL
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x00a1
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r2 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r1)
            int r2 = r2.getInstance()
            r5 = 2
            if (r2 == r5) goto L_0x0024
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r1 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r1)
            int r1 = r1.getInstance()
            r2 = 3
            if (r1 != r2) goto L_0x00a1
        L_0x0024:
            boolean r1 = r0 instanceof com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithSHA1CKDF
            if (r1 == 0) goto L_0x002c
            r3 = r0
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF r3 = (com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithSHA1CKDF) r3
            goto L_0x0037
        L_0x002c:
            if (r0 == 0) goto L_0x0037
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF r3 = new com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r0 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r0)
            r3.<init>(r0)
        L_0x0037:
            r11.cca_continue = r3
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = r3.cca_continue
            java.lang.String r0 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(r0)
            com.cardinalcommerce.a.EncryptedJWT r0 = com.cardinalcommerce.p060a.Payload.Cardinal(r0)
            com.cardinalcommerce.a.getSDKAppID r1 = r0.init
            r0.getInstance()
            java.security.spec.EllipticCurve r7 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getInstance(r1)
            com.cardinalcommerce.a.Base64URL r1 = new com.cardinalcommerce.a.Base64URL
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r2 = r3.cca_continue
            java.lang.String r6 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(r2)
            com.cardinalcommerce.a.ChallengeParameters r2 = r0.Cardinal
            java.security.spec.ECPoint r8 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init(r2)
            java.math.BigInteger r9 = r0.getInstance
            java.math.BigInteger r10 = r0.cca_continue
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10)
            r11.Cardinal = r1
            com.cardinalcommerce.a.isEnableDFSync r12 = r12.init
            byte[] r12 = r12.cca_continue()
            com.cardinalcommerce.a.setLocationDataConsentGiven r12 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r12)
            boolean r0 = r12 instanceof com.cardinalcommerce.p060a.setProxyAddress
            if (r0 == 0) goto L_0x0080
            com.cardinalcommerce.a.setProxyAddress r12 = com.cardinalcommerce.p060a.setProxyAddress.Cardinal((java.lang.Object) r12)
            java.math.BigInteger r0 = new java.math.BigInteger
            byte[] r12 = r12.Cardinal
            r0.<init>(r4, r12)
            r11.getInstance = r0
            return
        L_0x0080:
            com.cardinalcommerce.a.isEnableDFSync r12 = com.cardinalcommerce.p060a.isEnableDFSync.init(r12)
            byte[] r12 = r12.cca_continue()
            int r0 = r12.length
            byte[] r0 = new byte[r0]
            r1 = 0
        L_0x008c:
            int r2 = r12.length
            if (r1 == r2) goto L_0x0099
            int r2 = r12.length
            int r2 = r2 - r4
            int r2 = r2 - r1
            byte r2 = r12[r2]
            r0[r1] = r2
            int r1 = r1 + 1
            goto L_0x008c
        L_0x0099:
            java.math.BigInteger r12 = new java.math.BigInteger
            r12.<init>(r4, r0)
            r11.getInstance = r12
            return
        L_0x00a1:
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r0 = com.cardinalcommerce.p060a.KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo.init(r0)
            boolean r1 = r0.Cardinal()
            if (r1 == 0) goto L_0x00f9
            com.cardinalcommerce.a.setLocationDataConsentGiven r0 = r0.configure
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r0)
            com.cardinalcommerce.a.KeyAgreementSpi$DH r1 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.init((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r0)
            if (r1 != 0) goto L_0x00d4
            com.cardinalcommerce.a.BCRSAPublicKey r1 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithRFC2631KDF.init(r0)
            com.cardinalcommerce.a.KeyAgreementSpi$DH r2 = new com.cardinalcommerce.a.KeyAgreementSpi$DH
            com.cardinalcommerce.a.getSDKAppID r6 = r1.Cardinal
            com.cardinalcommerce.a.ChallengeParameters r7 = r1.init
            java.math.BigInteger r8 = r1.cca_continue
            java.math.BigInteger r9 = r1.getInstance
            byte[] r10 = r1.init()
            r5 = r2
            r5.<init>((com.cardinalcommerce.p060a.getSDKAppID) r6, (com.cardinalcommerce.p060a.ChallengeParameters) r7, (java.math.BigInteger) r8, (java.math.BigInteger) r9, (byte[]) r10)
            java.lang.String r0 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(r0)
            r6 = r0
            r1 = r2
            goto L_0x00d9
        L_0x00d4:
            java.lang.String r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getInstance((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r0)
            r6 = r0
        L_0x00d9:
            com.cardinalcommerce.a.getSDKAppID r0 = r1.cca_continue
            r1.init()
            java.security.spec.EllipticCurve r7 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getInstance(r0)
            com.cardinalcommerce.a.Base64URL r0 = new com.cardinalcommerce.a.Base64URL
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo r2 = r1.getInstance
            com.cardinalcommerce.a.ChallengeParameters r2 = r2.cca_continue()
            java.security.spec.ECPoint r8 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init(r2)
            java.math.BigInteger r9 = r1.Cardinal
            java.math.BigInteger r10 = r1.init
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r11.Cardinal = r0
            goto L_0x012a
        L_0x00f9:
            boolean r1 = r0.cca_continue()
            if (r1 == 0) goto L_0x0102
            r11.Cardinal = r3
            goto L_0x012a
        L_0x0102:
            com.cardinalcommerce.a.setLocationDataConsentGiven r0 = r0.configure
            com.cardinalcommerce.a.KeyAgreementSpi$DH r0 = com.cardinalcommerce.p060a.KeyAgreementSpi.C1970DH.configure(r0)
            com.cardinalcommerce.a.getSDKAppID r1 = r0.cca_continue
            r0.init()
            java.security.spec.EllipticCurve r1 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getInstance(r1)
            java.security.spec.ECParameterSpec r2 = new java.security.spec.ECParameterSpec
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo r5 = r0.getInstance
            com.cardinalcommerce.a.ChallengeParameters r5 = r5.cca_continue()
            java.security.spec.ECPoint r5 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init(r5)
            java.math.BigInteger r6 = r0.Cardinal
            java.math.BigInteger r0 = r0.init
            int r0 = r0.intValue()
            r2.<init>(r1, r5, r6, r0)
            r11.Cardinal = r2
        L_0x012a:
            com.cardinalcommerce.a.isEnableDFSync r12 = r12.init
            byte[] r12 = r12.cca_continue()
            com.cardinalcommerce.a.setLocationDataConsentGiven r12 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r12)
            boolean r0 = r12 instanceof com.cardinalcommerce.p060a.setProxyAddress
            if (r0 == 0) goto L_0x0146
            com.cardinalcommerce.a.setProxyAddress r12 = com.cardinalcommerce.p060a.setProxyAddress.Cardinal((java.lang.Object) r12)
            java.math.BigInteger r0 = new java.math.BigInteger
            byte[] r12 = r12.Cardinal
            r0.<init>(r12)
            r11.getInstance = r0
            return
        L_0x0146:
            if (r12 == 0) goto L_0x0151
            com.cardinalcommerce.a.DSASigner$detDSASha3_256 r3 = new com.cardinalcommerce.a.DSASigner$detDSASha3_256
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r12 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r12)
            r3.<init>(r12)
        L_0x0151:
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r12 = r3.init
            com.cardinalcommerce.a.getProxyAddress r12 = r12.Cardinal((int) r4)
            com.cardinalcommerce.a.isEnableDFSync r12 = (com.cardinalcommerce.p060a.isEnableDFSync) r12
            java.math.BigInteger r0 = new java.math.BigInteger
            byte[] r12 = r12.cca_continue()
            r0.<init>(r4, r12)
            r11.getInstance = r0
            com.cardinalcommerce.a.PrivateKeyInfo r12 = r3.cca_continue()
            r11.configure = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PrivateKey.init(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getEncoded() {
        /*
            r9 = this;
            com.cardinalcommerce.a.getProxyAddress r0 = r9.cca_continue
            java.lang.String r1 = "DER"
            r2 = 0
            if (r0 == 0) goto L_0x0047
            r0 = 32
            byte[] r3 = new byte[r0]
            java.math.BigInteger r4 = r9.getS()
            byte[] r4 = r4.toByteArray()
            int r5 = r4.length
            r6 = 0
            if (r5 >= r0) goto L_0x0021
            byte[] r5 = new byte[r0]
            int r7 = r4.length
            int r7 = 32 - r7
            int r8 = r4.length
            java.lang.System.arraycopy(r4, r6, r5, r7, r8)
            r4 = r5
        L_0x0021:
            if (r6 == r0) goto L_0x002e
            int r5 = r4.length
            int r5 = r5 + -1
            int r5 = r5 - r6
            byte r5 = r4[r5]
            r3[r6] = r5
            int r6 = r6 + 1
            goto L_0x0021
        L_0x002e:
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r0 = new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x0046 }
            com.cardinalcommerce.a.DSASigner$stdDSA r4 = new com.cardinalcommerce.a.DSASigner$stdDSA     // Catch:{ IOException -> 0x0046 }
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r5 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHUwithSHA512CKDF.getSDKVersion     // Catch:{ IOException -> 0x0046 }
            com.cardinalcommerce.a.getProxyAddress r6 = r9.cca_continue     // Catch:{ IOException -> 0x0046 }
            r4.<init>(r5, r6)     // Catch:{ IOException -> 0x0046 }
            com.cardinalcommerce.a.EdEC r5 = new com.cardinalcommerce.a.EdEC     // Catch:{ IOException -> 0x0046 }
            r5.<init>((byte[]) r3)     // Catch:{ IOException -> 0x0046 }
            r0.<init>(r4, r5)     // Catch:{ IOException -> 0x0046 }
            byte[] r0 = r0.init(r1)     // Catch:{ IOException -> 0x0046 }
            return r0
        L_0x0046:
            return r2
        L_0x0047:
            java.security.spec.ECParameterSpec r0 = r9.Cardinal
            boolean r3 = r0 instanceof com.cardinalcommerce.p060a.Base64URL
            if (r3 == 0) goto L_0x0068
            com.cardinalcommerce.a.Base64URL r0 = (com.cardinalcommerce.p060a.Base64URL) r0
            java.lang.String r0 = r0.getInstance
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.cca_continue(r0)
            if (r0 != 0) goto L_0x0062
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier
            java.security.spec.ECParameterSpec r3 = r9.Cardinal
            com.cardinalcommerce.a.Base64URL r3 = (com.cardinalcommerce.p060a.Base64URL) r3
            java.lang.String r3 = r3.getInstance
            r0.<init>((java.lang.String) r3)
        L_0x0062:
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r3 = new com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo
            r3.<init>((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r0)
            goto L_0x00b4
        L_0x0068:
            if (r0 != 0) goto L_0x007c
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r3 = new com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo
            com.cardinalcommerce.a.ECGOST$Mappings r0 = com.cardinalcommerce.p060a.ECGOST.Mappings.Cardinal
            r3.<init>((com.cardinalcommerce.p060a.setUiType) r0)
            com.cardinalcommerce.a.NHKeyFactorySpi r0 = com.cardinalcommerce.p060a.JWK.getInstance
            java.math.BigInteger r4 = r9.getS()
            int r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.init(r0, r2, r4)
            goto L_0x00c4
        L_0x007c:
            java.security.spec.EllipticCurve r0 = r0.getCurve()
            com.cardinalcommerce.a.getSDKAppID r4 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.Cardinal(r0)
            com.cardinalcommerce.a.KeyAgreementSpi$DH r0 = new com.cardinalcommerce.a.KeyAgreementSpi$DH
            java.security.spec.ECParameterSpec r3 = r9.Cardinal
            java.security.spec.ECPoint r3 = r3.getGenerator()
            com.cardinalcommerce.a.ChallengeParameters r5 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init((com.cardinalcommerce.p060a.getSDKAppID) r4, (java.security.spec.ECPoint) r3)
            java.security.spec.ECParameterSpec r3 = r9.Cardinal
            java.math.BigInteger r6 = r3.getOrder()
            java.security.spec.ECParameterSpec r3 = r9.Cardinal
            int r3 = r3.getCofactor()
            long r7 = (long) r3
            java.math.BigInteger r7 = java.math.BigInteger.valueOf(r7)
            java.security.spec.ECParameterSpec r3 = r9.Cardinal
            java.security.spec.EllipticCurve r3 = r3.getCurve()
            byte[] r8 = r3.getSeed()
            r3 = r0
            r3.<init>((com.cardinalcommerce.p060a.getSDKAppID) r4, (com.cardinalcommerce.p060a.ChallengeParameters) r5, (java.math.BigInteger) r6, (java.math.BigInteger) r7, (byte[]) r8)
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r3 = new com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo
            r3.<init>((com.cardinalcommerce.p060a.KeyAgreementSpi.C1970DH) r0)
        L_0x00b4:
            com.cardinalcommerce.a.NHKeyFactorySpi r0 = com.cardinalcommerce.p060a.JWK.getInstance
            java.security.spec.ECParameterSpec r4 = r9.Cardinal
            java.math.BigInteger r4 = r4.getOrder()
            java.math.BigInteger r5 = r9.getS()
            int r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.init(r0, r4, r5)
        L_0x00c4:
            com.cardinalcommerce.a.PrivateKeyInfo r4 = r9.configure
            if (r4 == 0) goto L_0x00d4
            com.cardinalcommerce.a.DSASigner$detDSASha3_256 r4 = new com.cardinalcommerce.a.DSASigner$detDSASha3_256
            java.math.BigInteger r5 = r9.getS()
            com.cardinalcommerce.a.PrivateKeyInfo r6 = r9.configure
            r4.<init>(r0, r5, r6, r3)
            goto L_0x00dd
        L_0x00d4:
            com.cardinalcommerce.a.DSASigner$detDSASha3_256 r4 = new com.cardinalcommerce.a.DSASigner$detDSASha3_256
            java.math.BigInteger r5 = r9.getS()
            r4.<init>(r0, r5, r3)
        L_0x00dd:
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r0 = new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x00f6 }
            com.cardinalcommerce.a.DSASigner$stdDSA r5 = new com.cardinalcommerce.a.DSASigner$stdDSA     // Catch:{ IOException -> 0x00f6 }
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r6 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHUwithSHA512CKDF.getSDKVersion     // Catch:{ IOException -> 0x00f6 }
            com.cardinalcommerce.a.setLocationDataConsentGiven r3 = r3.values()     // Catch:{ IOException -> 0x00f6 }
            r5.<init>(r6, r3)     // Catch:{ IOException -> 0x00f6 }
            com.cardinalcommerce.a.setLocationDataConsentGiven r3 = r4.values()     // Catch:{ IOException -> 0x00f6 }
            r0.<init>(r5, r3)     // Catch:{ IOException -> 0x00f6 }
            byte[] r0 = r0.init(r1)     // Catch:{ IOException -> 0x00f6 }
            return r0
        L_0x00f6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PrivateKey.getEncoded():byte[]");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410PrivateKey)) {
            return false;
        }
        BCECGOST3410PrivateKey bCECGOST3410PrivateKey = (BCECGOST3410PrivateKey) obj;
        if (this.getInstance.equals(bCECGOST3410PrivateKey.getInstance)) {
            ECParameterSpec eCParameterSpec = this.Cardinal;
            Container cca_continue2 = eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue();
            ECParameterSpec eCParameterSpec2 = bCECGOST3410PrivateKey.Cardinal;
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

    private static PrivateKeyInfo getInstance(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        try {
            return SubjectPublicKeyInfo.init(setLocationDataConsentGiven.getInstance(bCECGOST3410PublicKey.getEncoded())).getInstance;
        } catch (IOException unused) {
            return null;
        }
    }
}
