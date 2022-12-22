package com.didi.safetoolkit.business.triprecording.view;

import android.animation.ValueAnimator;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: RecordWaveView.kt */
final class RecordWaveView$start$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ RecordWaveView this$0;

    RecordWaveView$start$1(RecordWaveView recordWaveView) {
        this.this$0 = recordWaveView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            int intValue = ((Integer) animatedValue).intValue();
            int nextInt = new Random().nextInt(100);
            if (nextInt < 40 || intValue < 5 || intValue > this.this$0.f34507a - 5) {
                f = 0.1f;
            } else {
                f = (((float) nextInt) * (nextInt < 95 ? 0.4f : 0.7f)) / ((float) 100);
            }
            while (intValue < this.this$0.f34507a - 1 && ((RecordWaveLine) this.this$0.f34510d.get(intValue)).isStartAnimation()) {
                intValue++;
            }
            ((RecordWaveLine) this.this$0.f34510d.get(intValue)).start(f);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
