package com.didi.rfusion.widget.floating;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler;
import com.taxis99.R;
import java.util.ArrayList;

public class RFFloatingChangeHandler extends AnimatorChangeHandler {

    /* renamed from: a */
    private static final String f33546a = "RFFloatingChangeHandler";

    /* renamed from: b */
    private static final int f33547b = 255;

    /* renamed from: c */
    private View f33548c;

    /* renamed from: d */
    private View f33549d;

    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
    }

    public RFFloatingChangeHandler() {
    }

    public RFFloatingChangeHandler(boolean z) {
        super(z);
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z && view2 != null) {
            m23618a(view2);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) m23620c(), 0.0f});
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RFFloatingChangeHandler.this.m23619b(valueAnimator);
                }
            });
            arrayList.add(ofFloat);
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23619b(ValueAnimator valueAnimator) {
        m23616a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public Animator getExitAnimator(View view) {
        m23618a(view);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f33549d.getTranslationY(), (float) m23620c()});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFFloatingChangeHandler.this.m23617a(valueAnimator);
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23617a(ValueAnimator valueAnimator) {
        m23616a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: a */
    private void m23618a(View view) {
        this.f33548c = view.findViewById(R.id.rf_fl_floating);
        this.f33549d = view.findViewById(R.id.rf_rrl_frame);
    }

    /* renamed from: a */
    private void m23616a(float f) {
        float min = Math.min(Math.max(f, 0.0f), (float) m23620c());
        float c = 1.0f - (min / ((float) m23620c()));
        this.f33549d.setTranslationY(min);
        this.f33548c.getBackground().setAlpha((int) (c * 255.0f));
    }

    /* renamed from: c */
    private int m23620c() {
        return this.f33548c.getHeight() - this.f33549d.getTop();
    }
}
