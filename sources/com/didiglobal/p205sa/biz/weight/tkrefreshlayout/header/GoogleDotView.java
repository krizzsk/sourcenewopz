package com.didiglobal.p205sa.biz.weight.tkrefreshlayout.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.IHeaderView;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.OnAnimEndListener;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.DensityUtil;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.header.GoogleDotView */
public class GoogleDotView extends View implements IHeaderView {

    /* renamed from: a */
    float f51312a;

    /* renamed from: b */
    float f51313b;

    /* renamed from: c */
    boolean f51314c;

    /* renamed from: d */
    ValueAnimator f51315d;

    /* renamed from: e */
    ValueAnimator f51316e;

    /* renamed from: f */
    private Paint f51317f;

    /* renamed from: g */
    private float f51318g;

    /* renamed from: h */
    private int f51319h;

    /* renamed from: i */
    private int f51320i;

    public View getView() {
        return this;
    }

    public void setCir_x(int i) {
        this.f51320i = i;
    }

    public GoogleDotView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public GoogleDotView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GoogleDotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f51319h = 5;
        this.f51314c = false;
        m36735a();
    }

    /* renamed from: a */
    private void m36735a() {
        this.f51318g = (float) DensityUtil.dp2px(getContext(), 4.0f);
        Paint paint = new Paint();
        this.f51317f = paint;
        paint.setAntiAlias(true);
        this.f51317f.setColor(Color.rgb(114, 114, 114));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 1.2f, 1.0f, 0.8f});
        this.f51315d = ofFloat;
        ofFloat.setDuration(800);
        this.f51315d.setInterpolator(new DecelerateInterpolator());
        this.f51315d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GoogleDotView.this.f51312a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                GoogleDotView.this.invalidate();
            }
        });
        this.f51315d.setRepeatCount(-1);
        this.f51315d.setRepeatMode(2);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.8f, 1.0f, 1.2f});
        this.f51316e = ofFloat2;
        ofFloat2.setDuration(800);
        this.f51316e.setInterpolator(new DecelerateInterpolator());
        this.f51316e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GoogleDotView.this.f51313b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f51316e.setRepeatCount(-1);
        this.f51316e.setRepeatMode(2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = (getMeasuredWidth() / this.f51319h) - 10;
        for (int i = 0; i < this.f51319h; i++) {
            if (this.f51314c) {
                if (i == 0) {
                    this.f51317f.setAlpha(105);
                    this.f51317f.setColor(InputDeviceCompat.SOURCE_ANY);
                    canvas.drawCircle((float) (((getMeasuredWidth() / 2) - (this.f51320i * 2)) - (((measuredWidth * 2) / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f51318g * this.f51313b, this.f51317f);
                } else if (i == 1) {
                    this.f51317f.setAlpha(145);
                    this.f51317f.setColor(-16711936);
                    canvas.drawCircle((float) (((getMeasuredWidth() / 2) - (this.f51320i * 1)) - ((measuredWidth / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f51318g * this.f51313b, this.f51317f);
                } else if (i == 2) {
                    this.f51317f.setAlpha(255);
                    this.f51317f.setColor(-16776961);
                    canvas.drawCircle((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2), this.f51318g * this.f51312a, this.f51317f);
                } else if (i == 3) {
                    this.f51317f.setAlpha(145);
                    this.f51317f.setColor(-16711936);
                    canvas.drawCircle((float) ((getMeasuredWidth() / 2) + (this.f51320i * 1) + ((measuredWidth / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f51318g * this.f51313b, this.f51317f);
                } else if (i == 4) {
                    this.f51317f.setAlpha(105);
                    this.f51317f.setColor(InputDeviceCompat.SOURCE_ANY);
                    canvas.drawCircle((float) ((getMeasuredWidth() / 2) + (this.f51320i * 2) + (((measuredWidth * 2) / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f51318g * this.f51313b, this.f51317f);
                }
            } else if (i == 0) {
                this.f51317f.setAlpha(105);
                this.f51317f.setColor(InputDeviceCompat.SOURCE_ANY);
                canvas.drawCircle((float) (((getMeasuredWidth() / 2) - (this.f51320i * 2)) - (((measuredWidth * 2) / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f51318g, this.f51317f);
            } else if (i == 1) {
                this.f51317f.setAlpha(145);
                this.f51317f.setColor(-16711936);
                canvas.drawCircle((float) (((getMeasuredWidth() / 2) - (this.f51320i * 1)) - ((measuredWidth / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f51318g, this.f51317f);
            } else if (i == 2) {
                this.f51317f.setAlpha(255);
                this.f51317f.setColor(-16776961);
                canvas.drawCircle((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2), this.f51318g, this.f51317f);
            } else if (i == 3) {
                this.f51317f.setAlpha(145);
                this.f51317f.setColor(-16711936);
                canvas.drawCircle((float) ((getMeasuredWidth() / 2) + (this.f51320i * 1) + ((measuredWidth / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f51318g, this.f51317f);
            } else if (i == 4) {
                this.f51317f.setAlpha(105);
                this.f51317f.setColor(InputDeviceCompat.SOURCE_ANY);
                canvas.drawCircle((float) ((getMeasuredWidth() / 2) + (this.f51320i * 2) + (((measuredWidth * 2) / 3) * 2)), (float) (getMeasuredHeight() / 2), this.f51318g, this.f51317f);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f51315d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f51316e;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    public void onPullingDown(float f, float f2, float f3) {
        float f4 = (f / 2.0f) + 1.0f;
        setScaleX(f4);
        setScaleY(f4);
        this.f51314c = false;
        if (this.f51315d.isRunning()) {
            this.f51315d.cancel();
            invalidate();
        }
        if (this.f51316e.isRunning()) {
            this.f51316e.cancel();
        }
    }

    public void onPullReleasing(float f, float f2, float f3) {
        float f4 = (f / 2.0f) + 1.0f;
        setScaleX(f4);
        setScaleY(f4);
        if (f < 1.0f) {
            this.f51314c = false;
            if (this.f51315d.isRunning()) {
                this.f51315d.cancel();
                invalidate();
            }
            if (this.f51316e.isRunning()) {
                this.f51316e.cancel();
            }
        }
    }

    public void startAnim(float f, float f2) {
        this.f51314c = true;
        this.f51315d.start();
        this.f51316e.start();
    }

    public void onFinish(OnAnimEndListener onAnimEndListener) {
        onAnimEndListener.onAnimEnd();
    }

    public void reset() {
        this.f51314c = false;
        if (this.f51315d.isRunning()) {
            this.f51315d.cancel();
        }
        if (this.f51316e.isRunning()) {
            this.f51316e.cancel();
        }
        invalidate();
    }
}
