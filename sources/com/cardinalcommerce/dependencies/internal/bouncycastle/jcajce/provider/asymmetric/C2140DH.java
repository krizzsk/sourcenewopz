package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.McElieceKeyFactorySpi;
import com.cardinalcommerce.p060a.RainbowKeyFactorySpi;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.DH */
public class C2140DH {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Map<String, String> f3137a;

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.DH$Mappings */
    public static class Mappings extends RainbowKeyFactorySpi {
        public final void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi) {
            mcElieceKeyFactorySpi.init("KeyPairGenerator.DH", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyPairGeneratorSpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyPairGenerator.DIFFIEHELLMAN", "DH");
            mcElieceKeyFactorySpi.init("KeyAgreement.DH", (Map<String, String>) C2140DH.f3137a);
            mcElieceKeyFactorySpi.init("KeyAgreement.DH", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyAgreement.DIFFIEHELLMAN", "DH");
            mcElieceKeyFactorySpi.cca_continue("KeyAgreement", KeyFactorySpi.getErrorNumber, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithRFC2631KDF");
            mcElieceKeyFactorySpi.cca_continue("KeyAgreement", KeyFactorySpi.isValidated, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithRFC2631KDF");
            mcElieceKeyFactorySpi.init("KeyFactory.DH", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyFactorySpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.KeyFactory.DIFFIEHELLMAN", "DH");
            mcElieceKeyFactorySpi.init("AlgorithmParameters.DH", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.AlgorithmParametersSpi");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameters.DIFFIEHELLMAN", "DH");
            mcElieceKeyFactorySpi.init("Alg.Alias.AlgorithmParameterGenerator.DIFFIEHELLMAN", "DH");
            mcElieceKeyFactorySpi.init("AlgorithmParameterGenerator.DH", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.AlgorithmParameterGeneratorSpi");
            mcElieceKeyFactorySpi.init("Cipher.IES", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IES");
            mcElieceKeyFactorySpi.init("Cipher.IESwithAES-CBC", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            mcElieceKeyFactorySpi.init("Cipher.IESWITHAES-CBC", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            mcElieceKeyFactorySpi.init("Cipher.IESWITHDESEDE-CBC", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithDESedeCBC");
            mcElieceKeyFactorySpi.init("Cipher.DHIES", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IES");
            mcElieceKeyFactorySpi.init("Cipher.DHIESwithAES-CBC", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            mcElieceKeyFactorySpi.init("Cipher.DHIESWITHAES-CBC", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            mcElieceKeyFactorySpi.init("Cipher.DHIESWITHDESEDE-CBC", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithDESedeCBC");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHWITHSHA1KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA1KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHWITHSHA224KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA224KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHWITHSHA256KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA256KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHWITHSHA384KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA384KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHWITHSHA512KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA512KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHUWITHSHA1KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA1KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHUWITHSHA224KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA224KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHUWITHSHA256KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA256KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHUWITHSHA384KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA384KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHUWITHSHA512KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA512KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHUWITHSHA1CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA1CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHUWITHSHA224CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA224CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHUWITHSHA256CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA256CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHUWITHSHA384CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA384CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.DHUWITHSHA512CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA512CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.MQVWITHSHA1KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA1KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.MQVWITHSHA224KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA224KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.MQVWITHSHA256KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA256KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.MQVWITHSHA384KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA384KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.MQVWITHSHA512KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA512KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.MQVWITHSHA1CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA1CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.MQVWITHSHA224CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA224CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.MQVWITHSHA256CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA256CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.MQVWITHSHA384CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA384CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.MQVWITHSHA512CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA512CKDF");
            configure(mcElieceKeyFactorySpi, KeyFactorySpi.setRequestTimeout, "DH", new com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p062dh.KeyFactorySpi());
            configure(mcElieceKeyFactorySpi, KeyAgreementSpi.ECKAEGwithSHA1KDF.onSetupCompleted, "DH", new com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p062dh.KeyFactorySpi());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f3137a = hashMap;
        hashMap.put("SupportedKeyClasses", "javax.crypto.interfaces.DHPublicKey|javax.crypto.interfaces.DHPrivateKey");
        f3137a.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
