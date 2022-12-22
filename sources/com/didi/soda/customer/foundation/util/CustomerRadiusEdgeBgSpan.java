package com.didi.soda.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;

public class CustomerRadiusEdgeBgSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f41207a;

    /* renamed from: b */
    private int f41208b;

    /* renamed from: c */
    private int f41209c;

    /* renamed from: d */
    private int f41210d;

    /* renamed from: e */
    private int f41211e;

    /* renamed from: f */
    private int f41212f;

    /* renamed from: g */
    private int f41213g;

    /* renamed from: h */
    private int f41214h = DisplayUtils.dip2px(GlobalContext.getContext(), 0.5f);

    public CustomerRadiusEdgeBgSpan(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f41212f = i;
        this.f41208b = i2;
        this.f41210d = i4;
        this.f41211e = i5;
        this.f41209c = i3;
        this.f41213g = i6;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.setTextSize((float) this.f41212f);
        int measureText = (int) (paint.measureText(charSequence, i, i2) + ((float) (this.f41211e * 2)));
        this.f41207a = measureText;
        return measureText;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2 = f;
        int i6 = i4;
        Paint paint2 = paint;
        paint2.setColor(this.f41209c);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth((float) this.f41214h);
        float f3 = (float) i6;
        RectF rectF = new RectF(f2, paint.ascent() + f3, ((float) this.f41207a) + f2, (f3 + paint.descent()) - (((float) this.f41210d) / 2.0f));
        int i7 = this.f41210d;
        Canvas canvas2 = canvas;
        canvas.drawRoundRect(rectF, (float) i7, (float) i7, paint2);
        paint.reset();
        paint2.setAntiAlias(true);
        paint2.setColor(this.f41208b);
        paint2.setTextSize((float) this.f41212f);
        canvas.drawText(charSequence, i, i2, f2 + ((float) this.f41211e), (float) (i6 - this.f41210d), paint2);
    }
}
