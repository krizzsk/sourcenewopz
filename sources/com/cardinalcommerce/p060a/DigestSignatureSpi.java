package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.DigestSignatureSpi */
public final class DigestSignatureSpi extends MD4 {
    public final ChallengeParameters cca_continue;

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$MD2 */
    public final class MD2 extends MD4 {
        public BigInteger Cardinal;

        public MD2(BigInteger bigInteger, BCRSAPublicKey bCRSAPublicKey) {
            super(true, bCRSAPublicKey);
            this.Cardinal = bigInteger;
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$MD4 */
    public class MD4 extends setKeyboardNavigationCluster {
        public BCRSAPublicKey init;

        protected MD4(boolean z, BCRSAPublicKey bCRSAPublicKey) {
            super(z);
            this.init = bCRSAPublicKey;
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$MD5 */
    public final class MD5 extends setKeyboardNavigationCluster {
        public final byte[] Cardinal;

        public MD5(SecureRandom secureRandom) {
            super(true);
            byte[] bArr = new byte[32];
            this.Cardinal = bArr;
            setImportantForAutofill.init(secureRandom, bArr);
        }

        public MD5(byte[] bArr) {
            super(true);
            byte[] bArr2 = new byte[32];
            this.Cardinal = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, 32);
        }

        public final byte[] getEncoded() {
            return setForegroundTintBlendMode.cca_continue(this.Cardinal);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$RIPEMD128 */
    public final class RIPEMD128 extends setKeyboardNavigationCluster {
        public final byte[] Cardinal;

        public RIPEMD128(byte[] bArr, int i) {
            super(false);
            byte[] bArr2 = new byte[57];
            this.Cardinal = bArr2;
            System.arraycopy(bArr, i, bArr2, 0, 57);
        }

        public final byte[] getEncoded() {
            return setForegroundTintBlendMode.cca_continue(this.Cardinal);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$RIPEMD160 */
    public final class RIPEMD160 extends GOST3410Util {
        public RIPEMD160(SecureRandom secureRandom) {
            super(secureRandom, 448);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$RIPEMD256 */
    public final class RIPEMD256 extends setKeyboardNavigationCluster {
        public final byte[] init;

        public RIPEMD256(byte[] bArr, int i) {
            super(false);
            byte[] bArr2 = new byte[32];
            this.init = bArr2;
            System.arraycopy(bArr, i, bArr2, 0, 32);
        }

        public final byte[] getEncoded() {
            return setForegroundTintBlendMode.cca_continue(this.init);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$SHA1 */
    public final class SHA1 extends setKeyboardNavigationCluster {
        public final byte[] cca_continue;

        public SHA1(SecureRandom secureRandom) {
            super(true);
            byte[] bArr = new byte[57];
            this.cca_continue = bArr;
            setAutofillId.cca_continue(secureRandom, bArr);
        }

        public SHA1(byte[] bArr) {
            super(true);
            byte[] bArr2 = new byte[57];
            this.cca_continue = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, 57);
        }

        public final byte[] getEncoded() {
            return setForegroundTintBlendMode.cca_continue(this.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$SHA3_384 */
    public final class SHA3_384 extends SHA3_512 {
        public BigInteger getInstance;

        public SHA3_384(BigInteger bigInteger, SHA512_256 sha512_256) {
            super(false, sha512_256);
            this.getInstance = bigInteger;
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$SHA3_512 */
    public class SHA3_512 extends setKeyboardNavigationCluster {
        public SHA512_256 cca_continue;

        public SHA3_512(boolean z, SHA512_256 sha512_256) {
            super(z);
            this.cca_continue = sha512_256;
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$SHA512_224 */
    public final class SHA512_224 extends SHA3_512 {
        public BigInteger configure;

        public SHA512_224(BigInteger bigInteger, SHA512_256 sha512_256) {
            super(true, sha512_256);
            this.configure = bigInteger;
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$noneRSA */
    public final class noneRSA implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        private byte[] getInstance;
        private byte[] init;

        public noneRSA(byte[] bArr, byte[] bArr2) {
            this.init = bArr;
            this.getInstance = bArr2;
        }

        public final byte[] configure() {
            return this.init;
        }

        public final byte[] getInstance() {
            return this.getInstance;
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$SHA224 */
    public final class SHA224 implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        public int cca_continue;
        public BigInteger configure;
        public BigInteger init;

        public SHA224(BigInteger bigInteger, BigInteger bigInteger2) {
            this(bigInteger, bigInteger2, 0);
        }

        public SHA224(BigInteger bigInteger, BigInteger bigInteger2, int i) {
            this.configure = bigInteger2;
            this.init = bigInteger;
            this.cca_continue = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SHA224)) {
                return false;
            }
            SHA224 sha224 = (SHA224) obj;
            if (!sha224.init.equals(this.init) || !sha224.configure.equals(this.configure) || sha224.cca_continue != this.cca_continue) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (this.init.hashCode() ^ this.configure.hashCode()) + this.cca_continue;
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$SHA384 */
    public final class SHA384 extends SHA3_224 {
        public BigInteger Cardinal;

        public SHA384(BigInteger bigInteger, SHA224 sha224) {
            super(false, sha224);
            this.Cardinal = bigInteger;
        }

        public final int hashCode() {
            return this.Cardinal.hashCode() ^ super.hashCode();
        }

        public final boolean equals(Object obj) {
            return (obj instanceof SHA384) && ((SHA384) obj).Cardinal.equals(this.Cardinal) && super.equals(obj);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$SHA3_224 */
    public class SHA3_224 extends setKeyboardNavigationCluster {
        public SHA224 configure;

        protected SHA3_224(boolean z, SHA224 sha224) {
            super(z);
            this.configure = sha224;
        }

        public int hashCode() {
            SHA224 sha224 = this.configure;
            if (sha224 != null) {
                return sha224.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SHA3_224)) {
                return false;
            }
            SHA3_224 sha3_224 = (SHA3_224) obj;
            SHA224 sha224 = this.configure;
            if (sha224 != null) {
                return sha224.equals(sha3_224.configure);
            }
            if (sha3_224.configure == null) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$SHA3_256 */
    public final class SHA3_256 extends SHA3_224 {
        public BigInteger cca_continue;

        public SHA3_256(BigInteger bigInteger, SHA224 sha224) {
            super(true, sha224);
            this.cca_continue = bigInteger;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof SHA3_256) && ((SHA3_256) obj).cca_continue.equals(this.cca_continue)) {
                return super.equals(obj);
            }
            return false;
        }

        public final int hashCode() {
            return this.cca_continue.hashCode();
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$SHA512 */
    public final class SHA512 extends GOST3410Util {
        public SHA512_256 init;

        public SHA512(SecureRandom secureRandom, SHA512_256 sha512_256) {
            super(secureRandom, sha512_256.cca_continue.bitLength() - 1);
            this.init = sha512_256;
        }
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$SHA512_256 */
    public final class SHA512_256 implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
        public BigInteger cca_continue;
        public BigInteger configure;
        public BigInteger getInstance;

        public SHA512_256(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this.cca_continue = bigInteger;
            this.configure = bigInteger2;
            this.getInstance = bigInteger3;
        }

        public final int hashCode() {
            return (this.cca_continue.hashCode() ^ this.configure.hashCode()) ^ this.getInstance.hashCode();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SHA512_256)) {
                return false;
            }
            SHA512_256 sha512_256 = (SHA512_256) obj;
            if (!sha512_256.cca_continue.equals(this.cca_continue) || !sha512_256.configure.equals(this.configure) || !sha512_256.getInstance.equals(this.getInstance)) {
                return false;
            }
            return true;
        }
    }

    public DigestSignatureSpi(ChallengeParameters challengeParameters, BCRSAPublicKey bCRSAPublicKey) {
        super(false, bCRSAPublicKey);
        this.cca_continue = BCRSAPublicKey.getInstance(bCRSAPublicKey.Cardinal, challengeParameters);
    }

    /* renamed from: com.cardinalcommerce.a.DigestSignatureSpi$SHA256 */
    public final class SHA256 extends GOST3410Util {
        public SHA224 cca_continue;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SHA256(java.security.SecureRandom r2, com.cardinalcommerce.p060a.DigestSignatureSpi.SHA224 r3) {
            /*
                r1 = this;
                int r0 = r3.cca_continue
                if (r0 == 0) goto L_0x0007
                int r0 = r3.cca_continue
                goto L_0x000d
            L_0x0007:
                java.math.BigInteger r0 = r3.init
                int r0 = r0.bitLength()
            L_0x000d:
                r1.<init>(r2, r0)
                r1.cca_continue = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.DigestSignatureSpi.SHA256.<init>(java.security.SecureRandom, com.cardinalcommerce.a.DigestSignatureSpi$SHA224):void");
        }
    }
}
