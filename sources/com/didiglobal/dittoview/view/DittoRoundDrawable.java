package com.didiglobal.dittoview.view;

import android.graphics.Bitmap;
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

public class DittoRoundDrawable extends Drawable {

    /* renamed from: a */
    private final Path f49930a;

    /* renamed from: b */
    private int f49931b;

    /* renamed from: c */
    private int f49932c;

    /* renamed from: d */
    private RectF f49933d;

    /* renamed from: e */
    private Bitmap f49934e;

    /* renamed from: f */
    private Paint f49935f;

    /* renamed from: g */
    private float[] f49936g = new float[8];

    /* renamed from: h */
    private Matrix f49937h;

    /* renamed from: i */
    private boolean f49938i = true;

    /* renamed from: j */
    private BitmapShader f49939j;

    /* renamed from: k */
    private Paint f49940k;

    /* renamed from: l */
    private boolean f49941l = false;

    /* renamed from: m */
    private float f49942m;

    public int getOpacity() {
        return -3;
    }

    public DittoRoundDrawable(Bitmap bitmap, DittoCorner dittoCorner) {
        this.f49934e = bitmap;
        this.f49939j = new BitmapShader(this.f49934e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f49931b = bitmap.getWidth();
        this.f49932c = bitmap.getHeight();
        float[] fArr = this.f49936g;
        float leftTopCorner = dittoCorner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f49936g;
        float rightTopCorner = dittoCorner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f49936g;
        float rightBottomCorner = dittoCorner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f49936g;
        float leftBottomCorner = dittoCorner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f49940k = paint;
        paint.setAntiAlias(true);
        this.f49940k.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f49935f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f49935f.setAntiAlias(true);
        this.f49935f.setShader(this.f49939j);
        this.f49933d = new RectF();
        this.f49937h = new Matrix();
        this.f49930a = new Path();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f49933d.set(rect);
        if (!(this.f49932c == 0 || this.f49931b == 0)) {
            this.f49937h.setScale((this.f49933d.width() * 1.0f) / ((float) this.f49931b), (this.f49933d.height() * 1.0f) / ((float) this.f49932c));
        }
        this.f49938i = true;
    }

    public static DittoRoundDrawable fromBitmap(Bitmap bitmap, DittoCorner dittoCorner) {
        if (bitmap != null) {
            return new DittoRoundDrawable(bitmap, dittoCorner);
        }
        return null;
    }

    public void setBorderColor(int i) {
        this.f49940k.setColor(i);
    }

    public void setBorderWidth(float f) {
        if (f > 0.0f) {
            this.f49941l = true;
            this.f49942m = f;
            this.f49940k.setStrokeWidth(f);
            return;
        }
        this.f49941l = false;
    }

    public void draw(Canvas canvas) {
        BitmapShader bitmapShader;
        if (this.f49938i && (bitmapShader = this.f49939j) != null) {
            bitmapShader.setLocalMatrix(this.f49937h);
            this.f49938i = false;
        }
        this.f49930a.reset();
        this.f49930a.addRoundRect(this.f49933d, this.f49936g, Path.Direction.CW);
        canvas.drawPath(this.f49930a, this.f49935f);
        if (this.f49941l) {
            this.f49930a.reset();
            this.f49933d.left += this.f49942m / 2.0f;
            this.f49933d.top += this.f49942m / 2.0f;
            this.f49933d.right -= this.f49942m / 2.0f;
            this.f49933d.bottom -= this.f49942m / 2.0f;
            this.f49930a.addRoundRect(this.f49933d, this.f49936g, Path.Direction.CW);
            canvas.drawPath(this.f49930a, this.f49940k);
        }
    }

    public void setAlpha(int i) {
        this.f49935f.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f49935f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f49932c;
    }

    public int getIntrinsicWidth() {
        return this.f49931b;
    }
}
