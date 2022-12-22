package com.didi.soda.search.component.result;

import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.component.filter.OnFilterEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/search/component/result/SearchResultPresenter$initFilterEvent$2", "Lcom/didi/soda/home/topgun/component/filter/OnFilterEvent;", "onConfirm", "", "filterDataManager", "Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultPresenter.kt */
public final class SearchResultPresenter$initFilterEvent$2 implements OnFilterEvent {
    final /* synthetic */ SearchResultPresenter this$0;

    SearchResultPresenter$initFilterEvent$2(SearchResultPresenter searchResultPresenter) {
        this.this$0 = searchResultPresenter;
    }

    public void onConfirm(FilterDataManager filterDataManager) {
        Intrinsics.checkNotNullParameter(filterDataManager, "filterDataManager");
        this.this$0.confirm();
    }
}
