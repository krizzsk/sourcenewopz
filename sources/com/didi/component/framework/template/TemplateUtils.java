package com.didi.component.framework.template;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import com.didi.component.common.animator.IGlobalXPanelAnimator;
import com.didi.component.common.animators.ViewAnimator;

public class TemplateUtils {
    public static void toggleBottomInOut(IGlobalXPanelAnimator iGlobalXPanelAnimator, boolean z, View view, IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener, boolean z2) {
        if (z2) {
            toggleBottomInOut(iGlobalXPanelAnimator, z, view, visibilityChangedListener, 0, 550);
        } else {
            toggleBottomInOut(iGlobalXPanelAnimator, z, view, visibilityChangedListener, 0);
        }
    }

    public static void toggleBottomInOut(IGlobalXPanelAnimator iGlobalXPanelAnimator, boolean z, View view, IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener, long j) {
        if (iGlobalXPanelAnimator == null) {
            return;
        }
        if (z) {
            iGlobalXPanelAnimator.initPrepare(view);
            iGlobalXPanelAnimator.show(view, j, visibilityChangedListener);
            return;
        }
        iGlobalXPanelAnimator.hide(view, j, visibilityChangedListener);
    }

    public static void toggleBottomInOut(IGlobalXPanelAnimator iGlobalXPanelAnimator, boolean z, View view, IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener, long j, long j2) {
        if (iGlobalXPanelAnimator == null) {
            return;
        }
        if (z) {
            iGlobalXPanelAnimator.initPrepare(view);
            iGlobalXPanelAnimator.show(view, j2, j, visibilityChangedListener);
            return;
        }
        iGlobalXPanelAnimator.hide(view, j2, j, visibilityChangedListener);
    }

    public static void toggleMask(final boolean z, final View view, long j) {
        ValueAnimator valueAnimator;
        if (z) {
            valueAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        } else {
            valueAnimator = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        }
        valueAnimator.setDuration(j);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                View.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.addListener(new ViewAnimator.DefaultAnimatorListener() {
            public void onAnimationStart(Animator animator) {
                if (z) {
                    view.setVisibility(0);
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (!z) {
                    view.setVisibility(8);
                }
            }
        });
        valueAnimator.start();
    }
}
