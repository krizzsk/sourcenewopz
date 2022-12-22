package com.didi.sdk.login.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

public class DriverCirclePhoto extends ImageView {

    /* renamed from: a */
    private int f36721a = 1;

    /* renamed from: b */
    private int f36722b = Color.parseColor("#30000000");

    /* renamed from: c */
    private Paint f36723c = new Paint();

    public DriverCirclePhoto(Context context) {
        super(context);
    }

    public DriverCirclePhoto(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DriverCirclePhoto(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static Bitmap round(Bitmap bitmap, int i, int i2, int i3, boolean z) {
        Bitmap bitmap2;
        if (i == 0 || i2 == 0 || i3 <= 0 || bitmap == null) {
            return bitmap;
        }
        try {
            bitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            return null;
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i, i2);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float f = (float) i3;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (z) {
            clear(bitmap);
        }
        return bitmap2;
    }

    public static void clear(Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT < 14) {
            bitmap.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap a;
        Bitmap round;
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap != null && (a = m25999a(bitmap)) != null && (round = round(a, getWidth(), getHeight(), getWidth() / 2, false)) != null) {
                Rect rect = new Rect(0, 0, round.getWidth(), round.getHeight());
                this.f36723c.reset();
                canvas.drawBitmap(round, rect, rect, this.f36723c);
            } else {
                return;
            }
        } else {
            super.onDraw(canvas);
        }
        m26000a(canvas, getWidth(), getHeight());
    }

    /* renamed from: a */
    private void m26000a(Canvas canvas, int i, int i2) {
        if (this.f36721a != 0) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            paint.setColor(this.f36722b);
            paint.setStrokeWidth((float) this.f36721a);
            float f = (float) (i >> 1);
            canvas.drawCircle(f, (float) (i2 >> 1), f, paint);
        }
    }

    /* renamed from: a */
    private Bitmap m25999a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        int width2 = getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) width2) / ((float) width), ((float) getHeight()) / ((float) height));
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception unused) {
            return null;
        }
    }
}
