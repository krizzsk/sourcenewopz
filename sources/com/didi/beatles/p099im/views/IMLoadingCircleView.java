package com.didi.beatles.p099im.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.views.IMLoadingCircleView */
public class IMLoadingCircleView extends View {

    /* renamed from: a */
    private static String f9893a = IMLoadingCircleView.class.getSimpleName();

    /* renamed from: m */
    private static final float f9894m = 10.0f;

    /* renamed from: b */
    private Paint f9895b;

    /* renamed from: c */
    private float f9896c;

    /* renamed from: d */
    private float f9897d;

    /* renamed from: e */
    private float f9898e;

    /* renamed from: f */
    private float f9899f;

    /* renamed from: g */
    private final RectF f9900g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f9901h;

    /* renamed from: i */
    private int f9902i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Float f9903j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Float f9904k;

    /* renamed from: l */
    private AnimatorSet f9905l;

    /* renamed from: n */
    private ValueAnimator f9906n;

    /* renamed from: o */
    private ValueAnimator f9907o;

    /* renamed from: p */
    private ValueAnimator f9908p;

    /* renamed from: q */
    private boolean f9909q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public OnDoneCircleAnimListner f9910r;

    /* renamed from: com.didi.beatles.im.views.IMLoadingCircleView$OnDoneCircleAnimListner */
    public interface OnDoneCircleAnimListner {
        void onCircleDone();
    }

    public IMLoadingCircleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMLoadingCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMLoadingCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9896c = 3.0f;
        this.f9900g = new RectF();
        this.f9902i = -65536;
        Float valueOf = Float.valueOf(0.0f);
        this.f9903j = valueOf;
        this.f9904k = valueOf;
        this.f9905l = new AnimatorSet();
        Paint paint = new Paint();
        this.f9895b = paint;
        paint.setAntiAlias(true);
        this.f9895b.setStrokeJoin(Paint.Join.ROUND);
        this.f9895b.setStrokeWidth(this.f9896c);
        this.f9895b.setColor(this.f9902i);
        this.f9895b.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f9900g.left = this.f9897d - this.f9899f;
        this.f9900g.top = this.f9898e - this.f9899f;
        this.f9900g.right = this.f9897d + this.f9899f;
        this.f9900g.bottom = this.f9898e + this.f9899f;
        canvas.drawArc(this.f9900g, 0.0f, (float) this.f9901h, false, this.f9895b);
        float f = this.f9897d;
        float f2 = this.f9899f;
        canvas.drawLine(f - (f2 / 2.0f), this.f9898e, (f - (f2 / 2.0f)) + this.f9903j.floatValue(), this.f9898e + this.f9903j.floatValue(), this.f9895b);
        float f3 = this.f9897d;
        canvas.drawLine(f3, this.f9898e + (this.f9899f / 2.0f), f3 + this.f9904k.floatValue(), (this.f9898e + (this.f9899f / 2.0f)) - (this.f9904k.floatValue() * 1.5f), this.f9895b);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m6690a();
    }

    /* renamed from: a */
    private void m6690a() {
        int width = getWidth();
        int height = getHeight();
        int min = Math.min(height, width);
        this.f9897d = (float) (width / 2);
        this.f9898e = (float) (height / 2);
        this.f9899f = (((float) min) - 20.0f) / 2.0f;
    }

    public void loadCircle() {
        AnimatorSet animatorSet = this.f9905l;
        if (animatorSet == null || !animatorSet.isRunning()) {
            initDegreeAndOffset();
            m6690a();
            this.f9906n = ValueAnimator.ofInt(new int[]{0, 360});
            this.f9907o = ValueAnimator.ofFloat(new float[]{0.0f, this.f9899f / 2.0f});
            this.f9908p = ValueAnimator.ofFloat(new float[]{0.0f, this.f9899f / 2.0f});
            String str = f9893a;
            IMLog.m6635i(str, "mRadius" + this.f9899f);
            this.f9906n.setDuration(700);
            this.f9907o.setDuration(350);
            this.f9908p.setDuration(350);
            this.f9906n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int unused = IMLoadingCircleView.this.f9901h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    IMLoadingCircleView.this.invalidate();
                }
            });
            this.f9907o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float unused = IMLoadingCircleView.this.f9903j = (Float) valueAnimator.getAnimatedValue();
                    IMLoadingCircleView.this.invalidate();
                }
            });
            this.f9908p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float unused = IMLoadingCircleView.this.f9904k = (Float) valueAnimator.getAnimatedValue();
                    IMLoadingCircleView.this.invalidate();
                }
            });
            this.f9905l.play(this.f9906n).before(this.f9907o);
            this.f9905l.play(this.f9908p).after(this.f9907o);
            this.f9905l.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    IMLoadingCircleView.this.stop();
                    IMLoadingCircleView.this.postDelayed(new Runnable() {
                        public void run() {
                            if (IMLoadingCircleView.this.f9910r != null) {
                                IMLoadingCircleView.this.f9910r.onCircleDone();
                            }
                        }
                    }, 800);
                }
            });
            this.f9905l.start();
        }
    }

    public void stop() {
        ValueAnimator valueAnimator = this.f9906n;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
        ValueAnimator valueAnimator2 = this.f9907o;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
        }
        ValueAnimator valueAnimator3 = this.f9908p;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
        }
        clearAnimation();
    }

    public boolean isStarted() {
        AnimatorSet animatorSet = this.f9905l;
        if (animatorSet != null) {
            return animatorSet.isStarted();
        }
        return false;
    }

    public void initDegreeAndOffset() {
        this.f9901h = 0;
        Float valueOf = Float.valueOf(0.0f);
        this.f9903j = valueOf;
        this.f9904k = valueOf;
    }

    public boolean IsCanHide() {
        return this.f9909q;
    }

    public void setCanHide(boolean z) {
        this.f9909q = z;
    }

    public void addCircleAnimatorEndListner(OnDoneCircleAnimListner onDoneCircleAnimListner) {
        if (this.f9910r == null) {
            this.f9910r = onDoneCircleAnimListner;
        }
    }

    public void removeCircleAnimatorEndListner() {
        this.f9910r = null;
    }
}
