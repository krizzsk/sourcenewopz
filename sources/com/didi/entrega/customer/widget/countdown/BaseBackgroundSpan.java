package com.didi.entrega.customer.widget.countdown;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class BaseBackgroundSpan extends ImageSpan {

    /* renamed from: a */
    private Rect f20370a = new Rect();

    /* renamed from: b */
    private int f20371b = 0;

    /* renamed from: c */
    private int f20372c = 0;

    /* renamed from: d */
    private int f20373d = 20;

    /* renamed from: e */
    private int f20374e = 20;

    /* renamed from: f */
    private int f20375f = 20;

    /* renamed from: g */
    private int f20376g = 20;

    /* renamed from: h */
    private int f20377h = -16711936;

    /* renamed from: i */
    private int f20378i = 50;

    public BaseBackgroundSpan(Drawable drawable, int i) {
        super(drawable, i);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.setTextSize((float) this.f20378i);
        paint.getTextBounds(charSequence.toString(), i, i2, this.f20370a);
        this.f20372c = this.f20372c < this.f20370a.width() ? this.f20370a.width() : this.f20372c;
        this.f20371b = this.f20371b < this.f20370a.height() ? this.f20370a.height() : this.f20371b;
        getDrawable().setBounds(0, 0, this.f20372c + this.f20373d + this.f20374e, this.f20375f + this.f20376g + this.f20371b);
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        paint.setColor(this.f20377h);
        paint.setTextSize((float) this.f20378i);
        canvas.drawText(charSequence.subSequence(i, i2).toString(), f + ((float) ((getDrawable().getBounds().width() - this.f20372c) / 2)), (float) ((i4 - ((getDrawable().getBounds().height() - this.f20371b) / 2)) + (this.f20371b / 3)), paint);
    }

    public BaseBackgroundSpan setTimerPadding(int i, int i2, int i3, int i4) {
        this.f20373d = i;
        this.f20374e = i3;
        this.f20376g = i4;
        this.f20375f = i2;
        return this;
    }

    public BaseBackgroundSpan setTimerTextColor(int i) {
        this.f20377h = i;
        return this;
    }

    public BaseBackgroundSpan setTimerTextSize(int i) {
        this.f20378i = i;
        return this;
    }
}
