package com.didi.entrega.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class CenterImageSpan extends ImageSpan {
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_IMAGE_ONLY = 1;

    /* renamed from: a */
    private int f20072a = 0;

    public CenterImageSpan(Drawable drawable) {
        super(drawable);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6;
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i7 = this.f20072a;
        if (i7 == 0) {
            i6 = (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2)) - 4;
        } else {
            i6 = i7 == 1 ? (i5 - drawable.getBounds().bottom) + 4 : 0;
        }
        canvas.save();
        canvas.translate(f, (float) i6);
        drawable.draw(canvas);
        canvas.restore();
    }

    public void setType(int i) {
        this.f20072a = i;
    }
}
