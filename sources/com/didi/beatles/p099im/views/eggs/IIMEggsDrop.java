package com.didi.beatles.p099im.views.eggs;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/* renamed from: com.didi.beatles.im.views.eggs.IIMEggsDrop */
public interface IIMEggsDrop {
    void draw(Canvas canvas);

    void init(Bitmap bitmap, int i, int i2);

    boolean isActive();

    void recycle();
}
