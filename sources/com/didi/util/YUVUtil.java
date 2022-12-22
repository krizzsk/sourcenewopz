package com.didi.util;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;

public class YUVUtil {
    public static byte[] getYUV420sp(int i, int i2, Bitmap bitmap) {
        int[] iArr = new int[(i * i2)];
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        byte[] bArr = new byte[((((i % 2 == 0 ? i : i + 1) * (i2 % 2 == 0 ? i2 : i2 + 1)) * 3) / 2)];
        m32444a(bArr, iArr, i, i2);
        bitmap.recycle();
        return bArr;
    }

    /* renamed from: a */
    private static void m32444a(byte[] bArr, int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = 0;
            while (i6 < i) {
                i4++;
                bArr[i3] = (byte) Math.max(0, Math.min((((((iArr[i4] & 16711680) >> 16) * 77) + (((iArr[i4] & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) * 150)) + ((iArr[i4] & 255) * 29)) >> 8, 255));
                i6++;
                i3++;
            }
        }
    }
}
