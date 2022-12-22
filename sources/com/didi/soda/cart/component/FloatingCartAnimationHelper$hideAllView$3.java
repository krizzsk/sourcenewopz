package com.didi.soda.cart.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.didi.soda.cart.component.CustomerFloatingCartView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/cart/component/FloatingCartAnimationHelper$hideAllView$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FloatingCartAnimationHelper.kt */
public final class FloatingCartAnimationHelper$hideAllView$3 extends AnimatorListenerAdapter {
    final /* synthetic */ CustomerFloatingCartView.AnimationEndListener $animationEndListener;
    final /* synthetic */ boolean $hasDiscount;
    final /* synthetic */ FloatingCartAnimationHelper this$0;

    FloatingCartAnimationHelper$hideAllView$3(FloatingCartAnimationHelper floatingCartAnimationHelper, boolean z, CustomerFloatingCartView.AnimationEndListener animationEndListener) {
        this.this$0 = floatingCartAnimationHelper;
        this.$hasDiscount = z;
        this.$animationEndListener = animationEndListener;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.this$0.f39964m.setVisibility(8);
        this.this$0.f39961j.setVisibility(8);
        this.this$0.f39963l.setImageResource(R.drawable.customer_frame_anim_ic_shopping_bag_open);
        if (this.$hasDiscount) {
            this.this$0.f39955d.setVisibility(0);
        } else {
            this.this$0.f39955d.setVisibility(8);
            this.this$0.f39966o.setAlpha(0.0f);
        }
        this.this$0.f39961j.setTranslationY(0.0f);
        this.this$0.f39964m.setTranslationY(0.0f);
        this.this$0.f39955d.setTranslationY(0.0f);
        this.this$0.f39965n.setAlpha(0.0f);
        this.$animationEndListener.onClearData();
        AnimatorSet access$getExpandAnimatorSet$p = this.this$0.f39970s;
        if (access$getExpandAnimatorSet$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            access$getExpandAnimatorSet$p = null;
        }
        access$getExpandAnimatorSet$p.removeListener(this);
    }
}
