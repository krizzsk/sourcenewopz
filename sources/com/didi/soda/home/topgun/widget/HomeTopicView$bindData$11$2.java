package com.didi.soda.home.topgun.widget;

import com.didi.soda.home.topgun.binder.HomeTopicBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeTopicView.kt */
final class HomeTopicView$bindData$11$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HomeBusinessInfoRvModel $shopModel;
    final /* synthetic */ HomeTopicView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeTopicView$bindData$11$2(HomeTopicView homeTopicView, HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        super(0);
        this.this$0 = homeTopicView;
        this.$shopModel = homeBusinessInfoRvModel;
    }

    public final void invoke() {
        HomeTopicBinder.Companion.Logic logic = this.this$0.getLogic();
        if (logic != null) {
            logic.showItemShop(this.$shopModel);
        }
    }
}
