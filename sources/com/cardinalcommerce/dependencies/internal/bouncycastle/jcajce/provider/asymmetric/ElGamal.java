package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.McElieceKeyFactorySpi;
import com.cardinalcommerce.p060a.RainbowKeyFactorySpi;

public class ElGamal {

    public static class Mappings extends RainbowKeyFactorySpi {
        public final void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi) {
            mcElieceKeyFactorySpi.init("AlgorithmParameterGenerator.ELGAMAL", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParameterGeneratorSpi");
            mcElieceKeyFactorySpi.init("AlgorithmParameterGenerator.ElGamal", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParameterGeneratorSpi");
            mcElieceKeyFactorySpi.init("AlgorithmParameters.ELGAMAL", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParametersSpi");
            mcElieceKeyFactorySpi.init("AlgorithmParameters.ElGamal", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParametersSpi");
            mcElieceKeyFactorySpi.init("Cipher.ELGAMAL", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$NoPadding");
            mcElieceKeyFactorySpi.init("Cipher.ElGamal", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$NoPadding");
            mcElieceKeyFactorySpi.init("Alg.Alias.Cipher.ELGAMAL/ECB/PKCS1PADDING", "ELGAMAL/PKCS1");
            mcElieceKeyFactorySpi.init("Alg.Alias.Cipher.ELGAMAL/NONE/PKCS1PADDING", "ELGAMAL/PKCS1");
            mcElieceKeyFactorySpi.init("Alg.Alias.Cipher.ELGAMAL/NONE/NOPADDING", "ELGAMAL");
            mcElieceKeyFactorySpi.init("Cipher.ELGAMAL/PKCS1", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$PKCS1v1_5Padding");
            mcElieceKeyFactorySpi.init("KeyFactory.ELGAMAL", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyFactorySpi");
            mcElieceKeyFactorySpi.init("KeyFactory.ElGamal", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyFactorySpi");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.ELGAMAL", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyPairGeneratorSpi");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.ElGamal", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyPairGeneratorSpi");
            configure(mcElieceKeyFactorySpi, KeyAgreementSpi.MQVwithSHA512KDF.values, "ELGAMAL", new KeyFactorySpi());
            getInstance(mcElieceKeyFactorySpi, KeyAgreementSpi.MQVwithSHA512KDF.values, "ELGAMAL");
        }
    }
}
