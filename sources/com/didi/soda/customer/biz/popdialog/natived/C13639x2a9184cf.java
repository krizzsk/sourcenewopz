package com.didi.soda.customer.biz.popdialog.natived;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.didi.soda.home.manager.CustomerGuideManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/customer/biz/popdialog/natived/PopDialogAnimateHelper$disAppearDialogWithAnimate$animatorSet$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.biz.popdialog.natived.PopDialogAnimateHelper$disAppearDialogWithAnimate$animatorSet$1$1 */
/* compiled from: PopDialogAnimateHelper.kt */
public final class C13639x2a9184cf extends AnimatorListenerAdapter {
    final /* synthetic */ DialogAnimateInterface $popView;

    C13639x2a9184cf(DialogAnimateInterface dialogAnimateInterface) {
        this.$popView = dialogAnimateInterface;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        View closedView = this.$popView.getClosedView();
        if (closedView != null) {
            closedView.setVisibility(4);
        }
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        View rootView = this.$popView.getRootView();
        if (rootView != null) {
            rootView.setVisibility(8);
        }
        CustomerGuideManager.Companion.getInstance().syncAndTriggerCustomerGuideInfoShown();
    }
}
