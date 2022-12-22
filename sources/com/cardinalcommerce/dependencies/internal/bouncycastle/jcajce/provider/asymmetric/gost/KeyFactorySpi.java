package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.gost;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import com.cardinalcommerce.p060a.AlgorithmSupportMessage;
import com.cardinalcommerce.p060a.AuthenticatedCipherText;
import com.cardinalcommerce.p060a.JWTClaimsSet;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.RuntimeErrorEvent;
import com.cardinalcommerce.p060a.setErrorCode;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof JWTClaimsSet ? new BCGOST3410PrivateKey((JWTClaimsSet) keySpec) : super.engineGeneratePrivate(keySpec);
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof RuntimeErrorEvent ? new BCGOST3410PublicKey((RuntimeErrorEvent) keySpec) : super.engineGeneratePublic(keySpec);
    }

    /* access modifiers changed from: protected */
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof AuthenticatedCipherText) {
            return new BCGOST3410PublicKey((AuthenticatedCipherText) key);
        }
        if (key instanceof AlgorithmSupportMessage) {
            return new BCGOST3410PrivateKey((AlgorithmSupportMessage) key);
        }
        throw new InvalidKeyException("key type unknown");
    }

    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(RuntimeErrorEvent.class) && (key instanceof AuthenticatedCipherText)) {
            AuthenticatedCipherText authenticatedCipherText = (AuthenticatedCipherText) key;
            setErrorCode cca_continue = authenticatedCipherText.cca_continue().cca_continue();
            return new RuntimeErrorEvent(authenticatedCipherText.Cardinal(), cca_continue.configure, cca_continue.init, cca_continue.getInstance);
        } else if (!cls.isAssignableFrom(JWTClaimsSet.class) || !(key instanceof AlgorithmSupportMessage)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            AlgorithmSupportMessage algorithmSupportMessage = (AlgorithmSupportMessage) key;
            setErrorCode cca_continue2 = algorithmSupportMessage.cca_continue().cca_continue();
            return new JWTClaimsSet(algorithmSupportMessage.getInstance(), cca_continue2.configure, cca_continue2.init, cca_continue2.getInstance);
        }
    }

    public final PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.cca_continue.init;
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHUwithSHA512CKDF.getWarnings)) {
            return new BCGOST3410PrivateKey(privateKeyInfo);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }

    public final PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.init.init;
        if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHUwithSHA512CKDF.getWarnings)) {
            return new BCGOST3410PublicKey(subjectPublicKeyInfo);
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognised");
        throw new IOException(sb.toString());
    }
}
