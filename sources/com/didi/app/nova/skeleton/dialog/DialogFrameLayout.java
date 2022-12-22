package com.didi.app.nova.skeleton.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class DialogFrameLayout extends FrameLayout {

    /* renamed from: a */
    private int f8428a = 0;

    /* renamed from: b */
    private Animator f8429b;

    public DialogFrameLayout(Context context) {
        super(context);
    }

    public DialogFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DialogFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onDialogChange(Dialog dialog, Dialog dialog2, boolean z) {
        int i = this.f8428a;
        int i2 = z ? i + 1 : i - 1;
        onDialogCountChanged(this.f8428a, i2, z);
        this.f8428a = i2;
    }

    /* access modifiers changed from: protected */
    public void onDialogCountChanged(int i, int i2, boolean z) {
        AnimatorSet animatorSet = null;
        if (i2 == 1 && z) {
            Animator animator = this.f8429b;
            if (animator != null) {
                animator.end();
                this.f8429b = null;
            }
            setAlpha(0.0f);
            setBackgroundColor(Color.parseColor("#AD333740"));
            animatorSet = new AnimatorSet();
            float alpha = getAlpha();
            animatorSet.play(ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{alpha, 1.0f}));
        } else if (i2 == 0 && !z) {
            Animator animator2 = this.f8429b;
            if (animator2 != null) {
                animator2.end();
                this.f8429b = null;
            }
            animatorSet = new AnimatorSet();
            float alpha2 = getAlpha();
            animatorSet.play(ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{alpha2, 0.0f}));
        }
        if (this.f8429b == null && animatorSet != null) {
            this.f8429b = animatorSet;
            animatorSet.setDuration(400);
            this.f8429b.start();
        }
    }
}
