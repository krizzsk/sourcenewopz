package com.iproov.sdk.p223ui.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import p091static.C3087do;
import p091static.C3088if;
import p093switch.C3125super;

/* renamed from: com.iproov.sdk.ui.views.OverlayView */
public class OverlayView extends ViewGroup {

    /* renamed from: a */
    private RectF f54427a;

    /* renamed from: b */
    private RectF f54428b;

    /* renamed from: c */
    private float f54429c = 1.0f;

    /* renamed from: d */
    private boolean f54430d = true;

    /* renamed from: e */
    private final Paint f54431e = new Paint();

    /* renamed from: f */
    private final Paint f54432f = new Paint();

    /* renamed from: g */
    private final Paint f54433g = new Paint();

    /* renamed from: h */
    private C3088if f54434h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ValueAnimator f54435i;

    /* renamed from: j */
    private ValueAnimator f54436j;

    /* renamed from: k */
    private ValueAnimator f54437k;

    /* renamed from: l */
    private ValueAnimator f54438l;

    /* renamed from: com.iproov.sdk.ui.views.OverlayView$do */
    class C19928do extends C3087do {

        /* renamed from: do */
        final /* synthetic */ Runnable f54439do;

        C19928do(Runnable runnable) {
            this.f54439do = runnable;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ValueAnimator unused = OverlayView.this.f54435i = null;
            this.f54439do.run();
        }
    }

    /* renamed from: com.iproov.sdk.ui.views.OverlayView$if */
    class C19929if extends C3087do {

        /* renamed from: do */
        final /* synthetic */ Runnable f54441do;

        C19929if(OverlayView overlayView, Runnable runnable) {
            this.f54441do = runnable;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f54441do.run();
        }
    }

    public OverlayView(Context context) {
        super(context);
        m39367a();
    }

    /* renamed from: b */
    private void m39369b() {
        this.f54427a = C3125super.m4040do(getWidth(), getHeight(), this.f54429c);
        RectF rectF = new RectF(this.f54427a);
        this.f54428b = rectF;
        rectF.inset(20.0f, 20.0f);
        this.f54434h.setDrawRect(this.f54428b);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m39371c(ValueAnimator valueAnimator) {
        this.f54434h.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m39372d(ValueAnimator valueAnimator) {
        setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f54432f);
        if (this.f54430d) {
            canvas.drawOval(this.f54428b, this.f54433g);
            canvas.drawOval(this.f54428b, this.f54431e);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        C3088if ifVar = new C3088if(getContext());
        this.f54434h = ifVar;
        addView(ifVar, new ViewGroup.LayoutParams(-1, -1));
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f}).setDuration(200);
        this.f54438l = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OverlayView.this.m39372d(valueAnimator);
            }
        });
        setOvalVisible(false);
        mo162199do(true, false);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(0, 0, getWidth(), getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m39369b();
    }

    public void setBGColor(int i) {
        this.f54432f.setColor(i);
        if (i != ContextCompat.getColor(getContext(), 17170445)) {
            this.f54432f.setAlpha(76);
        }
        invalidate();
    }

    public void setFGColor(int i) {
        this.f54431e.setColor(i);
        this.f54431e.setAlpha(255);
        invalidate();
        this.f54434h.setColor(i);
    }

    public void setOvalVisible(boolean z) {
        this.f54430d = z;
    }

    public void setScale(float f) {
        this.f54429c = f;
        m39369b();
        invalidate();
    }

    public void setScanLineType(C19931do doVar) {
        this.f54434h.setScanlineType(doVar);
    }

    /* renamed from: a */
    private void m39367a() {
        setAlpha(0.0f);
        setWillNotDraw(false);
        this.f54431e.setStyle(Paint.Style.STROKE);
        this.f54431e.setStrokeWidth(10.0f);
        this.f54431e.setStrokeCap(Paint.Cap.ROUND);
        this.f54431e.setAntiAlias(true);
        this.f54432f.setAlpha(0);
        this.f54433g.setStyle(Paint.Style.FILL);
        this.f54433g.setColor(0);
        this.f54433g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        setLayerType(1, (Paint) null);
        invalidate();
    }

    /* renamed from: for  reason: not valid java name */
    public void m47554for() {
        ValueAnimator valueAnimator = this.f54435i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f54436j;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator3 = this.f54437k;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        ValueAnimator valueAnimator4 = this.f54438l;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
        }
        C3088if ifVar = this.f54434h;
        if (ifVar != null) {
            ifVar.m46186for();
        }
    }

    /* renamed from: if */
    public void mo162201if(boolean z, boolean z2) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.f54437k;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        } else if (z) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
            this.f54437k = duration;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    OverlayView.this.m39371c(valueAnimator);
                }
            });
        }
        if (!z2 || (valueAnimator = this.f54437k) == null) {
            this.f54434h.setAlpha(z ? 1.0f : 0.0f);
        } else if (z) {
            valueAnimator.start();
        } else {
            valueAnimator.reverse();
        }
    }

    /* renamed from: do */
    public void mo162199do(boolean z, boolean z2) {
        ValueAnimator valueAnimator = this.f54438l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z2) {
            setAlpha(z ? 0.0f : 1.0f);
        } else if (z) {
            this.f54438l.start();
        } else {
            this.f54438l.reverse();
        }
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m39367a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m39370b(ValueAnimator valueAnimator) {
        setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: do */
    public void mo162198do(Runnable runnable, int i, int i2) {
        if (this.f54435i == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 2.0f}).setDuration((long) i);
            this.f54435i = duration;
            duration.setStartDelay((long) i2);
            this.f54435i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    OverlayView.this.m39370b(valueAnimator);
                }
            });
            if (runnable != null) {
                this.f54435i.addListener(new C19928do(runnable));
            }
            this.f54435i.start();
        }
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m39367a();
    }

    /* renamed from: do */
    public void mo162197do(Runnable runnable) {
        if (this.f54436j != null) {
            runnable.run();
            return;
        }
        setOvalVisible(true);
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{2.0f, 1.0f}).setDuration(400);
        this.f54436j = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OverlayView.this.m39368a(valueAnimator);
            }
        });
        if (runnable != null) {
            this.f54436j.addListener(new C19929if(this, runnable));
        }
        this.f54436j.start();
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m39367a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39368a(ValueAnimator valueAnimator) {
        setScale(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
