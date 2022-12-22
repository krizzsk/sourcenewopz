package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import com.cardinalcommerce.p060a.AESCBC;
import com.cardinalcommerce.p060a.CompletionEvent;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.RSASSAVerifier;
import com.cardinalcommerce.p060a.getSDKTransactionID;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof getSDKTransactionID ? new BCElGamalPrivateKey((getSDKTransactionID) keySpec) : keySpec instanceof DHPrivateKeySpec ? new BCElGamalPrivateKey((DHPrivateKeySpec) keySpec) : super.engineGeneratePrivate(keySpec);
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof CompletionEvent ? new BCElGamalPublicKey((CompletionEvent) keySpec) : keySpec instanceof DHPublicKeySpec ? new BCElGamalPublicKey((DHPublicKeySpec) keySpec) : super.engineGeneratePublic(keySpec);
    }

    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(DHPrivateKeySpec.class) && (key instanceof DHPrivateKey)) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            return new DHPrivateKeySpec(dHPrivateKey.getX(), dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
        } else if (!cls.isAssignableFrom(DHPublicKeySpec.class) || !(key instanceof DHPublicKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            return new DHPublicKeySpec(dHPublicKey.getY(), dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
        }
    }

    /* access modifiers changed from: protected */
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof DHPublicKey) {
            return new BCElGamalPublicKey((DHPublicKey) key);
        }
        if (key instanceof DHPrivateKey) {
            return new BCElGamalPrivateKey((DHPrivateKey) key);
        }
        if (key instanceof RSASSAVerifier) {
            return new BCElGamalPublicKey((RSASSAVerifier) key);
        }
        if (key instanceof AESCBC) {
            return new BCElGamalPrivateKey((AESCBC) key);
        }
        throw new InvalidKeyException("key type unknown");
    }

    public final PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.cca_continue.init;
        if (aSN1ObjectIdentifier.equals(com.cardinalcommerce.p060a.KeyFactorySpi.setRequestTimeout)) {
            return new BCElGamalPrivateKey(privateKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.ECKAEGwithSHA1KDF.onSetupCompleted)) {
            return new BCElGamalPrivateKey(privateKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.MQVwithSHA512KDF.values)) {
            return new BCElGamalPrivateKey(privateKeyInfo);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }

    public final PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.init.init;
        if (aSN1ObjectIdentifier.equals(com.cardinalcommerce.p060a.KeyFactorySpi.setRequestTimeout)) {
            return new BCElGamalPublicKey(subjectPublicKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.ECKAEGwithSHA1KDF.onSetupCompleted)) {
            return new BCElGamalPublicKey(subjectPublicKeyInfo);
        }
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.MQVwithSHA512KDF.values)) {
            return new BCElGamalPublicKey(subjectPublicKeyInfo);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }
}
