package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p062dh;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.AlgorithmParameterGeneratorSpi */
public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {

    /* renamed from: a */
    private SecureRandom f3142a;

    /* renamed from: b */
    private int f3143b = 2048;

    /* renamed from: c */
    private int f3144c = 0;

    /* access modifiers changed from: protected */
    public void engineInit(int i, SecureRandom secureRandom) {
        this.f3143b = i;
        this.f3142a = secureRandom;
    }

    /* access modifiers changed from: protected */
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DHGenParameterSpec) {
            DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
            this.f3143b = dHGenParameterSpec.getPrimeSize();
            this.f3144c = dHGenParameterSpec.getExponentSize();
            this.f3142a = secureRandom;
            return;
        }
        throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGenerateParameters() {
        KeyAgreementSpi.X448 x448 = new KeyAgreementSpi.X448();
        int init = PrimeCertaintyCalculator.init(this.f3143b);
        SecureRandom secureRandom = this.f3142a;
        if (secureRandom != null) {
            x448.getInstance = this.f3143b;
            x448.Cardinal = init;
            x448.init = secureRandom;
        } else {
            int i = this.f3143b;
            SecureRandom cca_continue = KeyAgreementSpi.MQV.cca_continue();
            x448.getInstance = i;
            x448.Cardinal = init;
            x448.init = cca_continue;
        }
        CipherSpi Cardinal = x448.Cardinal();
        try {
            AlgorithmParameters init2 = init("DH");
            init2.init(new DHParameterSpec(Cardinal.Cardinal, Cardinal.configure, this.f3144c));
            return init2;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
