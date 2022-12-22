package com.didi.addressold.view.tips;

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
    private Paint f7978a;

    /* renamed from: b */
    private Path f7979b;

    /* renamed from: c */
    private Path f7980c;

    /* renamed from: d */
    private Point f7981d;

    /* renamed from: e */
    private Point f7982e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Point f7983f;

    /* renamed from: g */
    private float f7984g;

    /* renamed from: h */
    private int f7985h = 2;

    /* renamed from: i */
    private int f7986i;

    /* renamed from: j */
    private int f7987j;

    /* renamed from: k */
    private int f7988k;

    /* renamed from: l */
    private final int f7989l = 200;

    /* renamed from: m */
    private Animator.AnimatorListener f7990m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Animator.AnimatorListener f7991n;

    /* renamed from: o */
    private boolean f7992o = true;

    public TipsLineView(Context context) {
        super(context);
        m5164a(context);
    }

    public TipsLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5164a(context);
    }

    public TipsLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5164a(context);
    }

    /* renamed from: a */
    private void m5164a(Context context) {
        this.f7984g = context.getResources().getDisplayMetrics().density;
        this.f7978a = new Paint();
        this.f7979b = new Path();
        this.f7978a.setAntiAlias(true);
        this.f7978a.setDither(true);
        int color = context.getResources().getColor(R.color.guide_line_color);
        this.f7986i = color;
        this.f7978a.setColor(color);
        int dip2px = dip2px((float) this.f7985h);
        this.f7985h = dip2px;
        this.f7978a.setStrokeWidth((float) dip2px);
        this.f7978a.setStyle(Paint.Style.STROKE);
    }

    public void setEnterAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f7990m = animatorListener;
    }

    public void setExitAnimatorLiener(Animator.AnimatorListener animatorListener) {
        this.f7991n = animatorListener;
    }

    public void startPathAnim(long j) {
        final PathMeasure pathMeasure = new PathMeasure(this.f7980c, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, pathMeasure.getLength()});
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float[] fArr = new float[2];
                pathMeasure.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), fArr, (float[]) null);
                Point unused = TipsLineView.this.f7983f = new Point((int) fArr[0], (int) fArr[1]);
                TipsLineView.this.postInvalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.f7990m;
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void startEndAnim(long j) {
        Path path = new Path();
        this.f7980c = path;
        path.reset();
        this.f7980c.moveTo((float) this.f7982e.x, (float) this.f7982e.y);
        this.f7980c.lineTo((float) this.f7981d.x, (float) this.f7981d.y);
        final PathMeasure pathMeasure = new PathMeasure(this.f7980c, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, pathMeasure.getLength()});
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float[] fArr = new float[2];
                pathMeasure.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), fArr, (float[]) null);
                Point unused = TipsLineView.this.f7983f = new Point((int) fArr[0], (int) fArr[1]);
                TipsLineView.this.postInvalidate();
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animator) {
                if (TipsLineView.this.f7991n != null) {
                    TipsLineView.this.f7991n.onAnimationStart(animator);
                }
            }

            public void onAnimationEnd(Animator animator) {
                TipsLineView.this.m5163a();
                if (TipsLineView.this.f7991n != null) {
                    TipsLineView.this.f7991n.onAnimationEnd(animator);
                }
            }

            public void onAnimationCancel(Animator animator) {
                if (TipsLineView.this.f7991n != null) {
                    TipsLineView.this.f7991n.onAnimationCancel(animator);
                }
            }

            public void onAnimationRepeat(Animator animator) {
                if (TipsLineView.this.f7991n != null) {
                    TipsLineView.this.f7991n.onAnimationRepeat(animator);
                }
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5163a() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    public int dip2px(float f) {
        return (int) ((f * this.f7984g) + 0.5f);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f7983f == null) {
            this.f7987j = canvas.getHeight();
            this.f7988k = canvas.getWidth();
            SystemUtils.log(4, "xxxx", " cw=" + this.f7988k + " w=" + getWidth() + " " + getLeft() + " " + this.f7985h, (Throwable) null, "com.didi.addressold.view.tips.TipsLineView", 167);
            if (this.f7987j > this.f7988k) {
                this.f7981d = new Point(0, this.f7987j);
                this.f7982e = new Point(0, 0);
                this.f7978a.setStrokeWidth((float) this.f7988k);
            } else {
                this.f7981d = new Point(this.f7988k, 0);
                this.f7982e = new Point(0, 0);
                this.f7978a.setStrokeWidth((float) this.f7987j);
            }
            if (this.f7992o) {
                this.f7983f = new Point(this.f7981d.x, this.f7981d.y);
                Path path = new Path();
                this.f7980c = path;
                path.reset();
                this.f7980c.moveTo((float) this.f7981d.x, (float) this.f7981d.y);
                this.f7980c.lineTo((float) this.f7982e.x, (float) this.f7982e.y);
                startPathAnim(200);
            } else {
                this.f7983f = this.f7982e;
            }
        }
        this.f7979b.reset();
        this.f7979b.moveTo((float) this.f7981d.x, (float) this.f7981d.y);
        this.f7979b.lineTo((float) this.f7983f.x, (float) this.f7983f.y);
        float f = this.f7984g;
        this.f7978a.setPathEffect(new DashPathEffect(new float[]{f * 4.0f, f * 3.0f, 4.0f * f, f * 3.0f}, 1.0f));
        canvas.drawPath(this.f7979b, this.f7978a);
    }

    public void setUseAnimation(boolean z) {
        this.f7992o = z;
    }
}
