package com.didi.component.estimate.newui.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class DynamicArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_BOTTOM = 3;
    public static final int ARROW_DIRECTION_LEFT = 4;
    public static final int ARROW_DIRECTION_RIGHT = 2;
    public static final int ARROW_DIRECTION_TOP = 1;

    /* renamed from: a */
    private float f13044a;

    /* renamed from: b */
    private float f13045b;

    /* renamed from: c */
    private float f13046c;

    /* renamed from: d */
    private float f13047d;

    /* renamed from: e */
    private float f13048e;

    /* renamed from: f */
    private float f13049f;

    /* renamed from: g */
    private float f13050g;

    /* renamed from: h */
    private float f13051h;

    /* renamed from: i */
    private RectF f13052i = new RectF();

    /* renamed from: j */
    private RectF f13053j = new RectF();

    /* renamed from: k */
    private RectF f13054k = new RectF();

    /* renamed from: l */
    private RectF f13055l = new RectF();

    /* renamed from: m */
    private int f13056m = 3;

    /* renamed from: n */
    private float f13057n;

    /* renamed from: o */
    private float f13058o;

    /* renamed from: p */
    private float f13059p;

    /* renamed from: q */
    private float f13060q;

    /* renamed from: r */
    private Drawable f13061r;

    /* renamed from: s */
    private Rect f13062s;

    /* renamed from: t */
    private RectF f13063t = new RectF();

    /* renamed from: u */
    private Path f13064u = new Path();

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f13062s = rect;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        m8865a(this.f13063t);
        this.f13064u.reset();
        this.f13064u.moveTo(m8869c(), m8873e());
        m8866a(this.f13064u);
        this.f13064u.arcTo(m8874f(), 270.0f, 90.0f);
        m8868b(this.f13064u);
        this.f13064u.arcTo(m8878j(), 0.0f, 90.0f);
        m8870c(this.f13064u);
        this.f13064u.arcTo(m8882n(), 90.0f, 90.0f);
        m8872d(this.f13064u);
        this.f13064u.arcTo(m8886r(), 180.0f, 90.0f);
        this.f13064u.close();
        canvas.clipPath(this.f13064u);
        Rect rect = this.f13062s;
        if (rect != null) {
            this.f13061r.setBounds(rect);
        } else {
            this.f13061r.setBounds(getBounds());
        }
        this.f13061r.draw(canvas);
    }

    public void setSrcDrawable(Drawable drawable) {
        this.f13061r = drawable;
        invalidateSelf();
    }

    public void setMargin(float f) {
        this.f13045b = f;
        this.f13046c = f;
        this.f13047d = f;
        this.f13044a = f;
        invalidateSelf();
    }

    public void setMargin(float f, float f2, float f3, float f4) {
        this.f13045b = f;
        this.f13046c = f2;
        this.f13047d = f3;
        this.f13044a = f4;
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        if (f >= 0.0f) {
            this.f13048e = f;
            this.f13049f = f;
            this.f13050g = f;
            this.f13051h = f;
            invalidateSelf();
        }
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.f13048e = f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f13049f = f2;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        this.f13050g = f3;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        this.f13051h = f4;
        invalidateSelf();
    }

    public void setArrow(int i, float f, float f2, float f3, float f4) {
        this.f13056m = i;
        this.f13057n = f;
        this.f13058o = f2;
        this.f13059p = f3;
        this.f13060q = f4;
        invalidateSelf();
    }

    /* renamed from: a */
    private RectF m8865a(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        rectF.top = ((float) this.f13062s.top) + this.f13045b + m8864a(1);
        rectF.right = (((float) this.f13062s.right) - this.f13046c) - m8864a(2);
        rectF.bottom = (((float) this.f13062s.bottom) - this.f13047d) - m8864a(3);
        rectF.left = ((float) this.f13062s.left) + this.f13044a + m8864a(4);
        return rectF;
    }

    /* renamed from: a */
    private float m8864a(int i) {
        if (i == this.f13056m) {
            return this.f13060q;
        }
        return 0.0f;
    }

    /* renamed from: a */
    private float m8863a() {
        float f = this.f13063t.right - this.f13063t.left;
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* renamed from: b */
    private float m8867b() {
        float f = this.f13063t.bottom - this.f13063t.top;
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* renamed from: a */
    private void m8866a(Path path) {
        float c = m8869c();
        float d = m8871d();
        float e = m8873e();
        if (this.f13056m == 1) {
            float f = this.f13059p;
            if (f > 0.0f && this.f13060q > 0.0f) {
                float f2 = this.f13057n;
                if (f2 - (f / 2.0f) > c && (f / 2.0f) + f2 < d) {
                    path.lineTo(f2 - (f / 2.0f), e);
                    path.lineTo(this.f13057n, e - this.f13060q);
                    path.lineTo(this.f13057n + (this.f13059p / 2.0f), e);
                    path.lineTo(d, e);
                    return;
                }
            }
        }
        path.lineTo(d, e);
    }

    /* renamed from: b */
    private void m8868b(Path path) {
        float h = m8876h();
        float i = m8877i();
        float g = m8875g();
        if (this.f13056m == 2) {
            float f = this.f13059p;
            if (f > 0.0f && this.f13060q > 0.0f) {
                float f2 = this.f13058o;
                if (f2 - (f / 2.0f) > h && (f / 2.0f) + f2 < i) {
                    path.lineTo(g, f2 - (f / 2.0f));
                    path.lineTo(this.f13060q + g, this.f13058o);
                    path.lineTo(g, this.f13058o + (this.f13059p / 2.0f));
                    path.lineTo(g, i);
                    return;
                }
            }
        }
        path.lineTo(g, i);
    }

    /* renamed from: c */
    private void m8870c(Path path) {
        float l = m8880l();
        float k = m8879k();
        float m = m8881m();
        if (this.f13056m == 3) {
            float f = this.f13059p;
            if (f > 0.0f && this.f13060q > 0.0f) {
                float f2 = this.f13057n;
                if (f2 - (f / 2.0f) > l && (f / 2.0f) + f2 < k) {
                    path.lineTo(f2 + (f / 2.0f), m);
                    path.lineTo(this.f13057n, this.f13060q + m);
                    path.lineTo(this.f13057n - (this.f13059p / 2.0f), m);
                    path.lineTo(l, m);
                    return;
                }
            }
        }
        path.lineTo(l, m);
    }

    /* renamed from: d */
    private void m8872d(Path path) {
        float q = m8885q();
        float p = m8884p();
        float o = m8883o();
        if (this.f13056m == 4) {
            float f = this.f13059p;
            if (f > 0.0f && this.f13060q > 0.0f) {
                float f2 = this.f13058o;
                if (f2 - (f / 2.0f) > q && (f / 2.0f) + f2 < p) {
                    path.lineTo(o, f2 + (f / 2.0f));
                    path.lineTo(o - this.f13060q, this.f13058o);
                    path.lineTo(o, this.f13058o - (this.f13059p / 2.0f));
                    path.lineTo(o, q);
                    return;
                }
            }
        }
        path.lineTo(o, q);
    }

    /* renamed from: c */
    private float m8869c() {
        float a = m8863a();
        if (a > 0.0f) {
            return this.f13063t.left + Math.min(this.f13048e, a / 2.0f);
        }
        return (float) this.f13062s.left;
    }

    /* renamed from: d */
    private float m8871d() {
        float a = m8863a();
        if (a > 0.0f) {
            return this.f13063t.right - Math.min(this.f13049f, a / 2.0f);
        }
        return (float) this.f13062s.right;
    }

    /* renamed from: e */
    private float m8873e() {
        if (m8867b() > 0.0f) {
            return this.f13063t.top;
        }
        return (float) this.f13062s.top;
    }

    /* renamed from: f */
    private RectF m8874f() {
        float a = m8863a();
        float b = m8867b();
        if (a > 0.0f && b > 0.0f) {
            this.f13053j.right = this.f13063t.right;
            RectF rectF = this.f13053j;
            rectF.left = rectF.right - Math.min(this.f13049f * 2.0f, a);
            this.f13053j.top = this.f13063t.top;
            RectF rectF2 = this.f13053j;
            rectF2.bottom = rectF2.top + Math.min(this.f13049f * 2.0f, b);
        }
        return this.f13053j;
    }

    /* renamed from: g */
    private float m8875g() {
        if (m8863a() > 0.0f) {
            return this.f13063t.right;
        }
        return (float) this.f13062s.right;
    }

    /* renamed from: h */
    private float m8876h() {
        float b = m8867b();
        if (b > 0.0f) {
            return this.f13063t.top + Math.min(this.f13049f, b / 2.0f);
        }
        return (float) this.f13062s.top;
    }

    /* renamed from: i */
    private float m8877i() {
        float b = m8867b();
        if (b > 0.0f) {
            return this.f13063t.bottom - Math.min(this.f13051h, b / 2.0f);
        }
        return (float) this.f13062s.bottom;
    }

    /* renamed from: j */
    private RectF m8878j() {
        float a = m8863a();
        float b = m8867b();
        if (a > 0.0f && b > 0.0f) {
            this.f13055l.right = this.f13063t.right;
            RectF rectF = this.f13055l;
            rectF.left = rectF.right - Math.min(this.f13051h * 2.0f, a);
            this.f13055l.bottom = this.f13063t.bottom;
            RectF rectF2 = this.f13055l;
            rectF2.top = rectF2.bottom - Math.min(this.f13051h * 2.0f, b);
        }
        return this.f13055l;
    }

    /* renamed from: k */
    private float m8879k() {
        float a = m8863a();
        if (a > 0.0f) {
            return this.f13063t.right - Math.min(this.f13051h, a / 2.0f);
        }
        return (float) this.f13062s.right;
    }

    /* renamed from: l */
    private float m8880l() {
        float a = m8863a();
        if (a > 0.0f) {
            return this.f13063t.left + Math.min(this.f13050g, a / 2.0f);
        }
        return (float) this.f13062s.left;
    }

    /* renamed from: m */
    private float m8881m() {
        if (m8867b() > 0.0f) {
            return this.f13063t.bottom;
        }
        return (float) this.f13062s.bottom;
    }

    /* renamed from: n */
    private RectF m8882n() {
        float a = m8863a();
        float b = m8867b();
        if (a > 0.0f && b > 0.0f) {
            this.f13054k.left = this.f13063t.left;
            RectF rectF = this.f13054k;
            rectF.right = rectF.left + Math.min(this.f13050g * 2.0f, a);
            this.f13054k.bottom = this.f13063t.bottom;
            RectF rectF2 = this.f13054k;
            rectF2.top = rectF2.bottom - Math.min(this.f13050g * 2.0f, b);
        }
        return this.f13054k;
    }

    /* renamed from: o */
    private float m8883o() {
        if (m8863a() > 0.0f) {
            return this.f13063t.left;
        }
        return (float) this.f13062s.left;
    }

    /* renamed from: p */
    private float m8884p() {
        float b = m8867b();
        if (b > 0.0f) {
            return this.f13063t.bottom - Math.min(this.f13050g, b / 2.0f);
        }
        return (float) this.f13062s.bottom;
    }

    /* renamed from: q */
    private float m8885q() {
        float b = m8867b();
        if (b > 0.0f) {
            return this.f13063t.top + Math.min(this.f13048e, b / 2.0f);
        }
        return (float) this.f13062s.top;
    }

    /* renamed from: r */
    private RectF m8886r() {
        float a = m8863a();
        float b = m8867b();
        if (a > 0.0f && b > 0.0f) {
            this.f13052i.left = this.f13063t.left;
            RectF rectF = this.f13052i;
            rectF.right = rectF.left + Math.min(this.f13048e * 2.0f, a);
            this.f13052i.top = this.f13063t.top;
            RectF rectF2 = this.f13052i;
            rectF2.bottom = rectF2.top + Math.min(this.f13048e * 2.0f, b);
        }
        return this.f13052i;
    }
}
