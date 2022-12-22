package com.didi.soda.search.component.result;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.soda.customer.listener.LoadingViewSupporter;
import com.didi.soda.search.component.base.AbsSearchResultComponent;
import com.didi.soda.search.component.header.SearchHeaderInterface;
import com.didi.soda.search.component.result.Contract;

public class SearchResultComponent extends AbsSearchResultComponent<Contract.AbsSearchResultView, Contract.AbsSearchResultPresenter> {

    /* renamed from: a */
    SearchResultView f43718a;

    /* renamed from: b */
    SearchResultPresenter f43719b;

    /* renamed from: c */
    private SearchHeaderInterface f43720c;

    public SearchResultComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void setLoadingViewSupporter(LoadingViewSupporter loadingViewSupporter) {
        if (this.f43718a == null) {
            this.f43718a = new SearchResultView();
        }
    }

    public void setSearchHeaderInterface(SearchHeaderInterface searchHeaderInterface) {
        this.f43720c = searchHeaderInterface;
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSearchResultView onCreateView() {
        if (this.f43718a == null) {
            this.f43718a = new SearchResultView();
        }
        this.f43718a.setSearchHeaderInterface(this.f43720c);
        return this.f43718a;
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSearchResultPresenter onCreatePresenter() {
        if (this.f43719b == null) {
            this.f43719b = new SearchResultPresenter();
        }
        return this.f43719b;
    }

    public void setSearchResultLayoutVisibility(int i) {
        this.f43718a.setSearchResultLayoutVisibility(i);
    }

    public void onPageResult(Bundle bundle) {
        SearchResultPresenter searchResultPresenter = this.f43719b;
        if (searchResultPresenter != null) {
            searchResultPresenter.onPageResult(bundle);
        }
    }
}
