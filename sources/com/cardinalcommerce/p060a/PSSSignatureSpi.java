package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.PSSSignatureSpi */
public final class PSSSignatureSpi implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    public KeyAgreementSpi.ECKAEGwithSHA512KDF Cardinal = null;
    private byte[] getInstance;

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$PSSwithRSA */
    public final class PSSwithRSA implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$SHA1withRSA */
    public final class SHA1withRSA extends GOST3410Util {
        public BigInteger cca_continue;
        public int init;

        public SHA1withRSA(BigInteger bigInteger, SecureRandom secureRandom, int i, int i2) {
            super(secureRandom, i);
            if (i < 12) {
                throw new IllegalArgumentException("key strength too small");
            } else if (bigInteger.testBit(0)) {
                this.cca_continue = bigInteger;
                this.init = i2;
            } else {
                throw new IllegalArgumentException("public exponent cannot be even");
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$SHA224withRSA */
    public final class SHA224withRSA extends ISOSignatureSpi.WhirlpoolWithRSAEncryption {
        public BigInteger CardinalError;
        public BigInteger cca_continue;
        public BigInteger getInstance;
        public BigInteger getSDKVersion;
        public BigInteger init;
        public BigInteger values;

        public SHA224withRSA(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
            super(true, bigInteger, bigInteger3);
            this.getInstance = bigInteger2;
            this.cca_continue = bigInteger4;
            this.init = bigInteger5;
            this.values = bigInteger6;
            this.CardinalError = bigInteger7;
            this.getSDKVersion = bigInteger8;
        }
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$SHA256withRSA */
    public final class SHA256withRSA extends GOST3410Util {
        public SHA256withRSA(SecureRandom secureRandom) {
            super(secureRandom, 255);
        }
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$SHA384withRSA */
    public final class SHA384withRSA extends GOST3410Util {
        public SHA384withRSA(SecureRandom secureRandom) {
            super(secureRandom, 448);
        }
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$SHA3_256withRSA */
    public final class SHA3_256withRSA extends setKeyboardNavigationCluster {
        public final byte[] configure;

        public SHA3_256withRSA(byte[] bArr, int i) {
            super(false);
            byte[] bArr2 = new byte[32];
            this.configure = bArr2;
            System.arraycopy(bArr, i, bArr2, 0, 32);
        }

        public final byte[] getEncoded() {
            return setForegroundTintBlendMode.cca_continue(this.configure);
        }
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$SHA3_384withRSA */
    public final class SHA3_384withRSA extends setKeyboardNavigationCluster {
        public final byte[] configure;

        public SHA3_384withRSA(byte[] bArr, int i) {
            super(false);
            byte[] bArr2 = new byte[56];
            this.configure = bArr2;
            System.arraycopy(bArr, i, bArr2, 0, 56);
        }

        public final byte[] getEncoded() {
            return setForegroundTintBlendMode.cca_continue(this.configure);
        }
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$SHA3_512withRSA */
    public final class SHA3_512withRSA implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        public setKeyboardNavigationCluster getInstance;
        public setKeyboardNavigationCluster init;

        public SHA3_512withRSA(setKeyboardNavigationCluster setkeyboardnavigationcluster, setKeyboardNavigationCluster setkeyboardnavigationcluster2) {
            if (setkeyboardnavigationcluster == null) {
                throw new NullPointerException("staticPublicKey cannot be null");
            } else if (!(setkeyboardnavigationcluster instanceof SHA3_384withRSA) && !(setkeyboardnavigationcluster instanceof SHA3_256withRSA)) {
                throw new IllegalArgumentException("only X25519 and X448 paramaters can be used");
            } else if (setkeyboardnavigationcluster2 == null) {
                throw new NullPointerException("ephemeralPublicKey cannot be null");
            } else if (setkeyboardnavigationcluster.getClass().isAssignableFrom(setkeyboardnavigationcluster2.getClass())) {
                this.getInstance = setkeyboardnavigationcluster;
                this.init = setkeyboardnavigationcluster2;
            } else {
                throw new IllegalArgumentException("static and ephemeral public keys have different domain parameters");
            }
        }
    }

    public PSSSignatureSpi(byte[] bArr) {
        this.getInstance = bArr;
    }

    public final byte[] cca_continue() {
        return this.getInstance;
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$SHA3_224withRSA */
    public final class SHA3_224withRSA extends setKeyboardNavigationCluster {
        public final byte[] configure;

        public SHA3_224withRSA(byte[] bArr) {
            super(true);
            byte[] bArr2 = new byte[32];
            this.configure = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, 32);
        }

        public final byte[] getEncoded() {
            return setForegroundTintBlendMode.cca_continue(this.configure);
        }

        public SHA3_224withRSA(SecureRandom secureRandom) {
            super(true);
            byte[] bArr = new byte[32];
            this.configure = bArr;
            secureRandom.nextBytes(bArr);
            bArr[0] = (byte) (bArr[0] & 248);
            bArr[31] = (byte) (bArr[31] & Byte.MAX_VALUE);
            bArr[31] = (byte) (bArr[31] | 64);
        }
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$SHA512_224withRSA */
    public final class SHA512_224withRSA implements KeyFactorySpi.ECGOST3410 {
        private CipherSpi Cardinal;

        public SHA512_224withRSA(CipherSpi cipherSpi) {
            this.Cardinal = cipherSpi;
        }

        public final setKeyboardNavigationCluster Cardinal(InputStream inputStream) throws IOException {
            int bitLength = (this.Cardinal.Cardinal.bitLength() + 7) / 8;
            byte[] bArr = new byte[bitLength];
            setTooltipText.init(inputStream, bArr, 0, bitLength);
            return new CipherSpi.PKCS1v1_5Padding(new BigInteger(1, bArr), this.Cardinal);
        }
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$SHA512_256withRSA */
    public final class SHA512_256withRSA extends setKeyboardNavigationCluster {
        public final byte[] getInstance;

        public SHA512_256withRSA(byte[] bArr) {
            super(true);
            byte[] bArr2 = new byte[56];
            this.getInstance = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, 56);
        }

        public final byte[] getEncoded() {
            return setForegroundTintBlendMode.cca_continue(this.getInstance);
        }

        public SHA512_256withRSA(SecureRandom secureRandom) {
            super(true);
            byte[] bArr = new byte[56];
            this.getInstance = bArr;
            secureRandom.nextBytes(bArr);
            bArr[0] = (byte) (bArr[0] & 252);
            bArr[55] = (byte) (bArr[55] | 128);
        }

        public final SHA3_384withRSA Cardinal() {
            byte[] bArr = new byte[56];
            setRevealOnFocusHint.Cardinal(this.getInstance, 0, bArr, 0);
            return new SHA3_384withRSA(bArr, 0);
        }
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$SHA512withRSA */
    public final class SHA512withRSA implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        public setKeyboardNavigationCluster cca_continue;
        public setKeyboardNavigationCluster getInstance;

        public SHA512withRSA(setKeyboardNavigationCluster setkeyboardnavigationcluster, setKeyboardNavigationCluster setkeyboardnavigationcluster2, setKeyboardNavigationCluster setkeyboardnavigationcluster3) {
            if (setkeyboardnavigationcluster != null) {
                boolean z = setkeyboardnavigationcluster instanceof SHA512_256withRSA;
                if (!z && !(setkeyboardnavigationcluster instanceof SHA3_224withRSA)) {
                    throw new IllegalArgumentException("only X25519 and X448 paramaters can be used");
                } else if (setkeyboardnavigationcluster2 == null) {
                    throw new NullPointerException("ephemeralPrivateKey cannot be null");
                } else if (setkeyboardnavigationcluster.getClass().isAssignableFrom(setkeyboardnavigationcluster2.getClass())) {
                    if (setkeyboardnavigationcluster3 == null) {
                        if (setkeyboardnavigationcluster2 instanceof SHA512_256withRSA) {
                            ((SHA512_256withRSA) setkeyboardnavigationcluster2).Cardinal();
                        } else {
                            byte[] bArr = new byte[32];
                            setOnHoverListener.Cardinal(((SHA3_224withRSA) setkeyboardnavigationcluster2).configure, 0, bArr, 0);
                            new SHA3_256withRSA(bArr, 0);
                        }
                    } else if ((setkeyboardnavigationcluster3 instanceof SHA3_384withRSA) && !z) {
                        throw new IllegalArgumentException("ephemeral public key has different domain parameters");
                    } else if ((setkeyboardnavigationcluster3 instanceof SHA3_256withRSA) && !(setkeyboardnavigationcluster instanceof SHA3_224withRSA)) {
                        throw new IllegalArgumentException("ephemeral public key has different domain parameters");
                    }
                    this.getInstance = setkeyboardnavigationcluster;
                    this.cca_continue = setkeyboardnavigationcluster2;
                } else {
                    throw new IllegalArgumentException("static and ephemeral private keys have different domain parameters");
                }
            } else {
                throw new NullPointerException("staticPrivateKey cannot be null");
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.PSSSignatureSpi$nonePSS */
    public final class nonePSS implements KeyFactorySpi.C1979EC {
        private static final BigInteger configure = BigInteger.valueOf(1);
        private SecureRandom cca_continue;
        private DigestSignatureSpi.MD4 init;

        public final void getInstance(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            DigestSignatureSpi.MD4 md4;
            if (z) {
                if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
                    ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption = (ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF;
                    this.cca_continue = sHA224WithRSAEncryption.configure;
                    eCKAEGwithSHA512KDF = sHA224WithRSAEncryption.getInstance;
                } else {
                    this.cca_continue = KeyAgreementSpi.MQV.cca_continue();
                }
                md4 = (DigestSignatureSpi.MD2) eCKAEGwithSHA512KDF;
            } else {
                md4 = (DigestSignatureSpi) eCKAEGwithSHA512KDF;
            }
            this.init = md4;
        }

        public final BigInteger cca_continue() {
            return this.init.init.cca_continue;
        }

        public final BigInteger[] configure(byte[] bArr) {
            BCRSAPublicKey bCRSAPublicKey = this.init.init;
            getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
            BigInteger bigInteger = new BigInteger(1, setForegroundTintBlendMode.Cardinal(bArr));
            int configure2 = getsdkappid.configure();
            if (bigInteger.bitLength() > configure2) {
                bigInteger = bigInteger.mod(configure.shiftLeft(configure2));
            }
            getAcsTransactionID configure3 = getsdkappid.configure(bigInteger);
            if (configure3.cleanup()) {
                configure3 = getsdkappid.configure(configure);
            }
            BigInteger bigInteger2 = bCRSAPublicKey.cca_continue;
            BigInteger bigInteger3 = ((DigestSignatureSpi.MD2) this.init).Cardinal;
            setAcsRefNumber setacsrefnumber = new setAcsRefNumber();
            while (true) {
                BigInteger configure4 = setSelected.configure(bigInteger2.bitLength() - 1, this.cca_continue);
                getAcsTransactionID sDKVersion = setacsrefnumber.configure(bCRSAPublicKey.init, configure4).CardinalRenderType().getSDKVersion();
                if (!sDKVersion.cleanup()) {
                    BigInteger Cardinal = configure3.init(sDKVersion).Cardinal();
                    int bitLength = bigInteger2.bitLength() - 1;
                    if (Cardinal.bitLength() > bitLength) {
                        Cardinal = Cardinal.mod(configure.shiftLeft(bitLength));
                    }
                    if (Cardinal.signum() != 0) {
                        BigInteger mod = Cardinal.multiply(bigInteger3).add(configure4).mod(bigInteger2);
                        if (mod.signum() != 0) {
                            return new BigInteger[]{Cardinal, mod};
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        public final boolean init(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
            if (bigInteger.signum() > 0 && bigInteger2.signum() > 0) {
                BCRSAPublicKey bCRSAPublicKey = this.init.init;
                BigInteger bigInteger3 = bCRSAPublicKey.cca_continue;
                if (bigInteger.compareTo(bigInteger3) < 0 && bigInteger2.compareTo(bigInteger3) < 0) {
                    getSDKAppID getsdkappid = bCRSAPublicKey.Cardinal;
                    BigInteger bigInteger4 = new BigInteger(1, setForegroundTintBlendMode.Cardinal(bArr));
                    int configure2 = getsdkappid.configure();
                    if (bigInteger4.bitLength() > configure2) {
                        bigInteger4 = bigInteger4.mod(configure.shiftLeft(configure2));
                    }
                    getAcsTransactionID configure3 = getsdkappid.configure(bigInteger4);
                    if (configure3.cleanup()) {
                        configure3 = getsdkappid.configure(configure);
                    }
                    ChallengeParameters CardinalRenderType = getDeviceData.init(bCRSAPublicKey.init, bigInteger2, ((DigestSignatureSpi) this.init).cca_continue, bigInteger).CardinalRenderType();
                    if (CardinalRenderType.valueOf()) {
                        return false;
                    }
                    BigInteger Cardinal = configure3.init(CardinalRenderType.getSDKVersion()).Cardinal();
                    int bitLength = bigInteger3.bitLength() - 1;
                    if (Cardinal.bitLength() > bitLength) {
                        Cardinal = Cardinal.mod(configure.shiftLeft(bitLength));
                    }
                    if (Cardinal.compareTo(bigInteger) == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
