package com.didi.soda.customer.widget;

import android.graphics.Paint;
import android.os.Build;
import android.text.Spanned;
import android.text.style.LineHeightSpan;

public class ExtraLengthSpan implements LineHeightSpan {

    /* renamed from: a */
    private final int f41534a;

    /* renamed from: b */
    private final int f41535b;

    public ExtraLengthSpan(int i, int i2) {
        this.f41534a = i;
        this.f41535b = i2;
    }

    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 23 && i != ((Spanned) charSequence).getSpanStart(this)) {
            z = false;
        }
        if (z) {
            if (this.f41534a != 0) {
                fontMetricsInt.top -= this.f41534a;
                fontMetricsInt.ascent = fontMetricsInt.top;
            }
            if (this.f41535b != 0) {
                fontMetricsInt.bottom += this.f41535b;
                fontMetricsInt.descent = fontMetricsInt.bottom;
            }
        }
    }
}
