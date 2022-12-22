package com.didi.entrega.home.component.feed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.entrega.home.shimmer.ShimmerRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/home/component/feed/HomeFeedView$dismissShimmer$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedView.kt */
public final class HomeFeedView$dismissShimmer$1 extends AnimatorListenerAdapter {
    final /* synthetic */ HomeFeedView this$0;

    HomeFeedView$dismissShimmer$1(HomeFeedView homeFeedView) {
        this.this$0 = homeFeedView;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        FrameLayout access$getMHomeShimmerContainer$p = this.this$0.f20660h;
        LinearLayout linearLayout = null;
        if (access$getMHomeShimmerContainer$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeShimmerContainer");
            access$getMHomeShimmerContainer$p = null;
        }
        ShimmerRecyclerView access$getMShimmerView$p = this.this$0.f20662j;
        if (access$getMShimmerView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerView");
            access$getMShimmerView$p = null;
        }
        access$getMHomeShimmerContainer$p.removeView(access$getMShimmerView$p);
        LinearLayout access$getMHomeShimmerContainerParent$p = this.this$0.f20661i;
        if (access$getMHomeShimmerContainerParent$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeShimmerContainerParent");
        } else {
            linearLayout = access$getMHomeShimmerContainerParent$p;
        }
        linearLayout.setVisibility(8);
    }
}
