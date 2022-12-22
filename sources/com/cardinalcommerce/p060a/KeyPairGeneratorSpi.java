package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import java.math.BigInteger;
import java.util.Hashtable;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi */
public final class KeyPairGeneratorSpi extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private static DSASigner.stdDSA f2454a = new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA512KDF.CardinalError, ECGOST.Mappings.Cardinal);

    /* renamed from: b */
    private static DSASigner.stdDSA f2455b = new DSASigner.stdDSA(KeyFactorySpi.CardinalError, f2454a);

    /* renamed from: c */
    private static DSASigner.stdDSA f2456c = new DSASigner.stdDSA(KeyFactorySpi.values, new EdEC(new byte[0]));
    public DSASigner.stdDSA Cardinal;
    public DSASigner.stdDSA configure;
    public DSASigner.stdDSA getInstance;

    /* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi$EC */
    public interface C1980EC {
        boolean Cardinal(DSASigner.dsaSha3_224 dsasha3_224, DSASigner.dsaSha3_224 dsasha3_2242);

        int configure(DSASigner.dsaSha3_224 dsasha3_224);

        String getInstance(DSASigner.dsaSha3_224 dsasha3_224);
    }

    /* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi$ECDH */
    public interface ECDH extends KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo {
        int getInstance(byte[] bArr, int i, int i2);
    }

    /* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi$ECDHC */
    public class ECDHC extends RuntimeException {
        public ECDHC() {
        }

        public ECDHC(String str) {
            super(str);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi$ECDSA */
    public interface ECDSA {
        byte[] Cardinal() throws KeyAgreementSpi.MQVwithSHA1KDFAndSharedInfo, KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo;

        void cca_continue(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF);

        void cca_continue(byte[] bArr, int i, int i2);

        void init(byte b);

        boolean init(byte[] bArr);
    }

    /* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi$X25519 */
    public interface X25519 {
        void configure(byte[] bArr);

        void init(long j, byte[] bArr);
    }

    /* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi$XDH */
    public interface XDH {
        int configure(byte[] bArr) throws KeyFactorySpi.ECDH;

        int configure(byte[] bArr, int i);
    }

    public KeyPairGeneratorSpi() {
        this.getInstance = f2454a;
        this.Cardinal = f2455b;
        this.configure = f2456c;
    }

    public KeyPairGeneratorSpi(DSASigner.stdDSA stddsa, DSASigner.stdDSA stddsa2, DSASigner.stdDSA stddsa3) {
        this.getInstance = stddsa;
        this.Cardinal = stddsa2;
        this.configure = stddsa3;
    }

    public static KeyPairGeneratorSpi getInstance(Object obj) {
        if (obj != null) {
            return new KeyPairGeneratorSpi(setThreeDSRequestorAppURL.cca_continue(obj));
        }
        return null;
    }

    /* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi$ECMQV */
    public final class ECMQV implements KeyAgreementSpi.ECKAEGwithSHA224KDF {
        private DigestSignatureSpi.MD2 cca_continue;

        public final void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            this.cca_continue = (DigestSignatureSpi.MD2) eCKAEGwithSHA512KDF;
        }

        public final int cca_continue() {
            return (this.cca_continue.init.Cardinal.configure() + 7) / 8;
        }

        public final BigInteger Cardinal(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            DigestSignatureSpi digestSignatureSpi = (DigestSignatureSpi) eCKAEGwithSHA512KDF;
            BCRSAPublicKey bCRSAPublicKey = this.cca_continue.init;
            if (bCRSAPublicKey.equals(digestSignatureSpi.init)) {
                BigInteger bigInteger = this.cca_continue.Cardinal;
                ChallengeParameters instance = getDeviceData.getInstance(bCRSAPublicKey.Cardinal, digestSignatureSpi.cca_continue);
                if (!instance.valueOf()) {
                    BigInteger bigInteger2 = bCRSAPublicKey.getInstance;
                    if (!bigInteger2.equals(getSDKReferenceNumber.values)) {
                        bigInteger = bCRSAPublicKey.configure().multiply(bigInteger).mod(bCRSAPublicKey.cca_continue);
                        instance = getDeviceData.cca_continue(instance, bigInteger2);
                    }
                    ChallengeParameters CardinalRenderType = instance.configure(bigInteger).CardinalRenderType();
                    if (!CardinalRenderType.valueOf()) {
                        return CardinalRenderType.getSDKVersion().Cardinal();
                    }
                    throw new IllegalStateException("Infinity is not a valid agreement value for ECDH");
                }
                throw new IllegalStateException("Infinity is not a valid public key for ECDH");
            }
            throw new IllegalStateException("ECDH public key has wrong domain parameters");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi$Ed448 */
    public abstract class Ed448 {
        public static void Cardinal(byte[] bArr, byte[] bArr2) {
            int i = 0;
            do {
                bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
                int i2 = i + 1;
                bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
                int i3 = i2 + 1;
                bArr[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
                int i4 = i3 + 1;
                bArr[i4] = (byte) (bArr[i4] ^ bArr2[i4]);
                i = i4 + 1;
            } while (i < 16);
        }

        public static void Cardinal(long[] jArr, long[] jArr2) {
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = jArr2[0];
            long j4 = jArr2[1];
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            for (int i = 0; i < 64; i++) {
                long j8 = j >> 63;
                j <<= 1;
                j5 ^= j3 & j8;
                long j9 = j7 ^ (j4 & j8);
                long j10 = j2 >> 63;
                j2 <<= 1;
                j7 = j9 ^ (j3 & j10);
                j6 ^= j4 & j10;
                j4 = (j4 >>> 1) | (j3 << 63);
                j3 = (j3 >>> 1) ^ (((j4 << 63) >> 8) & -2233785415175766016L);
            }
            jArr[0] = ((((j6 >>> 1) ^ j6) ^ (j6 >>> 2)) ^ (j6 >>> 7)) ^ j5;
            jArr[1] = (((j6 << 63) ^ (j6 << 62)) ^ (j6 << 57)) ^ j7;
        }

        public static void configure(byte[] bArr, byte[] bArr2, int i) {
            int i2 = 0;
            do {
                bArr[i2] = (byte) (bArr[i2] ^ bArr2[i + i2]);
                int i3 = i2 + 1;
                bArr[i3] = (byte) (bArr[i3] ^ bArr2[i + i3]);
                int i4 = i3 + 1;
                bArr[i4] = (byte) (bArr[i4] ^ bArr2[i + i4]);
                int i5 = i4 + 1;
                bArr[i5] = (byte) (bArr[i5] ^ bArr2[i + i5]);
                i2 = i5 + 1;
            } while (i2 < 16);
        }

        public static void init(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2) {
            int i3 = 0;
            do {
                bArr3[i2 + i3] = (byte) (bArr[i3] ^ bArr2[i + i3]);
                int i4 = i3 + 1;
                bArr3[i2 + i4] = (byte) (bArr[i4] ^ bArr2[i + i4]);
                int i5 = i4 + 1;
                bArr3[i2 + i5] = (byte) (bArr[i5] ^ bArr2[i + i5]);
                int i6 = i5 + 1;
                bArr3[i2 + i6] = (byte) (bArr[i6] ^ bArr2[i + i6]);
                i3 = i6 + 1;
            } while (i3 < 16);
        }

        public static void configure(long[] jArr, byte[] bArr) {
            int i = 0;
            for (long j : jArr) {
                setMinimumWidth.getInstance((int) (j >>> 32), bArr, i);
                setMinimumWidth.getInstance((int) j, bArr, i + 4);
                i += 8;
            }
        }

        public static long[] Cardinal(byte[] bArr) {
            long[] jArr = new long[2];
            int i = 0;
            for (int i2 = 0; i2 < 2; i2++) {
                int cca_continue = setMinimumWidth.cca_continue(bArr, i);
                jArr[i2] = (((long) setMinimumWidth.cca_continue(bArr, i + 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | ((((long) cca_continue) & InternalZipConstants.ZIP_64_SIZE_LIMIT) << 32);
                i += 8;
            }
            return jArr;
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi$EdDSA */
    public final class EdDSA implements KeyFactorySpi.ECDHC {
        private static Hashtable CardinalError;
        public int Cardinal;
        private int cca_continue;
        private byte[] cleanup;
        private setPaddingRelative configure;
        public KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo getInstance;
        private byte[] getSDKVersion;
        private setPaddingRelative init;

        private EdDSA(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, int i) {
            this.getInstance = mQVwithSHA256KDFAndSharedInfo;
            int instance = mQVwithSHA256KDFAndSharedInfo.getInstance();
            this.Cardinal = instance;
            this.cca_continue = i;
            this.cleanup = new byte[i];
            this.getSDKVersion = new byte[(i + instance)];
        }

        public final int Cardinal() {
            return this.Cardinal;
        }

        public final int Cardinal(byte[] bArr) {
            this.getInstance.configure(this.getSDKVersion, this.cca_continue);
            setPaddingRelative setpaddingrelative = this.configure;
            if (setpaddingrelative != null) {
                ((setPaddingRelative) this.getInstance).cca_continue(setpaddingrelative);
                KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.getInstance;
                mQVwithSHA256KDFAndSharedInfo.init(this.getSDKVersion, this.cca_continue, mQVwithSHA256KDFAndSharedInfo.getInstance());
            } else {
                KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2 = this.getInstance;
                byte[] bArr2 = this.getSDKVersion;
                mQVwithSHA256KDFAndSharedInfo2.init(bArr2, 0, bArr2.length);
            }
            int configure2 = this.getInstance.configure(bArr, 0);
            int i = this.cca_continue;
            while (true) {
                byte[] bArr3 = this.getSDKVersion;
                if (i >= bArr3.length) {
                    break;
                }
                bArr3[i] = 0;
                i++;
            }
            setPaddingRelative setpaddingrelative2 = this.init;
            if (setpaddingrelative2 != null) {
                ((setPaddingRelative) this.getInstance).cca_continue(setpaddingrelative2);
            } else {
                KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo3 = this.getInstance;
                byte[] bArr4 = this.cleanup;
                mQVwithSHA256KDFAndSharedInfo3.init(bArr4, 0, bArr4.length);
            }
            return configure2;
        }

        public final void init(byte[] bArr, int i, int i2) {
            this.getInstance.init(bArr, i, i2);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public EdDSA(com.cardinalcommerce.p060a.KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof com.cardinalcommerce.p060a.KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo
                if (r0 == 0) goto L_0x000c
                r0 = r4
                com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA384KDFAndSharedInfo r0 = (com.cardinalcommerce.p060a.KeyAgreementSpi.MQVwithSHA384KDFAndSharedInfo) r0
                int r0 = r0.Cardinal()
                goto L_0x001e
            L_0x000c:
                java.util.Hashtable r0 = CardinalError
                java.lang.String r1 = r4.configure()
                java.lang.Object r0 = r0.get(r1)
                java.lang.Integer r0 = (java.lang.Integer) r0
                if (r0 == 0) goto L_0x0022
                int r0 = r0.intValue()
            L_0x001e:
                r3.<init>(r4, r0)
                return
            L_0x0022:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "unknown digest passed: "
                r1.<init>(r2)
                java.lang.String r4 = r4.configure()
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.KeyPairGeneratorSpi.EdDSA.<init>(com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA256KDFAndSharedInfo):void");
        }

        public final void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            byte[] bArr;
            this.getInstance.cca_continue();
            byte[] instance = ((ISOSignatureSpi.MD5WithRSAEncryption) eCKAEGwithSHA512KDF).getInstance();
            int length = instance.length;
            if (length > this.cca_continue) {
                this.getInstance.init(instance, 0, length);
                this.getInstance.configure(this.cleanup, 0);
                length = this.Cardinal;
            } else {
                System.arraycopy(instance, 0, this.cleanup, 0, length);
            }
            while (true) {
                bArr = this.cleanup;
                if (length >= bArr.length) {
                    break;
                }
                bArr[length] = 0;
                length++;
            }
            System.arraycopy(bArr, 0, this.getSDKVersion, 0, this.cca_continue);
            byte[] bArr2 = this.cleanup;
            int i = this.cca_continue;
            for (int i2 = 0; i2 < i; i2++) {
                bArr2[i2] = (byte) (bArr2[i2] ^ 54);
            }
            byte[] bArr3 = this.getSDKVersion;
            int i3 = this.cca_continue;
            for (int i4 = 0; i4 < i3; i4++) {
                bArr3[i4] = (byte) (bArr3[i4] ^ 92);
            }
            KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.getInstance;
            if (mQVwithSHA256KDFAndSharedInfo instanceof setPaddingRelative) {
                setPaddingRelative init2 = ((setPaddingRelative) mQVwithSHA256KDFAndSharedInfo).init();
                this.configure = init2;
                ((KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo) init2).init(this.getSDKVersion, 0, this.cca_continue);
            }
            KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2 = this.getInstance;
            byte[] bArr4 = this.cleanup;
            mQVwithSHA256KDFAndSharedInfo2.init(bArr4, 0, bArr4.length);
            KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo3 = this.getInstance;
            if (mQVwithSHA256KDFAndSharedInfo3 instanceof setPaddingRelative) {
                this.init = ((setPaddingRelative) mQVwithSHA256KDFAndSharedInfo3).init();
            }
        }

        static {
            Hashtable hashtable = new Hashtable();
            CardinalError = hashtable;
            hashtable.put("GOST3411", 32);
            CardinalError.put(MessageDigestAlgorithms.MD2, 16);
            CardinalError.put("MD4", 64);
            CardinalError.put(MessageDigestAlgorithms.MD5, 64);
            CardinalError.put("RIPEMD128", 64);
            CardinalError.put("RIPEMD160", 64);
            CardinalError.put("SHA-1", 64);
            CardinalError.put(McElieceCCA2KeyGenParameterSpec.SHA224, 64);
            CardinalError.put("SHA-256", 64);
            CardinalError.put("SHA-384", 128);
            CardinalError.put("SHA-512", 128);
            CardinalError.put("Tiger", 64);
            CardinalError.put("Whirlpool", 64);
        }
    }

    private KeyPairGeneratorSpi(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        this.getInstance = f2454a;
        this.Cardinal = f2455b;
        this.configure = f2456c;
        for (int i = 0; i != setthreedsrequestorappurl.getInstance(); i++) {
            getType gettype = (getType) setthreedsrequestorappurl.Cardinal(i);
            int i2 = gettype.Cardinal;
            DSASigner.stdDSA stddsa = null;
            if (i2 == 0) {
                setThreeDSRequestorAppURL configure2 = setThreeDSRequestorAppURL.configure(gettype, true);
                this.getInstance = configure2 != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue((Object) configure2)) : stddsa;
            } else if (i2 == 1) {
                setThreeDSRequestorAppURL configure3 = setThreeDSRequestorAppURL.configure(gettype, true);
                this.Cardinal = configure3 != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue((Object) configure3)) : stddsa;
            } else if (i2 == 2) {
                setThreeDSRequestorAppURL configure4 = setThreeDSRequestorAppURL.configure(gettype, true);
                this.configure = configure4 != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue((Object) configure4)) : stddsa;
            } else {
                throw new IllegalArgumentException("unknown tag");
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi$X448 */
    public final class X448 extends KeyAgreementSpi.ECKAEGwithSHA256KDF {
        private XDH Cardinal;

        public X448(KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo dHwithSHA512KDFAndSharedInfo) {
            this(dHwithSHA512KDFAndSharedInfo, new SignatureSpi.EdDSA());
        }

        private X448(KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo dHwithSHA512KDFAndSharedInfo, XDH xdh) {
            this.configure = dHwithSHA512KDFAndSharedInfo;
            this.Cardinal = xdh;
            this.getInstance = new byte[dHwithSHA512KDFAndSharedInfo.cca_continue()];
            this.init = 0;
        }

        public final int getInstance(int i) {
            int i2 = i + this.init;
            int length = i2 % this.getInstance.length;
            return length == 0 ? Math.max(0, i2 - this.getInstance.length) : i2 - length;
        }

        public final int getInstance(byte[] bArr, int i) throws KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo, IllegalStateException, KeyFactorySpi.ECDH {
            int configure;
            int i2;
            int cca_continue = this.configure.cca_continue();
            if (this.cca_continue) {
                if (this.init != cca_continue) {
                    i2 = 0;
                } else if ((cca_continue * 2) + i <= bArr.length) {
                    i2 = this.configure.init(this.getInstance, 0, bArr, i);
                    this.init = 0;
                } else {
                    Cardinal();
                    throw new KeyFactorySpi.ECDSA("output buffer too short");
                }
                this.Cardinal.configure(this.getInstance, this.init);
                configure = i2 + this.configure.init(this.getInstance, 0, bArr, i + i2);
            } else if (this.init == cca_continue) {
                int init = this.configure.init(this.getInstance, 0, this.getInstance, 0);
                this.init = 0;
                try {
                    configure = init - this.Cardinal.configure(this.getInstance);
                    System.arraycopy(this.getInstance, 0, bArr, i, configure);
                } catch (Throwable th) {
                    Cardinal();
                    throw th;
                }
            } else {
                Cardinal();
                throw new KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo("last block incomplete in decryption");
            }
            Cardinal();
            return configure;
        }

        public final int getInstance(byte[] bArr, int i, int i2, byte[] bArr2) throws KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo, IllegalStateException {
            if (i2 >= 0) {
                int configure = configure();
                int instance = getInstance(i2);
                if (instance <= 0 || instance <= bArr2.length) {
                    int length = this.getInstance.length - this.init;
                    int i3 = 0;
                    if (i2 > length) {
                        System.arraycopy(bArr, i, this.getInstance, this.init, length);
                        this.init = 0;
                        i2 -= length;
                        i += length;
                        i3 = this.configure.init(this.getInstance, 0, bArr2, 0) + 0;
                        while (i2 > this.getInstance.length) {
                            i3 += this.configure.init(bArr, i, bArr2, i3);
                            i2 -= configure;
                            i += configure;
                        }
                    }
                    System.arraycopy(bArr, i, this.getInstance, this.init, i2);
                    this.init += i2;
                    return i3;
                }
                throw new KeyFactorySpi.ECDSA("output buffer too short");
            }
            throw new IllegalArgumentException("Can't have a negative input length!");
        }

        public final int init(int i) {
            int length;
            int i2 = i + this.init;
            int length2 = i2 % this.getInstance.length;
            if (length2 != 0) {
                i2 -= length2;
                length = this.getInstance.length;
            } else if (!this.cca_continue) {
                return i2;
            } else {
                length = this.getInstance.length;
            }
            return i2 + length;
        }

        public final void init(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) throws IllegalArgumentException {
            KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo dHwithSHA512KDFAndSharedInfo;
            this.cca_continue = z;
            Cardinal();
            if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
                dHwithSHA512KDFAndSharedInfo = this.configure;
                eCKAEGwithSHA512KDF = ((ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF).getInstance;
            } else {
                dHwithSHA512KDFAndSharedInfo = this.configure;
            }
            dHwithSHA512KDFAndSharedInfo.Cardinal(z, eCKAEGwithSHA512KDF);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyPairGeneratorSpi$Ed25519 */
    public final class Ed25519 implements X25519 {
        private long[] init;

        public final void configure(byte[] bArr) {
            long[] jArr = new long[2];
            int i = 0;
            for (int i2 = 0; i2 < 2; i2++) {
                int cca_continue = setMinimumWidth.cca_continue(bArr, i);
                jArr[i2] = (((long) setMinimumWidth.cca_continue(bArr, i + 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | ((((long) cca_continue) & InternalZipConstants.ZIP_64_SIZE_LIMIT) << 32);
                i += 8;
            }
            this.init = jArr;
        }

        public final void init(long j, byte[] bArr) {
            long[] jArr;
            byte[] bArr2 = bArr;
            long[] jArr2 = new long[2];
            jArr2[0] = Long.MIN_VALUE;
            if (j > 0) {
                long[] jArr3 = this.init;
                if (jArr3 == null) {
                    jArr = null;
                } else {
                    long[] jArr4 = new long[jArr3.length];
                    System.arraycopy(jArr3, 0, jArr4, 0, jArr3.length);
                    jArr = jArr4;
                }
                long j2 = j;
                do {
                    if ((1 & j2) != 0) {
                        Ed448.Cardinal(jArr2, jArr);
                    }
                    long[] jArr5 = new long[4];
                    setLabelFor.init(jArr[0], jArr5, 0);
                    setLabelFor.init(jArr[1], jArr5, 2);
                    long j3 = jArr5[0];
                    long j4 = jArr5[1];
                    long j5 = jArr5[2];
                    long j6 = jArr5[3];
                    long j7 = j5 ^ (((j6 << 63) ^ (j6 << 62)) ^ (j6 << 57));
                    jArr[0] = j3 ^ (((j7 ^ (j7 >>> 1)) ^ (j7 >>> 2)) ^ (j7 >>> 7));
                    jArr[1] = (j4 ^ (((j6 ^ (j6 >>> 1)) ^ (j6 >>> 2)) ^ (j6 >>> 7))) ^ (((j7 << 63) ^ (j7 << 62)) ^ (j7 << 57));
                    j2 >>>= 1;
                } while (j2 > 0);
            }
            int i = 0;
            for (int i2 = 0; i2 < 2; i2++) {
                long j8 = jArr2[i2];
                setMinimumWidth.getInstance((int) (j8 >>> 32), bArr2, i);
                setMinimumWidth.getInstance((int) j8, bArr2, i + 4);
                i += 8;
            }
        }
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        if (!this.getInstance.equals(f2454a)) {
            setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 0, this.getInstance));
        }
        if (!this.Cardinal.equals(f2455b)) {
            setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 1, this.Cardinal));
        }
        if (!this.configure.equals(f2456c)) {
            setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 2, this.configure));
        }
        return new GOST(setforegroundtintblendmode);
    }
}
