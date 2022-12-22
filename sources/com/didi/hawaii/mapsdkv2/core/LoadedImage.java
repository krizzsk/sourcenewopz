package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;

class LoadedImage {
    public final float anchorPointX1;
    public final float anchorPointY1;
    final Bitmap bitmap;
    public final float scale;

    LoadedImage(Bitmap bitmap2, float f, float f2, float f3) {
        this.bitmap = bitmap2;
        this.scale = f;
        this.anchorPointX1 = f2;
        this.anchorPointY1 = f3;
    }
}
