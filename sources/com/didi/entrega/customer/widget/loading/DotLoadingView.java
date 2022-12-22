package com.didi.entrega.customer.widget.loading;

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
    private static final int f20530a = 2131101506;

    /* renamed from: b */
    private static final int f20531b = 2131101506;

    /* renamed from: c */
    private static final int f20532c = 2131168258;

    /* renamed from: d */
    private static final int f20533d = 2131167534;

    /* renamed from: e */
    private int f20534e = 0;

    /* renamed from: f */
    private int f20535f;

    /* renamed from: g */
    private int f20536g;

    /* renamed from: h */
    private int f20537h;

    /* renamed from: i */
    private float f20538i;

    /* renamed from: j */
    private int f20539j;

    /* renamed from: k */
    private boolean f20540k = true;

    /* renamed from: l */
    private List<Dot> f20541l = new ArrayList();

    /* renamed from: m */
    private AnimatorSet f20542m = new AnimatorSet();
    public int mDuration = 350;

    public DotLoadingView(Context context) {
        super(context);
        m15033a((AttributeSet) null);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15033a(attributeSet);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15033a(attributeSet);
    }

    public void start() {
        if (this.f20534e == 0) {
            this.f20534e = 1;
            m15031a();
        }
    }

    public void stop() {
        if (this.f20534e == 1) {
            this.f20542m.cancel();
        }
        this.f20534e = 0;
    }

    public boolean isRunning() {
        return this.f20534e == 1;
    }

    public void setAutoRunning(boolean z) {
        this.f20540k = z;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setColor(int i, int i2) {
        for (int i3 = 0; i3 < this.f20541l.size(); i3++) {
            this.f20541l.get(i3).updateColor(i, i2);
        }
    }

    public void setRadiusAndScale(int i, float f) {
        this.f20539j = i;
        this.f20538i = f;
        this.f20535f = (int) (((float) (i * 2)) * f);
        for (int i2 = 0; i2 < this.f20541l.size(); i2++) {
            Dot dot = this.f20541l.get(i2);
            dot.scale = 1.0f / f;
            dot.width = this.f20535f;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f20540k && this.f20534e == 1) {
            m15031a();
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
        int size = this.f20541l.size();
        if (size > 0) {
            i4 = Math.max(this.f20535f, this.f20541l.get(0).drawable.getIntrinsicWidth());
            i3 = (size * i4) + (this.f20536g * (size - 1));
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
        if (getVisibility() == 0 && (size = this.f20541l.size()) > 0) {
            int max = Math.max(this.f20535f, this.f20541l.get(0).drawable.getIntrinsicWidth());
            int max2 = Math.max(((getRight() - getLeft()) >> 1) - (((size * max) + (this.f20536g * (size - 1))) >> 1), 0);
            int max3 = Math.max(((getBottom() - getTop()) >> 1) - (max >> 1), 0);
            for (int i = 0; i < this.f20541l.size(); i++) {
                this.f20541l.get(i).draw(canvas, max2, max3, i, this.f20536g);
            }
        }
    }

    /* renamed from: a */
    private void m15031a() {
        this.f20542m.start();
    }

    /* renamed from: a */
    private void m15033a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaDotLoadingView, 0, 0);
        int color = obtainStyledAttributes.getColor(2, m15030a(f20531b));
        int color2 = obtainStyledAttributes.getColor(1, m15030a(f20530a));
        this.f20540k = obtainStyledAttributes.getBoolean(0, this.f20540k);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(6, getContext().getResources().getDimensionPixelSize(f20532c));
        float f = obtainStyledAttributes.getFloat(7, 1.25f);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(5, getContext().getResources().getDimensionPixelSize(f20533d));
        int integer = obtainStyledAttributes.getInteger(3, 3);
        this.mDuration = obtainStyledAttributes.getInteger(4, this.mDuration);
        obtainStyledAttributes.recycle();
        this.f20536g = dimensionPixelSize2;
        this.f20537h = integer;
        this.f20535f = (int) (((float) (dimensionPixelSize * 2)) * f);
        m15032a(dimensionPixelSize, f, color, color2);
        setRadiusAndScale(dimensionPixelSize, f);
        this.f20534e = this.f20540k ? 1 : 0;
    }

    /* renamed from: a */
    private void m15032a(int i, float f, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f20537h; i4++) {
            final Dot create = Dot.create(this.f20535f, 1.0f / this.f20538i, i2, i3);
            create.animator = ValueAnimator.ofFloat(new float[]{0.0f, (float) this.f20537h});
            if (i4 > 0) {
                create.animator.setStartDelay((long) (((double) this.mDuration) * 0.8d * ((double) i4)));
            }
            create.animator.setDuration((long) (this.mDuration * (this.f20537h + 1)));
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
            this.f20541l.add(create);
        }
        setRadiusAndScale(i, f);
        this.f20542m.playTogether(arrayList);
    }

    /* renamed from: a */
    private int m15030a(int i) {
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
