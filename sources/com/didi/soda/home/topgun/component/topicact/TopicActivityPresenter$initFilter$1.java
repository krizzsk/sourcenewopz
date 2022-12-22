package com.didi.soda.home.topgun.component.topicact;

import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.component.filter.OnFilterEvent;
import com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/home/topgun/component/topicact/TopicActivityPresenter$initFilter$1", "Lcom/didi/soda/home/topgun/component/filter/OnFilterEvent;", "onConfirm", "", "filterDataManager", "Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActivityPresenter.kt */
public final class TopicActivityPresenter$initFilter$1 implements OnFilterEvent {
    final /* synthetic */ TopicActivityPresenter this$0;

    TopicActivityPresenter$initFilter$1(TopicActivityPresenter topicActivityPresenter) {
        this.this$0 = topicActivityPresenter;
    }

    public void onConfirm(FilterDataManager filterDataManager) {
        Intrinsics.checkNotNullParameter(filterDataManager, "filterDataManager");
        this.this$0.m30392i();
        this.this$0.m30370a(filterDataManager);
        ActivityDataSource access$getDataSource$p = this.this$0.f42912c;
        if (access$getDataSource$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            access$getDataSource$p = null;
        }
        HomeFeedParam homeFeedParam = access$getDataSource$p.getHomeFeedParam();
        if (homeFeedParam != null) {
            homeFeedParam.setIsFilter(true);
        }
        this.this$0.m30393j();
    }
}
