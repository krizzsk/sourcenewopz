package com.iproov.sdk.p223ui.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import p093switch.C3125super;

/* renamed from: com.iproov.sdk.ui.views.ReticleView */
public class ReticleView extends View {

    /* renamed from: a */
    private static int f54443a = 5;

    /* renamed from: b */
    private static int f54444b = 20;

    /* renamed from: c */
    private final Paint f54445c = new Paint();

    /* renamed from: d */
    private float f54446d = 120.0f;

    /* renamed from: e */
    private float f54447e = 1.0f;

    /* renamed from: f */
    private C19930do f54448f = C19930do.UNLOCKED;

    /* renamed from: g */
    private final ValueAnimator f54449g = ValueAnimator.ofInt(new int[]{f54443a, f54444b});

    /* renamed from: h */
    private ValueAnimator f54450h;

    /* renamed from: i */
    private ValueAnimator f54451i;

    /* renamed from: j */
    private RectF f54452j = null;

    /* renamed from: k */
    private RectF f54453k = null;

    /* renamed from: l */
    private int f54454l = f54443a;

    /* renamed from: com.iproov.sdk.ui.views.ReticleView$do */
    enum C19930do {
        LOCKED,
        UNLOCKED
    }

    public ReticleView(Context context) {
        super(context);
        m39380a();
    }

    /* renamed from: a */
    private void m39380a() {
        setAlpha(0.0f);
        setWillNotDraw(false);
        this.f54445c.setStyle(Paint.Style.STROKE);
        this.f54445c.setStrokeWidth(10.0f);
        this.f54445c.setStrokeCap(Paint.Cap.ROUND);
        this.f54445c.setAntiAlias(true);
        this.f54449g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ReticleView.this.m39385c(valueAnimator);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m39383b(ValueAnimator valueAnimator) {
        setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: c */
    private void m39384c() {
        RectF rectF = this.f54453k;
        if (rectF == null || rectF.height() == 0.0f) {
            this.f54446d = 120.0f;
        } else {
            this.f54446d = this.f54453k.height() * 0.1f;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m39385c(ValueAnimator valueAnimator) {
        setupDrawRect(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    private void setRect(RectF rectF) {
        this.f54452j = rectF;
        setupDrawRect(f54443a);
    }

    private void setupDrawRect(int i) {
        this.f54454l = i;
        m39382b();
    }

    /* renamed from: case  reason: not valid java name */
    public void m47555case() {
        C19930do doVar = this.f54448f;
        C19930do doVar2 = C19930do.UNLOCKED;
        if (doVar != doVar2) {
            this.f54448f = doVar2;
            this.f54449g.setDuration(100);
            this.f54449g.reverse();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f54453k;
        if (rectF != null && this.f54445c != null) {
            int width = (int) ((rectF.width() * (this.f54447e - 1.0f)) / 2.0f);
            int height = (int) ((this.f54453k.height() * (this.f54447e - 1.0f)) / 2.0f);
            RectF rectF2 = this.f54453k;
            int i = ((int) rectF2.left) - width;
            int i2 = ((int) rectF2.right) + width;
            int i3 = ((int) rectF2.top) - height;
            int i4 = ((int) rectF2.bottom) + height;
            float f = (float) i;
            float f2 = (float) i3;
            Canvas canvas2 = canvas;
            float f3 = f;
            float f4 = f2;
            canvas2.drawLine(f3, f4, f, f2 + this.f54446d, this.f54445c);
            canvas2.drawLine(f3, f4, f + this.f54446d, f2, this.f54445c);
            float f5 = (float) i4;
            float f6 = f5;
            canvas2.drawLine(f3, f6, f, f5 - this.f54446d, this.f54445c);
            canvas2.drawLine(f3, f6, f + this.f54446d, f5, this.f54445c);
            float f7 = (float) i2;
            float f8 = f7;
            float f9 = f2;
            canvas2.drawLine(f8, f9, f7, f2 + this.f54446d, this.f54445c);
            canvas2.drawLine(f8, f9, f7 - this.f54446d, f2, this.f54445c);
            Canvas canvas3 = canvas;
            float f10 = f7;
            float f11 = f5;
            canvas3.drawLine(f10, f11, f7, f5 - this.f54446d, this.f54445c);
            canvas3.drawLine(f10, f11, f7 - this.f54446d, f5, this.f54445c);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f}).setDuration(200);
        this.f54451i = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ReticleView.this.m39383b(valueAnimator);
            }
        });
        mo162215do(true, false);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        setRect(C3125super.m4040do(getWidth(), getHeight(), this.f54447e));
    }

    public void setColor(int i) {
        this.f54445c.setColor(i);
        this.f54445c.setAlpha(255);
        m39382b();
    }

    public void setReticleVisible(boolean z) {
        setVisibility(z ? 0 : 4);
        if (z) {
            setAlpha(1.0f);
        }
    }

    public void setScale(float f) {
        this.f54447e = f;
        m39382b();
    }

    /* renamed from: try  reason: not valid java name */
    public void m47557try() {
        this.f54449g.cancel();
        ValueAnimator valueAnimator = this.f54450h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f54451i;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    /* renamed from: b */
    private void m39382b() {
        RectF rectF = new RectF(this.f54452j);
        this.f54453k = rectF;
        float f = (float) this.f54454l;
        rectF.inset(f, f);
        m39384c();
        invalidate();
    }

    /* renamed from: for  reason: not valid java name */
    public void m47556for() {
        C19930do doVar = this.f54448f;
        C19930do doVar2 = C19930do.LOCKED;
        if (doVar != doVar2) {
            this.f54448f = doVar2;
            this.f54449g.setDuration(200);
            this.f54449g.setStartDelay(50);
            this.f54449g.start();
        }
    }

    /* renamed from: do */
    public void mo162215do(boolean z, boolean z2) {
        ValueAnimator valueAnimator = this.f54451i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z2) {
            setAlpha(z ? 0.0f : 1.0f);
        } else if (z) {
            this.f54451i.start();
        } else {
            this.f54451i.reverse();
        }
    }

    public ReticleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m39380a();
    }

    /* renamed from: do */
    public void mo162214do(int i, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{getAlpha(), 0.0f});
        this.f54450h = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ReticleView.this.m39381a(valueAnimator);
            }
        });
        this.f54450h.setDuration((long) i);
        this.f54450h.setStartDelay((long) i2);
        this.f54450h.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39381a(ValueAnimator valueAnimator) {
        setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public ReticleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m39380a();
    }

    public ReticleView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m39380a();
    }
}
