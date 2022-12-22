package com.didi.soda.customer.foundation.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.util.C1850Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class ClipBottomTransformation extends BitmapTransformation {

    /* renamed from: a */
    private static final String f40915a = "com.didi.soda.customer.foundation.imageloader.ClipBottomTransformation";

    /* renamed from: b */
    private static final byte[] f40916b = f40915a.getBytes(CHARSET);

    /* renamed from: c */
    private int f40917c;

    /* renamed from: d */
    private int f40918d;

    /* renamed from: e */
    private int f40919e;

    /* renamed from: f */
    private int f40920f;

    public ClipBottomTransformation(Context context, int i, int i2, int i3) {
        this.f40917c = i3;
        this.f40918d = i;
        this.f40919e = i2;
        this.f40920f = (i + String.valueOf(i2) + i3).hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f40916b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f40920f).array());
    }

    public boolean equals(Object obj) {
        if (obj instanceof ClipBottomTransformation) {
            ClipBottomTransformation clipBottomTransformation = (ClipBottomTransformation) obj;
            return clipBottomTransformation.f40917c == this.f40917c && clipBottomTransformation.f40918d == this.f40918d && clipBottomTransformation.f40919e == this.f40919e;
        }
    }

    public int hashCode() {
        return C1850Util.hashCode(672007565, C1850Util.hashCode(this.f40920f));
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        Bitmap bitmap3 = bitmapPool.get(width, bitmap.getHeight(), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        if (bitmap3 == null) {
            bitmap2 = Bitmap.createBitmap(width, (this.f40919e * width) / this.f40918d, Bitmap.Config.ARGB_8888);
        } else {
            int i3 = (this.f40919e * width) / this.f40918d;
            if (i3 > bitmap3.getHeight()) {
                i3 = bitmap3.getHeight();
            }
            bitmap2 = Bitmap.createBitmap(bitmap3, 0, 0, width > bitmap3.getWidth() ? bitmap3.getWidth() : width, i3);
        }
        bitmap2.setHasAlpha(true);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawBitmap(bitmap2, (Rect) null, new Rect(0, 0, this.f40918d, this.f40919e), paint);
        RectF rectF = new RectF(0.0f, 0.0f, (float) width, (float) ((this.f40919e * width) / this.f40918d));
        int i4 = this.f40917c;
        canvas.drawRoundRect(rectF, (float) i4, (float) i4, paint);
        return bitmap2;
    }
}
