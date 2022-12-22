package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.IESUtil;
import com.cardinalcommerce.p060a.AESGCM;
import com.cardinalcommerce.p060a.BCECGOST3410_2012PrivateKey;
import com.cardinalcommerce.p060a.BCRSAPrivateKey;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.ButtonCustomization;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.JWEObject;
import com.cardinalcommerce.p060a.JWSObject;
import com.cardinalcommerce.p060a.JWSVerifier;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.QTESLAKeyFactorySpi;
import com.cardinalcommerce.p060a.RSAUtil;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.ToolbarCustomization;
import com.cardinalcommerce.p060a.getButtonCustomization;
import com.cardinalcommerce.p060a.getErrorMessage;
import com.cardinalcommerce.p060a.setAnimation;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
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

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher */
public class IESCipher extends CipherSpi {
    private int Cardinal;
    private SecureRandom CardinalError;
    private ButtonCustomization cca_continue;
    private setKeyboardNavigationCluster cleanup = null;
    private final JWEObject configure = new JWSObject();
    private int getInstance = -1;
    private setKeyboardNavigationCluster getSDKVersion;
    private AlgorithmParameters getWarnings = null;
    private ByteArrayOutputStream init = new ByteArrayOutputStream();
    private getErrorMessage values = null;

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAESCBC */
    public static class ECIESwithAESCBC extends ECIESwithCipher {
        public ECIESwithAESCBC() {
            super(new getButtonCustomization(new BCECGOST3410_2012PrivateKey()), 16);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESedeCBC */
    public static class ECIESwithDESedeCBC extends ECIESwithCipher {
        public ECIESwithDESedeCBC() {
            super(new getButtonCustomization(new KeyAgreementSpi.ECVKO512()), 8);
        }
    }

    public IESCipher(ButtonCustomization buttonCustomization) {
        this.cca_continue = buttonCustomization;
        this.Cardinal = 0;
    }

    public IESCipher(ButtonCustomization buttonCustomization, int i) {
        this.cca_continue = buttonCustomization;
        this.Cardinal = i;
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i, i2);
        System.arraycopy(engineDoFinal, 0, bArr2, i3, engineDoFinal.length);
        return engineDoFinal.length;
    }

    public byte[] engineGetIV() {
        getErrorMessage geterrormessage = this.values;
        if (geterrormessage != null) {
            return geterrormessage.Cardinal();
        }
        return null;
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.getWarnings == null && this.values != null) {
            try {
                AlgorithmParameters configure2 = this.configure.configure("IES");
                this.getWarnings = configure2;
                configure2.init(this.values);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.getWarnings;
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
        this.getWarnings = algorithmParameters;
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
        this.init.write(bArr, i, i2);
        return 0;
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.init.write(bArr, i, i2);
        return null;
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIES */
    public static class ECIES extends IESCipher {
        public ECIES() {
            super(new ButtonCustomization(new KeyPairGeneratorSpi.ECMQV(), new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()), new KeyPairGeneratorSpi.EdDSA(new SignatureSpi.ecNR224())));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithCipher */
    public static class ECIESwithCipher extends IESCipher {
        public ECIESwithCipher(KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo dHwithSHA512KDFAndSharedInfo, int i) {
            super(new ButtonCustomization(new KeyPairGeneratorSpi.ECMQV(), new KeyFactorySpi.ED25519(new SignatureSpi.ecNR224()), new KeyPairGeneratorSpi.EdDSA(new SignatureSpi.ecNR224()), new KeyPairGeneratorSpi.X448(dHwithSHA512KDFAndSharedInfo)), i);
        }
    }

    public int engineGetBlockSize() {
        if (this.cca_continue.Cardinal != null) {
            return this.cca_continue.Cardinal.configure();
        }
        return 0;
    }

    public int engineGetKeySize(Key key) {
        if (key instanceof JWSVerifier) {
            return ((JWSVerifier) key).Cardinal().init.configure();
        }
        throw new IllegalArgumentException("not an EC key");
    }

    public int engineGetOutputSize(int i) {
        int size;
        if (this.getSDKVersion != null) {
            int Cardinal2 = this.cca_continue.configure.Cardinal();
            int configure2 = this.cleanup == null ? ((((DigestSignatureSpi.MD4) this.getSDKVersion).init.Cardinal.configure() + 7) / 8) * 2 : 0;
            if (this.cca_continue.Cardinal != null) {
                int i2 = this.getInstance;
                if (i2 == 1 || i2 == 3) {
                    i = this.cca_continue.Cardinal.init(i);
                } else if (i2 == 2 || i2 == 4) {
                    i = this.cca_continue.Cardinal.init((i - Cardinal2) - configure2);
                } else {
                    throw new IllegalStateException("cipher not initialised");
                }
            }
            int i3 = this.getInstance;
            if (i3 == 1 || i3 == 3) {
                size = this.init.size() + Cardinal2 + 1 + configure2;
            } else if (i3 == 2 || i3 == 4) {
                size = (this.init.size() - Cardinal2) - configure2;
            } else {
                throw new IllegalStateException("cipher not initialised");
            }
            return size + i;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException, InvalidKeyException {
        getErrorMessage geterrormessage;
        setKeyboardNavigationCluster setkeyboardnavigationcluster;
        setKeyboardNavigationCluster setkeyboardnavigationcluster2;
        setKeyboardNavigationCluster setkeyboardnavigationcluster3;
        byte[] bArr = null;
        this.cleanup = null;
        if (algorithmParameterSpec == null) {
            int i2 = this.Cardinal;
            if (i2 != 0 && i == 1) {
                bArr = new byte[i2];
                secureRandom.nextBytes(bArr);
            }
            geterrormessage = IESUtil.Cardinal(this.cca_continue.Cardinal, bArr);
        } else if (algorithmParameterSpec instanceof getErrorMessage) {
            geterrormessage = (getErrorMessage) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        this.values = geterrormessage;
        byte[] Cardinal2 = this.values.Cardinal();
        int i3 = this.Cardinal;
        if (i3 == 0 || (Cardinal2 != null && Cardinal2.length == i3)) {
            if (i == 1 || i == 3) {
                if (key instanceof PublicKey) {
                    PublicKey publicKey = (PublicKey) key;
                    if (publicKey instanceof BCECPublicKey) {
                        setkeyboardnavigationcluster2 = ((BCECPublicKey) publicKey).configure;
                    } else {
                        setkeyboardnavigationcluster2 = ECUtil.Cardinal(publicKey);
                    }
                    this.getSDKVersion = setkeyboardnavigationcluster2;
                } else if (key instanceof AESGCM) {
                    AESGCM aesgcm = (AESGCM) key;
                    PublicKey cca_continue2 = aesgcm.cca_continue();
                    if (cca_continue2 instanceof BCECPublicKey) {
                        setkeyboardnavigationcluster = ((BCECPublicKey) cca_continue2).configure;
                    } else {
                        setkeyboardnavigationcluster = ECUtil.Cardinal(cca_continue2);
                    }
                    this.getSDKVersion = setkeyboardnavigationcluster;
                    this.cleanup = ECUtil.getInstance(aesgcm.getInstance());
                } else {
                    throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
                }
            } else if (i != 2 && i != 4) {
                throw new InvalidKeyException("must be passed EC key");
            } else if (key instanceof PrivateKey) {
                this.getSDKVersion = ECUtil.getInstance((PrivateKey) key);
            } else if (key instanceof AESGCM) {
                AESGCM aesgcm2 = (AESGCM) key;
                PublicKey cca_continue3 = aesgcm2.cca_continue();
                if (cca_continue3 instanceof BCECPublicKey) {
                    setkeyboardnavigationcluster3 = ((BCECPublicKey) cca_continue3).configure;
                } else {
                    setkeyboardnavigationcluster3 = ECUtil.Cardinal(cca_continue3);
                }
                this.cleanup = setkeyboardnavigationcluster3;
                this.getSDKVersion = ECUtil.getInstance(aesgcm2.getInstance());
            } else {
                throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
            }
            this.CardinalError = secureRandom;
            this.getInstance = i;
            this.init.reset();
            return;
        }
        StringBuilder sb = new StringBuilder("NONCE in IES Parameters needs to be ");
        sb.append(this.Cardinal);
        sb.append(" bytes long");
        throw new InvalidAlgorithmParameterException(sb.toString());
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (i2 != 0) {
            this.init.write(bArr, i, i2);
        }
        byte[] byteArray = this.init.toByteArray();
        this.init.reset();
        KeyAgreementSpi.ECKAEGwithSHA512KDF sHA1WithRSAEncryption = new ISOSignatureSpi.SHA1WithRSAEncryption(this.values.getInstance(), this.values.init(), this.values.Cardinal, this.values.getInstance);
        if (this.values.Cardinal() != null) {
            sHA1WithRSAEncryption = new ISOSignatureSpi.SHA384WithRSAEncryption(sHA1WithRSAEncryption, this.values.Cardinal());
        }
        BCRSAPublicKey bCRSAPublicKey = ((DigestSignatureSpi.MD4) this.getSDKVersion).init;
        setKeyboardNavigationCluster setkeyboardnavigationcluster = this.cleanup;
        if (setkeyboardnavigationcluster != null) {
            try {
                if (this.getInstance != 1) {
                    if (this.getInstance != 3) {
                        ButtonCustomization buttonCustomization = this.cca_continue;
                        setKeyboardNavigationCluster setkeyboardnavigationcluster2 = this.getSDKVersion;
                        buttonCustomization.init = false;
                        buttonCustomization.getInstance = setkeyboardnavigationcluster2;
                        buttonCustomization.cca_continue = setkeyboardnavigationcluster;
                        buttonCustomization.cleanup = new byte[0];
                        buttonCustomization.Cardinal(sHA1WithRSAEncryption);
                        return this.cca_continue.Cardinal(byteArray, byteArray.length);
                    }
                }
                ButtonCustomization buttonCustomization2 = this.cca_continue;
                setKeyboardNavigationCluster setkeyboardnavigationcluster3 = this.cleanup;
                setKeyboardNavigationCluster setkeyboardnavigationcluster4 = this.getSDKVersion;
                buttonCustomization2.init = true;
                buttonCustomization2.getInstance = setkeyboardnavigationcluster3;
                buttonCustomization2.cca_continue = setkeyboardnavigationcluster4;
                buttonCustomization2.cleanup = new byte[0];
                buttonCustomization2.Cardinal(sHA1WithRSAEncryption);
                return this.cca_continue.Cardinal(byteArray, byteArray.length);
            } catch (Exception e) {
                throw new QTESLAKeyFactorySpi("unable to process block", e);
            }
        } else {
            int i3 = this.getInstance;
            if (i3 == 1 || i3 == 3) {
                KeyAgreementSpi.X448withSHA384CKDF x448withSHA384CKDF = new KeyAgreementSpi.X448withSHA384CKDF();
                x448withSHA384CKDF.cca_continue(new BCRSAPrivateKey(bCRSAPublicKey, this.CardinalError));
                final boolean configure2 = this.values.configure();
                ToolbarCustomization toolbarCustomization = new ToolbarCustomization(x448withSHA384CKDF, new KeyFactorySpi.ECGOST3410_2012() {
                    public final byte[] cca_continue(setKeyboardNavigationCluster setkeyboardnavigationcluster) {
                        return ((DigestSignatureSpi) setkeyboardnavigationcluster).cca_continue.configure(configure2);
                    }
                });
                try {
                    ButtonCustomization buttonCustomization3 = this.cca_continue;
                    setKeyboardNavigationCluster setkeyboardnavigationcluster5 = this.getSDKVersion;
                    buttonCustomization3.init = true;
                    buttonCustomization3.cca_continue = setkeyboardnavigationcluster5;
                    buttonCustomization3.CardinalError = toolbarCustomization;
                    buttonCustomization3.Cardinal(sHA1WithRSAEncryption);
                    return this.cca_continue.Cardinal(byteArray, byteArray.length);
                } catch (Exception e2) {
                    throw new QTESLAKeyFactorySpi("unable to process block", e2);
                }
            } else if (i3 == 2 || i3 == 4) {
                try {
                    ButtonCustomization buttonCustomization4 = this.cca_continue;
                    setKeyboardNavigationCluster setkeyboardnavigationcluster6 = this.getSDKVersion;
                    RSAUtil rSAUtil = new RSAUtil(bCRSAPublicKey);
                    buttonCustomization4.init = false;
                    buttonCustomization4.getInstance = setkeyboardnavigationcluster6;
                    buttonCustomization4.getSDKVersion = rSAUtil;
                    buttonCustomization4.Cardinal(sHA1WithRSAEncryption);
                    return this.cca_continue.Cardinal(byteArray, byteArray.length);
                } catch (KeyFactorySpi.ECDH e3) {
                    throw new QTESLAKeyFactorySpi("unable to process block", e3);
                }
            } else {
                throw new IllegalStateException("cipher not initialised");
            }
        }
    }
}
