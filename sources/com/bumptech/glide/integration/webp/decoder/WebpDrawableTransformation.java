package com.bumptech.glide.integration.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.security.MessageDigest;

public class WebpDrawableTransformation implements Transformation<WebpDrawable> {
    private final Transformation<Bitmap> wrapped;

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WebpDrawableTransformation(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r1) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.bumptech.glide.util.Preconditions.checkNotNull(r1)
            com.bumptech.glide.load.Transformation r1 = (com.bumptech.glide.load.Transformation) r1
            r0.wrapped = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation.<init>(com.bumptech.glide.load.Transformation):void");
    }

    public Resource<WebpDrawable> transform(Context context, Resource<WebpDrawable> resource, int i, int i2) {
        WebpDrawable webpDrawable = resource.get();
        BitmapResource bitmapResource = new BitmapResource(webpDrawable.getFirstFrame(), Glide.get(context).getBitmapPool());
        Resource<Bitmap> transform = this.wrapped.transform(context, bitmapResource, i, i2);
        if (!bitmapResource.equals(transform)) {
            bitmapResource.recycle();
        }
        webpDrawable.setFrameTransformation(this.wrapped, transform.get());
        return resource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WebpDrawableTransformation) {
            return this.wrapped.equals(((WebpDrawableTransformation) obj).wrapped);
        }
        return false;
    }

    public int hashCode() {
        return this.wrapped.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
