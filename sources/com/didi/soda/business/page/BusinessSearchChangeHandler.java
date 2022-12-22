package com.didi.soda.business.page;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.taxis99.R;
import java.util.ArrayList;

public class BusinessSearchChangeHandler extends AnimatorChangeHandler {
    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (z && view2 != null) {
            View findViewById = view2.findViewById(R.id.customer_fl_business_words_container);
            ArrayList arrayList = new ArrayList();
            if (findViewById != null) {
                float dip2px = (float) DisplayUtils.dip2px(findViewById.getContext(), 192.0f);
                findViewById.setTranslationY(dip2px);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, View.TRANSLATION_Y, new float[]{dip2px, 0.0f});
                ofFloat.setInterpolator(CustomerInterpolator.newInstance());
                ofFloat.setDuration(300);
                ofFloat.setStartDelay(100);
                arrayList.add(ofFloat);
            }
            animatorSet.playTogether(arrayList);
        } else if (!z && view != null) {
            animatorSet.play(ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f}));
        }
        return animatorSet;
    }
}
