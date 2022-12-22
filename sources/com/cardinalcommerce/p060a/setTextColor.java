package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setTextColor */
public final class setTextColor {

    /* renamed from: a */
    private static final long[] f3005a = {-5270498306774157648L, 5270498306774195053L, 19634136210L};

    public static void Cardinal(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr2[2] ^ jArr[2];
    }

    /* renamed from: a */
    private static void m2095a(long j, long j2, long[] jArr, int i) {
        long j3 = j;
        long[] jArr2 = new long[8];
        jArr2[1] = j2;
        jArr2[2] = jArr2[1] << 1;
        jArr2[3] = jArr2[2] ^ j2;
        jArr2[4] = jArr2[2] << 1;
        jArr2[5] = jArr2[4] ^ j2;
        jArr2[6] = jArr2[3] << 1;
        jArr2[7] = jArr2[6] ^ j2;
        long j4 = jArr2[((int) j3) & 3];
        long j5 = 0;
        int i2 = 47;
        do {
            int i3 = (int) (j3 >>> i2);
            long j6 = (jArr2[(i3 >>> 6) & 7] << 6) ^ (jArr2[i3 & 7] ^ (jArr2[(i3 >>> 3) & 7] << 3));
            j4 ^= j6 << i2;
            j5 ^= j6 >>> (-i2);
            i2 -= 9;
        } while (i2 > 0);
        jArr[i] = 36028797018963967L & j4;
        jArr[i + 1] = (j4 >>> 55) ^ (j5 << 9);
    }

    /* renamed from: a */
    private static void m2096a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        jArr[0] = j ^ (j2 << 55);
        jArr[1] = (j2 >>> 9) ^ (j3 << 46);
        jArr[2] = (j3 >>> 18) ^ (j4 << 37);
        jArr[3] = (j4 >>> 27) ^ (j5 << 28);
        jArr[4] = (j5 >>> 36) ^ (j6 << 19);
        jArr[5] = j6 >>> 45;
    }

    /* renamed from: a */
    private static void m2097a(long[] jArr, long[] jArr2) {
        setLabelFor.cca_continue(jArr[0], jArr2, 0);
        setLabelFor.cca_continue(jArr[1], jArr2, 2);
        long j = jArr[2];
        jArr2[4] = setLabelFor.Cardinal((int) j);
        jArr2[5] = ((long) setLabelFor.configure((int) (j >>> 32))) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
    }

    /* renamed from: a */
    private static void m2098a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr2[5] ^ jArr[5];
    }

    /* renamed from: b */
    private static void m2099b(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = (jArr[2] << 18) ^ (j2 >>> 46);
        long j4 = ((j2 << 9) ^ (j >>> 55)) & 36028797018963967L;
        long j5 = j & 36028797018963967L;
        long j6 = jArr2[0];
        long j7 = jArr2[1];
        long j8 = (j7 >>> 46) ^ (jArr2[2] << 18);
        long j9 = ((j6 >>> 55) ^ (j7 << 9)) & 36028797018963967L;
        long j10 = j6 & 36028797018963967L;
        long[] jArr4 = new long[10];
        long[] jArr5 = jArr4;
        m2095a(j5, j10, jArr5, 0);
        m2095a(j3, j8, jArr5, 2);
        long j11 = (j5 ^ j4) ^ j3;
        long j12 = (j10 ^ j9) ^ j8;
        long[] jArr6 = jArr4;
        m2095a(j11, j12, jArr6, 4);
        long j13 = (j4 << 1) ^ (j3 << 2);
        long j14 = (j9 << 1) ^ (j8 << 2);
        m2095a(j5 ^ j13, j10 ^ j14, jArr6, 6);
        m2095a(j11 ^ j13, j12 ^ j14, jArr6, 8);
        long j15 = jArr4[6] ^ jArr4[8];
        long j16 = jArr4[7] ^ jArr4[9];
        long j17 = (j15 << 1) ^ jArr4[6];
        long j18 = (j15 ^ (j16 << 1)) ^ jArr4[7];
        long j19 = jArr4[0];
        long j20 = (jArr4[1] ^ jArr4[0]) ^ jArr4[4];
        long j21 = jArr4[1] ^ jArr4[5];
        long j22 = ((j17 ^ j19) ^ (jArr4[2] << 4)) ^ (jArr4[2] << 1);
        long j23 = (((j18 ^ j20) ^ (jArr4[3] << 4)) ^ (jArr4[3] << 1)) ^ (j22 >>> 55);
        long j24 = (j21 ^ j16) ^ (j23 >>> 55);
        long j25 = j23 & 36028797018963967L;
        long j26 = ((j22 & 36028797018963967L) >>> 1) ^ ((j25 & 1) << 54);
        long j27 = j26 ^ (j26 << 1);
        long j28 = j27 ^ (j27 << 2);
        long j29 = j28 ^ (j28 << 4);
        long j30 = j29 ^ (j29 << 8);
        long j31 = j30 ^ (j30 << 16);
        long j32 = (j31 ^ (j31 << 32)) & 36028797018963967L;
        long j33 = ((j25 >>> 1) ^ ((j24 & 1) << 54)) ^ (j32 >>> 54);
        long j34 = j33 ^ (j33 << 1);
        long j35 = j34 ^ (j34 << 2);
        long j36 = j35 ^ (j35 << 4);
        long j37 = j36 ^ (j36 << 8);
        long j38 = j37 ^ (j37 << 16);
        long j39 = (j38 ^ (j38 << 32)) & 36028797018963967L;
        long j40 = (j24 >>> 1) ^ (j39 >>> 54);
        long j41 = j40 ^ (j40 << 1);
        long j42 = j41 ^ (j41 << 2);
        long j43 = j42 ^ (j42 << 4);
        long j44 = j43 ^ (j43 << 8);
        long j45 = j44 ^ (j44 << 16);
        long j46 = j45 ^ (j45 << 32);
        jArr3[0] = j19;
        jArr3[1] = (j20 ^ j32) ^ jArr4[2];
        jArr3[2] = ((j21 ^ j39) ^ j32) ^ jArr4[3];
        jArr3[3] = j46 ^ j39;
        jArr3[4] = jArr4[2] ^ j46;
        jArr3[5] = jArr4[3];
        m2096a(jArr3);
    }

    public static int cca_continue(long[] jArr) {
        return ((int) (jArr[0] ^ (jArr[2] >>> 29))) & 1;
    }

    public static void cca_continue(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = j4 ^ ((((j6 >>> 35) ^ (j6 >>> 32)) ^ (j6 >>> 29)) ^ (j6 >>> 28));
        long j8 = j2 ^ ((((j5 << 29) ^ (j5 << 32)) ^ (j5 << 35)) ^ (j5 << 36));
        long j9 = (j3 ^ ((((j6 << 29) ^ (j6 << 32)) ^ (j6 << 35)) ^ (j6 << 36))) ^ ((j5 >>> 28) ^ (((j5 >>> 35) ^ (j5 >>> 32)) ^ (j5 >>> 29)));
        long j10 = j ^ ((((j7 << 29) ^ (j7 << 32)) ^ (j7 << 35)) ^ (j7 << 36));
        long j11 = j8 ^ ((j7 >>> 28) ^ (((j7 >>> 35) ^ (j7 >>> 32)) ^ (j7 >>> 29)));
        long j12 = j9 >>> 35;
        jArr2[0] = (((j10 ^ j12) ^ (j12 << 3)) ^ (j12 << 6)) ^ (j12 << 7);
        jArr2[1] = j11;
        jArr2[2] = 34359738367L & j9;
    }

    public static void init(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    public static long[] getInstance(BigInteger bigInteger) {
        long[] cca_continue = setKeepScreenOn.cca_continue(bigInteger);
        long j = cca_continue[2];
        long j2 = j >>> 35;
        cca_continue[0] = ((j2 << 7) ^ (((j2 << 3) ^ j2) ^ (j2 << 6))) ^ cca_continue[0];
        cca_continue[2] = j & 34359738367L;
        return cca_continue;
    }

    public static void Cardinal(long[] jArr, long[] jArr2) {
        if (!setKeepScreenOn.init(jArr)) {
            long[] jArr3 = new long[3];
            long[] jArr4 = new long[3];
            long[] jArr5 = new long[6];
            m2097a(jArr, jArr5);
            cca_continue(jArr5, jArr3);
            cca_continue(jArr3, 1, jArr4);
            long[] jArr6 = new long[6];
            m2099b(jArr3, jArr4, jArr6);
            cca_continue(jArr6, jArr3);
            cca_continue(jArr4, 1, jArr4);
            long[] jArr7 = new long[6];
            m2099b(jArr3, jArr4, jArr7);
            cca_continue(jArr7, jArr3);
            cca_continue(jArr3, 3, jArr4);
            long[] jArr8 = new long[6];
            m2099b(jArr3, jArr4, jArr8);
            cca_continue(jArr8, jArr3);
            cca_continue(jArr4, 3, jArr4);
            long[] jArr9 = new long[6];
            m2099b(jArr3, jArr4, jArr9);
            cca_continue(jArr9, jArr3);
            cca_continue(jArr3, 9, jArr4);
            long[] jArr10 = new long[6];
            m2099b(jArr3, jArr4, jArr10);
            cca_continue(jArr10, jArr3);
            cca_continue(jArr4, 9, jArr4);
            long[] jArr11 = new long[6];
            m2099b(jArr3, jArr4, jArr11);
            cca_continue(jArr11, jArr3);
            cca_continue(jArr3, 27, jArr4);
            long[] jArr12 = new long[6];
            m2099b(jArr3, jArr4, jArr12);
            cca_continue(jArr12, jArr3);
            cca_continue(jArr4, 27, jArr4);
            long[] jArr13 = new long[6];
            m2099b(jArr3, jArr4, jArr13);
            cca_continue(jArr13, jArr3);
            cca_continue(jArr3, 81, jArr4);
            long[] jArr14 = new long[6];
            m2099b(jArr3, jArr4, jArr14);
            cca_continue(jArr14, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void init(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[6];
        m2099b(jArr, jArr2, jArr4);
        cca_continue(jArr4, jArr3);
    }

    public static void cca_continue(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[6];
        m2099b(jArr, jArr2, jArr4);
        m2098a(jArr3, jArr4, jArr3);
    }

    public static void getInstance(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[3];
        long configure = setLabelFor.configure(jArr[0]);
        long configure2 = setLabelFor.configure(jArr[1]);
        jArr3[0] = (configure >>> 32) | (configure2 & -4294967296L);
        long configure3 = setLabelFor.configure(jArr[2]);
        long j = configure3 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        jArr3[1] = configure3 >>> 32;
        long[] jArr4 = new long[6];
        m2099b(jArr3, f3005a, jArr4);
        cca_continue(jArr4, jArr2);
        jArr2[0] = jArr2[0] ^ ((configure & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (configure2 << 32));
        jArr2[1] = jArr2[1] ^ j;
    }

    public static void configure(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[6];
        m2097a(jArr, jArr3);
        cca_continue(jArr3, jArr2);
    }

    public static void values(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[6];
        m2097a(jArr, jArr3);
        m2098a(jArr2, jArr3, jArr2);
    }

    public static void cca_continue(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[6];
        m2097a(jArr, jArr3);
        while (true) {
            cca_continue(jArr3, jArr2);
            i--;
            if (i > 0) {
                m2097a(jArr2, jArr3);
            } else {
                return;
            }
        }
    }
}
