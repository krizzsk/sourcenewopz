package com.didi.component.evaluateentrance.evaluate.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class LinearLayoutAnimator extends LinearLayout {

    /* renamed from: a */
    private static final String f13555a = "FrameLayoutAnimator";

    /* renamed from: b */
    private ValueAnimator f13556b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f13557c = false;

    /* renamed from: d */
    private boolean f13558d = false;

    public LinearLayoutAnimator(Context context) {
        super(context);
        m9309a();
    }

    public LinearLayoutAnimator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9309a();
    }

    public LinearLayoutAnimator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9309a();
    }

    public LinearLayoutAnimator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m9309a();
    }

    /* renamed from: a */
    private void m9309a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f13556b = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayoutAnimator.this.setLayoutHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.f13556b.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = LinearLayoutAnimator.this.f13557c = false;
                LinearLayoutAnimator.this.setLayoutHeight(-2);
            }
        });
        this.f13556b.setDuration(400);
    }

    public void setEnableAnimator(boolean z) {
        this.f13558d = z;
    }

    public ValueAnimator getValueAnimator() {
        return this.f13556b;
    }

    /* access modifiers changed from: private */
    public void setLayoutHeight(int i) {
        if (getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = i;
            setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int measuredHeight = getMeasuredHeight();
        super.onMeasure(i, i2);
        int measuredHeight2 = getMeasuredHeight();
        if (this.f13558d && !this.f13557c && Math.abs(measuredHeight - measuredHeight2) >= 5) {
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            this.f13557c = true;
            this.f13556b.setIntValues(new int[]{measuredHeight, measuredHeight2});
            this.f13556b.start();
        }
    }
}
