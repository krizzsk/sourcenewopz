package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.ByteUtils;
import com.cardinalcommerce.p060a.ChallengeParameters;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.NHKeyFactorySpi;
import com.cardinalcommerce.p060a.X509CertUtils;
import com.cardinalcommerce.p060a.getErrorCode;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.cardinalcommerce.p060a.setErrorMessage;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi */
public class KeyFactorySpi extends BaseKeyFactorySpi implements AsymmetricKeyInfoConverter {
    private NHKeyFactorySpi configure;
    private String getInstance;

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$EC */
    public static class C2148EC extends KeyFactorySpi {
        public C2148EC() {
            super("EC", JWK.getInstance);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDH */
    public static class ECDH extends KeyFactorySpi {
        public ECDH() {
            super("ECDH", JWK.getInstance);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDHC */
    public static class ECDHC extends KeyFactorySpi {
        public ECDHC() {
            super("ECDHC", JWK.getInstance);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDSA */
    public static class ECDSA extends KeyFactorySpi {
        public ECDSA() {
            super("ECDSA", JWK.getInstance);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECGOST3410 */
    public static class ECGOST3410 extends KeyFactorySpi {
        public ECGOST3410() {
            super("ECGOST3410", JWK.getInstance);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECGOST3410_2012 */
    public static class ECGOST3410_2012 extends KeyFactorySpi {
        public ECGOST3410_2012() {
            super("ECGOST3410-2012", JWK.getInstance);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECMQV */
    public static class ECMQV extends KeyFactorySpi {
        public ECMQV() {
            super("ECMQV", JWK.getInstance);
        }
    }

    KeyFactorySpi(String str, NHKeyFactorySpi nHKeyFactorySpi) {
        this.getInstance = str;
        this.configure = nHKeyFactorySpi;
    }

    /* access modifiers changed from: protected */
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof ECPublicKey) {
            return new BCECPublicKey((ECPublicKey) key, this.configure);
        }
        if (key instanceof ECPrivateKey) {
            return new BCECPrivateKey((ECPrivateKey) key, this.configure);
        }
        throw new InvalidKeyException("key type unknown");
    }

    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(ECPublicKeySpec.class) && (key instanceof ECPublicKey)) {
            ECPublicKey eCPublicKey = (ECPublicKey) key;
            if (eCPublicKey.getParams() != null) {
                return new ECPublicKeySpec(eCPublicKey.getW(), eCPublicKey.getParams());
            }
            Container cca_continue = JWK.getInstance.cca_continue();
            ECPoint w = eCPublicKey.getW();
            getSDKAppID getsdkappid = cca_continue.init;
            cca_continue.getInstance();
            return new ECPublicKeySpec(w, EC5Util.Cardinal(EC5Util.getInstance(getsdkappid), cca_continue));
        } else if (cls.isAssignableFrom(ECPrivateKeySpec.class) && (key instanceof ECPrivateKey)) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) key;
            if (eCPrivateKey.getParams() != null) {
                return new ECPrivateKeySpec(eCPrivateKey.getS(), eCPrivateKey.getParams());
            }
            Container cca_continue2 = JWK.getInstance.cca_continue();
            BigInteger s = eCPrivateKey.getS();
            getSDKAppID getsdkappid2 = cca_continue2.init;
            cca_continue2.getInstance();
            return new ECPrivateKeySpec(s, EC5Util.Cardinal(EC5Util.getInstance(getsdkappid2), cca_continue2));
        } else if (cls.isAssignableFrom(ByteUtils.class) && (key instanceof ECPublicKey)) {
            ECPublicKey eCPublicKey2 = (ECPublicKey) key;
            if (eCPublicKey2.getParams() != null) {
                return new ByteUtils(EC5Util.configure(eCPublicKey2.getParams(), eCPublicKey2.getW()), EC5Util.cca_continue(eCPublicKey2.getParams()));
            }
            return new ByteUtils(EC5Util.configure(eCPublicKey2.getParams(), eCPublicKey2.getW()), JWK.getInstance.cca_continue());
        } else if (cls.isAssignableFrom(X509CertUtils.class) && (key instanceof ECPrivateKey)) {
            ECPrivateKey eCPrivateKey2 = (ECPrivateKey) key;
            if (eCPrivateKey2.getParams() != null) {
                return new X509CertUtils(eCPrivateKey2.getS(), EC5Util.cca_continue(eCPrivateKey2.getParams()));
            }
            return new X509CertUtils(eCPrivateKey2.getS(), JWK.getInstance.cca_continue());
        } else if (!cls.isAssignableFrom(setErrorMessage.class) || !(key instanceof ECPublicKey)) {
            if (!cls.isAssignableFrom(getErrorCode.class) || !(key instanceof ECPrivateKey)) {
                return super.engineGetKeySpec(key, cls);
            }
            if (key instanceof BCECPrivateKey) {
                try {
                    return new getErrorCode(setLocationDataConsentGiven.getInstance(PrivateKeyInfo.init(key.getEncoded()).init.cca_continue()).values().getEncoded());
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder("cannot encoded key: ");
                    sb.append(e.getMessage());
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                StringBuilder sb2 = new StringBuilder("invalid key type: ");
                sb2.append(key.getClass().getName());
                throw new IllegalArgumentException(sb2.toString());
            }
        } else if (key instanceof BCECPublicKey) {
            BCECPublicKey bCECPublicKey = (BCECPublicKey) key;
            Container cca_continue3 = bCECPublicKey.Cardinal == null ? null : EC5Util.cca_continue(bCECPublicKey.Cardinal);
            try {
                ChallengeParameters challengeParameters = bCECPublicKey.configure.cca_continue;
                if (bCECPublicKey.Cardinal == null) {
                    challengeParameters = challengeParameters.init();
                }
                return new setErrorMessage(DSASigner.dsaSha3_384.configure((setKeyboardNavigationCluster) new DigestSignatureSpi(challengeParameters, new BCRSAPublicKey(cca_continue3.init, cca_continue3.Cardinal, cca_continue3.getInstance, cca_continue3.cca_continue, cca_continue3.getInstance()))));
            } catch (IOException e2) {
                StringBuilder sb3 = new StringBuilder("unable to produce encoding: ");
                sb3.append(e2.getMessage());
                throw new IllegalArgumentException(sb3.toString());
            }
        } else {
            StringBuilder sb4 = new StringBuilder("invalid key type: ");
            sb4.append(key.getClass().getName());
            throw new IllegalArgumentException(sb4.toString());
        }
    }

    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509CertUtils) {
            return new BCECPrivateKey(this.getInstance, (X509CertUtils) keySpec, this.configure);
        }
        if (keySpec instanceof ECPrivateKeySpec) {
            return new BCECPrivateKey(this.getInstance, (ECPrivateKeySpec) keySpec, this.configure);
        }
        if (!(keySpec instanceof getErrorCode)) {
            return super.engineGeneratePrivate(keySpec);
        }
        byte[] encoded = ((getErrorCode) keySpec).getEncoded();
        DSASigner.detDSASha3_256 detdsasha3_256 = encoded != null ? new DSASigner.detDSASha3_256(setThreeDSRequestorAppURL.cca_continue((Object) encoded)) : null;
        try {
            return new BCECPrivateKey(this.getInstance, new PrivateKeyInfo(new DSASigner.stdDSA(KeyAgreementSpi.ECKAEGwithSHA1KDF.CardinalUiType, detdsasha3_256.init()), detdsasha3_256), this.configure);
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder("bad encoding: ");
            sb.append(e.getMessage());
            throw new InvalidKeySpecException(sb.toString());
        }
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        try {
            if (keySpec instanceof ByteUtils) {
                return new BCECPublicKey(this.getInstance, (ByteUtils) keySpec, this.configure);
            }
            if (keySpec instanceof ECPublicKeySpec) {
                return new BCECPublicKey(this.getInstance, (ECPublicKeySpec) keySpec, this.configure);
            }
            if (!(keySpec instanceof setErrorMessage)) {
                return super.engineGeneratePublic(keySpec);
            }
            setKeyboardNavigationCluster cca_continue = DSASigner.dsaSha3_384.cca_continue(((setErrorMessage) keySpec).getEncoded());
            if (cca_continue instanceof DigestSignatureSpi) {
                BCRSAPublicKey bCRSAPublicKey = ((DigestSignatureSpi) cca_continue).init;
                return engineGeneratePublic(new ByteUtils(((DigestSignatureSpi) cca_continue).cca_continue, new Container(bCRSAPublicKey.Cardinal, bCRSAPublicKey.init, bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance, bCRSAPublicKey.init())));
            }
            throw new IllegalArgumentException("openssh key is not ec public key");
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("invalid KeySpec: ");
            sb.append(e.getMessage());
            throw new InvalidKeySpecException(sb.toString(), e);
        }
    }

    public final PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.cca_continue.init;
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.ECKAEGwithSHA1KDF.CardinalUiType)) {
            return new BCECPrivateKey(this.getInstance, privateKeyInfo, this.configure);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }

    public final PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.init.init;
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.ECKAEGwithSHA1KDF.CardinalUiType)) {
            return new BCECPublicKey(this.getInstance, subjectPublicKeyInfo, this.configure);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }
}
