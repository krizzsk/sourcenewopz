package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12;

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

public class BCECGOST3410_2012PrivateKey implements KeyAgreementSpi.ECKAEGwithSHA512KDF, KeyLengthException, ECPrivateKey {
    private transient ECParameterSpec Cardinal;
    private transient PrivateKeyInfo cca_continue;
    private transient BigInteger configure;
    private transient KeyAgreementSpi.DHwithSHA1CKDF getInstance;
    private String init = "ECGOST3410-2012";

    protected BCECGOST3410_2012PrivateKey() {
        new PKCS12BagAttributeCarrierImpl();
    }

    BCECGOST3410_2012PrivateKey(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo privateKeyInfo) throws IOException {
        new PKCS12BagAttributeCarrierImpl();
        configure(privateKeyInfo);
    }

    public BCECGOST3410_2012PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        new PKCS12BagAttributeCarrierImpl();
        this.configure = eCPrivateKeySpec.getS();
        this.Cardinal = eCPrivateKeySpec.getParams();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        configure(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo.init(setLocationDataConsentGiven.getInstance((byte[]) objectInputStream.readObject())));
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
        return this.configure;
    }

    public ECParameterSpec getParams() {
        return this.Cardinal;
    }

    public BigInteger getS() {
        return this.configure;
    }

    public BCECGOST3410_2012PrivateKey(X509CertUtils x509CertUtils) {
        ECParameterSpec eCParameterSpec;
        new PKCS12BagAttributeCarrierImpl();
        this.configure = x509CertUtils.Cardinal;
        if (x509CertUtils.cca_continue != null) {
            getSDKAppID getsdkappid = x509CertUtils.cca_continue.init;
            x509CertUtils.cca_continue.getInstance();
            eCParameterSpec = EC5Util.Cardinal(EC5Util.getInstance(getsdkappid), x509CertUtils.cca_continue);
        } else {
            eCParameterSpec = null;
        }
        this.Cardinal = eCParameterSpec;
    }

    public BCECGOST3410_2012PrivateKey(String str, DigestSignatureSpi.MD2 md2, BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey, ECParameterSpec eCParameterSpec) {
        new PKCS12BagAttributeCarrierImpl();
        BCRSAPublicKey bCRSAPublicKey = md2.init;
        this.init = str;
        this.configure = md2.Cardinal;
        if (eCParameterSpec == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
        } else {
            this.Cardinal = eCParameterSpec;
        }
        this.getInstance = bCECGOST3410_2012PublicKey.getInstance();
        this.cca_continue = SubjectPublicKeyInfo.init(bCECGOST3410_2012PublicKey.getEncoded()).getInstance;
    }

    public BCECGOST3410_2012PrivateKey(String str, DigestSignatureSpi.MD2 md2, BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey, Container container) {
        new PKCS12BagAttributeCarrierImpl();
        BCRSAPublicKey bCRSAPublicKey = md2.init;
        this.init = str;
        this.configure = md2.Cardinal;
        if (container == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
        } else {
            getSDKAppID getsdkappid2 = container.init;
            container.getInstance();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid2), EC5Util.init(container.Cardinal), container.getInstance, container.cca_continue.intValue());
        }
        this.getInstance = bCECGOST3410_2012PublicKey.getInstance();
        this.cca_continue = SubjectPublicKeyInfo.init(bCECGOST3410_2012PublicKey.getEncoded()).getInstance;
    }

    public BCECGOST3410_2012PrivateKey(String str, DigestSignatureSpi.MD2 md2) {
        new PKCS12BagAttributeCarrierImpl();
        this.init = str;
        this.configure = md2.Cardinal;
        this.Cardinal = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.cardinalcommerce.a.DSASigner$detDSASha3_256} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void configure(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r12) throws java.io.IOException {
        /*
            r11 = this;
            com.cardinalcommerce.a.DSASigner$stdDSA r0 = r12.cca_continue
            com.cardinalcommerce.a.getProxyAddress r0 = r0.cca_continue
            com.cardinalcommerce.a.setLocationDataConsentGiven r0 = r0.values()
            boolean r1 = r0 instanceof com.cardinalcommerce.p060a.setThreeDSRequestorAppURL
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x00a7
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r1 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r0)
            int r1 = r1.getInstance()
            r4 = 2
            if (r1 == r4) goto L_0x0024
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r0 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r0)
            int r0 = r0.getInstance()
            r1 = 3
            if (r0 != r1) goto L_0x00a7
        L_0x0024:
            com.cardinalcommerce.a.DSASigner$stdDSA r0 = r12.cca_continue
            com.cardinalcommerce.a.getProxyAddress r0 = r0.cca_continue
            boolean r1 = r0 instanceof com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithSHA1CKDF
            if (r1 == 0) goto L_0x0030
            r2 = r0
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF r2 = (com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithSHA1CKDF) r2
            goto L_0x003b
        L_0x0030:
            if (r0 == 0) goto L_0x003b
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF r2 = new com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r0 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r0)
            r2.<init>(r0)
        L_0x003b:
            r11.getInstance = r2
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = r2.cca_continue
            java.lang.String r0 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(r0)
            com.cardinalcommerce.a.EncryptedJWT r0 = com.cardinalcommerce.p060a.Payload.Cardinal(r0)
            com.cardinalcommerce.a.getSDKAppID r1 = r0.init
            r0.getInstance()
            java.security.spec.EllipticCurve r6 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getInstance(r1)
            com.cardinalcommerce.a.Base64URL r1 = new com.cardinalcommerce.a.Base64URL
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF r2 = r11.getInstance
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r2 = r2.cca_continue
            java.lang.String r5 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(r2)
            com.cardinalcommerce.a.ChallengeParameters r2 = r0.Cardinal
            java.security.spec.ECPoint r7 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init(r2)
            java.math.BigInteger r8 = r0.getInstance
            java.math.BigInteger r9 = r0.cca_continue
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9)
            r11.Cardinal = r1
            com.cardinalcommerce.a.isEnableDFSync r12 = r12.init
            byte[] r12 = r12.cca_continue()
            com.cardinalcommerce.a.setLocationDataConsentGiven r12 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r12)
            boolean r0 = r12 instanceof com.cardinalcommerce.p060a.setProxyAddress
            if (r0 == 0) goto L_0x0086
            com.cardinalcommerce.a.setProxyAddress r12 = com.cardinalcommerce.p060a.setProxyAddress.Cardinal((java.lang.Object) r12)
            java.math.BigInteger r0 = new java.math.BigInteger
            byte[] r12 = r12.Cardinal
            r0.<init>(r3, r12)
            r11.configure = r0
            return
        L_0x0086:
            com.cardinalcommerce.a.isEnableDFSync r12 = com.cardinalcommerce.p060a.isEnableDFSync.init(r12)
            byte[] r12 = r12.cca_continue()
            int r0 = r12.length
            byte[] r0 = new byte[r0]
            r1 = 0
        L_0x0092:
            int r2 = r12.length
            if (r1 == r2) goto L_0x009f
            int r2 = r12.length
            int r2 = r2 - r3
            int r2 = r2 - r1
            byte r2 = r12[r2]
            r0[r1] = r2
            int r1 = r1 + 1
            goto L_0x0092
        L_0x009f:
            java.math.BigInteger r12 = new java.math.BigInteger
            r12.<init>(r3, r0)
            r11.configure = r12
            return
        L_0x00a7:
            com.cardinalcommerce.a.DSASigner$stdDSA r0 = r12.cca_continue
            com.cardinalcommerce.a.getProxyAddress r0 = r0.cca_continue
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r0 = com.cardinalcommerce.p060a.KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo.init(r0)
            boolean r1 = r0.Cardinal()
            if (r1 == 0) goto L_0x0109
            com.cardinalcommerce.a.setLocationDataConsentGiven r0 = r0.configure
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r0)
            com.cardinalcommerce.a.KeyAgreementSpi$DH r1 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.init((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r0)
            if (r1 != 0) goto L_0x00e5
            com.cardinalcommerce.a.BCRSAPublicKey r1 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithRFC2631KDF.init(r0)
            com.cardinalcommerce.a.getSDKAppID r4 = r1.Cardinal
            r1.init()
            java.security.spec.EllipticCurve r7 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getInstance(r4)
            com.cardinalcommerce.a.Base64URL r4 = new com.cardinalcommerce.a.Base64URL
            java.lang.String r6 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(r0)
            com.cardinalcommerce.a.ChallengeParameters r0 = r1.init
            java.security.spec.ECPoint r8 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init(r0)
            java.math.BigInteger r9 = r1.cca_continue
            java.math.BigInteger r10 = r1.getInstance
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            r11.Cardinal = r4
            goto L_0x013a
        L_0x00e5:
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
            r11.Cardinal = r4
            goto L_0x013a
        L_0x0109:
            boolean r1 = r0.cca_continue()
            if (r1 == 0) goto L_0x0112
            r11.Cardinal = r2
            goto L_0x013a
        L_0x0112:
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
            r11.Cardinal = r4
        L_0x013a:
            com.cardinalcommerce.a.isEnableDFSync r12 = r12.init
            byte[] r12 = r12.cca_continue()
            com.cardinalcommerce.a.setLocationDataConsentGiven r12 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r12)
            boolean r0 = r12 instanceof com.cardinalcommerce.p060a.setProxyAddress
            if (r0 == 0) goto L_0x0156
            com.cardinalcommerce.a.setProxyAddress r12 = com.cardinalcommerce.p060a.setProxyAddress.Cardinal((java.lang.Object) r12)
            java.math.BigInteger r0 = new java.math.BigInteger
            byte[] r12 = r12.Cardinal
            r0.<init>(r12)
            r11.configure = r0
            return
        L_0x0156:
            if (r12 == 0) goto L_0x0161
            com.cardinalcommerce.a.DSASigner$detDSASha3_256 r2 = new com.cardinalcommerce.a.DSASigner$detDSASha3_256
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r12 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r12)
            r2.<init>(r12)
        L_0x0161:
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r12 = r2.init
            com.cardinalcommerce.a.getProxyAddress r12 = r12.Cardinal((int) r3)
            com.cardinalcommerce.a.isEnableDFSync r12 = (com.cardinalcommerce.p060a.isEnableDFSync) r12
            java.math.BigInteger r0 = new java.math.BigInteger
            byte[] r12 = r12.cca_continue()
            r0.<init>(r3, r12)
            r11.configure = r0
            com.cardinalcommerce.a.PrivateKeyInfo r12 = r2.cca_continue()
            r11.cca_continue = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.BCECGOST3410_2012PrivateKey.configure(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getEncoded() {
        /*
            r13 = this;
            java.math.BigInteger r0 = r13.configure
            int r0 = r0.bitLength()
            r1 = 1
            r2 = 0
            r3 = 256(0x100, float:3.59E-43)
            if (r0 <= r3) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0014
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r3 = com.cardinalcommerce.p060a.DSASigner.detDSA224.Cardinal
            goto L_0x0016
        L_0x0014:
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r3 = com.cardinalcommerce.p060a.DSASigner.detDSA224.init
        L_0x0016:
            if (r0 == 0) goto L_0x001b
            r0 = 64
            goto L_0x001d
        L_0x001b:
            r0 = 32
        L_0x001d:
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF r4 = r13.getInstance
            java.lang.String r5 = "DER"
            r6 = 0
            if (r4 == 0) goto L_0x005e
            byte[] r4 = new byte[r0]
            java.math.BigInteger r7 = r13.getS()
            byte[] r7 = r7.toByteArray()
            int r8 = r7.length
            if (r8 >= r0) goto L_0x003b
            byte[] r8 = new byte[r0]
            int r9 = r7.length
            int r9 = r0 - r9
            int r10 = r7.length
            java.lang.System.arraycopy(r7, r2, r8, r9, r10)
            r7 = r8
        L_0x003b:
            if (r2 == r0) goto L_0x0047
            int r8 = r7.length
            int r8 = r8 - r1
            int r8 = r8 - r2
            byte r8 = r7[r8]
            r4[r2] = r8
            int r2 = r2 + 1
            goto L_0x003b
        L_0x0047:
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r0 = new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x005d }
            com.cardinalcommerce.a.DSASigner$stdDSA r1 = new com.cardinalcommerce.a.DSASigner$stdDSA     // Catch:{ IOException -> 0x005d }
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF r2 = r13.getInstance     // Catch:{ IOException -> 0x005d }
            r1.<init>(r3, r2)     // Catch:{ IOException -> 0x005d }
            com.cardinalcommerce.a.EdEC r2 = new com.cardinalcommerce.a.EdEC     // Catch:{ IOException -> 0x005d }
            r2.<init>((byte[]) r4)     // Catch:{ IOException -> 0x005d }
            r0.<init>(r1, r2)     // Catch:{ IOException -> 0x005d }
            byte[] r0 = r0.init(r5)     // Catch:{ IOException -> 0x005d }
            return r0
        L_0x005d:
            return r6
        L_0x005e:
            java.security.spec.ECParameterSpec r0 = r13.Cardinal
            boolean r1 = r0 instanceof com.cardinalcommerce.p060a.Base64URL
            if (r1 == 0) goto L_0x007f
            com.cardinalcommerce.a.Base64URL r0 = (com.cardinalcommerce.p060a.Base64URL) r0
            java.lang.String r0 = r0.getInstance
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.cca_continue(r0)
            if (r0 != 0) goto L_0x0079
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier
            java.security.spec.ECParameterSpec r1 = r13.Cardinal
            com.cardinalcommerce.a.Base64URL r1 = (com.cardinalcommerce.p060a.Base64URL) r1
            java.lang.String r1 = r1.getInstance
            r0.<init>((java.lang.String) r1)
        L_0x0079:
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r1 = new com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo
            r1.<init>((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r0)
            goto L_0x00cb
        L_0x007f:
            if (r0 != 0) goto L_0x0093
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r1 = new com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo
            com.cardinalcommerce.a.ECGOST$Mappings r0 = com.cardinalcommerce.p060a.ECGOST.Mappings.Cardinal
            r1.<init>((com.cardinalcommerce.p060a.setUiType) r0)
            com.cardinalcommerce.a.NHKeyFactorySpi r0 = com.cardinalcommerce.p060a.JWK.getInstance
            java.math.BigInteger r2 = r13.getS()
            int r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.init(r0, r6, r2)
            goto L_0x00db
        L_0x0093:
            java.security.spec.EllipticCurve r0 = r0.getCurve()
            com.cardinalcommerce.a.getSDKAppID r8 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.Cardinal(r0)
            com.cardinalcommerce.a.KeyAgreementSpi$DH r0 = new com.cardinalcommerce.a.KeyAgreementSpi$DH
            java.security.spec.ECParameterSpec r1 = r13.Cardinal
            java.security.spec.ECPoint r1 = r1.getGenerator()
            com.cardinalcommerce.a.ChallengeParameters r9 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init((com.cardinalcommerce.p060a.getSDKAppID) r8, (java.security.spec.ECPoint) r1)
            java.security.spec.ECParameterSpec r1 = r13.Cardinal
            java.math.BigInteger r10 = r1.getOrder()
            java.security.spec.ECParameterSpec r1 = r13.Cardinal
            int r1 = r1.getCofactor()
            long r1 = (long) r1
            java.math.BigInteger r11 = java.math.BigInteger.valueOf(r1)
            java.security.spec.ECParameterSpec r1 = r13.Cardinal
            java.security.spec.EllipticCurve r1 = r1.getCurve()
            byte[] r12 = r1.getSeed()
            r7 = r0
            r7.<init>((com.cardinalcommerce.p060a.getSDKAppID) r8, (com.cardinalcommerce.p060a.ChallengeParameters) r9, (java.math.BigInteger) r10, (java.math.BigInteger) r11, (byte[]) r12)
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r1 = new com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo
            r1.<init>((com.cardinalcommerce.p060a.KeyAgreementSpi.C1970DH) r0)
        L_0x00cb:
            com.cardinalcommerce.a.NHKeyFactorySpi r0 = com.cardinalcommerce.p060a.JWK.getInstance
            java.security.spec.ECParameterSpec r2 = r13.Cardinal
            java.math.BigInteger r2 = r2.getOrder()
            java.math.BigInteger r4 = r13.getS()
            int r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.init(r0, r2, r4)
        L_0x00db:
            com.cardinalcommerce.a.PrivateKeyInfo r2 = r13.cca_continue
            if (r2 == 0) goto L_0x00eb
            com.cardinalcommerce.a.DSASigner$detDSASha3_256 r2 = new com.cardinalcommerce.a.DSASigner$detDSASha3_256
            java.math.BigInteger r4 = r13.getS()
            com.cardinalcommerce.a.PrivateKeyInfo r7 = r13.cca_continue
            r2.<init>(r0, r4, r7, r1)
            goto L_0x00f4
        L_0x00eb:
            com.cardinalcommerce.a.DSASigner$detDSASha3_256 r2 = new com.cardinalcommerce.a.DSASigner$detDSASha3_256
            java.math.BigInteger r4 = r13.getS()
            r2.<init>(r0, r4, r1)
        L_0x00f4:
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r0 = new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x010b }
            com.cardinalcommerce.a.DSASigner$stdDSA r4 = new com.cardinalcommerce.a.DSASigner$stdDSA     // Catch:{ IOException -> 0x010b }
            com.cardinalcommerce.a.setLocationDataConsentGiven r1 = r1.values()     // Catch:{ IOException -> 0x010b }
            r4.<init>(r3, r1)     // Catch:{ IOException -> 0x010b }
            com.cardinalcommerce.a.setLocationDataConsentGiven r1 = r2.values()     // Catch:{ IOException -> 0x010b }
            r0.<init>(r4, r1)     // Catch:{ IOException -> 0x010b }
            byte[] r0 = r0.init(r5)     // Catch:{ IOException -> 0x010b }
            return r0
        L_0x010b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.BCECGOST3410_2012PrivateKey.getEncoded():byte[]");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410_2012PrivateKey)) {
            return false;
        }
        BCECGOST3410_2012PrivateKey bCECGOST3410_2012PrivateKey = (BCECGOST3410_2012PrivateKey) obj;
        if (this.configure.equals(bCECGOST3410_2012PrivateKey.configure)) {
            ECParameterSpec eCParameterSpec = this.Cardinal;
            Container cca_continue2 = eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue();
            ECParameterSpec eCParameterSpec2 = bCECGOST3410_2012PrivateKey.Cardinal;
            if (cca_continue2.equals(eCParameterSpec2 != null ? EC5Util.cca_continue(eCParameterSpec2) : JWK.getInstance.cca_continue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.configure.hashCode();
        ECParameterSpec eCParameterSpec = this.Cardinal;
        return hashCode ^ (eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue()).hashCode();
    }

    public String toString() {
        String str = this.init;
        BigInteger bigInteger = this.configure;
        ECParameterSpec eCParameterSpec = this.Cardinal;
        return ECUtil.configure(str, bigInteger, eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue());
    }
}
