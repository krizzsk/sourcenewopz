package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.McElieceKeyFactorySpi;
import com.cardinalcommerce.p060a.RainbowKeyFactorySpi;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.GM */
public class C2142GM {

    /* renamed from: a */
    private static final Map<String, String> f3140a;

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.GM$Mappings */
    public static class Mappings extends RainbowKeyFactorySpi {
        public final void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi) {
            mcElieceKeyFactorySpi.init("Signature.SHA256WITHSM2", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi$sha256WithSM2");
            StringBuilder sb = new StringBuilder("Alg.Alias.Signature.");
            sb.append(KeyAgreementSpi.DHwithSHA224KDF.setRequestTimeout);
            mcElieceKeyFactorySpi.init(sb.toString(), "SHA256WITHSM2");
            mcElieceKeyFactorySpi.init("Signature.SM3WITHSM2", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi$sm3WithSM2");
            StringBuilder sb2 = new StringBuilder("Alg.Alias.Signature.");
            sb2.append(KeyAgreementSpi.DHwithSHA224KDF.getRequestTimeout);
            mcElieceKeyFactorySpi.init(sb2.toString(), "SM3WITHSM2");
            mcElieceKeyFactorySpi.init("Cipher.SM2", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2");
            mcElieceKeyFactorySpi.init("Alg.Alias.Cipher.SM2WITHSM3", "SM2");
            StringBuilder sb3 = new StringBuilder("Alg.Alias.Cipher.");
            sb3.append(KeyAgreementSpi.DHwithSHA224KDF.cca_continue);
            mcElieceKeyFactorySpi.init(sb3.toString(), "SM2");
            mcElieceKeyFactorySpi.init("Cipher.SM2WITHBLAKE2B", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withBlake2b");
            StringBuilder sb4 = new StringBuilder("Alg.Alias.Cipher.");
            sb4.append(KeyAgreementSpi.DHwithSHA224KDF.CardinalActionCode);
            mcElieceKeyFactorySpi.init(sb4.toString(), "SM2WITHBLAKE2B");
            mcElieceKeyFactorySpi.init("Cipher.SM2WITHBLAKE2S", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withBlake2s");
            StringBuilder sb5 = new StringBuilder("Alg.Alias.Cipher.");
            sb5.append(KeyAgreementSpi.DHwithSHA224KDF.CardinalUiType);
            mcElieceKeyFactorySpi.init(sb5.toString(), "SM2WITHBLAKE2S");
            mcElieceKeyFactorySpi.init("Cipher.SM2WITHWHIRLPOOL", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withWhirlpool");
            StringBuilder sb6 = new StringBuilder("Alg.Alias.Cipher.");
            sb6.append(KeyAgreementSpi.DHwithSHA224KDF.CardinalEnvironment);
            mcElieceKeyFactorySpi.init(sb6.toString(), "SM2WITHWHIRLPOOL");
            mcElieceKeyFactorySpi.init("Cipher.SM2WITHMD5", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withMD5");
            StringBuilder sb7 = new StringBuilder("Alg.Alias.Cipher.");
            sb7.append(KeyAgreementSpi.DHwithSHA224KDF.valueOf);
            mcElieceKeyFactorySpi.init(sb7.toString(), "SM2WITHMD5");
            mcElieceKeyFactorySpi.init("Cipher.SM2WITHRIPEMD160", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withRMD");
            StringBuilder sb8 = new StringBuilder("Alg.Alias.Cipher.");
            sb8.append(KeyAgreementSpi.DHwithSHA224KDF.CardinalRenderType);
            mcElieceKeyFactorySpi.init(sb8.toString(), "SM2WITHRIPEMD160");
            mcElieceKeyFactorySpi.init("Cipher.SM2WITHSHA1", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha1");
            StringBuilder sb9 = new StringBuilder("Alg.Alias.Cipher.");
            sb9.append(KeyAgreementSpi.DHwithSHA224KDF.getWarnings);
            mcElieceKeyFactorySpi.init(sb9.toString(), "SM2WITHSHA1");
            mcElieceKeyFactorySpi.init("Cipher.SM2WITHSHA224", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha224");
            StringBuilder sb10 = new StringBuilder("Alg.Alias.Cipher.");
            sb10.append(KeyAgreementSpi.DHwithSHA224KDF.getSDKVersion);
            mcElieceKeyFactorySpi.init(sb10.toString(), "SM2WITHSHA224");
            mcElieceKeyFactorySpi.init("Cipher.SM2WITHSHA256", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha256");
            StringBuilder sb11 = new StringBuilder("Alg.Alias.Cipher.");
            sb11.append(KeyAgreementSpi.DHwithSHA224KDF.values);
            mcElieceKeyFactorySpi.init(sb11.toString(), "SM2WITHSHA256");
            mcElieceKeyFactorySpi.init("Cipher.SM2WITHSHA384", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha384");
            StringBuilder sb12 = new StringBuilder("Alg.Alias.Cipher.");
            sb12.append(KeyAgreementSpi.DHwithSHA224KDF.cleanup);
            mcElieceKeyFactorySpi.init(sb12.toString(), "SM2WITHSHA384");
            mcElieceKeyFactorySpi.init("Cipher.SM2WITHSHA512", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha512");
            StringBuilder sb13 = new StringBuilder("Alg.Alias.Cipher.");
            sb13.append(KeyAgreementSpi.DHwithSHA224KDF.CardinalError);
            mcElieceKeyFactorySpi.init(sb13.toString(), "SM2WITHSHA512");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f3140a = hashMap;
        hashMap.put("SupportedKeyClasses", "java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey");
        f3140a.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
