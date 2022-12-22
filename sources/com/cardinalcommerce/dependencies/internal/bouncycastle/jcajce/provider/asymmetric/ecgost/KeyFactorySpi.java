package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.p060a.ByteUtils;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.X509CertUtils;
import com.cardinalcommerce.p060a.getSDKAppID;
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

public class KeyFactorySpi extends BaseKeyFactorySpi {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof X509CertUtils ? new BCECGOST3410PrivateKey((X509CertUtils) keySpec) : keySpec instanceof ECPrivateKeySpec ? new BCECGOST3410PrivateKey((ECPrivateKeySpec) keySpec) : super.engineGeneratePrivate(keySpec);
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof ByteUtils ? new BCECGOST3410PublicKey((ByteUtils) keySpec, JWK.getInstance) : keySpec instanceof ECPublicKeySpec ? new BCECGOST3410PublicKey((ECPublicKeySpec) keySpec) : super.engineGeneratePublic(keySpec);
    }

    /* access modifiers changed from: protected */
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
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
        } else if (!cls.isAssignableFrom(X509CertUtils.class) || !(key instanceof ECPrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            ECPrivateKey eCPrivateKey2 = (ECPrivateKey) key;
            if (eCPrivateKey2.getParams() != null) {
                return new X509CertUtils(eCPrivateKey2.getS(), EC5Util.cca_continue(eCPrivateKey2.getParams()));
            }
            return new X509CertUtils(eCPrivateKey2.getS(), JWK.getInstance.cca_continue());
        }
    }

    public final PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.cca_continue.init;
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHUwithSHA512CKDF.getSDKVersion)) {
            return new BCECGOST3410PrivateKey(privateKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHUwithSHA512CKDF.getRequestTimeout)) {
            return new BCECGOST3410PrivateKey(privateKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHUwithSHA512CKDF.setRequestTimeout)) {
            return new BCECGOST3410PrivateKey(privateKeyInfo);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }

    public final PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.init.init;
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHUwithSHA512CKDF.getSDKVersion)) {
            return new BCECGOST3410PublicKey(subjectPublicKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHUwithSHA512CKDF.getRequestTimeout)) {
            return new BCECGOST3410PublicKey(subjectPublicKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHUwithSHA512CKDF.setRequestTimeout)) {
            return new BCECGOST3410PublicKey(subjectPublicKeyInfo);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }
}
