package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.getButtonCustomization */
public final class getButtonCustomization implements KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo {

    /* renamed from: a */
    private byte[] f2544a;

    /* renamed from: b */
    private byte[] f2545b;

    /* renamed from: c */
    private byte[] f2546c;

    /* renamed from: d */
    private int f2547d;

    /* renamed from: e */
    private KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo f2548e;

    /* renamed from: f */
    private boolean f2549f;

    public getButtonCustomization() {
    }

    /* renamed from: a */
    private static void m1883a(long j, long j2, long[] jArr, int i) {
        long j3 = j;
        long[] jArr2 = new long[8];
        jArr2[1] = j2;
        jArr2[2] = jArr2[1] << 1;
        jArr2[3] = jArr2[2] ^ j2;
        jArr2[4] = jArr2[2] << 1;
        jArr2[5] = jArr2[4] ^ j2;
        jArr2[6] = jArr2[3] << 1;
        jArr2[7] = jArr2[6] ^ j2;
        int i2 = (int) j3;
        long j4 = (jArr2[(i2 >>> 3) & 7] << 3) ^ jArr2[i2 & 7];
        long j5 = 0;
        int i3 = 54;
        do {
            int i4 = (int) (j3 >>> i3);
            long j6 = (jArr2[(i4 >>> 3) & 7] << 3) ^ jArr2[i4 & 7];
            j4 ^= j6 << i3;
            j5 ^= j6 >>> (-i3);
            i3 -= 6;
        } while (i3 > 0);
        jArr[i] = jArr[i] ^ (1152921504606846975L & j4);
        int i5 = i + 1;
        jArr[i5] = ((((((j3 & 585610922974906400L) & ((j2 << 4) >> 63)) >>> 5) ^ j5) << 4) ^ (j4 >>> 60)) ^ jArr[i5];
    }

    /* renamed from: a */
    private static void m1884a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        jArr[0] = j ^ (j2 << 60);
        jArr[1] = (j2 >>> 4) ^ (j3 << 56);
        jArr[2] = (j3 >>> 8) ^ (j4 << 52);
        jArr[3] = (j4 >>> 12) ^ (j5 << 48);
        jArr[4] = (j5 >>> 16) ^ (j6 << 44);
        jArr[5] = (j6 >>> 20) ^ (j7 << 40);
        jArr[6] = (j7 >>> 24) ^ (j8 << 36);
        jArr[7] = j8 >>> 28;
    }

    /* renamed from: a */
    static void m1885a(long[] jArr, long[] jArr2) {
        setLabelFor.cca_continue(jArr[0], jArr2, 0);
        setLabelFor.cca_continue(jArr[1], jArr2, 2);
        setLabelFor.cca_continue(jArr[2], jArr2, 4);
        long j = jArr[3];
        jArr2[6] = setLabelFor.Cardinal((int) j);
        jArr2[7] = ((long) setLabelFor.getInstance((int) (j >>> 32))) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
    }

    /* renamed from: a */
    static void m1886a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    /* renamed from: b */
    private static void m1887b(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 1152921504606846975L;
        jArr2[1] = ((j >>> 60) ^ (j2 << 4)) & 1152921504606846975L;
        jArr2[2] = ((j2 >>> 56) ^ (j3 << 8)) & 1152921504606846975L;
        jArr2[3] = (j3 >>> 52) ^ (j4 << 12);
    }

    /* renamed from: b */
    static void m1888b(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        m1887b(jArr, jArr4);
        m1887b(jArr2, jArr5);
        long[] jArr6 = jArr3;
        m1883a(jArr4[0], jArr5[0], jArr6, 0);
        m1883a(jArr4[1], jArr5[1], jArr6, 1);
        m1883a(jArr4[2], jArr5[2], jArr6, 2);
        m1883a(jArr4[3], jArr5[3], jArr6, 3);
        for (int i = 5; i > 0; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 1];
        }
        m1883a(jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        m1883a(jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i2 = 7; i2 > 1; i2--) {
            jArr3[i2] = jArr3[i2] ^ jArr3[i2 - 2];
        }
        long j = jArr4[0] ^ jArr4[2];
        long j2 = jArr4[1] ^ jArr4[3];
        long j3 = jArr5[0] ^ jArr5[2];
        long j4 = jArr5[1] ^ jArr5[3];
        m1883a(j ^ j2, j3 ^ j4, jArr3, 3);
        long[] jArr7 = new long[3];
        m1883a(j, j3, jArr7, 0);
        m1883a(j2, j4, jArr7, 1);
        long j5 = jArr7[0];
        long j6 = jArr7[1];
        long j7 = jArr7[2];
        jArr3[2] = jArr3[2] ^ j5;
        jArr3[3] = (j5 ^ j6) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j7 ^ j6);
        jArr3[5] = jArr3[5] ^ j7;
        m1884a(jArr3);
    }

    public static void init(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = j7 ^ (j8 >>> 17);
        long j10 = (j6 ^ (j8 << 47)) ^ (j9 >>> 17);
        long j11 = ((j5 ^ (j8 >>> 47)) ^ (j9 << 47)) ^ (j10 >>> 17);
        long j12 = j ^ (j11 << 17);
        long j13 = (j2 ^ (j10 << 17)) ^ (j11 >>> 47);
        long j14 = (((j4 ^ (j8 << 17)) ^ (j9 >>> 47)) ^ (j10 << 47)) ^ (j11 >>> 17);
        long j15 = j14 >>> 47;
        jArr2[0] = j12 ^ j15;
        jArr2[1] = j13;
        long j16 = j15 << 30;
        jArr2[2] = j16 ^ (((j3 ^ (j9 << 17)) ^ (j10 >>> 47)) ^ (j11 << 47));
        jArr2[3] = 140737488355327L & j14;
    }

    public static long[] init(BigInteger bigInteger) {
        long[] cca_continue = setNextFocusLeftId.cca_continue(bigInteger);
        long j = cca_continue[3];
        long j2 = j >>> 47;
        cca_continue[0] = cca_continue[0] ^ j2;
        cca_continue[2] = (j2 << 30) ^ cca_continue[2];
        cca_continue[3] = j & 140737488355327L;
        return cca_continue;
    }

    public static void cca_continue(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        m1888b(jArr, jArr2, jArr4);
        init(jArr4, jArr3);
    }

    public static void cca_continue(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[8];
        m1885a(jArr, jArr3);
        while (true) {
            init(jArr3, jArr2);
            i--;
            if (i > 0) {
                m1885a(jArr2, jArr3);
            } else {
                return;
            }
        }
    }

    public getButtonCustomization(KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo dHwithSHA512KDFAndSharedInfo) {
        this.f2548e = null;
        this.f2548e = dHwithSHA512KDFAndSharedInfo;
        int cca_continue = dHwithSHA512KDFAndSharedInfo.cca_continue();
        this.f2547d = cca_continue;
        this.f2544a = new byte[cca_continue];
        this.f2545b = new byte[cca_continue];
        this.f2546c = new byte[cca_continue];
    }

    public final void Cardinal(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) throws IllegalArgumentException {
        KeyAgreementSpi.DHwithSHA512KDFAndSharedInfo dHwithSHA512KDFAndSharedInfo;
        boolean z2 = this.f2549f;
        this.f2549f = z;
        if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA384WithRSAEncryption) {
            ISOSignatureSpi.SHA384WithRSAEncryption sHA384WithRSAEncryption = (ISOSignatureSpi.SHA384WithRSAEncryption) eCKAEGwithSHA512KDF;
            byte[] Cardinal = sHA384WithRSAEncryption.Cardinal();
            if (Cardinal.length == this.f2547d) {
                System.arraycopy(Cardinal, 0, this.f2544a, 0, Cardinal.length);
                init();
                if (sHA384WithRSAEncryption.configure != null) {
                    dHwithSHA512KDFAndSharedInfo = this.f2548e;
                    eCKAEGwithSHA512KDF = sHA384WithRSAEncryption.configure;
                } else if (z2 != z) {
                    throw new IllegalArgumentException("cannot change encrypting state without providing key.");
                } else {
                    return;
                }
            } else {
                throw new IllegalArgumentException("initialisation vector must be the same length as block size");
            }
        } else {
            init();
            if (eCKAEGwithSHA512KDF != null) {
                dHwithSHA512KDFAndSharedInfo = this.f2548e;
            } else if (z2 != z) {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            } else {
                return;
            }
        }
        dHwithSHA512KDFAndSharedInfo.Cardinal(z, eCKAEGwithSHA512KDF);
    }

    public final String Cardinal() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2548e.Cardinal());
        sb.append("/CBC");
        return sb.toString();
    }

    public final int cca_continue() {
        return this.f2548e.cca_continue();
    }

    public final int init(byte[] bArr, int i, byte[] bArr2, int i2) throws KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo, IllegalStateException {
        if (!this.f2549f) {
            int i3 = this.f2547d;
            if (i + i3 <= bArr.length) {
                System.arraycopy(bArr, i, this.f2546c, 0, i3);
                int init = this.f2548e.init(bArr, i, bArr2, i2);
                for (int i4 = 0; i4 < this.f2547d; i4++) {
                    int i5 = i2 + i4;
                    bArr2[i5] = (byte) (bArr2[i5] ^ this.f2545b[i4]);
                }
                byte[] bArr3 = this.f2545b;
                this.f2545b = this.f2546c;
                this.f2546c = bArr3;
                return init;
            }
            throw new KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo("input buffer too short");
        } else if (this.f2547d + i <= bArr.length) {
            for (int i6 = 0; i6 < this.f2547d; i6++) {
                byte[] bArr4 = this.f2545b;
                bArr4[i6] = (byte) (bArr4[i6] ^ bArr[i + i6]);
            }
            int init2 = this.f2548e.init(this.f2545b, 0, bArr2, i2);
            byte[] bArr5 = this.f2545b;
            System.arraycopy(bArr2, i2, bArr5, 0, bArr5.length);
            return init2;
        } else {
            throw new KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo("input buffer too short");
        }
    }

    public final void init() {
        byte[] bArr = this.f2544a;
        System.arraycopy(bArr, 0, this.f2545b, 0, bArr.length);
        byte[] bArr2 = this.f2546c;
        for (int i = 0; i < bArr2.length; i++) {
            bArr2[i] = 0;
        }
        this.f2548e.init();
    }
}
