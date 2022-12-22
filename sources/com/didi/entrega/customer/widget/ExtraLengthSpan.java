package com.didi.entrega.customer.widget;

import android.graphics.Paint;
import android.os.Build;
import android.text.Spanned;
import android.text.style.LineHeightSpan;

public class ExtraLengthSpan implements LineHeightSpan {

    /* renamed from: a */
    private final int f20307a;

    /* renamed from: b */
    private final int f20308b;

    public ExtraLengthSpan(int i, int i2) {
        this.f20307a = i;
        this.f20308b = i2;
    }

    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 23 && i != ((Spanned) charSequence).getSpanStart(this)) {
            z = false;
        }
        if (z) {
            if (this.f20307a != 0) {
                fontMetricsInt.top -= this.f20307a;
                fontMetricsInt.ascent = fontMetricsInt.top;
            }
            if (this.f20308b != 0) {
                fontMetricsInt.bottom += this.f20308b;
                fontMetricsInt.descent = fontMetricsInt.bottom;
            }
        }
    }
}
