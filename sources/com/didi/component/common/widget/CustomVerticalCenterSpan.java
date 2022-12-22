package com.didi.component.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.didichuxing.publicservice.resourcecontrol.utils.DensityUtil;

public class CustomVerticalCenterSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f11988a;

    /* renamed from: b */
    private Context f11989b;

    /* renamed from: c */
    private int f11990c;

    public CustomVerticalCenterSpan(Context context, int i, int i2) {
        this.f11989b = context;
        this.f11988a = i;
        this.f11990c = i2;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) m8069a(paint).measureText(charSequence.subSequence(i, i2).toString());
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        TextPaint a = m8069a(paint);
        Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
        a.setColor(this.f11990c);
        canvas.drawText(subSequence.toString(), f, (float) (i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2))), a);
    }

    /* renamed from: a */
    private TextPaint m8069a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setColor(this.f11989b.getResources().getColor(17170444));
        textPaint.setTextSize((float) DensityUtil.dip2px(this.f11989b, (float) this.f11988a));
        return textPaint;
    }
}
