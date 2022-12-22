package com.didi.soda.bill.widgets.notify;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "nView", "Landroid/view/View;", "mainView"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NotifyLayout.kt */
final class NotifyLayout$onMeasure$1 extends Lambda implements Function2<View, View, Unit> {
    final /* synthetic */ NotifyLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotifyLayout$onMeasure$1(NotifyLayout notifyLayout) {
        super(2);
        this.this$0 = notifyLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((View) obj, (View) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(View view, View view2) {
        Intrinsics.checkNotNullParameter(view, "nView");
        Intrinsics.checkNotNullParameter(view2, "mainView");
        Object animatedValue = this.this$0.getAnimator().getAnimatedValue();
        if (animatedValue != null) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec((int) ((((float) view2.getMeasuredHeight()) - (((float) view.getMeasuredHeight()) * ((Float) animatedValue).floatValue())) + this.this$0.f39315c), 1073741824));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
