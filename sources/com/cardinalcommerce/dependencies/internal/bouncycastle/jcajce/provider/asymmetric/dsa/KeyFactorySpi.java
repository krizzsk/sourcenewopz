package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import com.cardinalcommerce.p060a.AlgorithmParametersSpi;
import com.cardinalcommerce.p060a.BCGOST3410PrivateKey;
import com.cardinalcommerce.p060a.BCGOST3410PublicKey;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.EC5Util;
import com.cardinalcommerce.p060a.getErrorCode;
import com.cardinalcommerce.p060a.setErrorMessage;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(DSAPublicKeySpec.class) && (key instanceof DSAPublicKey)) {
            DSAPublicKey dSAPublicKey = (DSAPublicKey) key;
            return new DSAPublicKeySpec(dSAPublicKey.getY(), dSAPublicKey.getParams().getP(), dSAPublicKey.getParams().getQ(), dSAPublicKey.getParams().getG());
        } else if (cls.isAssignableFrom(DSAPrivateKeySpec.class) && (key instanceof DSAPrivateKey)) {
            DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) key;
            return new DSAPrivateKeySpec(dSAPrivateKey.getX(), dSAPrivateKey.getParams().getP(), dSAPrivateKey.getParams().getQ(), dSAPrivateKey.getParams().getG());
        } else if (cls.isAssignableFrom(setErrorMessage.class) && (key instanceof DSAPublicKey)) {
            DSAPublicKey dSAPublicKey2 = (DSAPublicKey) key;
            try {
                return new setErrorMessage(DSASigner.dsaSha3_384.configure((setKeyboardNavigationCluster) new BCGOST3410PrivateKey(dSAPublicKey2.getY(), new BCGOST3410PublicKey(dSAPublicKey2.getParams().getP(), dSAPublicKey2.getParams().getQ(), dSAPublicKey2.getParams().getG()))));
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder("unable to produce encoding: ");
                sb.append(e.getMessage());
                throw new IllegalArgumentException(sb.toString());
            }
        } else if (!cls.isAssignableFrom(getErrorCode.class) || !(key instanceof DSAPrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            DSAPrivateKey dSAPrivateKey2 = (DSAPrivateKey) key;
            try {
                return new getErrorCode(EC5Util.Cardinal((setKeyboardNavigationCluster) new AlgorithmParametersSpi.PSS(dSAPrivateKey2.getX(), new BCGOST3410PublicKey(dSAPrivateKey2.getParams().getP(), dSAPrivateKey2.getParams().getQ(), dSAPrivateKey2.getParams().getG()))));
            } catch (IOException e2) {
                StringBuilder sb2 = new StringBuilder("unable to produce encoding: ");
                sb2.append(e2.getMessage());
                throw new IllegalArgumentException(sb2.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof DSAPublicKey) {
            return new BCDSAPublicKey((DSAPublicKey) key);
        }
        if (key instanceof DSAPrivateKey) {
            return new BCDSAPrivateKey((DSAPrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }

    public final PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.cca_continue.init;
        if (DSAUtil.Cardinal(aSN1ObjectIdentifier)) {
            return new BCDSAPrivateKey(privateKeyInfo);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }

    public final PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.init.init;
        if (DSAUtil.Cardinal(aSN1ObjectIdentifier)) {
            return new BCDSAPublicKey(subjectPublicKeyInfo);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }

    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof DSAPrivateKeySpec) {
            return new BCDSAPrivateKey((DSAPrivateKeySpec) keySpec);
        }
        if (!(keySpec instanceof getErrorCode)) {
            return super.engineGeneratePrivate(keySpec);
        }
        setKeyboardNavigationCluster Cardinal = EC5Util.Cardinal(((getErrorCode) keySpec).getEncoded());
        if (Cardinal instanceof AlgorithmParametersSpi.PSS) {
            AlgorithmParametersSpi.PSS pss = (AlgorithmParametersSpi.PSS) Cardinal;
            return engineGeneratePrivate(new DSAPrivateKeySpec(pss.init, pss.Cardinal.init, pss.Cardinal.getInstance, pss.Cardinal.cca_continue));
        }
        throw new IllegalArgumentException("openssh private key is not dsa privare key");
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof DSAPublicKeySpec) {
            try {
                return new BCDSAPublicKey((DSAPublicKeySpec) keySpec);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("invalid KeySpec: ");
                sb.append(e.getMessage());
                throw new InvalidKeySpecException(sb.toString()) {
                    public final Throwable getCause() {
                        return e;
                    }
                };
            }
        } else if (!(keySpec instanceof setErrorMessage)) {
            return super.engineGeneratePublic(keySpec);
        } else {
            setKeyboardNavigationCluster cca_continue = DSASigner.dsaSha3_384.cca_continue(((setErrorMessage) keySpec).getEncoded());
            if (cca_continue instanceof BCGOST3410PrivateKey) {
                BCGOST3410PrivateKey bCGOST3410PrivateKey = (BCGOST3410PrivateKey) cca_continue;
                return engineGeneratePublic(new DSAPublicKeySpec(bCGOST3410PrivateKey.cca_continue, bCGOST3410PrivateKey.Cardinal.init, bCGOST3410PrivateKey.Cardinal.getInstance, bCGOST3410PrivateKey.Cardinal.cca_continue));
            }
            throw new IllegalArgumentException("openssh public key is not dsa public key");
        }
    }
}
