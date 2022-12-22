package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.ToolbarCustomization */
public final class ToolbarCustomization {

    /* renamed from: a */
    KeyAgreementSpi.ECKAEGwithRIPEMD160KDF f2485a;

    /* renamed from: b */
    KeyFactorySpi.ECGOST3410_2012 f2486b;

    public ToolbarCustomization() {
    }

    /* renamed from: a */
    private static void m1826a(long j, long j2, long[] jArr, int i) {
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
        jArr[i] = jArr[i] ^ (576460752303423487L & j4);
        int i5 = i + 1;
        jArr[i5] = jArr[i5] ^ ((j4 >>> 59) ^ (j5 << 5));
    }

    /* renamed from: a */
    private static void m1827a(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        jArr[0] = j ^ (j2 << 59);
        jArr[1] = (j2 >>> 5) ^ (j3 << 54);
        jArr[2] = (j3 >>> 10) ^ (j4 << 49);
        jArr[3] = (j4 >>> 15) ^ (j5 << 44);
        jArr[4] = (j5 >>> 20) ^ (j6 << 39);
        jArr[5] = (j6 >>> 25) ^ (j7 << 34);
        jArr[6] = (j7 >>> 30) ^ (j8 << 29);
        jArr[7] = j8 >>> 35;
    }

    /* renamed from: a */
    static void m1828a(long[] jArr, long[] jArr2) {
        setLabelFor.cca_continue(jArr[0], jArr2, 0);
        setLabelFor.cca_continue(jArr[1], jArr2, 2);
        setLabelFor.cca_continue(jArr[2], jArr2, 4);
        long j = jArr[3];
        jArr2[6] = setLabelFor.Cardinal((int) j);
        jArr2[7] = ((long) setLabelFor.getInstance((int) (j >>> 32))) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
    }

    /* renamed from: a */
    static void m1829a(long[] jArr, long[] jArr2, long[] jArr3) {
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
    private static void m1830b(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 576460752303423487L;
        jArr2[1] = ((j >>> 59) ^ (j2 << 5)) & 576460752303423487L;
        jArr2[2] = ((j2 >>> 54) ^ (j3 << 10)) & 576460752303423487L;
        jArr2[3] = (j3 >>> 49) ^ (j4 << 15);
    }

    /* renamed from: b */
    static void m1831b(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        m1830b(jArr, jArr4);
        m1830b(jArr2, jArr5);
        long[] jArr6 = jArr3;
        m1826a(jArr4[0], jArr5[0], jArr6, 0);
        m1826a(jArr4[1], jArr5[1], jArr6, 1);
        m1826a(jArr4[2], jArr5[2], jArr6, 2);
        m1826a(jArr4[3], jArr5[3], jArr6, 3);
        for (int i = 5; i > 0; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 1];
        }
        m1826a(jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        m1826a(jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i2 = 7; i2 > 1; i2--) {
            jArr3[i2] = jArr3[i2] ^ jArr3[i2 - 2];
        }
        long j = jArr4[0] ^ jArr4[2];
        long j2 = jArr4[1] ^ jArr4[3];
        long j3 = jArr5[0] ^ jArr5[2];
        long j4 = jArr5[1] ^ jArr5[3];
        m1826a(j ^ j2, j3 ^ j4, jArr3, 3);
        long[] jArr7 = new long[3];
        m1826a(j, j3, jArr7, 0);
        m1826a(j2, j4, jArr7, 1);
        long j5 = jArr7[0];
        long j6 = jArr7[1];
        long j7 = jArr7[2];
        jArr3[2] = jArr3[2] ^ j5;
        jArr3[3] = (j5 ^ j6) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j7 ^ j6);
        jArr3[5] = jArr3[5] ^ j7;
        m1827a(jArr3);
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
        long j9 = j6 ^ (j8 >>> 31);
        long j10 = (j5 ^ ((j8 >>> 41) ^ (j8 << 33))) ^ (j7 >>> 31);
        long j11 = ((j4 ^ (j8 << 23)) ^ ((j7 >>> 41) ^ (j7 << 33))) ^ (j9 >>> 31);
        long j12 = j ^ (j10 << 23);
        long j13 = ((j3 ^ (j7 << 23)) ^ ((j9 >>> 41) ^ (j9 << 33))) ^ (j10 >>> 31);
        long j14 = j11 >>> 41;
        jArr2[0] = j12 ^ j14;
        long j15 = j14 << 10;
        jArr2[1] = j15 ^ ((j2 ^ (j9 << 23)) ^ ((j10 >>> 41) ^ (j10 << 33)));
        jArr2[2] = j13;
        jArr2[3] = 2199023255551L & j11;
    }

    public static long[] configure(BigInteger bigInteger) {
        long[] cca_continue = setNextFocusLeftId.cca_continue(bigInteger);
        long j = cca_continue[3];
        long j2 = j >>> 41;
        cca_continue[0] = cca_continue[0] ^ j2;
        cca_continue[1] = (j2 << 10) ^ cca_continue[1];
        cca_continue[3] = j & 2199023255551L;
        return cca_continue;
    }

    public static void init(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        m1831b(jArr, jArr2, jArr4);
        init(jArr4, jArr3);
    }

    public static void getInstance(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[8];
        m1828a(jArr, jArr3);
        while (true) {
            init(jArr3, jArr2);
            i--;
            if (i > 0) {
                m1828a(jArr2, jArr3);
            } else {
                return;
            }
        }
    }

    public ToolbarCustomization(KeyAgreementSpi.ECKAEGwithRIPEMD160KDF eCKAEGwithRIPEMD160KDF, KeyFactorySpi.ECGOST3410_2012 ecgost3410_2012) {
        this.f2485a = eCKAEGwithRIPEMD160KDF;
        this.f2486b = ecgost3410_2012;
    }
}
