package com.didi.soda.business.component.category;

import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CategoryAnimator.kt */
final class CategoryAnimator$animator$2 extends Lambda implements Function0<ValueAnimator> {
    final /* synthetic */ CategoryAnimator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CategoryAnimator$animator$2(CategoryAnimator categoryAnimator) {
        super(0);
        this.this$0 = categoryAnimator;
    }

    public final ValueAnimator invoke() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{-this.this$0.getTargetView().getMeasuredHeight(), 0});
        CategoryAnimator categoryAnimator = this.this$0;
        ofInt.setDuration(200);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CategoryAnimator$animator$2.m46806invoke$lambda1$lambda0(CategoryAnimator.this, valueAnimator);
            }
        });
        ofInt.addListener(new CategoryAnimator$animator$2$1$2(categoryAnimator));
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m46806invoke$lambda1$lambda0(CategoryAnimator categoryAnimator, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(categoryAnimator, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            categoryAnimator.getTargetView().setTranslationY((float) ((Integer) animatedValue).intValue());
            categoryAnimator.m27875a(valueAnimator.getAnimatedFraction());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
