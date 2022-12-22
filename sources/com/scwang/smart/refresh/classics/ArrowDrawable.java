package com.scwang.smart.refresh.classics;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import com.scwang.smart.drawable.PaintDrawable;

public class ArrowDrawable extends PaintDrawable {

    /* renamed from: a */
    private int f55978a = 0;

    /* renamed from: b */
    private int f55979b = 0;

    /* renamed from: c */
    private Path f55980c = new Path();

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (!(this.f55978a == width && this.f55979b == height)) {
            this.f55980c.reset();
            float f = (float) ((width * 30) / 225);
            float f2 = f * 0.70710677f;
            float f3 = f / 0.70710677f;
            float f4 = (float) width;
            float f5 = f4 / 2.0f;
            float f6 = (float) height;
            this.f55980c.moveTo(f5, f6);
            float f7 = f6 / 2.0f;
            this.f55980c.lineTo(0.0f, f7);
            float f8 = f7 - f2;
            this.f55980c.lineTo(f2, f8);
            float f9 = f / 2.0f;
            float f10 = f5 - f9;
            float f11 = (f6 - f3) - f9;
            this.f55980c.lineTo(f10, f11);
            this.f55980c.lineTo(f10, 0.0f);
            float f12 = f5 + f9;
            this.f55980c.lineTo(f12, 0.0f);
            this.f55980c.lineTo(f12, f11);
            this.f55980c.lineTo(f4 - f2, f8);
            this.f55980c.lineTo(f4, f7);
            this.f55980c.close();
            this.f55978a = width;
            this.f55979b = height;
        }
        canvas.drawPath(this.f55980c, this.mPaint);
    }
}
