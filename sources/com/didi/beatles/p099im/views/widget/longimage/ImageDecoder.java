package com.didi.beatles.p099im.views.widget.longimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

/* renamed from: com.didi.beatles.im.views.widget.longimage.ImageDecoder */
public interface ImageDecoder {
    Bitmap decode(Context context, Uri uri) throws Exception;
}
