package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import com.cardinalcommerce.p060a.ExtendedInvalidKeySpecException;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;

public class KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: a */
    private static BigInteger f3212a = BigInteger.valueOf(65537);

    /* renamed from: b */
    private PSSSignatureSpi.SHA1withRSA f3213b;

    /* renamed from: c */
    private KeyFactorySpi.EDDSA f3214c = new KeyFactorySpi.EDDSA();

    public KeyPairGeneratorSpi() {
        super("RSA");
        PSSSignatureSpi.SHA1withRSA sHA1withRSA = new PSSSignatureSpi.SHA1withRSA(f3212a, KeyAgreementSpi.MQV.cca_continue(), 2048, PrimeCertaintyCalculator.init(2048));
        this.f3213b = sHA1withRSA;
        this.f3214c.configure = sHA1withRSA;
    }

    public void initialize(int i, SecureRandom secureRandom) {
        PSSSignatureSpi.SHA1withRSA sHA1withRSA = new PSSSignatureSpi.SHA1withRSA(f3212a, secureRandom, i, PrimeCertaintyCalculator.init(i));
        this.f3213b = sHA1withRSA;
        this.f3214c.configure = sHA1withRSA;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof RSAKeyGenParameterSpec) {
            RSAKeyGenParameterSpec rSAKeyGenParameterSpec = (RSAKeyGenParameterSpec) algorithmParameterSpec;
            PSSSignatureSpi.SHA1withRSA sHA1withRSA = new PSSSignatureSpi.SHA1withRSA(rSAKeyGenParameterSpec.getPublicExponent(), secureRandom, rSAKeyGenParameterSpec.getKeysize(), PrimeCertaintyCalculator.init(2048));
            this.f3213b = sHA1withRSA;
            this.f3214c.configure = sHA1withRSA;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a RSAKeyGenParameterSpec");
    }

    public KeyPair generateKeyPair() {
        ExtendedInvalidKeySpecException init = this.f3214c.init();
        return new KeyPair(new BCRSAPublicKey((ISOSignatureSpi.WhirlpoolWithRSAEncryption) init.Cardinal), new BCRSAPrivateCrtKey((PSSSignatureSpi.SHA224withRSA) init.cca_continue));
    }
}
