package com.scwang.smart.refresh.horizontal;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.AbsListView;
import com.scwang.smart.refresh.layout.util.SmartUtil;
import com.scwang.smart.refresh.layout.wrapper.RefreshContentWrapper;

public class RefreshContentHorizontal extends RefreshContentWrapper {
    RefreshContentHorizontal(View view) {
        super(view);
    }

    public ValueAnimator.AnimatorUpdateListener scrollContentWhenFinished(int i) {
        if (this.mScrollableView == null || i == 0) {
            return null;
        }
        if ((i >= 0 || !ScrollBoundaryHorizontal.canScrollRight(this.mScrollableView)) && (i <= 0 || !ScrollBoundaryHorizontal.canScrollLeft(this.mScrollableView))) {
            return null;
        }
        this.mLastSpinner = i;
        return this;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            if (this.mScrollableView instanceof AbsListView) {
                SmartUtil.scrollListBy((AbsListView) this.mScrollableView, intValue - this.mLastSpinner);
            } else {
                this.mScrollableView.scrollBy(intValue - this.mLastSpinner, 0);
            }
        } catch (Throwable unused) {
        }
        this.mLastSpinner = intValue;
    }
}
