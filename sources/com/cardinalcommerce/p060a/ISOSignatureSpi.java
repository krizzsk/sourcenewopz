package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.ISOSignatureSpi */
public class ISOSignatureSpi implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    private byte[] Cardinal;
    private byte[] cca_continue;
    public int getInstance;

    /* renamed from: com.cardinalcommerce.a.ISOSignatureSpi$MD5WithRSAEncryption */
    public final class MD5WithRSAEncryption implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        private byte[] configure;

        public MD5WithRSAEncryption(byte[] bArr) {
            this(bArr, bArr.length);
        }

        private MD5WithRSAEncryption(byte[] bArr, int i) {
            byte[] bArr2 = new byte[i];
            this.configure = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, i);
        }

        public final byte[] getInstance() {
            return this.configure;
        }
    }

    /* renamed from: com.cardinalcommerce.a.ISOSignatureSpi$RIPEMD160WithRSAEncryption */
    public final class RIPEMD160WithRSAEncryption implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    }

    /* renamed from: com.cardinalcommerce.a.ISOSignatureSpi$SHA1WithRSAEncryption */
    public final class SHA1WithRSAEncryption extends ISOSignatureSpi {
        public int configure;

        public SHA1WithRSAEncryption(byte[] bArr, byte[] bArr2, int i, int i2) {
            super(bArr, bArr2, i);
            this.configure = i2;
        }
    }

    /* renamed from: com.cardinalcommerce.a.ISOSignatureSpi$SHA224WithRSAEncryption */
    public final class SHA224WithRSAEncryption implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        public SecureRandom configure;
        public KeyAgreementSpi.ECKAEGwithSHA512KDF getInstance;

        public SHA224WithRSAEncryption(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF, SecureRandom secureRandom) {
            this.configure = secureRandom;
            this.getInstance = eCKAEGwithSHA512KDF;
        }
    }

    /* renamed from: com.cardinalcommerce.a.ISOSignatureSpi$SHA384WithRSAEncryption */
    public final class SHA384WithRSAEncryption implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        private byte[] cca_continue;
        public KeyAgreementSpi.ECKAEGwithSHA512KDF configure;

        public SHA384WithRSAEncryption(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF, byte[] bArr) {
            this(eCKAEGwithSHA512KDF, bArr, bArr.length);
        }

        private SHA384WithRSAEncryption(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF, byte[] bArr, int i) {
            byte[] bArr2 = new byte[i];
            this.cca_continue = bArr2;
            this.configure = eCKAEGwithSHA512KDF;
            System.arraycopy(bArr, 0, bArr2, 0, i);
        }

        public final byte[] Cardinal() {
            return this.cca_continue;
        }
    }

    /* renamed from: com.cardinalcommerce.a.ISOSignatureSpi$SHA512WithRSAEncryption */
    public final class SHA512WithRSAEncryption implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        public KeyAgreementSpi.ECKAEGwithSHA512KDF cca_continue;
        private byte[] configure;

        public SHA512WithRSAEncryption(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF, byte[] bArr) {
            this.cca_continue = eCKAEGwithSHA512KDF;
            this.configure = bArr;
        }

        public final byte[] init() {
            return this.configure;
        }
    }

    /* renamed from: com.cardinalcommerce.a.ISOSignatureSpi$SHA512_256WithRSAEncryption */
    public final class SHA512_256WithRSAEncryption implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        private byte[] Cardinal;
        public KeyAgreementSpi.ECKAEGwithSHA512KDF init;

        public SHA512_256WithRSAEncryption(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF, byte[] bArr) {
            this(eCKAEGwithSHA512KDF, bArr, bArr.length);
        }

        private SHA512_256WithRSAEncryption(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF, byte[] bArr, int i) {
            byte[] bArr2 = new byte[i];
            this.Cardinal = bArr2;
            this.init = eCKAEGwithSHA512KDF;
            System.arraycopy(bArr, 0, bArr2, 0, i);
        }

        public final byte[] configure() {
            return this.Cardinal;
        }
    }

    public ISOSignatureSpi(byte[] bArr, byte[] bArr2, int i) {
        this.Cardinal = setForegroundTintBlendMode.cca_continue(bArr);
        this.cca_continue = setForegroundTintBlendMode.cca_continue(bArr2);
        this.getInstance = i;
    }

    public final byte[] configure() {
        return setForegroundTintBlendMode.cca_continue(this.cca_continue);
    }

    public final byte[] init() {
        return setForegroundTintBlendMode.cca_continue(this.Cardinal);
    }

    /* renamed from: com.cardinalcommerce.a.ISOSignatureSpi$SHA256WithRSAEncryption */
    public final class SHA256WithRSAEncryption implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        public DigestSignatureSpi cca_continue;
        public DigestSignatureSpi.MD2 getInstance;
        public DigestSignatureSpi.MD2 init;

        public SHA256WithRSAEncryption(DigestSignatureSpi.MD2 md2, DigestSignatureSpi.MD2 md22, DigestSignatureSpi digestSignatureSpi) {
            if (md2 == null) {
                throw new NullPointerException("staticPrivateKey cannot be null");
            } else if (md22 != null) {
                BCRSAPublicKey bCRSAPublicKey = md2.init;
                if (bCRSAPublicKey.equals(md22.init)) {
                    if (digestSignatureSpi == null) {
                        digestSignatureSpi = new DigestSignatureSpi(bCRSAPublicKey.init.configure(md22.Cardinal), bCRSAPublicKey);
                    } else if (!bCRSAPublicKey.equals(digestSignatureSpi.init)) {
                        throw new IllegalArgumentException("Ephemeral public key has different domain parameters");
                    }
                    this.init = md2;
                    this.getInstance = md22;
                    this.cca_continue = digestSignatureSpi;
                    return;
                }
                throw new IllegalArgumentException("Static and ephemeral private keys have different domain parameters");
            } else {
                throw new NullPointerException("ephemeralPrivateKey cannot be null");
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.ISOSignatureSpi$SHA512_224WithRSAEncryption */
    public final class SHA512_224WithRSAEncryption implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        public DigestSignatureSpi getInstance;
        public DigestSignatureSpi init;

        public SHA512_224WithRSAEncryption(DigestSignatureSpi digestSignatureSpi, DigestSignatureSpi digestSignatureSpi2) {
            if (digestSignatureSpi == null) {
                throw new NullPointerException("staticPublicKey cannot be null");
            } else if (digestSignatureSpi2 == null) {
                throw new NullPointerException("ephemeralPublicKey cannot be null");
            } else if (digestSignatureSpi.init.equals(digestSignatureSpi2.init)) {
                this.init = digestSignatureSpi;
                this.getInstance = digestSignatureSpi2;
            } else {
                throw new IllegalArgumentException("Static and ephemeral public keys have different domain parameters");
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.ISOSignatureSpi$WhirlpoolWithRSAEncryption */
    public class WhirlpoolWithRSAEncryption extends setKeyboardNavigationCluster {
        private static final BigInteger getInstance = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);
        private static final BigInteger init = BigInteger.valueOf(1);
        public BigInteger Cardinal;
        public BigInteger configure;

        public WhirlpoolWithRSAEncryption(boolean z, BigInteger bigInteger, BigInteger bigInteger2) {
            super(z);
            if (!z && (bigInteger2.intValue() & 1) == 0) {
                throw new IllegalArgumentException("RSA publicExponent is even");
            } else if ((bigInteger.intValue() & 1) == 0) {
                throw new IllegalArgumentException("RSA modulus is even");
            } else if (setMinimumHeight.Cardinal("com.cardinalcommerce.dependencies.internal.bouncycastle.rsa.allow_unsafe_mod") || bigInteger.gcd(getInstance).equals(init)) {
                this.configure = bigInteger;
                this.Cardinal = bigInteger2;
            } else {
                throw new IllegalArgumentException("RSA modulus has a small prime factor");
            }
        }
    }
}
