package com.didi.app.nova.skeleton.conductor.changehandler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import java.util.ArrayList;

public class VerticalChangeHandler extends AnimatorChangeHandler {
    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
    }

    public VerticalChangeHandler() {
    }

    public VerticalChangeHandler(boolean z) {
        super(z);
    }

    public VerticalChangeHandler(long j) {
        super(j);
    }

    public VerticalChangeHandler(long j, boolean z) {
        super(j, z);
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z && view2 != null) {
            arrayList.add(ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{(float) view2.getHeight(), 0.0f}));
        } else if (!z && view != null) {
            arrayList.add(ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{(float) view.getHeight()}));
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    public ControllerChangeHandler copy() {
        return new VerticalChangeHandler(getAnimationDuration(), removesFromViewOnPush());
    }
}
