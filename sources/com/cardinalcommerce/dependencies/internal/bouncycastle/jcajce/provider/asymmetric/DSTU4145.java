package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.McElieceKeyFactorySpi;
import com.cardinalcommerce.p060a.RainbowKeyFactorySpi;

public class DSTU4145 {

    public static class Mappings extends RainbowKeyFactorySpi {
        public final void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi) {
            mcElieceKeyFactorySpi.init("KeyFactory.DSTU4145", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyFactory.DSTU-4145-2002", "DSTU4145");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyFactory.DSTU4145-3410", "DSTU4145");
            configure(mcElieceKeyFactorySpi, DSASigner.dsaSha3_512.configure, "DSTU4145", new KeyFactorySpi());
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.".concat(String.valueOf(DSASigner.dsaSha3_512.configure)), "DSTU4145");
            configure(mcElieceKeyFactorySpi, DSASigner.dsaSha3_512.cca_continue, "DSTU4145", new KeyFactorySpi());
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.".concat(String.valueOf(DSASigner.dsaSha3_512.cca_continue)), "DSTU4145");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.DSTU4145", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu.KeyPairGeneratorSpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyPairGenerator.DSTU-4145", "DSTU4145");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyPairGenerator.DSTU-4145-2002", "DSTU4145");
            mcElieceKeyFactorySpi.init("Signature.DSTU4145", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.DSTU-4145", "DSTU4145");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.DSTU-4145-2002", "DSTU4145");
            cca_continue(mcElieceKeyFactorySpi, "GOST3411", "DSTU4145LE", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpiLe", DSASigner.dsaSha3_512.configure);
            cca_continue(mcElieceKeyFactorySpi, "GOST3411", "DSTU4145", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpi", DSASigner.dsaSha3_512.cca_continue);
        }
    }
}
