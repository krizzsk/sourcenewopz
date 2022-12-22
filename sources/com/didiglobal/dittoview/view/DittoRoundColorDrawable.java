package com.didiglobal.dittoview.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class DittoRoundColorDrawable extends Drawable {

    /* renamed from: a */
    private final Path f49925a = new Path();

    /* renamed from: b */
    private RectF f49926b = new RectF();

    /* renamed from: c */
    private Paint f49927c;

    /* renamed from: d */
    private float[] f49928d;

    /* renamed from: e */
    private Paint f49929e;

    public int getOpacity() {
        return -3;
    }

    public DittoRoundColorDrawable(int i, DittoCorner dittoCorner) {
        float[] fArr = new float[8];
        this.f49928d = fArr;
        float leftTopCorner = dittoCorner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f49928d;
        float rightTopCorner = dittoCorner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f49928d;
        float rightBottomCorner = dittoCorner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f49928d;
        float leftBottomCorner = dittoCorner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f49927c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f49927c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f49929e = paint2;
        paint2.setAntiAlias(true);
        this.f49929e.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f49926b.set(rect);
    }

    public void draw(Canvas canvas) {
        this.f49925a.reset();
        this.f49925a.addRoundRect(this.f49926b, this.f49928d, Path.Direction.CW);
        canvas.drawPath(this.f49925a, this.f49929e);
    }

    public void setAlpha(int i) {
        this.f49927c.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f49927c.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
