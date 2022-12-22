package com.didi.soda.search.component.result.binder;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.home.topgun.manager.FilterNoResultLogicRepo;
import com.didi.soda.search.component.result.SearchResultPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/search/component/result/binder/SearchResultComponentLogicUnit;", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "presenter", "Lcom/didi/soda/search/component/result/SearchResultPresenter;", "(Lcom/didi/soda/search/component/result/SearchResultPresenter;)V", "mPresent", "dealFilterLogic", "", "logicType", "", "(Ljava/lang/Integer;)V", "onBindLogic", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultComponentLogicUnit.kt */
public final class SearchResultComponentLogicUnit extends ComponentLogicUnit {

    /* renamed from: a */
    private SearchResultPresenter f43754a;

    public SearchResultComponentLogicUnit(SearchResultPresenter searchResultPresenter) {
        Intrinsics.checkNotNullParameter(searchResultPresenter, "presenter");
        this.f43754a = searchResultPresenter;
    }

    public void onBindLogic() {
        SearchResultPresenter searchResultPresenter = this.f43754a;
        if (searchResultPresenter != null && searchResultPresenter.getScopeContext() != null) {
            FilterNoResultLogicRepo filterNoResultLogicRepo = (FilterNoResultLogicRepo) getLogic(FilterNoResultLogicRepo.class);
            SearchResultPresenter searchResultPresenter2 = this.f43754a;
            filterNoResultLogicRepo.subscribe(searchResultPresenter2 == null ? null : searchResultPresenter2.getScopeContext(), new Action1(filterNoResultLogicRepo) {
                public final /* synthetic */ FilterNoResultLogicRepo f$1;

                {
                    this.f$1 = r2;
                }

                public final void call(Object obj) {
                    SearchResultComponentLogicUnit.m31080a(SearchResultComponentLogicUnit.this, this.f$1, (Integer) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31080a(SearchResultComponentLogicUnit searchResultComponentLogicUnit, FilterNoResultLogicRepo filterNoResultLogicRepo, Integer num) {
        Intrinsics.checkNotNullParameter(searchResultComponentLogicUnit, "this$0");
        searchResultComponentLogicUnit.m31081a(Integer.valueOf(filterNoResultLogicRepo.getSearchStatus()));
    }

    /* renamed from: a */
    private final void m31081a(Integer num) {
        SearchResultPresenter searchResultPresenter;
        if (num != null && num.intValue() == 1 && (searchResultPresenter = this.f43754a) != null) {
            searchResultPresenter.resetFilter();
        }
    }
}
