package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.p060a.BCECGOST3410PrivateKey;
import com.cardinalcommerce.p060a.ECGOST2012SignatureSpi512;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.JWSObject;
import com.cardinalcommerce.p060a.JWSVerifier;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.QTESLAKeyFactorySpi;
import com.cardinalcommerce.p060a.SignatureSpi;
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

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi */
public class GMCipherSpi extends CipherSpi {
    private KeyAgreementSpi.X25519UwithSHA256KDF Cardinal;
    private setKeyboardNavigationCluster cca_continue;
    private SecureRandom configure;
    private ErasableOutputStream getInstance = new ErasableOutputStream();
    private int init = -1;

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2 */
    public static class SM2 extends GMCipherSpi {
        public SM2() {
            super(new KeyAgreementSpi.X25519UwithSHA256KDF());
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withBlake2b */
    public static class SM2withBlake2b extends GMCipherSpi {
        public SM2withBlake2b() {
            super(new KeyAgreementSpi.X25519UwithSHA256KDF(new SignatureSpi.ecDSA512((byte) 0)));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withBlake2s */
    public static class SM2withBlake2s extends GMCipherSpi {
        public SM2withBlake2s() {
            super(new KeyAgreementSpi.X25519UwithSHA256KDF(new SignatureSpi.ecDSASha3_224((byte) 0)));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withMD5 */
    public static class SM2withMD5 extends GMCipherSpi {
        public SM2withMD5() {
            super(new KeyAgreementSpi.X25519UwithSHA256KDF(new SignatureSpi.ecDetDSA512()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withRMD */
    public static class SM2withRMD extends GMCipherSpi {
        public SM2withRMD() {
            super(new KeyAgreementSpi.X25519UwithSHA256KDF(new SignatureSpi.ecDetDSASha3_256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha1 */
    public static class SM2withSha1 extends GMCipherSpi {
        public SM2withSha1() {
            super(new KeyAgreementSpi.X25519UwithSHA256KDF(new SignatureSpi.ecNR224()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha224 */
    public static class SM2withSha224 extends GMCipherSpi {
        public SM2withSha224() {
            super(new KeyAgreementSpi.X25519UwithSHA256KDF(new SignatureSpi.ecNR256()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha256 */
    public static class SM2withSha256 extends GMCipherSpi {
        public SM2withSha256() {
            super(new KeyAgreementSpi.X25519UwithSHA256KDF(new SignatureSpi.ecNR()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha384 */
    public static class SM2withSha384 extends GMCipherSpi {
        public SM2withSha384() {
            super(new KeyAgreementSpi.X25519UwithSHA256KDF(new SignatureSpi.ecNR384()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha512 */
    public static class SM2withSha512 extends GMCipherSpi {
        public SM2withSha512() {
            super(new KeyAgreementSpi.X25519UwithSHA256KDF(new BCECGOST3410PrivateKey()));
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withWhirlpool */
    public static class SM2withWhirlpool extends GMCipherSpi {
        public SM2withWhirlpool() {
            super(new KeyAgreementSpi.X25519UwithSHA256KDF(new ECGOST2012SignatureSpi512()));
        }
    }

    public GMCipherSpi(KeyAgreementSpi.X25519UwithSHA256KDF x25519UwithSHA256KDF) {
        new JWSObject();
        this.Cardinal = x25519UwithSHA256KDF;
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i, i2);
        System.arraycopy(engineDoFinal, 0, bArr2, i3, engineDoFinal.length);
        return engineDoFinal.length;
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        byte[] cca_continue2;
        if (i2 != 0) {
            this.getInstance.write(bArr, i, i2);
        }
        try {
            if (this.init != 1) {
                if (this.init != 3) {
                    if (this.init != 2) {
                        if (this.init != 4) {
                            throw new IllegalStateException("cipher not initialised");
                        }
                    }
                    this.Cardinal.configure(false, this.cca_continue);
                    cca_continue2 = this.Cardinal.cca_continue(this.getInstance.Cardinal(), this.getInstance.size());
                    this.getInstance.getInstance();
                    return cca_continue2;
                }
            }
            this.Cardinal.configure(true, new ISOSignatureSpi.SHA224WithRSAEncryption(this.cca_continue, this.configure));
            cca_continue2 = this.Cardinal.cca_continue(this.getInstance.Cardinal(), this.getInstance.size());
            this.getInstance.getInstance();
            return cca_continue2;
        } catch (Exception e) {
            throw new QTESLAKeyFactorySpi("unable to process block", e);
        } catch (Exception e2) {
            throw new QTESLAKeyFactorySpi("unable to process block", e2);
        } catch (Throwable th) {
            this.getInstance.getInstance();
            throw th;
        }
    }

    public int engineGetBlockSize() {
        return 0;
    }

    public byte[] engineGetIV() {
        return null;
    }

    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameters == null) {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
            return;
        }
        StringBuilder sb = new StringBuilder("cannot recognise parameters: ");
        sb.append(algorithmParameters.getClass().getName());
        throw new InvalidAlgorithmParameterException(sb.toString());
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
        if (!setAnimation.Cardinal(str).equals(IStoreCallback.DEFAULT_API_DETAIL_KEY)) {
            throw new IllegalArgumentException("can't support mode ".concat(String.valueOf(str)));
        }
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        if (!setAnimation.Cardinal(str).equals("NOPADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
    }

    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.getInstance.write(bArr, i, i2);
        return 0;
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.getInstance.write(bArr, i, i2);
        return null;
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$ErasableOutputStream */
    protected static final class ErasableOutputStream extends ByteArrayOutputStream {
        public final byte[] Cardinal() {
            return this.buf;
        }

        public final void getInstance() {
            byte[] bArr = this.buf;
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = 0;
            }
            reset();
        }
    }

    public int engineGetKeySize(Key key) {
        if (key instanceof JWSVerifier) {
            return ((JWSVerifier) key).Cardinal().init.configure();
        }
        throw new IllegalArgumentException("not an EC key");
    }

    public int engineGetOutputSize(int i) {
        int i2;
        int instance;
        int i3 = this.init;
        if (i3 == 1 || i3 == 3) {
            KeyAgreementSpi.X25519UwithSHA256KDF x25519UwithSHA256KDF = this.Cardinal;
            i2 = (x25519UwithSHA256KDF.configure * 2) + 1 + i;
            instance = x25519UwithSHA256KDF.getInstance.getInstance();
        } else if (i3 == 2 || i3 == 4) {
            KeyAgreementSpi.X25519UwithSHA256KDF x25519UwithSHA256KDF2 = this.Cardinal;
            i2 = (x25519UwithSHA256KDF2.configure * 2) + 1 + i;
            instance = x25519UwithSHA256KDF2.getInstance.getInstance();
        } else {
            throw new IllegalStateException("cipher not initialised");
        }
        return i2 + instance;
    }

    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException, InvalidKeyException {
        setKeyboardNavigationCluster setkeyboardnavigationcluster;
        if (i == 1 || i == 3) {
            if (key instanceof PublicKey) {
                PublicKey publicKey = (PublicKey) key;
                if (publicKey instanceof BCECPublicKey) {
                    setkeyboardnavigationcluster = ((BCECPublicKey) publicKey).configure;
                } else {
                    setkeyboardnavigationcluster = ECUtil.Cardinal(publicKey);
                }
            } else {
                throw new InvalidKeyException("must be passed public EC key for encryption");
            }
        } else if (i != 2 && i != 4) {
            throw new InvalidKeyException("must be passed EC key");
        } else if (key instanceof PrivateKey) {
            setkeyboardnavigationcluster = ECUtil.getInstance((PrivateKey) key);
        } else {
            throw new InvalidKeyException("must be passed private EC key for decryption");
        }
        this.cca_continue = setkeyboardnavigationcluster;
        if (secureRandom != null) {
            this.configure = secureRandom;
        } else {
            this.configure = KeyAgreementSpi.MQV.cca_continue();
        }
        this.init = i;
        this.getInstance.reset();
    }
}
