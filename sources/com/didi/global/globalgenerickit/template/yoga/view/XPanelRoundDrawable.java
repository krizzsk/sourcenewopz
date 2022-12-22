package com.didi.global.globalgenerickit.template.yoga.view;

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
    private final Path f22264a;

    /* renamed from: b */
    private int f22265b;

    /* renamed from: c */
    private int f22266c;

    /* renamed from: d */
    private RectF f22267d;

    /* renamed from: e */
    private Bitmap f22268e;

    /* renamed from: f */
    private Paint f22269f;

    /* renamed from: g */
    private float[] f22270g = new float[8];

    /* renamed from: h */
    private Matrix f22271h;

    /* renamed from: i */
    private boolean f22272i = true;

    /* renamed from: j */
    private BitmapShader f22273j;

    /* renamed from: k */
    private Paint f22274k;

    /* renamed from: l */
    private boolean f22275l = false;

    /* renamed from: m */
    private float f22276m;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundDrawable(Bitmap bitmap, Corner corner) {
        this.f22268e = bitmap;
        this.f22273j = new BitmapShader(this.f22268e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f22265b = bitmap.getWidth();
        this.f22266c = bitmap.getHeight();
        float[] fArr = this.f22270g;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f22270g;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f22270g;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f22270g;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f22274k = paint;
        paint.setAntiAlias(true);
        this.f22274k.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f22269f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f22269f.setAntiAlias(true);
        this.f22269f.setShader(this.f22273j);
        this.f22267d = new RectF();
        this.f22271h = new Matrix();
        this.f22264a = new Path();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f22267d.set(rect);
        if (!(this.f22266c == 0 || this.f22265b == 0)) {
            this.f22271h.setScale((this.f22267d.width() * 1.0f) / ((float) this.f22265b), (this.f22267d.height() * 1.0f) / ((float) this.f22266c));
        }
        this.f22272i = true;
    }

    public static XPanelRoundDrawable fromBitmap(Bitmap bitmap, Corner corner) {
        if (bitmap != null) {
            return new XPanelRoundDrawable(bitmap, corner);
        }
        return null;
    }

    public void setBorderColor(int i) {
        this.f22274k.setColor(i);
    }

    public void setBorderWidth(float f) {
        if (f > 0.0f) {
            this.f22275l = true;
            this.f22276m = f;
            this.f22274k.setStrokeWidth(f);
            return;
        }
        this.f22275l = false;
    }

    public void draw(Canvas canvas) {
        BitmapShader bitmapShader;
        if (this.f22272i && (bitmapShader = this.f22273j) != null) {
            bitmapShader.setLocalMatrix(this.f22271h);
            this.f22272i = false;
        }
        this.f22264a.reset();
        this.f22264a.addRoundRect(this.f22267d, this.f22270g, Path.Direction.CW);
        canvas.drawPath(this.f22264a, this.f22269f);
        if (this.f22275l) {
            this.f22264a.reset();
            this.f22267d.left += this.f22276m / 2.0f;
            this.f22267d.top += this.f22276m / 2.0f;
            this.f22267d.right -= this.f22276m / 2.0f;
            this.f22267d.bottom -= this.f22276m / 2.0f;
            this.f22264a.addRoundRect(this.f22267d, this.f22270g, Path.Direction.CW);
            canvas.drawPath(this.f22264a, this.f22274k);
        }
    }

    public void setAlpha(int i) {
        this.f22269f.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f22269f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f22266c;
    }

    public int getIntrinsicWidth() {
        return this.f22265b;
    }
}
