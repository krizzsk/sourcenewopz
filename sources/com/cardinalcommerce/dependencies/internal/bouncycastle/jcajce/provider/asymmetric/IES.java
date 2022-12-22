package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric;

import com.cardinalcommerce.p060a.McElieceKeyFactorySpi;
import com.cardinalcommerce.p060a.RainbowKeyFactorySpi;

public class IES {

    public static class Mappings extends RainbowKeyFactorySpi {
        public final void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi) {
            mcElieceKeyFactorySpi.init("AlgorithmParameters.IES", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ies.AlgorithmParametersSpi");
            mcElieceKeyFactorySpi.init("AlgorithmParameters.ECIES", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ies.AlgorithmParametersSpi");
        }
    }
}
