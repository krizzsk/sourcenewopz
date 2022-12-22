package com.didi.soda.address.edit;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.VerticalChangeHandler;
import com.taxis99.R;
import java.util.ArrayList;

public class EditPageChangeHandler extends VerticalChangeHandler {
    public EditPageChangeHandler() {
    }

    public EditPageChangeHandler(boolean z) {
        super(z);
    }

    public ControllerChangeHandler copy() {
        return new EditPageChangeHandler();
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z && view2 != null) {
            View findViewById = view2.findViewById(R.id.customer_custom_confirm);
            m27426a(viewGroup, 8);
            findViewById.setAlpha(0.0f);
            ObjectAnimator duration = ObjectAnimator.ofFloat(findViewById, View.TRANSLATION_Y, new float[]{(float) findViewById.getHeight(), 0.0f}).setDuration(400);
            duration.setStartDelay(50);
            arrayList.add(duration);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(findViewById, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(400);
            duration2.setStartDelay(50);
            arrayList.add(duration2);
            arrayList.add(ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{(float) view2.getHeight(), 0.0f}));
        } else if (!z) {
            m27426a(viewGroup, 0);
            if (view != null) {
                arrayList.add(ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{(float) view.getHeight()}));
            }
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    /* renamed from: a */
    private void m27426a(View view, int i) {
        if (view != null) {
            View findViewById = view.findViewById(R.id.customer_custom_main_drawer);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            View findViewById2 = view.findViewById(R.id.customer_fl_order_root_container);
            if (findViewById2 != null) {
                findViewById2.setVisibility(i);
            }
            View findViewById3 = view.findViewById(R.id.customer_flutter_discount_root);
            if (findViewById3 != null) {
                findViewById3.setVisibility(i);
            }
            View findViewById4 = view.findViewById(R.id.customer_fl_activity_landing_container);
            if (findViewById4 != null) {
                findViewById4.setVisibility(i);
            }
            View findViewById5 = view.findViewById(R.id.customer_cl_business_parent);
            if (findViewById5 != null) {
                findViewById5.setVisibility(i);
            }
        }
    }
}
