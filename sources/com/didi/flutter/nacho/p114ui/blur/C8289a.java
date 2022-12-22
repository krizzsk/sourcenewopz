package com.didi.flutter.nacho.p114ui.blur;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* renamed from: com.didi.flutter.nacho.ui.blur.a */
/* compiled from: FastBlurHelper */
final class C8289a {
    private C8289a() {
    }

    /* renamed from: a */
    public static Bitmap m15556a(Bitmap bitmap, int i, boolean z) {
        Bitmap bitmap2;
        int i2 = i;
        if (i2 < 1) {
            return null;
        }
        if (z || bitmap.getConfig() == Bitmap.Config.RGB_565) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        }
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap2.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int i5 = i2 + i2 + 1;
        int[] iArr2 = new int[Math.max(width, height)];
        int i6 = (i5 + 1) >> 1;
        int i7 = i6 * i6;
        int i8 = i7 * 256;
        int[] iArr3 = new int[i8];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            iArr3[i10] = i10 / i7;
        }
        int[] iArr4 = new int[2];
        iArr4[1] = 3;
        iArr4[0] = i5;
        int[][] iArr5 = (int[][]) Array.newInstance(int.class, iArr4);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            for (int i24 = -i2; i24 <= i2; i24++) {
                int i25 = iArr[i13 + Math.min(i3, Math.max(i24, i9))];
                int[] iArr6 = iArr5[i24 + i2];
                iArr6[i9] = (i25 & 16711680) >> 16;
                iArr6[1] = (i25 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr6[2] = i25 & 255;
                int abs = i11 - Math.abs(i24);
                i15 += iArr6[i9] * abs;
                i16 += iArr6[1] * abs;
                i17 += iArr6[2] * abs;
                if (i24 > 0) {
                    i21 += iArr6[i9];
                    i22 += iArr6[1];
                    i23 += iArr6[2];
                } else {
                    i18 += iArr6[i9];
                    i19 += iArr6[1];
                    i20 += iArr6[2];
                }
            }
            int i26 = i2;
            int i27 = 0;
            while (i27 < width) {
                iArr[i13] = (iArr[i13] & -16777216) | (iArr3[i15] << 16) | (iArr3[i16] << 8) | iArr3[i17];
                int i28 = i15 - i18;
                int i29 = i16 - i19;
                int i30 = i17 - i20;
                int[] iArr7 = iArr5[((i26 - i2) + i5) % i5];
                int i31 = i18 - iArr7[i9];
                int i32 = i19 - iArr7[1];
                int i33 = i20 - iArr7[2];
                if (i12 == 0) {
                    iArr2[i27] = Math.min(i27 + i2 + 1, i3);
                }
                int i34 = iArr[i14 + iArr2[i27]];
                iArr7[0] = (i34 & 16711680) >> 16;
                iArr7[1] = (i34 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr7[2] = i34 & 255;
                int i35 = i21 + iArr7[0];
                int i36 = i22 + iArr7[1];
                int i37 = i23 + iArr7[2];
                i15 = i28 + i35;
                i16 = i29 + i36;
                i17 = i30 + i37;
                i26 = (i26 + 1) % i5;
                int[] iArr8 = iArr5[i26 % i5];
                i18 = i31 + iArr8[0];
                i19 = i32 + iArr8[1];
                i20 = i33 + iArr8[2];
                i21 = i35 - iArr8[0];
                i22 = i36 - iArr8[1];
                i23 = i37 - iArr8[2];
                i13++;
                i27++;
                i9 = 0;
            }
            i14 += width;
            i12++;
            i9 = 0;
        }
        int i38 = 0;
        while (i38 < width) {
            int i39 = -i2;
            Bitmap bitmap3 = bitmap2;
            int i40 = i39;
            int[] iArr9 = iArr2;
            int i41 = i39 * width;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            while (i40 <= i2) {
                int i51 = i5;
                int[] iArr10 = iArr5[i40 + i2];
                int i52 = iArr[Math.max(0, i41) + i38];
                iArr10[0] = (i52 & 16711680) >> 16;
                iArr10[1] = (i52 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i52 & 255;
                int abs2 = i11 - Math.abs(i40);
                i42 += iArr10[0] * abs2;
                i43 += iArr10[1] * abs2;
                i44 += iArr10[2] * abs2;
                if (i40 > 0) {
                    i48 += iArr10[0];
                    i49 += iArr10[1];
                    i50 += iArr10[2];
                } else {
                    i45 += iArr10[0];
                    i46 += iArr10[1];
                    i47 += iArr10[2];
                }
                if (i40 < i4) {
                    i41 += width;
                }
                i40++;
                i5 = i51;
            }
            int i53 = i5;
            int i54 = i2;
            int i55 = i38;
            int i56 = 0;
            while (i56 < height) {
                iArr[i55] = (iArr[i55] & -16777216) | (iArr3[i42] << 16) | (iArr3[i43] << 8) | iArr3[i44];
                int i57 = i42 - i45;
                int i58 = i43 - i46;
                int i59 = i44 - i47;
                int[] iArr11 = iArr5[((i54 - i2) + i53) % i53];
                int i60 = i45 - iArr11[0];
                int i61 = i46 - iArr11[1];
                int i62 = i47 - iArr11[2];
                if (i38 == 0) {
                    iArr9[i56] = Math.min(i56 + i11, i4) * width;
                }
                int i63 = iArr[iArr9[i56] + i38];
                iArr11[0] = (i63 & 16711680) >> 16;
                iArr11[1] = (i63 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[2] = i63 & 255;
                int i64 = i48 + iArr11[0];
                int i65 = i49 + iArr11[1];
                int i66 = i50 + iArr11[2];
                i42 = i57 + i64;
                i43 = i58 + i65;
                i44 = i59 + i66;
                i54 = (i54 + 1) % i53;
                int[] iArr12 = iArr5[i54];
                i45 = i60 + iArr12[0];
                i46 = i61 + iArr12[1];
                i47 = i62 + iArr12[2];
                i48 = i64 - iArr12[0];
                i49 = i65 - iArr12[1];
                i50 = i66 - iArr12[2];
                i55 += width;
                i56++;
                i2 = i;
            }
            i38++;
            i2 = i;
            bitmap2 = bitmap3;
            iArr2 = iArr9;
            i5 = i53;
        }
        Bitmap bitmap4 = bitmap2;
        bitmap4.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap4;
    }
}
