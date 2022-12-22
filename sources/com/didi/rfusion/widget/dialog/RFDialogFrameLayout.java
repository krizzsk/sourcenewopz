package com.didi.rfusion.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.rfusion.utils.RFResUtils;
import com.taxis99.R;

public class RFDialogFrameLayout extends DialogFrameLayout {

    /* renamed from: a */
    private static final String f33508a = "RFDialogFrameLayout";

    /* renamed from: b */
    private int f33509b = 0;

    /* renamed from: c */
    private int f33510c = 0;

    /* renamed from: d */
    private Animator f33511d;

    /* access modifiers changed from: protected */
    public TimeInterpolator getTimeInterpolator(boolean z, Dialog dialog) {
        return null;
    }

    public RFDialogFrameLayout(Context context) {
        super(context);
    }

    public RFDialogFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RFDialogFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private static Animator m23594a(int i, int i2, boolean z, View view, Animator animator, TimeInterpolator timeInterpolator) {
        AnimatorSet animatorSet;
        if (i == 1 && z) {
            view.setAlpha(0.0f);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{view.getAlpha(), 1.0f}));
        } else if (i != 0 || z) {
            animatorSet = null;
        } else {
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{view.getAlpha(), 0.0f}));
        }
        if (i2 > 0) {
            view.setBackgroundColor(RFResUtils.getColor(R.color.rf_color_gery_13_0_B3000000));
        } else {
            view.setBackgroundColor(RFResUtils.getColor(R.color.rf_color_white_100_alpha_0));
        }
        if (animatorSet != null) {
            if (animator != null) {
                animator.end();
            }
            if (timeInterpolator != null) {
                animatorSet.setInterpolator(timeInterpolator);
            }
            animatorSet.setDuration(300);
            animatorSet.start();
        }
        return animatorSet;
    }

    public void onDialogChange(Dialog dialog, Dialog dialog2, boolean z) {
        TimeInterpolator timeInterpolator;
        if (z) {
            this.f33509b++;
            if (isShowBackground(dialog)) {
                this.f33510c++;
            }
            timeInterpolator = getTimeInterpolator(true, dialog);
        } else {
            this.f33509b--;
            if (isShowBackground(dialog2)) {
                this.f33510c--;
            }
            timeInterpolator = getTimeInterpolator(false, dialog2);
        }
        this.f33511d = m23594a(this.f33509b, this.f33510c, z, this, this.f33511d, timeInterpolator);
    }

    /* access modifiers changed from: protected */
    public boolean isShowBackground(Dialog dialog) {
        if (dialog instanceof RFDialog) {
            return ((RFDialog) dialog).isShadowShow();
        }
        return true;
    }
}
