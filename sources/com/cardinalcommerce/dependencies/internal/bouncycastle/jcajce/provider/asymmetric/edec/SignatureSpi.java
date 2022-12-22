package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec;

import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.X931SignatureSpi;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;

public class SignatureSpi extends java.security.SignatureSpi {
    private static final byte[] init = new byte[0];
    private KeyPairGeneratorSpi.ECDSA configure;
    private final String getInstance;

    public static final class Ed25519 extends SignatureSpi {
        public Ed25519() {
            super(EdDSAParameterSpec.Ed25519);
        }
    }

    public static final class Ed448 extends SignatureSpi {
        public Ed448() {
            super(EdDSAParameterSpec.Ed448);
        }
    }

    public static final class EdDSA extends SignatureSpi {
        public EdDSA() {
            super((String) null);
        }
    }

    SignatureSpi(String str) {
        this.getInstance = str;
    }

    private KeyPairGeneratorSpi.ECDSA init(String str) throws InvalidKeyException {
        String str2 = this.getInstance;
        if (str2 == null || str.equals(str2)) {
            return str.equals(EdDSAParameterSpec.Ed448) ? new X931SignatureSpi.SHA512_224WithRSAEncryption(init) : new X931SignatureSpi.SHA512WithRSAEncryption();
        }
        StringBuilder sb = new StringBuilder("inappropriate key for ");
        sb.append(this.getInstance);
        throw new InvalidKeyException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) throws InvalidParameterException {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(String str, Object obj) throws InvalidParameterException {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public byte[] engineSign() throws SignatureException {
        try {
            return this.configure.Cardinal();
        } catch (KeyAgreementSpi.MQVwithSHA1KDFAndSharedInfo e) {
            throw new SignatureException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.configure.init(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.configure.cca_continue(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.configure.init(bArr);
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCEdDSAPublicKey) {
            setKeyboardNavigationCluster setkeyboardnavigationcluster = ((BCEdDSAPublicKey) publicKey).init;
            this.configure = init(setkeyboardnavigationcluster instanceof DigestSignatureSpi.RIPEMD128 ? EdDSAParameterSpec.Ed448 : EdDSAParameterSpec.Ed25519);
            this.configure.cca_continue(false, setkeyboardnavigationcluster);
            return;
        }
        throw new InvalidKeyException("cannot identify EdDSA public key");
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCEdDSAPrivateKey) {
            setKeyboardNavigationCluster setkeyboardnavigationcluster = ((BCEdDSAPrivateKey) privateKey).configure;
            this.configure = init(setkeyboardnavigationcluster instanceof DigestSignatureSpi.SHA1 ? EdDSAParameterSpec.Ed448 : EdDSAParameterSpec.Ed25519);
            this.configure.cca_continue(true, setkeyboardnavigationcluster);
            return;
        }
        throw new InvalidKeyException("cannot identify EdDSA public key");
    }
}
