package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.McElieceKeyFactorySpi;
import com.cardinalcommerce.p060a.RainbowKeyFactorySpi;
import java.util.HashMap;
import java.util.Map;

public class EdEC {

    /* renamed from: a */
    private static final Map<String, String> f3139a;

    public static class Mappings extends RainbowKeyFactorySpi {
        public final void init(McElieceKeyFactorySpi mcElieceKeyFactorySpi) {
            mcElieceKeyFactorySpi.init("KeyFactory.XDH", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$XDH");
            mcElieceKeyFactorySpi.init("KeyFactory.X448", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$X448");
            mcElieceKeyFactorySpi.init("KeyFactory.X25519", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$X25519");
            mcElieceKeyFactorySpi.init("KeyFactory.EDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$EDDSA");
            mcElieceKeyFactorySpi.init("KeyFactory.ED448", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$ED448");
            mcElieceKeyFactorySpi.init("KeyFactory.ED25519", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$ED25519");
            mcElieceKeyFactorySpi.init("Signature.EDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$EdDSA");
            mcElieceKeyFactorySpi.init("Signature.ED448", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$Ed448");
            mcElieceKeyFactorySpi.init("Signature.ED25519", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$Ed25519");
            mcElieceKeyFactorySpi.cca_continue("Signature", KeyAgreementSpi.DHwithSHA256CKDF.init, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$Ed448");
            mcElieceKeyFactorySpi.cca_continue("Signature", KeyAgreementSpi.DHwithSHA256CKDF.Cardinal, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$Ed25519");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.EDDSA", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$EdDSA");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.ED448", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed448");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.ED25519", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed25519");
            mcElieceKeyFactorySpi.cca_continue("KeyPairGenerator", KeyAgreementSpi.DHwithSHA256CKDF.init, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed448");
            mcElieceKeyFactorySpi.cca_continue("KeyPairGenerator", KeyAgreementSpi.DHwithSHA256CKDF.Cardinal, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed25519");
            mcElieceKeyFactorySpi.init("KeyAgreement.XDH", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$XDH");
            mcElieceKeyFactorySpi.init("KeyAgreement.X448", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448");
            mcElieceKeyFactorySpi.init("KeyAgreement.X25519", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519");
            mcElieceKeyFactorySpi.cca_continue("KeyAgreement", KeyAgreementSpi.DHwithSHA256CKDF.configure, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448");
            mcElieceKeyFactorySpi.cca_continue("KeyAgreement", KeyAgreementSpi.DHwithSHA256CKDF.cca_continue, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519");
            mcElieceKeyFactorySpi.init("KeyAgreement.X25519WITHSHA256CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA256CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.X25519WITHSHA384CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA384CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.X25519WITHSHA512CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA512CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.X448WITHSHA256CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA256CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.X448WITHSHA384CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA384CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.X448WITHSHA512CKDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA512CKDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.X25519WITHSHA256KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA256KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.X448WITHSHA512KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA512KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.X25519UWITHSHA256KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519UwithSHA256KDF");
            mcElieceKeyFactorySpi.init("KeyAgreement.X448UWITHSHA512KDF", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448UwithSHA512KDF");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.XDH", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$XDH");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.X448", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X448");
            mcElieceKeyFactorySpi.init("KeyPairGenerator.X25519", "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X25519");
            mcElieceKeyFactorySpi.cca_continue("KeyPairGenerator", KeyAgreementSpi.DHwithSHA256CKDF.configure, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpiSpi$X448");
            mcElieceKeyFactorySpi.cca_continue("KeyPairGenerator", KeyAgreementSpi.DHwithSHA256CKDF.cca_continue, "com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpiSpi$X25519");
            configure(mcElieceKeyFactorySpi, KeyAgreementSpi.DHwithSHA256CKDF.configure, "XDH", new KeyFactorySpi.X448());
            configure(mcElieceKeyFactorySpi, KeyAgreementSpi.DHwithSHA256CKDF.cca_continue, "XDH", new KeyFactorySpi.X25519());
            configure(mcElieceKeyFactorySpi, KeyAgreementSpi.DHwithSHA256CKDF.init, "EDDSA", new KeyFactorySpi.ED448());
            configure(mcElieceKeyFactorySpi, KeyAgreementSpi.DHwithSHA256CKDF.Cardinal, "EDDSA", new KeyFactorySpi.ED25519());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f3139a = hashMap;
        hashMap.put("SupportedKeyClasses", "java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey");
        f3139a.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
