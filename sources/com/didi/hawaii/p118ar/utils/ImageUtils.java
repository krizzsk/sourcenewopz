package com.didi.hawaii.p118ar.utils;

import android.graphics.Bitmap;
import android.media.Image;
import androidx.core.view.MotionEventCompat;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.FileOutputStream;

/* renamed from: com.didi.hawaii.ar.utils.ImageUtils */
public class ImageUtils {

    /* renamed from: a */
    static final int f23317a = 262143;

    /* renamed from: a */
    private static int m16712a(int i, int i2, int i3) {
        int i4 = i - 16;
        int i5 = 0;
        if (i4 < 0) {
            i4 = 0;
        }
        int i6 = i2 - 128;
        int i7 = i3 - 128;
        int i8 = i4 * 1192;
        int i9 = (i7 * 1634) + i8;
        int i10 = (i8 - (i7 * 833)) - (i6 * 400);
        int i11 = i8 + (i6 * 2066);
        if (i9 > f23317a) {
            i9 = f23317a;
        } else if (i9 < 0) {
            i9 = 0;
        }
        if (i10 > f23317a) {
            i10 = f23317a;
        } else if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > f23317a) {
            i5 = f23317a;
        } else if (i11 >= 0) {
            i5 = i11;
        }
        return -16777216 | ((i9 << 6) & 16711680) | ((i10 >> 2) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((i5 >> 10) & 255);
    }

    public static void saveBitmap(Bitmap bitmap) {
        saveBitmap(bitmap, "preview.png");
    }

    public static void saveBitmap(Bitmap bitmap, String str) {
        String absolutePath = SystemUtils.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(absolutePath + "/" + str);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 99, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            SystemUtils.log(6, "error", e.toString(), (Throwable) null, "com.didi.hawaii.ar.utils.ImageUtils", 47);
        }
    }

    public static void convertYUV420SPToARGB8888(byte[] bArr, int i, int i2, int[] iArr) {
        int i3 = i * i2;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 >> 1) * i) + i3;
            int i7 = 0;
            byte b = 0;
            byte b2 = 0;
            while (i7 < i) {
                byte b3 = bArr[i4] & 255;
                if ((i7 & 1) == 0) {
                    int i8 = i6 + 1;
                    b2 = bArr[i6] & 255;
                    i6 = i8 + 1;
                    b = bArr[i8] & 255;
                }
                iArr[i4] = m16712a(b3, b, b2);
                i7++;
                i4++;
            }
        }
    }

    public static void convertYUVToARGB8888(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6 = i2;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            int i9 = i3 * i8;
            int i10 = (i8 >> 1) * i4;
            int i11 = i;
            int i12 = 0;
            while (i12 < i11) {
                int i13 = ((i12 >> 1) * i5) + i10;
                iArr[i7] = m16712a(bArr[i9 + i12] & 255, bArr2[i13] & 255, bArr3[i13] & 255);
                i12++;
                i7++;
            }
        }
    }

    public static Bitmap convertImage2Bitmap(Image image) {
        int width = image.getWidth();
        int height = image.getHeight();
        byte[] bArr = new byte[image.getPlanes()[0].getBuffer().capacity()];
        image.getPlanes()[0].getBuffer().get(bArr);
        byte[] bArr2 = new byte[image.getPlanes()[1].getBuffer().capacity()];
        image.getPlanes()[1].getBuffer().get(bArr2);
        byte[] bArr3 = new byte[image.getPlanes()[2].getBuffer().capacity()];
        image.getPlanes()[2].getBuffer().get(bArr3);
        int rowStride = image.getPlanes()[0].getRowStride();
        int rowStride2 = image.getPlanes()[1].getRowStride();
        int pixelStride = image.getPlanes()[1].getPixelStride();
        image.close();
        int[] iArr = new int[(width * height)];
        convertYUVToARGB8888(bArr, bArr2, bArr3, width, height, rowStride, rowStride2, pixelStride, iArr);
        return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
    }
}
