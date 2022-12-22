package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.ByteUtils;
import com.cardinalcommerce.p060a.ChallengeParameters;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ECDSAVerifier;
import com.cardinalcommerce.p060a.GOST3410Util;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.NHKeyFactorySpi;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey */
public class BCECPublicKey implements ECDSAVerifier, ECPublicKey {
    transient ECParameterSpec Cardinal;
    transient DigestSignatureSpi configure;
    private transient NHKeyFactorySpi getInstance;
    private String init = "EC";

    public BCECPublicKey(String str, DigestSignatureSpi digestSignatureSpi, NHKeyFactorySpi nHKeyFactorySpi) {
        this.init = str;
        this.configure = digestSignatureSpi;
        this.Cardinal = null;
        this.getInstance = nHKeyFactorySpi;
    }

    BCECPublicKey(String str, SubjectPublicKeyInfo subjectPublicKeyInfo, NHKeyFactorySpi nHKeyFactorySpi) {
        this.init = str;
        this.getInstance = nHKeyFactorySpi;
        getInstance(subjectPublicKeyInfo);
    }

    public BCECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec, NHKeyFactorySpi nHKeyFactorySpi) {
        this.init = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.Cardinal = params;
        this.configure = new DigestSignatureSpi(EC5Util.configure(params, eCPublicKeySpec.getW()), EC5Util.Cardinal(nHKeyFactorySpi, eCPublicKeySpec.getParams()));
        this.getInstance = nHKeyFactorySpi;
    }

    public BCECPublicKey(ECPublicKey eCPublicKey, NHKeyFactorySpi nHKeyFactorySpi) {
        this.init = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.Cardinal = params;
        this.configure = new DigestSignatureSpi(EC5Util.configure(params, eCPublicKey.getW()), EC5Util.Cardinal(nHKeyFactorySpi, eCPublicKey.getParams()));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.getInstance = JWK.getInstance;
        getInstance(SubjectPublicKeyInfo.init(setLocationDataConsentGiven.getInstance((byte[]) objectInputStream.readObject())));
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
        return "X.509";
    }

    public ECParameterSpec getParams() {
        return this.Cardinal;
    }

    public BCECPublicKey(String str, ByteUtils byteUtils, NHKeyFactorySpi nHKeyFactorySpi) {
        this.init = str;
        if (byteUtils.cca_continue != null) {
            getSDKAppID getsdkappid = byteUtils.cca_continue.init;
            byteUtils.cca_continue.getInstance();
            EllipticCurve instance = EC5Util.getInstance(getsdkappid);
            this.configure = new DigestSignatureSpi(byteUtils.Cardinal, ECUtil.getInstance(nHKeyFactorySpi, byteUtils.cca_continue));
            this.Cardinal = EC5Util.Cardinal(instance, byteUtils.cca_continue);
        } else {
            getSDKAppID getsdkappid2 = nHKeyFactorySpi.cca_continue().init;
            BigInteger Cardinal2 = byteUtils.Cardinal.getSDKVersion().Cardinal();
            ChallengeParameters challengeParameters = byteUtils.Cardinal;
            if (challengeParameters.CardinalEnvironment()) {
                this.configure = new DigestSignatureSpi(getsdkappid2.Cardinal(Cardinal2, challengeParameters.CardinalError().Cardinal(), false), EC5Util.Cardinal(nHKeyFactorySpi, (ECParameterSpec) null));
                this.Cardinal = null;
            } else {
                throw new IllegalStateException("point not in normal form");
            }
        }
        this.getInstance = nHKeyFactorySpi;
    }

    public BCECPublicKey(String str, DigestSignatureSpi digestSignatureSpi, ECParameterSpec eCParameterSpec, NHKeyFactorySpi nHKeyFactorySpi) {
        BCRSAPublicKey bCRSAPublicKey = digestSignatureSpi.init;
        this.init = str;
        this.configure = digestSignatureSpi;
        if (eCParameterSpec == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
        } else {
            this.Cardinal = eCParameterSpec;
        }
        this.getInstance = nHKeyFactorySpi;
    }

    public BCECPublicKey(String str, DigestSignatureSpi digestSignatureSpi, Container container, NHKeyFactorySpi nHKeyFactorySpi) {
        BCRSAPublicKey bCRSAPublicKey = digestSignatureSpi.init;
        this.init = str;
        if (container == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
        } else {
            getSDKAppID getsdkappid2 = container.init;
            container.getInstance();
            this.Cardinal = EC5Util.Cardinal(EC5Util.getInstance(getsdkappid2), container);
        }
        this.configure = digestSignatureSpi;
        this.getInstance = nHKeyFactorySpi;
    }

    /* JADX WARNING: type inference failed for: r7v6, types: [com.cardinalcommerce.a.setLocationDataConsentGiven] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getInstance(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo r7) {
        /*
            r6 = this;
            com.cardinalcommerce.a.DSASigner$stdDSA r0 = r7.init
            com.cardinalcommerce.a.getProxyAddress r0 = r0.cca_continue
            com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo r0 = com.cardinalcommerce.p060a.KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo.init(r0)
            com.cardinalcommerce.a.NHKeyFactorySpi r1 = r6.getInstance
            com.cardinalcommerce.a.getSDKAppID r1 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getInstance(r1, r0)
            java.security.spec.ECParameterSpec r2 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init((com.cardinalcommerce.p060a.KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo) r0, (com.cardinalcommerce.p060a.getSDKAppID) r1)
            r6.Cardinal = r2
            com.cardinalcommerce.a.PrivateKeyInfo r7 = r7.getInstance
            byte[] r7 = r7.getInstance()
            com.cardinalcommerce.a.EdEC r2 = new com.cardinalcommerce.a.EdEC
            r2.<init>((byte[]) r7)
            r3 = 0
            byte r3 = r7[r3]
            r4 = 4
            if (r3 != r4) goto L_0x0052
            r3 = 1
            byte r3 = r7[r3]
            int r4 = r7.length
            r5 = 2
            int r4 = r4 - r5
            if (r3 != r4) goto L_0x0052
            byte r3 = r7[r5]
            r4 = 3
            if (r3 == r5) goto L_0x0036
            byte r3 = r7[r5]
            if (r3 != r4) goto L_0x0052
        L_0x0036:
            int r3 = r1.configure()
            int r3 = r3 + 7
            int r3 = r3 / 8
            int r5 = r7.length
            int r5 = r5 - r4
            if (r3 < r5) goto L_0x0052
            com.cardinalcommerce.a.setLocationDataConsentGiven r7 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r7)     // Catch:{ IOException -> 0x004a }
            r2 = r7
            com.cardinalcommerce.a.isEnableDFSync r2 = (com.cardinalcommerce.p060a.isEnableDFSync) r2     // Catch:{ IOException -> 0x004a }
            goto L_0x0052
        L_0x004a:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "error recovering public key"
            r7.<init>(r0)
            throw r7
        L_0x0052:
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo r7 = new com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo
            r7.<init>((com.cardinalcommerce.p060a.getSDKAppID) r1, (com.cardinalcommerce.p060a.isEnableDFSync) r2)
            com.cardinalcommerce.a.DigestSignatureSpi r1 = new com.cardinalcommerce.a.DigestSignatureSpi
            com.cardinalcommerce.a.ChallengeParameters r7 = r7.cca_continue()
            com.cardinalcommerce.a.NHKeyFactorySpi r2 = r6.getInstance
            com.cardinalcommerce.a.BCRSAPublicKey r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.Cardinal(r2, r0)
            r1.<init>(r7, r0)
            r6.configure = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec.BCECPublicKey.getInstance(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public byte[] getEncoded() {
        return KeyUtil.configure(new SubjectPublicKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.ECKAEGwithSHA1KDF.CardinalUiType, GOST3410Util.configure(this.Cardinal)), isEnableDFSync.init(new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(this.configure.cca_continue, false).values()).cca_continue()));
    }

    public ECPoint getW() {
        return EC5Util.init(this.configure.cca_continue);
    }

    public final ChallengeParameters configure() {
        ChallengeParameters challengeParameters = this.configure.cca_continue;
        return this.Cardinal == null ? challengeParameters.init() : challengeParameters;
    }

    public String toString() {
        ChallengeParameters challengeParameters = this.configure.cca_continue;
        ECParameterSpec eCParameterSpec = this.Cardinal;
        return ECUtil.configure("EC", challengeParameters, eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : this.getInstance.cca_continue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECPublicKey)) {
            return false;
        }
        BCECPublicKey bCECPublicKey = (BCECPublicKey) obj;
        if (this.configure.cca_continue.init(bCECPublicKey.configure.cca_continue)) {
            ECParameterSpec eCParameterSpec = this.Cardinal;
            Container cca_continue = eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : this.getInstance.cca_continue();
            ECParameterSpec eCParameterSpec2 = bCECPublicKey.Cardinal;
            if (cca_continue.equals(eCParameterSpec2 != null ? EC5Util.cca_continue(eCParameterSpec2) : bCECPublicKey.getInstance.cca_continue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.configure.cca_continue.hashCode();
        ECParameterSpec eCParameterSpec = this.Cardinal;
        return hashCode ^ (eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : this.getInstance.cca_continue()).hashCode();
    }
}
