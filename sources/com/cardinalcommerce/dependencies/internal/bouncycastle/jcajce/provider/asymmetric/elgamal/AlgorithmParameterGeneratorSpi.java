package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {

    /* renamed from: a */
    private SecureRandom f3193a;

    /* renamed from: b */
    private int f3194b = 1024;

    /* renamed from: c */
    private int f3195c = 0;

    /* access modifiers changed from: protected */
    public void engineInit(int i, SecureRandom secureRandom) {
        this.f3194b = i;
        this.f3193a = secureRandom;
    }

    /* access modifiers changed from: protected */
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DHGenParameterSpec) {
            DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
            this.f3194b = dHGenParameterSpec.getPrimeSize();
            this.f3195c = dHGenParameterSpec.getExponentSize();
            this.f3193a = secureRandom;
            return;
        }
        throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGenerateParameters() {
        KeyAgreementSpi.XDH xdh = new KeyAgreementSpi.XDH();
        SecureRandom secureRandom = this.f3193a;
        if (secureRandom != null) {
            xdh.Cardinal = this.f3194b;
            xdh.init = 20;
            xdh.configure = secureRandom;
        } else {
            int i = this.f3194b;
            SecureRandom cca_continue = KeyAgreementSpi.MQV.cca_continue();
            xdh.Cardinal = i;
            xdh.init = 20;
            xdh.configure = cca_continue;
        }
        DigestSignatureSpi.SHA224 init = xdh.init();
        try {
            AlgorithmParameters init2 = init("ElGamal");
            init2.init(new DHParameterSpec(init.init, init.configure, this.f3195c));
            return init2;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
