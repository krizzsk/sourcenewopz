package com.cardinalcommerce.p060a;

import com.google.common.base.Ascii;

/* renamed from: com.cardinalcommerce.a.setOnCreateContextMenuListener */
public abstract class setOnCreateContextMenuListener {

    /* renamed from: a */
    private static final int[] f2892a = {34513072, 59165138, 4688974, 3500415, 6194736, 33281959, 54535759, 32551604, 163342, 5703241};

    public static void Cardinal(int i, int[] iArr) {
        int i2 = 0 - i;
        for (int i3 = 0; i3 < 10; i3++) {
            iArr[i3] = (iArr[i3] ^ i2) - i2;
        }
    }

    public static void Cardinal(byte[] bArr, int i, int[] iArr) {
        m2041a(bArr, 0, iArr, 0);
        m2041a(bArr, 16, iArr, 5);
        iArr[9] = iArr[9] & 16777215;
    }

    public static void Cardinal(int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = i4 + (i3 >> 25);
        int i12 = i6 + (i5 >> 25);
        int i13 = i9 + (i8 >> 25);
        int i14 = i + ((i10 >> 25) * 38);
        int i15 = i2 + (i14 >> 26);
        int i16 = i7 + (i12 >> 26);
        iArr[0] = i14 & 67108863;
        iArr[1] = i15 & 67108863;
        iArr[2] = (i3 & 33554431) + (i15 >> 26);
        iArr[3] = i11 & 67108863;
        iArr[4] = (i5 & 33554431) + (i11 >> 26);
        iArr[5] = i12 & 67108863;
        iArr[6] = i16 & 67108863;
        iArr[7] = (i8 & 33554431) + (i16 >> 26);
        iArr[8] = i13 & 67108863;
        iArr[9] = (i10 & 33554431) + (i13 >> 26);
    }

    public static void Cardinal(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        long j = ((long) i3) * 121666;
        long j2 = ((long) i5) * 121666;
        long j3 = ((long) i8) * 121666;
        long j4 = ((long) iArr[9]) * 121666;
        long j5 = ((j4 >> 25) * 38) + (((long) i) * 121666);
        iArr2[0] = ((int) j5) & 67108863;
        long j6 = j3 >> 25;
        long j7 = (j2 >> 25) + (((long) i6) * 121666);
        iArr2[5] = ((int) j7) & 67108863;
        long j8 = j7 >> 26;
        long j9 = (j5 >> 26) + (((long) i2) * 121666);
        iArr2[1] = ((int) j9) & 67108863;
        long j10 = j9 >> 26;
        long j11 = (j >> 25) + (((long) i4) * 121666);
        iArr2[3] = ((int) j11) & 67108863;
        long j12 = j8 + (((long) i7) * 121666);
        iArr2[6] = ((int) j12) & 67108863;
        long j13 = j6 + (((long) i9) * 121666);
        iArr2[8] = 67108863 & ((int) j13);
        iArr2[2] = (((int) j) & 33554431) + ((int) j10);
        iArr2[4] = (((int) j2) & 33554431) + ((int) (j11 >> 26));
        iArr2[7] = (((int) j3) & 33554431) + ((int) (j12 >> 26));
        iArr2[9] = (((int) j4) & 33554431) + ((int) (j13 >> 26));
    }

    public static void CardinalError(int[] iArr) {
        iArr[0] = iArr[0] - 1;
    }

    /* renamed from: a */
    private static int m2039a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
    }

    /* renamed from: a */
    private static void m2040a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    /* renamed from: a */
    private static void m2041a(byte[] bArr, int i, int[] iArr, int i2) {
        int a = m2039a(bArr, i);
        int a2 = m2039a(bArr, i + 4);
        int a3 = m2039a(bArr, i + 8);
        int a4 = m2039a(bArr, i + 12);
        iArr[i2] = a & 67108863;
        iArr[i2 + 1] = ((a >>> 26) | (a2 << 6)) & 67108863;
        iArr[i2 + 2] = ((a2 >>> 20) | (a3 << 12)) & 33554431;
        iArr[i2 + 3] = 67108863 & ((a4 << 19) | (a3 >>> 13));
        iArr[i2 + 4] = a4 >>> 7;
    }

    /* renamed from: a */
    private static void m2042a(int[] iArr, int i) {
        int i2 = iArr[9];
        int i3 = 16777215 & i2;
        int i4 = (((i2 >> 24) + i) * 19) + iArr[0];
        iArr[0] = i4 & 67108863;
        int i5 = (i4 >> 26) + iArr[1];
        iArr[1] = i5 & 67108863;
        int i6 = (i5 >> 26) + iArr[2];
        iArr[2] = i6 & 33554431;
        int i7 = (i6 >> 25) + iArr[3];
        iArr[3] = i7 & 67108863;
        int i8 = (i7 >> 26) + iArr[4];
        iArr[4] = i8 & 33554431;
        int i9 = (i8 >> 25) + iArr[5];
        iArr[5] = i9 & 67108863;
        int i10 = (i9 >> 26) + iArr[6];
        iArr[6] = i10 & 67108863;
        int i11 = (i10 >> 26) + iArr[7];
        iArr[7] = 33554431 & i11;
        int i12 = (i11 >> 25) + iArr[8];
        iArr[8] = 67108863 & i12;
        iArr[9] = (i12 >> 26) + i3;
    }

    /* renamed from: a */
    private static void m2043a(int[] iArr, int i, byte[] bArr, int i2) {
        int i3 = iArr[i];
        int i4 = iArr[i + 1];
        int i5 = iArr[i + 2];
        int i6 = iArr[i + 3];
        int i7 = iArr[i + 4];
        m2040a((i4 << 26) | i3, bArr, i2);
        m2040a((i4 >>> 6) | (i5 << 20), bArr, i2 + 4);
        m2040a((i5 >>> 12) | (i6 << 13), bArr, i2 + 8);
        m2040a((i7 << 7) | (i6 >>> 19), bArr, i2 + 12);
    }

    public static void cca_continue(int i, int[] iArr, int[] iArr2) {
        int i2 = 0 - i;
        for (int i3 = 0; i3 < 10; i3++) {
            int i4 = iArr[i3];
            int i5 = iArr2[i3];
            int i6 = (i4 ^ i5) & i2;
            iArr[i3] = i4 ^ i6;
            iArr2[i3] = i5 ^ i6;
        }
    }

    public static void cca_continue(int[] iArr) {
        iArr[0] = 1;
        for (int i = 1; i < 10; i++) {
            iArr[i] = 0;
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        long j = (long) i;
        long j2 = j * j;
        long j3 = (long) (i2 << 1);
        long j4 = j * j3;
        long j5 = (long) (i3 << 1);
        int i9 = iArr[8];
        int i10 = i2;
        int i11 = i8;
        long j6 = (long) i10;
        long j7 = (j * j5) + (j6 * j6);
        int i12 = iArr[9];
        int i13 = i7;
        long j8 = (long) (i4 << 1);
        long j9 = (j3 * j5) + (j * j8);
        int i14 = i10;
        int i15 = i5;
        long j10 = (long) (i5 << 1);
        long j11 = (((long) i3) * j5) + (j * j10) + (j6 * j8);
        long j12 = (j3 * j10) + (j8 * j5);
        long j13 = (long) i4;
        long j14 = (j5 * j10) + (j13 * j13);
        long j15 = j13 * j10;
        long j16 = ((long) i15) * j10;
        long j17 = j11;
        int i16 = i6;
        int i17 = i15;
        long j18 = (long) i16;
        long j19 = j18 * j18;
        int i18 = i16;
        long j20 = (long) (i13 << 1);
        long j21 = j18 * j20;
        long j22 = (long) (i11 << 1);
        long j23 = j15;
        long j24 = j16;
        long j25 = (long) i13;
        long j26 = (j18 * j22) + (j25 * j25);
        long j27 = (long) (i9 << 1);
        long j28 = (j20 * j22) + (j18 * j27);
        long j29 = j14;
        int i19 = i11;
        long j30 = j12;
        long j31 = (long) (i12 << 1);
        long j32 = (((long) i19) * j22) + (j18 * j31) + (j25 * j27);
        long j33 = (j20 * j31) + (j27 * j22);
        int i20 = i9;
        long j34 = (long) i20;
        int i21 = i12;
        long j35 = j2 - (j33 * 38);
        long j36 = j4 - (((j22 * j31) + (j34 * j34)) * 38);
        long j37 = j7 - ((j34 * j31) * 38);
        long j38 = j9 - ((((long) i21) * j31) * 38);
        long j39 = j24 - j28;
        int i22 = i + i18;
        int i23 = i14 + i13;
        int i24 = i3 + i19;
        int i25 = i4 + i20;
        int i26 = i17 + i21;
        long j40 = j23 - j26;
        long j41 = j29 - j21;
        long j42 = j30 - j19;
        long j43 = (long) i22;
        long j44 = j43 * j43;
        long j45 = j32;
        long j46 = (long) (i23 << 1);
        long j47 = j43 * j46;
        long j48 = (long) (i24 << 1);
        long j49 = j39;
        long j50 = (long) i23;
        long j51 = (j43 * j48) + (j50 * j50);
        int i27 = i25;
        long j52 = (long) (i25 << 1);
        long j53 = (j46 * j48) + (j43 * j52);
        long j54 = (long) (i26 << 1);
        long j55 = (j46 * j54) + (j52 * j48);
        long j56 = (long) i27;
        long j57 = (j48 * j54) + (j56 * j56);
        long j58 = j56 * j54;
        long j59 = ((long) i26) * j54;
        long j60 = j49 + (j53 - j38);
        long j61 = (j60 >> 26) + (((((((long) i24) * j48) + (j43 * j54)) + (j50 * j52)) - j17) - j45);
        long j62 = j35 + ((((j61 >> 25) + j55) - j42) * 38);
        iArr2[0] = ((int) j62) & 67108863;
        long j63 = (j62 >> 26) + j36 + ((j57 - j41) * 38);
        iArr2[1] = ((int) j63) & 67108863;
        long j64 = (j63 >> 26) + j37 + ((j58 - j40) * 38);
        iArr2[2] = ((int) j64) & 33554431;
        long j65 = (j64 >> 25) + j38 + ((j59 - j49) * 38);
        iArr2[3] = ((int) j65) & 67108863;
        long j66 = (j65 >> 26) + j17 + (38 * j45);
        iArr2[4] = ((int) j66) & 33554431;
        long j67 = (j66 >> 25) + j42 + (j44 - j35);
        iArr2[5] = ((int) j67) & 67108863;
        long j68 = (j67 >> 26) + j41 + (j47 - j36);
        iArr2[6] = ((int) j68) & 67108863;
        long j69 = (j68 >> 26) + j40 + (j51 - j37);
        iArr2[7] = ((int) j69) & 33554431;
        long j70 = (j69 >> 25) + ((long) (((int) j60) & 67108863));
        iArr2[8] = ((int) j70) & 67108863;
        iArr2[9] = (((int) j61) & 33554431) + ((int) (j70 >> 26));
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i = 0; i < 10; i++) {
            iArr3[i] = iArr[i] - iArr2[i];
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        for (int i = 0; i < 10; i++) {
            int i2 = iArr[i];
            int i3 = iArr2[i];
            iArr3[i] = i2 + i3;
            iArr4[i] = i2 - i3;
        }
    }

    public static void cleanup(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            iArr[i] = 0;
        }
    }

    public static void configure(int[] iArr, byte[] bArr, int i) {
        m2043a(iArr, 0, bArr, i);
        m2043a(iArr, 5, bArr, i + 16);
    }

    public static void configure(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i = 0; i < 10; i++) {
            iArr3[i] = iArr[i] + iArr2[i];
        }
    }

    public static boolean configure(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            i |= iArr[i2];
        }
        return i == 0;
    }

    public static void getInstance(int[] iArr) {
        int i = (iArr[9] >>> 23) & 1;
        m2042a(iArr, i);
        m2042a(iArr, -i);
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        for (int i = 0; i < 10; i++) {
            iArr2[i] = -iArr[i];
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            iArr2[i + i2] = iArr[i2];
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = iArr[0];
        int i2 = iArr2[0];
        int i3 = iArr[1];
        int i4 = iArr2[1];
        int i5 = iArr[2];
        int i6 = iArr2[2];
        int i7 = iArr[3];
        int i8 = iArr2[3];
        int i9 = iArr[4];
        int i10 = iArr2[4];
        int i11 = iArr[5];
        int i12 = iArr2[5];
        int i13 = iArr[6];
        int i14 = iArr2[6];
        int i15 = iArr[7];
        int i16 = iArr2[7];
        int i17 = i15;
        int i18 = iArr[8];
        int i19 = iArr2[8];
        int i20 = iArr[9];
        int i21 = i11;
        long j = (long) i;
        int i22 = iArr2[9];
        long j2 = (long) i2;
        long j3 = j * j2;
        int i23 = i2;
        int i24 = i16;
        long j4 = (long) i4;
        int i25 = i4;
        long j5 = (long) i3;
        long j6 = (j * j4) + (j5 * j2);
        int i26 = i10;
        int i27 = i13;
        long j7 = (long) i6;
        int i28 = i6;
        long j8 = (long) i5;
        long j9 = (j * j7) + (j5 * j4) + (j8 * j2);
        long j10 = j4;
        long j11 = (long) i8;
        long j12 = j * j11;
        long j13 = j11;
        long j14 = (long) i7;
        long j15 = (((j5 * j7) + (j8 * j4)) << 1) + j12 + (j14 * j2);
        int i29 = i8;
        long j16 = j7;
        long j17 = (long) i26;
        long j18 = (j * j17) + (j5 * j13) + (j14 * j10);
        long j19 = j14;
        int i30 = i9;
        long j20 = (long) i30;
        long j21 = ((j8 * j7) << 1) + j18 + (j2 * j20);
        long j22 = (((j8 * j17) + (j20 * j16)) << 1) + (j19 * j13);
        long j23 = (j19 * j17) + (j20 * j13);
        int i31 = i21;
        long j24 = (long) i31;
        int i32 = i7;
        int i33 = i12;
        long j25 = (long) i33;
        long j26 = j24 * j25;
        int i34 = i33;
        int i35 = i5;
        int i36 = i14;
        int i37 = i3;
        long j27 = (long) i36;
        int i38 = i36;
        int i39 = i31;
        long j28 = (long) i27;
        long j29 = (j24 * j27) + (j28 * j25);
        long j30 = j23;
        long j31 = (long) i24;
        long j32 = j22;
        long j33 = (long) i17;
        long j34 = (j24 * j31) + (j28 * j27) + (j33 * j25);
        long j35 = ((((j5 * j17) + (j8 * j13)) + (j19 * j16)) + (j20 * j10)) << 1;
        long j36 = (long) i19;
        long j37 = j27;
        int i40 = i39;
        long j38 = (long) i18;
        long j39 = (((j28 * j31) + (j33 * j27)) << 1) + (j24 * j36) + (j38 * j25);
        long j40 = j31;
        long j41 = (long) i22;
        long j42 = (j24 * j41) + (j28 * j36) + (j38 * j37);
        long j43 = j38;
        int i41 = i20;
        long j44 = (long) i41;
        long j45 = ((j33 * j31) << 1) + j42 + (j25 * j44);
        long j46 = (j28 * j41) + (j33 * j36) + (j43 * j40) + (j44 * j37);
        long j47 = j3 - (j46 * 76);
        long j48 = j6 - (((((j33 * j41) + (j44 * j40)) << 1) + (j43 * j36)) * 38);
        long j49 = j9 - (((j43 * j41) + (j36 * j44)) * 38);
        long j50 = j15 - ((j44 * j41) * 76);
        int i42 = i35 + i17;
        long j51 = j30 - j34;
        int i43 = i29 + i19;
        int i44 = i30 + i41;
        int i45 = i26 + i22;
        long j52 = j32 - j29;
        long j53 = (long) (i + i40);
        long j54 = j35 - j26;
        long j55 = (long) (i23 + i34);
        long j56 = j53 * j55;
        long j57 = ((j20 * j17) << 1) - j39;
        long j58 = (long) (i25 + i38);
        long j59 = (long) (i37 + i27);
        long j60 = (j53 * j58) + (j59 * j55);
        int i46 = i44;
        long j61 = (long) (i28 + i24);
        int i47 = i46;
        long j62 = (long) i42;
        long j63 = j58;
        long j64 = (long) i43;
        long j65 = j64;
        long j66 = (long) (i32 + i18);
        long j67 = (((j59 * j61) + (j62 * j58)) << 1) + (j53 * j64) + (j66 * j55);
        long j68 = j61;
        long j69 = (long) i45;
        long j70 = (long) i47;
        long j71 = (((j62 * j69) + (j70 * j68)) << 1) + (j66 * j65);
        long j72 = j57 + (j67 - j50);
        long j73 = (j72 >> 26) + (((((j62 * j61) << 1) + ((((j53 * j69) + (j59 * j65)) + (j66 * j63)) + (j55 * j70))) - j21) - j45);
        long j74 = j47 + ((((j73 >> 25) + (((((j59 * j69) + (j62 * j65)) + (j66 * j68)) + (j70 * j63)) << 1)) - j54) * 38);
        iArr3[0] = ((int) j74) & 67108863;
        long j75 = (j74 >> 26) + j48 + ((j71 - j52) * 38);
        iArr3[1] = ((int) j75) & 67108863;
        long j76 = (j75 >> 26) + j49 + ((((j66 * j69) + (j70 * j65)) - j51) * 38);
        iArr3[2] = ((int) j76) & 33554431;
        long j77 = (j76 >> 25) + j50 + ((((j70 * j69) << 1) - j57) * 38);
        iArr3[3] = ((int) j77) & 67108863;
        long j78 = (j77 >> 26) + j21 + (j45 * 38);
        iArr3[4] = ((int) j78) & 33554431;
        long j79 = (j78 >> 25) + j54 + (j56 - j47);
        iArr3[5] = ((int) j79) & 67108863;
        long j80 = (j79 >> 26) + j52 + (j60 - j48);
        iArr3[6] = ((int) j80) & 67108863;
        long j81 = (j80 >> 26) + j51 + ((((j53 * j61) + (j59 * j58)) + (j62 * j55)) - j49);
        iArr3[7] = ((int) j81) & 33554431;
        long j82 = (j81 >> 25) + ((long) (((int) j72) & 67108863));
        iArr3[8] = ((int) j82) & 67108863;
        iArr3[9] = (((int) j73) & 33554431) + ((int) (j82 >> 26));
    }

    public static int[] getInstance() {
        return new int[10];
    }

    public static void init(int[] iArr) {
        iArr[0] = iArr[0] + 1;
    }

    public static void init(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        m2044a(iArr, iArr3, iArr4);
        cca_continue(iArr4, iArr4);
        int i = 3;
        while (true) {
            i--;
            if (i > 0) {
                cca_continue(iArr4, iArr4);
            } else {
                getInstance(iArr4, iArr3, iArr2);
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m2044a(int[] iArr, int[] iArr2, int[] iArr3) {
        cca_continue(iArr, iArr2);
        getInstance(iArr, iArr2, iArr2);
        int i = 10;
        int[] iArr4 = new int[10];
        cca_continue(iArr2, iArr4);
        getInstance(iArr, iArr4, iArr4);
        cca_continue(iArr4, iArr4);
        int i2 = 2;
        int i3 = 2;
        while (true) {
            i3--;
            if (i3 <= 0) {
                break;
            }
            cca_continue(iArr4, iArr4);
        }
        getInstance(iArr2, iArr4, iArr4);
        int[] iArr5 = new int[10];
        cca_continue(iArr4, iArr5);
        int i4 = 5;
        int i5 = 5;
        while (true) {
            i5--;
            if (i5 <= 0) {
                break;
            }
            cca_continue(iArr5, iArr5);
        }
        getInstance(iArr4, iArr5, iArr5);
        int[] iArr6 = new int[10];
        cca_continue(iArr5, iArr6);
        while (true) {
            i4--;
            if (i4 <= 0) {
                break;
            }
            cca_continue(iArr6, iArr6);
        }
        getInstance(iArr4, iArr6, iArr6);
        cca_continue(iArr6, iArr4);
        while (true) {
            i--;
            if (i <= 0) {
                break;
            }
            cca_continue(iArr4, iArr4);
        }
        getInstance(iArr5, iArr4, iArr4);
        cca_continue(iArr4, iArr5);
        int i6 = 25;
        int i7 = 25;
        while (true) {
            i7--;
            if (i7 <= 0) {
                break;
            }
            cca_continue(iArr5, iArr5);
        }
        getInstance(iArr4, iArr5, iArr5);
        cca_continue(iArr5, iArr6);
        while (true) {
            i6--;
            if (i6 <= 0) {
                break;
            }
            cca_continue(iArr6, iArr6);
        }
        getInstance(iArr4, iArr6, iArr6);
        int i8 = 50;
        cca_continue(iArr6, iArr4);
        while (true) {
            i8--;
            if (i8 <= 0) {
                break;
            }
            cca_continue(iArr4, iArr4);
        }
        getInstance(iArr5, iArr4, iArr4);
        int i9 = 125;
        cca_continue(iArr4, iArr5);
        while (true) {
            i9--;
            if (i9 <= 0) {
                break;
            }
            cca_continue(iArr5, iArr5);
        }
        getInstance(iArr4, iArr5, iArr5);
        cca_continue(iArr5, iArr4);
        while (true) {
            i2--;
            if (i2 > 0) {
                cca_continue(iArr4, iArr4);
            } else {
                getInstance(iArr4, iArr, iArr3);
                return;
            }
        }
    }

    public static boolean init(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        getInstance(iArr, iArr2, iArr4);
        cca_continue(iArr2, iArr5);
        getInstance(iArr4, iArr5, iArr4);
        cca_continue(iArr5, iArr5);
        getInstance(iArr5, iArr4, iArr5);
        int[] iArr6 = new int[10];
        int[] iArr7 = new int[10];
        m2044a(iArr5, iArr6, iArr7);
        getInstance(iArr7, iArr4, iArr7);
        int[] iArr8 = new int[10];
        cca_continue(iArr7, iArr8);
        getInstance(iArr8, iArr2, iArr8);
        for (int i = 0; i < 10; i++) {
            iArr6[i] = iArr8[i] - iArr[i];
        }
        int i2 = (iArr6[9] >>> 23) & 1;
        m2042a(iArr6, i2);
        m2042a(iArr6, -i2);
        if (configure(iArr6)) {
            for (int i3 = 0; i3 < 10; i3++) {
                iArr3[i3 + 0] = iArr7[i3];
            }
            return true;
        }
        for (int i4 = 0; i4 < 10; i4++) {
            iArr6[i4] = iArr8[i4] + iArr[i4];
        }
        int i5 = (iArr6[9] >>> 23) & 1;
        m2042a(iArr6, i5);
        m2042a(iArr6, -i5);
        if (!configure(iArr6)) {
            return false;
        }
        getInstance(iArr7, f2892a, iArr3);
        return true;
    }
}
