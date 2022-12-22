package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.cardinalcommerce.p060a.BCEdDSAPrivateKey;
import com.cardinalcommerce.p060a.BaseCipherSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.JWEObject;
import com.cardinalcommerce.p060a.JWSObject;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.XMSSMTKeyFactorySpi;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class PSSSignatureSpi extends SignatureSpi {
    private PSSParameterSpec Cardinal;
    private boolean CardinalEnvironment;
    private boolean CardinalError;
    private ISOSignatureSpi.WhirlpoolWithRSAEncryption CardinalUiType;
    private AlgorithmParameters cca_continue;
    private byte cleanup;
    private final JWEObject configure;
    private KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo getInstance;
    private int getSDKVersion;
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo getWarnings;
    private PSSParameterSpec init;
    private BaseCipherSpi valueOf;
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo values;

    public static class PSSwithRSA extends PSSSignatureSpi {
        public PSSwithRSA() {
            super(new BCEdDSAPrivateKey(), (PSSParameterSpec) null);
        }
    }

    public static class SHA1withRSA extends PSSSignatureSpi {
        public SHA1withRSA() {
            super(new BCEdDSAPrivateKey(), PSSParameterSpec.DEFAULT);
        }
    }

    public static class SHA224withRSA extends PSSSignatureSpi {
        public SHA224withRSA() {
            super(new BCEdDSAPrivateKey(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224), 28, 1));
        }
    }

    public static class SHA256withRSA extends PSSSignatureSpi {
        public SHA256withRSA() {
            super(new BCEdDSAPrivateKey(), new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), 32, 1));
        }
    }

    public static class SHA384withRSA extends PSSSignatureSpi {
        public SHA384withRSA() {
            super(new BCEdDSAPrivateKey(), new PSSParameterSpec("SHA-384", "MGF1", new MGF1ParameterSpec("SHA-384"), 48, 1));
        }
    }

    public static class SHA3_224withRSA extends PSSSignatureSpi {
        public SHA3_224withRSA() {
            super(new BCEdDSAPrivateKey(), new PSSParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), 28, 1));
        }
    }

    public static class SHA3_256withRSA extends PSSSignatureSpi {
        public SHA3_256withRSA() {
            super(new BCEdDSAPrivateKey(), new PSSParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), 32, 1));
        }
    }

    public static class SHA3_384withRSA extends PSSSignatureSpi {
        public SHA3_384withRSA() {
            super(new BCEdDSAPrivateKey(), new PSSParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), 48, 1));
        }
    }

    public static class SHA3_512withRSA extends PSSSignatureSpi {
        public SHA3_512withRSA() {
            super(new BCEdDSAPrivateKey(), new PSSParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), 64, 1));
        }
    }

    public static class SHA512_224withRSA extends PSSSignatureSpi {
        public SHA512_224withRSA() {
            super(new BCEdDSAPrivateKey(), new PSSParameterSpec("SHA-512(224)", "MGF1", new MGF1ParameterSpec("SHA-512(224)"), 28, 1));
        }
    }

    public static class SHA512_256withRSA extends PSSSignatureSpi {
        public SHA512_256withRSA() {
            super(new BCEdDSAPrivateKey(), new PSSParameterSpec("SHA-512(256)", "MGF1", new MGF1ParameterSpec("SHA-512(256)"), 32, 1));
        }
    }

    public static class SHA512withRSA extends PSSSignatureSpi {
        public SHA512withRSA() {
            super(new BCEdDSAPrivateKey(), new PSSParameterSpec("SHA-512", "MGF1", new MGF1ParameterSpec("SHA-512"), 64, 1));
        }
    }

    public static class nonePSS extends PSSSignatureSpi {
        public nonePSS() {
            super(new BCEdDSAPrivateKey(), (PSSParameterSpec) null, true);
        }
    }

    protected PSSSignatureSpi(KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo, PSSParameterSpec pSSParameterSpec) {
        this(dHwithSHA384KDFAndSharedInfo, pSSParameterSpec, false);
    }

    private static byte cca_continue(int i) {
        if (i == 1) {
            return PSSSigner.TRAILER_IMPLICIT;
        }
        throw new IllegalArgumentException("unknown trailer field");
    }

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        if (this.cca_continue == null && this.Cardinal != null) {
            try {
                AlgorithmParameters configure2 = this.configure.configure("PSS");
                this.cca_continue = configure2;
                configure2.init(this.Cardinal);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.cca_continue;
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            this.CardinalUiType = RSAUtil.m2202a((RSAPrivateKey) privateKey);
            BaseCipherSpi baseCipherSpi = new BaseCipherSpi(this.getInstance, this.getWarnings, this.values, this.getSDKVersion, this.cleanup);
            this.valueOf = baseCipherSpi;
            baseCipherSpi.cca_continue(true, this.CardinalUiType);
            this.CardinalEnvironment = true;
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            this.CardinalUiType = RSAUtil.m2202a((RSAPrivateKey) privateKey);
            BaseCipherSpi baseCipherSpi = new BaseCipherSpi(this.getInstance, this.getWarnings, this.values, this.getSDKVersion, this.cleanup);
            this.valueOf = baseCipherSpi;
            baseCipherSpi.cca_continue(true, new ISOSignatureSpi.SHA224WithRSAEncryption(this.CardinalUiType, secureRandom));
            this.CardinalEnvironment = true;
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof RSAPublicKey) {
            this.CardinalUiType = RSAUtil.m2203a((RSAPublicKey) publicKey);
            BaseCipherSpi baseCipherSpi = new BaseCipherSpi(this.getInstance, this.getWarnings, this.values, this.getSDKVersion, this.cleanup);
            this.valueOf = baseCipherSpi;
            baseCipherSpi.cca_continue(false, this.CardinalUiType);
            this.CardinalEnvironment = true;
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public byte[] engineSign() throws SignatureException {
        this.CardinalEnvironment = true;
        try {
            return this.valueOf.Cardinal();
        } catch (KeyAgreementSpi.MQVwithSHA1KDFAndSharedInfo e) {
            throw new SignatureException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        this.CardinalEnvironment = true;
        return this.valueOf.init(bArr);
    }

    class cca_continue implements KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo {
        private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo cca_continue;
        private boolean getInstance = true;
        private ByteArrayOutputStream init = new ByteArrayOutputStream();

        public cca_continue(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
            this.cca_continue = mQVwithSHA256KDFAndSharedInfo;
        }

        public final void Cardinal(byte b) {
            this.init.write(b);
        }

        public final void cca_continue() {
            this.init.reset();
            this.cca_continue.cca_continue();
        }

        public final String configure() {
            return "NULL";
        }

        public final int getInstance() {
            return this.cca_continue.getInstance();
        }

        public final void init(byte[] bArr, int i, int i2) {
            this.init.write(bArr, i, i2);
        }

        public final int configure(byte[] bArr, int i) {
            byte[] byteArray = this.init.toByteArray();
            if (this.getInstance) {
                System.arraycopy(byteArray, 0, bArr, i, byteArray.length);
            } else {
                this.cca_continue.init(byteArray, 0, byteArray.length);
                this.cca_continue.configure(bArr, i);
            }
            this.init.reset();
            this.cca_continue.cca_continue();
            this.getInstance = !this.getInstance;
            return byteArray.length;
        }
    }

    protected PSSSignatureSpi(KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo, PSSParameterSpec pSSParameterSpec, boolean z) {
        this.configure = new JWSObject();
        this.CardinalEnvironment = true;
        this.getInstance = dHwithSHA384KDFAndSharedInfo;
        this.init = pSSParameterSpec;
        if (pSSParameterSpec == null) {
            this.Cardinal = PSSParameterSpec.DEFAULT;
        } else {
            this.Cardinal = pSSParameterSpec;
        }
        this.values = XMSSMTKeyFactorySpi.Cardinal(this.Cardinal.getDigestAlgorithm());
        this.getSDKVersion = this.Cardinal.getSaltLength();
        this.cleanup = cca_continue(this.Cardinal.getTrailerField());
        this.CardinalError = z;
        this.getWarnings = z ? new cca_continue(this.values) : this.values;
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.valueOf.getInstance.Cardinal(b);
        this.CardinalEnvironment = false;
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.valueOf.getInstance.init(bArr, i, i2);
        this.CardinalEnvironment = false;
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec != null || (algorithmParameterSpec = this.init) != null) {
            if (!this.CardinalEnvironment) {
                throw new ProviderException("cannot call setParameter in the middle of update");
            } else if (algorithmParameterSpec instanceof PSSParameterSpec) {
                PSSParameterSpec pSSParameterSpec = (PSSParameterSpec) algorithmParameterSpec;
                PSSParameterSpec pSSParameterSpec2 = this.init;
                if (pSSParameterSpec2 != null && !XMSSMTKeyFactorySpi.init(pSSParameterSpec2.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                    StringBuilder sb = new StringBuilder("parameter must be using ");
                    sb.append(this.init.getDigestAlgorithm());
                    throw new InvalidAlgorithmParameterException(sb.toString());
                } else if (!pSSParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !pSSParameterSpec.getMGFAlgorithm().equals(KeyFactorySpi.CardinalError.init)) {
                    throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
                } else if (pSSParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                    MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) pSSParameterSpec.getMGFParameters();
                    if (XMSSMTKeyFactorySpi.init(mGF1ParameterSpec.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo Cardinal2 = XMSSMTKeyFactorySpi.Cardinal(mGF1ParameterSpec.getDigestAlgorithm());
                        if (Cardinal2 != null) {
                            this.cca_continue = null;
                            this.Cardinal = pSSParameterSpec;
                            this.values = Cardinal2;
                            this.getSDKVersion = pSSParameterSpec.getSaltLength();
                            this.cleanup = cca_continue(this.Cardinal.getTrailerField());
                            this.getWarnings = this.CardinalError ? new cca_continue(this.values) : this.values;
                            if (this.CardinalUiType != null) {
                                this.valueOf = new BaseCipherSpi(this.getInstance, this.getWarnings, this.values, this.getSDKVersion, this.cleanup);
                                if (this.CardinalUiType.getInstance()) {
                                    this.valueOf.cca_continue(true, this.CardinalUiType);
                                } else {
                                    this.valueOf.cca_continue(false, this.CardinalUiType);
                                }
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder("no match on MGF digest algorithm: ");
                            sb2.append(mGF1ParameterSpec.getDigestAlgorithm());
                            throw new InvalidAlgorithmParameterException(sb2.toString());
                        }
                    } else {
                        throw new InvalidAlgorithmParameterException("digest algorithm for MGF should be the same as for PSS parameters.");
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("unknown MGF parameters");
                }
            } else {
                throw new InvalidAlgorithmParameterException("Only PSSParameterSpec supported");
            }
        }
    }
}
