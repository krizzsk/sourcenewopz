package com.didichuxing.omega.sdk.feedback.leaked;

import android.content.Context;
import android.graphics.Bitmap;

public class BitmapLeakMaker extends LeakMaker<Bitmap> {
    public void startLeak(Context context) {
        this.uselessObjectList.add(Bitmap.createBitmap(769, 1367, Bitmap.Config.ARGB_8888));
    }
}
