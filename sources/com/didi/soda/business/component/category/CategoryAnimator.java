package com.didi.soda.business.component.category;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0014\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0014\u0010\u001a\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/business/component/category/CategoryAnimator;", "Ljava/lang/Runnable;", "targetView", "Landroid/view/View;", "backgroundView", "(Landroid/view/View;Landroid/view/View;)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "Lkotlin/Lazy;", "animatorCallback", "Lkotlin/Function0;", "", "getBackgroundView", "()Landroid/view/View;", "isReverse", "", "getTargetView", "changeBackground", "fraction", "", "reverse", "callback", "run", "start", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CategoryAnimator.kt */
public final class CategoryAnimator implements Runnable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final ArgbEvaluator f39388f = new ArgbEvaluator();

    /* renamed from: a */
    private final View f39389a;

    /* renamed from: b */
    private final View f39390b;

    /* renamed from: c */
    private boolean f39391c;

    /* renamed from: d */
    private final Lazy f39392d = LazyKt.lazy(new CategoryAnimator$animator$2(this));
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Function0<Unit> f39393e = CategoryAnimator$animatorCallback$1.INSTANCE;

    public CategoryAnimator(View view, View view2) {
        Intrinsics.checkNotNullParameter(view, "targetView");
        Intrinsics.checkNotNullParameter(view2, "backgroundView");
        this.f39389a = view;
        this.f39390b = view2;
    }

    public final View getBackgroundView() {
        return this.f39390b;
    }

    public final View getTargetView() {
        return this.f39389a;
    }

    /* renamed from: a */
    private final ValueAnimator m27874a() {
        Object value = this.f39392d.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-animator>(...)");
        return (ValueAnimator) value;
    }

    public void run() {
        if (this.f39391c) {
            m27874a().reverse();
        } else {
            m27874a().start();
        }
    }

    public final void start(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.f39393e = function0;
        this.f39391c = false;
        this.f39389a.setVisibility(4);
        this.f39389a.post(this);
    }

    public final void reverse(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.f39393e = function0;
        this.f39391c = true;
        this.f39389a.post(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27875a(float f) {
        int color = ResourceHelper.getColor(R.color.rf_color_white_100_alpha_0);
        int color2 = ResourceHelper.getColor(R.color.rf_color_gery_12_0_7F000000);
        View view = this.f39390b;
        Object evaluate = f39388f.evaluate(f, Integer.valueOf(color), Integer.valueOf(color2));
        if (evaluate != null) {
            view.setBackgroundColor(((Integer) evaluate).intValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/business/component/category/CategoryAnimator$Companion;", "", "()V", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "getArgbEvaluator", "()Landroid/animation/ArgbEvaluator;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CategoryAnimator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArgbEvaluator getArgbEvaluator() {
            return CategoryAnimator.f39388f;
        }
    }
}
