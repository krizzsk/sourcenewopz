package com.didi.entrega.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.GlobalContext;

public class CustomerSideSpacingSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f20123a;

    /* renamed from: b */
    private int f20124b;

    /* renamed from: c */
    private int f20125c;

    public CustomerSideSpacingSpan(int i, int i2, int i3) {
        this.f20123a = i;
        this.f20124b = i2;
        this.f20125c = i3;
    }

    public CustomerSideSpacingSpan(int i, int i2) {
        this(i, 0, i2);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return ((int) m14825a(paint).measureText(charSequence.subSequence(i, i2).toString())) + (this.f20125c * 2);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        TextPaint a = m14825a(paint);
        Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
        canvas.drawText(subSequence.toString(), f + ((float) this.f20125c), (float) (i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2))), a);
    }

    /* renamed from: a */
    private TextPaint m14825a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize((float) DisplayUtils.dip2px(GlobalContext.getContext(), (float) this.f20123a));
        int i = this.f20124b;
        if (i != 0) {
            textPaint.setColor(i);
        }
        return textPaint;
    }
}
