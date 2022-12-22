package com.didi.soda.globalcart.anim;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"com/didi/soda/globalcart/anim/TotalPriceAnim$run$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "last", "", "getLast", "()I", "setLast", "(I)V", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TotalPriceAnim.kt */
public final class TotalPriceAnim$run$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ Function1<String, Unit> $setTextBlock;
    private int last = -1;
    final /* synthetic */ TotalPriceAnim this$0;

    TotalPriceAnim$run$1(Function1<? super String, Unit> function1, TotalPriceAnim totalPriceAnim) {
        this.$setTextBlock = function1;
        this.this$0 = totalPriceAnim;
    }

    public final int getLast() {
        return this.last;
    }

    public final void setLast(int i) {
        this.last = i;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator != null) {
            Function1<String, Unit> function1 = this.$setTextBlock;
            TotalPriceAnim totalPriceAnim = this.this$0;
            int last2 = getLast();
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (!(animatedValue instanceof Integer) || last2 != ((Number) animatedValue).intValue()) {
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                if (animatedValue2 != null) {
                    setLast(((Integer) animatedValue2).intValue());
                    function1.invoke(totalPriceAnim.m29790a());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }
}
