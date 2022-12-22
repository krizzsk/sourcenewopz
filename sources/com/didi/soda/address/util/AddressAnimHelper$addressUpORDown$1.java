package com.didi.soda.address.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/address/util/AddressAnimHelper$addressUpORDown$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddressAnimHelper.kt */
public final class AddressAnimHelper$addressUpORDown$1 extends AnimatorListenerAdapter {
    final /* synthetic */ Function0<Unit> $endAction;

    AddressAnimHelper$addressUpORDown$1(Function0<Unit> function0) {
        this.$endAction = function0;
    }

    public void onAnimationEnd(Animator animator) {
        this.$endAction.invoke();
    }
}
