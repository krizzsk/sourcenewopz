package com.didi.rfusion.widget.searchbar;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: RFSearchBar.kt */
final class RFSearchBar$getAlphaAnimator$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ RFSearchBar this$0;

    RFSearchBar$getAlphaAnimator$1(RFSearchBar rFSearchBar) {
        this.this$0 = rFSearchBar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            RFSearchBar.access$getIvClose$p(this.this$0).setAlpha(((Float) animatedValue).floatValue());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
}
