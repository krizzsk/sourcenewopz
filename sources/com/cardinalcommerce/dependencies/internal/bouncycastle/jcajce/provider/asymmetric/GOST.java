package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.McElieceKeyFactorySpi;
import com.cardinalcommerce.p060a.RainbowKeyFactorySpi;

public class GOST {

    public static class Mappings extends RainbowKeyFactorySpi {
        public final void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi) {
            mcElieceKeyFactorySpi.init("KeyPairGenerator.GOST3410", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.gost.KeyPairGeneratorSpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyPairGenerator.GOST-3410", "GOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyPairGenerator.GOST-3410-94", "GOST3410");
            mcElieceKeyFactorySpi.init("KeyFactory.GOST3410", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyFactory.GOST-3410", "GOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyFactory.GOST-3410-94", "GOST3410");
            mcElieceKeyFactorySpi.init("AlgorithmParameters.GOST3410", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.gost.AlgorithmParametersSpi");
            mcElieceKeyFactorySpi.init("AlgorithmParameterGenerator.GOST3410", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.gost.AlgorithmParameterGeneratorSpi");
            configure(mcElieceKeyFactorySpi, KeyAgreementSpi.DHUwithSHA512CKDF.getWarnings, "GOST3410", new KeyFactorySpi());
            getInstance(mcElieceKeyFactorySpi, KeyAgreementSpi.DHUwithSHA512CKDF.getWarnings, "GOST3410");
            mcElieceKeyFactorySpi.init("Signature.GOST3410", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.gost.SignatureSpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.GOST-3410", "GOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.GOST-3410-94", "GOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.GOST3411withGOST3410", "GOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.GOST3411WITHGOST3410", "GOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.GOST3411WithGOST3410", "GOST3410");
            StringBuilder sb = new StringBuilder("Alg.Alias.Signature.");
            sb.append(KeyAgreementSpi.DHUwithSHA512CKDF.values);
            mcElieceKeyFactorySpi.init(sb.toString(), "GOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameterGenerator.GOST-3410", "GOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.GOST-3410", "GOST3410");
        }
    }
}
