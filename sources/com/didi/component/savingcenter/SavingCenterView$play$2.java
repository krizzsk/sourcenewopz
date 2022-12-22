package com.didi.component.savingcenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SavingCenterView.kt */
final class SavingCenterView$play$2 implements Runnable {
    final /* synthetic */ int $offset;
    final /* synthetic */ SavingCenterView this$0;

    SavingCenterView$play$2(SavingCenterView savingCenterView, int i) {
        this.this$0 = savingCenterView;
        this.$offset = i;
    }

    public final void run() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.this$0.getMSideTextView().getWidth(), this.$offset});
        ofInt.setDuration(500);
        final SavingCenterView savingCenterView = this.this$0;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Intrinsics.checkNotNullParameter(valueAnimator, "animation");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue != null) {
                    savingCenterView.getMSideTextView().setWidth(((Integer) animatedValue).intValue());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        });
        final SavingCenterView savingCenterView2 = this.this$0;
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator, boolean z) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                savingCenterView2.setMIsPlay(false);
                savingCenterView2.getMSideTextView().setWidth(savingCenterView2.getOrinWidth());
                savingCenterView2.getMSideLayout().setVisibility(4);
            }
        });
        ofInt.start();
    }
}
