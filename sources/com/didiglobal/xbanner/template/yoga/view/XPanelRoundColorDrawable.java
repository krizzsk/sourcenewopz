package com.didiglobal.xbanner.template.yoga.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class XPanelRoundColorDrawable extends Drawable {

    /* renamed from: a */
    private final Path f51550a = new Path();

    /* renamed from: b */
    private RectF f51551b = new RectF();

    /* renamed from: c */
    private Paint f51552c;

    /* renamed from: d */
    private float[] f51553d;

    /* renamed from: e */
    private Paint f51554e;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundColorDrawable(int i, Corner corner) {
        float[] fArr = new float[8];
        this.f51553d = fArr;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f51553d;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f51553d;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f51553d;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f51552c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f51552c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f51554e = paint2;
        paint2.setAntiAlias(true);
        this.f51554e.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f51551b.set(rect);
    }

    public void draw(Canvas canvas) {
        this.f51550a.reset();
        this.f51550a.addRoundRect(this.f51551b, this.f51553d, Path.Direction.CW);
        canvas.drawPath(this.f51550a, this.f51554e);
    }

    public void setAlpha(int i) {
        this.f51552c.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f51552c.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
