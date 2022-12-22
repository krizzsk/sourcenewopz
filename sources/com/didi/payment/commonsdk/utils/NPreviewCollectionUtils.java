package com.didi.payment.commonsdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Base64;
import java.io.ByteArrayOutputStream;

public class NPreviewCollectionUtils {
    public static String compressData(byte[] bArr, int i, int i2, float f, int i3) {
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, (int[]) null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
            return compress(bytes2Bimap(byteArrayOutputStream.toByteArray()), f, i3);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Bitmap bytes2Bimap(byte[] bArr) {
        if (bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    public static String compress(Bitmap bitmap, float f, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (1.0d - ((double) f) > 1.0E-4d) {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }
}
