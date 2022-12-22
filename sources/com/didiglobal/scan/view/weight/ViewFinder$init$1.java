package com.didiglobal.scan.view.weight;

import android.animation.ValueAnimator;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ViewFinder.kt */
final class ViewFinder$init$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ ViewFinder this$0;

    ViewFinder$init$1(ViewFinder viewFinder) {
        this.this$0 = viewFinder;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
        if (animatedValue instanceof Float) {
            this.this$0.m36803a(((Number) animatedValue).floatValue());
        }
    }
}
