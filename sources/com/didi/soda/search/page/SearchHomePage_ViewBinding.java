package com.didi.soda.search.page;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class SearchHomePage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SearchHomePage f43782a;

    public SearchHomePage_ViewBinding(SearchHomePage searchHomePage, View view) {
        this.f43782a = searchHomePage;
        searchHomePage.mSearchHeaderContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_search_header_container, "field 'mSearchHeaderContainer'", FrameLayout.class);
        searchHomePage.mSearchPanelContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_entrance_panel_container, "field 'mSearchPanelContainer'", FrameLayout.class);
        searchHomePage.mSearchResultContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_search_result_container, "field 'mSearchResultContainer'", FrameLayout.class);
        searchHomePage.mSearchSuggestionContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_search_suggestion_container, "field 'mSearchSuggestionContainer'", FrameLayout.class);
    }

    public void unbind() {
        SearchHomePage searchHomePage = this.f43782a;
        if (searchHomePage != null) {
            this.f43782a = null;
            searchHomePage.mSearchHeaderContainer = null;
            searchHomePage.mSearchPanelContainer = null;
            searchHomePage.mSearchResultContainer = null;
            searchHomePage.mSearchSuggestionContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
