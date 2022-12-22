package com.didi.soda.customer.widget.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import java.util.regex.Pattern;

public class CountDownNumSpan extends ReplacementSpan {

    /* renamed from: a */
    private float f42230a;

    /* renamed from: b */
    private float f42231b;

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        String replaceAll = Pattern.compile("\\d").matcher(charSequence).replaceAll("0");
        this.f42230a = paint.measureText("0");
        this.f42231b = paint.measureText(":");
        return (int) paint.measureText(replaceAll, i, i2);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2;
        int i6 = i;
        int i7 = i2;
        float f3 = f;
        while (i6 < i7) {
            int i8 = i6 + 1;
            canvas.drawText(charSequence, i6, i8, f3, (float) i4, paint);
            CharSequence charSequence2 = charSequence;
            if (charSequence.charAt(i6) == ':') {
                f2 = this.f42231b;
            } else {
                f2 = this.f42230a;
            }
            f3 += f2;
            i6 = i8;
        }
    }
}
