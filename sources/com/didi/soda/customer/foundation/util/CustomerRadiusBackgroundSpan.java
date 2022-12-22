package com.didi.soda.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class CustomerRadiusBackgroundSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f41200a;

    /* renamed from: b */
    private int f41201b;

    /* renamed from: c */
    private int f41202c;

    /* renamed from: d */
    private int f41203d;

    /* renamed from: e */
    private int f41204e;

    /* renamed from: f */
    private int f41205f;

    /* renamed from: g */
    private int f41206g;

    public CustomerRadiusBackgroundSpan(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f41205f = i;
        this.f41201b = i2;
        this.f41203d = i4;
        this.f41204e = i5;
        this.f41202c = i3;
        this.f41206g = i6;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.setTextSize((float) this.f41205f);
        int measureText = (int) (paint.measureText(charSequence, i, i2) + ((float) (this.f41204e * 2)));
        this.f41200a = measureText;
        return measureText;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2 = f;
        Paint paint2 = paint;
        paint2.setColor(this.f41202c);
        paint2.setAntiAlias(true);
        RectF rectF = new RectF(f, (float) (this.f41203d + i3), ((float) this.f41200a) + f2, (float) this.f41206g);
        int i6 = this.f41203d;
        Canvas canvas2 = canvas;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint2);
        paint2.setColor(this.f41201b);
        paint2.setTextSize((float) this.f41205f);
        canvas.drawText(charSequence, i, i2, f2 + ((float) this.f41204e), (float) i4, paint2);
    }
}
