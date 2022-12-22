package com.cardinalcommerce.p060a;

import com.google.common.base.Ascii;
import okio.Utf8;

/* renamed from: com.cardinalcommerce.a.setTransitionName */
public final class setTransitionName {

    /* renamed from: a */
    private static final short[] f3071a = new short[128];

    /* renamed from: b */
    private static final byte[] f3072b = new byte[112];

    public static int cca_continue(byte[] bArr, char[] cArr) {
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = i + 1;
            byte b = bArr[i];
            if (b < 0) {
                short s = f3071a[b & Byte.MAX_VALUE];
                int i4 = s >>> 8;
                byte b2 = (byte) s;
                while (b2 >= 0) {
                    if (i3 >= bArr.length) {
                        return -1;
                    }
                    int i5 = i3 + 1;
                    byte b3 = bArr[i3];
                    i4 = (i4 << 6) | (b3 & Utf8.REPLACEMENT_BYTE);
                    b2 = f3072b[b2 + ((b3 & 255) >>> 4)];
                    i3 = i5;
                }
                if (b2 == -2) {
                    return -1;
                }
                if (i4 <= 65535) {
                    if (i2 >= cArr.length) {
                        return -1;
                    }
                    cArr[i2] = (char) i4;
                    i2++;
                } else if (i2 >= cArr.length - 1) {
                    return -1;
                } else {
                    int i6 = i2 + 1;
                    cArr[i2] = (char) ((i4 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                    i2 = i6 + 1;
                    cArr[i6] = (char) (56320 | (i4 & 1023));
                }
                i = i3;
            } else if (i2 >= cArr.length) {
                return -1;
            } else {
                cArr[i2] = (char) b;
                i = i3;
                i2++;
            }
        }
        return i2;
    }

    static {
        byte[] bArr = new byte[128];
        for (int i = 0; i <= 15; i++) {
            bArr[i] = 1;
        }
        for (int i2 = 16; i2 <= 31; i2++) {
            bArr[i2] = 2;
        }
        for (int i3 = 32; i3 <= 63; i3++) {
            bArr[i3] = 3;
        }
        for (int i4 = 64; i4 <= 65; i4++) {
            bArr[i4] = 0;
        }
        for (int i5 = 66; i5 <= 95; i5++) {
            bArr[i5] = 4;
        }
        for (int i6 = 96; i6 <= 96; i6++) {
            bArr[96] = 5;
        }
        for (int i7 = 97; i7 <= 108; i7++) {
            bArr[i7] = 6;
        }
        for (int i8 = 109; i8 <= 109; i8++) {
            bArr[109] = 7;
        }
        for (int i9 = 110; i9 <= 111; i9++) {
            bArr[i9] = 6;
        }
        for (int i10 = 112; i10 <= 112; i10++) {
            bArr[112] = 8;
        }
        for (int i11 = 113; i11 <= 115; i11++) {
            bArr[i11] = 9;
        }
        for (int i12 = 116; i12 <= 116; i12++) {
            bArr[116] = 10;
        }
        for (int i13 = 117; i13 <= 127; i13++) {
            bArr[i13] = 0;
        }
        byte[] bArr2 = f3072b;
        int length = bArr2.length - 1;
        for (int i14 = 0; i14 <= length; i14++) {
            bArr2[i14] = -2;
        }
        byte[] bArr3 = f3072b;
        for (int i15 = 8; i15 <= 11; i15++) {
            bArr3[i15] = -1;
        }
        byte[] bArr4 = f3072b;
        for (int i16 = 24; i16 <= 27; i16++) {
            bArr4[i16] = 0;
        }
        byte[] bArr5 = f3072b;
        for (int i17 = 40; i17 <= 43; i17++) {
            bArr5[i17] = 16;
        }
        byte[] bArr6 = f3072b;
        for (int i18 = 58; i18 <= 59; i18++) {
            bArr6[i18] = 0;
        }
        byte[] bArr7 = f3072b;
        for (int i19 = 72; i19 <= 73; i19++) {
            bArr7[i19] = 0;
        }
        byte[] bArr8 = f3072b;
        for (int i20 = 89; i20 <= 91; i20++) {
            bArr8[i20] = 16;
        }
        byte[] bArr9 = f3072b;
        for (int i21 = 104; i21 <= 104; i21++) {
            bArr9[104] = 16;
        }
        byte[] bArr10 = {0, 0, 0, 0, Ascii.f53596US, Ascii.f53593SI, Ascii.f53593SI, Ascii.f53593SI, 7, 7, 7};
        byte[] bArr11 = {-2, -2, -2, -2, 0, 48, 16, 64, 80, 32, 96};
        for (int i22 = 0; i22 < 128; i22++) {
            byte b = bArr[i22];
            f3071a[i22] = (short) (bArr11[b] | ((bArr10[b] & i22) << 8));
        }
    }
}
