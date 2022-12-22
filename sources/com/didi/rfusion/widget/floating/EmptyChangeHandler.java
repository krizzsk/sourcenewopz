package com.didi.rfusion.widget.floating;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.FadeChangeHandler;

public class EmptyChangeHandler extends FadeChangeHandler {
    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
    }

    public EmptyChangeHandler() {
    }

    public EmptyChangeHandler(boolean z) {
        super(z);
    }

    public EmptyChangeHandler(long j) {
        super(j);
    }

    public EmptyChangeHandler(long j, boolean z) {
        super(j, z);
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ValueAnimator.ofInt(new int[]{0, 1})});
        return animatorSet;
    }

    public ControllerChangeHandler copy() {
        return new EmptyChangeHandler(getAnimationDuration(), removesFromViewOnPush());
    }
}
