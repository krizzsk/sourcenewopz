package com.didi.soda.search.component.suggestion;

import android.view.ViewGroup;
import com.didi.soda.customer.base.rxdux.RxduxComponent;
import com.didi.soda.jadux.Reducer;
import com.didi.soda.search.component.suggestion.Contract;

public class SearchSuggestionComponent extends RxduxComponent<Contract.AbsSearchSuggestionView, SearchSuggestionPresenter, SearchSuggestionState> {

    /* renamed from: a */
    SearchSugListener f43755a;

    public SearchSuggestionComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void setOnNoSugListener(SearchSugListener searchSugListener) {
        this.f43755a = searchSugListener;
    }

    /* access modifiers changed from: protected */
    public SearchSuggestionPresenter onCreatePresenter() {
        SearchSuggestionPresenter searchSuggestionPresenter = new SearchSuggestionPresenter();
        searchSuggestionPresenter.setSearchSugListener(this.f43755a);
        return searchSuggestionPresenter;
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSearchSuggestionView onCreateView() {
        return new SearchSuggestionView();
    }

    /* access modifiers changed from: protected */
    public Reducer<SearchSuggestionState> createReducer() {
        return new SearchSuggestionReducer();
    }

    /* access modifiers changed from: protected */
    public SearchSuggestionState initState() {
        return new SearchSuggestionState();
    }

    public void setSearchSuggestionLayoutVisibility(int i) {
        ((Contract.AbsSearchSuggestionView) getLogicView()).setSearchSuggestionLayoutVisibility(i);
    }
}
