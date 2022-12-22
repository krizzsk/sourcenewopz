package com.didi.entrega.customer.foundation.util;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class CustomerTypeFaceSpan extends MetricAffectingSpan {

    /* renamed from: a */
    private Typeface f20131a;

    public CustomerTypeFaceSpan(Typeface typeface) {
        this.f20131a = typeface;
    }

    public void updateDrawState(TextPaint textPaint) {
        m14829a(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        m14829a(textPaint);
    }

    /* renamed from: a */
    private void m14829a(Paint paint) {
        if (this.f20131a != null) {
            Typeface typeface = paint.getTypeface();
            int style = (typeface != null ? typeface.getStyle() : 0) & (~this.f20131a.getStyle());
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.setTypeface(this.f20131a);
        }
    }
}
