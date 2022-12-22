package com.didi.soda.globalcart.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/globalcart/anim/TotalPriceAnim$run$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TotalPriceAnim.kt */
public final class TotalPriceAnim$run$2 extends AnimatorListenerAdapter {
    final /* synthetic */ Function1<String, Unit> $setTextBlock;
    final /* synthetic */ TotalPriceAnim this$0;

    TotalPriceAnim$run$2(Function1<? super String, Unit> function1, TotalPriceAnim totalPriceAnim) {
        this.$setTextBlock = function1;
        this.this$0 = totalPriceAnim;
    }

    public void onAnimationEnd(Animator animator) {
        this.$setTextBlock.invoke(this.this$0.f42277a);
    }

    public void onAnimationCancel(Animator animator) {
        this.$setTextBlock.invoke(this.this$0.f42277a);
    }
}
