package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec.BCECPublicKey;
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
    private BCRSAPublicKey cca_continue;
    private String configure;
    private byte[] getSDKVersion;
    private KeyUtil values;

    public static class ECVKO extends KeyAgreementSpi {
        public ECVKO() {
            super("ECGOST3410", new KeyUtil(new SignatureSpi.ecDSASha3_384()));
        }
    }

    protected KeyAgreementSpi(String str, KeyUtil keyUtil) {
        super(str, (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) null);
        this.configure = str;
        this.values = keyUtil;
    }

    public final byte[] Cardinal() {
        return this.getSDKVersion;
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        init(key, (AlgorithmParameterSpec) null);
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null || (algorithmParameterSpec instanceof JWEHeader)) {
            init(key, algorithmParameterSpec);
            return;
        }
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }

    /* access modifiers changed from: protected */
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF;
        if (this.cca_continue == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.configure);
            sb.append(" not initialised.");
            throw new IllegalStateException(sb.toString());
        } else if (!z) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.configure);
            sb2.append(" can only be between two parties.");
            throw new IllegalStateException(sb2.toString());
        } else if (key instanceof PublicKey) {
            PublicKey publicKey = (PublicKey) key;
            if (publicKey instanceof BCECPublicKey) {
                eCKAEGwithSHA512KDF = ((BCECGOST3410PublicKey) publicKey).Cardinal;
            } else {
                eCKAEGwithSHA512KDF = ECUtil.Cardinal(publicKey);
            }
            try {
                this.getSDKVersion = this.values.Cardinal(eCKAEGwithSHA512KDF);
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
            sb4.append(this.configure);
            sb4.append(" key agreement requires ");
            String name = ECDSAVerifier.class.getName();
            sb4.append(name.substring(name.lastIndexOf(46) + 1));
            sb4.append(" for doPhase");
            throw new InvalidKeyException(sb4.toString());
        }
    }

    private void init(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException {
        if (key instanceof PrivateKey) {
            DigestSignatureSpi.MD2 md2 = (DigestSignatureSpi.MD2) ECUtil.getInstance((PrivateKey) key);
            this.cca_continue = md2.init;
            this.getInstance = algorithmParameterSpec instanceof JWEHeader ? JWEHeader.configure() : null;
            this.values.configure(new ISOSignatureSpi.SHA512_256WithRSAEncryption(md2, this.getInstance));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.configure);
        sb.append(" key agreement requires ");
        String name = KeyLengthException.class.getName();
        sb.append(name.substring(name.lastIndexOf(46) + 1));
        sb.append(" for initialisation");
        throw new InvalidKeyException(sb.toString());
    }
}
