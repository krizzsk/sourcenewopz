package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;

public abstract class Texture {
    public abstract Bitmap getBitmap();

    public abstract String getBitmapKey();

    public abstract int getColumnCount();

    public abstract int getRowCount();

    public static Texture bitmap(Resources resources, Bitmap bitmap) {
        return new C9181a(resources, bitmap);
    }

    public static Texture customBitmap(int i) {
        return new C9182b(i);
    }

    public static Texture mappack(String str, int i, int i2) {
        return new C9187g(str, i, i2);
    }

    public static AnchorTexture anchorBitmap(Resources resources, Bitmap bitmap, int i, int i2, float f, float f2) {
        return new AnchorTexture(resources, bitmap, i, i2, f, f2);
    }
}
