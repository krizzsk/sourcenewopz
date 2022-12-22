package com.didiglobal.xbanner.template.yoga.view;

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

public class XPanelRoundDrawable extends Drawable {

    /* renamed from: a */
    private final Path f51555a;

    /* renamed from: b */
    private int f51556b;

    /* renamed from: c */
    private int f51557c;

    /* renamed from: d */
    private RectF f51558d;

    /* renamed from: e */
    private Bitmap f51559e;

    /* renamed from: f */
    private Paint f51560f;

    /* renamed from: g */
    private float[] f51561g = new float[8];

    /* renamed from: h */
    private Matrix f51562h;

    /* renamed from: i */
    private boolean f51563i = true;

    /* renamed from: j */
    private BitmapShader f51564j;

    /* renamed from: k */
    private Paint f51565k;

    /* renamed from: l */
    private boolean f51566l = false;

    /* renamed from: m */
    private float f51567m;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundDrawable(Bitmap bitmap, Corner corner) {
        this.f51559e = bitmap;
        this.f51564j = new BitmapShader(this.f51559e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f51556b = bitmap.getWidth();
        this.f51557c = bitmap.getHeight();
        float[] fArr = this.f51561g;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f51561g;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f51561g;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f51561g;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f51565k = paint;
        paint.setAntiAlias(true);
        this.f51565k.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f51560f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f51560f.setAntiAlias(true);
        this.f51560f.setShader(this.f51564j);
        this.f51558d = new RectF();
        this.f51562h = new Matrix();
        this.f51555a = new Path();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f51558d.set(rect);
        if (!(this.f51557c == 0 || this.f51556b == 0)) {
            this.f51562h.setScale((this.f51558d.width() * 1.0f) / ((float) this.f51556b), (this.f51558d.height() * 1.0f) / ((float) this.f51557c));
        }
        this.f51563i = true;
    }

    public static XPanelRoundDrawable fromBitmap(Bitmap bitmap, Corner corner) {
        if (bitmap != null) {
            return new XPanelRoundDrawable(bitmap, corner);
        }
        return null;
    }

    public void setBorderColor(int i) {
        this.f51565k.setColor(i);
    }

    public void setBorderWidth(float f) {
        if (f > 0.0f) {
            this.f51566l = true;
            this.f51567m = f;
            this.f51565k.setStrokeWidth(f);
            return;
        }
        this.f51566l = false;
    }

    public void draw(Canvas canvas) {
        BitmapShader bitmapShader;
        if (this.f51563i && (bitmapShader = this.f51564j) != null) {
            bitmapShader.setLocalMatrix(this.f51562h);
            this.f51563i = false;
        }
        this.f51555a.reset();
        this.f51555a.addRoundRect(this.f51558d, this.f51561g, Path.Direction.CW);
        canvas.drawPath(this.f51555a, this.f51560f);
        if (this.f51566l) {
            this.f51555a.reset();
            this.f51558d.left += this.f51567m / 2.0f;
            this.f51558d.top += this.f51567m / 2.0f;
            this.f51558d.right -= this.f51567m / 2.0f;
            this.f51558d.bottom -= this.f51567m / 2.0f;
            this.f51555a.addRoundRect(this.f51558d, this.f51561g, Path.Direction.CW);
            canvas.drawPath(this.f51555a, this.f51565k);
        }
    }

    public void setAlpha(int i) {
        this.f51560f.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f51560f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f51557c;
    }

    public int getIntrinsicWidth() {
        return this.f51556b;
    }
}
