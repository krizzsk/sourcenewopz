package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p062dh;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import com.cardinalcommerce.p060a.BCECGOST3410PrivateKey;
import com.cardinalcommerce.p060a.BCElGamalPublicKey;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.EncryptionMethod;
import com.cardinalcommerce.p060a.JWEHeader;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.Payload;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.Sphincs256KeyFactorySpi;
import com.cardinalcommerce.p060a.XMSSKeyFactorySpi;
import com.cardinalcommerce.p060a.setClipToOutline;
import com.cardinalcommerce.p060a.setScrollBarDefaultDelayBeforeFade;
import com.cardinalcommerce.p060a.setTransitionVisibility;
import com.cardinalcommerce.p060a.setVerticalFadingEdgeEnabled;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi */
public class KeyAgreementSpi extends BaseAgreementSpi {
    private static final BigInteger cca_continue = BigInteger.valueOf(2);
    private static final BigInteger configure = BigInteger.valueOf(1);
    private byte[] CardinalActionCode;
    private BigInteger CardinalEnvironment;
    private XMSSKeyFactorySpi CardinalError;
    private final SignatureSpi.ecCVCDSA224 cleanup;
    private final KeyAgreementSpi.ECKAEGwithSHA224KDF getSDKVersion;
    private BigInteger getWarnings;
    private BigInteger valueOf;
    private EncryptionMethod values;

    public KeyAgreementSpi() {
        this("Diffie-Hellman", (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) null);
    }

    public KeyAgreementSpi(String str, KeyAgreementSpi.ECKAEGwithSHA224KDF eCKAEGwithSHA224KDF, KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo mQVwithSHA224KDFAndSharedInfo) {
        super(str, mQVwithSHA224KDFAndSharedInfo);
        this.cleanup = null;
        this.getSDKVersion = eCKAEGwithSHA224KDF;
    }

    public KeyAgreementSpi(String str, KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo mQVwithSHA224KDFAndSharedInfo) {
        super(str, mQVwithSHA224KDFAndSharedInfo);
        this.cleanup = null;
        this.getSDKVersion = null;
    }

    public KeyAgreementSpi(String str, SignatureSpi.ecCVCDSA224 eccvcdsa224, KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo mQVwithSHA224KDFAndSharedInfo) {
        super(str, mQVwithSHA224KDFAndSharedInfo);
        this.cleanup = eccvcdsa224;
        this.getSDKVersion = null;
    }

    private byte[] Cardinal(BigInteger bigInteger) {
        int bitLength = (this.CardinalEnvironment.bitLength() + 7) / 8;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == bitLength) {
            return byteArray;
        }
        if (byteArray[0] == 0 && byteArray.length == bitLength + 1) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            return bArr;
        }
        byte[] bArr2 = new byte[bitLength];
        System.arraycopy(byteArray, 0, bArr2, bitLength - byteArray.length, byteArray.length);
        return bArr2;
    }

    private static BCElGamalPublicKey configure(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof DHPrivateKey)) {
            throw new InvalidKeyException("private key not a DHPrivateKey");
        } else if (privateKey instanceof BCDHPrivateKey) {
            return ((BCDHPrivateKey) privateKey).configure();
        } else {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) privateKey;
            DHParameterSpec params = dHPrivateKey.getParams();
            return new BCElGamalPublicKey(dHPrivateKey.getX(), new CipherSpi(params.getP(), params.getG(), params.getL()));
        }
    }

    public final byte[] Cardinal() {
        return this.CardinalActionCode;
    }

    public int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        if (this.getWarnings != null) {
            return super.engineGenerateSecret(bArr, i);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        if (this.getWarnings != null) {
            return str.equals("TlsPremasterSecret") ? new SecretKeySpec(getInstance(this.CardinalActionCode), str) : super.engineGenerateSecret(str);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.getWarnings != null) {
            return super.engineGenerateSecret();
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            this.CardinalEnvironment = dHPrivateKey.getParams().getP();
            this.valueOf = dHPrivateKey.getParams().getG();
            BigInteger x = dHPrivateKey.getX();
            this.getWarnings = x;
            this.CardinalActionCode = Cardinal(x);
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA1CKDF */
    public static class DHUwithSHA1CKDF extends KeyAgreementSpi {
        public DHUwithSHA1CKDF() {
            super("DHUwithSHA1CKDF", new SignatureSpi.ecCVCDSA224(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA1KDF */
    public static class DHUwithSHA1KDF extends KeyAgreementSpi {
        public DHUwithSHA1KDF() {
            super("DHUwithSHA1KDF", new SignatureSpi.ecCVCDSA224(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA224CKDF */
    public static class DHUwithSHA224CKDF extends KeyAgreementSpi {
        public DHUwithSHA224CKDF() {
            super("DHUwithSHA224CKDF", new SignatureSpi.ecCVCDSA224(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA224KDF */
    public static class DHUwithSHA224KDF extends KeyAgreementSpi {
        public DHUwithSHA224KDF() {
            super("DHUwithSHA224KDF", new SignatureSpi.ecCVCDSA224(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA256CKDF */
    public static class DHUwithSHA256CKDF extends KeyAgreementSpi {
        public DHUwithSHA256CKDF() {
            super("DHUwithSHA256CKDF", new SignatureSpi.ecCVCDSA224(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA256KDF */
    public static class DHUwithSHA256KDF extends KeyAgreementSpi {
        public DHUwithSHA256KDF() {
            super("DHUwithSHA256KDF", new SignatureSpi.ecCVCDSA224(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA384CKDF */
    public static class DHUwithSHA384CKDF extends KeyAgreementSpi {
        public DHUwithSHA384CKDF() {
            super("DHUwithSHA384CKDF", new SignatureSpi.ecCVCDSA224(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA384KDF */
    public static class DHUwithSHA384KDF extends KeyAgreementSpi {
        public DHUwithSHA384KDF() {
            super("DHUwithSHA384KDF", new SignatureSpi.ecCVCDSA224(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA512CKDF */
    public static class DHUwithSHA512CKDF extends KeyAgreementSpi {
        public DHUwithSHA512CKDF() {
            super("DHUwithSHA512CKDF", new SignatureSpi.ecCVCDSA224(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA512KDF */
    public static class DHUwithSHA512KDF extends KeyAgreementSpi {
        public DHUwithSHA512KDF() {
            super("DHUwithSHA512KDF", new SignatureSpi.ecCVCDSA224(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithRFC2631KDF */
    public static class DHwithRFC2631KDF extends KeyAgreementSpi {
        public DHwithRFC2631KDF() {
            super("DHwithRFC2631KDF", new SignatureSpi.ecDSA224(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA1CKDF */
    public static class DHwithSHA1CKDF extends KeyAgreementSpi {
        public DHwithSHA1CKDF() {
            super("DHwithSHA1CKDF", new Payload(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA1KDF */
    public static class DHwithSHA1KDF extends KeyAgreementSpi {
        public DHwithSHA1KDF() {
            super("DHwithSHA1CKDF", new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA224CKDF */
    public static class DHwithSHA224CKDF extends KeyAgreementSpi {
        public DHwithSHA224CKDF() {
            super("DHwithSHA224CKDF", new Payload(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA224KDF */
    public static class DHwithSHA224KDF extends KeyAgreementSpi {
        public DHwithSHA224KDF() {
            super("DHwithSHA224CKDF", new KeyFactorySpi.ED25519(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA256CKDF */
    public static class DHwithSHA256CKDF extends KeyAgreementSpi {
        public DHwithSHA256CKDF() {
            super("DHwithSHA256CKDF", new Payload(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA256KDF */
    public static class DHwithSHA256KDF extends KeyAgreementSpi {
        public DHwithSHA256KDF() {
            super("DHwithSHA256CKDF", new KeyFactorySpi.ED25519(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA384CKDF */
    public static class DHwithSHA384CKDF extends KeyAgreementSpi {
        public DHwithSHA384CKDF() {
            super("DHwithSHA384CKDF", new Payload(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA384KDF */
    public static class DHwithSHA384KDF extends KeyAgreementSpi {
        public DHwithSHA384KDF() {
            super("DHwithSHA384KDF", new KeyFactorySpi.ED25519(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA512CKDF */
    public static class DHwithSHA512CKDF extends KeyAgreementSpi {
        public DHwithSHA512CKDF() {
            super("DHwithSHA512CKDF", new Payload(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA512KDF */
    public static class DHwithSHA512KDF extends KeyAgreementSpi {
        public DHwithSHA512KDF() {
            super("DHwithSHA512KDF", new KeyFactorySpi.ED25519(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA1CKDF */
    public static class MQVwithSHA1CKDF extends KeyAgreementSpi {
        public MQVwithSHA1CKDF() {
            super("MQVwithSHA1CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA512(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA1KDF */
    public static class MQVwithSHA1KDF extends KeyAgreementSpi {
        public MQVwithSHA1KDF() {
            super("MQVwithSHA1KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA512(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA224CKDF */
    public static class MQVwithSHA224CKDF extends KeyAgreementSpi {
        public MQVwithSHA224CKDF() {
            super("MQVwithSHA224CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA512(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA224KDF */
    public static class MQVwithSHA224KDF extends KeyAgreementSpi {
        public MQVwithSHA224KDF() {
            super("MQVwithSHA224KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA512(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA256CKDF */
    public static class MQVwithSHA256CKDF extends KeyAgreementSpi {
        public MQVwithSHA256CKDF() {
            super("MQVwithSHA256CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA512(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA256KDF */
    public static class MQVwithSHA256KDF extends KeyAgreementSpi {
        public MQVwithSHA256KDF() {
            super("MQVwithSHA256KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA512(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA384CKDF */
    public static class MQVwithSHA384CKDF extends KeyAgreementSpi {
        public MQVwithSHA384CKDF() {
            super("MQVwithSHA384CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA512(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA384KDF */
    public static class MQVwithSHA384KDF extends KeyAgreementSpi {
        public MQVwithSHA384KDF() {
            super("MQVwithSHA384KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA512(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA512CKDF */
    public static class MQVwithSHA512CKDF extends KeyAgreementSpi {
        public MQVwithSHA512CKDF() {
            super("MQVwithSHA512CKDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA512(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new Payload(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA512KDF */
    public static class MQVwithSHA512KDF extends KeyAgreementSpi {
        public MQVwithSHA512KDF() {
            super("MQVwithSHA512KDF", (KeyAgreementSpi.ECKAEGwithSHA224KDF) new SignatureSpi.ecCVCDSA512(), (KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo) new KeyFactorySpi.ED25519(new BCECGOST3410PrivateKey()));
        }
    }

    /* access modifiers changed from: protected */
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        if (this.getWarnings == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        } else if (key instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            if (!dHPublicKey.getParams().getG().equals(this.valueOf) || !dHPublicKey.getParams().getP().equals(this.CardinalEnvironment)) {
                throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
            }
            BigInteger y = dHPublicKey.getY();
            if (y == null || y.compareTo(cca_continue) < 0 || y.compareTo(this.CardinalEnvironment.subtract(configure)) >= 0) {
                throw new InvalidKeyException("Invalid DH PublicKey");
            } else if (this.cleanup != null) {
                if (z) {
                    this.CardinalActionCode = this.cleanup.getInstance(new setScrollBarDefaultDelayBeforeFade(Cardinal((PublicKey) key), Cardinal((PublicKey) null)));
                    return null;
                }
                throw new IllegalStateException("unified Diffie-Hellman can use only two key pairs");
            } else if (this.getSDKVersion == null) {
                BigInteger modPow = y.modPow(this.getWarnings, this.CardinalEnvironment);
                if (modPow.compareTo(configure) != 0) {
                    this.CardinalActionCode = Cardinal(modPow);
                    if (z) {
                        return null;
                    }
                    return new BCDHPublicKey(modPow, dHPublicKey.getParams());
                }
                throw new InvalidKeyException("Shared key can't be 1");
            } else if (z) {
                this.CardinalActionCode = Cardinal(this.getSDKVersion.Cardinal(new setClipToOutline(Cardinal((PublicKey) key), Cardinal((PublicKey) null))));
                return null;
            } else {
                throw new IllegalStateException("MQV Diffie-Hellman can use only two key pairs");
            }
        } else {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            if (algorithmParameterSpec == null) {
                this.CardinalEnvironment = dHPrivateKey.getParams().getP();
                this.valueOf = dHPrivateKey.getParams().getG();
            } else if (algorithmParameterSpec instanceof DHParameterSpec) {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.CardinalEnvironment = dHParameterSpec.getP();
                this.valueOf = dHParameterSpec.getG();
                this.CardinalError = null;
                this.getInstance = null;
            } else if (algorithmParameterSpec instanceof XMSSKeyFactorySpi) {
                if (this.cleanup != null) {
                    this.CardinalEnvironment = dHPrivateKey.getParams().getP();
                    this.valueOf = dHPrivateKey.getParams().getG();
                    this.CardinalError = (XMSSKeyFactorySpi) algorithmParameterSpec;
                    this.getInstance = XMSSKeyFactorySpi.cca_continue();
                    this.cleanup.getInstance = new setVerticalFadingEdgeEnabled(configure(dHPrivateKey), configure((PrivateKey) null));
                } else {
                    throw new InvalidAlgorithmParameterException("agreement algorithm not DHU based");
                }
            } else if (algorithmParameterSpec instanceof EncryptionMethod) {
                if (this.getSDKVersion != null) {
                    this.CardinalEnvironment = dHPrivateKey.getParams().getP();
                    this.valueOf = dHPrivateKey.getParams().getG();
                    this.values = (EncryptionMethod) algorithmParameterSpec;
                    this.getInstance = EncryptionMethod.Cardinal();
                    this.getSDKVersion.configure(new setTransitionVisibility(configure(dHPrivateKey), configure((PrivateKey) null)));
                } else {
                    throw new InvalidAlgorithmParameterException("agreement algorithm not MQV based");
                }
            } else if (!(algorithmParameterSpec instanceof JWEHeader)) {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            } else if (this.Cardinal != null) {
                this.CardinalEnvironment = dHPrivateKey.getParams().getP();
                this.valueOf = dHPrivateKey.getParams().getG();
                this.CardinalError = null;
                this.getInstance = JWEHeader.configure();
            } else {
                throw new InvalidAlgorithmParameterException("no KDF specified for UserKeyingMaterialSpec");
            }
            BigInteger x = dHPrivateKey.getX();
            this.getWarnings = x;
            this.CardinalActionCode = Cardinal(x);
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
    }

    private static CipherSpi.PKCS1v1_5Padding Cardinal(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof DHPublicKey)) {
            throw new InvalidKeyException("public key not a DHPublicKey");
        } else if (publicKey instanceof BCDHPublicKey) {
            return ((BCDHPublicKey) publicKey).cca_continue;
        } else {
            DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
            DHParameterSpec params = dHPublicKey.getParams();
            return params instanceof Sphincs256KeyFactorySpi ? new CipherSpi.PKCS1v1_5Padding(dHPublicKey.getY(), ((Sphincs256KeyFactorySpi) params).init()) : new CipherSpi.PKCS1v1_5Padding(dHPublicKey.getY(), new CipherSpi(params.getP(), params.getG(), params.getL()));
        }
    }
}
