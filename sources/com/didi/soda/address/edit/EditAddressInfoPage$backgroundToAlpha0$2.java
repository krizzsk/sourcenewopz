package com.didi.soda.address.edit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/address/edit/EditAddressInfoPage$backgroundToAlpha0$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoPage.kt */
public final class EditAddressInfoPage$backgroundToAlpha0$2 extends AnimatorListenerAdapter {
    final /* synthetic */ EditAddressInfoPage this$0;

    EditAddressInfoPage$backgroundToAlpha0$2(EditAddressInfoPage editAddressInfoPage) {
        this.this$0 = editAddressInfoPage;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        this.this$0.getMBackgroundView().setVisibility(8);
    }
}
