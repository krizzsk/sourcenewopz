package com.didiglobal.p205sa.biz.component.ridecard;

import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didiglobal/sa/biz/component/ridecard/RideCardView$updataBaseView$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.ridecard.RideCardView$updataBaseView$1 */
/* compiled from: RideCardView.kt */
public final class RideCardView$updataBaseView$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ RideCardView this$0;

    RideCardView$updataBaseView$1(RideCardView rideCardView) {
        this.this$0 = rideCardView;
    }

    public void onGlobalLayout() {
        RideCardPresenter access$getPresenter$p;
        this.this$0.f51061h.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.this$0.m36584a("onglobalLayout");
        if (this.this$0.m36577a().left > 0 && (access$getPresenter$p = this.this$0.f51056c) != null) {
            access$getPresenter$p.doPublish("event_map_reset_map", this.this$0.m36577a());
        }
    }
}
