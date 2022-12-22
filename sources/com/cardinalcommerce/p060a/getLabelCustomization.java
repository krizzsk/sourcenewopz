package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.getLabelCustomization */
public final class getLabelCustomization {

    /* renamed from: a */
    private static final long[] f2567a = {878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042};

    public static void Cardinal(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
    }

    public static void Cardinal(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    /* renamed from: a */
    private static void m1896a(long j, long j2, long[] jArr, int i) {
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
    private static void m1897a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        long j10 = jArr[9];
        jArr[0] = j ^ (j2 << 57);
        jArr[1] = (j2 >>> 7) ^ (j3 << 50);
        jArr[2] = (j3 >>> 14) ^ (j4 << 43);
        jArr[3] = (j4 >>> 21) ^ (j5 << 36);
        jArr[4] = (j5 >>> 28) ^ (j6 << 29);
        jArr[5] = (j6 >>> 35) ^ (j7 << 22);
        jArr[6] = (j7 >>> 42) ^ (j8 << 15);
        jArr[7] = (j8 >>> 49) ^ (j9 << 8);
        jArr[8] = (j9 >>> 56) ^ (j10 << 1);
        jArr[9] = j10 >>> 63;
    }

    /* renamed from: a */
    private static void m1898a(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        jArr2[0] = j & 144115188075855871L;
        jArr2[1] = ((j >>> 57) ^ (j2 << 7)) & 144115188075855871L;
        jArr2[2] = ((j2 >>> 50) ^ (j3 << 14)) & 144115188075855871L;
        jArr2[3] = ((j3 >>> 43) ^ (j4 << 21)) & 144115188075855871L;
        jArr2[4] = (j4 >>> 36) ^ (j5 << 28);
    }

    /* renamed from: a */
    private static void m1899a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr[7] ^ jArr2[7];
        jArr3[8] = jArr2[8] ^ jArr[8];
    }

    /* renamed from: b */
    private static void m1900b(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 4; i++) {
            setLabelFor.cca_continue(jArr[i], jArr2, i << 1);
        }
        jArr2[8] = setLabelFor.Cardinal((int) jArr[4]);
    }

    /* renamed from: b */
    private static void m1901b(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[5];
        m1898a(jArr, jArr4);
        m1898a(jArr2, jArr5);
        long[] jArr6 = new long[26];
        long[] jArr7 = jArr6;
        m1896a(jArr4[0], jArr5[0], jArr7, 0);
        m1896a(jArr4[1], jArr5[1], jArr7, 2);
        m1896a(jArr4[2], jArr5[2], jArr7, 4);
        m1896a(jArr4[3], jArr5[3], jArr7, 6);
        m1896a(jArr4[4], jArr5[4], jArr7, 8);
        long j = jArr4[0] ^ jArr4[1];
        long j2 = jArr5[0] ^ jArr5[1];
        long j3 = jArr4[0] ^ jArr4[2];
        long j4 = jArr5[0] ^ jArr5[2];
        long j5 = jArr4[2] ^ jArr4[4];
        long j6 = jArr5[2] ^ jArr5[4];
        long j7 = jArr4[3] ^ jArr4[4];
        long j8 = jArr5[3] ^ jArr5[4];
        m1896a(j3 ^ jArr4[3], j4 ^ jArr5[3], jArr7, 18);
        m1896a(j5 ^ jArr4[1], j6 ^ jArr5[1], jArr7, 20);
        long j9 = j ^ j7;
        long j10 = j2 ^ j8;
        long j11 = j9 ^ jArr4[2];
        long[] jArr8 = jArr6;
        m1896a(j9, j10, jArr8, 22);
        m1896a(j11, jArr5[2] ^ j10, jArr8, 24);
        m1896a(j, j2, jArr8, 10);
        m1896a(j3, j4, jArr8, 12);
        m1896a(j5, j6, jArr8, 14);
        m1896a(j7, j8, jArr8, 16);
        jArr3[0] = jArr6[0];
        jArr3[9] = jArr6[9];
        long j12 = jArr6[0] ^ jArr6[1];
        long j13 = jArr6[2] ^ j12;
        long j14 = jArr6[10] ^ j13;
        jArr3[1] = j14;
        long j15 = jArr6[3] ^ jArr6[4];
        long j16 = j13 ^ (j15 ^ (jArr6[11] ^ jArr6[12]));
        jArr3[2] = j16;
        long j17 = jArr6[5] ^ jArr6[6];
        long j18 = ((j12 ^ j15) ^ j17) ^ jArr6[8];
        long j19 = jArr6[13] ^ jArr6[14];
        jArr3[3] = (j18 ^ j19) ^ ((jArr6[18] ^ jArr6[22]) ^ jArr6[24]);
        long j20 = (jArr6[7] ^ jArr6[8]) ^ jArr6[9];
        long j21 = j20 ^ jArr6[17];
        jArr3[8] = j21;
        long j22 = (j20 ^ j17) ^ (jArr6[15] ^ jArr6[16]);
        jArr3[7] = j22;
        long j23 = j14 ^ j22;
        long j24 = (jArr6[19] ^ jArr6[20]) ^ (jArr6[25] ^ jArr6[24]);
        jArr3[4] = (j24 ^ (jArr6[18] ^ jArr6[23])) ^ j23;
        jArr3[5] = ((j16 ^ j21) ^ j24) ^ (jArr6[21] ^ jArr6[22]);
        jArr3[6] = ((((jArr6[9] ^ (j18 ^ jArr6[0])) ^ j19) ^ jArr6[21]) ^ jArr6[23]) ^ jArr6[25];
        m1897a(jArr3);
    }

    public static void cca_continue(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        long j10 = j5 ^ ((((j9 >>> 27) ^ (j9 >>> 22)) ^ (j9 >>> 20)) ^ (j9 >>> 15));
        long j11 = j ^ ((((j6 << 37) ^ (j6 << 42)) ^ (j6 << 44)) ^ (j6 << 49));
        long j12 = (j2 ^ ((((j7 << 37) ^ (j7 << 42)) ^ (j7 << 44)) ^ (j7 << 49))) ^ ((((j6 >>> 27) ^ (j6 >>> 22)) ^ (j6 >>> 20)) ^ (j6 >>> 15));
        long j13 = j10 >>> 27;
        jArr2[0] = (((j11 ^ j13) ^ (j13 << 5)) ^ (j13 << 7)) ^ (j13 << 12);
        jArr2[1] = j12;
        jArr2[2] = (j3 ^ ((((j8 << 37) ^ (j8 << 42)) ^ (j8 << 44)) ^ (j8 << 49))) ^ ((((j7 >>> 27) ^ (j7 >>> 22)) ^ (j7 >>> 20)) ^ (j7 >>> 15));
        jArr2[3] = (j4 ^ ((((j9 << 37) ^ (j9 << 42)) ^ (j9 << 44)) ^ (j9 << 49))) ^ ((((j8 >>> 27) ^ (j8 >>> 22)) ^ (j8 >>> 20)) ^ (j8 >>> 15));
        jArr2[4] = 134217727 & j10;
    }

    public static int configure(long[] jArr) {
        return ((int) (jArr[0] ^ (jArr[4] >>> 15))) & 1;
    }

    public static long[] cca_continue(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 320) {
            throw new IllegalArgumentException();
        }
        long[] jArr = new long[5];
        int i = 0;
        while (bigInteger.signum() != 0) {
            jArr[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i++;
        }
        long j = jArr[4];
        long j2 = j >>> 27;
        jArr[0] = ((j2 << 12) ^ (((j2 << 5) ^ j2) ^ (j2 << 7))) ^ jArr[0];
        jArr[4] = j & 134217727;
        return jArr;
    }

    public static void init(long[] jArr, long[] jArr2) {
        if (!setNextFocusUpId.getInstance(jArr)) {
            long[] jArr3 = new long[5];
            long[] jArr4 = new long[5];
            getInstance(jArr, jArr3);
            long[] jArr5 = new long[10];
            m1901b(jArr3, jArr, jArr5);
            cca_continue(jArr5, jArr3);
            Cardinal(jArr3, 2, jArr4);
            long[] jArr6 = new long[10];
            m1901b(jArr4, jArr3, jArr6);
            cca_continue(jArr6, jArr4);
            Cardinal(jArr4, 4, jArr3);
            long[] jArr7 = new long[10];
            m1901b(jArr3, jArr4, jArr7);
            cca_continue(jArr7, jArr3);
            Cardinal(jArr3, 8, jArr4);
            long[] jArr8 = new long[10];
            m1901b(jArr4, jArr3, jArr8);
            cca_continue(jArr8, jArr4);
            getInstance(jArr4, jArr4);
            long[] jArr9 = new long[10];
            m1901b(jArr4, jArr, jArr9);
            cca_continue(jArr9, jArr4);
            Cardinal(jArr4, 17, jArr3);
            long[] jArr10 = new long[10];
            m1901b(jArr3, jArr4, jArr10);
            cca_continue(jArr10, jArr3);
            getInstance(jArr3, jArr3);
            long[] jArr11 = new long[10];
            m1901b(jArr3, jArr, jArr11);
            cca_continue(jArr11, jArr3);
            Cardinal(jArr3, 35, jArr4);
            long[] jArr12 = new long[10];
            m1901b(jArr4, jArr3, jArr12);
            cca_continue(jArr12, jArr4);
            Cardinal(jArr4, 70, jArr3);
            long[] jArr13 = new long[10];
            m1901b(jArr3, jArr4, jArr13);
            cca_continue(jArr13, jArr3);
            getInstance(jArr3, jArr3);
            long[] jArr14 = new long[10];
            m1901b(jArr3, jArr, jArr14);
            cca_continue(jArr14, jArr3);
            Cardinal(jArr3, 141, jArr4);
            long[] jArr15 = new long[10];
            m1901b(jArr4, jArr3, jArr15);
            cca_continue(jArr15, jArr4);
            getInstance(jArr4, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void configure(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[10];
        m1901b(jArr, jArr2, jArr4);
        cca_continue(jArr4, jArr3);
    }

    public static void init(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[10];
        m1901b(jArr, jArr2, jArr4);
        m1899a(jArr3, jArr4, jArr3);
    }

    public static void configure(long[] jArr, long[] jArr2) {
        long[] jArr3 = jArr2;
        long[] jArr4 = new long[5];
        long configure = setLabelFor.configure(jArr[0]);
        long configure2 = setLabelFor.configure(jArr[1]);
        long j = (configure & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (configure2 << 32);
        jArr4[0] = (configure >>> 32) | (configure2 & -4294967296L);
        long configure3 = setLabelFor.configure(jArr[2]);
        long configure4 = setLabelFor.configure(jArr[3]);
        jArr4[1] = (configure3 >>> 32) | (-4294967296L & configure4);
        long configure5 = setLabelFor.configure(jArr[4]);
        long j2 = InternalZipConstants.ZIP_64_SIZE_LIMIT & configure5;
        jArr4[2] = configure5 >>> 32;
        long[] jArr5 = new long[10];
        m1901b(jArr4, f2567a, jArr5);
        cca_continue(jArr5, jArr3);
        jArr3[0] = jArr3[0] ^ j;
        jArr3[1] = jArr3[1] ^ ((configure3 & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (configure4 << 32));
        jArr3[2] = jArr3[2] ^ j2;
    }

    public static void getInstance(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[9];
        m1900b(jArr, jArr3);
        cca_continue(jArr3, jArr2);
    }

    public static void getWarnings(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[9];
        m1900b(jArr, jArr3);
        m1899a(jArr2, jArr3, jArr2);
    }

    public static void Cardinal(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[9];
        m1900b(jArr, jArr3);
        while (true) {
            cca_continue(jArr3, jArr2);
            i--;
            if (i > 0) {
                m1900b(jArr2, jArr3);
            } else {
                return;
            }
        }
    }
}
