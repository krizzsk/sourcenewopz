package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.C1850Util;
import com.bumptech.glide.util.Preconditions;

public class BitmapResource implements Initializable, Resource<Bitmap> {
    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;

    public static BitmapResource obtain(Bitmap bitmap2, BitmapPool bitmapPool2) {
        if (bitmap2 == null) {
            return null;
        }
        return new BitmapResource(bitmap2, bitmapPool2);
    }

    public BitmapResource(Bitmap bitmap2, BitmapPool bitmapPool2) {
        this.bitmap = (Bitmap) Preconditions.checkNotNull(bitmap2, "Bitmap must not be null");
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool2, "BitmapPool must not be null");
    }

    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    public Bitmap get() {
        return this.bitmap;
    }

    public int getSize() {
        return C1850Util.getBitmapByteSize(this.bitmap);
    }

    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }

    public void initialize() {
        this.bitmap.prepareToDraw();
    }
}
