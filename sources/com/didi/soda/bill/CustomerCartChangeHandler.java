package com.didi.soda.bill;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler;
import java.util.ArrayList;

public class CustomerCartChangeHandler extends AnimatorChangeHandler {

    /* renamed from: a */
    int f38811a;

    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
    }

    public CustomerCartChangeHandler(int i, boolean z) {
        super(z);
        this.f38811a = i;
    }

    public CustomerCartChangeHandler() {
    }

    public ControllerChangeHandler copy() {
        return new CustomerCartChangeHandler(this.f38811a, removesFromViewOnPush());
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z && view2 != null) {
            View findViewById = view2.findViewById(this.f38811a);
            arrayList.add(ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{(float) view2.getHeight(), 0.0f}));
            findViewById.setAlpha(0.0f);
            ObjectAnimator duration = ObjectAnimator.ofFloat(findViewById, View.TRANSLATION_Y, new float[]{(float) (findViewById.getHeight() * 2), 0.0f}).setDuration(400);
            duration.setStartDelay(50);
            arrayList.add(duration);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(findViewById, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(400);
            duration2.setStartDelay(50);
            arrayList.add(duration2);
        } else if (!z && view != null) {
            arrayList.add(ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{(float) view.getHeight()}));
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }
}
