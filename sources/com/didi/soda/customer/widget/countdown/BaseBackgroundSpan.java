package com.didi.soda.customer.widget.countdown;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class BaseBackgroundSpan extends ImageSpan {

    /* renamed from: a */
    private Rect f41661a = new Rect();

    /* renamed from: b */
    private int f41662b = 0;

    /* renamed from: c */
    private int f41663c = 0;

    /* renamed from: d */
    private int f41664d = 20;

    /* renamed from: e */
    private int f41665e = 20;

    /* renamed from: f */
    private int f41666f = 20;

    /* renamed from: g */
    private int f41667g = 20;

    /* renamed from: h */
    private int f41668h = -16711936;

    /* renamed from: i */
    private int f41669i = 50;

    public BaseBackgroundSpan(Drawable drawable, int i) {
        super(drawable, i);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.setTextSize((float) this.f41669i);
        paint.getTextBounds(charSequence.toString(), i, i2, this.f41661a);
        this.f41663c = this.f41663c < this.f41661a.width() ? this.f41661a.width() : this.f41663c;
        this.f41662b = this.f41662b < this.f41661a.height() ? this.f41661a.height() : this.f41662b;
        getDrawable().setBounds(0, 0, this.f41663c + this.f41664d + this.f41665e, this.f41666f + this.f41667g + this.f41662b);
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        paint.setColor(this.f41668h);
        paint.setTextSize((float) this.f41669i);
        canvas.drawText(charSequence.subSequence(i, i2).toString(), f + ((float) ((getDrawable().getBounds().width() - this.f41663c) / 2)), (float) ((i4 - ((getDrawable().getBounds().height() - this.f41662b) / 2)) + (this.f41662b / 3)), paint);
    }

    public BaseBackgroundSpan setTimerPadding(int i, int i2, int i3, int i4) {
        this.f41664d = i;
        this.f41665e = i3;
        this.f41667g = i4;
        this.f41666f = i2;
        return this;
    }

    public BaseBackgroundSpan setTimerTextColor(int i) {
        this.f41668h = i;
        return this;
    }

    public BaseBackgroundSpan setTimerTextSize(int i) {
        this.f41669i = i;
        return this;
    }
}
