package com.didi.component.never.common.animators;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.didi.component.never.common.util.UIUtils;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class ViewAnimator extends ValueAnimator {
    private static final long DEFAULT_DURATION = 500;
    protected Set<AnimatorItem>[] mAnimators;
    private ValueAnimator.AnimatorUpdateListener mUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewAnimator viewAnimator = ViewAnimator.this;
            viewAnimator.onUpdate(viewAnimator.mViews);
        }
    };
    protected View[] mViews;

    public interface AnimatorItem {
        TimeInterpolator getInterpolator();

        void onUpdate(View view, float f);

        void onViewAttached(View view);

        void setInterpolator(TimeInterpolator timeInterpolator);
    }

    public static class DefaultAnimatorListener implements Animator.AnimatorListener {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* access modifiers changed from: protected */
    public abstract void newAnimators(int i, Set<AnimatorItem> set);

    /* access modifiers changed from: protected */
    public abstract void onViewAttached(View... viewArr);

    public ViewAnimator() {
        setDuration(500);
    }

    public final ViewAnimator attachView(View... viewArr) {
        this.mViews = viewArr;
        onViewAttached(viewArr);
        int length = viewArr != null ? viewArr.length : 0;
        this.mAnimators = new LinkedHashSet[length];
        for (int i = 0; i < length; i++) {
            this.mAnimators[i] = new LinkedHashSet();
            newAnimators(i, this.mAnimators[i]);
            if (viewArr[i] != null) {
                attach(this.mAnimators[i], viewArr[i]);
            }
        }
        super.addUpdateListener(this.mUpdateListener);
        setFloatValues(new float[]{0.0f, 1.0f});
        return this;
    }

    private void attach(Set<AnimatorItem> set, View view) {
        for (AnimatorItem onViewAttached : set) {
            onViewAttached.onViewAttached(view);
        }
    }

    /* access modifiers changed from: protected */
    public final void onUpdate(View... viewArr) {
        Set<AnimatorItem>[] setArr = this.mAnimators;
        int length = setArr != null ? setArr.length : 0;
        float animatedFraction = getAnimatedFraction();
        for (int i = 0; i < length; i++) {
            for (AnimatorItem next : this.mAnimators[i]) {
                if (viewArr[i] != null) {
                    TimeInterpolator interpolator = next.getInterpolator();
                    if (interpolator != null) {
                        next.onUpdate(viewArr[i], interpolator.getInterpolation(animatedFraction));
                    } else {
                        next.onUpdate(viewArr[i], animatedFraction);
                    }
                }
            }
        }
    }

    public final void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        throw new UnsupportedOperationException("不支持外部设置AnimatorUpdateListener!");
    }

    public static abstract class ViewPairAnimator extends ViewAnimator {
        /* access modifiers changed from: protected */
        public abstract void firstViewAnimators(Set<AnimatorItem> set);

        /* access modifiers changed from: protected */
        public void onViewAttached(View... viewArr) {
        }

        /* access modifiers changed from: protected */
        public abstract void secondViewAnimators(Set<AnimatorItem> set);

        /* access modifiers changed from: protected */
        public final void newAnimators(int i, Set<AnimatorItem> set) {
            if (i == 0) {
                firstViewAnimators(set);
            } else if (i == 1) {
                secondViewAnimators(set);
            }
        }
    }

    public static abstract class BaseAnimItem implements AnimatorItem {
        protected TimeInterpolator mInterpolator;

        public void setInterpolator(TimeInterpolator timeInterpolator) {
            this.mInterpolator = timeInterpolator;
        }

        public TimeInterpolator getInterpolator() {
            return this.mInterpolator;
        }
    }

    public static int getScreenWidth(Context context) {
        return UIUtils.getScreenWidth(context);
    }

    public static int getScreenHeight(Context context) {
        return UIUtils.getScreenHeight(context);
    }
}
