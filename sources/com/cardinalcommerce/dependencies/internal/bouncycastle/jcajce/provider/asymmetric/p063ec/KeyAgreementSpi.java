package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.p060a.BCECGOST3410PrivateKey;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ECDH;
import com.cardinalcommerce.p060a.ECDSAVerifier;
import com.cardinalcommerce.p060a.EncryptionMethod;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.JWEHeader;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.Payload;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.XMSSKeyFactorySpi;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi */
public class KeyAgreementSpi extends BaseAgreementSpi {
    private EncryptionMethod CardinalError;
    private BCRSAPublicKey cca_continue;
    private XMSSKeyFactorySpi cleanup;
    private String configure;
    private byte[] getSDKVersion;
    private Object values;

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DH */
    public static class C2147DH extends KeyAgreementSpi {
        public C2147DH() {
            super("ECDH", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) null);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHC */
    public static class DHC extends KeyAgreementSpi {
        public DHC() {
            super("ECDHC", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA384(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) null);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUC */
    public static class DHUC extends KeyAgreementSpi {
        public DHUC() {
            super("ECCDHU", new SignatureSpi.ecCVCDSA256(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) null);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithRIPEMD160KDF */
    public static class ECKAEGwithRIPEMD160KDF extends KeyAgreementSpi {
        public ECKAEGwithRIPEMD160KDF() {
            super("ECKAEGwithRIPEMD160KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecDetDSASha3_256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQV */
    public static class MQV extends KeyAgreementSpi {
        public MQV() {
            super("ECMQV", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) null);
        }
    }

    protected KeyAgreementSpi(String str, KeyAgreementSpi.ECKAEGwithSHA224KDF eCKAEGwithSHA224KDF, KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo mQVwithSHA224KDFAndSharedInfo) {
        super(str, mQVwithSHA224KDFAndSharedInfo);
        this.configure = str;
        this.values = eCKAEGwithSHA224KDF;
    }

    protected KeyAgreementSpi(String str, SignatureSpi.ecCVCDSA256 eccvcdsa256, KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo mQVwithSHA224KDFAndSharedInfo) {
        super(str, mQVwithSHA224KDFAndSharedInfo);
        this.configure = str;
        this.values = eccvcdsa256;
    }

    public final byte[] Cardinal() {
        return setForegroundTintBlendMode.cca_continue(this.getSDKVersion);
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            getInstance(key, (AlgorithmParameterSpec) null);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null || (algorithmParameterSpec instanceof EncryptionMethod) || (algorithmParameterSpec instanceof JWEHeader) || (algorithmParameterSpec instanceof XMSSKeyFactorySpi)) {
            getInstance(key, algorithmParameterSpec);
            return;
        }
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA1KDFAndSharedInfo */
    public static class CDHwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA1KDFAndSharedInfo() {
            super("ECCDHwithSHA1KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA384(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA224KDFAndSharedInfo */
    public static class CDHwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA224KDFAndSharedInfo() {
            super("ECCDHwithSHA224KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA384(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA256KDFAndSharedInfo */
    public static class CDHwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA256KDFAndSharedInfo() {
            super("ECCDHwithSHA256KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA384(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA384KDFAndSharedInfo */
    public static class CDHwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA384KDFAndSharedInfo() {
            super("ECCDHwithSHA384KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA384(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo */
    public static class CDHwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public CDHwithSHA512KDFAndSharedInfo() {
            super("ECCDHwithSHA512KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA384(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA1CKDF */
    public static class DHUwithSHA1CKDF extends KeyAgreementSpi {
        public DHUwithSHA1CKDF() {
            super("ECCDHUwithSHA1CKDF", new SignatureSpi.ecCVCDSA256(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA1KDF */
    public static class DHUwithSHA1KDF extends KeyAgreementSpi {
        public DHUwithSHA1KDF() {
            super("ECCDHUwithSHA1KDF", new SignatureSpi.ecCVCDSA256(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA224CKDF */
    public static class DHUwithSHA224CKDF extends KeyAgreementSpi {
        public DHUwithSHA224CKDF() {
            super("ECCDHUwithSHA224CKDF", new SignatureSpi.ecCVCDSA256(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA224KDF */
    public static class DHUwithSHA224KDF extends KeyAgreementSpi {
        public DHUwithSHA224KDF() {
            super("ECCDHUwithSHA224KDF", new SignatureSpi.ecCVCDSA256(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA256CKDF */
    public static class DHUwithSHA256CKDF extends KeyAgreementSpi {
        public DHUwithSHA256CKDF() {
            super("ECCDHUwithSHA256CKDF", new SignatureSpi.ecCVCDSA256(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA256KDF */
    public static class DHUwithSHA256KDF extends KeyAgreementSpi {
        public DHUwithSHA256KDF() {
            super("ECCDHUwithSHA256KDF", new SignatureSpi.ecCVCDSA256(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA384CKDF */
    public static class DHUwithSHA384CKDF extends KeyAgreementSpi {
        public DHUwithSHA384CKDF() {
            super("ECCDHUwithSHA384CKDF", new SignatureSpi.ecCVCDSA256(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA384KDF */
    public static class DHUwithSHA384KDF extends KeyAgreementSpi {
        public DHUwithSHA384KDF() {
            super("ECCDHUwithSHA384KDF", new SignatureSpi.ecCVCDSA256(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA512CKDF */
    public static class DHUwithSHA512CKDF extends KeyAgreementSpi {
        public DHUwithSHA512CKDF() {
            super("ECCDHUwithSHA512CKDF", new SignatureSpi.ecCVCDSA256(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA512KDF */
    public static class DHUwithSHA512KDF extends KeyAgreementSpi {
        public DHUwithSHA512KDF() {
            super("ECCDHUwithSHA512KDF", new SignatureSpi.ecCVCDSA256(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1CKDF */
    public static class DHwithSHA1CKDF extends KeyAgreementSpi {
        public DHwithSHA1CKDF() {
            super("ECDHwithSHA1CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA384(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDF */
    public static class DHwithSHA1KDF extends KeyAgreementSpi {
        public DHwithSHA1KDF() {
            super("ECDHwithSHA1KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDFAndSharedInfo */
    public static class DHwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA1KDFAndSharedInfo() {
            super("ECDHwithSHA1KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo */
    public static class DHwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA224KDFAndSharedInfo() {
            super("ECDHwithSHA224KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA256CKDF */
    public static class DHwithSHA256CKDF extends KeyAgreementSpi {
        public DHwithSHA256CKDF() {
            super("ECDHwithSHA256CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA384(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA256KDFAndSharedInfo */
    public static class DHwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA256KDFAndSharedInfo() {
            super("ECDHwithSHA256KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA384CKDF */
    public static class DHwithSHA384CKDF extends KeyAgreementSpi {
        public DHwithSHA384CKDF() {
            super("ECDHwithSHA384CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA384(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA384KDFAndSharedInfo */
    public static class DHwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA384KDFAndSharedInfo() {
            super("ECDHwithSHA384KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA512CKDF */
    public static class DHwithSHA512CKDF extends KeyAgreementSpi {
        public DHwithSHA512CKDF() {
            super("ECDHwithSHA512CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA384(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA512KDFAndSharedInfo */
    public static class DHwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public DHwithSHA512KDFAndSharedInfo() {
            super("ECDHwithSHA512KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA1KDF */
    public static class ECKAEGwithSHA1KDF extends KeyAgreementSpi {
        public ECKAEGwithSHA1KDF() {
            super("ECKAEGwithSHA1KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA224KDF */
    public static class ECKAEGwithSHA224KDF extends KeyAgreementSpi {
        public ECKAEGwithSHA224KDF() {
            super("ECKAEGwithSHA224KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA256KDF */
    public static class ECKAEGwithSHA256KDF extends KeyAgreementSpi {
        public ECKAEGwithSHA256KDF() {
            super("ECKAEGwithSHA256KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA384KDF */
    public static class ECKAEGwithSHA384KDF extends KeyAgreementSpi {
        public ECKAEGwithSHA384KDF() {
            super("ECKAEGwithSHA384KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$ECKAEGwithSHA512KDF */
    public static class ECKAEGwithSHA512KDF extends KeyAgreementSpi {
        public ECKAEGwithSHA512KDF() {
            super("ECKAEGwithSHA512KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new KeyPairGeneratorSpi.ECMQV(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1CKDF */
    public static class MQVwithSHA1CKDF extends KeyAgreementSpi {
        public MQVwithSHA1CKDF() {
            super("ECMQVwithSHA1CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1KDF */
    public static class MQVwithSHA1KDF extends KeyAgreementSpi {
        public MQVwithSHA1KDF() {
            super("ECMQVwithSHA1KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1KDFAndSharedInfo */
    public static class MQVwithSHA1KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA1KDFAndSharedInfo() {
            super("ECMQVwithSHA1KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA224CKDF */
    public static class MQVwithSHA224CKDF extends KeyAgreementSpi {
        public MQVwithSHA224CKDF() {
            super("ECMQVwithSHA224CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA224KDF */
    public static class MQVwithSHA224KDF extends KeyAgreementSpi {
        public MQVwithSHA224KDF() {
            super("ECMQVwithSHA224KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA224KDFAndSharedInfo */
    public static class MQVwithSHA224KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA224KDFAndSharedInfo() {
            super("ECMQVwithSHA224KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA256CKDF */
    public static class MQVwithSHA256CKDF extends KeyAgreementSpi {
        public MQVwithSHA256CKDF() {
            super("ECMQVwithSHA256CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA256KDF */
    public static class MQVwithSHA256KDF extends KeyAgreementSpi {
        public MQVwithSHA256KDF() {
            super("ECMQVwithSHA256KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA256KDFAndSharedInfo */
    public static class MQVwithSHA256KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA256KDFAndSharedInfo() {
            super("ECMQVwithSHA256KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA384CKDF */
    public static class MQVwithSHA384CKDF extends KeyAgreementSpi {
        public MQVwithSHA384CKDF() {
            super("ECMQVwithSHA384CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA384KDF */
    public static class MQVwithSHA384KDF extends KeyAgreementSpi {
        public MQVwithSHA384KDF() {
            super("ECMQVwithSHA384KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA384KDFAndSharedInfo */
    public static class MQVwithSHA384KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA384KDFAndSharedInfo() {
            super("ECMQVwithSHA384KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA512CKDF */
    public static class MQVwithSHA512CKDF extends KeyAgreementSpi {
        public MQVwithSHA512CKDF() {
            super("ECMQVwithSHA512CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA512KDF */
    public static class MQVwithSHA512KDF extends KeyAgreementSpi {
        public MQVwithSHA512KDF() {
            super("ECMQVwithSHA512KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo */
    public static class MQVwithSHA512KDFAndSharedInfo extends KeyAgreementSpi {
        public MQVwithSHA512KDFAndSharedInfo() {
            super("ECMQVwithSHA512KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecDSA(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new BCECGOST3410PrivateKey()));
        }
    }

    private byte[] configure(BigInteger bigInteger) {
        return KeyAgreementSpi.DHwithSHA256KDFAndSharedInfo.configure(bigInteger, (this.cca_continue.Cardinal.configure() + 7) / 8);
    }

    /* access modifiers changed from: protected */
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF;
        KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        if (this.cca_continue == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.configure);
            sb.append(" not initialised.");
            throw new IllegalStateException(sb.toString());
        } else if (z) {
            Object obj5 = this.values;
            if (obj5 instanceof SignatureSpi.ecDSA) {
                if (!(key instanceof ECDH)) {
                    PublicKey publicKey = (PublicKey) key;
                    if (publicKey instanceof BCECPublicKey) {
                        obj4 = ((BCECPublicKey) publicKey).configure;
                    } else {
                        obj4 = ECUtil.Cardinal(publicKey);
                    }
                    eCKAEGwithSHA512KDF = new ISOSignatureSpi.SHA512_224WithRSAEncryption((DigestSignatureSpi) obj4, (DigestSignatureSpi) ECUtil.Cardinal((PublicKey) null));
                } else {
                    ECDH ecdh = (ECDH) key;
                    PublicKey instance = ecdh.getInstance();
                    if (instance instanceof BCECPublicKey) {
                        obj2 = ((BCECPublicKey) instance).configure;
                    } else {
                        obj2 = ECUtil.Cardinal(instance);
                    }
                    DigestSignatureSpi digestSignatureSpi = (DigestSignatureSpi) obj2;
                    PublicKey Cardinal = ecdh.Cardinal();
                    if (Cardinal instanceof BCECPublicKey) {
                        obj3 = ((BCECPublicKey) Cardinal).configure;
                    } else {
                        obj3 = ECUtil.Cardinal(Cardinal);
                    }
                    eCKAEGwithSHA512KDF = new ISOSignatureSpi.SHA512_224WithRSAEncryption(digestSignatureSpi, (DigestSignatureSpi) obj3);
                }
            } else if (obj5 instanceof SignatureSpi.ecCVCDSA256) {
                PublicKey publicKey2 = (PublicKey) key;
                if (publicKey2 instanceof BCECPublicKey) {
                    obj = ((BCECPublicKey) publicKey2).configure;
                } else {
                    obj = ECUtil.Cardinal(publicKey2);
                }
                eCKAEGwithSHA512KDF = new KeyAgreementSpi.DHwithSHA256KDFAndSharedInfo((DigestSignatureSpi) obj, (DigestSignatureSpi) ECUtil.Cardinal((PublicKey) null));
            } else if (key instanceof PublicKey) {
                PublicKey publicKey3 = (PublicKey) key;
                if (publicKey3 instanceof BCECPublicKey) {
                    eCKAEGwithSHA512KDF2 = ((BCECPublicKey) publicKey3).configure;
                } else {
                    eCKAEGwithSHA512KDF2 = ECUtil.Cardinal(publicKey3);
                }
                eCKAEGwithSHA512KDF = eCKAEGwithSHA512KDF2;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.configure);
                sb2.append(" key agreement requires ");
                String name = ECDSAVerifier.class.getName();
                sb2.append(name.substring(name.lastIndexOf(46) + 1));
                sb2.append(" for doPhase");
                throw new InvalidKeyException(sb2.toString());
            }
            try {
                if (this.values instanceof KeyAgreementSpi.ECKAEGwithSHA224KDF) {
                    this.getSDKVersion = configure(((KeyAgreementSpi.ECKAEGwithSHA224KDF) this.values).Cardinal(eCKAEGwithSHA512KDF));
                } else {
                    this.getSDKVersion = ((SignatureSpi.ecCVCDSA256) this.values).init(eCKAEGwithSHA512KDF);
                }
                return null;
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder("calculation failed: ");
                sb3.append(e.getMessage());
                throw new InvalidKeyException(sb3.toString()) {
                    public final Throwable getCause() {
                        return e;
                    }
                };
            }
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.configure);
            sb4.append(" can only be between two parties.");
            throw new IllegalStateException(sb4.toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.cardinalcommerce.a.DigestSignatureSpi} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getInstance(java.security.Key r7, java.security.spec.AlgorithmParameterSpec r8) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r6 = this;
            java.lang.Object r0 = r6.values
            boolean r1 = r0 instanceof com.cardinalcommerce.p060a.SignatureSpi.ecDSA
            java.lang.String r2 = " for initialisation"
            java.lang.String r3 = " key agreement requires "
            r4 = 46
            r5 = 0
            if (r1 == 0) goto L_0x00a3
            r6.CardinalError = r5
            boolean r0 = r7 instanceof com.cardinalcommerce.p060a.ConcatKDF
            if (r0 != 0) goto L_0x0045
            boolean r1 = r8 instanceof com.cardinalcommerce.p060a.EncryptionMethod
            if (r1 == 0) goto L_0x0018
            goto L_0x0045
        L_0x0018:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = r6.configure
            r8.append(r0)
            r8.append(r3)
            java.lang.Class<com.cardinalcommerce.a.EncryptionMethod> r0 = com.cardinalcommerce.p060a.EncryptionMethod.class
            java.lang.String r0 = r0.getName()
            int r1 = r0.lastIndexOf(r4)
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0045:
            if (r0 == 0) goto L_0x0078
            com.cardinalcommerce.a.ConcatKDF r7 = (com.cardinalcommerce.p060a.ConcatKDF) r7
            java.security.PrivateKey r8 = r7.configure()
            com.cardinalcommerce.a.setKeyboardNavigationCluster r8 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getInstance((java.security.PrivateKey) r8)
            com.cardinalcommerce.a.DigestSignatureSpi$MD2 r8 = (com.cardinalcommerce.p060a.DigestSignatureSpi.MD2) r8
            java.security.PrivateKey r0 = r7.init()
            com.cardinalcommerce.a.setKeyboardNavigationCluster r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getInstance((java.security.PrivateKey) r0)
            com.cardinalcommerce.a.DigestSignatureSpi$MD2 r0 = (com.cardinalcommerce.p060a.DigestSignatureSpi.MD2) r0
            java.security.PublicKey r1 = r7.getInstance()
            if (r1 == 0) goto L_0x0091
            java.security.PublicKey r7 = r7.getInstance()
            boolean r1 = r7 instanceof com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec.BCECPublicKey
            if (r1 == 0) goto L_0x0070
            com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey r7 = (com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec.BCECPublicKey) r7
            com.cardinalcommerce.a.DigestSignatureSpi r7 = r7.configure
            goto L_0x0074
        L_0x0070:
            com.cardinalcommerce.a.setKeyboardNavigationCluster r7 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.Cardinal(r7)
        L_0x0074:
            com.cardinalcommerce.a.DigestSignatureSpi r7 = (com.cardinalcommerce.p060a.DigestSignatureSpi) r7
            r5 = r7
            goto L_0x0091
        L_0x0078:
            com.cardinalcommerce.a.EncryptionMethod r8 = (com.cardinalcommerce.p060a.EncryptionMethod) r8
            java.security.PrivateKey r7 = (java.security.PrivateKey) r7
            com.cardinalcommerce.a.setKeyboardNavigationCluster r7 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getInstance((java.security.PrivateKey) r7)
            com.cardinalcommerce.a.DigestSignatureSpi$MD2 r7 = (com.cardinalcommerce.p060a.DigestSignatureSpi.MD2) r7
            com.cardinalcommerce.a.setKeyboardNavigationCluster r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getInstance((java.security.PrivateKey) r5)
            com.cardinalcommerce.a.DigestSignatureSpi$MD2 r0 = (com.cardinalcommerce.p060a.DigestSignatureSpi.MD2) r0
            r6.CardinalError = r8
            byte[] r8 = com.cardinalcommerce.p060a.EncryptionMethod.Cardinal()
            r6.getInstance = r8
            r8 = r7
        L_0x0091:
            com.cardinalcommerce.a.ISOSignatureSpi$SHA256WithRSAEncryption r7 = new com.cardinalcommerce.a.ISOSignatureSpi$SHA256WithRSAEncryption
            r7.<init>(r8, r0, r5)
            com.cardinalcommerce.a.BCRSAPublicKey r8 = r8.init
            r6.cca_continue = r8
            java.lang.Object r8 = r6.values
            com.cardinalcommerce.a.SignatureSpi$ecDSA r8 = (com.cardinalcommerce.p060a.SignatureSpi.ecDSA) r8
            com.cardinalcommerce.a.ISOSignatureSpi$SHA256WithRSAEncryption r7 = (com.cardinalcommerce.p060a.ISOSignatureSpi.SHA256WithRSAEncryption) r7
            r8.getInstance = r7
            return
        L_0x00a3:
            boolean r1 = r8 instanceof com.cardinalcommerce.p060a.XMSSKeyFactorySpi
            if (r1 == 0) goto L_0x0101
            boolean r0 = r0 instanceof com.cardinalcommerce.p060a.SignatureSpi.ecCVCDSA256
            if (r0 == 0) goto L_0x00d5
            com.cardinalcommerce.a.XMSSKeyFactorySpi r8 = (com.cardinalcommerce.p060a.XMSSKeyFactorySpi) r8
            java.security.PrivateKey r7 = (java.security.PrivateKey) r7
            com.cardinalcommerce.a.setKeyboardNavigationCluster r7 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getInstance((java.security.PrivateKey) r7)
            com.cardinalcommerce.a.DigestSignatureSpi$MD2 r7 = (com.cardinalcommerce.p060a.DigestSignatureSpi.MD2) r7
            com.cardinalcommerce.a.setKeyboardNavigationCluster r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getInstance((java.security.PrivateKey) r5)
            com.cardinalcommerce.a.DigestSignatureSpi$MD2 r0 = (com.cardinalcommerce.p060a.DigestSignatureSpi.MD2) r0
            r6.cleanup = r8
            byte[] r8 = com.cardinalcommerce.p060a.XMSSKeyFactorySpi.cca_continue()
            r6.getInstance = r8
            com.cardinalcommerce.a.setTag r8 = new com.cardinalcommerce.a.setTag
            r8.<init>(r7, r0, r5)
            com.cardinalcommerce.a.BCRSAPublicKey r7 = r7.init
            r6.cca_continue = r7
            java.lang.Object r7 = r6.values
            com.cardinalcommerce.a.SignatureSpi$ecCVCDSA256 r7 = (com.cardinalcommerce.p060a.SignatureSpi.ecCVCDSA256) r7
            com.cardinalcommerce.a.setTag r8 = (com.cardinalcommerce.p060a.setTag) r8
            r7.getInstance = r8
            return
        L_0x00d5:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = r6.configure
            r8.append(r0)
            java.lang.String r0 = " key agreement cannot be used with "
            r8.append(r0)
            java.lang.Class<com.cardinalcommerce.a.XMSSKeyFactorySpi> r0 = com.cardinalcommerce.p060a.XMSSKeyFactorySpi.class
            java.lang.String r0 = r0.getName()
            int r1 = r0.lastIndexOf(r4)
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0101:
            boolean r0 = r7 instanceof java.security.PrivateKey
            if (r0 == 0) goto L_0x0134
            com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA224KDFAndSharedInfo r0 = r6.Cardinal
            if (r0 != 0) goto L_0x0116
            boolean r0 = r8 instanceof com.cardinalcommerce.p060a.JWEHeader
            if (r0 != 0) goto L_0x010e
            goto L_0x0116
        L_0x010e:
            java.security.InvalidAlgorithmParameterException r7 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r8 = "no KDF specified for UserKeyingMaterialSpec"
            r7.<init>(r8)
            throw r7
        L_0x0116:
            java.security.PrivateKey r7 = (java.security.PrivateKey) r7
            com.cardinalcommerce.a.setKeyboardNavigationCluster r7 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getInstance((java.security.PrivateKey) r7)
            com.cardinalcommerce.a.DigestSignatureSpi$MD2 r7 = (com.cardinalcommerce.p060a.DigestSignatureSpi.MD2) r7
            com.cardinalcommerce.a.BCRSAPublicKey r0 = r7.init
            r6.cca_continue = r0
            boolean r8 = r8 instanceof com.cardinalcommerce.p060a.JWEHeader
            if (r8 == 0) goto L_0x012a
            byte[] r5 = com.cardinalcommerce.p060a.JWEHeader.configure()
        L_0x012a:
            r6.getInstance = r5
            java.lang.Object r8 = r6.values
            com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA224KDF r8 = (com.cardinalcommerce.p060a.KeyAgreementSpi.ECKAEGwithSHA224KDF) r8
            r8.configure(r7)
            return
        L_0x0134:
            java.security.InvalidKeyException r7 = new java.security.InvalidKeyException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = r6.configure
            r8.append(r0)
            r8.append(r3)
            java.lang.Class<com.cardinalcommerce.a.KeyLengthException> r0 = com.cardinalcommerce.p060a.KeyLengthException.class
            java.lang.String r0 = r0.getName()
            int r1 = r0.lastIndexOf(r4)
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec.KeyAgreementSpi.getInstance(java.security.Key, java.security.spec.AlgorithmParameterSpec):void");
    }
}
