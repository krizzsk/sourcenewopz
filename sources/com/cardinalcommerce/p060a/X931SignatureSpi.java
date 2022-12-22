package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.AlgorithmParametersSpi;
import com.cardinalcommerce.p060a.BaseCipherSpi;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* renamed from: com.cardinalcommerce.a.X931SignatureSpi */
public interface X931SignatureSpi {

    /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$RIPEMD128WithRSAEncryption */
    public interface RIPEMD128WithRSAEncryption {
        BigInteger[] configure(BigInteger bigInteger, byte[] bArr) throws IOException;

        byte[] getInstance(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) throws IOException;
    }

    BigInteger Cardinal();

    void cca_continue(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr);

    boolean getInstance();

    void init(BigInteger bigInteger, SecureRandom secureRandom);

    /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$SHA512WithRSAEncryption */
    public final class SHA512WithRSAEncryption implements KeyPairGeneratorSpi.ECDSA {
        private final C1985configure Cardinal = new C1985configure((byte) 0);
        private DigestSignatureSpi.RIPEMD256 cca_continue;
        private boolean getInstance;
        private DigestSignatureSpi.MD5 init;

        public final byte[] Cardinal() {
            DigestSignatureSpi.MD5 md5;
            if (this.getInstance && (md5 = this.init) != null) {
                return this.Cardinal.init(md5, this.cca_continue);
            }
            throw new IllegalStateException("Ed25519Signer not initialised for signature generation.");
        }

        public final void cca_continue(byte[] bArr, int i, int i2) {
            this.Cardinal.write(bArr, i, i2);
        }

        public final void init(byte b) {
            this.Cardinal.write(b);
        }

        public final boolean init(byte[] bArr) {
            DigestSignatureSpi.RIPEMD256 ripemd256;
            if (!this.getInstance && (ripemd256 = this.cca_continue) != null) {
                return this.Cardinal.configure(ripemd256, bArr);
            }
            throw new IllegalStateException("Ed25519Signer not initialised for verification");
        }

        /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$SHA512WithRSAEncryption$configure */
        static class C1985configure extends ByteArrayOutputStream {
            private C1985configure() {
            }

            /* synthetic */ C1985configure(byte b) {
                this();
            }

            /* access modifiers changed from: package-private */
            public final synchronized boolean configure(DigestSignatureSpi.RIPEMD256 ripemd256, byte[] bArr) {
                if (64 != bArr.length) {
                    return false;
                }
                boolean cca_continue = setImportantForAutofill.cca_continue(bArr, ripemd256.getEncoded(), this.buf, this.count);
                reset();
                return cca_continue;
            }

            /* access modifiers changed from: package-private */
            public final synchronized byte[] init(DigestSignatureSpi.MD5 md5, DigestSignatureSpi.RIPEMD256 ripemd256) {
                byte[] bArr;
                bArr = new byte[64];
                byte[] bArr2 = this.buf;
                int i = this.count;
                byte[] bArr3 = new byte[32];
                if (ripemd256 == null) {
                    setImportantForAutofill.cca_continue(md5.Cardinal, bArr3);
                } else {
                    System.arraycopy(ripemd256.init, 0, bArr3, 0, 32);
                }
                setImportantForAutofill.getInstance(md5.Cardinal, bArr3, bArr2, 0, i, bArr, 0);
                reset();
                return bArr;
            }

            public final synchronized void reset() {
                byte[] bArr = this.buf;
                int i = this.count;
                for (int i2 = 0; i2 < i; i2++) {
                    bArr[i2] = 0;
                }
                this.count = 0;
            }
        }

        public final void cca_continue(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            DigestSignatureSpi.RIPEMD256 ripemd256;
            this.getInstance = z;
            if (z) {
                DigestSignatureSpi.MD5 md5 = (DigestSignatureSpi.MD5) eCKAEGwithSHA512KDF;
                this.init = md5;
                byte[] bArr = new byte[32];
                setImportantForAutofill.cca_continue(md5.Cardinal, bArr);
                ripemd256 = new DigestSignatureSpi.RIPEMD256(bArr, 0);
            } else {
                this.init = null;
                ripemd256 = (DigestSignatureSpi.RIPEMD256) eCKAEGwithSHA512KDF;
            }
            this.cca_continue = ripemd256;
            this.Cardinal.reset();
        }
    }

    /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$SHA512_224WithRSAEncryption */
    public final class SHA512_224WithRSAEncryption implements KeyPairGeneratorSpi.ECDSA {
        private boolean Cardinal;
        private DigestSignatureSpi.SHA1 cca_continue;
        private final cca_continue configure = new cca_continue((byte) 0);
        private DigestSignatureSpi.RIPEMD128 getInstance;
        private final byte[] init;

        public SHA512_224WithRSAEncryption(byte[] bArr) {
            this.init = setForegroundTintBlendMode.cca_continue(bArr);
        }

        public final byte[] Cardinal() {
            DigestSignatureSpi.SHA1 sha1;
            if (this.Cardinal && (sha1 = this.cca_continue) != null) {
                return this.configure.getInstance(sha1, this.getInstance, this.init);
            }
            throw new IllegalStateException("Ed448Signer not initialised for signature generation.");
        }

        public final void cca_continue(byte[] bArr, int i, int i2) {
            this.configure.write(bArr, i, i2);
        }

        public final void init(byte b) {
            this.configure.write(b);
        }

        public final boolean init(byte[] bArr) {
            DigestSignatureSpi.RIPEMD128 ripemd128;
            if (!this.Cardinal && (ripemd128 = this.getInstance) != null) {
                return this.configure.init(ripemd128, this.init, bArr);
            }
            throw new IllegalStateException("Ed448Signer not initialised for verification");
        }

        /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$SHA512_224WithRSAEncryption$cca_continue */
        static class cca_continue extends ByteArrayOutputStream {
            private cca_continue() {
            }

            /* synthetic */ cca_continue(byte b) {
                this();
            }

            /* access modifiers changed from: package-private */
            public final synchronized boolean init(DigestSignatureSpi.RIPEMD128 ripemd128, byte[] bArr, byte[] bArr2) {
                if (114 != bArr2.length) {
                    return false;
                }
                boolean configure = setAutofillId.configure(bArr2, ripemd128.getEncoded(), bArr, this.buf, this.count);
                reset();
                return configure;
            }

            /* access modifiers changed from: package-private */
            public final synchronized byte[] getInstance(DigestSignatureSpi.SHA1 sha1, DigestSignatureSpi.RIPEMD128 ripemd128, byte[] bArr) {
                byte[] bArr2;
                bArr2 = new byte[114];
                byte[] bArr3 = this.buf;
                int i = this.count;
                byte[] bArr4 = new byte[57];
                if (ripemd128 == null) {
                    setAutofillId.init(sha1.cca_continue, bArr4);
                } else {
                    System.arraycopy(ripemd128.Cardinal, 0, bArr4, 0, 57);
                }
                setAutofillId.Cardinal(sha1.cca_continue, bArr4, bArr, bArr3, 0, i, bArr2, 0);
                reset();
                return bArr2;
            }

            public final synchronized void reset() {
                byte[] bArr = this.buf;
                int i = this.count;
                for (int i2 = 0; i2 < i; i2++) {
                    bArr[i2] = 0;
                }
                this.count = 0;
            }
        }

        public final void cca_continue(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            DigestSignatureSpi.RIPEMD128 ripemd128;
            this.Cardinal = z;
            if (z) {
                DigestSignatureSpi.SHA1 sha1 = (DigestSignatureSpi.SHA1) eCKAEGwithSHA512KDF;
                this.cca_continue = sha1;
                byte[] bArr = new byte[57];
                setAutofillId.init(sha1.cca_continue, bArr);
                ripemd128 = new DigestSignatureSpi.RIPEMD128(bArr, 0);
            } else {
                this.cca_continue = null;
                ripemd128 = (DigestSignatureSpi.RIPEMD128) eCKAEGwithSHA512KDF;
            }
            this.getInstance = ripemd128;
            this.configure.reset();
        }
    }

    /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$RIPEMD160WithRSAEncryption */
    public final class RIPEMD160WithRSAEncryption implements KeyFactorySpi.C1979EC {
        private final X931SignatureSpi configure;
        private ElGamalUtil getInstance;
        private SecureRandom init;

        public RIPEMD160WithRSAEncryption() {
            this.configure = new BaseCipherSpi.ErasableOutputStream();
        }

        public RIPEMD160WithRSAEncryption(X931SignatureSpi x931SignatureSpi) {
            this.configure = x931SignatureSpi;
        }

        private static BigInteger getInstance(BigInteger bigInteger, byte[] bArr) {
            if (bigInteger.bitLength() >= (bArr.length << 3)) {
                return new BigInteger(1, bArr);
            }
            int bitLength = bigInteger.bitLength() / 8;
            byte[] bArr2 = new byte[bitLength];
            System.arraycopy(bArr, 0, bArr2, 0, bitLength);
            return new BigInteger(1, bArr2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void getInstance(boolean r3, com.cardinalcommerce.p060a.KeyAgreementSpi.ECKAEGwithSHA512KDF r4) {
            /*
                r2 = this;
                r0 = 0
                if (r3 == 0) goto L_0x0015
                boolean r1 = r4 instanceof com.cardinalcommerce.p060a.ISOSignatureSpi.SHA224WithRSAEncryption
                if (r1 == 0) goto L_0x0012
                com.cardinalcommerce.a.ISOSignatureSpi$SHA224WithRSAEncryption r4 = (com.cardinalcommerce.p060a.ISOSignatureSpi.SHA224WithRSAEncryption) r4
                com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA512KDF r1 = r4.getInstance
                com.cardinalcommerce.a.AlgorithmParametersSpi$PSS r1 = (com.cardinalcommerce.p060a.AlgorithmParametersSpi.PSS) r1
                r2.getInstance = r1
                java.security.SecureRandom r4 = r4.configure
                goto L_0x001a
            L_0x0012:
                com.cardinalcommerce.a.AlgorithmParametersSpi$PSS r4 = (com.cardinalcommerce.p060a.AlgorithmParametersSpi.PSS) r4
                goto L_0x0017
            L_0x0015:
                com.cardinalcommerce.a.BCGOST3410PrivateKey r4 = (com.cardinalcommerce.p060a.BCGOST3410PrivateKey) r4
            L_0x0017:
                r2.getInstance = r4
                r4 = r0
            L_0x001a:
                if (r3 == 0) goto L_0x0026
                com.cardinalcommerce.a.X931SignatureSpi r3 = r2.configure
                boolean r3 = r3.getInstance()
                if (r3 != 0) goto L_0x0026
                r3 = 1
                goto L_0x0027
            L_0x0026:
                r3 = 0
            L_0x0027:
                if (r3 != 0) goto L_0x002a
                goto L_0x0032
            L_0x002a:
                if (r4 == 0) goto L_0x002e
                r0 = r4
                goto L_0x0032
            L_0x002e:
                java.security.SecureRandom r0 = com.cardinalcommerce.p060a.KeyAgreementSpi.MQV.cca_continue()
            L_0x0032:
                r2.init = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.X931SignatureSpi.RIPEMD160WithRSAEncryption.getInstance(boolean, com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA512KDF):void");
        }

        public final BigInteger cca_continue() {
            return this.getInstance.Cardinal.getInstance;
        }

        public final BigInteger[] configure(byte[] bArr) {
            BCGOST3410PublicKey bCGOST3410PublicKey = this.getInstance.Cardinal;
            BigInteger bigInteger = bCGOST3410PublicKey.getInstance;
            BigInteger instance = getInstance(bigInteger, bArr);
            BigInteger bigInteger2 = ((AlgorithmParametersSpi.PSS) this.getInstance).init;
            if (this.configure.getInstance()) {
                this.configure.cca_continue(bigInteger, bigInteger2, bArr);
            } else {
                this.configure.init(bigInteger, this.init);
            }
            BigInteger Cardinal = this.configure.Cardinal();
            BigInteger bigInteger3 = bCGOST3410PublicKey.cca_continue;
            SecureRandom secureRandom = this.init;
            if (secureRandom == null) {
                secureRandom = KeyAgreementSpi.MQV.cca_continue();
            }
            BigInteger mod = bigInteger3.modPow(Cardinal.add(setSelected.configure(7, secureRandom).add(BigInteger.valueOf(128)).multiply(bigInteger)), bCGOST3410PublicKey.init).mod(bigInteger);
            return new BigInteger[]{mod, Cardinal.modInverse(bigInteger).multiply(instance.add(bigInteger2.multiply(mod))).mod(bigInteger)};
        }

        public final boolean init(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
            BCGOST3410PublicKey bCGOST3410PublicKey = this.getInstance.Cardinal;
            BigInteger bigInteger3 = bCGOST3410PublicKey.getInstance;
            BigInteger instance = getInstance(bigInteger3, bArr);
            BigInteger valueOf = BigInteger.valueOf(0);
            if (valueOf.compareTo(bigInteger) >= 0 || bigInteger3.compareTo(bigInteger) <= 0 || valueOf.compareTo(bigInteger2) >= 0 || bigInteger3.compareTo(bigInteger2) <= 0) {
                return false;
            }
            BigInteger modInverse = bigInteger2.modInverse(bigInteger3);
            BigInteger mod = instance.multiply(modInverse).mod(bigInteger3);
            BigInteger mod2 = bigInteger.multiply(modInverse).mod(bigInteger3);
            BigInteger bigInteger4 = bCGOST3410PublicKey.init;
            return bCGOST3410PublicKey.cca_continue.modPow(mod, bigInteger4).multiply(((BCGOST3410PrivateKey) this.getInstance).cca_continue.modPow(mod2, bigInteger4)).mod(bigInteger4).mod(bigInteger3).equals(bigInteger);
        }
    }

    /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$SHA1WithRSAEncryption */
    public final class SHA1WithRSAEncryption implements KeyFactorySpi.C1979EC {
        private SecureRandom getInstance;
        private DigestSignatureSpi.MD4 init;

        public final void getInstance(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            if (!z) {
                this.init = (DigestSignatureSpi) eCKAEGwithSHA512KDF;
            } else if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
                ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption = (ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF;
                this.getInstance = sHA224WithRSAEncryption.configure;
                this.init = (DigestSignatureSpi.MD2) sHA224WithRSAEncryption.getInstance;
            } else {
                this.getInstance = KeyAgreementSpi.MQV.cca_continue();
                this.init = (DigestSignatureSpi.MD2) eCKAEGwithSHA512KDF;
            }
        }

        public final BigInteger cca_continue() {
            return this.init.init.cca_continue;
        }

        public final BigInteger[] configure(byte[] bArr) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i = 0; i != length; i++) {
                bArr2[i] = bArr[(length - 1) - i];
            }
            BigInteger bigInteger = new BigInteger(1, bArr2);
            BCRSAPublicKey bCRSAPublicKey = this.init.init;
            BigInteger bigInteger2 = bCRSAPublicKey.cca_continue;
            BigInteger bigInteger3 = ((DigestSignatureSpi.MD2) this.init).Cardinal;
            setAcsRefNumber setacsrefnumber = new setAcsRefNumber();
            while (true) {
                BigInteger configure = setSelected.configure(bigInteger2.bitLength(), this.getInstance);
                if (!configure.equals(getSDKReferenceNumber.CardinalError)) {
                    BigInteger mod = setacsrefnumber.configure(bCRSAPublicKey.init, configure).CardinalRenderType().getSDKVersion().Cardinal().mod(bigInteger2);
                    if (!mod.equals(getSDKReferenceNumber.CardinalError)) {
                        BigInteger mod2 = configure.multiply(bigInteger).add(bigInteger3.multiply(mod)).mod(bigInteger2);
                        if (!mod2.equals(getSDKReferenceNumber.CardinalError)) {
                            return new BigInteger[]{mod, mod2};
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        public final boolean init(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i = 0; i != length; i++) {
                bArr2[i] = bArr[(length - 1) - i];
            }
            BigInteger bigInteger3 = new BigInteger(1, bArr2);
            BigInteger bigInteger4 = this.init.init.cca_continue;
            if (bigInteger.compareTo(getSDKReferenceNumber.values) < 0 || bigInteger.compareTo(bigInteger4) >= 0 || bigInteger2.compareTo(getSDKReferenceNumber.values) < 0 || bigInteger2.compareTo(bigInteger4) >= 0) {
                return false;
            }
            BigInteger modInverse = bigInteger3.modInverse(bigInteger4);
            ChallengeParameters CardinalRenderType = getDeviceData.init(this.init.init.init, bigInteger2.multiply(modInverse).mod(bigInteger4), ((DigestSignatureSpi) this.init).cca_continue, bigInteger4.subtract(bigInteger).multiply(modInverse).mod(bigInteger4)).CardinalRenderType();
            if (CardinalRenderType.valueOf()) {
                return false;
            }
            return CardinalRenderType.getSDKVersion().Cardinal().mod(bigInteger4).equals(bigInteger);
        }
    }

    /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$SHA224WithRSAEncryption */
    public final class SHA224WithRSAEncryption implements KeyFactorySpi.C1979EC {
        private SecureRandom Cardinal;
        private DigestSignatureSpi.MD4 cca_continue;
        private boolean configure;

        public final void getInstance(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            this.configure = z;
            if (!z) {
                this.cca_continue = (DigestSignatureSpi) eCKAEGwithSHA512KDF;
            } else if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
                ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption = (ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF;
                this.Cardinal = sHA224WithRSAEncryption.configure;
                this.cca_continue = (DigestSignatureSpi.MD2) sHA224WithRSAEncryption.getInstance;
            } else {
                this.Cardinal = KeyAgreementSpi.MQV.cca_continue();
                this.cca_continue = (DigestSignatureSpi.MD2) eCKAEGwithSHA512KDF;
            }
        }

        public final BigInteger cca_continue() {
            return this.cca_continue.init.cca_continue;
        }

        public final BigInteger[] configure(byte[] bArr) {
            ExtendedInvalidKeySpecException init;
            BigInteger mod;
            if (this.configure) {
                BigInteger bigInteger = this.cca_continue.init.cca_continue;
                int bitLength = bigInteger.bitLength();
                BigInteger bigInteger2 = new BigInteger(1, bArr);
                int bitLength2 = bigInteger2.bitLength();
                DigestSignatureSpi.MD2 md2 = (DigestSignatureSpi.MD2) this.cca_continue;
                if (bitLength2 <= bitLength) {
                    do {
                        KeyAgreementSpi.X448withSHA384CKDF x448withSHA384CKDF = new KeyAgreementSpi.X448withSHA384CKDF();
                        x448withSHA384CKDF.cca_continue(new BCRSAPrivateKey(md2.init, this.Cardinal));
                        init = x448withSHA384CKDF.init();
                        mod = ((DigestSignatureSpi) init.Cardinal).cca_continue.getSDKVersion().Cardinal().add(bigInteger2).mod(bigInteger);
                    } while (mod.equals(getSDKReferenceNumber.CardinalError));
                    return new BigInteger[]{mod, ((DigestSignatureSpi.MD2) init.cca_continue).Cardinal.subtract(mod.multiply(md2.Cardinal)).mod(bigInteger)};
                }
                throw new KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo("input too large for ECNR key.");
            }
            throw new IllegalStateException("not initialised for signing");
        }

        public final boolean init(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
            if (!this.configure) {
                DigestSignatureSpi digestSignatureSpi = (DigestSignatureSpi) this.cca_continue;
                BigInteger bigInteger3 = digestSignatureSpi.init.cca_continue;
                int bitLength = bigInteger3.bitLength();
                BigInteger bigInteger4 = new BigInteger(1, bArr);
                if (bigInteger4.bitLength() > bitLength) {
                    throw new KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo("input too large for ECNR key.");
                } else if (bigInteger.compareTo(getSDKReferenceNumber.values) < 0 || bigInteger.compareTo(bigInteger3) >= 0 || bigInteger2.compareTo(getSDKReferenceNumber.CardinalError) < 0 || bigInteger2.compareTo(bigInteger3) >= 0) {
                    return false;
                } else {
                    ChallengeParameters CardinalRenderType = getDeviceData.init(digestSignatureSpi.init.init, bigInteger2, digestSignatureSpi.cca_continue, bigInteger).CardinalRenderType();
                    if (CardinalRenderType.valueOf()) {
                        return false;
                    }
                    return bigInteger.subtract(CardinalRenderType.getSDKVersion().Cardinal()).mod(bigInteger3).equals(bigInteger4);
                }
            } else {
                throw new IllegalStateException("not initialised for verifying");
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$SHA256WithRSAEncryption */
    public final class SHA256WithRSAEncryption implements KeyFactorySpi.C1979EC {
        private DigestSignatureSpi.MD4 configure;
        private SecureRandom getInstance;

        public final void getInstance(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            if (!z) {
                this.configure = (DigestSignatureSpi) eCKAEGwithSHA512KDF;
            } else if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
                ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption = (ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF;
                this.getInstance = sHA224WithRSAEncryption.configure;
                this.configure = (DigestSignatureSpi.MD2) sHA224WithRSAEncryption.getInstance;
            } else {
                this.getInstance = KeyAgreementSpi.MQV.cca_continue();
                this.configure = (DigestSignatureSpi.MD2) eCKAEGwithSHA512KDF;
            }
        }

        public final BigInteger cca_continue() {
            return this.configure.init.cca_continue;
        }

        public final BigInteger[] configure(byte[] bArr) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i = 0; i != length; i++) {
                bArr2[i] = bArr[(length - 1) - i];
            }
            BigInteger bigInteger = new BigInteger(1, bArr2);
            BCRSAPublicKey bCRSAPublicKey = this.configure.init;
            BigInteger bigInteger2 = bCRSAPublicKey.cca_continue;
            BigInteger bigInteger3 = ((DigestSignatureSpi.MD2) this.configure).Cardinal;
            setAcsRefNumber setacsrefnumber = new setAcsRefNumber();
            while (true) {
                BigInteger configure2 = setSelected.configure(bigInteger2.bitLength(), this.getInstance);
                if (!configure2.equals(getSDKReferenceNumber.CardinalError)) {
                    BigInteger mod = setacsrefnumber.configure(bCRSAPublicKey.init, configure2).CardinalRenderType().getSDKVersion().Cardinal().mod(bigInteger2);
                    if (!mod.equals(getSDKReferenceNumber.CardinalError)) {
                        BigInteger mod2 = configure2.multiply(bigInteger).add(bigInteger3.multiply(mod)).mod(bigInteger2);
                        if (!mod2.equals(getSDKReferenceNumber.CardinalError)) {
                            return new BigInteger[]{mod, mod2};
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        public final boolean init(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i = 0; i != length; i++) {
                bArr2[i] = bArr[(length - 1) - i];
            }
            BigInteger bigInteger3 = new BigInteger(1, bArr2);
            BigInteger bigInteger4 = this.configure.init.cca_continue;
            if (bigInteger.compareTo(getSDKReferenceNumber.values) < 0 || bigInteger.compareTo(bigInteger4) >= 0 || bigInteger2.compareTo(getSDKReferenceNumber.values) < 0 || bigInteger2.compareTo(bigInteger4) >= 0) {
                return false;
            }
            BigInteger modInverse = bigInteger3.modInverse(bigInteger4);
            ChallengeParameters CardinalRenderType = getDeviceData.init(this.configure.init.init, bigInteger2.multiply(modInverse).mod(bigInteger4), ((DigestSignatureSpi) this.configure).cca_continue, bigInteger4.subtract(bigInteger).multiply(modInverse).mod(bigInteger4)).CardinalRenderType();
            if (CardinalRenderType.valueOf()) {
                return false;
            }
            return CardinalRenderType.getSDKVersion().Cardinal().mod(bigInteger4).equals(bigInteger);
        }
    }

    /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$SHA384WithRSAEncryption */
    public final class SHA384WithRSAEncryption implements KeyFactorySpi.C1979EC, getSDKReferenceNumber {
        private SecureRandom cca_continue;
        private DigestSignatureSpi.MD4 configure;
        private final X931SignatureSpi getInstance;

        public SHA384WithRSAEncryption() {
            this.getInstance = new BaseCipherSpi.ErasableOutputStream();
        }

        public SHA384WithRSAEncryption(X931SignatureSpi x931SignatureSpi) {
            this.getInstance = x931SignatureSpi;
        }

        private static BigInteger configure(BigInteger bigInteger, byte[] bArr) {
            int bitLength = bigInteger.bitLength();
            int length = bArr.length << 3;
            BigInteger bigInteger2 = new BigInteger(1, bArr);
            return bitLength < length ? bigInteger2.shiftRight(length - bitLength) : bigInteger2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void getInstance(boolean r3, com.cardinalcommerce.p060a.KeyAgreementSpi.ECKAEGwithSHA512KDF r4) {
            /*
                r2 = this;
                r0 = 0
                if (r3 == 0) goto L_0x0015
                boolean r1 = r4 instanceof com.cardinalcommerce.p060a.ISOSignatureSpi.SHA224WithRSAEncryption
                if (r1 == 0) goto L_0x0012
                com.cardinalcommerce.a.ISOSignatureSpi$SHA224WithRSAEncryption r4 = (com.cardinalcommerce.p060a.ISOSignatureSpi.SHA224WithRSAEncryption) r4
                com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA512KDF r1 = r4.getInstance
                com.cardinalcommerce.a.DigestSignatureSpi$MD2 r1 = (com.cardinalcommerce.p060a.DigestSignatureSpi.MD2) r1
                r2.configure = r1
                java.security.SecureRandom r4 = r4.configure
                goto L_0x001a
            L_0x0012:
                com.cardinalcommerce.a.DigestSignatureSpi$MD2 r4 = (com.cardinalcommerce.p060a.DigestSignatureSpi.MD2) r4
                goto L_0x0017
            L_0x0015:
                com.cardinalcommerce.a.DigestSignatureSpi r4 = (com.cardinalcommerce.p060a.DigestSignatureSpi) r4
            L_0x0017:
                r2.configure = r4
                r4 = r0
            L_0x001a:
                if (r3 == 0) goto L_0x0026
                com.cardinalcommerce.a.X931SignatureSpi r3 = r2.getInstance
                boolean r3 = r3.getInstance()
                if (r3 != 0) goto L_0x0026
                r3 = 1
                goto L_0x0027
            L_0x0026:
                r3 = 0
            L_0x0027:
                if (r3 != 0) goto L_0x002a
                goto L_0x0032
            L_0x002a:
                if (r4 == 0) goto L_0x002e
                r0 = r4
                goto L_0x0032
            L_0x002e:
                java.security.SecureRandom r0 = com.cardinalcommerce.p060a.KeyAgreementSpi.MQV.cca_continue()
            L_0x0032:
                r2.cca_continue = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.X931SignatureSpi.SHA384WithRSAEncryption.getInstance(boolean, com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA512KDF):void");
        }

        public final BigInteger cca_continue() {
            return this.configure.init.cca_continue;
        }

        public final BigInteger[] configure(byte[] bArr) {
            BCRSAPublicKey bCRSAPublicKey = this.configure.init;
            BigInteger bigInteger = bCRSAPublicKey.cca_continue;
            BigInteger configure2 = configure(bigInteger, bArr);
            BigInteger bigInteger2 = ((DigestSignatureSpi.MD2) this.configure).Cardinal;
            if (this.getInstance.getInstance()) {
                this.getInstance.cca_continue(bigInteger, bigInteger2, bArr);
            } else {
                this.getInstance.init(bigInteger, this.cca_continue);
            }
            setAcsRefNumber setacsrefnumber = new setAcsRefNumber();
            while (true) {
                BigInteger Cardinal = this.getInstance.Cardinal();
                BigInteger mod = setacsrefnumber.configure(bCRSAPublicKey.init, Cardinal).CardinalRenderType().getSDKVersion().Cardinal().mod(bigInteger);
                if (!mod.equals(CardinalError)) {
                    BigInteger mod2 = Cardinal.modInverse(bigInteger).multiply(configure2.add(bigInteger2.multiply(mod))).mod(bigInteger);
                    if (!mod2.equals(CardinalError)) {
                        return new BigInteger[]{mod, mod2};
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:38:0x009d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean init(byte[] r6, java.math.BigInteger r7, java.math.BigInteger r8) {
            /*
                r5 = this;
                com.cardinalcommerce.a.DigestSignatureSpi$MD4 r0 = r5.configure
                com.cardinalcommerce.a.BCRSAPublicKey r0 = r0.init
                java.math.BigInteger r1 = r0.cca_continue
                java.math.BigInteger r6 = configure(r1, r6)
                java.math.BigInteger r2 = values
                int r2 = r7.compareTo(r2)
                r3 = 0
                if (r2 < 0) goto L_0x00c7
                int r2 = r7.compareTo(r1)
                if (r2 < 0) goto L_0x001b
                goto L_0x00c7
            L_0x001b:
                java.math.BigInteger r2 = values
                int r2 = r8.compareTo(r2)
                if (r2 < 0) goto L_0x00c7
                int r2 = r8.compareTo(r1)
                if (r2 < 0) goto L_0x002b
                goto L_0x00c7
            L_0x002b:
                java.math.BigInteger r8 = r8.modInverse(r1)
                java.math.BigInteger r6 = r6.multiply(r8)
                java.math.BigInteger r6 = r6.mod(r1)
                java.math.BigInteger r8 = r7.multiply(r8)
                java.math.BigInteger r8 = r8.mod(r1)
                com.cardinalcommerce.a.ChallengeParameters r0 = r0.init
                com.cardinalcommerce.a.DigestSignatureSpi$MD4 r2 = r5.configure
                com.cardinalcommerce.a.DigestSignatureSpi r2 = (com.cardinalcommerce.p060a.DigestSignatureSpi) r2
                com.cardinalcommerce.a.ChallengeParameters r2 = r2.cca_continue
                com.cardinalcommerce.a.ChallengeParameters r6 = com.cardinalcommerce.p060a.getDeviceData.init(r0, r6, r2, r8)
                boolean r8 = r6.valueOf()
                if (r8 == 0) goto L_0x0052
                return r3
            L_0x0052:
                com.cardinalcommerce.a.getSDKAppID r8 = r6.cca_continue()
                if (r8 == 0) goto L_0x00b2
                java.math.BigInteger r0 = r8.CardinalError()
                if (r0 == 0) goto L_0x00b2
                java.math.BigInteger r2 = CardinalActionCode
                int r0 = r0.compareTo(r2)
                if (r0 > 0) goto L_0x00b2
                int r0 = r8.CardinalActionCode()
                r2 = 1
                if (r0 == r2) goto L_0x0087
                r4 = 2
                if (r0 == r4) goto L_0x007e
                r4 = 3
                if (r0 == r4) goto L_0x007e
                r4 = 4
                if (r0 == r4) goto L_0x007e
                r4 = 6
                if (r0 == r4) goto L_0x0087
                r4 = 7
                if (r0 == r4) goto L_0x0087
                r0 = 0
                goto L_0x008b
            L_0x007e:
                com.cardinalcommerce.a.getAcsTransactionID r0 = r6.cca_continue((int) r3)
                com.cardinalcommerce.a.getAcsTransactionID r0 = r0.configure()
                goto L_0x008b
            L_0x0087:
                com.cardinalcommerce.a.getAcsTransactionID r0 = r6.cca_continue((int) r3)
            L_0x008b:
                if (r0 == 0) goto L_0x00b2
                boolean r4 = r0.cleanup()
                if (r4 != 0) goto L_0x00b2
                com.cardinalcommerce.a.getAcsTransactionID r6 = r6.values()
            L_0x0097:
                boolean r4 = r8.init(r7)
                if (r4 == 0) goto L_0x00b1
                com.cardinalcommerce.a.getAcsTransactionID r4 = r8.configure((java.math.BigInteger) r7)
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.init(r0)
                boolean r4 = r4.equals(r6)
                if (r4 == 0) goto L_0x00ac
                return r2
            L_0x00ac:
                java.math.BigInteger r7 = r7.add(r1)
                goto L_0x0097
            L_0x00b1:
                return r3
            L_0x00b2:
                com.cardinalcommerce.a.ChallengeParameters r6 = r6.CardinalRenderType()
                com.cardinalcommerce.a.getAcsTransactionID r6 = r6.getSDKVersion()
                java.math.BigInteger r6 = r6.Cardinal()
                java.math.BigInteger r6 = r6.mod(r1)
                boolean r6 = r6.equals(r7)
                return r6
            L_0x00c7:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.X931SignatureSpi.SHA384WithRSAEncryption.init(byte[], java.math.BigInteger, java.math.BigInteger):boolean");
        }
    }

    /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$SHA512_256WithRSAEncryption */
    public final class SHA512_256WithRSAEncryption {
        private static final Map<String, Integer> Cardinal;

        public static Integer init(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
            return Cardinal.get(mQVwithSHA256KDFAndSharedInfo.configure());
        }

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("RIPEMD128", 13004);
            hashMap.put("RIPEMD160", 12748);
            hashMap.put("SHA-1", 13260);
            hashMap.put(McElieceCCA2KeyGenParameterSpec.SHA224, 14540);
            hashMap.put("SHA-256", 13516);
            hashMap.put("SHA-384", 14028);
            hashMap.put("SHA-512", 13772);
            hashMap.put("SHA-512/224", 14796);
            hashMap.put(SPHINCSKeyParameters.SHA512_256, 15052);
            hashMap.put("Whirlpool", 14284);
            Cardinal = Collections.unmodifiableMap(hashMap);
        }
    }

    /* renamed from: com.cardinalcommerce.a.X931SignatureSpi$WhirlpoolWithRSAEncryption */
    public final class WhirlpoolWithRSAEncryption implements X931SignatureSpi {
        private static final BigInteger configure = BigInteger.valueOf(0);
        private final KeyPairGeneratorSpi.EdDSA Cardinal;
        private final byte[] cca_continue = new byte[this.Cardinal.Cardinal];
        private BigInteger getInstance;
        private final byte[] init;

        private BigInteger getInstance(byte[] bArr) {
            BigInteger bigInteger = new BigInteger(1, bArr);
            return (bArr.length << 3) > this.getInstance.bitLength() ? bigInteger.shiftRight((bArr.length << 3) - this.getInstance.bitLength()) : bigInteger;
        }

        public final boolean getInstance() {
            return true;
        }

        public final void init(BigInteger bigInteger, SecureRandom secureRandom) {
            throw new IllegalStateException("Operation not supported");
        }

        public WhirlpoolWithRSAEncryption(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
            KeyPairGeneratorSpi.EdDSA edDSA = new KeyPairGeneratorSpi.EdDSA(mQVwithSHA256KDFAndSharedInfo);
            this.Cardinal = edDSA;
            this.init = new byte[edDSA.Cardinal];
        }

        public final void cca_continue(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
            this.getInstance = bigInteger;
            byte[] bArr2 = this.init;
            for (int i = 0; i < bArr2.length; i++) {
                bArr2[i] = 1;
            }
            byte[] bArr3 = this.cca_continue;
            for (int i2 = 0; i2 < bArr3.length; i2++) {
                bArr3[i2] = 0;
            }
            int init2 = setSelected.init(bigInteger);
            byte[] bArr4 = new byte[init2];
            byte[] cca_continue2 = setSelected.cca_continue(bigInteger2);
            System.arraycopy(cca_continue2, 0, bArr4, init2 - cca_continue2.length, cca_continue2.length);
            byte[] bArr5 = new byte[init2];
            BigInteger instance = getInstance(bArr);
            if (instance.compareTo(bigInteger) >= 0) {
                instance = instance.subtract(bigInteger);
            }
            byte[] cca_continue3 = setSelected.cca_continue(instance);
            System.arraycopy(cca_continue3, 0, bArr5, init2 - cca_continue3.length, cca_continue3.length);
            this.Cardinal.configure(new ISOSignatureSpi.MD5WithRSAEncryption(this.cca_continue));
            KeyPairGeneratorSpi.EdDSA edDSA = this.Cardinal;
            byte[] bArr6 = this.init;
            edDSA.getInstance.init(bArr6, 0, bArr6.length);
            this.Cardinal.getInstance.Cardinal((byte) 0);
            this.Cardinal.getInstance.init(bArr4, 0, init2);
            this.Cardinal.getInstance.init(bArr5, 0, init2);
            this.Cardinal.Cardinal(this.cca_continue);
            this.Cardinal.configure(new ISOSignatureSpi.MD5WithRSAEncryption(this.cca_continue));
            KeyPairGeneratorSpi.EdDSA edDSA2 = this.Cardinal;
            byte[] bArr7 = this.init;
            edDSA2.getInstance.init(bArr7, 0, bArr7.length);
            this.Cardinal.Cardinal(this.init);
            KeyPairGeneratorSpi.EdDSA edDSA3 = this.Cardinal;
            byte[] bArr8 = this.init;
            edDSA3.getInstance.init(bArr8, 0, bArr8.length);
            this.Cardinal.getInstance.Cardinal((byte) 1);
            this.Cardinal.getInstance.init(bArr4, 0, init2);
            this.Cardinal.getInstance.init(bArr5, 0, init2);
            this.Cardinal.Cardinal(this.cca_continue);
            this.Cardinal.configure(new ISOSignatureSpi.MD5WithRSAEncryption(this.cca_continue));
            KeyPairGeneratorSpi.EdDSA edDSA4 = this.Cardinal;
            byte[] bArr9 = this.init;
            edDSA4.getInstance.init(bArr9, 0, bArr9.length);
            this.Cardinal.Cardinal(this.init);
        }

        public final BigInteger Cardinal() {
            int init2 = setSelected.init(this.getInstance);
            byte[] bArr = new byte[init2];
            while (true) {
                int i = 0;
                while (i < init2) {
                    KeyPairGeneratorSpi.EdDSA edDSA = this.Cardinal;
                    byte[] bArr2 = this.init;
                    edDSA.getInstance.init(bArr2, 0, bArr2.length);
                    this.Cardinal.Cardinal(this.init);
                    int min = Math.min(init2 - i, this.init.length);
                    System.arraycopy(this.init, 0, bArr, i, min);
                    i += min;
                }
                BigInteger instance = getInstance(bArr);
                if (instance.compareTo(configure) > 0 && instance.compareTo(this.getInstance) < 0) {
                    return instance;
                }
                KeyPairGeneratorSpi.EdDSA edDSA2 = this.Cardinal;
                byte[] bArr3 = this.init;
                edDSA2.getInstance.init(bArr3, 0, bArr3.length);
                this.Cardinal.getInstance.Cardinal((byte) 0);
                this.Cardinal.Cardinal(this.cca_continue);
                this.Cardinal.configure(new ISOSignatureSpi.MD5WithRSAEncryption(this.cca_continue));
                KeyPairGeneratorSpi.EdDSA edDSA3 = this.Cardinal;
                byte[] bArr4 = this.init;
                edDSA3.getInstance.init(bArr4, 0, bArr4.length);
                this.Cardinal.Cardinal(this.init);
            }
        }
    }
}
