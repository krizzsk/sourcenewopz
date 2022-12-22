package com.didi.soda.customer.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class CustomerRoundDrawable extends Drawable {

    /* renamed from: a */
    private Path f41472a;

    /* renamed from: b */
    private int f41473b;

    /* renamed from: c */
    private int f41474c;

    /* renamed from: d */
    private RectF f41475d;

    /* renamed from: e */
    private Bitmap f41476e;

    /* renamed from: f */
    private Paint f41477f;

    /* renamed from: g */
    private float[] f41478g = new float[8];

    /* renamed from: h */
    private Matrix f41479h;

    /* renamed from: i */
    private boolean f41480i = true;

    /* renamed from: j */
    private BitmapShader f41481j;

    /* renamed from: k */
    private Paint f41482k;

    /* renamed from: l */
    private boolean f41483l = false;

    /* renamed from: m */
    private float f41484m;

    public int getOpacity() {
        return -3;
    }

    public CustomerRoundDrawable(Context context, int i, Corner corner) {
        m29351a(BitmapFactory.decodeResource(context.getResources(), i), corner);
    }

    public CustomerRoundDrawable(Bitmap bitmap, Corner corner) {
        m29351a(bitmap, corner);
    }

    /* renamed from: a */
    private void m29351a(Bitmap bitmap, Corner corner) {
        this.f41476e = bitmap;
        this.f41481j = new BitmapShader(this.f41476e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f41473b = bitmap.getWidth();
        this.f41474c = bitmap.getHeight();
        float[] fArr = this.f41478g;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f41478g;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f41478g;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f41478g;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f41482k = paint;
        paint.setAntiAlias(true);
        this.f41482k.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f41477f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f41477f.setAntiAlias(true);
        this.f41477f.setShader(this.f41481j);
        this.f41475d = new RectF();
        this.f41479h = new Matrix();
        this.f41472a = new Path();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f41475d.set(rect);
        if (!(this.f41474c == 0 || this.f41473b == 0)) {
            this.f41479h.setScale((this.f41475d.width() * 1.0f) / ((float) this.f41473b), (this.f41475d.height() * 1.0f) / ((float) this.f41474c));
        }
        this.f41480i = true;
    }

    public void setBorderColor(int i) {
        this.f41482k.setColor(i);
    }

    public void setBorderWidth(float f) {
        if (f > 0.0f) {
            this.f41483l = true;
            this.f41484m = f;
            this.f41482k.setStrokeWidth(f);
            return;
        }
        this.f41483l = false;
    }

    public void draw(Canvas canvas) {
        BitmapShader bitmapShader;
        if (this.f41480i && (bitmapShader = this.f41481j) != null) {
            bitmapShader.setLocalMatrix(this.f41479h);
            this.f41480i = false;
        }
        this.f41472a.reset();
        this.f41472a.addRoundRect(this.f41475d, this.f41478g, Path.Direction.CW);
        canvas.drawPath(this.f41472a, this.f41477f);
        if (this.f41483l) {
            this.f41472a.reset();
            this.f41475d.left += this.f41484m / 2.0f;
            this.f41475d.top += this.f41484m / 2.0f;
            this.f41475d.right -= this.f41484m / 2.0f;
            this.f41475d.bottom -= this.f41484m / 2.0f;
            this.f41472a.addRoundRect(this.f41475d, this.f41478g, Path.Direction.CW);
            canvas.drawPath(this.f41472a, this.f41482k);
        }
    }

    public void setAlpha(int i) {
        this.f41477f.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f41477f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f41474c;
    }

    public int getIntrinsicWidth() {
        return this.f41473b;
    }

    public static class Corner {
        private float leftBottomCorner;
        private float leftTopCorner;
        private float rightBottomCorner;
        private float rightTopCorner;

        public void setCorners(float f) {
            this.leftTopCorner = f;
            this.leftBottomCorner = f;
            this.rightTopCorner = f;
            this.rightBottomCorner = f;
        }

        public void setLeftTopCorner(float f) {
            this.leftTopCorner = f;
        }

        public void setLeftBottomCorner(float f) {
            this.leftBottomCorner = f;
        }

        public void setRightTopCorner(float f) {
            this.rightTopCorner = f;
        }

        public void setRightBottomCorner(float f) {
            this.rightBottomCorner = f;
        }

        public float getLeftTopCorner() {
            return this.leftTopCorner;
        }

        public float getLeftBottomCorner() {
            return this.leftBottomCorner;
        }

        public float getRightTopCorner() {
            return this.rightTopCorner;
        }

        public float getRightBottomCorner() {
            return this.rightBottomCorner;
        }
    }
}
