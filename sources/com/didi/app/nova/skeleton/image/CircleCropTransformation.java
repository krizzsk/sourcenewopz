package com.didi.app.nova.skeleton.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

@Deprecated
public class CircleCropTransformation extends BitmapTransformation {

    /* renamed from: a */
    private static final int f8440a = 1;

    /* renamed from: b */
    private static final String f8441b = "com.didi.app.nova.skeleton.image.CircleCropTransformation.1";

    public int hashCode() {
        return 163903394;
    }

    public CircleCropTransformation(Context context) {
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmap2 = bitmapPool.get(i, i2, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        }
        int width = (bitmap.getWidth() - min) / 2;
        int height = (bitmap.getHeight() - min) / 2;
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        if (!(width == 0 && height == 0)) {
            Matrix matrix = new Matrix();
            matrix.setTranslate((float) (-width), (float) (-height));
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        float f = ((float) min) / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        return bitmap2;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        try {
            messageDigest.update(f8441b.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public boolean equals(Object obj) {
        return obj instanceof CircleCropTransformation;
    }
}
