package com.didi.soda.search.component.suggestion;

import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.taxis99.R;

public class SearchSuggestionView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SearchSuggestionView f43764a;

    public SearchSuggestionView_ViewBinding(SearchSuggestionView searchSuggestionView, View view) {
        this.f43764a = searchSuggestionView;
        searchSuggestionView.mList = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_custom_search_suggestion, "field 'mList'", NovaRecyclerView.class);
        searchSuggestionView.mRoot = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.customer_search_suggestion_layout, "field 'mRoot'", ViewGroup.class);
    }

    public void unbind() {
        SearchSuggestionView searchSuggestionView = this.f43764a;
        if (searchSuggestionView != null) {
            this.f43764a = null;
            searchSuggestionView.mList = null;
            searchSuggestionView.mRoot = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
