package com.didi.safetoolkit.business.triprecording.view;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: RecordWaveLine.kt */
final class RecordWaveLine$start$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ RecordWaveLine this$0;

    RecordWaveLine$start$1(RecordWaveLine recordWaveLine) {
        this.this$0 = recordWaveLine;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        RecordWaveLine recordWaveLine = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            recordWaveLine.f34504i = ((Float) animatedValue).floatValue();
            this.this$0.invalidate();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
}
