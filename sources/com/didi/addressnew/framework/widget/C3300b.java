package com.didi.addressnew.framework.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;

/* renamed from: com.didi.addressnew.framework.widget.b */
/* compiled from: Dot */
class C3300b {

    /* renamed from: a */
    int f7431a = 0;

    /* renamed from: b */
    public int f7432b;

    /* renamed from: c */
    float f7433c;

    /* renamed from: d */
    float f7434d;

    /* renamed from: e */
    int f7435e;

    /* renamed from: f */
    ValueAnimator f7436f;

    /* renamed from: g */
    ValueAnimator f7437g;

    /* renamed from: h */
    private Paint f7438h;

    /* renamed from: i */
    private Integer[] f7439i;

    C3300b(DotLoader dotLoader, int i, int i2) {
        this.f7435e = i2;
        this.f7439i = dotLoader.f7417a;
        this.f7432b = i;
        Paint paint = new Paint(1);
        this.f7438h = paint;
        paint.setColor(this.f7439i[this.f7431a].intValue());
        this.f7438h.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo39117a(int i) {
        this.f7431a = i;
        this.f7438h.setColor(this.f7439i[i].intValue());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo39120b(int i) {
        this.f7438h.setColor(i);
    }

    /* renamed from: d */
    private int m4672d() {
        return this.f7439i[this.f7431a].intValue();
    }

    /* renamed from: a */
    public int mo39116a() {
        mo39121c();
        return m4672d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo39119b() {
        int i = this.f7431a + 1;
        this.f7431a = i;
        if (i >= this.f7439i.length) {
            this.f7431a = 0;
        }
        this.f7438h.setColor(this.f7439i[this.f7431a].intValue());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo39121c() {
        int i = this.f7431a + 1;
        this.f7431a = i;
        if (i >= this.f7439i.length) {
            this.f7431a = 0;
        }
        return this.f7431a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo39118a(Canvas canvas) {
        canvas.drawCircle(this.f7433c, this.f7434d, (float) this.f7432b, this.f7438h);
    }
}
