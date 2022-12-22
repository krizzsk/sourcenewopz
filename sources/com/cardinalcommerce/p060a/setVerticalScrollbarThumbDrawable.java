package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setVerticalScrollbarThumbDrawable */
public final class setVerticalScrollbarThumbDrawable {

    /* renamed from: a */
    private static final long[] f3093a = {3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    /* renamed from: a */
    private static void m2173a(long[] jArr, int i) {
        int i2 = i + 8;
        long j = jArr[i2];
        long j2 = j >>> 59;
        jArr[i] = ((j2 << 10) ^ (((j2 << 2) ^ j2) ^ (j2 << 5))) ^ jArr[i];
        jArr[i2] = j & 576460752303423487L;
    }

    /* renamed from: a */
    private static void m2174a(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3) {
        for (int i4 = 0; i4 < 9; i4++) {
            int i5 = i3 + i4;
            jArr3[i5] = jArr3[i5] ^ (jArr[i + i4] ^ jArr2[i2 + i4]);
        }
    }

    /* renamed from: a */
    private static void m2175a(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = jArr3;
        for (int i = 56; i >= 0; i -= 8) {
            for (int i2 = 1; i2 < 9; i2 += 2) {
                int i3 = (int) (jArr[i2] >>> i);
                m2174a(jArr2, (i3 & 15) * 9, jArr2, (((i3 >>> 4) & 15) + 16) * 9, jArr3, i2 - 1);
            }
            setDrawingCacheQuality.configure(16, jArr4, 0);
        }
        for (int i4 = 56; i4 >= 0; i4 -= 8) {
            for (int i5 = 0; i5 < 9; i5 += 2) {
                int i6 = (int) (jArr[i5] >>> i4);
                m2174a(jArr2, (i6 & 15) * 9, jArr2, (((i6 >>> 4) & 15) + 16) * 9, jArr3, i5);
            }
            if (i4 > 0) {
                setDrawingCacheQuality.configure(18, jArr4, 0);
            }
        }
    }

    public static void cca_continue(long[] jArr, long[] jArr2) {
        long j = jArr[9];
        long j2 = jArr[17];
        long j3 = (((j ^ (j2 >>> 59)) ^ (j2 >>> 57)) ^ (j2 >>> 54)) ^ (j2 >>> 49);
        long j4 = (j2 << 15) ^ (((jArr[8] ^ (j2 << 5)) ^ (j2 << 7)) ^ (j2 << 10));
        for (int i = 16; i >= 10; i--) {
            long j5 = jArr[i];
            jArr2[i - 8] = (((j4 ^ (j5 >>> 59)) ^ (j5 >>> 57)) ^ (j5 >>> 54)) ^ (j5 >>> 49);
            j4 = (((jArr[i - 9] ^ (j5 << 5)) ^ (j5 << 7)) ^ (j5 << 10)) ^ (j5 << 15);
        }
        jArr2[1] = (((j4 ^ (j3 >>> 59)) ^ (j3 >>> 57)) ^ (j3 >>> 54)) ^ (j3 >>> 49);
        long j6 = (j3 << 15) ^ (((jArr[0] ^ (j3 << 5)) ^ (j3 << 7)) ^ (j3 << 10));
        long j7 = jArr2[8];
        long j8 = j7 >>> 59;
        jArr2[0] = (((j6 ^ j8) ^ (j8 << 2)) ^ (j8 << 5)) ^ (j8 << 10);
        jArr2[8] = 576460752303423487L & j7;
    }

    public static void cca_continue(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 9; i++) {
            jArr3[i] = jArr[i] ^ jArr2[i];
        }
    }

    public static void configure(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        for (int i = 1; i < 9; i++) {
            jArr2[i] = jArr[i];
        }
    }

    public static int init(long[] jArr) {
        return ((int) ((jArr[0] ^ (jArr[8] >>> 49)) ^ (jArr[8] >>> 57))) & 1;
    }

    public static void init(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 9; i++) {
            jArr3[i] = jArr3[i] ^ (jArr[i] ^ jArr2[i]);
        }
    }

    public static long[] getInstance(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 576) {
            throw new IllegalArgumentException();
        }
        long[] jArr = new long[9];
        int i = 0;
        while (bigInteger.signum() != 0) {
            jArr[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i++;
        }
        m2173a(jArr, 0);
        return jArr;
    }

    public static void Cardinal(long[] jArr, long[] jArr2) {
        if (!setNextFocusForwardId.init(jArr)) {
            long[] jArr3 = new long[9];
            long[] jArr4 = new long[9];
            long[] jArr5 = new long[9];
            getInstance(jArr, jArr5);
            getInstance(jArr5, jArr3);
            getInstance(jArr3, jArr4);
            configure(jArr3, jArr4, jArr3);
            init(jArr3, 2, jArr4);
            configure(jArr3, jArr4, jArr3);
            configure(jArr3, jArr5, jArr3);
            init(jArr3, 5, jArr4);
            configure(jArr3, jArr4, jArr3);
            init(jArr4, 5, jArr4);
            configure(jArr3, jArr4, jArr3);
            init(jArr3, 15, jArr4);
            configure(jArr3, jArr4, jArr5);
            init(jArr5, 30, jArr3);
            init(jArr3, 30, jArr4);
            configure(jArr3, jArr4, jArr3);
            init(jArr3, 60, jArr4);
            configure(jArr3, jArr4, jArr3);
            init(jArr4, 60, jArr4);
            configure(jArr3, jArr4, jArr3);
            init(jArr3, 180, jArr4);
            configure(jArr3, jArr4, jArr3);
            init(jArr4, 180, jArr4);
            configure(jArr3, jArr4, jArr3);
            configure(jArr3, jArr5, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void configure(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[18];
        m2175a(jArr, getInstance(jArr2), jArr4);
        cca_continue(jArr4, jArr3);
    }

    public static void getInstance(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[18];
        m2175a(jArr, getInstance(jArr2), jArr4);
        for (int i = 0; i < 18; i++) {
            jArr3[i] = jArr3[i] ^ jArr4[i];
        }
    }

    public static void Cardinal(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[18];
        m2175a(jArr, jArr2, jArr4);
        cca_continue(jArr4, jArr3);
    }

    public static void values(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[18];
        m2175a(jArr, jArr2, jArr4);
        for (int i = 0; i < 18; i++) {
            jArr3[i] = jArr3[i] ^ jArr4[i];
        }
    }

    public static long[] getInstance(long[] jArr) {
        long j;
        long[] jArr2 = new long[288];
        int i = 0;
        System.arraycopy(jArr, 0, jArr2, 9, 9);
        int i2 = 7;
        int i3 = 0;
        while (true) {
            j = 0;
            if (i2 <= 0) {
                break;
            }
            i3 += 18;
            int i4 = i3 >>> 1;
            int i5 = 0;
            while (i5 < 9) {
                long j2 = jArr2[i4 + i5];
                jArr2[i3 + i5] = (j >>> 63) | (j2 << 1);
                i5++;
                j = j2;
            }
            m2173a(jArr2, i3);
            int i6 = i3 + 9;
            for (int i7 = 0; i7 < 9; i7++) {
                jArr2[i6 + i7] = jArr2[i7 + 9] ^ jArr2[i3 + i7];
            }
            i2--;
        }
        while (i < 144) {
            long j3 = jArr2[i];
            jArr2[i + 144] = (j >>> -4) | (j3 << 4);
            i++;
            j = j3;
        }
        return jArr2;
    }

    public static void init(long[] jArr, long[] jArr2) {
        long[] jArr3 = jArr2;
        long[] jArr4 = new long[9];
        long[] jArr5 = new long[9];
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + 1;
            long configure = setLabelFor.configure(jArr[i]);
            i = i3 + 1;
            long configure2 = setLabelFor.configure(jArr[i3]);
            jArr4[i2] = (InternalZipConstants.ZIP_64_SIZE_LIMIT & configure) | (configure2 << 32);
            jArr5[i2] = (configure >>> 32) | (-4294967296L & configure2);
        }
        long configure3 = setLabelFor.configure(jArr[8]);
        jArr4[4] = InternalZipConstants.ZIP_64_SIZE_LIMIT & configure3;
        jArr5[4] = configure3 >>> 32;
        long[] jArr6 = new long[18];
        m2175a(jArr5, getInstance(f3093a), jArr6);
        cca_continue(jArr6, jArr3);
        for (int i4 = 0; i4 < 9; i4++) {
            jArr3[i4] = jArr3[i4] ^ jArr4[i4];
        }
    }

    public static void getInstance(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[18];
        for (int i = 0; i < 9; i++) {
            setLabelFor.cca_continue(jArr[i], jArr3, i << 1);
        }
        cca_continue(jArr3, jArr2);
    }

    public static void getSDKVersion(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[18];
        for (int i = 0; i < 9; i++) {
            setLabelFor.cca_continue(jArr[i], jArr3, i << 1);
        }
        for (int i2 = 0; i2 < 18; i2++) {
            jArr2[i2] = jArr2[i2] ^ jArr3[i2];
        }
    }

    public static void init(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[18];
        for (int i2 = 0; i2 < 9; i2++) {
            setLabelFor.cca_continue(jArr[i2], jArr3, i2 << 1);
        }
        cca_continue(jArr3, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                for (int i3 = 0; i3 < 9; i3++) {
                    setLabelFor.cca_continue(jArr2[i3], jArr3, i3 << 1);
                }
                cca_continue(jArr3, jArr2);
            } else {
                return;
            }
        }
    }
}
