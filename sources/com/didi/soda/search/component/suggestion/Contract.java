package com.didi.soda.search.component.suggestion;

import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import com.didi.soda.customer.base.rxdux.RxduxPresenter;

interface Contract {

    public static abstract class AbsSearchSuggestionView extends CustomerRecyclerView<AbsSearchSuggestionPresenter> {
        /* access modifiers changed from: package-private */
        public abstract void setSearchSuggestionLayoutVisibility(int i);
    }

    public static abstract class AbsSearchSuggestionPresenter extends RxduxPresenter<SearchSuggestionState, AbsSearchSuggestionView> {
        SearchSugListener searchSugListener;

        /* access modifiers changed from: package-private */
        public abstract IBlockScope getScope();

        /* access modifiers changed from: package-private */
        public abstract void onRetryClick();

        public void setSearchSugListener(SearchSugListener searchSugListener2) {
            this.searchSugListener = searchSugListener2;
        }
    }
}
