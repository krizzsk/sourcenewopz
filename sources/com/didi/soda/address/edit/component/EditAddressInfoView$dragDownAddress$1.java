package com.didi.soda.address.edit.component;

import android.animation.ValueAnimator;
import com.didi.common.map.model.LatLng;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoView.kt */
final class EditAddressInfoView$dragDownAddress$1 extends Lambda implements Function1<ValueAnimator, Unit> {
    final /* synthetic */ LatLng $centerLatLng;
    final /* synthetic */ EditAddressInfoView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditAddressInfoView$dragDownAddress$1(EditAddressInfoView editAddressInfoView, LatLng latLng) {
        super(1);
        this.this$0 = editAddressInfoView;
        this.$centerLatLng = latLng;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ValueAnimator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            this.this$0.m27449a(this.$centerLatLng, (int) ((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
