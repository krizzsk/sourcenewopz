package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import com.cardinalcommerce.p060a.AAD;
import com.cardinalcommerce.p060a.BCEdDSAPublicKey;
import com.cardinalcommerce.p060a.ECGOST2012SignatureSpi256;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
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
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class CipherSpi extends BaseCipherSpi {
    private AlgorithmParameterSpec Cardinal;
    private AlgorithmParameters cca_continue;
    private BaseCipherSpi.ErasableOutputStream configure = new BaseCipherSpi.ErasableOutputStream();
    private KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo getInstance;

    public static class NoPadding extends CipherSpi {
        public NoPadding() {
            super(new BCEdDSAPublicKey());
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi {
        public PKCS1v1_5Padding() {
            super(new KeyAgreementSpi.ECVKO256(new BCEdDSAPublicKey()));
        }
    }

    public CipherSpi(KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo) {
        this.getInstance = dHwithSHA384KDFAndSharedInfo;
    }

    private byte[] cca_continue() throws BadPaddingException {
        try {
            byte[] Cardinal2 = this.getInstance.Cardinal(this.configure.getInstance(), 0, this.configure.size());
            this.configure.cca_continue();
            return Cardinal2;
        } catch (KeyFactorySpi.ECDH e) {
            throw new QTESLAKeyFactorySpi("unable to decrypt block", e);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new QTESLAKeyFactorySpi("unable to decrypt block", e2);
        } catch (Throwable th) {
            this.configure.cca_continue();
            throw th;
        }
    }

    private void getInstance(OAEPParameterSpec oAEPParameterSpec) throws NoSuchPaddingException {
        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo Cardinal2 = XMSSMTKeyFactorySpi.Cardinal(mGF1ParameterSpec.getDigestAlgorithm());
        if (Cardinal2 != null) {
            this.getInstance = new setAcsTransactionID(new BCEdDSAPublicKey(), Cardinal2, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
            this.Cardinal = oAEPParameterSpec;
            return;
        }
        StringBuilder sb = new StringBuilder("no match on OAEP constructor for digest algorithm: ");
        sb.append(mGF1ParameterSpec.getDigestAlgorithm());
        throw new NoSuchPaddingException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        if (engineGetOutputSize(i2) + i3 <= bArr2.length) {
            if (bArr != null) {
                this.configure.write(bArr, i, i2);
            }
            if (this.getInstance instanceof BCEdDSAPublicKey) {
                if (this.configure.size() > this.getInstance.getInstance() + 1) {
                    throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
                }
            } else if (this.configure.size() > this.getInstance.getInstance()) {
                throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
            }
            byte[] cca_continue2 = cca_continue();
            for (int i4 = 0; i4 != cca_continue2.length; i4++) {
                bArr2[i3 + i4] = cca_continue2[i4];
            }
            return cca_continue2.length;
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (bArr != null) {
            this.configure.write(bArr, i, i2);
        }
        if (this.getInstance instanceof BCEdDSAPublicKey) {
            if (this.configure.size() > this.getInstance.getInstance() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
            }
        } else if (this.configure.size() > this.getInstance.getInstance()) {
            throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
        }
        return cca_continue();
    }

    public int engineGetBlockSize() {
        return this.getInstance.getInstance();
    }

    public int engineGetOutputSize(int i) {
        return this.getInstance.configure();
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.cca_continue == null && this.Cardinal != null) {
            try {
                AlgorithmParameters instance = getInstance("OAEP");
                this.cca_continue = instance;
                instance.init(this.Cardinal);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.cca_continue;
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("can't handle parameters in ElGamal");
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
            throw new NoSuchAlgorithmException("can't support mode ".concat(String.valueOf(str)));
        }
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String Cardinal2 = setAnimation.Cardinal(str);
        if (Cardinal2.equals("NOPADDING")) {
            this.getInstance = new BCEdDSAPublicKey();
        } else if (Cardinal2.equals("PKCS1PADDING")) {
            this.getInstance = new KeyAgreementSpi.ECVKO256(new BCEdDSAPublicKey());
        } else if (Cardinal2.equals("ISO9796-1PADDING")) {
            this.getInstance = new ECGOST2012SignatureSpi256(new BCEdDSAPublicKey());
        } else if (Cardinal2.equals("OAEPPADDING")) {
            getInstance(OAEPParameterSpec.DEFAULT);
        } else if (Cardinal2.equals("OAEPWITHMD5ANDMGF1PADDING")) {
            getInstance(new OAEPParameterSpec(MessageDigestAlgorithms.MD5, "MGF1", new MGF1ParameterSpec(MessageDigestAlgorithms.MD5), PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA1ANDMGF1PADDING")) {
            getInstance(OAEPParameterSpec.DEFAULT);
        } else if (Cardinal2.equals("OAEPWITHSHA224ANDMGF1PADDING")) {
            getInstance(new OAEPParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224), PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA256ANDMGF1PADDING")) {
            getInstance(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA384ANDMGF1PADDING")) {
            getInstance(new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA512ANDMGF1PADDING")) {
            getInstance(new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA3-224ANDMGF1PADDING")) {
            getInstance(new OAEPParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA3-256ANDMGF1PADDING")) {
            getInstance(new OAEPParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA3-384ANDMGF1PADDING")) {
            getInstance(new OAEPParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), PSource.PSpecified.DEFAULT));
        } else if (Cardinal2.equals("OAEPWITHSHA3-512ANDMGF1PADDING")) {
            getInstance(new OAEPParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), PSource.PSpecified.DEFAULT));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" unavailable with ElGamal.");
            throw new NoSuchPaddingException(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.configure.write(bArr, i, i2);
        return 0;
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.configure.write(bArr, i, i2);
        return null;
    }

    public int engineGetKeySize(Key key) {
        BigInteger p;
        if (key instanceof AAD) {
            p = ((AAD) key).getInstance().configure;
        } else if (key instanceof DHKey) {
            p = ((DHKey) key).getParams().getP();
        } else {
            throw new IllegalArgumentException("not an ElGamal key!");
        }
        return p.bitLength();
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption;
        KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo;
        if (key instanceof DHPublicKey) {
            sHA224WithRSAEncryption = ElGamalUtil.configure((PublicKey) key);
        } else if (key instanceof DHPrivateKey) {
            sHA224WithRSAEncryption = ElGamalUtil.cca_continue((PrivateKey) key);
        } else {
            throw new InvalidKeyException("unknown key type passed to ElGamal");
        }
        if (algorithmParameterSpec instanceof OAEPParameterSpec) {
            OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
            this.Cardinal = algorithmParameterSpec;
            if (!oAEPParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !oAEPParameterSpec.getMGFAlgorithm().equals(KeyFactorySpi.CardinalError.init)) {
                throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
            } else if (oAEPParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo Cardinal2 = XMSSMTKeyFactorySpi.Cardinal(oAEPParameterSpec.getDigestAlgorithm());
                if (Cardinal2 != null) {
                    MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
                    KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo Cardinal3 = XMSSMTKeyFactorySpi.Cardinal(mGF1ParameterSpec.getDigestAlgorithm());
                    if (Cardinal3 != null) {
                        this.getInstance = new setAcsTransactionID(new BCEdDSAPublicKey(), Cardinal2, Cardinal3, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
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
        } else if (algorithmParameterSpec != null) {
            throw new InvalidAlgorithmParameterException("unknown parameter type.");
        }
        if (secureRandom != null) {
            sHA224WithRSAEncryption = new ISOSignatureSpi.SHA224WithRSAEncryption(sHA224WithRSAEncryption, secureRandom);
        }
        boolean z = true;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        StringBuilder sb3 = new StringBuilder("unknown opmode ");
                        sb3.append(i);
                        sb3.append(" passed to ElGamal");
                        throw new InvalidParameterException(sb3.toString());
                    }
                }
            }
            dHwithSHA384KDFAndSharedInfo = this.getInstance;
            z = false;
            dHwithSHA384KDFAndSharedInfo.Cardinal(z, sHA224WithRSAEncryption);
        }
        dHwithSHA384KDFAndSharedInfo = this.getInstance;
        dHwithSHA384KDFAndSharedInfo.Cardinal(z, sHA224WithRSAEncryption);
    }
}
