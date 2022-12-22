package com.didi.hawaii.mapsdkv2.common;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.didi.hawaii.log.HWLog;

public class ImageCommUtils {
    public static Bitmap zoomBitmap(Bitmap bitmap, float f, float f2) {
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e) {
            HWLog.m16761i("", "zoomBitmap-:" + e.getMessage());
            return null;
        }
    }
}
