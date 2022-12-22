package com.didi.soda.customer.foundation.util;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class CustomerTypeFaceSpan extends MetricAffectingSpan {

    /* renamed from: a */
    private Typeface f41232a;

    public CustomerTypeFaceSpan(Typeface typeface) {
        this.f41232a = typeface;
    }

    public void updateDrawState(TextPaint textPaint) {
        m29203a(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        m29203a(textPaint);
    }

    /* renamed from: a */
    private void m29203a(Paint paint) {
        if (this.f41232a != null) {
            Typeface typeface = paint.getTypeface();
            int style = (typeface != null ? typeface.getStyle() : 0) & (~this.f41232a.getStyle());
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.setTypeface(this.f41232a);
        }
    }
}
