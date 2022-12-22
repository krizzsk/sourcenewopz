package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSAUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.McElieceKeyFactorySpi;
import com.cardinalcommerce.p060a.RainbowKeyFactorySpi;

public class DSA {

    public static class Mappings extends RainbowKeyFactorySpi {
        public final void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi) {
            mcElieceKeyFactorySpi.init("AlgorithmParameters.DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.AlgorithmParametersSpi");
            mcElieceKeyFactorySpi.init("AlgorithmParameterGenerator.DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.AlgorithmParameterGeneratorSpi");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.KeyPairGeneratorSpi");
            mcElieceKeyFactorySpi.init("KeyFactory.DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi");
            mcElieceKeyFactorySpi.init("Signature.DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$stdDSA");
            mcElieceKeyFactorySpi.init("Signature.NONEWITHDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$noneDSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.RAWDSA", "NONEWITHDSA");
            mcElieceKeyFactorySpi.init("Signature.DETDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            mcElieceKeyFactorySpi.init("Signature.SHA1WITHDETDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            mcElieceKeyFactorySpi.init("Signature.SHA224WITHDETDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
            mcElieceKeyFactorySpi.init("Signature.SHA256WITHDETDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
            mcElieceKeyFactorySpi.init("Signature.SHA384WITHDETDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
            mcElieceKeyFactorySpi.init("Signature.SHA512WITHDETDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
            mcElieceKeyFactorySpi.init("Signature.DDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            mcElieceKeyFactorySpi.init("Signature.SHA1WITHDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            mcElieceKeyFactorySpi.init("Signature.SHA224WITHDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
            mcElieceKeyFactorySpi.init("Signature.SHA256WITHDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
            mcElieceKeyFactorySpi.init("Signature.SHA384WITHDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
            mcElieceKeyFactorySpi.init("Signature.SHA512WITHDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
            mcElieceKeyFactorySpi.init("Signature.SHA3-224WITHDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_224");
            mcElieceKeyFactorySpi.init("Signature.SHA3-256WITHDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_256");
            mcElieceKeyFactorySpi.init("Signature.SHA3-384WITHDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_384");
            mcElieceKeyFactorySpi.init("Signature.SHA3-512WITHDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_512");
            cca_continue(mcElieceKeyFactorySpi, "SHA224", "DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa224", KeyAgreementSpi.MQVwithSHA224KDF.isEnableLogging);
            cca_continue(mcElieceKeyFactorySpi, "SHA256", "DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa256", KeyAgreementSpi.MQVwithSHA224KDF.setEnableLogging);
            cca_continue(mcElieceKeyFactorySpi, "SHA384", "DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa384", KeyAgreementSpi.MQVwithSHA224KDF.isLocationDataConsentGiven);
            cca_continue(mcElieceKeyFactorySpi, "SHA512", "DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa512", KeyAgreementSpi.MQVwithSHA224KDF.getExtendedData);
            cca_continue(mcElieceKeyFactorySpi, "SHA3-224", "DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_224", KeyAgreementSpi.MQVwithSHA224KDF.getType);
            cca_continue(mcElieceKeyFactorySpi, "SHA3-256", "DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_256", KeyAgreementSpi.MQVwithSHA224KDF.getProcessorTransactionId);
            cca_continue(mcElieceKeyFactorySpi, "SHA3-384", "DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_384", KeyAgreementSpi.MQVwithSHA224KDF.Payment);
            cca_continue(mcElieceKeyFactorySpi, "SHA3-512", "DSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_512", KeyAgreementSpi.MQVwithSHA224KDF.getJSON);
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.SHA/DSA", "DSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.SHA1withDSA", "DSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.SHA1WITHDSA", "DSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.1", "DSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.3", "DSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.DSAwithSHA1", "DSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.DSAWITHSHA1", "DSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.SHA1WithDSA", "DSA");
            mcElieceKeyFactorySpi.init("Alg.Alias.Signature.DSAWithSHA1", "DSA");
            KeyFactorySpi keyFactorySpi = new KeyFactorySpi();
            for (int i = 0; i != DSAUtil.configure.length; i++) {
                StringBuilder sb = new StringBuilder("Alg.Alias.Signature.");
                sb.append(DSAUtil.configure[i]);
                mcElieceKeyFactorySpi.init(sb.toString(), "DSA");
                configure(mcElieceKeyFactorySpi, DSAUtil.configure[i], "DSA", keyFactorySpi);
                getInstance(mcElieceKeyFactorySpi, DSAUtil.configure[i], "DSA");
            }
        }
    }
}
