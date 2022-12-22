package com.didi.safetoolkit.business.emergency.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;

public class SfRippleAnimationLayout extends RelativeLayout {

    /* renamed from: a */
    private static final int f34356a = 2;

    /* renamed from: b */
    private static final int f34357b = 1500;

    /* renamed from: c */
    private static final float f34358c = 1.8f;

    /* renamed from: d */
    private static final float f34359d = 0.0f;

    /* renamed from: e */
    private static final float f34360e = 110.0f;

    /* renamed from: f */
    private int f34361f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f34362g;

    /* renamed from: h */
    private float f34363h;

    /* renamed from: i */
    private int f34364i;

    /* renamed from: j */
    private int f34365j;

    /* renamed from: k */
    private int f34366k;

    /* renamed from: l */
    private float f34367l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Paint f34368m;

    /* renamed from: n */
    private boolean f34369n;

    /* renamed from: o */
    private AnimatorSet f34370o;

    /* renamed from: p */
    private ArrayList<RippleView> f34371p;

    public SfRippleAnimationLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SfRippleAnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34369n = false;
        this.f34371p = new ArrayList<>();
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.SfRippleAnimationLayout);
            this.f34361f = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.sf_color_6FFF525D));
            this.f34362g = obtainStyledAttributes.getDimension(5, 0.0f);
            this.f34363h = obtainStyledAttributes.getDimension(3, f34360e);
            this.f34364i = obtainStyledAttributes.getInt(2, 1500);
            this.f34365j = obtainStyledAttributes.getInt(1, 2);
            this.f34367l = obtainStyledAttributes.getFloat(4, f34358c);
            obtainStyledAttributes.recycle();
            this.f34366k = this.f34364i / this.f34365j;
            Paint paint = new Paint(1);
            this.f34368m = paint;
            if (this.f34362g > 0.0f) {
                paint.setStyle(Paint.Style.STROKE);
            } else {
                paint.setStyle(Paint.Style.FILL);
            }
            this.f34368m.setColor(this.f34361f);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f34370o = animatorSet;
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            float f = this.f34363h;
            float f2 = this.f34362g;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ((f + f2) * 2.0f), (int) ((f + f2) * 2.0f));
            layoutParams.addRule(13, -1);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f34365j; i++) {
                RippleView rippleView = new RippleView(getContext());
                addView(rippleView, layoutParams);
                this.f34371p.add(rippleView);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rippleView, "ScaleX", new float[]{1.0f, this.f34367l});
                ofFloat.setRepeatCount(-1);
                ofFloat.setRepeatMode(1);
                ofFloat.setStartDelay((long) (this.f34366k * i));
                ofFloat.setDuration((long) this.f34364i);
                arrayList.add(ofFloat);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(rippleView, "ScaleY", new float[]{1.0f, this.f34367l});
                ofFloat2.setRepeatCount(-1);
                ofFloat2.setRepeatMode(1);
                ofFloat2.setStartDelay((long) (this.f34366k * i));
                ofFloat2.setDuration((long) this.f34364i);
                arrayList.add(ofFloat2);
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(rippleView, "Alpha", new float[]{1.0f, 0.0f});
                ofFloat3.setRepeatCount(-1);
                ofFloat3.setRepeatMode(1);
                ofFloat3.setStartDelay((long) (this.f34366k * i));
                ofFloat3.setDuration((long) this.f34364i);
                arrayList.add(ofFloat3);
            }
            this.f34370o.playTogether(arrayList);
        }
    }

    public void startRippleAnimation() {
        if (!isRippleAnimationRunning()) {
            Iterator<RippleView> it = this.f34371p.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(0);
            }
            this.f34370o.start();
            this.f34369n = true;
        }
    }

    public void stopRippleAnimation() {
        if (isRippleAnimationRunning()) {
            this.f34370o.end();
            this.f34369n = false;
            Iterator<RippleView> it = this.f34371p.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(4);
            }
        }
    }

    public boolean isRippleAnimationRunning() {
        return this.f34369n;
    }

    private class RippleView extends View {
        public RippleView(Context context) {
            super(context);
            setVisibility(4);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            float min = (float) (Math.min(getWidth(), getHeight()) / 2);
            canvas.drawCircle(min, min, min - SfRippleAnimationLayout.this.f34362g, SfRippleAnimationLayout.this.f34368m);
        }
    }
}
