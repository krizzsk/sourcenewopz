package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p062dh;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.DHUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.IESUtil;
import com.cardinalcommerce.p060a.AESGCM;
import com.cardinalcommerce.p060a.BCECGOST3410_2012PrivateKey;
import com.cardinalcommerce.p060a.BCElGamalPrivateKey;
import com.cardinalcommerce.p060a.ButtonCustomization;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.JWEObject;
import com.cardinalcommerce.p060a.JWSObject;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.cardinalcommerce.p060a.QTESLAKeyFactorySpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.ToolbarCustomization;
import com.cardinalcommerce.p060a.getButtonCustomization;
import com.cardinalcommerce.p060a.getErrorMessage;
import com.cardinalcommerce.p060a.setAnimation;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import com.cardinalcommerce.p060a.setSelected;
import com.didi.travel.p171v2.store.IStoreCallback;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher */
public class IESCipher extends CipherSpi {
    private ByteArrayOutputStream Cardinal = new ByteArrayOutputStream();
    private setKeyboardNavigationCluster CardinalError = null;
    private final JWEObject cca_continue = new JWSObject();
    private AlgorithmParameters cleanup = null;
    private final int configure;
    private ButtonCustomization getInstance;
    private getErrorMessage getSDKVersion = null;
    private setKeyboardNavigationCluster getWarnings;
    private int init = -1;
    private SecureRandom values;

    public IESCipher(ButtonCustomization buttonCustomization) {
        this.getInstance = buttonCustomization;
        this.configure = 0;
    }

    public IESCipher(ButtonCustomization buttonCustomization, int i) {
        this.getInstance = buttonCustomization;
        this.configure = i;
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i, i2);
        System.arraycopy(engineDoFinal, 0, bArr2, i3, engineDoFinal.length);
        return engineDoFinal.length;
    }

    public byte[] engineGetIV() {
        getErrorMessage geterrormessage = this.getSDKVersion;
        if (geterrormessage != null) {
            return geterrormessage.Cardinal();
        }
        return null;
    }

    public int engineGetKeySize(Key key) {
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        throw new IllegalArgumentException("not a DH key");
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.cleanup == null && this.getSDKVersion != null) {
            try {
                AlgorithmParameters configure2 = this.cca_continue.configure("IES");
                this.cleanup = configure2;
                configure2.init(this.getSDKVersion);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.cleanup;
    }

    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            try {
                algorithmParameterSpec = algorithmParameters.getParameterSpec(getErrorMessage.class);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("cannot recognise parameters: ");
                sb.append(e.toString());
                throw new InvalidAlgorithmParameterException(sb.toString());
            }
        } else {
            algorithmParameterSpec = null;
        }
        this.cleanup = algorithmParameters;
        engineInit(i, key, algorithmParameterSpec, secureRandom);
    }

    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            StringBuilder sb = new StringBuilder("cannot handle supplied parameter spec: ");
            sb.append(e.getMessage());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String Cardinal2 = setAnimation.Cardinal(str);
        if (!Cardinal2.equals(IStoreCallback.DEFAULT_API_DETAIL_KEY) && !Cardinal2.equals("DHAES")) {
            throw new IllegalArgumentException("can't support mode ".concat(String.valueOf(str)));
        }
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String Cardinal2 = setAnimation.Cardinal(str);
        if (!Cardinal2.equals("NOPADDING") && !Cardinal2.equals("PKCS5PADDING") && !Cardinal2.equals("PKCS7PADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
    }

    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.Cardinal.write(bArr, i, i2);
        return 0;
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.Cardinal.write(bArr, i, i2);
        return null;
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IES */
    public static class IES extends IESCipher {
        public IES() {
            super(new ButtonCustomization(new SignatureSpi.ecCVCDSA(), new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()), new KeyPairGeneratorSpi.EdDSA(new SignatureSpi.ecNR224())));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC */
    public static class IESwithAESCBC extends IESCipher {
        public IESwithAESCBC() {
            super(new ButtonCustomization(new SignatureSpi.ecCVCDSA(), new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()), new KeyPairGeneratorSpi.EdDSA(new SignatureSpi.ecNR224()), new KeyPairGeneratorSpi.X448(new getButtonCustomization(new BCECGOST3410_2012PrivateKey()))), 16);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithDESedeCBC */
    public static class IESwithDESedeCBC extends IESCipher {
        public IESwithDESedeCBC() {
            super(new ButtonCustomization(new SignatureSpi.ecCVCDSA(), new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()), new KeyPairGeneratorSpi.EdDSA(new SignatureSpi.ecNR224()), new KeyPairGeneratorSpi.X448(new getButtonCustomization(new KeyAgreementSpi.ECVKO512()))), 8);
        }
    }

    public int engineGetBlockSize() {
        if (this.getInstance.Cardinal != null) {
            return this.getInstance.Cardinal.configure();
        }
        return 0;
    }

    public int engineGetOutputSize(int i) {
        int size;
        if (this.getWarnings != null) {
            int Cardinal2 = this.getInstance.configure.Cardinal();
            int bitLength = this.CardinalError == null ? (((((BCElGamalPrivateKey) this.getWarnings).configure.Cardinal.bitLength() + 7) * 2) / 8) + 1 : 0;
            if (this.getInstance.Cardinal != null) {
                int i2 = this.init;
                if (i2 == 1 || i2 == 3) {
                    i = this.getInstance.Cardinal.init(i);
                } else if (i2 == 2 || i2 == 4) {
                    i = this.getInstance.Cardinal.init((i - Cardinal2) - bitLength);
                } else {
                    throw new IllegalStateException("cipher not initialised");
                }
            }
            int i3 = this.init;
            if (i3 == 1 || i3 == 3) {
                size = this.Cardinal.size() + Cardinal2 + bitLength;
            } else if (i3 == 2 || i3 == 4) {
                size = (this.Cardinal.size() - Cardinal2) - bitLength;
            } else {
                throw new IllegalStateException("IESCipher not initialised");
            }
            return size + i;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException, InvalidKeyException {
        getErrorMessage geterrormessage;
        setKeyboardNavigationCluster setkeyboardnavigationcluster;
        PrivateKey instance;
        if (algorithmParameterSpec == null) {
            byte[] bArr = null;
            int i2 = this.configure;
            if (i2 != 0 && i == 1) {
                bArr = new byte[i2];
                secureRandom.nextBytes(bArr);
            }
            geterrormessage = IESUtil.Cardinal(this.getInstance.Cardinal, bArr);
        } else if (algorithmParameterSpec instanceof getErrorMessage) {
            geterrormessage = (getErrorMessage) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        this.getSDKVersion = geterrormessage;
        byte[] Cardinal2 = this.getSDKVersion.Cardinal();
        int i3 = this.configure;
        if (i3 == 0 || (Cardinal2 != null && Cardinal2.length == i3)) {
            if (i == 1 || i == 3) {
                if (key instanceof DHPublicKey) {
                    setkeyboardnavigationcluster = DHUtil.cca_continue((PublicKey) key);
                } else if (key instanceof AESGCM) {
                    AESGCM aesgcm = (AESGCM) key;
                    this.getWarnings = DHUtil.cca_continue(aesgcm.cca_continue());
                    this.CardinalError = DHUtil.configure(aesgcm.getInstance());
                    this.values = secureRandom;
                    this.init = i;
                    this.Cardinal.reset();
                    return;
                } else {
                    throw new InvalidKeyException("must be passed recipient's public DH key for encryption");
                }
            } else if (i == 2 || i == 4) {
                if (key instanceof DHPrivateKey) {
                    instance = (PrivateKey) key;
                } else if (key instanceof AESGCM) {
                    AESGCM aesgcm2 = (AESGCM) key;
                    this.CardinalError = DHUtil.cca_continue(aesgcm2.cca_continue());
                    instance = aesgcm2.getInstance();
                } else {
                    throw new InvalidKeyException("must be passed recipient's private DH key for decryption");
                }
                setkeyboardnavigationcluster = DHUtil.configure(instance);
            } else {
                throw new InvalidKeyException("must be passed EC key");
            }
            this.getWarnings = setkeyboardnavigationcluster;
            this.values = secureRandom;
            this.init = i;
            this.Cardinal.reset();
            return;
        }
        StringBuilder sb = new StringBuilder("NONCE in IES Parameters needs to be ");
        sb.append(this.configure);
        sb.append(" bytes long");
        throw new InvalidAlgorithmParameterException(sb.toString());
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (i2 != 0) {
            this.Cardinal.write(bArr, i, i2);
        }
        byte[] byteArray = this.Cardinal.toByteArray();
        this.Cardinal.reset();
        KeyAgreementSpi.ECKAEGwithSHA512KDF sHA1WithRSAEncryption = new ISOSignatureSpi.SHA1WithRSAEncryption(this.getSDKVersion.getInstance(), this.getSDKVersion.init(), this.getSDKVersion.Cardinal, this.getSDKVersion.getInstance);
        if (this.getSDKVersion.Cardinal() != null) {
            sHA1WithRSAEncryption = new ISOSignatureSpi.SHA384WithRSAEncryption(sHA1WithRSAEncryption, this.getSDKVersion.Cardinal());
        }
        com.cardinalcommerce.p060a.CipherSpi cipherSpi = ((BCElGamalPrivateKey) this.getWarnings).configure;
        setKeyboardNavigationCluster setkeyboardnavigationcluster = this.CardinalError;
        if (setkeyboardnavigationcluster != null) {
            try {
                if (this.init != 1) {
                    if (this.init != 3) {
                        ButtonCustomization buttonCustomization = this.getInstance;
                        setKeyboardNavigationCluster setkeyboardnavigationcluster2 = this.getWarnings;
                        buttonCustomization.init = false;
                        buttonCustomization.getInstance = setkeyboardnavigationcluster2;
                        buttonCustomization.cca_continue = setkeyboardnavigationcluster;
                        buttonCustomization.cleanup = new byte[0];
                        buttonCustomization.Cardinal(sHA1WithRSAEncryption);
                        return this.getInstance.Cardinal(byteArray, byteArray.length);
                    }
                }
                ButtonCustomization buttonCustomization2 = this.getInstance;
                setKeyboardNavigationCluster setkeyboardnavigationcluster3 = this.CardinalError;
                setKeyboardNavigationCluster setkeyboardnavigationcluster4 = this.getWarnings;
                buttonCustomization2.init = true;
                buttonCustomization2.getInstance = setkeyboardnavigationcluster3;
                buttonCustomization2.cca_continue = setkeyboardnavigationcluster4;
                buttonCustomization2.cleanup = new byte[0];
                buttonCustomization2.Cardinal(sHA1WithRSAEncryption);
                return this.getInstance.Cardinal(byteArray, byteArray.length);
            } catch (Exception e) {
                throw new QTESLAKeyFactorySpi("unable to process block", e);
            }
        } else {
            int i3 = this.init;
            if (i3 == 1 || i3 == 3) {
                KeyAgreementSpi.X25519withSHA256KDF x25519withSHA256KDF = new KeyAgreementSpi.X25519withSHA256KDF();
                x25519withSHA256KDF.Cardinal = new SignatureSpi.Ed25519(this.values, cipherSpi);
                ToolbarCustomization toolbarCustomization = new ToolbarCustomization(x25519withSHA256KDF, new KeyFactorySpi.ECGOST3410_2012() {
                    public final byte[] cca_continue(setKeyboardNavigationCluster setkeyboardnavigationcluster) {
                        int bitLength = (((BCElGamalPrivateKey) setkeyboardnavigationcluster).configure.Cardinal.bitLength() + 7) / 8;
                        byte[] bArr = new byte[bitLength];
                        byte[] cca_continue = setSelected.cca_continue(((CipherSpi.PKCS1v1_5Padding) setkeyboardnavigationcluster).Cardinal);
                        if (cca_continue.length <= bitLength) {
                            System.arraycopy(cca_continue, 0, bArr, bitLength - cca_continue.length, cca_continue.length);
                            return bArr;
                        }
                        throw new IllegalArgumentException("Senders's public key longer than expected.");
                    }
                });
                try {
                    ButtonCustomization buttonCustomization3 = this.getInstance;
                    setKeyboardNavigationCluster setkeyboardnavigationcluster5 = this.getWarnings;
                    buttonCustomization3.init = true;
                    buttonCustomization3.cca_continue = setkeyboardnavigationcluster5;
                    buttonCustomization3.CardinalError = toolbarCustomization;
                    buttonCustomization3.Cardinal(sHA1WithRSAEncryption);
                    return this.getInstance.Cardinal(byteArray, byteArray.length);
                } catch (Exception e2) {
                    throw new QTESLAKeyFactorySpi("unable to process block", e2);
                }
            } else if (i3 == 2 || i3 == 4) {
                try {
                    ButtonCustomization buttonCustomization4 = this.getInstance;
                    setKeyboardNavigationCluster setkeyboardnavigationcluster6 = this.getWarnings;
                    PSSSignatureSpi.SHA512_224withRSA sHA512_224withRSA = new PSSSignatureSpi.SHA512_224withRSA(((BCElGamalPrivateKey) this.getWarnings).configure);
                    buttonCustomization4.init = false;
                    buttonCustomization4.getInstance = setkeyboardnavigationcluster6;
                    buttonCustomization4.getSDKVersion = sHA512_224withRSA;
                    buttonCustomization4.Cardinal(sHA1WithRSAEncryption);
                    return this.getInstance.Cardinal(byteArray, byteArray.length);
                } catch (KeyFactorySpi.ECDH e3) {
                    throw new QTESLAKeyFactorySpi("unable to process block", e3);
                }
            } else {
                throw new IllegalStateException("IESCipher not initialised");
            }
        }
    }
}
