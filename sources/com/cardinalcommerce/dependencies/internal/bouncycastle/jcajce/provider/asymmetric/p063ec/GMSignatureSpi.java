package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.p060a.BaseKeyFactorySpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.JWEObject;
import com.cardinalcommerce.p060a.JWSObject;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.PemObject;
import com.cardinalcommerce.p060a.SignatureSpi;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi */
public class GMSignatureSpi extends SignatureSpi {
    private PemObject Cardinal;
    private AlgorithmParameters cca_continue;
    private final JWEObject configure = new JWSObject();
    private final BaseKeyFactorySpi init;

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi$sha256WithSM2 */
    public static class sha256WithSM2 extends GMSignatureSpi {
        public sha256WithSM2() {
            super(new BaseKeyFactorySpi(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi$sm3WithSM2 */
    public static class sm3WithSM2 extends GMSignatureSpi {
        public sm3WithSM2() {
            super(new BaseKeyFactorySpi());
        }
    }

    GMSignatureSpi(BaseKeyFactorySpi baseKeyFactorySpi) {
        this.init = baseKeyFactorySpi;
    }

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        if (this.cca_continue == null && this.Cardinal != null) {
            try {
                AlgorithmParameters configure2 = this.configure.configure("PSS");
                this.cca_continue = configure2;
                configure2.init(this.Cardinal);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.cca_continue;
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        KeyAgreementSpi.ECKAEGwithSHA512KDF instance = ECUtil.getInstance(privateKey);
        if (this.appRandom != null) {
            instance = new ISOSignatureSpi.SHA224WithRSAEncryption(instance, this.appRandom);
        }
        if (this.Cardinal != null) {
            this.init.cca_continue(true, new ISOSignatureSpi.SHA512WithRSAEncryption(instance, PemObject.cca_continue()));
        } else {
            this.init.cca_continue(true, instance);
        }
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof PemObject) {
            this.Cardinal = (PemObject) algorithmParameterSpec;
            return;
        }
        throw new InvalidAlgorithmParameterException("only SM2ParameterSpec supported");
    }

    /* access modifiers changed from: protected */
    public byte[] engineSign() throws SignatureException {
        try {
            return this.init.Cardinal();
        } catch (KeyAgreementSpi.MQVwithSHA1KDFAndSharedInfo e) {
            StringBuilder sb = new StringBuilder("unable to create signature: ");
            sb.append(e.getMessage());
            throw new SignatureException(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.init.init(bArr);
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        ISOSignatureSpi.SHA512WithRSAEncryption sHA512WithRSAEncryption;
        if (publicKey instanceof BCECPublicKey) {
            sHA512WithRSAEncryption = ((BCECPublicKey) publicKey).configure;
        } else {
            sHA512WithRSAEncryption = ECUtil.Cardinal(publicKey);
        }
        if (this.Cardinal != null) {
            sHA512WithRSAEncryption = new ISOSignatureSpi.SHA512WithRSAEncryption(sHA512WithRSAEncryption, PemObject.cca_continue());
        }
        this.init.cca_continue(false, sHA512WithRSAEncryption);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.init.getInstance.Cardinal(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.init.getInstance.init(bArr, i, i2);
    }
}
