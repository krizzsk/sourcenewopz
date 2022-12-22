package com.didi.entrega.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class CustomerRadiusBackgroundSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f20108a;

    /* renamed from: b */
    private int f20109b;

    /* renamed from: c */
    private int f20110c;

    /* renamed from: d */
    private int f20111d;

    /* renamed from: e */
    private int f20112e;

    /* renamed from: f */
    private int f20113f;

    /* renamed from: g */
    private int f20114g;

    public CustomerRadiusBackgroundSpan(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f20113f = i;
        this.f20109b = i2;
        this.f20111d = i4;
        this.f20112e = i5;
        this.f20110c = i3;
        this.f20114g = i6;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.setTextSize((float) this.f20113f);
        int measureText = (int) (paint.measureText(charSequence, i, i2) + ((float) (this.f20112e * 2)));
        this.f20108a = measureText;
        return measureText;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2 = f;
        Paint paint2 = paint;
        paint2.setColor(this.f20110c);
        paint2.setAntiAlias(true);
        RectF rectF = new RectF(f, (float) (this.f20111d + i3), ((float) this.f20108a) + f2, (float) this.f20114g);
        int i6 = this.f20111d;
        Canvas canvas2 = canvas;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint2);
        paint2.setColor(this.f20109b);
        paint2.setTextSize((float) this.f20113f);
        canvas.drawText(charSequence, i, i2, f2 + ((float) this.f20112e), (float) i4, paint2);
    }
}
