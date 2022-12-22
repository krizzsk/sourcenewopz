package com.didi.global.globaluikit.richinfo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.view.ViewGroup;

public class CustomViewSpan extends ReplacementSpan {
    protected View view;

    public CustomViewSpan(View view2) {
        this.view = view2;
        view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        this.view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        View view2 = this.view;
        view2.layout(0, 0, view2.getMeasuredWidth(), this.view.getMeasuredHeight());
        if (fontMetricsInt != null) {
            int measuredHeight = this.view.getMeasuredHeight();
            int i3 = (-measuredHeight) / 2;
            fontMetricsInt.top = i3;
            fontMetricsInt.ascent = i3;
            int i4 = measuredHeight / 2;
            fontMetricsInt.bottom = i4;
            fontMetricsInt.descent = i4;
        }
        return this.view.getRight();
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.save();
        canvas.translate(f, (float) (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (this.view.getMeasuredHeight() / 2)));
        this.view.draw(canvas);
        canvas.restore();
    }
}
