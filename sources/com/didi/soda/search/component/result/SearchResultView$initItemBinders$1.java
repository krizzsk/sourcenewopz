package com.didi.soda.search.component.result;

import com.didi.soda.search.binder.SearchAdjustableTitleBinder;
import com.didi.soda.search.component.result.Contract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/search/component/result/SearchResultView$initItemBinders$1", "Lcom/didi/soda/search/binder/SearchAdjustableTitleBinder;", "onAdjustableTitleExpend", "", "type", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultView.kt */
public final class SearchResultView$initItemBinders$1 extends SearchAdjustableTitleBinder {
    final /* synthetic */ SearchResultView this$0;

    SearchResultView$initItemBinders$1(SearchResultView searchResultView) {
        this.this$0 = searchResultView;
    }

    public void onAdjustableTitleExpend(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        ((Contract.AbsSearchResultPresenter) this.this$0.getPresenter()).onAdjustableTitleExpend(str);
    }
}
