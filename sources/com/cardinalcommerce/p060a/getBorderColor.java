package com.cardinalcommerce.p060a;

import androidx.core.view.InputDeviceCompat;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.getBorderColor */
public class getBorderColor implements KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo {
    private byte[] Cardinal;
    private int cca_continue;
    private byte[] configure;
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo getInstance;

    public getBorderColor() {
    }

    static void Cardinal(long[] jArr, long[] jArr2) {
        setLabelFor.cca_continue(jArr[0], jArr2, 0);
        setLabelFor.cca_continue(jArr[1], jArr2, 2);
        setLabelFor.cca_continue(jArr[2], jArr2, 4);
        jArr2[6] = jArr[3] & 1;
    }

    static void Cardinal(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        cca_continue(jArr, jArr4);
        cca_continue(jArr2, jArr5);
        long[] jArr6 = jArr3;
        configure(jArr4[0], jArr5[0], jArr6, 0);
        configure(jArr4[1], jArr5[1], jArr6, 1);
        configure(jArr4[2], jArr5[2], jArr6, 2);
        configure(jArr4[3], jArr5[3], jArr6, 3);
        for (int i = 5; i > 0; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 1];
        }
        configure(jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        configure(jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i2 = 7; i2 > 1; i2--) {
            jArr3[i2] = jArr3[i2] ^ jArr3[i2 - 2];
        }
        long j = jArr4[0] ^ jArr4[2];
        long j2 = jArr4[1] ^ jArr4[3];
        long j3 = jArr5[0] ^ jArr5[2];
        long j4 = jArr5[1] ^ jArr5[3];
        configure(j ^ j2, j3 ^ j4, jArr3, 3);
        long[] jArr7 = new long[3];
        configure(j, j3, jArr7, 0);
        configure(j2, j4, jArr7, 1);
        long j5 = jArr7[0];
        long j6 = jArr7[1];
        long j7 = jArr7[2];
        jArr3[2] = jArr3[2] ^ j5;
        jArr3[3] = (j5 ^ j6) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j7 ^ j6);
        jArr3[5] = jArr3[5] ^ j7;
        cca_continue(jArr3);
    }

    private static void cca_continue(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        jArr[0] = j ^ (j2 << 49);
        jArr[1] = (j2 >>> 15) ^ (j3 << 34);
        jArr[2] = (j3 >>> 30) ^ (j4 << 19);
        jArr[3] = ((j4 >>> 45) ^ (j5 << 4)) ^ (j6 << 53);
        jArr[4] = ((j5 >>> 60) ^ (j7 << 38)) ^ (j6 >>> 11);
        jArr[5] = (j7 >>> 26) ^ (j8 << 23);
        jArr[6] = j8 >>> 41;
        jArr[7] = 0;
    }

    private static void cca_continue(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 562949953421311L;
        jArr2[1] = ((j >>> 49) ^ (j2 << 15)) & 562949953421311L;
        jArr2[2] = ((j2 >>> 34) ^ (j3 << 30)) & 562949953421311L;
        jArr2[3] = (j3 >>> 19) ^ (j4 << 45);
    }

    private static void configure(long j, long j2, long[] jArr, int i) {
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
        int i3 = 36;
        do {
            int i4 = (int) (j3 >>> i3);
            long j6 = (jArr2[(i4 >>> 12) & 7] << 12) ^ (((jArr2[i4 & 7] ^ (jArr2[(i4 >>> 3) & 7] << 3)) ^ (jArr2[(i4 >>> 6) & 7] << 6)) ^ (jArr2[(i4 >>> 9) & 7] << 9));
            j4 ^= j6 << i3;
            j5 ^= j6 >>> (-i3);
            i3 -= 15;
        } while (i3 > 0);
        jArr[i] = jArr[i] ^ (562949953421311L & j4);
        int i5 = i + 1;
        jArr[i5] = jArr[i5] ^ ((j4 >>> 49) ^ (j5 << 15));
    }

    public static void getInstance(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = j5 ^ (j7 >>> 50);
        long j9 = (j4 ^ ((j7 >>> 1) ^ (j7 << 14))) ^ (j6 >>> 50);
        long j10 = j ^ (j8 << 63);
        long j11 = (j2 ^ (j6 << 63)) ^ ((j8 >>> 1) ^ (j8 << 14));
        long j12 = ((j3 ^ (j7 << 63)) ^ ((j6 >>> 1) ^ (j6 << 14))) ^ (j8 >>> 50);
        long j13 = j9 >>> 1;
        jArr2[0] = (j10 ^ j13) ^ (j13 << 15);
        jArr2[1] = (j13 >>> 49) ^ j11;
        jArr2[2] = j12;
        jArr2[3] = 1 & j9;
    }

    static void getInstance(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    public static long[] configure(BigInteger bigInteger) {
        long[] cca_continue2 = setNextFocusLeftId.cca_continue(bigInteger);
        long j = cca_continue2[3];
        long j2 = j >>> 1;
        cca_continue2[0] = cca_continue2[0] ^ ((j2 << 15) ^ j2);
        cca_continue2[1] = (j2 >>> 49) ^ cca_continue2[1];
        cca_continue2[3] = j & 1;
        return cca_continue2;
    }

    public static void configure(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        Cardinal(jArr, jArr2, jArr4);
        getInstance(jArr4, jArr3);
    }

    public static void Cardinal(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[8];
        Cardinal(jArr, jArr3);
        while (true) {
            getInstance(jArr3, jArr2);
            i--;
            if (i > 0) {
                Cardinal(jArr2, jArr3);
            } else {
                return;
            }
        }
    }

    public getBorderColor(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
        this.cca_continue = 1;
        this.getInstance = mQVwithSHA256KDFAndSharedInfo;
    }

    public final void getInstance(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        if (eCKAEGwithSHA512KDF instanceof DigestSignatureSpi.noneRSA) {
            DigestSignatureSpi.noneRSA nonersa = (DigestSignatureSpi.noneRSA) eCKAEGwithSHA512KDF;
            this.Cardinal = nonersa.configure();
            this.configure = nonersa.getInstance();
        } else if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.RIPEMD160WithRSAEncryption) {
            this.Cardinal = null;
            this.configure = null;
        } else {
            throw new IllegalArgumentException("KDF parameters required for generator");
        }
    }

    public final int init(byte[] bArr, int i, int i2) throws KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo, IllegalArgumentException {
        byte[] bArr2 = bArr;
        int i3 = i2;
        if (bArr2.length - i3 >= 0) {
            long j = (long) i3;
            int instance = this.getInstance.getInstance();
            if (j <= 8589934591L) {
                long j2 = (long) instance;
                int i4 = (int) (((j + j2) - 1) / j2);
                byte[] bArr3 = new byte[this.getInstance.getInstance()];
                byte[] bArr4 = new byte[4];
                setMinimumWidth.getInstance(this.cca_continue, bArr4, 0);
                int i5 = this.cca_continue & InputDeviceCompat.SOURCE_ANY;
                int i6 = i3;
                int i7 = i;
                for (int i8 = 0; i8 < i4; i8++) {
                    KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.getInstance;
                    byte[] bArr5 = this.Cardinal;
                    mQVwithSHA256KDFAndSharedInfo.init(bArr5, 0, bArr5.length);
                    this.getInstance.init(bArr4, 0, 4);
                    byte[] bArr6 = this.configure;
                    if (bArr6 != null) {
                        this.getInstance.init(bArr6, 0, bArr6.length);
                    }
                    this.getInstance.configure(bArr3, 0);
                    if (i6 > instance) {
                        System.arraycopy(bArr3, 0, bArr2, i7, instance);
                        i7 += instance;
                        i6 -= instance;
                    } else {
                        System.arraycopy(bArr3, 0, bArr2, i7, i6);
                    }
                    byte b = (byte) (bArr4[3] + 1);
                    bArr4[3] = b;
                    if (b == 0) {
                        i5 += 256;
                        setMinimumWidth.getInstance(i5, bArr4, 0);
                    }
                }
                this.getInstance.cca_continue();
                return (int) j;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new KeyFactorySpi.ECDSA("output buffer too small");
    }
}
