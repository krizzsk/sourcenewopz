package com.didi.soda.address.util;

import android.view.View;
import android.view.animation.Animation;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/soda/address/util/AddressAnimHelper$scale$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddressAnimHelper.kt */
public final class AddressAnimHelper$scale$1 implements Animation.AnimationListener {
    final /* synthetic */ boolean $isGonaVisible;
    final /* synthetic */ View $target;

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    AddressAnimHelper$scale$1(boolean z, View view) {
        this.$isGonaVisible = z;
        this.$target = view;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.$isGonaVisible) {
            View view = this.$target;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.$target;
        if (view2 != null) {
            view2.setVisibility(4);
        }
    }
}
