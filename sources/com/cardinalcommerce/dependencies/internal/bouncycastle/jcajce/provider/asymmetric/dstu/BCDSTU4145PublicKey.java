package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.Base64URL;
import com.cardinalcommerce.p060a.ByteUtils;
import com.cardinalcommerce.p060a.ChallengeParameters;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ECDSAVerifier;
import com.cardinalcommerce.p060a.EdEC;
import com.cardinalcommerce.p060a.EncryptedJWT;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.NHKeyFactorySpi;
import com.cardinalcommerce.p060a.PrivateKeyInfo;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setProxyAddress;
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

public class BCDSTU4145PublicKey implements ECDSAVerifier, ECPublicKey {
    private transient DSASigner.dsa224 Cardinal;
    transient DigestSignatureSpi cca_continue;
    private transient ECParameterSpec getInstance;
    private String init = "DSTU4145";

    BCDSTU4145PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        cca_continue(subjectPublicKeyInfo);
    }

    public BCDSTU4145PublicKey(String str, DigestSignatureSpi digestSignatureSpi) {
        this.init = str;
        this.cca_continue = digestSignatureSpi;
        this.getInstance = null;
    }

    public BCDSTU4145PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.getInstance = params;
        this.cca_continue = new DigestSignatureSpi(EC5Util.configure(params, eCPublicKeySpec.getW()), EC5Util.Cardinal((NHKeyFactorySpi) null, this.getInstance));
    }

    private static void cca_continue(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - 1) - i];
            bArr[(bArr.length - 1) - i] = b;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        cca_continue(SubjectPublicKeyInfo.init(setLocationDataConsentGiven.getInstance((byte[]) objectInputStream.readObject())));
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
        return this.init;
    }

    public String getFormat() {
        return "X.509";
    }

    public ECParameterSpec getParams() {
        return this.getInstance;
    }

    public final byte[] init() {
        DSASigner.dsa224 dsa224 = this.Cardinal;
        return dsa224 != null ? dsa224.Cardinal() : DSASigner.dsa224.cca_continue();
    }

    public BCDSTU4145PublicKey(ByteUtils byteUtils, NHKeyFactorySpi nHKeyFactorySpi) {
        if (byteUtils.cca_continue != null) {
            getSDKAppID getsdkappid = byteUtils.cca_continue.init;
            byteUtils.cca_continue.getInstance();
            EllipticCurve instance = EC5Util.getInstance(getsdkappid);
            this.cca_continue = new DigestSignatureSpi(byteUtils.Cardinal, ECUtil.getInstance(nHKeyFactorySpi, byteUtils.cca_continue));
            this.getInstance = EC5Util.Cardinal(instance, byteUtils.cca_continue);
            return;
        }
        getSDKAppID getsdkappid2 = nHKeyFactorySpi.cca_continue().init;
        BigInteger Cardinal2 = byteUtils.Cardinal.getSDKVersion().Cardinal();
        ChallengeParameters challengeParameters = byteUtils.Cardinal;
        if (challengeParameters.CardinalEnvironment()) {
            this.cca_continue = new DigestSignatureSpi(getsdkappid2.Cardinal(Cardinal2, challengeParameters.CardinalError().Cardinal(), false), EC5Util.Cardinal(nHKeyFactorySpi, (ECParameterSpec) null));
            this.getInstance = null;
            return;
        }
        throw new IllegalStateException("point not in normal form");
    }

    public BCDSTU4145PublicKey(String str, DigestSignatureSpi digestSignatureSpi, ECParameterSpec eCParameterSpec) {
        BCRSAPublicKey bCRSAPublicKey = digestSignatureSpi.init;
        this.init = str;
        this.cca_continue = digestSignatureSpi;
        if (eCParameterSpec == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.getInstance = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
            return;
        }
        this.getInstance = eCParameterSpec;
    }

    public BCDSTU4145PublicKey(String str, DigestSignatureSpi digestSignatureSpi, Container container) {
        BCRSAPublicKey bCRSAPublicKey = digestSignatureSpi.init;
        this.init = str;
        if (container == null) {
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            bCRSAPublicKey.init();
            this.getInstance = new ECParameterSpec(EC5Util.getInstance(getsdkappid), EC5Util.init(bCRSAPublicKey.init), bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance.intValue());
        } else {
            getSDKAppID getsdkappid2 = container.init;
            container.getInstance();
            this.getInstance = EC5Util.Cardinal(EC5Util.getInstance(getsdkappid2), container);
        }
        this.cca_continue = digestSignatureSpi;
    }

    private void cca_continue(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        KeyAgreementSpi.C1970DH dh;
        Container container;
        ECParameterSpec eCParameterSpec;
        PrivateKeyInfo privateKeyInfo = subjectPublicKeyInfo.getInstance;
        this.init = "DSTU4145";
        try {
            byte[] cca_continue2 = ((isEnableDFSync) setLocationDataConsentGiven.getInstance(privateKeyInfo.getInstance())).cca_continue();
            if (subjectPublicKeyInfo.init.init.equals(DSASigner.dsaSha3_512.configure)) {
                cca_continue(cca_continue2);
            }
            setThreeDSRequestorAppURL cca_continue3 = setThreeDSRequestorAppURL.cca_continue((Object) subjectPublicKeyInfo.init.cca_continue);
            if (cca_continue3.Cardinal(0) instanceof setProxyAddress) {
                dh = KeyAgreementSpi.C1970DH.configure(cca_continue3);
                container = new Container(dh.cca_continue, dh.getInstance.cca_continue(), dh.Cardinal, dh.init, dh.init());
            } else {
                DSASigner.dsa224 configure = DSASigner.dsa224.configure(cca_continue3);
                this.Cardinal = configure;
                if (configure.configure()) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = this.Cardinal.Cardinal;
                    BCRSAPublicKey init2 = DSASigner.detDSASha3_512.init(aSN1ObjectIdentifier);
                    container = new EncryptedJWT(aSN1ObjectIdentifier.init, init2.Cardinal, init2.init, init2.cca_continue, init2.getInstance, init2.init());
                } else {
                    DSASigner.dsa384 dsa384 = this.Cardinal.getInstance;
                    byte[] init3 = dsa384.init();
                    if (subjectPublicKeyInfo.init.init.equals(DSASigner.dsaSha3_512.configure)) {
                        cca_continue(init3);
                    }
                    DSASigner.detDSASha3_384 detdsasha3_384 = dsa384.Cardinal;
                    getSDKAppID.cca_continue cca_continue4 = new getSDKAppID.cca_continue(detdsasha3_384.getInstance, detdsasha3_384.cca_continue, detdsasha3_384.configure, detdsasha3_384.init, new BigInteger(dsa384.cca_continue.Cardinal), new BigInteger(1, init3));
                    byte[] cca_continue5 = dsa384.cca_continue();
                    if (subjectPublicKeyInfo.init.init.equals(DSASigner.dsaSha3_512.configure)) {
                        cca_continue(cca_continue5);
                    }
                    container = new Container(cca_continue4, DSASigner.dsa256.cca_continue((getSDKAppID) cca_continue4, cca_continue5), new BigInteger(dsa384.init.Cardinal));
                }
                dh = null;
            }
            getSDKAppID getsdkappid = container.init;
            container.getInstance();
            EllipticCurve instance = EC5Util.getInstance(getsdkappid);
            DSASigner.dsa224 dsa224 = this.Cardinal;
            if (dsa224 == null) {
                eCParameterSpec = EC5Util.cca_continue(dh);
            } else if (dsa224.configure()) {
                this.getInstance = new Base64URL(this.Cardinal.Cardinal.init, instance, EC5Util.init(container.Cardinal), container.getInstance, container.cca_continue);
                this.cca_continue = new DigestSignatureSpi(DSASigner.dsa256.cca_continue(getsdkappid, cca_continue2), EC5Util.Cardinal((NHKeyFactorySpi) null, this.getInstance));
            } else {
                eCParameterSpec = new ECParameterSpec(instance, EC5Util.init(container.Cardinal), container.getInstance, container.cca_continue.intValue());
            }
            this.getInstance = eCParameterSpec;
            this.cca_continue = new DigestSignatureSpi(DSASigner.dsa256.cca_continue(getsdkappid, cca_continue2), EC5Util.Cardinal((NHKeyFactorySpi) null, this.getInstance));
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    public byte[] getEncoded() {
        getProxyAddress getproxyaddress;
        getProxyAddress getproxyaddress2 = this.Cardinal;
        if (getproxyaddress2 == null) {
            ECParameterSpec eCParameterSpec = this.getInstance;
            if (eCParameterSpec instanceof Base64URL) {
                getproxyaddress = new DSASigner.dsa224(new ASN1ObjectIdentifier(((Base64URL) eCParameterSpec).getInstance));
            } else {
                getSDKAppID Cardinal2 = EC5Util.Cardinal(eCParameterSpec.getCurve());
                getproxyaddress = new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo(new KeyAgreementSpi.C1970DH(Cardinal2, EC5Util.init(Cardinal2, this.getInstance.getGenerator()), this.getInstance.getOrder(), BigInteger.valueOf((long) this.getInstance.getCofactor()), this.getInstance.getCurve().getSeed()));
            }
            getproxyaddress2 = getproxyaddress;
        }
        try {
            return KeyUtil.configure(new SubjectPublicKeyInfo(new DSASigner.stdDSA(DSASigner.dsaSha3_512.cca_continue, getproxyaddress2), (getProxyAddress) new EdEC(DSASigner.dsa256.init(this.cca_continue.cca_continue))));
        } catch (IOException unused) {
            return null;
        }
    }

    public ECPoint getW() {
        return EC5Util.init(this.cca_continue.cca_continue);
    }

    public final ChallengeParameters configure() {
        ChallengeParameters challengeParameters = this.cca_continue.cca_continue;
        return this.getInstance == null ? challengeParameters.init() : challengeParameters;
    }

    public String toString() {
        String str = this.init;
        ChallengeParameters challengeParameters = this.cca_continue.cca_continue;
        ECParameterSpec eCParameterSpec = this.getInstance;
        return ECUtil.configure(str, challengeParameters, eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PublicKey)) {
            return false;
        }
        BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) obj;
        if (this.cca_continue.cca_continue.init(bCDSTU4145PublicKey.cca_continue.cca_continue)) {
            ECParameterSpec eCParameterSpec = this.getInstance;
            Container cca_continue2 = eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue();
            ECParameterSpec eCParameterSpec2 = bCDSTU4145PublicKey.getInstance;
            if (cca_continue2.equals(eCParameterSpec2 != null ? EC5Util.cca_continue(eCParameterSpec2) : JWK.getInstance.cca_continue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.cca_continue.cca_continue.hashCode();
        ECParameterSpec eCParameterSpec = this.getInstance;
        return hashCode ^ (eCParameterSpec != null ? EC5Util.cca_continue(eCParameterSpec) : JWK.getInstance.cca_continue()).hashCode();
    }
}
