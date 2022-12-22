package com.didi.entrega.customer.foundation.util;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

public class CustomerFixLineHeightSpan implements LineHeightSpan {

    /* renamed from: a */
    private final int f20107a;

    public CustomerFixLineHeightSpan(int i) {
        this.f20107a = i;
    }

    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        int i5 = fontMetricsInt.descent - fontMetricsInt.ascent;
        if (i5 > 0) {
            fontMetricsInt.descent = Math.round(((float) fontMetricsInt.descent) * ((((float) this.f20107a) * 1.0f) / ((float) i5)));
            fontMetricsInt.ascent = fontMetricsInt.descent - this.f20107a;
        }
    }
}
