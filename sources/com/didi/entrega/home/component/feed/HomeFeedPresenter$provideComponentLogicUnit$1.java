package com.didi.entrega.home.component.feed;

import com.didi.entrega.customer.base.binder.ComponentLogicUnit;
import com.didi.entrega.home.component.feed.binder.HomerServicesCardLogicRepo;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/entrega/home/component/feed/HomeFeedPresenter$provideComponentLogicUnit$1", "Lcom/didi/entrega/customer/base/binder/ComponentLogicUnit;", "onBindLogic", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedPresenter.kt */
public final class HomeFeedPresenter$provideComponentLogicUnit$1 extends ComponentLogicUnit {
    final /* synthetic */ HomeFeedPresenter this$0;

    HomeFeedPresenter$provideComponentLogicUnit$1(HomeFeedPresenter homeFeedPresenter) {
        this.this$0 = homeFeedPresenter;
    }

    public void onBindLogic() {
        ((HomerServicesCardLogicRepo) getLogic(HomerServicesCardLogicRepo.class)).subscribe(this.this$0.getScopeContext(), new HomeFeedPresenter$provideComponentLogicUnit$1$onBindLogic$1(this.this$0));
    }
}
