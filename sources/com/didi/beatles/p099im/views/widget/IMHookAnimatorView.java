package com.didi.beatles.p099im.views.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: com.didi.beatles.im.views.widget.IMHookAnimatorView */
public class IMHookAnimatorView extends View {

    /* renamed from: g */
    private static final int f10462g = 16;

    /* renamed from: h */
    private static final int f10463h = 7;

    /* renamed from: a */
    private int f10464a;

    /* renamed from: b */
    private long f10465b;

    /* renamed from: c */
    private float f10466c;

    /* renamed from: d */
    private float f10467d;

    /* renamed from: e */
    private float f10468e;

    /* renamed from: f */
    private float f10469f;

    /* renamed from: i */
    private int f10470i;

    /* renamed from: j */
    private int f10471j;

    /* renamed from: k */
    private int f10472k;

    /* renamed from: l */
    private int f10473l;

    public IMHookAnimatorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMHookAnimatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMHookAnimatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10464a = -16776961;
        this.f10465b = 200;
        this.f10466c = 0.0f;
        this.f10467d = 0.0f;
        this.f10468e = 0.0f;
        this.f10469f = 0.0f;
        this.f10471j = 1;
        this.f10472k = 5;
        m7111a();
    }

    /* renamed from: a */
    private void m7111a() {
        int i = ((int) this.f10465b) / 16;
        this.f10470i = i;
        this.f10471j = i / 7;
        this.f10473l = this.f10472k / 2;
    }

    public void setDuration(long j) {
        this.f10465b = j;
    }

    public void setColor(int i) {
        this.f10464a = i;
    }

    public void setTextWidth(int i) {
        this.f10472k = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(this.f10464a);
        paint.setStrokeWidth((float) this.f10472k);
        paint.setAntiAlias(true);
        int width = getWidth() / 3;
        int height = getHeight() / 2;
        if (this.f10466c == 0.0f && this.f10467d == 0.0f) {
            int i = this.f10471j;
            this.f10466c = (float) ((width / (i * 3)) + 0);
            this.f10467d = (float) ((height / (i * 3)) + height);
        } else {
            float f = this.f10466c;
            if (2.0f + f < ((float) width)) {
                int i2 = this.f10471j;
                this.f10466c = f + ((float) (width / (i2 * 3)));
                this.f10467d += (float) (height / (i2 * 3));
            }
        }
        canvas.drawLine(0.0f, (float) height, this.f10466c, this.f10467d, paint);
        float f2 = (float) width;
        if (this.f10466c + 5.0f > f2) {
            float f3 = this.f10468e;
            if (f3 == 0.0f) {
                int i3 = this.f10471j;
                this.f10468e = (float) ((width / (i3 * 2)) + width);
                this.f10469f = (float) ((height * 2) - (height / (i3 * 2)));
            } else if (f3 != ((float) (width * 3))) {
                int i4 = this.f10471j;
                this.f10468e = f3 + ((float) (width / (i4 * 2)));
                this.f10469f -= (float) (height / (i4 * 2));
            }
            int i5 = this.f10473l;
            canvas.drawLine((float) (width - i5), (float) ((height * 2) + i5), this.f10468e, this.f10469f, paint);
        }
        if (this.f10466c != f2 || this.f10468e != ((float) (width * 3))) {
            postInvalidateDelayed(16);
        }
    }
}
