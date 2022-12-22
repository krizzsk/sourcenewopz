package com.didi.map.global.component.floatingwindow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.didi.map.global.component.floatingwindow.FWController;
import com.didi.map.global.component.floatingwindow.util.C9502Util;
import com.didi.map.global.component.floatingwindow.view.IFWView;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/map/global/component/floatingwindow/FWController$animeForExpand$listeners$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FWController.kt */
public final class FWController$animeForExpand$listeners$1 extends AnimatorListenerAdapter {
    final /* synthetic */ FWController this$0;

    FWController$animeForExpand$listeners$1(FWController fWController) {
        this.this$0 = fWController;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationStart(animator);
        SystemUtils.log(3, C9502Util.TAG, "animeForExpand: start", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController$animeForExpand$listeners$1", 508);
        this.this$0.m18285a();
        this.this$0.m18291a(IFWView.FWShapeState.EXPAND);
        this.this$0.f25604s = FWController.FWAnimeState.EXPAND;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        SystemUtils.log(3, C9502Util.TAG, "animeForExpand: end", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController$animeForExpand$listeners$1", 516);
        this.this$0.f25600o = null;
        this.this$0.f25604s = FWController.FWAnimeState.NONE;
        this.this$0.m18301g();
        this.this$0.m18302h();
    }
}
