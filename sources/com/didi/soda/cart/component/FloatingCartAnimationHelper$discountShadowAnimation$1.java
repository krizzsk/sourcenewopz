package com.didi.soda.cart.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/cart/component/FloatingCartAnimationHelper$discountShadowAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FloatingCartAnimationHelper.kt */
public final class FloatingCartAnimationHelper$discountShadowAnimation$1 extends AnimatorListenerAdapter {
    final /* synthetic */ FloatingCartAnimationHelper this$0;

    FloatingCartAnimationHelper$discountShadowAnimation$1(FloatingCartAnimationHelper floatingCartAnimationHelper) {
        this.this$0 = floatingCartAnimationHelper;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.this$0.f39966o.setVisibility(0);
    }
}
