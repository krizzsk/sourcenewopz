package com.didi.soda.home.component.bub;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.home.bub.TaskBubModel;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/home/component/bub/HomeBubPresenter$onCreate$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/soda/home/bub/TaskBubModel;", "call", "", "t", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeBubPresenter.kt */
public final class HomeBubPresenter$onCreate$1 implements Action1<TaskBubModel> {
    final /* synthetic */ HomeBubPresenter this$0;

    HomeBubPresenter$onCreate$1(HomeBubPresenter homeBubPresenter) {
        this.this$0 = homeBubPresenter;
    }

    public void call(TaskBubModel taskBubModel) {
        Unit unit = null;
        if (taskBubModel != null) {
            HomeBubPresenter homeBubPresenter = this.this$0;
            HomeBubView homeBubView = (HomeBubView) homeBubPresenter.getLogicView();
            if (homeBubView != null) {
                homeBubView.visibleView();
            }
            HomeBubView homeBubView2 = (HomeBubView) homeBubPresenter.getLogicView();
            if (homeBubView2 != null) {
                homeBubView2.randerView(taskBubModel);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            HomeBubPresenter$onCreate$1 homeBubPresenter$onCreate$1 = this;
            HomeBubView homeBubView3 = (HomeBubView) this.this$0.getLogicView();
            if (homeBubView3 != null) {
                homeBubView3.goneView();
            }
        }
    }
}
