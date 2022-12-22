package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.ButtonCustomization */
public final class ButtonCustomization {
    public KeyAgreementSpi.ECKAEGwithSHA256KDF Cardinal;
    public ToolbarCustomization CardinalError;

    /* renamed from: a */
    private KeyAgreementSpi.ECKAEGwithSHA224KDF f2331a;

    /* renamed from: b */
    private KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo f2332b;

    /* renamed from: c */
    private ISOSignatureSpi f2333c;
    public KeyAgreementSpi.ECKAEGwithSHA512KDF cca_continue;
    public byte[] cleanup;
    public KeyFactorySpi.ECDHC configure;

    /* renamed from: d */
    private byte[] f2334d;
    public KeyAgreementSpi.ECKAEGwithSHA512KDF getInstance;
    public KeyFactorySpi.ECGOST3410 getSDKVersion;
    public boolean init;

    public ButtonCustomization() {
    }

    /* renamed from: a */
    private static void m1789a(long j, long j2, long[] jArr, int i) {
        long j3 = j;
        long[] jArr2 = new long[8];
        jArr2[1] = j2;
        jArr2[2] = jArr2[1] << 1;
        jArr2[3] = jArr2[2] ^ j2;
        jArr2[4] = jArr2[2] << 1;
        jArr2[5] = jArr2[4] ^ j2;
        jArr2[6] = jArr2[3] << 1;
        jArr2[7] = jArr2[6] ^ j2;
        long j4 = jArr2[((int) j3) & 7];
        long j5 = 0;
        int i2 = 48;
        do {
            int i3 = (int) (j3 >>> i2);
            long j6 = (jArr2[(i3 >>> 6) & 7] << 6) ^ (jArr2[i3 & 7] ^ (jArr2[(i3 >>> 3) & 7] << 3));
            j4 ^= j6 << i2;
            j5 ^= j6 >>> (-i2);
            i2 -= 9;
        } while (i2 > 0);
        jArr[i] = 144115188075855871L & j4;
        jArr[i + 1] = (((((j3 & 72198606942111744L) & ((j2 << 7) >> 63)) >>> 8) ^ j5) << 7) ^ (j4 >>> 57);
    }

    /* renamed from: a */
    static void m1790a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: b */
    static void m1793b(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = ((jArr[1] << 7) ^ (j >>> 57)) & 144115188075855871L;
        long j3 = j & 144115188075855871L;
        long j4 = jArr2[0];
        long j5 = ((jArr2[1] << 7) ^ (j4 >>> 57)) & 144115188075855871L;
        long j6 = 144115188075855871L & j4;
        long[] jArr4 = new long[6];
        long[] jArr5 = jArr4;
        m1789a(j3, j6, jArr4, 0);
        m1789a(j2, j5, jArr5, 2);
        m1789a(j3 ^ j2, j6 ^ j5, jArr5, 4);
        long j7 = jArr5[1] ^ jArr5[2];
        long j8 = jArr5[0];
        long j9 = jArr5[3];
        long j10 = (jArr5[4] ^ j8) ^ j7;
        long j11 = j7 ^ (jArr5[5] ^ j9);
        jArr3[0] = j8 ^ (j10 << 57);
        jArr3[1] = (j10 >>> 7) ^ (j11 << 50);
        jArr3[2] = (j11 >>> 14) ^ (j9 << 43);
        jArr3[3] = j9 >>> 21;
    }

    public static void configure(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = j3 ^ ((j4 >>> 40) ^ (j4 >>> 49));
        long j6 = j ^ ((j5 << 15) ^ (j5 << 24));
        long j7 = (j2 ^ ((j4 << 15) ^ (j4 << 24))) ^ ((j5 >>> 40) ^ (j5 >>> 49));
        long j8 = j7 >>> 49;
        jArr2[0] = (j6 ^ j8) ^ (j8 << 9);
        jArr2[1] = 562949953421311L & j7;
    }

    public static long[] init(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        long[] jArr = new long[2];
        int i = 0;
        while (bigInteger.signum() != 0) {
            jArr[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i++;
        }
        long j = jArr[1];
        long j2 = j >>> 49;
        jArr[0] = (j2 ^ (j2 << 9)) ^ jArr[0];
        jArr[1] = j & 562949953421311L;
        return jArr;
    }

    public static void getInstance(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[4];
        setLabelFor.cca_continue(jArr[0], jArr3, 0);
        setLabelFor.cca_continue(jArr[1], jArr3, 2);
        configure(jArr3, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                setLabelFor.cca_continue(jArr2[0], jArr3, 0);
                setLabelFor.cca_continue(jArr2[1], jArr3, 2);
                configure(jArr3, jArr2);
            } else {
                return;
            }
        }
    }

    public ButtonCustomization(KeyAgreementSpi.ECKAEGwithSHA224KDF eCKAEGwithSHA224KDF, KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo mQVwithSHA224KDFAndSharedInfo, KeyFactorySpi.ECDHC ecdhc) {
        this.f2331a = eCKAEGwithSHA224KDF;
        this.f2332b = mQVwithSHA224KDFAndSharedInfo;
        this.configure = ecdhc;
        ecdhc.Cardinal();
        this.Cardinal = null;
    }

    public ButtonCustomization(KeyAgreementSpi.ECKAEGwithSHA224KDF eCKAEGwithSHA224KDF, KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo mQVwithSHA224KDFAndSharedInfo, KeyFactorySpi.ECDHC ecdhc, KeyAgreementSpi.ECKAEGwithSHA256KDF eCKAEGwithSHA256KDF) {
        this.f2331a = eCKAEGwithSHA224KDF;
        this.f2332b = mQVwithSHA224KDFAndSharedInfo;
        this.configure = ecdhc;
        ecdhc.Cardinal();
        this.Cardinal = eCKAEGwithSHA256KDF;
    }

    public void Cardinal(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA384WithRSAEncryption) {
            ISOSignatureSpi.SHA384WithRSAEncryption sHA384WithRSAEncryption = (ISOSignatureSpi.SHA384WithRSAEncryption) eCKAEGwithSHA512KDF;
            this.f2334d = sHA384WithRSAEncryption.Cardinal();
            eCKAEGwithSHA512KDF = sHA384WithRSAEncryption.configure;
        } else {
            this.f2334d = null;
        }
        this.f2333c = (ISOSignatureSpi) eCKAEGwithSHA512KDF;
    }

    /* renamed from: a */
    private byte[] m1792a(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
        byte[] bArr2;
        byte[] bArr3;
        KeyAgreementSpi.ECKAEGwithSHA256KDF eCKAEGwithSHA256KDF;
        KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF;
        if (this.Cardinal == null) {
            byte[] bArr4 = new byte[i2];
            int i3 = this.f2333c.getInstance / 8;
            bArr2 = new byte[i3];
            int i4 = i2 + i3;
            byte[] bArr5 = new byte[i4];
            this.f2332b.init(bArr5, 0, i4);
            if (this.cleanup.length != 0) {
                System.arraycopy(bArr5, 0, bArr2, 0, i3);
                System.arraycopy(bArr5, i3, bArr4, 0, i2);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, i2);
                System.arraycopy(bArr5, i2, bArr2, 0, i3);
            }
            bArr3 = new byte[i2];
            for (int i5 = 0; i5 != i2; i5++) {
                bArr3[i5] = (byte) (bArr[i5 + 0] ^ bArr4[i5]);
            }
        } else {
            int i6 = ((ISOSignatureSpi.SHA1WithRSAEncryption) this.f2333c).configure / 8;
            byte[] bArr6 = new byte[i6];
            int i7 = this.f2333c.getInstance / 8;
            byte[] bArr7 = new byte[i7];
            int i8 = i6 + i7;
            byte[] bArr8 = new byte[i8];
            this.f2332b.init(bArr8, 0, i8);
            System.arraycopy(bArr8, 0, bArr6, 0, i6);
            System.arraycopy(bArr8, i6, bArr7, 0, i7);
            if (this.f2334d != null) {
                eCKAEGwithSHA256KDF = this.Cardinal;
                eCKAEGwithSHA512KDF = new ISOSignatureSpi.SHA384WithRSAEncryption(new ISOSignatureSpi.MD5WithRSAEncryption(bArr6), this.f2334d);
            } else {
                eCKAEGwithSHA256KDF = this.Cardinal;
                eCKAEGwithSHA512KDF = new ISOSignatureSpi.MD5WithRSAEncryption(bArr6);
            }
            eCKAEGwithSHA256KDF.init(true, eCKAEGwithSHA512KDF);
            bArr3 = new byte[this.Cardinal.init(i2)];
            int instance = this.Cardinal.getInstance(bArr, 0, i2, bArr3);
            i2 = instance + this.Cardinal.getInstance(bArr3, instance);
            bArr2 = bArr7;
        }
        byte[] configure2 = this.f2333c.configure();
        byte[] bArr9 = null;
        if (this.cleanup.length != 0) {
            bArr9 = m1791a(configure2);
        }
        int Cardinal2 = this.configure.Cardinal();
        byte[] bArr10 = new byte[Cardinal2];
        this.configure.configure(new ISOSignatureSpi.MD5WithRSAEncryption(bArr2));
        this.configure.init(bArr3, 0, bArr3.length);
        if (configure2 != null) {
            this.configure.init(configure2, 0, configure2.length);
        }
        if (this.cleanup.length != 0) {
            this.configure.init(bArr9, 0, bArr9.length);
        }
        this.configure.Cardinal(bArr10);
        byte[] bArr11 = this.cleanup;
        byte[] bArr12 = new byte[(bArr11.length + i2 + Cardinal2)];
        System.arraycopy(bArr11, 0, bArr12, 0, bArr11.length);
        System.arraycopy(bArr3, 0, bArr12, this.cleanup.length, i2);
        System.arraycopy(bArr10, 0, bArr12, this.cleanup.length + i2, Cardinal2);
        return bArr12;
    }

    /* renamed from: b */
    private byte[] m1794b(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
        int i3;
        byte[] bArr2;
        byte[] bArr3;
        if (i2 >= this.cleanup.length + this.configure.Cardinal()) {
            if (this.Cardinal == null) {
                int length = (i2 - this.cleanup.length) - this.configure.Cardinal();
                byte[] bArr4 = new byte[length];
                int i4 = this.f2333c.getInstance / 8;
                bArr2 = new byte[i4];
                int i5 = length + i4;
                byte[] bArr5 = new byte[i5];
                this.f2332b.init(bArr5, 0, i5);
                if (this.cleanup.length != 0) {
                    System.arraycopy(bArr5, 0, bArr2, 0, i4);
                    System.arraycopy(bArr5, i4, bArr4, 0, length);
                } else {
                    System.arraycopy(bArr5, 0, bArr4, 0, length);
                    System.arraycopy(bArr5, length, bArr2, 0, i4);
                }
                bArr3 = new byte[length];
                for (int i6 = 0; i6 != length; i6++) {
                    bArr3[i6] = (byte) (bArr[(this.cleanup.length + 0) + i6] ^ bArr4[i6]);
                }
                i3 = 0;
            } else {
                int i7 = ((ISOSignatureSpi.SHA1WithRSAEncryption) this.f2333c).configure / 8;
                byte[] bArr6 = new byte[i7];
                int i8 = this.f2333c.getInstance / 8;
                bArr2 = new byte[i8];
                int i9 = i7 + i8;
                byte[] bArr7 = new byte[i9];
                this.f2332b.init(bArr7, 0, i9);
                System.arraycopy(bArr7, 0, bArr6, 0, i7);
                System.arraycopy(bArr7, i7, bArr2, 0, i8);
                KeyAgreementSpi.ECKAEGwithSHA512KDF mD5WithRSAEncryption = new ISOSignatureSpi.MD5WithRSAEncryption(bArr6);
                byte[] bArr8 = this.f2334d;
                if (bArr8 != null) {
                    mD5WithRSAEncryption = new ISOSignatureSpi.SHA384WithRSAEncryption(mD5WithRSAEncryption, bArr8);
                }
                this.Cardinal.init(false, mD5WithRSAEncryption);
                bArr3 = new byte[this.Cardinal.init((i2 - this.cleanup.length) - this.configure.Cardinal())];
                KeyAgreementSpi.ECKAEGwithSHA256KDF eCKAEGwithSHA256KDF = this.Cardinal;
                byte[] bArr9 = this.cleanup;
                i3 = eCKAEGwithSHA256KDF.getInstance(bArr, bArr9.length + 0, (i2 - bArr9.length) - this.configure.Cardinal(), bArr3);
            }
            byte[] configure2 = this.f2333c.configure();
            byte[] bArr10 = null;
            if (this.cleanup.length != 0) {
                bArr10 = m1791a(configure2);
            }
            int i10 = i2 + 0;
            byte[] cca_continue2 = setForegroundTintBlendMode.cca_continue(bArr, i10 - this.configure.Cardinal(), i10);
            int length2 = cca_continue2.length;
            byte[] bArr11 = new byte[length2];
            this.configure.configure(new ISOSignatureSpi.MD5WithRSAEncryption(bArr2));
            KeyFactorySpi.ECDHC ecdhc = this.configure;
            byte[] bArr12 = this.cleanup;
            ecdhc.init(bArr, bArr12.length + 0, (i2 - bArr12.length) - length2);
            if (configure2 != null) {
                this.configure.init(configure2, 0, configure2.length);
            }
            if (this.cleanup.length != 0) {
                this.configure.init(bArr10, 0, bArr10.length);
            }
            this.configure.Cardinal(bArr11);
            if (setForegroundTintBlendMode.init(cca_continue2, bArr11)) {
                KeyAgreementSpi.ECKAEGwithSHA256KDF eCKAEGwithSHA256KDF2 = this.Cardinal;
                return eCKAEGwithSHA256KDF2 == null ? bArr3 : setForegroundTintBlendMode.cca_continue(bArr3, 0, i3 + eCKAEGwithSHA256KDF2.getInstance(bArr3, i3));
            }
            throw new KeyFactorySpi.ECDH("invalid MAC");
        }
        throw new KeyFactorySpi.ECDH("Length of input must be greater than the MAC and V combined");
    }

    public final byte[] Cardinal(byte[] bArr, int i) throws KeyFactorySpi.ECDH {
        if (this.init) {
            ToolbarCustomization toolbarCustomization = this.CardinalError;
            if (toolbarCustomization != null) {
                IESUtil iESUtil = new IESUtil(toolbarCustomization.f2485a.init(), toolbarCustomization.f2486b);
                this.getInstance = iESUtil.init.cca_continue;
                this.cleanup = iESUtil.getInstance();
            }
        } else if (this.getSDKVersion != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i);
            try {
                this.cca_continue = this.getSDKVersion.Cardinal(byteArrayInputStream);
                this.cleanup = setForegroundTintBlendMode.cca_continue(bArr, 0, i - byteArrayInputStream.available());
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder("unable to recover ephemeral public key: ");
                sb.append(e.getMessage());
                throw new KeyFactorySpi.ECDH(sb.toString(), e);
            } catch (IllegalArgumentException e2) {
                StringBuilder sb2 = new StringBuilder("unable to recover ephemeral public key: ");
                sb2.append(e2.getMessage());
                throw new KeyFactorySpi.ECDH(sb2.toString(), e2);
            }
        }
        this.f2331a.configure(this.getInstance);
        byte[] Cardinal2 = setSelected.Cardinal(this.f2331a.cca_continue(), this.f2331a.Cardinal(this.cca_continue));
        byte[] bArr2 = this.cleanup;
        if (bArr2.length != 0) {
            byte[] cca_continue2 = setForegroundTintBlendMode.cca_continue(bArr2, Cardinal2);
            setForegroundTintBlendMode.configure(Cardinal2, (byte) 0);
            Cardinal2 = cca_continue2;
        }
        try {
            this.f2332b.getInstance(new DigestSignatureSpi.noneRSA(Cardinal2, this.f2333c.init()));
            return this.init ? m1792a(bArr, 0, i) : m1794b(bArr, 0, i);
        } finally {
            setForegroundTintBlendMode.configure(Cardinal2, (byte) 0);
        }
    }

    /* renamed from: a */
    private static byte[] m1791a(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            long length = ((long) bArr.length) << 3;
            setMinimumWidth.getInstance((int) (length >>> 32), bArr2, 0);
            setMinimumWidth.getInstance((int) length, bArr2, 4);
        }
        return bArr2;
    }
}
