package com.didichuxing.xpanel.xcard.view;

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
    private final Path f49660a;

    /* renamed from: b */
    private int f49661b;

    /* renamed from: c */
    private int f49662c;

    /* renamed from: d */
    private RectF f49663d;

    /* renamed from: e */
    private Bitmap f49664e;

    /* renamed from: f */
    private Paint f49665f;

    /* renamed from: g */
    private float[] f49666g = new float[8];

    /* renamed from: h */
    private Matrix f49667h;

    /* renamed from: i */
    private boolean f49668i = true;

    /* renamed from: j */
    private BitmapShader f49669j;

    /* renamed from: k */
    private Paint f49670k;

    /* renamed from: l */
    private boolean f49671l = false;

    /* renamed from: m */
    private float f49672m;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundDrawable(Bitmap bitmap, Corner corner) {
        this.f49664e = bitmap;
        this.f49669j = new BitmapShader(this.f49664e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f49661b = bitmap.getWidth();
        this.f49662c = bitmap.getHeight();
        float[] fArr = this.f49666g;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f49666g;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f49666g;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f49666g;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f49670k = paint;
        paint.setAntiAlias(true);
        this.f49670k.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f49665f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f49665f.setAntiAlias(true);
        this.f49665f.setShader(this.f49669j);
        this.f49663d = new RectF();
        this.f49667h = new Matrix();
        this.f49660a = new Path();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f49663d.set(rect);
        if (!(this.f49662c == 0 || this.f49661b == 0)) {
            this.f49667h.setScale((this.f49663d.width() * 1.0f) / ((float) this.f49661b), (this.f49663d.height() * 1.0f) / ((float) this.f49662c));
        }
        this.f49668i = true;
    }

    public static XPanelRoundDrawable fromBitmap(Bitmap bitmap, Corner corner) {
        if (bitmap != null) {
            return new XPanelRoundDrawable(bitmap, corner);
        }
        return null;
    }

    public void setBorderColor(int i) {
        this.f49670k.setColor(i);
    }

    public void setBorderWidth(float f) {
        if (f > 0.0f) {
            this.f49671l = true;
            this.f49672m = f;
            this.f49670k.setStrokeWidth(f);
            return;
        }
        this.f49671l = false;
    }

    public void draw(Canvas canvas) {
        BitmapShader bitmapShader;
        if (this.f49668i && (bitmapShader = this.f49669j) != null) {
            bitmapShader.setLocalMatrix(this.f49667h);
            this.f49668i = false;
        }
        this.f49660a.reset();
        this.f49660a.addRoundRect(this.f49663d, this.f49666g, Path.Direction.CW);
        canvas.drawPath(this.f49660a, this.f49665f);
        if (this.f49671l) {
            this.f49660a.reset();
            this.f49663d.left += this.f49672m / 2.0f;
            this.f49663d.top += this.f49672m / 2.0f;
            this.f49663d.right -= this.f49672m / 2.0f;
            this.f49663d.bottom -= this.f49672m / 2.0f;
            this.f49660a.addRoundRect(this.f49663d, this.f49666g, Path.Direction.CW);
            canvas.drawPath(this.f49660a, this.f49670k);
        }
    }

    public void setAlpha(int i) {
        this.f49665f.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f49665f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f49662c;
    }

    public int getIntrinsicWidth() {
        return this.f49661b;
    }
}
