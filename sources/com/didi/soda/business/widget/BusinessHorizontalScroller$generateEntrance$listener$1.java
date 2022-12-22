package com.didi.soda.business.widget;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, mo175978d2 = {"com/didi/soda/business/widget/BusinessHorizontalScroller$generateEntrance$listener$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessHorizontalScroller.kt */
public final class BusinessHorizontalScroller$generateEntrance$listener$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ View $entranceView;
    final /* synthetic */ ViewGroup $root;

    BusinessHorizontalScroller$generateEntrance$listener$1(View view, ViewGroup viewGroup) {
        this.$entranceView = view;
        this.$root = viewGroup;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        View view2 = this.$entranceView;
        Float valueOf = view2 == null ? null : Float.valueOf(view2.getX());
        View view3 = this.$entranceView;
        int i9 = 0;
        if (Intrinsics.areEqual(valueOf, (float) (i3 - ((view3 == null || (layoutParams2 = view3.getLayoutParams()) == null) ? 0 : layoutParams2.width)))) {
            this.$root.removeOnLayoutChangeListener(this);
            return;
        }
        View view4 = this.$entranceView;
        if (view4 != null) {
            if (!(view4 == null || (layoutParams = view4.getLayoutParams()) == null)) {
                i9 = layoutParams.width;
            }
            view4.setX((float) (i3 - i9));
        }
    }
}
