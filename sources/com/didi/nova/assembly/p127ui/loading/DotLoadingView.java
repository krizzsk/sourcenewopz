package com.didi.nova.assembly.p127ui.loading;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.legacy.widget.Space;
import com.didi.passenger.C10448R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.nova.assembly.ui.loading.DotLoadingView */
public class DotLoadingView extends LinearLayout implements Animatable {

    /* renamed from: a */
    private static final String f29273a = "DotLoadingView";

    /* renamed from: b */
    private static final int f29274b = 1;

    /* renamed from: c */
    private static final int f29275c = 2;

    /* renamed from: d */
    private static final int f29276d = 350;

    /* renamed from: e */
    private static final int f29277e = 1400;

    /* renamed from: f */
    private static final float f29278f = 0.75f;

    /* renamed from: g */
    private static final int f29279g = 2131100431;

    /* renamed from: h */
    private static final int f29280h = 2131100433;

    /* renamed from: i */
    private static final int f29281i = 2131167088;

    /* renamed from: j */
    private static final int f29282j = 2131167090;

    /* renamed from: k */
    private static final int f29283k = 2131167089;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f29284l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public float f29285m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f29286n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f29287o;

    /* renamed from: p */
    private float f29288p;

    /* renamed from: q */
    private int f29289q;

    /* renamed from: r */
    private int f29290r;

    /* renamed from: s */
    private int f29291s;

    /* renamed from: t */
    private View f29292t;

    /* renamed from: u */
    private View f29293u;

    /* renamed from: v */
    private View f29294v;

    /* renamed from: w */
    private AnimatorSet f29295w;

    /* renamed from: x */
    private int f29296x = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.nova.assembly.ui.loading.DotLoadingView$LoadingMode */
    public @interface LoadingMode {
    }

    public DotLoadingView(Context context) {
        super(context);
        m20651a(context, (AttributeSet) null);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20651a(context, attributeSet);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20651a(context, attributeSet);
    }

    public void start() {
        stop();
        this.f29295w.start();
    }

    public void stop() {
        AnimatorSet animatorSet;
        if (isRunning() && (animatorSet = this.f29295w) != null) {
            animatorSet.cancel();
        }
    }

    public boolean isRunning() {
        AnimatorSet animatorSet = this.f29295w;
        return animatorSet != null && animatorSet.isRunning();
    }

    public void setColor(int i, int i2) {
        this.f29287o = i;
        this.f29286n = i2;
    }

    public void setMode(int i) {
        this.f29296x = i;
        m20655b();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(m20645a(this.f29289q, i), getDefaultSize(((int) this.f29284l) * 2, i2));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            start();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        stop();
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    private void m20651a(Context context, AttributeSet attributeSet) {
        setOrientation(0);
        setGravity(17);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.DotLoadingView, 0, 0);
            this.f29287o = obtainStyledAttributes.getColor(2, m20644a(f29280h));
            this.f29286n = obtainStyledAttributes.getColor(1, m20644a(f29279g));
            this.f29285m = obtainStyledAttributes.getDimension(8, m20652b(f29282j));
            this.f29284l = obtainStyledAttributes.getDimension(7, m20652b(f29281i));
            this.f29288p = obtainStyledAttributes.getDimension(5, m20652b(f29283k));
            this.f29296x = obtainStyledAttributes.getInt(6, 1);
            this.f29291s = 1400;
            this.f29290r = (int) (((float) (1400 / 4)) * 0.75f);
            float f = this.f29285m;
            this.f29289q = (int) ((this.f29288p * 2.0f) + (f * 2.0f * 3.0f) + ((this.f29284l - f) * 2.0f));
            obtainStyledAttributes.recycle();
        }
        this.f29292t = m20648a(context, this.f29285m, this.f29287o);
        this.f29293u = m20648a(context, this.f29285m, this.f29287o);
        this.f29294v = m20648a(context, this.f29285m, this.f29287o);
        addView(this.f29292t);
        addView(m20649a(context, (int) this.f29288p));
        addView(this.f29293u);
        addView(m20649a(context, (int) this.f29288p));
        addView(this.f29294v);
        m20650a();
    }

    /* renamed from: a */
    private void m20650a() {
        this.f29295w = new AnimatorSet();
        if (this.f29296x == 2) {
            ValueAnimator a = m20647a(this.f29292t, 0);
            ValueAnimator a2 = m20647a(this.f29293u, this.f29290r);
            ValueAnimator a3 = m20647a(this.f29294v, this.f29290r * 2);
            this.f29295w.playTogether(new Animator[]{a, a2, a3});
            return;
        }
        ValueAnimator b = m20654b(this.f29292t, 0);
        ValueAnimator b2 = m20654b(this.f29293u, this.f29290r);
        ValueAnimator b3 = m20654b(this.f29294v, this.f29290r * 2);
        this.f29295w.playTogether(new Animator[]{b, b2, b3});
    }

    /* renamed from: a */
    private ValueAnimator m20647a(View view, int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setDuration((long) this.f29291s);
        ofFloat.setStartDelay((long) i);
        return ofFloat;
    }

    /* renamed from: a */
    private int m20644a(int i) {
        if (i == 0) {
            return 0;
        }
        return ContextCompat.getColor(getContext(), i);
    }

    /* renamed from: b */
    private float m20652b(int i) {
        if (i == 0) {
            return 0.0f;
        }
        return getContext().getResources().getDimension(i);
    }

    /* renamed from: a */
    private View m20648a(Context context, float f, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(i);
        gradientDrawable.setShape(1);
        View view = new View(context);
        view.setBackground(gradientDrawable);
        int i2 = (int) (f * 2.0f);
        view.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
        return view;
    }

    /* renamed from: a */
    private Space m20649a(Context context, int i) {
        Space space = new Space(context);
        space.setLayoutParams(new LinearLayout.LayoutParams(i, 1));
        return space;
    }

    /* renamed from: a */
    private int m20645a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.max(size, i);
        }
        if (mode != 1073741824) {
            return i;
        }
        return size;
    }

    /* renamed from: b */
    private ValueAnimator m20654b(final View view, int i) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 3.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setDuration((long) this.f29291s);
        ofFloat.setStartDelay((long) i);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f;
                float animatedFraction = valueAnimator.getAnimatedFraction() * 3.0f;
                if (animatedFraction > 1.0f) {
                    f = 0.0f;
                } else {
                    if (animatedFraction > 0.5f) {
                        animatedFraction = 1.0f - animatedFraction;
                    }
                    f = animatedFraction * 2.0f;
                }
                float a = (((DotLoadingView.this.f29284l - DotLoadingView.this.f29285m) * f) / DotLoadingView.this.f29285m) + 1.0f;
                view.setScaleX(a);
                view.setScaleY(a);
                DotLoadingView dotLoadingView = DotLoadingView.this;
                ((GradientDrawable) view.getBackground()).setColor(dotLoadingView.m20643a(f, dotLoadingView.f29287o, DotLoadingView.this.f29286n));
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m20643a(float f, int i, int i2) {
        int red = Color.red(i);
        int blue = Color.blue(i);
        int green = Color.green(i);
        int alpha = Color.alpha(i);
        int red2 = Color.red(i2);
        int blue2 = Color.blue(i2);
        int i3 = red2 - red;
        int i4 = blue2 - blue;
        int green2 = (int) (((float) green) + (((float) (Color.green(i2) - green)) * f));
        return Color.argb((int) (((float) alpha) + (f * ((float) (Color.alpha(i2) - alpha)))), (int) (((float) red) + (((float) i3) * f)), green2, (int) (((float) blue) + (((float) i4) * f)));
    }

    /* renamed from: b */
    private void m20655b() {
        m20650a();
    }
}
