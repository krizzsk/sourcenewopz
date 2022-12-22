package com.didi.soda.customer.animation.transitions;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.transition.Fade;
import android.transition.TransitionValues;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class FadeSafeOreo extends Fade {
    public FadeSafeOreo() {
    }

    public FadeSafeOreo(int i) {
        super(i);
    }

    public FadeSafeOreo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if (Build.VERSION.SDK_INT != 27) {
            return super.onDisappear(viewGroup, transitionValues, i, transitionValues2, i2);
        }
        boolean z = true;
        boolean z2 = (transitionValues == null || transitionValues.view == null) ? false : true;
        if (transitionValues2 == null || transitionValues2.view == null) {
            z = false;
        }
        RemovedView removedView = null;
        if (!canRemoveViews() && z2 && !z) {
            removedView = new RemovedView(transitionValues.view);
        }
        Animator onDisappear = super.onDisappear(viewGroup, transitionValues, i, transitionValues2, i2);
        if (removedView != null) {
            removedView.append();
        }
        return onDisappear;
    }

    private static final class RemovedView {
        private ViewGroup mParent;
        private int mPosition;
        private View mView;

        private RemovedView(View view) {
            this.mPosition = -1;
            this.mView = view;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                this.mParent = viewGroup;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (this.mParent.getChildAt(i) == view) {
                        this.mPosition = i;
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void append() {
            int i;
            View view = this.mView;
            if (view != null) {
                if (this.mParent != null) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = this.mParent;
                    if (parent != viewGroup && (i = this.mPosition) >= 0) {
                        viewGroup.addView(this.mView, i);
                    }
                    this.mParent = null;
                }
                this.mView = null;
            }
        }
    }
}
