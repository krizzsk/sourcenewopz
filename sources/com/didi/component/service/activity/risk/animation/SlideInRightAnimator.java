package com.didi.component.service.activity.risk.animation;

import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.service.activity.risk.animation.BaseItemAnimator;

public class SlideInRightAnimator extends BaseItemAnimator {
    public SlideInRightAnimator() {
    }

    public SlideInRightAnimator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    /* access modifiers changed from: protected */
    public void animateRemoveImpl(RecyclerView.ViewHolder viewHolder) {
        ViewCompat.animate(viewHolder.itemView).translationX((float) viewHolder.itemView.getRootView().getWidth()).setDuration(getRemoveDuration()).setInterpolator(this.mInterpolator).setListener(new BaseItemAnimator.DefaultRemoveVpaListener(viewHolder)).setStartDelay(getRemoveDelay(viewHolder)).start();
    }

    /* access modifiers changed from: protected */
    public void preAnimateAddImpl(RecyclerView.ViewHolder viewHolder) {
        ViewCompat.setTranslationX(viewHolder.itemView, (float) viewHolder.itemView.getRootView().getWidth());
    }

    /* access modifiers changed from: protected */
    public void animateAddImpl(RecyclerView.ViewHolder viewHolder) {
        ViewCompat.animate(viewHolder.itemView).translationX(0.0f).setDuration(getAddDuration()).setInterpolator(this.mInterpolator).setListener(new BaseItemAnimator.DefaultAddVpaListener(viewHolder)).setStartDelay(getAddDelay(viewHolder)).start();
    }
}
