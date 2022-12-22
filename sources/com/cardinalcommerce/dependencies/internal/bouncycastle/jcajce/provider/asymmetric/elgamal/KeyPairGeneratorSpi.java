package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ExtendedInvalidKeySpecException;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getTransactionStatus;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHParameterSpec;

public class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: a */
    private DigestSignatureSpi.SHA256 f3197a;

    /* renamed from: b */
    private KeyAgreementSpi.X448withSHA256CKDF f3198b = new KeyAgreementSpi.X448withSHA256CKDF();

    /* renamed from: c */
    private int f3199c = 1024;

    /* renamed from: d */
    private int f3200d = 20;

    /* renamed from: e */
    private SecureRandom f3201e = KeyAgreementSpi.MQV.cca_continue();

    /* renamed from: f */
    private boolean f3202f = false;

    public KeyPairGeneratorSpi() {
        super("ElGamal");
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.f3199c = i;
        this.f3201e = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        DigestSignatureSpi.SHA256 sha256;
        boolean z = algorithmParameterSpec instanceof getTransactionStatus;
        if (z || (algorithmParameterSpec instanceof DHParameterSpec)) {
            if (z) {
                getTransactionStatus gettransactionstatus = (getTransactionStatus) algorithmParameterSpec;
                sha256 = new DigestSignatureSpi.SHA256(secureRandom, new DigestSignatureSpi.SHA224(gettransactionstatus.configure, gettransactionstatus.Cardinal));
            } else {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                sha256 = new DigestSignatureSpi.SHA256(secureRandom, new DigestSignatureSpi.SHA224(dHParameterSpec.getP(), dHParameterSpec.getG(), dHParameterSpec.getL()));
            }
            this.f3197a = sha256;
            this.f3198b.configure = this.f3197a;
            this.f3202f = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec or an ElGamalParameterSpec");
    }

    public KeyPair generateKeyPair() {
        if (!this.f3202f) {
            DHParameterSpec init = JWK.getInstance.init(this.f3199c);
            if (init != null) {
                this.f3197a = new DigestSignatureSpi.SHA256(this.f3201e, new DigestSignatureSpi.SHA224(init.getP(), init.getG(), init.getL()));
            } else {
                KeyAgreementSpi.XDH xdh = new KeyAgreementSpi.XDH();
                int i = this.f3199c;
                int i2 = this.f3200d;
                SecureRandom secureRandom = this.f3201e;
                xdh.Cardinal = i;
                xdh.init = i2;
                xdh.configure = secureRandom;
                this.f3197a = new DigestSignatureSpi.SHA256(this.f3201e, xdh.init());
            }
            this.f3198b.configure = this.f3197a;
            this.f3202f = true;
        }
        ExtendedInvalidKeySpecException init2 = this.f3198b.init();
        return new KeyPair(new BCElGamalPublicKey((DigestSignatureSpi.SHA384) init2.Cardinal), new BCElGamalPrivateKey((DigestSignatureSpi.SHA3_256) init2.cca_continue));
    }
}
