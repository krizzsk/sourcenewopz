package com.didi.global.fintech.cashier.p117ui.widget.tickerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.didi.global.fintech.cashier.p117ui.widget.tickerview.TickerCharacterList;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerColumn */
public class TickerColumn {

    /* renamed from: a */
    private TickerCharacterList[] f21968a;

    /* renamed from: b */
    private final TickerDrawMetrics f21969b;

    /* renamed from: c */
    private char f21970c = 0;

    /* renamed from: d */
    private char f21971d = 0;

    /* renamed from: e */
    private char[] f21972e;

    /* renamed from: f */
    private int f21973f;

    /* renamed from: g */
    private int f21974g;

    /* renamed from: h */
    private int f21975h;

    /* renamed from: i */
    private float f21976i;

    /* renamed from: j */
    private float f21977j;

    /* renamed from: k */
    private float f21978k;

    /* renamed from: l */
    private float f21979l;

    /* renamed from: m */
    private float f21980m;

    /* renamed from: n */
    private float f21981n;

    /* renamed from: o */
    private float f21982o;

    /* renamed from: p */
    private float f21983p;

    /* renamed from: q */
    private int f21984q;

    TickerColumn(TickerCharacterList[] tickerCharacterListArr, TickerDrawMetrics tickerDrawMetrics) {
        this.f21968a = tickerCharacterListArr;
        this.f21969b = tickerDrawMetrics;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66283a(TickerCharacterList[] tickerCharacterListArr) {
        this.f21968a = tickerCharacterListArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66280a(char c) {
        this.f21971d = c;
        this.f21978k = this.f21979l;
        float a = this.f21969b.mo66297a(c);
        this.f21980m = a;
        this.f21981n = Math.max(this.f21978k, a);
        m15921f();
        int i = 1;
        if (!(this.f21974g >= this.f21973f)) {
            i = -1;
        }
        this.f21984q = i;
        this.f21983p = this.f21982o;
        this.f21982o = 0.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public char mo66279a() {
        return this.f21970c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public char mo66284b() {
        return this.f21971d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo66285c() {
        m15922g();
        return this.f21979l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public float mo66286d() {
        m15922g();
        return this.f21981n;
    }

    /* renamed from: f */
    private void m15921f() {
        this.f21972e = null;
        for (TickerCharacterList tickerCharacterList : this.f21968a) {
            TickerCharacterList.CharacterIndices a = tickerCharacterList.mo66276a(this.f21970c, this.f21971d, this.f21969b.mo66302d());
            if (a != null) {
                this.f21972e = tickerCharacterList.mo66278b();
                this.f21973f = a.startIndex;
                this.f21974g = a.endIndex;
            }
        }
        if (this.f21972e == null) {
            char c = this.f21970c;
            char c2 = this.f21971d;
            if (c == c2) {
                this.f21972e = new char[]{c};
                this.f21974g = 0;
                this.f21973f = 0;
                return;
            }
            this.f21972e = new char[]{c, c2};
            this.f21973f = 0;
            this.f21974g = 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo66287e() {
        m15922g();
        this.f21981n = this.f21979l;
    }

    /* renamed from: g */
    private void m15922g() {
        float a = this.f21969b.mo66297a(this.f21971d);
        float f = this.f21979l;
        float f2 = this.f21980m;
        if (f == f2 && f2 != a) {
            this.f21980m = a;
            this.f21979l = a;
            this.f21981n = a;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66281a(float f) {
        if (f == 1.0f) {
            this.f21970c = this.f21971d;
            this.f21982o = 0.0f;
            this.f21983p = 0.0f;
        }
        float b = this.f21969b.mo66300b();
        float abs = ((((float) Math.abs(this.f21974g - this.f21973f)) * b) * f) / b;
        int i = (int) abs;
        float f2 = this.f21983p * (1.0f - f);
        int i2 = this.f21984q;
        this.f21976i = ((abs - ((float) i)) * b * ((float) i2)) + f2;
        this.f21975h = this.f21973f + (i * i2);
        this.f21977j = b;
        float f3 = this.f21978k;
        this.f21979l = f3 + ((this.f21980m - f3) * f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66282a(Canvas canvas, Paint paint) {
        if (m15920a(canvas, paint, this.f21972e, this.f21975h, this.f21976i)) {
            int i = this.f21975h;
            if (i >= 0) {
                this.f21970c = this.f21972e[i];
            }
            this.f21982o = this.f21976i;
        }
        m15920a(canvas, paint, this.f21972e, this.f21975h + 1, this.f21976i - this.f21977j);
        m15920a(canvas, paint, this.f21972e, this.f21975h - 1, this.f21976i + this.f21977j);
    }

    /* renamed from: a */
    private boolean m15920a(Canvas canvas, Paint paint, char[] cArr, int i, float f) {
        if (i < 0 || i >= cArr.length) {
            return false;
        }
        canvas.drawText(cArr, i, 1, 0.0f, f, paint);
        return true;
    }
}
