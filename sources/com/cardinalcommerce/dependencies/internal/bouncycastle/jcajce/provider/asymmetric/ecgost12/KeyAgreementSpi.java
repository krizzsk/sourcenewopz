package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ECDSAVerifier;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.JWEHeader;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyLengthException;
import com.cardinalcommerce.p060a.KeyUtil;
import com.cardinalcommerce.p060a.SignatureSpi;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class KeyAgreementSpi extends BaseAgreementSpi {
    private String cca_continue;
    private KeyUtil cleanup;
    private BCRSAPublicKey configure;
    private byte[] getWarnings;

    public static class ECVKO256 extends KeyAgreementSpi {
        public ECVKO256() {
            super("ECGOST3410-2012-256", new KeyUtil(new SignatureSpi.ecDSARipeMD160()));
        }
    }

    public static class ECVKO512 extends KeyAgreementSpi {
        public ECVKO512() {
            super("ECGOST3410-2012-512", new KeyUtil(new SignatureSpi.ecDetDSA256()));
        }
    }

    protected KeyAgreementSpi(String str, KeyUtil keyUtil) {
        super(str, (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) null);
        this.cca_continue = str;
        this.cleanup = keyUtil;
    }

    public final byte[] Cardinal() {
        return this.getWarnings;
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        getInstance(key, (AlgorithmParameterSpec) null);
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null || (algorithmParameterSpec instanceof JWEHeader)) {
            getInstance(key, algorithmParameterSpec);
            return;
        }
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }

    /* access modifiers changed from: protected */
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF;
        if (this.configure == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.cca_continue);
            sb.append(" not initialised.");
            throw new IllegalStateException(sb.toString());
        } else if (!z) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.cca_continue);
            sb2.append(" can only be between two parties.");
            throw new IllegalStateException(sb2.toString());
        } else if (key instanceof PublicKey) {
            PublicKey publicKey = (PublicKey) key;
            if (publicKey instanceof BCECGOST3410_2012PublicKey) {
                eCKAEGwithSHA512KDF = ((BCECGOST3410_2012PublicKey) publicKey).init;
            } else {
                eCKAEGwithSHA512KDF = ECUtil.Cardinal(publicKey);
            }
            try {
                this.getWarnings = this.cleanup.Cardinal(eCKAEGwithSHA512KDF);
                return null;
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder("calculation failed: ");
                sb3.append(e.getMessage());
                throw new InvalidKeyException(sb3.toString()) {
                    public final Throwable getCause() {
                        return e;
                    }
                };
            }
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.cca_continue);
            sb4.append(" key agreement requires ");
            String name = ECDSAVerifier.class.getName();
            sb4.append(name.substring(name.lastIndexOf(46) + 1));
            sb4.append(" for doPhase");
            throw new InvalidKeyException(sb4.toString());
        }
    }

    private void getInstance(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException {
        if (key instanceof PrivateKey) {
            DigestSignatureSpi.MD2 md2 = (DigestSignatureSpi.MD2) ECUtil.getInstance((PrivateKey) key);
            this.configure = md2.init;
            this.getInstance = algorithmParameterSpec instanceof JWEHeader ? JWEHeader.configure() : null;
            this.cleanup.configure(new ISOSignatureSpi.SHA512_256WithRSAEncryption(md2, this.getInstance));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.cca_continue);
        sb.append(" key agreement requires ");
        String name = KeyLengthException.class.getName();
        sb.append(name.substring(name.lastIndexOf(46) + 1));
        sb.append(" for initialisation");
        throw new InvalidKeyException(sb.toString());
    }
}
