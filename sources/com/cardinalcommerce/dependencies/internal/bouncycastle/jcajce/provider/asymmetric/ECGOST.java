package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyFactorySpi;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.McElieceKeyFactorySpi;
import com.cardinalcommerce.p060a.RainbowKeyFactorySpi;

public class ECGOST {

    public static class Mappings extends RainbowKeyFactorySpi {
        public final void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi) {
            mcElieceKeyFactorySpi.init("KeyFactory.ECGOST3410", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyFactorySpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyFactory.GOST-3410-2001", "ECGOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyFactory.ECGOST-3410", "ECGOST3410");
            configure(mcElieceKeyFactorySpi, KeyAgreementSpi.DHUwithSHA512CKDF.getSDKVersion, "ECGOST3410", new KeyFactorySpi());
            configure(mcElieceKeyFactorySpi, KeyAgreementSpi.DHUwithSHA512CKDF.getRequestTimeout, "ECGOST3410", new KeyFactorySpi());
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.".concat(String.valueOf(KeyAgreementSpi.DHUwithSHA512CKDF.getSDKVersion)), "ECGOST3410");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.ECGOST3410", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyPairGeneratorSpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyPairGenerator.ECGOST-3410", "ECGOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyPairGenerator.GOST-3410-2001", "ECGOST3410");
            mcElieceKeyFactorySpi.init("Signature.ECGOST3410", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.ECGOST-3410", "ECGOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.GOST-3410-2001", "ECGOST3410");
            mcElieceKeyFactorySpi.init("KeyAgreement.ECGOST3410", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyAgreementSpi$ECVKO");
            StringBuilder sb = new StringBuilder("Alg.Alias.KeyAgreement.");
            sb.append(KeyAgreementSpi.DHUwithSHA512CKDF.getSDKVersion);
            mcElieceKeyFactorySpi.init(sb.toString(), "ECGOST3410");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyAgreement.GOST-3410-2001", "ECGOST3410");
            StringBuilder sb2 = new StringBuilder("Alg.Alias.KeyAgreement.");
            sb2.append(KeyAgreementSpi.DHUwithSHA512CKDF.setRequestTimeout);
            mcElieceKeyFactorySpi.init(sb2.toString(), "ECGOST3410");
            mcElieceKeyFactorySpi.init("AlgorithmParameters.ECGOST3410", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost.AlgorithmParametersSpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.GOST-3410-2001", "ECGOST3410");
            cca_continue(mcElieceKeyFactorySpi, "GOST3411", "ECGOST3410", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi", KeyAgreementSpi.DHUwithSHA512CKDF.cleanup);
            mcElieceKeyFactorySpi.init("KeyFactory.ECGOST3410-2012", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyFactory.GOST-3410-2012", "ECGOST3410-2012");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyFactory.ECGOST-3410-2012", "ECGOST3410-2012");
            configure(mcElieceKeyFactorySpi, DSASigner.detDSA224.init, "ECGOST3410-2012", new com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi());
            configure(mcElieceKeyFactorySpi, DSASigner.detDSA224.getWarnings, "ECGOST3410-2012", new com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi());
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.".concat(String.valueOf(DSASigner.detDSA224.init)), "ECGOST3410-2012");
            configure(mcElieceKeyFactorySpi, DSASigner.detDSA224.Cardinal, "ECGOST3410-2012", new com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi());
            configure(mcElieceKeyFactorySpi, DSASigner.detDSA224.values, "ECGOST3410-2012", new com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi());
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.".concat(String.valueOf(DSASigner.detDSA224.Cardinal)), "ECGOST3410-2012");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.ECGOST3410-2012", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyPairGeneratorSpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyPairGenerator.ECGOST3410-2012", "ECGOST3410-2012");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyPairGenerator.GOST-3410-2012", "ECGOST3410-2012");
            mcElieceKeyFactorySpi.init("Signature.ECGOST3410-2012-256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi256");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.ECGOST3410-2012-256", "ECGOST3410-2012-256");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.GOST-3410-2012-256", "ECGOST3410-2012-256");
            cca_continue(mcElieceKeyFactorySpi, "GOST3411-2012-256", "ECGOST3410-2012-256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi256", DSASigner.detDSA224.cleanup);
            mcElieceKeyFactorySpi.init("Signature.ECGOST3410-2012-512", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi512");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.ECGOST3410-2012-512", "ECGOST3410-2012-512");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.GOST-3410-2012-512", "ECGOST3410-2012-512");
            cca_continue(mcElieceKeyFactorySpi, "GOST3411-2012-512", "ECGOST3410-2012-512", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi512", DSASigner.detDSA224.getSDKVersion);
            mcElieceKeyFactorySpi.init("KeyAgreement.ECGOST3410-2012-256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyAgreementSpi$ECVKO256");
            mcElieceKeyFactorySpi.init("KeyAgreement.ECGOST3410-2012-512", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyAgreementSpi$ECVKO512");
            StringBuilder sb3 = new StringBuilder("Alg.Alias.KeyAgreement.");
            sb3.append(DSASigner.detDSA224.getWarnings);
            mcElieceKeyFactorySpi.init(sb3.toString(), "ECGOST3410-2012-256");
            StringBuilder sb4 = new StringBuilder("Alg.Alias.KeyAgreement.");
            sb4.append(DSASigner.detDSA224.values);
            mcElieceKeyFactorySpi.init(sb4.toString(), "ECGOST3410-2012-512");
            StringBuilder sb5 = new StringBuilder("Alg.Alias.KeyAgreement.");
            sb5.append(DSASigner.detDSA224.init);
            mcElieceKeyFactorySpi.init(sb5.toString(), "ECGOST3410-2012-256");
            StringBuilder sb6 = new StringBuilder("Alg.Alias.KeyAgreement.");
            sb6.append(DSASigner.detDSA224.Cardinal);
            mcElieceKeyFactorySpi.init(sb6.toString(), "ECGOST3410-2012-512");
        }
    }
}
