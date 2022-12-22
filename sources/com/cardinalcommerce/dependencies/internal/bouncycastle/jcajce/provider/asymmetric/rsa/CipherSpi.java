package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import com.cardinalcommerce.p060a.BCEdDSAPrivateKey;
import com.cardinalcommerce.p060a.ECGOST2012SignatureSpi256;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.JWEObject;
import com.cardinalcommerce.p060a.JWSObject;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.QTESLAKeyFactorySpi;
import com.cardinalcommerce.p060a.XMSSMTKeyFactorySpi;
import com.cardinalcommerce.p060a.setAcsTransactionID;
import com.cardinalcommerce.p060a.setAnimation;
import com.didi.travel.p171v2.store.IStoreCallback;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class CipherSpi extends BaseCipherSpi {
    private final JWEObject Cardinal = new JWSObject();
    private AlgorithmParameterSpec cca_continue;
    private BaseCipherSpi.ErasableOutputStream cleanup = new BaseCipherSpi.ErasableOutputStream();
    private AlgorithmParameters configure;
    private boolean getInstance = false;
    private boolean getSDKVersion = false;
    private KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo init;

    public static class ISO9796d1Padding extends CipherSpi {
        public ISO9796d1Padding() {
            super((KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo) new ECGOST2012SignatureSpi256(new BCEdDSAPrivateKey()));
        }
    }

    public static class NoPadding extends CipherSpi {
        public NoPadding() {
            super((KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo) new BCEdDSAPrivateKey());
        }
    }

    public static class OAEPPadding extends CipherSpi {
        public OAEPPadding() {
            super(OAEPParameterSpec.DEFAULT);
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi {
        public PKCS1v1_5Padding() {
            super((KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo) new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class PKCS1v1_5Padding_PrivateOnly extends CipherSpi {
        public PKCS1v1_5Padding_PrivateOnly() {
            super(false, true, new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public static class PKCS1v1_5Padding_PublicOnly extends CipherSpi {
        public PKCS1v1_5Padding_PublicOnly() {
            super(true, false, new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey()));
        }
    }

    public CipherSpi(KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo) {
        this.init = dHwithSHA384KDFAndSharedInfo;
    }

    public CipherSpi(OAEPParameterSpec oAEPParameterSpec) {
        try {
            cca_continue(oAEPParameterSpec);
        } catch (NoSuchPaddingException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public CipherSpi(boolean z, boolean z2, KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo) {
        this.getInstance = z;
        this.getSDKVersion = z2;
        this.init = dHwithSHA384KDFAndSharedInfo;
    }

    private void cca_continue(OAEPParameterSpec oAEPParameterSpec) throws NoSuchPaddingException {
        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo Cardinal2 = XMSSMTKeyFactorySpi.Cardinal(mGF1ParameterSpec.getDigestAlgorithm());
        if (Cardinal2 != null) {
            this.init = new setAcsTransactionID(new BCEdDSAPrivateKey(), Cardinal2, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
            this.cca_continue = oAEPParameterSpec;
            return;
        }
        StringBuilder sb = new StringBuilder("no match on OAEP constructor for digest algorithm: ");
        sb.append(mGF1ParameterSpec.getDigestAlgorithm());
        throw new NoSuchPaddingException(sb.toString());
    }

    private byte[] init() throws BadPaddingException {
        try {
            byte[] Cardinal2 = this.init.Cardinal(this.cleanup.getInstance(), 0, this.cleanup.size());
            this.cleanup.cca_continue();
            return Cardinal2;
        } catch (KeyFactorySpi.ECDH e) {
            throw new QTESLAKeyFactorySpi("unable to decrypt block", e);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new QTESLAKeyFactorySpi("unable to decrypt block", e2);
        } catch (Throwable th) {
            this.cleanup.cca_continue();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        if (engineGetOutputSize(i2) + i3 <= bArr2.length) {
            if (bArr != null) {
                this.cleanup.write(bArr, i, i2);
            }
            if (this.init instanceof BCEdDSAPrivateKey) {
                if (this.cleanup.size() > this.init.getInstance() + 1) {
                    throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
                }
            } else if (this.cleanup.size() > this.init.getInstance()) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
            byte[] init2 = init();
            for (int i4 = 0; i4 != init2.length; i4++) {
                bArr2[i3 + i4] = init2[i4];
            }
            return init2.length;
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (bArr != null) {
            this.cleanup.write(bArr, i, i2);
        }
        if (this.init instanceof BCEdDSAPrivateKey) {
            if (this.cleanup.size() > this.init.getInstance() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (this.cleanup.size() > this.init.getInstance()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        return init();
    }

    public int engineGetBlockSize() {
        try {
            return this.init.getInstance();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
    }

    public int engineGetKeySize(Key key) {
        BigInteger modulus;
        if (key instanceof RSAPrivateKey) {
            modulus = ((RSAPrivateKey) key).getModulus();
        } else if (key instanceof RSAPublicKey) {
            modulus = ((RSAPublicKey) key).getModulus();
        } else {
            throw new IllegalArgumentException("not an RSA key!");
        }
        return modulus.bitLength();
    }

    public int engineGetOutputSize(int i) {
        try {
            return this.init.configure();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.configure == null && this.cca_continue != null) {
            try {
                AlgorithmParameters configure2 = this.Cardinal.configure("OAEP");
                this.configure = configure2;
                configure2.init(this.cca_continue);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.configure;
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            try {
                algorithmParameterSpec = algorithmParameters.getParameterSpec(OAEPParameterSpec.class);
            } catch (InvalidParameterSpecException e) {
                StringBuilder sb = new StringBuilder("cannot recognise parameters: ");
                sb.append(e.toString());
                throw new InvalidAlgorithmParameterException(sb.toString(), e);
            }
        } else {
            algorithmParameterSpec = null;
        }
        this.configure = algorithmParameters;
        engineInit(i, key, algorithmParameterSpec, secureRandom);
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            StringBuilder sb = new StringBuilder("Eeeek! ");
            sb.append(e.toString());
            throw new InvalidKeyException(sb.toString(), e);
        }
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String Cardinal2 = setAnimation.Cardinal(str);
        if (!Cardinal2.equals(IStoreCallback.DEFAULT_API_DETAIL_KEY) && !Cardinal2.equals("ECB")) {
            if (Cardinal2.equals("1")) {
                this.getSDKVersion = true;
                this.getInstance = false;
            } else if (Cardinal2.equals("2")) {
                this.getSDKVersion = false;
                this.getInstance = true;
            } else {
                throw new NoSuchAlgorithmException("can't support mode ".concat(String.valueOf(str)));
            }
        }
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String Cardinal2 = setAnimation.Cardinal(str);
        if (Cardinal2.equals("NOPADDING")) {
            this.init = new BCEdDSAPrivateKey();
        } else if (Cardinal2.equals("PKCS1PADDING")) {
            this.init = new KeyAgreementSpi.ECVKO256(new BCEdDSAPrivateKey());
        } else if (Cardinal2.equals("ISO9796-1PADDING")) {
            this.init = new ECGOST2012SignatureSpi256(new BCEdDSAPrivateKey());
        } else if (Cardinal2.equals("OAEPWITHMD5ANDMGF1PADDING")) {
            cca_continue(new OAEPParameterSpec(MessageDigestAlgorithms.MD5, "MGF1", new MGF1ParameterSpec(MessageDigestAlgorithms.MD5), PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPPADDING")) {
            cca_continue(OAEPParameterSpec.DEFAULT);
        } else if (Cardinal2.equals("OAEPWITHSHA1ANDMGF1PADDING") || Cardinal2.equals("OAEPWITHSHA-1ANDMGF1PADDING")) {
            cca_continue(OAEPParameterSpec.DEFAULT);
        } else if (Cardinal2.equals("OAEPWITHSHA224ANDMGF1PADDING") || Cardinal2.equals("OAEPWITHSHA-224ANDMGF1PADDING")) {
            cca_continue(new OAEPParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224), PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA256ANDMGF1PADDING") || Cardinal2.equals("OAEPWITHSHA-256ANDMGF1PADDING")) {
            cca_continue(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA384ANDMGF1PADDING") || Cardinal2.equals("OAEPWITHSHA-384ANDMGF1PADDING")) {
            cca_continue(new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA512ANDMGF1PADDING") || Cardinal2.equals("OAEPWITHSHA-512ANDMGF1PADDING")) {
            cca_continue(new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA3-224ANDMGF1PADDING")) {
            cca_continue(new OAEPParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA3-256ANDMGF1PADDING")) {
            cca_continue(new OAEPParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA3-384ANDMGF1PADDING")) {
            cca_continue(new OAEPParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA3-512ANDMGF1PADDING")) {
            cca_continue(new OAEPParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), PSource.PSpecified.DEFAULT));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" unavailable with RSA.");
            throw new NoSuchPaddingException(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.cleanup.write(bArr, i, i2);
        if (this.init instanceof BCEdDSAPrivateKey) {
            if (this.cleanup.size() <= this.init.getInstance() + 1) {
                return 0;
            }
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        } else if (this.cleanup.size() <= this.init.getInstance()) {
            return 0;
        } else {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.cleanup.write(bArr, i, i2);
        if (this.init instanceof BCEdDSAPrivateKey) {
            if (this.cleanup.size() <= this.init.getInstance() + 1) {
                return null;
            }
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        } else if (this.cleanup.size() <= this.init.getInstance()) {
            return null;
        } else {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption;
        ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption2;
        if (algorithmParameterSpec == null || (algorithmParameterSpec instanceof OAEPParameterSpec)) {
            if (key instanceof RSAPublicKey) {
                if (!this.getSDKVersion || i != 1) {
                    sHA224WithRSAEncryption = RSAUtil.m2203a((RSAPublicKey) key);
                } else {
                    throw new InvalidKeyException("mode 1 requires RSAPrivateKey");
                }
            } else if (!(key instanceof RSAPrivateKey)) {
                throw new InvalidKeyException("unknown key type passed to RSA");
            } else if (!this.getInstance || i != 1) {
                sHA224WithRSAEncryption = RSAUtil.m2202a((RSAPrivateKey) key);
            } else {
                throw new InvalidKeyException("mode 2 requires RSAPublicKey");
            }
            if (algorithmParameterSpec != null) {
                OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
                this.cca_continue = algorithmParameterSpec;
                if (!oAEPParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !oAEPParameterSpec.getMGFAlgorithm().equals(KeyFactorySpi.CardinalError.init)) {
                    throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
                } else if (oAEPParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                    KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo Cardinal2 = XMSSMTKeyFactorySpi.Cardinal(oAEPParameterSpec.getDigestAlgorithm());
                    if (Cardinal2 != null) {
                        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
                        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo Cardinal3 = XMSSMTKeyFactorySpi.Cardinal(mGF1ParameterSpec.getDigestAlgorithm());
                        if (Cardinal3 != null) {
                            this.init = new setAcsTransactionID(new BCEdDSAPrivateKey(), Cardinal2, Cardinal3, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
                        } else {
                            StringBuilder sb = new StringBuilder("no match on MGF digest algorithm: ");
                            sb.append(mGF1ParameterSpec.getDigestAlgorithm());
                            throw new InvalidAlgorithmParameterException(sb.toString());
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder("no match on digest algorithm: ");
                        sb2.append(oAEPParameterSpec.getDigestAlgorithm());
                        throw new InvalidAlgorithmParameterException(sb2.toString());
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("unkown MGF parameters");
                }
            }
            if (!(this.init instanceof BCEdDSAPrivateKey)) {
                if (secureRandom == null) {
                    sHA224WithRSAEncryption2 = new ISOSignatureSpi.SHA224WithRSAEncryption(sHA224WithRSAEncryption, KeyAgreementSpi.MQV.cca_continue());
                }
                sHA224WithRSAEncryption = sHA224WithRSAEncryption2;
            }
            this.cleanup.reset();
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            StringBuilder sb3 = new StringBuilder("unknown opmode ");
                            sb3.append(i);
                            sb3.append(" passed to RSA");
                            throw new InvalidParameterException(sb3.toString());
                        }
                    }
                }
                this.init.Cardinal(false, sHA224WithRSAEncryption);
                return;
            }
            this.init.Cardinal(true, sHA224WithRSAEncryption);
            return;
        }
        StringBuilder sb4 = new StringBuilder("unknown parameter type: ");
        sb4.append(algorithmParameterSpec.getClass().getName());
        throw new InvalidAlgorithmParameterException(sb4.toString());
    }
}
