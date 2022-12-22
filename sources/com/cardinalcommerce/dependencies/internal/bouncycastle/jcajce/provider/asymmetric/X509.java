package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric;

import com.cardinalcommerce.p060a.McElieceKeyFactorySpi;
import com.cardinalcommerce.p060a.RainbowKeyFactorySpi;

public class X509 {

    public static class Mappings extends RainbowKeyFactorySpi {
        public final void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi) {
            mcElieceKeyFactorySpi.init("KeyFactory.X.509", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.x509.KeyFactory");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyFactory.X509", "X.509");
            mcElieceKeyFactorySpi.init("CertificateFactory.X.509", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory");
            mcElieceKeyFactorySpi.init("Alg.Alias.CertificateFactory.X509", "X.509");
        }
    }
}
