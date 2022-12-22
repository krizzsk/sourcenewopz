package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ExtendedInvalidKeySpecException;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.EC5Util;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.cardinalcommerce.p060a.getErrorCode;
import com.cardinalcommerce.p060a.setErrorMessage;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof RSAPublicKeySpec) {
            return new BCRSAPublicKey((RSAPublicKeySpec) keySpec);
        }
        if (!(keySpec instanceof setErrorMessage)) {
            return super.engineGeneratePublic(keySpec);
        }
        setKeyboardNavigationCluster cca_continue = DSASigner.dsaSha3_384.cca_continue(((setErrorMessage) keySpec).getEncoded());
        if (cca_continue instanceof ISOSignatureSpi.WhirlpoolWithRSAEncryption) {
            return new BCRSAPublicKey((ISOSignatureSpi.WhirlpoolWithRSAEncryption) cca_continue);
        }
        throw new InvalidKeySpecException("Open SSH public key is not RSA public key");
    }

    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(RSAPublicKeySpec.class) && (key instanceof RSAPublicKey)) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) key;
            return new RSAPublicKeySpec(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        } else if (cls.isAssignableFrom(RSAPrivateKeySpec.class) && (key instanceof RSAPrivateKey)) {
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) key;
            return new RSAPrivateKeySpec(rSAPrivateKey.getModulus(), rSAPrivateKey.getPrivateExponent());
        } else if (cls.isAssignableFrom(RSAPrivateCrtKeySpec.class) && (key instanceof RSAPrivateCrtKey)) {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) key;
            return new RSAPrivateCrtKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient());
        } else if (cls.isAssignableFrom(setErrorMessage.class) && (key instanceof RSAPublicKey)) {
            try {
                return new setErrorMessage(DSASigner.dsaSha3_384.configure((setKeyboardNavigationCluster) new ISOSignatureSpi.WhirlpoolWithRSAEncryption(false, ((RSAPublicKey) key).getModulus(), ((RSAPublicKey) key).getPublicExponent())));
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder("unable to produce encoding: ");
                sb.append(e.getMessage());
                throw new IllegalArgumentException(sb.toString());
            }
        } else if (!cls.isAssignableFrom(getErrorCode.class) || !(key instanceof RSAPrivateCrtKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            try {
                return new getErrorCode(EC5Util.Cardinal((setKeyboardNavigationCluster) new PSSSignatureSpi.SHA224withRSA(((RSAPrivateCrtKey) key).getModulus(), ((RSAPrivateCrtKey) key).getPublicExponent(), ((RSAPrivateCrtKey) key).getPrivateExponent(), ((RSAPrivateCrtKey) key).getPrimeP(), ((RSAPrivateCrtKey) key).getPrimeQ(), ((RSAPrivateCrtKey) key).getPrimeExponentP(), ((RSAPrivateCrtKey) key).getPrimeExponentQ(), ((RSAPrivateCrtKey) key).getCrtCoefficient())));
            } catch (IOException e2) {
                StringBuilder sb2 = new StringBuilder("unable to produce encoding: ");
                sb2.append(e2.getMessage());
                throw new IllegalArgumentException(sb2.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof RSAPublicKey) {
            return new BCRSAPublicKey((RSAPublicKey) key);
        }
        if (key instanceof RSAPrivateCrtKey) {
            return new BCRSAPrivateCrtKey((RSAPrivateCrtKey) key);
        }
        if (key instanceof RSAPrivateKey) {
            return new BCRSAPrivateKey((RSAPrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }

    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return cca_continue(PrivateKeyInfo.init(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e) {
                try {
                    byte[] encoded = ((PKCS8EncodedKeySpec) keySpec).getEncoded();
                    return new BCRSAPrivateCrtKey(encoded != null ? new DSASigner(setThreeDSRequestorAppURL.cca_continue((Object) encoded)) : null);
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder("unable to process key spec: ");
                    sb.append(e.toString());
                    throw new ExtendedInvalidKeySpecException(sb.toString(), e);
                }
            }
        } else if (keySpec instanceof RSAPrivateCrtKeySpec) {
            return new BCRSAPrivateCrtKey((RSAPrivateCrtKeySpec) keySpec);
        } else {
            if (keySpec instanceof RSAPrivateKeySpec) {
                return new BCRSAPrivateKey((RSAPrivateKeySpec) keySpec);
            }
            if (keySpec instanceof getErrorCode) {
                setKeyboardNavigationCluster Cardinal = EC5Util.Cardinal(((getErrorCode) keySpec).getEncoded());
                if (Cardinal instanceof PSSSignatureSpi.SHA224withRSA) {
                    return new BCRSAPrivateCrtKey((PSSSignatureSpi.SHA224withRSA) Cardinal);
                }
                throw new InvalidKeySpecException("open SSH public key is not RSA private key");
            }
            StringBuilder sb2 = new StringBuilder("unknown KeySpec type: ");
            sb2.append(keySpec.getClass().getName());
            throw new InvalidKeySpecException(sb2.toString());
        }
    }

    public final PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.cca_continue.init;
        if (RSAUtil.configure(aSN1ObjectIdentifier)) {
            setLocationDataConsentGiven instance = setLocationDataConsentGiven.getInstance(privateKeyInfo.init.cca_continue());
            DSASigner dSASigner = instance != null ? new DSASigner(setThreeDSRequestorAppURL.cca_continue((Object) instance)) : null;
            return dSASigner.CardinalError.intValue() == 0 ? new BCRSAPrivateKey(dSASigner) : new BCRSAPrivateCrtKey(privateKeyInfo);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }

    public final PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.init.init;
        if (RSAUtil.configure(aSN1ObjectIdentifier)) {
            return new BCRSAPublicKey(subjectPublicKeyInfo);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }
}
