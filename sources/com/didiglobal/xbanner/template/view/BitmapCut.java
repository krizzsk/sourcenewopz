package com.didiglobal.xbanner.template.view;

import android.graphics.Bitmap;

public class BitmapCut {
    public static Bitmap bitmapCut(Bitmap bitmap, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = (int) (((float) height) * (((float) i) / ((float) i2)));
        if (i3 > width) {
            return null;
        }
        return Bitmap.createBitmap(bitmap, width - i3, 0, i3, height);
    }
}
