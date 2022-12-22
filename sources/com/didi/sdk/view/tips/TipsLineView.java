package com.didi.sdk.view.tips;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class TipsLineView extends View {

    /* renamed from: a */
    private Paint f38257a;

    /* renamed from: b */
    private Path f38258b;

    /* renamed from: c */
    private Path f38259c;

    /* renamed from: d */
    private Point f38260d;

    /* renamed from: e */
    private Point f38261e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Point f38262f;

    /* renamed from: g */
    private float f38263g;

    /* renamed from: h */
    private int f38264h = 2;

    /* renamed from: i */
    private int f38265i;

    /* renamed from: j */
    private int f38266j;

    /* renamed from: k */
    private int f38267k;

    /* renamed from: l */
    private final int f38268l = 200;

    /* renamed from: m */
    private Animator.AnimatorListener f38269m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Animator.AnimatorListener f38270n;

    /* renamed from: o */
    private boolean f38271o = true;

    public TipsLineView(Context context) {
        super(context);
        m27043a(context);
    }

    public TipsLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27043a(context);
    }

    public TipsLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27043a(context);
    }

    /* renamed from: a */
    private void m27043a(Context context) {
        this.f38263g = context.getResources().getDisplayMetrics().density;
        this.f38257a = new Paint();
        this.f38258b = new Path();
        this.f38257a.setAntiAlias(true);
        this.f38257a.setDither(true);
        int color = context.getResources().getColor(R.color.guide_line_color);
        this.f38265i = color;
        this.f38257a.setColor(color);
        int dip2px = dip2px((float) this.f38264h);
        this.f38264h = dip2px;
        this.f38257a.setStrokeWidth((float) dip2px);
        this.f38257a.setStyle(Paint.Style.STROKE);
    }

    public void setEnterAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f38269m = animatorListener;
    }

    public void setExitAnimatorLiener(Animator.AnimatorListener animatorListener) {
        this.f38270n = animatorListener;
    }

    public void startPathAnim(long j) {
        final PathMeasure pathMeasure = new PathMeasure(this.f38259c, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, pathMeasure.getLength()});
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float[] fArr = new float[2];
                pathMeasure.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), fArr, (float[]) null);
                Point unused = TipsLineView.this.f38262f = new Point((int) fArr[0], (int) fArr[1]);
                TipsLineView.this.postInvalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.f38269m;
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void startEndAnim(long j) {
        Path path = new Path();
        this.f38259c = path;
        path.reset();
        this.f38259c.moveTo((float) this.f38261e.x, (float) this.f38261e.y);
        this.f38259c.lineTo((float) this.f38260d.x, (float) this.f38260d.y);
        final PathMeasure pathMeasure = new PathMeasure(this.f38259c, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, pathMeasure.getLength()});
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float[] fArr = new float[2];
                pathMeasure.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), fArr, (float[]) null);
                Point unused = TipsLineView.this.f38262f = new Point((int) fArr[0], (int) fArr[1]);
                TipsLineView.this.postInvalidate();
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animator) {
                if (TipsLineView.this.f38270n != null) {
                    TipsLineView.this.f38270n.onAnimationStart(animator);
                }
            }

            public void onAnimationEnd(Animator animator) {
                TipsLineView.this.m27042a();
                if (TipsLineView.this.f38270n != null) {
                    TipsLineView.this.f38270n.onAnimationEnd(animator);
                }
            }

            public void onAnimationCancel(Animator animator) {
                if (TipsLineView.this.f38270n != null) {
                    TipsLineView.this.f38270n.onAnimationCancel(animator);
                }
            }

            public void onAnimationRepeat(Animator animator) {
                if (TipsLineView.this.f38270n != null) {
                    TipsLineView.this.f38270n.onAnimationRepeat(animator);
                }
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27042a() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    public int dip2px(float f) {
        return (int) ((f * this.f38263g) + 0.5f);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f38262f == null) {
            this.f38266j = canvas.getHeight();
            this.f38267k = canvas.getWidth();
            SystemUtils.log(4, "xxxx", " cw=" + this.f38267k + " w=" + getWidth() + " " + getLeft() + " " + this.f38264h, (Throwable) null, "com.didi.sdk.view.tips.TipsLineView", 178);
            if (this.f38266j > this.f38267k) {
                this.f38260d = new Point(0, this.f38266j);
                this.f38261e = new Point(0, 0);
                this.f38257a.setStrokeWidth((float) this.f38267k);
            } else {
                this.f38260d = new Point(this.f38267k, 0);
                this.f38261e = new Point(0, 0);
                this.f38257a.setStrokeWidth((float) this.f38266j);
            }
            if (this.f38271o) {
                this.f38262f = new Point(this.f38260d.x, this.f38260d.y);
                Path path = new Path();
                this.f38259c = path;
                path.reset();
                this.f38259c.moveTo((float) this.f38260d.x, (float) this.f38260d.y);
                this.f38259c.lineTo((float) this.f38261e.x, (float) this.f38261e.y);
                startPathAnim(200);
            } else {
                this.f38262f = this.f38261e;
            }
        }
        this.f38258b.reset();
        this.f38258b.moveTo((float) this.f38260d.x, (float) this.f38260d.y);
        this.f38258b.lineTo((float) this.f38262f.x, (float) this.f38262f.y);
        float f = this.f38263g;
        this.f38257a.setPathEffect(new DashPathEffect(new float[]{f * 4.0f, f * 3.0f, 4.0f * f, f * 3.0f}, 1.0f));
        canvas.drawPath(this.f38258b, this.f38257a);
    }

    public void setUseAnimation(boolean z) {
        this.f38271o = z;
    }
}
