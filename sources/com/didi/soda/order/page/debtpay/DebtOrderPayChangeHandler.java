package com.didi.soda.order.page.debtpay;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler;
import com.taxis99.R;
import java.util.ArrayList;

public class DebtOrderPayChangeHandler extends AnimatorChangeHandler {

    /* renamed from: a */
    private View f43524a;

    /* renamed from: b */
    private View f43525b;

    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
    }

    public DebtOrderPayChangeHandler() {
    }

    public DebtOrderPayChangeHandler(boolean z) {
        super(z);
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z && view2 != null) {
            m30862a(view2);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f43524a, View.TRANSLATION_Y, new float[]{(float) this.f43524a.getHeight(), 0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f43525b, View.ALPHA, new float[]{this.f43525b.getAlpha(), 1.0f});
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
        } else if (!z && view != null) {
            m30862a(view);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f43524a, View.TRANSLATION_Y, new float[]{0.0f, (float) this.f43524a.getHeight()});
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f43525b, View.ALPHA, new float[]{this.f43525b.getAlpha(), 0.0f});
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
        }
        animatorSet.setDuration(300);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    /* renamed from: a */
    private void m30862a(View view) {
        this.f43525b = view.findViewById(R.id.customer_view_alph_black);
        this.f43524a = view.findViewById(R.id.customer_ll_content);
    }
}
