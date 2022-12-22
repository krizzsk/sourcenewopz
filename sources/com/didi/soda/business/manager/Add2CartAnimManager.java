package com.didi.soda.business.manager;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.blocks.widget.image.BackgroundDrawable;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/business/manager/Add2CartAnimManager;", "", "()V", "CIRCLE_END_VALUE", "", "createAndStartBackgroundAnimation", "", "targetView", "Landroid/view/View;", "virtualGoodsView", "adapter", "Landroid/animation/AnimatorListenerAdapter;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Add2CartAnimManager.kt */
public final class Add2CartAnimManager {
    public static final Add2CartAnimManager INSTANCE = new Add2CartAnimManager();

    /* renamed from: a */
    private static final int f39667a = ResourceHelper.getDimensionPixelSize(R.dimen.customer_32px);

    private Add2CartAnimManager() {
    }

    @JvmStatic
    public static final void createAndStartBackgroundAnimation(View view, View view2, AnimatorListenerAdapter animatorListenerAdapter) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(view, "targetView");
        Intrinsics.checkNotNullParameter(view2, "virtualGoodsView");
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{view.getWidth(), f39667a});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Add2CartAnimManager.m28247a(View.this, valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{ResourceHelper.getDimensionPixelSize(R.dimen.customer_60px), f39667a});
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Add2CartAnimManager.m28248b(View.this, valueAnimator);
            }
        });
        Drawable background = view2.getBackground();
        if (background instanceof GradientDrawable) {
            drawable = (GradientDrawable) view2.getBackground().mutate();
        } else if (background instanceof BackgroundDrawable) {
            drawable = (BackgroundDrawable) view2.getBackground().mutate();
        } else {
            drawable = new GradientDrawable();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px), (float) (f39667a / 2)});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(drawable) {
            public final /* synthetic */ Drawable f$0;

            {
                this.f$0 = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Add2CartAnimManager.m28246a(this.f$0, valueAnimator);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{view2.getAlpha(), 1.0f});
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Add2CartAnimManager.m28249c(View.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        List arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(ofInt, "widthAnimator");
        arrayList.add(ofInt);
        Intrinsics.checkNotNullExpressionValue(ofInt2, "heightAnimator");
        arrayList.add(ofInt2);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "radiusAnimator");
        arrayList.add(ofFloat);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "alphaAnimator");
        arrayList.add(ofFloat2);
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(250);
        animatorSet.setInterpolator(CustomerInterpolator.newInstance());
        if (animatorListenerAdapter != null) {
            animatorSet.addListener(animatorListenerAdapter);
        }
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28247a(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$virtualGoodsView");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            layoutParams.width = ((Integer) animatedValue).intValue();
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m28248b(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$virtualGoodsView");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            layoutParams.height = ((Integer) animatedValue).intValue();
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28246a(Drawable drawable, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(drawable, "$background");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            float[] fArr = {floatValue, floatValue, floatValue, floatValue, floatValue, floatValue, floatValue, floatValue};
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setCornerRadii(fArr);
            } else if (drawable instanceof BackgroundDrawable) {
                ((BackgroundDrawable) drawable).setBorderRadius(floatValue);
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m28249c(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$virtualGoodsView");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            view.setAlpha(((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
