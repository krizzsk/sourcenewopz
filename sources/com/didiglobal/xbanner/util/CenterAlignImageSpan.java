package com.didiglobal.xbanner.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class CenterAlignImageSpan extends ImageSpan {

    /* renamed from: a */
    int f51591a = 0;

    public CenterAlignImageSpan(Drawable drawable, int i) {
        super(drawable);
        this.f51591a = i;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i6 = ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
        canvas.save();
        canvas.translate(f + ((float) this.f51591a), (float) i6);
        drawable.draw(canvas);
        canvas.restore();
    }
}
