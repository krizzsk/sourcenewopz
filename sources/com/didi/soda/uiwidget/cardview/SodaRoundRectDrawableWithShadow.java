package com.didi.soda.uiwidget.cardview;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.taxis99.R;

class SodaRoundRectDrawableWithShadow extends Drawable {

    /* renamed from: a */
    static RoundRectHelper f43830a = null;

    /* renamed from: b */
    private static final double f43831b = Math.cos(Math.toRadians(45.0d));

    /* renamed from: c */
    private static final float f43832c = 1.5f;

    /* renamed from: d */
    private final int f43833d;

    /* renamed from: e */
    private float f43834e;

    /* renamed from: f */
    private Paint f43835f;

    /* renamed from: g */
    private Paint f43836g;

    /* renamed from: h */
    private Paint f43837h;

    /* renamed from: i */
    private RectF f43838i;

    /* renamed from: j */
    private float f43839j;

    /* renamed from: k */
    private Path f43840k;

    /* renamed from: l */
    private float f43841l;

    /* renamed from: m */
    private float f43842m;

    /* renamed from: n */
    private float f43843n;

    /* renamed from: o */
    private float f43844o;

    /* renamed from: p */
    private boolean f43845p = true;

    /* renamed from: q */
    private int f43846q;

    /* renamed from: r */
    private int f43847r;

    /* renamed from: s */
    private boolean f43848s = true;

    /* renamed from: t */
    private boolean f43849t = false;

    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public int getOpacity() {
        return -3;
    }

    SodaRoundRectDrawableWithShadow(Resources resources, int i, float f, float f2, float f3, float f4, int i2, int i3) {
        if (i2 != 0) {
            this.f43846q = i2;
        } else {
            this.f43846q = resources.getColor(R.color.soda_cardview_shadow_start_color);
        }
        if (i3 != 0) {
            this.f43847r = i3;
        } else {
            this.f43847r = resources.getColor(R.color.soda_cardview_shadow_end_color);
        }
        this.f43833d = resources.getDimensionPixelSize(R.dimen.ui_widget_4px);
        this.f43834e = f4;
        if (f4 > f2) {
            this.f43834e = f2;
        }
        Paint paint = new Paint(5);
        this.f43835f = paint;
        paint.setColor(i);
        Paint paint2 = new Paint(5);
        this.f43836g = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f43839j = (float) ((int) (f + 0.5f));
        this.f43838i = new RectF();
        Paint paint3 = new Paint(this.f43836g);
        this.f43837h = paint3;
        paint3.setAntiAlias(false);
        mo109125a(f2, f3);
    }

    /* renamed from: a */
    public void mo109128a(boolean z) {
        this.f43848s = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.f43835f.setAlpha(i);
        this.f43836g.setAlpha(i);
        this.f43837h.setAlpha(i);
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) mo109122a(this.f43842m, this.f43839j, this.f43848s));
        int ceil2 = (int) Math.ceil((double) mo109130b(this.f43842m, this.f43839j, this.f43848s));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f43835f.setColorFilter(colorFilter);
    }

    public void draw(Canvas canvas) {
        if (this.f43845p) {
            m31132b(getBounds());
            this.f43845p = false;
        }
        canvas.translate(0.0f, this.f43834e);
        m31131a(canvas);
        canvas.translate(0.0f, -this.f43834e);
        f43830a.drawRoundRect(canvas, this.f43838i, this.f43839j, this.f43835f);
    }

    /* renamed from: a */
    public void mo109126a(int i) {
        this.f43835f.setColor(i);
        invalidateSelf();
    }

    /* renamed from: a */
    public int mo109123a() {
        return this.f43835f.getColor();
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect((int) this.f43838i.left, (int) this.f43838i.top, (int) this.f43838i.right, (int) this.f43838i.bottom, this.f43839j);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f43845p = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo109125a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 >= 0.0f) {
            float e = (float) m31133e(f);
            float e2 = (float) m31133e(f2);
            if (e > e2) {
                if (!this.f43849t) {
                    this.f43849t = true;
                }
                e = e2;
            }
            if (this.f43844o != e || this.f43842m != e2) {
                this.f43844o = e;
                this.f43842m = e2;
                int i = this.f43833d;
                this.f43843n = (float) ((int) ((e * 1.5f) + ((float) i) + 0.5f));
                this.f43841l = e2 + ((float) i);
                this.f43845p = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo109122a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f43831b) * ((double) f2))) : f * 1.5f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo109130b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f43831b) * ((double) f2))) : f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo109124a(float f) {
        if (f >= 0.0f) {
            float f2 = (float) ((int) (f + 0.5f));
            if (this.f43839j != f2) {
                this.f43839j = f2;
                this.f43845p = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo109132b(int i) {
        this.f43846q = i;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo109135c(int i) {
        this.f43847r = i;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo109131b(float f) {
        this.f43834e = f;
        float f2 = this.f43844o;
        if (f > f2) {
            this.f43834e = f2;
        }
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo109129b() {
        return this.f43834e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo109133c() {
        return this.f43846q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo109136d() {
        return this.f43847r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public float mo109139e() {
        return this.f43839j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo109127a(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo109134c(float f) {
        mo109125a(f, this.f43842m);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo109137d(float f) {
        mo109125a(this.f43844o, f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public float mo109140f() {
        return this.f43844o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public float mo109141g() {
        return this.f43842m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public float mo109145h() {
        float f = this.f43842m;
        return (Math.max(f, this.f43839j + ((float) this.f43833d) + (f / 2.0f)) * 2.0f) + ((this.f43842m + ((float) this.f43833d)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public float mo109146i() {
        float f = this.f43842m;
        return (Math.max(f, this.f43839j + ((float) this.f43833d) + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.f43842m * 1.5f) + ((float) this.f43833d)) * 2.0f);
    }

    /* renamed from: e */
    private int m31133e(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    /* renamed from: a */
    private void m31131a(Canvas canvas) {
        float f = this.f43839j;
        float f2 = (-f) - this.f43843n;
        float f3 = f + ((float) this.f43833d) + (this.f43844o / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.f43838i.width() - f4 > 0.0f;
        boolean z2 = this.f43838i.height() - f4 > 0.0f;
        int save = canvas.save();
        canvas.translate(this.f43838i.left + f3, this.f43838i.top + f3);
        canvas.drawPath(this.f43840k, this.f43836g);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f43838i.width() - f4, -this.f43839j, this.f43837h);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f43838i.right - f3, this.f43838i.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f43840k, this.f43836g);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f43838i.width() - f4, (-this.f43839j) + this.f43843n, this.f43837h);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f43838i.left + f3, this.f43838i.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f43840k, this.f43836g);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f43838i.height() - f4, -this.f43839j, this.f43837h);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.f43838i.right - f3, this.f43838i.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f43840k, this.f43836g);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f43838i.height() - f4, -this.f43839j, this.f43837h);
        }
        canvas.restoreToCount(save4);
    }

    /* renamed from: j */
    private void m31134j() {
        float f = this.f43839j;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.f43843n;
        rectF2.inset(-f2, -f2);
        Path path = this.f43840k;
        if (path == null) {
            this.f43840k = new Path();
        } else {
            path.reset();
        }
        this.f43840k.setFillType(Path.FillType.EVEN_ODD);
        this.f43840k.moveTo(-this.f43839j, 0.0f);
        this.f43840k.rLineTo(-this.f43843n, 0.0f);
        this.f43840k.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f43840k.arcTo(rectF, 270.0f, -90.0f, false);
        this.f43840k.close();
        float f3 = this.f43839j;
        float f4 = f3 / (this.f43843n + f3);
        Paint paint = this.f43836g;
        float f5 = this.f43839j + this.f43843n;
        int i = this.f43846q;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.f43847r}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f43837h;
        float f6 = this.f43839j;
        float f7 = this.f43843n;
        int i2 = this.f43846q;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i2, i2, this.f43847r}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f43837h.setAntiAlias(false);
    }

    /* renamed from: b */
    private void m31132b(Rect rect) {
        float f = this.f43842m * 1.5f;
        this.f43838i.set(((float) rect.left) + this.f43842m, ((float) rect.top) + f, ((float) rect.right) - this.f43842m, ((float) rect.bottom) - f);
        m31134j();
    }
}
