package com.didichuxing.xpanel.xcard.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class XPanelRoundColorDrawable extends Drawable {

    /* renamed from: a */
    private final Path f49655a = new Path();

    /* renamed from: b */
    private RectF f49656b = new RectF();

    /* renamed from: c */
    private Paint f49657c;

    /* renamed from: d */
    private float[] f49658d;

    /* renamed from: e */
    private Paint f49659e;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundColorDrawable(int i, Corner corner) {
        float[] fArr = new float[8];
        this.f49658d = fArr;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f49658d;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f49658d;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f49658d;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f49657c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f49657c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f49659e = paint2;
        paint2.setAntiAlias(true);
        this.f49659e.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f49656b.set(rect);
    }

    public void draw(Canvas canvas) {
        this.f49655a.reset();
        this.f49655a.addRoundRect(this.f49656b, this.f49658d, Path.Direction.CW);
        canvas.drawPath(this.f49655a, this.f49659e);
    }

    public void setAlpha(int i) {
        this.f49657c.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f49657c.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
