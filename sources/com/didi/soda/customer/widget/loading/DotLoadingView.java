package com.didi.soda.customer.widget.loading;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.didi.passenger.C10448R;
import java.util.ArrayList;
import java.util.List;

public class DotLoadingView extends View {
    public static final int IDLE = 0;
    public static final int RUNNING = 1;

    /* renamed from: a */
    private static final int f42066a = 2131101506;

    /* renamed from: b */
    private static final int f42067b = 2131101506;

    /* renamed from: c */
    private static final int f42068c = 2131165687;

    /* renamed from: d */
    private static final int f42069d = 2131165464;

    /* renamed from: e */
    private int f42070e = 0;

    /* renamed from: f */
    private int f42071f;

    /* renamed from: g */
    private int f42072g;

    /* renamed from: h */
    private int f42073h;

    /* renamed from: i */
    private float f42074i;

    /* renamed from: j */
    private int f42075j;

    /* renamed from: k */
    private boolean f42076k = true;

    /* renamed from: l */
    private List<Dot> f42077l = new ArrayList();

    /* renamed from: m */
    private AnimatorSet f42078m = new AnimatorSet();
    public int mDuration = 350;

    public DotLoadingView(Context context) {
        super(context);
        m29679a((AttributeSet) null);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29679a(attributeSet);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29679a(attributeSet);
    }

    public void start() {
        if (this.f42070e == 0) {
            this.f42070e = 1;
            m29677a();
        }
    }

    public void stop() {
        if (this.f42070e == 1) {
            this.f42078m.cancel();
        }
        this.f42070e = 0;
    }

    public boolean isRunning() {
        return this.f42070e == 1;
    }

    public void setAutoRunning(boolean z) {
        this.f42076k = z;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setColor(int i, int i2) {
        for (int i3 = 0; i3 < this.f42077l.size(); i3++) {
            this.f42077l.get(i3).updateColor(i, i2);
        }
    }

    public void setRadiusAndScale(int i, float f) {
        this.f42075j = i;
        this.f42074i = f;
        this.f42071f = (int) (((float) (i * 2)) * f);
        for (int i2 = 0; i2 < this.f42077l.size(); i2++) {
            Dot dot = this.f42077l.get(i2);
            dot.scale = 1.0f / f;
            dot.width = this.f42071f;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f42076k && this.f42070e == 1) {
            m29677a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = this.f42077l.size();
        if (size > 0) {
            i4 = Math.max(this.f42071f, this.f42077l.get(0).drawable.getIntrinsicWidth());
            i3 = (size * i4) + (this.f42072g * (size - 1));
        } else {
            i4 = 0;
            i3 = 0;
        }
        setMeasuredDimension(resolveSizeAndState(i3 + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(i4 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int size;
        super.onDraw(canvas);
        if (getVisibility() == 0 && (size = this.f42077l.size()) > 0) {
            int max = Math.max(this.f42071f, this.f42077l.get(0).drawable.getIntrinsicWidth());
            int max2 = Math.max(((getRight() - getLeft()) >> 1) - (((size * max) + (this.f42072g * (size - 1))) >> 1), 0);
            int max3 = Math.max(((getBottom() - getTop()) >> 1) - (max >> 1), 0);
            for (int i = 0; i < this.f42077l.size(); i++) {
                this.f42077l.get(i).draw(canvas, max2, max3, i, this.f42072g);
            }
        }
    }

    /* renamed from: a */
    private void m29677a() {
        this.f42078m.start();
    }

    /* renamed from: a */
    private void m29679a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.DotLoadingView, 0, 0);
        int color = obtainStyledAttributes.getColor(2, m29676a(f42067b));
        int color2 = obtainStyledAttributes.getColor(1, m29676a(f42066a));
        this.f42076k = obtainStyledAttributes.getBoolean(0, this.f42076k);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, getContext().getResources().getDimensionPixelSize(f42068c));
        float f = obtainStyledAttributes.getFloat(9, 1.25f);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(5, getContext().getResources().getDimensionPixelSize(f42069d));
        int integer = obtainStyledAttributes.getInteger(3, 3);
        this.mDuration = obtainStyledAttributes.getInteger(4, this.mDuration);
        obtainStyledAttributes.recycle();
        this.f42072g = dimensionPixelSize2;
        this.f42073h = integer;
        this.f42071f = (int) (((float) (dimensionPixelSize * 2)) * f);
        m29678a(dimensionPixelSize, f, color, color2);
        setRadiusAndScale(dimensionPixelSize, f);
        this.f42070e = this.f42076k ? 1 : 0;
    }

    /* renamed from: a */
    private void m29678a(int i, float f, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f42073h; i4++) {
            final Dot create = Dot.create(this.f42071f, 1.0f / this.f42074i, i2, i3);
            create.animator = ValueAnimator.ofFloat(new float[]{0.0f, (float) this.f42073h});
            if (i4 > 0) {
                create.animator.setStartDelay((long) (((double) this.mDuration) * 0.8d * ((double) i4)));
            }
            create.animator.setDuration((long) (this.mDuration * (this.f42073h + 1)));
            create.animator.setRepeatCount(-1);
            create.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction() * 3.0f;
                    if (animatedFraction > 1.0f) {
                        animatedFraction = 0.0f;
                    }
                    Dot dot = create;
                    if (((double) animatedFraction) > 0.5d) {
                        animatedFraction = 1.0f - animatedFraction;
                    }
                    dot.updateFactor(animatedFraction * 2.0f);
                    if (DotLoadingView.this.getVisibility() == 0) {
                        ViewCompat.postInvalidateOnAnimation(DotLoadingView.this);
                    }
                }
            });
            arrayList.add(create.animator);
            this.f42077l.add(create);
        }
        setRadiusAndScale(i, f);
        this.f42078m.playTogether(arrayList);
    }

    /* renamed from: a */
    private int m29676a(int i) {
        if (i == 0) {
            return 0;
        }
        return ContextCompat.getColor(getContext(), i);
    }

    private static class Dot {
        private static ArgbEvaluator sArgbEvaluator = new ArgbEvaluator();
        ValueAnimator animator;
        GradientDrawable drawable;
        int endColor;
        float factor = 0.0f;
        float scale;
        int startColor;
        int width;

        private Dot() {
        }

        public static Dot create(int i, float f, int i2, int i3) {
            Dot dot = new Dot();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius((float) (i / 2));
            gradientDrawable.setColor(i2);
            gradientDrawable.setShape(1);
            dot.drawable = gradientDrawable;
            dot.width = i;
            dot.startColor = i2;
            dot.endColor = i3;
            dot.scale = f;
            return dot;
        }

        /* access modifiers changed from: package-private */
        public void draw(Canvas canvas, int i, int i2, int i3, int i4) {
            int i5 = this.width;
            int i6 = (i3 * (i4 + i5)) + i;
            int i7 = ((int) ((1.0f - this.factor) * (((float) i5) * (1.0f - this.scale)))) / 2;
            this.drawable.setBounds(i6 + i7, i2 + i7, (i6 + i5) - i7, (i2 + i5) - i7);
            this.drawable.setColor(((Integer) sArgbEvaluator.evaluate(this.factor, Integer.valueOf(this.startColor), Integer.valueOf(this.endColor))).intValue());
            this.drawable.draw(canvas);
        }

        /* access modifiers changed from: package-private */
        public void updateFactor(float f) {
            this.factor = f;
        }

        /* access modifiers changed from: package-private */
        public void updateColor(int i, int i2) {
            this.startColor = i;
            this.endColor = i2;
        }
    }
}
