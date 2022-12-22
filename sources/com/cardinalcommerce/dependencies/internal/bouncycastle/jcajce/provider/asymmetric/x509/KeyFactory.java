package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.x509;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.JWK;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyFactory extends KeyFactorySpi {
    /* access modifiers changed from: protected */
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

    /* access modifiers changed from: protected */
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        throw new InvalidKeyException("not implemented yet ".concat(String.valueOf(key)));
    }

    /* access modifiers changed from: protected */
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                PrivateKeyInfo init = PrivateKeyInfo.init(((PKCS8EncodedKeySpec) keySpec).getEncoded());
                PrivateKey configure = JWK.configure(init);
                if (configure != null) {
                    return configure;
                }
                StringBuilder sb = new StringBuilder("no factory found for OID: ");
                sb.append(init.cca_continue.init);
                throw new InvalidKeySpecException(sb.toString());
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder("Unknown KeySpec type: ");
            sb2.append(keySpec.getClass().getName());
            throw new InvalidKeySpecException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                SubjectPublicKeyInfo init = SubjectPublicKeyInfo.init(((X509EncodedKeySpec) keySpec).getEncoded());
                PublicKey instance = JWK.getInstance(init);
                if (instance != null) {
                    return instance;
                }
                StringBuilder sb = new StringBuilder("no factory found for OID: ");
                sb.append(init.init.init);
                throw new InvalidKeySpecException(sb.toString());
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder("Unknown KeySpec type: ");
            sb2.append(keySpec.getClass().getName());
            throw new InvalidKeySpecException(sb2.toString());
        }
    }
}
