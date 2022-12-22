package com.tunasashimi.tuna;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import com.didi.passenger.C10448R;

public class TunaRipple extends TunaView {
    private static final TimeInterpolator[] tunaRippleTimeInterpolatorArray = {new AccelerateDecelerateInterpolator(), new AccelerateInterpolator(), new AnticipateInterpolator(), new AnticipateOvershootInterpolator(), new BounceInterpolator(), new CycleInterpolator(0.0f), new DecelerateInterpolator(), new LinearInterpolator(), new OvershootInterpolator()};
    /* access modifiers changed from: private */
    public float tunaRippleAnimationCircleRadius;
    private Property<TunaRipple, Float> tunaRippleAnimationCircleRadiusProperty;
    private AnimatorSet tunaRippleAnimatorSet;
    /* access modifiers changed from: private */
    public float tunaRippleDeltaRadius;
    private int tunaRippleDuraction;
    private int tunaRippleInnerCircleAngle;
    private int tunaRippleInnerCircleColor;
    private int tunaRippleInnerCircleColorGradientEnd;
    private int tunaRippleInnerCircleColorGradientStart;
    private Shader tunaRippleInnerCircleColorShader;
    private float tunaRippleInnerCircleRadius;
    private float tunaRippleMaxRadius;
    private int tunaRippleOuterCircleAngle;
    private int tunaRippleOuterCircleColor;
    private int tunaRippleOuterCircleColorGradientEnd;
    private int tunaRippleOuterCircleColorGradientStart;
    private Shader tunaRippleOuterCircleColorShader;
    /* access modifiers changed from: private */
    public float tunaRippleOuterCircleRadius;
    /* access modifiers changed from: private */
    public float tunaRippleOuterDeferCircleRadius;
    /* access modifiers changed from: private */
    public float tunaRippleOuterDelayCircleRadius;
    private int tunaRippleTextColor;
    private float tunaRippleTextDx;
    private float tunaRippleTextDy;
    private float tunaRippleTextFractionDx;
    private float tunaRippleTextFractionDy;
    private float tunaRippleTextSize;
    private String tunaRippleTextValue;
    private TimeInterpolator tunaRippleTimeInterpolator;

    public float getTunaRippleInnerCircleRadius() {
        return this.tunaRippleInnerCircleRadius;
    }

    public void setTunaRippleInnerCircleRadius(float f) {
        this.tunaRippleInnerCircleRadius = f;
    }

    public int getTunaRippleInnerCircleColor() {
        return this.tunaRippleInnerCircleColor;
    }

    public void setTunaRippleInnerCircleColor(int i) {
        if (this.tunaRippleInnerCircleColor != i) {
            this.tunaRippleInnerCircleColorShader = null;
            this.tunaRippleInnerCircleColor = i;
        }
    }

    public void setTunaRippleInnerCircleColor(int i, int i2) {
        this.tunaRippleInnerCircleColorGradientStart = i;
        this.tunaRippleInnerCircleColorGradientEnd = i2;
        int i3 = this.tunaRippleInnerCircleAngle;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        setTunaRippleInnerCircleColor(i3, i, i2);
    }

    public void setTunaRippleInnerCircleColor(int i, int i2, int i3) {
        this.tunaRippleInnerCircleColorGradientStart = i2;
        this.tunaRippleInnerCircleColorGradientEnd = i3;
        this.tunaRippleInnerCircleColorShader = getLinearGradient(this.tunaWidth, this.tunaHeight, i, i2, i3);
    }

    public float getTunaRippleOuterCircleRadius() {
        return this.tunaRippleOuterCircleRadius;
    }

    public void setTunaRippleOuterCircleRadius(float f) {
        this.tunaRippleOuterCircleRadius = f;
    }

    public float getTunaRippleOuterDelayCircleRadius() {
        return this.tunaRippleOuterDelayCircleRadius;
    }

    public void setTunaRippleOuterDelayCircleRadius(float f) {
        this.tunaRippleOuterDelayCircleRadius = f;
    }

    public float getTunaRippleOuterDeferCircleRadius() {
        return this.tunaRippleOuterDeferCircleRadius;
    }

    public void setTunaRippleOuterDeferCircleRadius(float f) {
        this.tunaRippleOuterDeferCircleRadius = f;
    }

    public int getTunaRippleOuterCircleColor() {
        return this.tunaRippleOuterCircleColor;
    }

    public void setTunaRippleOuterCircleColor(int i) {
        if (this.tunaRippleOuterCircleColor != i) {
            this.tunaRippleOuterCircleColorShader = null;
            this.tunaRippleOuterCircleColor = i;
        }
    }

    public void setTunaRippleOuterCircleColor(int i, int i2) {
        int i3 = this.tunaRippleOuterCircleAngle;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        setTunaRippleOuterCircleColor(i3, i, i2);
    }

    public void setTunaRippleOuterCircleColor(int i, int i2, int i3) {
        this.tunaRippleOuterCircleColorGradientStart = i2;
        this.tunaRippleOuterCircleColorGradientEnd = i3;
        this.tunaRippleOuterCircleColorShader = getLinearGradient(this.tunaWidth, this.tunaHeight, i, i2, i3);
    }

    public float getTunaRippleTextSize() {
        return this.tunaRippleTextSize;
    }

    public void setTunaRippleTextSize(float f) {
        this.tunaRippleTextSize = f;
    }

    public int getTunaRippleTextColor() {
        return this.tunaRippleTextColor;
    }

    public void setTunaRippleTextColor(int i) {
        this.tunaRippleTextColor = i;
    }

    public String getTunaRippleTextValue() {
        return this.tunaRippleTextValue;
    }

    public void setTunaRippleTextValue(String str) {
        this.tunaRippleTextValue = str;
    }

    public float getTunaRippleTextDx() {
        return this.tunaRippleTextDx;
    }

    public void setTunaRippleTextDx(float f) {
        setTunaRippleTextDx(1, f);
    }

    public void setTunaRippleTextDx(int i, float f) {
        setTunaRippleTextDxRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaRippleTextDxRaw(float f) {
        if (this.tunaRippleTextDx != f) {
            this.tunaRippleTextDx = f;
        }
    }

    public float getTunaRippleTextDy() {
        return this.tunaRippleTextDy;
    }

    public void setTunaRippleTextDy(float f) {
        setTunaRippleTextDy(1, f);
    }

    public void setTunaRippleTextDy(int i, float f) {
        setTunaRippleTextDyRaw(applyDimension(i, f, getViewDisplayMetrics(this)));
    }

    private void setTunaRippleTextDyRaw(float f) {
        if (this.tunaRippleTextDy != f) {
            this.tunaRippleTextDy = f;
        }
    }

    public float getTunaRippleTextFractionDx() {
        return this.tunaRippleTextFractionDx;
    }

    public void setTunaRippleTextFractionDx(float f) {
        this.tunaRippleTextFractionDx = f;
    }

    public float getTunaRippleTextFractionDy() {
        return this.tunaRippleTextFractionDy;
    }

    public void setTunaRippleTextFractionDy(float f) {
        this.tunaRippleTextFractionDy = f;
    }

    public int getTunaRippleDuraction() {
        return this.tunaRippleDuraction;
    }

    public void setTunaRippleDuraction(int i) {
        this.tunaRippleDuraction = i;
    }

    public int getTunaRippleInnerCircleAngle() {
        return this.tunaRippleInnerCircleAngle;
    }

    public void setTunaRippleInnerCircleAngle(int i) {
        this.tunaRippleInnerCircleAngle = i;
        this.tunaRippleInnerCircleColorShader = getLinearGradient(this.tunaWidth, this.tunaHeight, i, this.tunaRippleInnerCircleColorGradientStart, this.tunaRippleInnerCircleColorGradientEnd);
    }

    public int getTunaRippleOuterCircleAngle() {
        return this.tunaRippleOuterCircleAngle;
    }

    public void setTunaRippleOuterCircleAngle(int i) {
        this.tunaRippleOuterCircleAngle = i;
        this.tunaRippleOuterCircleColorShader = getLinearGradient(this.tunaWidth, this.tunaHeight, i, this.tunaRippleOuterCircleColorGradientStart, this.tunaRippleOuterCircleColorGradientEnd);
    }

    public int getTunaRippleInnerCircleColorGradientStart() {
        return this.tunaRippleInnerCircleColorGradientStart;
    }

    public void setTunaRippleInnerCircleColorGradientStart(int i) {
        this.tunaRippleInnerCircleColorGradientStart = i;
    }

    public int getTunaRippleInnerCircleColorGradientEnd() {
        return this.tunaRippleInnerCircleColorGradientEnd;
    }

    public void setTunaRippleInnerCircleColorGradientEnd(int i) {
        this.tunaRippleInnerCircleColorGradientEnd = i;
    }

    public int getTunaRippleOuterCircleColorGradientStart() {
        return this.tunaRippleOuterCircleColorGradientStart;
    }

    public void setTunaRippleOuterCircleColorGradientStart(int i) {
        this.tunaRippleOuterCircleColorGradientStart = i;
    }

    public int getTunaRippleOuterCircleColorGradientEnd() {
        return this.tunaRippleOuterCircleColorGradientEnd;
    }

    public void setTunaRippleOuterCircleColorGradientEnd(int i) {
        this.tunaRippleOuterCircleColorGradientEnd = i;
    }

    public Shader getTunaRippleInnerCircleColorShader() {
        return this.tunaRippleInnerCircleColorShader;
    }

    public void setTunaRippleInnerCircleColorShader(Shader shader) {
        this.tunaRippleInnerCircleColorShader = shader;
    }

    public Shader getTunaRippleOuterCircleColorShader() {
        return this.tunaRippleOuterCircleColorShader;
    }

    public void setTunaRippleOuterCircleColorShader(Shader shader) {
        this.tunaRippleOuterCircleColorShader = shader;
    }

    public TimeInterpolator getTunaRippleTimeInterpolator() {
        return this.tunaRippleTimeInterpolator;
    }

    public void setTunaRippleTimeInterpolator(TimeInterpolator timeInterpolator) {
        this.tunaRippleTimeInterpolator = timeInterpolator;
    }

    public enum TunaRippleTimeInterpolator {
        ACCELERATEDECELERATEINTERPOLATOR(0),
        ACCELERATEINTERPOLATOR(1),
        ANTICIPATEINTERPOLATOR(2),
        ANTICIPATEOVERSHOOTINTERPOLATOR(3),
        BOUNCEINTERPOLATOR(4),
        CYCLEINTERPOLATOR(5),
        DECELERATEINTERPOLATOR(6),
        LINEARINTERPOLATOR(7),
        OVERSHOOTINTERPOLATOR(8);
        
        final int nativeInt;

        private TunaRippleTimeInterpolator(int i) {
            this.nativeInt = i;
        }
    }

    public static TimeInterpolator[] getTunarippletimeinterpolatorarray() {
        return tunaRippleTimeInterpolatorArray;
    }

    public AnimatorSet getTunaRippleAnimatorSet() {
        return this.tunaRippleAnimatorSet;
    }

    public void setTunaRippleAnimatorSet(AnimatorSet animatorSet) {
        this.tunaRippleAnimatorSet = animatorSet;
    }

    public TunaRipple(Context context) {
        this(context, (AttributeSet) null);
    }

    public TunaRipple(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TunaRipple(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tunaRippleAnimationCircleRadiusProperty = new Property<TunaRipple, Float>(Float.class, "tunaRippleAnimationCircleRadiusProperty") {
            public Float get(TunaRipple tunaRipple) {
                return Float.valueOf(tunaRipple.tunaRippleAnimationCircleRadius);
            }

            public void set(TunaRipple tunaRipple, Float f) {
                float unused = tunaRipple.tunaRippleAnimationCircleRadius = f.floatValue();
                float unused2 = tunaRipple.tunaRippleOuterCircleRadius = f.floatValue();
                float unused3 = tunaRipple.tunaRippleOuterDelayCircleRadius = f.floatValue() - (TunaRipple.this.tunaRippleDeltaRadius * 0.5f);
                float unused4 = tunaRipple.tunaRippleOuterDeferCircleRadius = f.floatValue() - (TunaRipple.this.tunaRippleDeltaRadius * 1.0f);
                TunaRipple.this.invalidate();
            }
        };
        this.tunaTag = TunaRipple.class.getSimpleName();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.TunaRipple);
        this.tunaRippleInnerCircleRadius = obtainStyledAttributes.getDimension(5, 0.0f);
        int color = obtainStyledAttributes.getColor(2, 0);
        this.tunaRippleInnerCircleColor = color;
        this.tunaRippleAnimationCircleRadius = this.tunaRippleInnerCircleRadius;
        this.tunaRippleOuterCircleColor = obtainStyledAttributes.getColor(7, color);
        this.tunaRippleTextSize = obtainStyledAttributes.getDimension(15, 0.0f);
        this.tunaRippleTextColor = obtainStyledAttributes.getColor(10, 0);
        this.tunaRippleTextValue = obtainStyledAttributes.getString(16);
        this.tunaRippleTextDx = obtainStyledAttributes.getDimension(11, 0.0f);
        this.tunaRippleTextDy = obtainStyledAttributes.getDimension(12, 0.0f);
        this.tunaRippleTextFractionDx = obtainStyledAttributes.getFraction(13, 1, 1, 0.0f);
        this.tunaRippleTextFractionDy = obtainStyledAttributes.getFraction(14, 1, 1, 0.0f);
        int i2 = obtainStyledAttributes.getInt(1, Integer.MAX_VALUE);
        this.tunaRippleInnerCircleAngle = i2;
        if (i2 != Integer.MAX_VALUE) {
            this.tunaRippleInnerCircleColorGradientStart = obtainStyledAttributes.getColor(4, this.tunaRippleInnerCircleColor);
            this.tunaRippleInnerCircleColorGradientEnd = obtainStyledAttributes.getColor(3, this.tunaRippleInnerCircleColor);
        }
        int i3 = obtainStyledAttributes.getInt(6, this.tunaRippleInnerCircleAngle);
        this.tunaRippleOuterCircleAngle = i3;
        if (i3 != Integer.MAX_VALUE) {
            this.tunaRippleOuterCircleColorGradientStart = obtainStyledAttributes.getColor(9, this.tunaRippleInnerCircleColorGradientStart);
            this.tunaRippleOuterCircleColorGradientEnd = obtainStyledAttributes.getColor(8, this.tunaRippleInnerCircleColorGradientEnd);
        }
        this.tunaRippleDuraction = obtainStyledAttributes.getInt(0, 0);
        int i4 = obtainStyledAttributes.getInt(17, -1);
        if (i4 > -1) {
            this.tunaRippleTimeInterpolator = tunaRippleTimeInterpolatorArray[i4];
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float f = (float) ((this.tunaWidth > this.tunaHeight ? this.tunaHeight : this.tunaWidth) >> 1);
        this.tunaRippleMaxRadius = f;
        float f2 = this.tunaRippleInnerCircleRadius;
        this.tunaRippleDeltaRadius = f - f2;
        if (f2 < f) {
            this.tunaRippleTextDx += ((float) this.tunaWidth) * this.tunaRippleTextFractionDx;
            this.tunaRippleTextDy += ((float) this.tunaHeight) * this.tunaRippleTextFractionDy;
            if (this.tunaRippleInnerCircleAngle != Integer.MAX_VALUE) {
                this.tunaRippleInnerCircleColorShader = getLinearGradient(this.tunaWidth, this.tunaHeight, this.tunaRippleInnerCircleAngle, this.tunaRippleInnerCircleColorGradientStart, this.tunaRippleInnerCircleColorGradientEnd);
            }
            if (this.tunaRippleOuterCircleAngle != Integer.MAX_VALUE) {
                this.tunaRippleOuterCircleColorShader = getLinearGradient(this.tunaWidth, this.tunaHeight, this.tunaRippleOuterCircleAngle, this.tunaRippleOuterCircleColorGradientStart, this.tunaRippleOuterCircleColorGradientEnd);
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException("The content attribute tunaRippleInnerCircleRadius length must be less than half of the width or height");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.tunaRippleInnerCircleRadius > 0.0f) {
            canvas.drawCircle((float) (this.tunaWidth >> 1), (float) (this.tunaHeight >> 1), this.tunaRippleInnerCircleRadius, initTunaPaint(Paint.Style.FILL, this.tunaRippleInnerCircleColor, this.tunaRippleInnerCircleColorShader));
        }
        float f = this.tunaRippleOuterCircleRadius;
        if (f > this.tunaRippleInnerCircleRadius && f < this.tunaRippleMaxRadius) {
            canvas.drawCircle((float) (this.tunaWidth >> 1), (float) (this.tunaHeight >> 1), this.tunaRippleOuterCircleRadius, initTunaPaint(Paint.Style.FILL, this.tunaRippleOuterCircleColor, this.tunaRippleInnerCircleColorShader, (int) (((this.tunaRippleMaxRadius - this.tunaRippleOuterCircleRadius) / this.tunaRippleDeltaRadius) * 255.0f)));
        }
        float f2 = this.tunaRippleOuterDelayCircleRadius;
        if (f2 > this.tunaRippleInnerCircleRadius && f2 < this.tunaRippleMaxRadius) {
            canvas.drawCircle((float) (this.tunaWidth >> 1), (float) (this.tunaHeight >> 1), this.tunaRippleOuterDelayCircleRadius, initTunaPaint(Paint.Style.FILL, this.tunaRippleOuterCircleColor, this.tunaRippleOuterCircleColorShader, (int) (((this.tunaRippleMaxRadius - this.tunaRippleOuterDelayCircleRadius) / this.tunaRippleDeltaRadius) * 255.0f)));
        }
        float f3 = this.tunaRippleOuterDeferCircleRadius;
        if (f3 > this.tunaRippleInnerCircleRadius && f3 < this.tunaRippleMaxRadius) {
            canvas.drawCircle((float) (this.tunaWidth >> 1), (float) (this.tunaHeight >> 1), this.tunaRippleOuterDeferCircleRadius, initTunaPaint(Paint.Style.FILL, this.tunaRippleOuterCircleColor, this.tunaRippleOuterCircleColorShader, (int) (((this.tunaRippleMaxRadius - this.tunaRippleOuterDeferCircleRadius) / this.tunaRippleDeltaRadius) * 255.0f)));
        }
        String str = this.tunaRippleTextValue;
        if (str != null) {
            drawTunaText(canvas, str, (float) this.tunaWidth, ((float) (this.tunaWidth >> 1)) + this.tunaRippleTextDx, ((float) (this.tunaHeight >> 1)) + this.tunaRippleTextDy, 0.0f, 0.0f, initTunaTextPaint(Paint.Style.FILL, this.tunaRippleTextColor, this.tunaRippleTextSize, Paint.Align.CENTER));
        }
    }

    public void play() {
        this.tunaRippleAnimatorSet = new AnimatorSet();
        Property<TunaRipple, Float> property = this.tunaRippleAnimationCircleRadiusProperty;
        float f = this.tunaRippleInnerCircleRadius;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, property, new float[]{f, f + (this.tunaRippleDeltaRadius * 3.0f)});
        ofFloat.setDuration((long) this.tunaRippleDuraction);
        this.tunaRippleAnimatorSet.playTogether(new Animator[]{ofFloat});
        TimeInterpolator timeInterpolator = this.tunaRippleTimeInterpolator;
        if (timeInterpolator != null) {
            this.tunaRippleAnimatorSet.setInterpolator(timeInterpolator);
        }
        this.tunaRippleAnimatorSet.start();
    }
}
