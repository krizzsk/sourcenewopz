package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.Base64URL;
import com.cardinalcommerce.p060a.ByteUtils;
import com.cardinalcommerce.p060a.ChallengeParameters;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ECDSAVerifier;
import com.cardinalcommerce.p060a.EdEC;
import com.cardinalcommerce.p060a.EncryptedJWT;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.NHKeyFactorySpi;
import com.cardinalcommerce.p060a.Payload;
import com.cardinalcommerce.p060a.PrivateKeyInfo;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;

public class BCECGOST3410PublicKey implements ECDSAVerifier, ECPublicKey {
    transient DigestSignatureSpi Cardinal;
    private String configure = "ECGOST3410";
    private transient ECParameterSpec getInstance;
    private transient getProxyAddress init;

    BCECGOST3410PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        configure(subjectPublicKeyInfo);
    }

    public BCECGOST3410PublicKey(String str, DigestSignatureSpi digestSignatureSpi) {
        this.configure = str;
        this.Cardinal = digestSignatureSpi;
        this.getInstance = null;
    }

    public BCECGOST3410PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.getInstance = params;
        this.Cardinal = new DigestSignatureSpi(EC5Util.configure(params, eCPublicKeySpec.getW()), EC5Util.Cardinal((NHKeyFactorySpi) null, eCPublicKeySpec.getParams()));
    }

    private static void Cardinal(byte[] bArr, int i, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(byteArray, 0, bArr2, 32 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i2 = 0; i2 != 32; i2++) {
            bArr[i + i2] = byteArray[(byteArray.length - 1) - i2];
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        configure(SubjectPublicKeyInfo.init(setLocationDataConsentGiven.getInstance((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final Container Cardinal() {
        ECParameterSpec eCParameterSpec = this.getInstance;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.cca_continue(eCParameterSpec);
    }

    public String getAlgorithm() {
        return this.configure;
    }

    public String getFormat() {
        return "X.509";
    }

    public ECParameterSpec getParams() {
        return this.getInstance;
    }

    public BCECGOST3410PublicKey(ByteUtils byteUtils, NHKeyFactorySpi nHKeyFactorySpi) {
        if (byteUtils.cca_continue != null) {
            getSDKAppID getsdkappid = byteUtils.cca_continue.init;
            byteUtils.cca_continue.getInstance();
            EllipticCurve instance = EC5Util.getInstance(getsdkappid);
            this.Cardinal = new DigestSignatureSpi(byteUtils.Cardinal, ECUtil.getInstance(nHKeyFactorySpi, byteUtils.cca_continue));
            this.getInstance = EC5Util.Cardinal(instance, byteUtils.cca_continue);
            return;
        }
        getSDKAppID getsdkappid2 = nHKeyFactorySpi.cca_continue().init;
        BigInteger Cardinal2 = byteUtils.Cardinal.getSDKVersion().Cardinal();
        ChallengeParameters challengeParameters = byteUtils.Cardinal;
        if (challengeParameters.CardinalEnvironment()) {
            this.Cardinal = new DigestSignatureSpi(getsdkappid2.Cardinal(Cardinal2, challengeParameters.CardinalError().Cardinal(), false), EC5Util.Cardinal(nHKeyFactorySpi, (ECParameterSpec) null));
            this.getInstance = null;
            return;
        }
        throw new IllegalStateException("point not in normal form");
    }

    public BCECGOST3410PublicKey(String str, DigestSignatureSpi digestSignatureSpi, ECParameterSpec eCParameterSpec) {
        BCRSAPublicKey bCRSAPublicKey = digestSignatureSpi.init;
        if (bCRSAPublicKey instanceof CipherSpi.ISO9796d1Padding) {
            CipherSpi.ISO9796d1Padding iSO9796d1Padding = (CipherSpi.ISO9796d1Padding) bCRSAPublicKey;
            this.init = new KeyAgreementSpi.DHwithSHA1CKDF(iSO9796d1Padding.configure, iSO9796d1Padding.getWarnings, iSO9796d1Padding.cleanup);
        }
        this.configure = str;
        this.Cardinal = digestSignatureSpi;
        if (eCParameterSpec == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.getInstance = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
            return;
        }
        this.getInstance = eCParameterSpec;
    }

    public BCECGOST3410PublicKey(String str, DigestSignatureSpi digestSignatureSpi, Container container) {
        BCRSAPublicKey bCRSAPublicKey = digestSignatureSpi.init;
        this.configure = str;
        this.Cardinal = digestSignatureSpi;
        if (container == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.getInstance = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
            return;
        }
        getSDKAppID getsdkappid2 = container.init;
        container.getInstance();
        this.getInstance = EC5Util.Cardinal(EC5Util.getInstance(getsdkappid2), container);
    }

    private void configure(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        PrivateKeyInfo privateKeyInfo = subjectPublicKeyInfo.getInstance;
        this.configure = "ECGOST3410";
        try {
            byte[] cca_continue = ((isEnableDFSync) setLocationDataConsentGiven.getInstance(privateKeyInfo.getInstance())).cca_continue();
            byte[] bArr = new byte[65];
            bArr[0] = 4;
            for (int i = 1; i <= 32; i++) {
                bArr[i] = cca_continue[32 - i];
                bArr[i + 32] = cca_continue[64 - i];
            }
            if (subjectPublicKeyInfo.init.cca_continue instanceof ASN1ObjectIdentifier) {
                aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(subjectPublicKeyInfo.init.cca_continue);
                this.init = aSN1ObjectIdentifier;
            } else {
                getProxyAddress getproxyaddress = subjectPublicKeyInfo.init.cca_continue;
                KeyAgreementSpi.DHwithSHA1CKDF dHwithSHA1CKDF = getproxyaddress instanceof KeyAgreementSpi.DHwithSHA1CKDF ? (KeyAgreementSpi.DHwithSHA1CKDF) getproxyaddress : getproxyaddress != null ? new KeyAgreementSpi.DHwithSHA1CKDF(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null;
                this.init = dHwithSHA1CKDF;
                aSN1ObjectIdentifier = dHwithSHA1CKDF.cca_continue;
            }
            EncryptedJWT Cardinal2 = Payload.Cardinal(KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(aSN1ObjectIdentifier));
            getSDKAppID getsdkappid = Cardinal2.init;
            Cardinal2.getInstance();
            EllipticCurve instance = EC5Util.getInstance(getsdkappid);
            this.Cardinal = new DigestSignatureSpi(getsdkappid.configure(bArr), ECUtil.getInstance((NHKeyFactorySpi) null, Cardinal2));
            this.getInstance = new Base64URL(KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(aSN1ObjectIdentifier), instance, EC5Util.init(Cardinal2.Cardinal), Cardinal2.getInstance, Cardinal2.cca_continue);
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    public byte[] getEncoded() {
        getProxyAddress getproxyaddress;
        getProxyAddress init2 = init();
        if (init2 == null) {
            ECParameterSpec eCParameterSpec = this.getInstance;
            if (eCParameterSpec instanceof Base64URL) {
                getproxyaddress = new KeyAgreementSpi.DHwithSHA1CKDF(KeyAgreementSpi.DHwithRFC2631KDF.configure(((Base64URL) eCParameterSpec).getInstance), KeyAgreementSpi.DHUwithSHA512CKDF.CardinalError);
            } else {
                getSDKAppID Cardinal2 = EC5Util.Cardinal(eCParameterSpec.getCurve());
                getproxyaddress = new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo(new KeyAgreementSpi.C1970DH(Cardinal2, EC5Util.init(Cardinal2, this.getInstance.getGenerator()), this.getInstance.getOrder(), BigInteger.valueOf((long) this.getInstance.getCofactor()), this.getInstance.getCurve().getSeed()));
            }
            init2 = getproxyaddress;
        }
        BigInteger Cardinal3 = this.Cardinal.cca_continue.getSDKVersion().Cardinal();
        ChallengeParameters challengeParameters = this.Cardinal.cca_continue;
        if (challengeParameters.CardinalEnvironment()) {
            BigInteger Cardinal4 = challengeParameters.CardinalError().Cardinal();
            byte[] bArr = new byte[64];
            Cardinal(bArr, 0, Cardinal3);
            Cardinal(bArr, 32, Cardinal4);
            try {
                return KeyUtil.configure(new SubjectPublicKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.DHUwithSHA512CKDF.getSDKVersion, init2), (getProxyAddress) new EdEC(bArr)));
            } catch (IOException unused) {
                return null;
            }
        } else {
            throw new IllegalStateException("point not in normal form");
        }
    }

    public ECPoint getW() {
        return EC5Util.init(this.Cardinal.cca_continue);
    }

    public final ChallengeParameters configure() {
        return this.getInstance == null ? this.Cardinal.cca_continue.init() : this.Cardinal.cca_continue;
    }

    public String toString() {
        String str = this.configure;
        ChallengeParameters challengeParameters = this.Cardinal.cca_continue;
        ECParameterSpec eCParameterSpec = this.getInstance;
        return ECUtil.configure(str, challengeParameters, eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410PublicKey)) {
            return false;
        }
        BCECGOST3410PublicKey bCECGOST3410PublicKey = (BCECGOST3410PublicKey) obj;
        if (this.Cardinal.cca_continue.init(bCECGOST3410PublicKey.Cardinal.cca_continue)) {
            ECParameterSpec eCParameterSpec = this.getInstance;
            Container cca_continue = eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue();
            ECParameterSpec eCParameterSpec2 = bCECGOST3410PublicKey.getInstance;
            if (cca_continue.equals(eCParameterSpec2 != null ? EC5Util.cca_continue(eCParameterSpec2) : JWK.getInstance.cca_continue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.Cardinal.cca_continue.hashCode();
        ECParameterSpec eCParameterSpec = this.getInstance;
        return hashCode ^ (eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue()).hashCode();
    }

    /* access modifiers changed from: package-private */
    public final getProxyAddress init() {
        if (this.init == null) {
            ECParameterSpec eCParameterSpec = this.getInstance;
            if (eCParameterSpec instanceof Base64URL) {
                this.init = new KeyAgreementSpi.DHwithSHA1CKDF(KeyAgreementSpi.DHwithRFC2631KDF.configure(((Base64URL) eCParameterSpec).getInstance), KeyAgreementSpi.DHUwithSHA512CKDF.CardinalError);
            }
        }
        return this.init;
    }
}
