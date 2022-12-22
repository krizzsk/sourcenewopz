package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.EC5Util;
import com.cardinalcommerce.p060a.EdEC;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getErrorCode;
import com.cardinalcommerce.p060a.getUiType;
import com.cardinalcommerce.p060a.setErrorMessage;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import com.cardinalcommerce.p060a.setTextDirection;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyFactorySpi extends BaseKeyFactorySpi implements AsymmetricKeyInfoConverter {
    static final byte[] cca_continue = setTextDirection.getInstance("3043300506032b6571033a00");
    static final byte[] configure = setTextDirection.getInstance("302a300506032b656e032100");
    static final byte[] getInstance = setTextDirection.getInstance("3042300506032b656f033900");
    static final byte[] init = setTextDirection.getInstance("302a300506032b6570032100");
    private final boolean Cardinal;
    private final int cleanup;

    public static class ED25519 extends KeyFactorySpi {
        public ED25519() {
            super(false, 112);
        }
    }

    public static class ED448 extends KeyFactorySpi {
        public ED448() {
            super(false, 113);
        }
    }

    public static class EDDSA extends KeyFactorySpi {
        public EDDSA() {
            super(false, 0);
        }
    }

    public static class X25519 extends KeyFactorySpi {
        public X25519() {
            super(true, 110);
        }
    }

    public static class X448 extends KeyFactorySpi {
        public X448() {
            super(true, 111);
        }
    }

    public static class XDH extends KeyFactorySpi {
        public XDH() {
            super(true, 0);
        }
    }

    public KeyFactorySpi(boolean z, int i) {
        this.Cardinal = z;
        this.cleanup = i;
    }

    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof getErrorCode)) {
            return super.engineGeneratePrivate(keySpec);
        }
        setKeyboardNavigationCluster Cardinal2 = EC5Util.Cardinal(((getErrorCode) keySpec).getEncoded());
        if (Cardinal2 instanceof DigestSignatureSpi.MD5) {
            return new BCEdDSAPrivateKey((setKeyboardNavigationCluster) (DigestSignatureSpi.MD5) Cardinal2);
        }
        throw new IllegalStateException("openssh private key not Ed25519 private key");
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            byte[] encoded = ((X509EncodedKeySpec) keySpec).getEncoded();
            int i = this.cleanup;
            if (i == 0 || i == encoded[8]) {
                switch (encoded[8]) {
                    case 110:
                        return new BCXDHPublicKey(configure, encoded);
                    case 111:
                        return new BCXDHPublicKey(getInstance, encoded);
                    case 112:
                        return new BCEdDSAPublicKey(init, encoded);
                    case 113:
                        return new BCEdDSAPublicKey(cca_continue, encoded);
                    default:
                        return super.engineGeneratePublic(keySpec);
                }
            }
        } else if (keySpec instanceof setErrorMessage) {
            setKeyboardNavigationCluster cca_continue2 = DSASigner.dsaSha3_384.cca_continue(((setErrorMessage) keySpec).getEncoded());
            if (cca_continue2 instanceof DigestSignatureSpi.RIPEMD256) {
                return new BCEdDSAPublicKey(new byte[0], ((DigestSignatureSpi.RIPEMD256) cca_continue2).getEncoded());
            }
            throw new IllegalStateException("openssh public key not Ed25519 public key");
        }
        return super.engineGeneratePublic(keySpec);
    }

    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(getErrorCode.class) && (key instanceof BCEdDSAPrivateKey)) {
            try {
                return new getErrorCode(EC5Util.Cardinal((setKeyboardNavigationCluster) new DigestSignatureSpi.MD5(((EdEC) new getUiType(((EdEC) setThreeDSRequestorAppURL.cca_continue((Object) key.getEncoded()).Cardinal(2)).cca_continue()).cca_continue()).cca_continue())));
            } catch (IOException e) {
                throw new InvalidKeySpecException(e.getMessage(), e.getCause());
            }
        } else if (!cls.isAssignableFrom(setErrorMessage.class) || !(key instanceof BCEdDSAPublicKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            try {
                return new setErrorMessage(DSASigner.dsaSha3_384.configure((setKeyboardNavigationCluster) new DigestSignatureSpi.RIPEMD256(key.getEncoded(), init.length)));
            } catch (IOException e2) {
                throw new InvalidKeySpecException(e2.getMessage(), e2.getCause());
            }
        }
    }

    /* access modifiers changed from: protected */
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        throw new InvalidKeyException("key type unknown");
    }

    public final PrivateKey cca_continue(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.cca_continue.init;
        if (this.Cardinal) {
            int i = this.cleanup;
            if ((i == 0 || i == 111) && aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.configure)) {
                return new BCXDHPrivateKey(privateKeyInfo);
            }
            int i2 = this.cleanup;
            if ((i2 == 0 || i2 == 110) && aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.cca_continue)) {
                return new BCXDHPrivateKey(privateKeyInfo);
            }
        } else if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.init) || aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.Cardinal)) {
            int i3 = this.cleanup;
            if ((i3 == 0 || i3 == 113) && aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.init)) {
                return new BCEdDSAPrivateKey(privateKeyInfo);
            }
            int i4 = this.cleanup;
            if ((i4 == 0 || i4 == 112) && aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.Cardinal)) {
                return new BCEdDSAPrivateKey(privateKeyInfo);
            }
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognized");
        throw new IOException(sb.toString());
    }

    public final PublicKey getInstance(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.init.init;
        if (this.Cardinal) {
            int i = this.cleanup;
            if ((i == 0 || i == 111) && aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.configure)) {
                return new BCXDHPublicKey(subjectPublicKeyInfo);
            }
            int i2 = this.cleanup;
            if ((i2 == 0 || i2 == 110) && aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.cca_continue)) {
                return new BCXDHPublicKey(subjectPublicKeyInfo);
            }
        } else if (aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.init) || aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.Cardinal)) {
            int i3 = this.cleanup;
            if ((i3 == 0 || i3 == 113) && aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.init)) {
                return new BCEdDSAPublicKey(subjectPublicKeyInfo);
            }
            int i4 = this.cleanup;
            if ((i4 == 0 || i4 == 112) && aSN1ObjectIdentifier.equals(KeyAgreementSpi.DHwithSHA256CKDF.Cardinal)) {
                return new BCEdDSAPublicKey(subjectPublicKeyInfo);
            }
        }
        StringBuilder sb = new StringBuilder("algorithm identifier ");
        sb.append(aSN1ObjectIdentifier);
        sb.append(" in key not recognized");
        throw new IOException(sb.toString());
    }
}
