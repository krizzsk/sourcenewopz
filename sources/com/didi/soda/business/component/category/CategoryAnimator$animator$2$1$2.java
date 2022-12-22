package com.didi.soda.business.component.category;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\u000b\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/business/component/category/CategoryAnimator$animator$2$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CategoryAnimator.kt */
public final class CategoryAnimator$animator$2$1$2 extends AnimatorListenerAdapter {
    final /* synthetic */ CategoryAnimator this$0;

    CategoryAnimator$animator$2$1$2(CategoryAnimator categoryAnimator) {
        this.this$0 = categoryAnimator;
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        this.this$0.getTargetView().setVisibility(0);
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.this$0.f39393e.invoke();
    }
}
