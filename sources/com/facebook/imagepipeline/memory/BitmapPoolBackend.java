package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.imageutils.BitmapUtil;

public class BitmapPoolBackend extends LruBucketsPoolBackend<Bitmap> {
    private static final String TAG = "BitmapPoolBackend";

    public void put(Bitmap bitmap) {
        if (isReusable(bitmap)) {
            super.put(bitmap);
        }
    }

    public Bitmap get(int i) {
        Bitmap bitmap = (Bitmap) super.get(i);
        if (bitmap == null || !isReusable(bitmap)) {
            return null;
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    public int getSize(Bitmap bitmap) {
        return BitmapUtil.getSizeInBytes(bitmap);
    }

    /* access modifiers changed from: protected */
    public boolean isReusable(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        if (bitmap.isRecycled()) {
            FLog.wtf(TAG, "Cannot reuse a recycled bitmap: %s", bitmap);
            return false;
        } else if (bitmap.isMutable()) {
            return true;
        } else {
            FLog.wtf(TAG, "Cannot reuse an immutable bitmap: %s", bitmap);
            return false;
        }
    }
}
