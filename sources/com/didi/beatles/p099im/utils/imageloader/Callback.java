package com.didi.beatles.p099im.utils.imageloader;

import android.graphics.Bitmap;

/* renamed from: com.didi.beatles.im.utils.imageloader.Callback */
public interface Callback {
    void onFailed();

    void onStart();

    void onSuccess(Bitmap bitmap);
}
