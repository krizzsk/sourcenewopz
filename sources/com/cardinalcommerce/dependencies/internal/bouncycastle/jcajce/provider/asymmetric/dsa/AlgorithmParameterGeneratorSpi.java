package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import com.cardinalcommerce.p060a.BCGOST3410PublicKey;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.setDrawingCacheEnabled;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {

    /* renamed from: a */
    private SecureRandom f3153a;

    /* renamed from: b */
    private int f3154b = 2048;

    /* renamed from: c */
    private setDrawingCacheEnabled f3155c;

    /* access modifiers changed from: protected */
    public void engineInit(int i, SecureRandom secureRandom) {
        if (i < 512 || i > 3072) {
            throw new InvalidParameterException("strength must be from 512 - 3072");
        } else if (i <= 1024 && i % 64 != 0) {
            throw new InvalidParameterException("strength must be a multiple of 64 below 1024 bits.");
        } else if (i <= 1024 || i % 1024 == 0) {
            this.f3154b = i;
            this.f3153a = secureRandom;
        } else {
            throw new InvalidParameterException("strength must be a multiple of 1024 above 1024 bits.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGenerateParameters() {
        setDrawingCacheEnabled setdrawingcacheenabled;
        KeyAgreementSpi.X25519withSHA384CKDF x25519withSHA384CKDF = this.f3154b <= 1024 ? new KeyAgreementSpi.X25519withSHA384CKDF() : new KeyAgreementSpi.X25519withSHA384CKDF(new SignatureSpi.ecNR());
        if (this.f3153a == null) {
            this.f3153a = KeyAgreementSpi.MQV.cca_continue();
        }
        int init = PrimeCertaintyCalculator.init(this.f3154b);
        int i = this.f3154b;
        if (i == 1024) {
            setdrawingcacheenabled = new setDrawingCacheEnabled(1024, 160, init, this.f3153a, (byte) 0);
        } else if (i > 1024) {
            setdrawingcacheenabled = new setDrawingCacheEnabled(i, 256, init, this.f3153a, (byte) 0);
        } else {
            x25519withSHA384CKDF.Cardinal(i, init, this.f3153a);
            BCGOST3410PublicKey configure = x25519withSHA384CKDF.configure();
            AlgorithmParameters init2 = init("DSA");
            init2.init(new DSAParameterSpec(configure.init, configure.getInstance, configure.cca_continue));
            return init2;
        }
        this.f3155c = setdrawingcacheenabled;
        x25519withSHA384CKDF.getInstance(setdrawingcacheenabled);
        BCGOST3410PublicKey configure2 = x25519withSHA384CKDF.configure();
        try {
            AlgorithmParameters init22 = init("DSA");
            init22.init(new DSAParameterSpec(configure2.init, configure2.getInstance, configure2.cca_continue));
            return init22;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
