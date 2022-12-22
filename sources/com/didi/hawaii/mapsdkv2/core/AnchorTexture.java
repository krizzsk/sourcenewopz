package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;

public class AnchorTexture extends C9181a {
    public float anchorX;
    public float anchorY;
    public int height;
    public int width;

    public /* bridge */ /* synthetic */ Bitmap getBitmap() {
        return super.getBitmap();
    }

    public /* bridge */ /* synthetic */ String getBitmapKey() {
        return super.getBitmapKey();
    }

    public /* bridge */ /* synthetic */ int getColumnCount() {
        return super.getColumnCount();
    }

    public /* bridge */ /* synthetic */ int getRowCount() {
        return super.getRowCount();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnchorTexture(Resources resources, Bitmap bitmap, int i, int i2, float f, float f2) {
        super(resources, bitmap);
        this.width = i;
        this.height = i2;
        this.anchorX = f;
        this.anchorY = f2;
    }
}
