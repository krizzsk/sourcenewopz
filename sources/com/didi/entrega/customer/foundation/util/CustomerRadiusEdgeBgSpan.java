package com.didi.entrega.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.GlobalContext;

public class CustomerRadiusEdgeBgSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f20115a;

    /* renamed from: b */
    private int f20116b;

    /* renamed from: c */
    private int f20117c;

    /* renamed from: d */
    private int f20118d;

    /* renamed from: e */
    private int f20119e;

    /* renamed from: f */
    private int f20120f;

    /* renamed from: g */
    private int f20121g;

    /* renamed from: h */
    private int f20122h = DisplayUtils.dip2px(GlobalContext.getContext(), 0.5f);

    public CustomerRadiusEdgeBgSpan(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f20120f = i;
        this.f20116b = i2;
        this.f20118d = i4;
        this.f20119e = i5;
        this.f20117c = i3;
        this.f20121g = i6;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.setTextSize((float) this.f20120f);
        int measureText = (int) (paint.measureText(charSequence, i, i2) + ((float) (this.f20119e * 2)));
        this.f20115a = measureText;
        return measureText;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2 = f;
        int i6 = i4;
        Paint paint2 = paint;
        paint2.setColor(this.f20117c);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth((float) this.f20122h);
        float f3 = (float) i6;
        RectF rectF = new RectF(f2, paint.ascent() + f3, ((float) this.f20115a) + f2, (f3 + paint.descent()) - (((float) this.f20118d) / 2.0f));
        int i7 = this.f20118d;
        Canvas canvas2 = canvas;
        canvas.drawRoundRect(rectF, (float) i7, (float) i7, paint2);
        paint.reset();
        paint2.setAntiAlias(true);
        paint2.setColor(this.f20116b);
        paint2.setTextSize((float) this.f20120f);
        canvas.drawText(charSequence, i, i2, f2 + ((float) this.f20119e), (float) (i6 - this.f20118d), paint2);
    }
}
