package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.getCornerRadius */
public final class getCornerRadius {

    /* renamed from: a */
    private static final long[] f2552a = {2791191049453778211L, 2791191049453778402L, 6};

    /* renamed from: a */
    private static void m1890a(long j, long j2, long[] jArr, int i) {
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
        long j4 = (jArr2[(i2 >>> 6) & 7] << 6) ^ (jArr2[i2 & 7] ^ (jArr2[(i2 >>> 3) & 7] << 3));
        long j5 = 0;
        int i3 = 33;
        do {
            int i4 = (int) (j3 >>> i3);
            long j6 = (jArr2[(i4 >>> 9) & 7] << 9) ^ ((jArr2[i4 & 7] ^ (jArr2[(i4 >>> 3) & 7] << 3)) ^ (jArr2[(i4 >>> 6) & 7] << 6));
            j4 ^= j6 << i3;
            j5 ^= j6 >>> (-i3);
            i3 -= 12;
        } while (i3 > 0);
        jArr[i] = 17592186044415L & j4;
        jArr[i + 1] = (j4 >>> 44) ^ (j5 << 20);
    }

    /* renamed from: a */
    private static void m1891a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        jArr[0] = j ^ (j2 << 44);
        jArr[1] = (j2 >>> 20) ^ (j3 << 24);
        jArr[2] = ((j3 >>> 40) ^ (j4 << 4)) ^ (j5 << 48);
        jArr[3] = ((j4 >>> 60) ^ (j6 << 28)) ^ (j5 >>> 16);
        jArr[4] = j6 >>> 36;
        jArr[5] = 0;
    }

    /* renamed from: a */
    private static void m1892a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    /* renamed from: b */
    private static void m1893b(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = ((jArr[2] << 40) ^ (j2 >>> 24)) & 17592186044415L;
        long j4 = ((j2 << 20) ^ (j >>> 44)) & 17592186044415L;
        long j5 = j & 17592186044415L;
        long j6 = jArr2[0];
        long j7 = jArr2[1];
        long j8 = ((j7 >>> 24) ^ (jArr2[2] << 40)) & 17592186044415L;
        long j9 = ((j6 >>> 44) ^ (j7 << 20)) & 17592186044415L;
        long j10 = j6 & 17592186044415L;
        long[] jArr4 = new long[10];
        m1890a(j5, j10, jArr4, 0);
        m1890a(j3, j8, jArr4, 2);
        long j11 = (j5 ^ j4) ^ j3;
        long j12 = (j10 ^ j9) ^ j8;
        long[] jArr5 = jArr4;
        m1890a(j11, j12, jArr5, 4);
        long j13 = (j4 << 1) ^ (j3 << 2);
        long j14 = (j9 << 1) ^ (j8 << 2);
        m1890a(j5 ^ j13, j10 ^ j14, jArr5, 6);
        m1890a(j11 ^ j13, j12 ^ j14, jArr5, 8);
        long j15 = jArr4[6] ^ jArr4[8];
        long j16 = jArr4[7] ^ jArr4[9];
        long j17 = (j15 << 1) ^ jArr4[6];
        long j18 = (j15 ^ (j16 << 1)) ^ jArr4[7];
        long j19 = jArr4[0];
        long j20 = (jArr4[1] ^ jArr4[0]) ^ jArr4[4];
        long j21 = jArr4[1] ^ jArr4[5];
        long j22 = ((j17 ^ j19) ^ (jArr4[2] << 4)) ^ (jArr4[2] << 1);
        long j23 = (((j20 ^ j18) ^ (jArr4[3] << 4)) ^ (jArr4[3] << 1)) ^ (j22 >>> 44);
        long j24 = (j21 ^ j16) ^ (j23 >>> 44);
        long j25 = j23 & 17592186044415L;
        long j26 = ((j22 & 17592186044415L) >>> 1) ^ ((j25 & 1) << 43);
        long j27 = j26 ^ (j26 << 1);
        long j28 = j27 ^ (j27 << 2);
        long j29 = j28 ^ (j28 << 4);
        long j30 = j29 ^ (j29 << 8);
        long j31 = j30 ^ (j30 << 16);
        long j32 = (j31 ^ (j31 << 32)) & 17592186044415L;
        long j33 = ((j25 >>> 1) ^ ((j24 & 1) << 43)) ^ (j32 >>> 43);
        long j34 = j33 ^ (j33 << 1);
        long j35 = j34 ^ (j34 << 2);
        long j36 = j35 ^ (j35 << 4);
        long j37 = j36 ^ (j36 << 8);
        long j38 = j37 ^ (j37 << 16);
        long j39 = (j38 ^ (j38 << 32)) & 17592186044415L;
        long j40 = (j39 >>> 43) ^ (j24 >>> 1);
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
        m1891a(jArr3);
    }

    public static void configure(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    public static void configure(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr2[2] ^ jArr[2];
    }

    public static int init(long[] jArr) {
        return ((int) ((jArr[0] ^ (jArr[1] >>> 59)) ^ (jArr[2] >>> 1))) & 1;
    }

    public static void init(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = j4 ^ (j5 >>> 59);
        long j7 = j ^ ((j6 << 61) ^ (j6 << 63));
        long j8 = (j2 ^ ((j5 << 61) ^ (j5 << 63))) ^ ((((j6 >>> 3) ^ (j6 >>> 1)) ^ j6) ^ (j6 << 5));
        long j9 = (j3 ^ ((((j5 >>> 3) ^ (j5 >>> 1)) ^ j5) ^ (j5 << 5))) ^ (j6 >>> 59);
        long j10 = j9 >>> 3;
        jArr2[0] = (((j7 ^ j10) ^ (j10 << 2)) ^ (j10 << 3)) ^ (j10 << 8);
        jArr2[1] = (j10 >>> 56) ^ j8;
        jArr2[2] = 7 & j9;
    }

    public static long[] Cardinal(BigInteger bigInteger) {
        long[] cca_continue = setKeepScreenOn.cca_continue(bigInteger);
        long j = cca_continue[2];
        long j2 = j >>> 3;
        cca_continue[0] = cca_continue[0] ^ ((((j2 << 2) ^ j2) ^ (j2 << 3)) ^ (j2 << 8));
        cca_continue[1] = (j2 >>> 56) ^ cca_continue[1];
        cca_continue[2] = j & 7;
        return cca_continue;
    }

    public static void Cardinal(long[] jArr, long[] jArr2) {
        if (!setKeepScreenOn.init(jArr)) {
            long[] jArr3 = new long[3];
            long[] jArr4 = new long[3];
            long[] jArr5 = new long[5];
            setLabelFor.cca_continue(jArr[0], jArr5, 0);
            setLabelFor.cca_continue(jArr[1], jArr5, 2);
            jArr5[4] = ((long) setLabelFor.configure((int) jArr[2])) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            init(jArr5, jArr3);
            long[] jArr6 = new long[6];
            m1893b(jArr3, jArr, jArr6);
            init(jArr6, jArr3);
            getInstance(jArr3, 2, jArr4);
            long[] jArr7 = new long[6];
            m1893b(jArr4, jArr3, jArr7);
            init(jArr7, jArr4);
            getInstance(jArr4, 4, jArr3);
            long[] jArr8 = new long[6];
            m1893b(jArr3, jArr4, jArr8);
            init(jArr8, jArr3);
            getInstance(jArr3, 8, jArr4);
            long[] jArr9 = new long[6];
            m1893b(jArr4, jArr3, jArr9);
            init(jArr9, jArr4);
            getInstance(jArr4, 16, jArr3);
            long[] jArr10 = new long[6];
            m1893b(jArr3, jArr4, jArr10);
            init(jArr10, jArr3);
            getInstance(jArr3, 32, jArr4);
            long[] jArr11 = new long[6];
            m1893b(jArr4, jArr3, jArr11);
            init(jArr11, jArr4);
            long[] jArr12 = new long[5];
            setLabelFor.cca_continue(jArr4[0], jArr12, 0);
            setLabelFor.cca_continue(jArr4[1], jArr12, 2);
            jArr12[4] = ((long) setLabelFor.configure((int) jArr4[2])) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            init(jArr12, jArr4);
            long[] jArr13 = new long[6];
            m1893b(jArr4, jArr, jArr13);
            init(jArr13, jArr4);
            getInstance(jArr4, 65, jArr3);
            long[] jArr14 = new long[6];
            m1893b(jArr3, jArr4, jArr14);
            init(jArr14, jArr3);
            long[] jArr15 = new long[5];
            setLabelFor.cca_continue(jArr3[0], jArr15, 0);
            setLabelFor.cca_continue(jArr3[1], jArr15, 2);
            jArr15[4] = ((long) setLabelFor.configure((int) jArr3[2])) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            init(jArr15, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void Cardinal(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[6];
        m1893b(jArr, jArr2, jArr4);
        init(jArr4, jArr3);
    }

    public static void cca_continue(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[6];
        m1893b(jArr, jArr2, jArr4);
        m1892a(jArr3, jArr4, jArr3);
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
        m1893b(jArr3, f2552a, jArr4);
        init(jArr4, jArr2);
        jArr2[0] = jArr2[0] ^ ((configure & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (configure2 << 32));
        jArr2[1] = jArr2[1] ^ j;
    }

    public static void cca_continue(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[5];
        setLabelFor.cca_continue(jArr[0], jArr3, 0);
        setLabelFor.cca_continue(jArr[1], jArr3, 2);
        jArr3[4] = ((long) setLabelFor.configure((int) jArr[2])) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        init(jArr3, jArr2);
    }

    public static void getWarnings(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[5];
        setLabelFor.cca_continue(jArr[0], jArr3, 0);
        setLabelFor.cca_continue(jArr[1], jArr3, 2);
        jArr3[4] = ((long) setLabelFor.configure((int) jArr[2])) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        m1892a(jArr2, jArr3, jArr2);
    }

    public static void getInstance(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[5];
        setLabelFor.cca_continue(jArr[0], jArr3, 0);
        setLabelFor.cca_continue(jArr[1], jArr3, 2);
        jArr3[4] = ((long) setLabelFor.configure((int) jArr[2])) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        init(jArr3, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                setLabelFor.cca_continue(jArr2[0], jArr3, 0);
                setLabelFor.cca_continue(jArr2[1], jArr3, 2);
                jArr3[4] = ((long) setLabelFor.configure((int) jArr2[2])) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                init(jArr3, jArr2);
            } else {
                return;
            }
        }
    }
}
