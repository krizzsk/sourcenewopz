package com.didi.component.driverbar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.didi.component.business.util.UiUtils;

public class CustomVerticalCenterSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f13017a;

    /* renamed from: b */
    private Context f13018b;

    public CustomVerticalCenterSpan(Context context, int i) {
        this.f13017a = i;
        this.f13018b = context;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) m8823a(paint).measureText(charSequence.subSequence(i, i2).toString());
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        TextPaint a = m8823a(paint);
        Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
        canvas.drawText(subSequence.toString(), f, (float) (i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2))), a);
    }

    /* renamed from: a */
    private TextPaint m8823a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize((float) UiUtils.dip2px(this.f13018b, (float) this.f13017a));
        return textPaint;
    }
}
