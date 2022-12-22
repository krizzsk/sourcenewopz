package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public abstract class BaseKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return cca_continue(PrivateKeyInfo.init(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("encoded key spec not recognized: ");
                sb.append(e.getMessage());
                throw new InvalidKeySpecException(sb.toString());
            }
        } else {
            throw new InvalidKeySpecException("key spec not recognized");
        }
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return getInstance(SubjectPublicKeyInfo.init(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("encoded key spec not recognized: ");
                sb.append(e.getMessage());
                throw new InvalidKeySpecException(sb.toString());
            }
        } else {
            throw new InvalidKeySpecException("key spec not recognized");
        }
    }

    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(PKCS8EncodedKeySpec.class) && key.getFormat().equals("PKCS#8")) {
            return new PKCS8EncodedKeySpec(key.getEncoded());
        }
        if (cls.isAssignableFrom(X509EncodedKeySpec.class) && key.getFormat().equals("X.509")) {
            return new X509EncodedKeySpec(key.getEncoded());
        }
        StringBuilder sb = new StringBuilder("not implemented yet ");
        sb.append(key);
        sb.append(" ");
        sb.append(cls);
        throw new InvalidKeySpecException(sb.toString());
    }
}
