package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12;

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

public class BCECGOST3410_2012PublicKey implements ECDSAVerifier, ECPublicKey {
    private transient ECParameterSpec Cardinal;
    private String configure = "ECGOST3410-2012";
    private transient KeyAgreementSpi.DHwithSHA1CKDF getInstance;
    transient DigestSignatureSpi init;

    BCECGOST3410_2012PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        Cardinal(subjectPublicKeyInfo);
    }

    public BCECGOST3410_2012PublicKey(String str, DigestSignatureSpi digestSignatureSpi) {
        this.configure = str;
        this.init = digestSignatureSpi;
        this.Cardinal = null;
    }

    public BCECGOST3410_2012PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.Cardinal = params;
        this.init = new DigestSignatureSpi(EC5Util.configure(params, eCPublicKeySpec.getW()), EC5Util.Cardinal((NHKeyFactorySpi) null, eCPublicKeySpec.getParams()));
    }

    private static void configure(byte[] bArr, int i, int i2, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i3 = 0; i3 != i; i3++) {
            bArr[i2 + i3] = byteArray[(byteArray.length - 1) - i3];
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Cardinal(SubjectPublicKeyInfo.init(setLocationDataConsentGiven.getInstance((byte[]) objectInputStream.readObject())));
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
        return this.configure;
    }

    public String getFormat() {
        return "X.509";
    }

    public ECParameterSpec getParams() {
        return this.Cardinal;
    }

    public BCECGOST3410_2012PublicKey(ByteUtils byteUtils, NHKeyFactorySpi nHKeyFactorySpi) {
        if (byteUtils.cca_continue != null) {
            getSDKAppID getsdkappid = byteUtils.cca_continue.init;
            byteUtils.cca_continue.getInstance();
            EllipticCurve instance = EC5Util.getInstance(getsdkappid);
            this.init = new DigestSignatureSpi(byteUtils.Cardinal, ECUtil.getInstance(nHKeyFactorySpi, byteUtils.cca_continue));
            this.Cardinal = EC5Util.Cardinal(instance, byteUtils.cca_continue);
            return;
        }
        getSDKAppID getsdkappid2 = nHKeyFactorySpi.cca_continue().init;
        BigInteger Cardinal2 = byteUtils.Cardinal.getSDKVersion().Cardinal();
        ChallengeParameters challengeParameters = byteUtils.Cardinal;
        if (challengeParameters.CardinalEnvironment()) {
            this.init = new DigestSignatureSpi(getsdkappid2.Cardinal(Cardinal2, challengeParameters.CardinalError().Cardinal(), false), EC5Util.Cardinal(nHKeyFactorySpi, (ECParameterSpec) null));
            this.Cardinal = null;
            return;
        }
        throw new IllegalStateException("point not in normal form");
    }

    public BCECGOST3410_2012PublicKey(String str, DigestSignatureSpi digestSignatureSpi, ECParameterSpec eCParameterSpec) {
        BCRSAPublicKey bCRSAPublicKey = digestSignatureSpi.init;
        this.configure = str;
        this.init = digestSignatureSpi;
        if (bCRSAPublicKey instanceof CipherSpi.ISO9796d1Padding) {
            CipherSpi.ISO9796d1Padding iSO9796d1Padding = (CipherSpi.ISO9796d1Padding) bCRSAPublicKey;
            this.getInstance = new KeyAgreementSpi.DHwithSHA1CKDF(iSO9796d1Padding.configure, iSO9796d1Padding.getWarnings, iSO9796d1Padding.cleanup);
        }
        if (eCParameterSpec == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
            return;
        }
        this.Cardinal = eCParameterSpec;
    }

    public BCECGOST3410_2012PublicKey(String str, DigestSignatureSpi digestSignatureSpi, Container container) {
        BCRSAPublicKey bCRSAPublicKey = digestSignatureSpi.init;
        this.configure = str;
        this.init = digestSignatureSpi;
        if (container == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.Cardinal = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
            return;
        }
        getSDKAppID getsdkappid2 = container.init;
        container.getInstance();
        this.Cardinal = EC5Util.Cardinal(EC5Util.getInstance(getsdkappid2), container);
    }

    private void Cardinal(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.init.init;
        PrivateKeyInfo privateKeyInfo = subjectPublicKeyInfo.getInstance;
        this.configure = "ECGOST3410-2012";
        try {
            byte[] cca_continue = ((isEnableDFSync) setLocationDataConsentGiven.getInstance(privateKeyInfo.getInstance())).cca_continue();
            int i = 32;
            if (aSN1ObjectIdentifier.equals(DSASigner.detDSA224.Cardinal)) {
                i = 64;
            }
            int i2 = i * 2;
            byte[] bArr = new byte[(i2 + 1)];
            bArr[0] = 4;
            for (int i3 = 1; i3 <= i; i3++) {
                bArr[i3] = cca_continue[i - i3];
                bArr[i3 + i] = cca_continue[i2 - i3];
            }
            getProxyAddress getproxyaddress = subjectPublicKeyInfo.init.cca_continue;
            KeyAgreementSpi.DHwithSHA1CKDF dHwithSHA1CKDF = getproxyaddress instanceof KeyAgreementSpi.DHwithSHA1CKDF ? (KeyAgreementSpi.DHwithSHA1CKDF) getproxyaddress : getproxyaddress != null ? new KeyAgreementSpi.DHwithSHA1CKDF(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null;
            this.getInstance = dHwithSHA1CKDF;
            EncryptedJWT Cardinal2 = Payload.Cardinal(KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(dHwithSHA1CKDF.cca_continue));
            getSDKAppID getsdkappid = Cardinal2.init;
            Cardinal2.getInstance();
            EllipticCurve instance = EC5Util.getInstance(getsdkappid);
            this.init = new DigestSignatureSpi(getsdkappid.configure(bArr), ECUtil.getInstance((NHKeyFactorySpi) null, Cardinal2));
            this.Cardinal = new Base64URL(KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(this.getInstance.cca_continue), instance, EC5Util.init(Cardinal2.Cardinal), Cardinal2.getInstance, Cardinal2.cca_continue);
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    public byte[] getEncoded() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        int i;
        getProxyAddress getproxyaddress;
        BigInteger Cardinal2 = this.init.cca_continue.getSDKVersion().Cardinal();
        ChallengeParameters challengeParameters = this.init.cca_continue;
        if (challengeParameters.CardinalEnvironment()) {
            BigInteger Cardinal3 = challengeParameters.CardinalError().Cardinal();
            boolean z = Cardinal2.bitLength() > 256;
            getProxyAddress instance = getInstance();
            if (instance == null) {
                ECParameterSpec eCParameterSpec = this.Cardinal;
                if (eCParameterSpec instanceof Base64URL) {
                    getproxyaddress = z ? new KeyAgreementSpi.DHwithSHA1CKDF(KeyAgreementSpi.DHwithRFC2631KDF.configure(((Base64URL) eCParameterSpec).getInstance), DSASigner.detDSA224.cca_continue) : new KeyAgreementSpi.DHwithSHA1CKDF(KeyAgreementSpi.DHwithRFC2631KDF.configure(((Base64URL) eCParameterSpec).getInstance), DSASigner.detDSA224.configure);
                } else {
                    getSDKAppID Cardinal4 = EC5Util.Cardinal(eCParameterSpec.getCurve());
                    getproxyaddress = new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo(new KeyAgreementSpi.C1970DH(Cardinal4, EC5Util.init(Cardinal4, this.Cardinal.getGenerator()), this.Cardinal.getOrder(), BigInteger.valueOf((long) this.Cardinal.getCofactor()), this.Cardinal.getCurve().getSeed()));
                }
                instance = getproxyaddress;
            }
            int i2 = 64;
            if (z) {
                aSN1ObjectIdentifier = DSASigner.detDSA224.Cardinal;
                i = 64;
                i2 = 128;
            } else {
                i = 32;
                aSN1ObjectIdentifier = DSASigner.detDSA224.init;
            }
            byte[] bArr = new byte[i2];
            int i3 = i2 / 2;
            configure(bArr, i3, 0, Cardinal2);
            configure(bArr, i3, i, Cardinal3);
            try {
                return KeyUtil.configure(new SubjectPublicKeyInfo(new DSASigner.stdDSA(aSN1ObjectIdentifier, instance), (getProxyAddress) new EdEC(bArr)));
            } catch (IOException unused) {
                return null;
            }
        } else {
            throw new IllegalStateException("point not in normal form");
        }
    }

    public ECPoint getW() {
        return EC5Util.init(this.init.cca_continue);
    }

    public final ChallengeParameters configure() {
        return this.Cardinal == null ? this.init.cca_continue.init() : this.init.cca_continue;
    }

    public String toString() {
        String str = this.configure;
        ChallengeParameters challengeParameters = this.init.cca_continue;
        ECParameterSpec eCParameterSpec = this.Cardinal;
        return ECUtil.configure(str, challengeParameters, eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410_2012PublicKey)) {
            return false;
        }
        BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey = (BCECGOST3410_2012PublicKey) obj;
        if (this.init.cca_continue.init(bCECGOST3410_2012PublicKey.init.cca_continue)) {
            ECParameterSpec eCParameterSpec = this.Cardinal;
            Container cca_continue = eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue();
            ECParameterSpec eCParameterSpec2 = bCECGOST3410_2012PublicKey.Cardinal;
            if (cca_continue.equals(eCParameterSpec2 != null ? EC5Util.cca_continue(eCParameterSpec2) : JWK.getInstance.cca_continue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.init.cca_continue.hashCode();
        ECParameterSpec eCParameterSpec = this.Cardinal;
        return hashCode ^ (eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue()).hashCode();
    }

    public final KeyAgreementSpi.DHwithSHA1CKDF getInstance() {
        if (this.getInstance == null && (this.Cardinal instanceof Base64URL)) {
            if (this.init.cca_continue.getSDKVersion().Cardinal().bitLength() > 256) {
                this.getInstance = new KeyAgreementSpi.DHwithSHA1CKDF(KeyAgreementSpi.DHwithRFC2631KDF.configure(((Base64URL) this.Cardinal).getInstance), DSASigner.detDSA224.cca_continue);
            } else {
                this.getInstance = new KeyAgreementSpi.DHwithSHA1CKDF(KeyAgreementSpi.DHwithRFC2631KDF.configure(((Base64URL) this.Cardinal).getInstance), DSASigner.detDSA224.configure);
            }
        }
        return this.getInstance;
    }
}
