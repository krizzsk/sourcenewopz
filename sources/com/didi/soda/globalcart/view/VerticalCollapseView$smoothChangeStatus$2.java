package com.didi.soda.globalcart.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.didi.soda.globalcart.view.VerticalCollapseView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/globalcart/view/VerticalCollapseView$smoothChangeStatus$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: VerticalCollapseView.kt */
public final class VerticalCollapseView$smoothChangeStatus$2 extends AnimatorListenerAdapter {
    final /* synthetic */ VerticalCollapseView this$0;

    VerticalCollapseView$smoothChangeStatus$2(VerticalCollapseView verticalCollapseView) {
        this.this$0 = verticalCollapseView;
    }

    public void onAnimationEnd(Animator animator) {
        VerticalCollapseView.StatusChangeListener access$getStatusListener$p = this.this$0.f42349b;
        if (access$getStatusListener$p != null) {
            access$getStatusListener$p.onAnimFinish();
        }
    }

    public void onAnimationCancel(Animator animator) {
        VerticalCollapseView.StatusChangeListener access$getStatusListener$p = this.this$0.f42349b;
        if (access$getStatusListener$p != null) {
            access$getStatusListener$p.onAnimFinish();
        }
    }
}
