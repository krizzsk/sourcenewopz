package com.didi.global.globalgenerickit.template.yoga.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class XPanelRoundColorDrawable extends Drawable {

    /* renamed from: a */
    private final Path f22259a = new Path();

    /* renamed from: b */
    private RectF f22260b = new RectF();

    /* renamed from: c */
    private Paint f22261c;

    /* renamed from: d */
    private float[] f22262d;

    /* renamed from: e */
    private Paint f22263e;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundColorDrawable(int i, Corner corner) {
        float[] fArr = new float[8];
        this.f22262d = fArr;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f22262d;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f22262d;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f22262d;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f22261c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f22261c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f22263e = paint2;
        paint2.setAntiAlias(true);
        this.f22263e.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f22260b.set(rect);
    }

    public void draw(Canvas canvas) {
        this.f22259a.reset();
        this.f22259a.addRoundRect(this.f22260b, this.f22262d, Path.Direction.CW);
        canvas.drawPath(this.f22259a, this.f22263e);
    }

    public void setAlpha(int i) {
        this.f22261c.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f22261c.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
