package com.didi.soda.customer.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/customer/helper/MoveAnimationHelper$createGoodViewMoveAnimation$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MoveAnimationHelper.kt */
public final class MoveAnimationHelper$createGoodViewMoveAnimation$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ View $virtualGoodsView;
    final /* synthetic */ MoveAnimationHelper this$0;

    MoveAnimationHelper$createGoodViewMoveAnimation$1$1(MoveAnimationHelper moveAnimationHelper, View view) {
        this.this$0 = moveAnimationHelper;
        this.$virtualGoodsView = view;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        this.this$0.f41350c.removeView(this.$virtualGoodsView);
        if (this.this$0.f41349b.getObject("service_floating_cart_key") != null) {
            Object object = this.this$0.f41349b.getObject("service_floating_cart_key");
            if (object != null) {
                ((IFloatingCartProvider) object).playAddToCartAnimation(false);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider");
        }
    }
}
