package com.didi.soda.search.component.header;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class SearchHeaderView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SearchHeaderView f43697a;

    public SearchHeaderView_ViewBinding(SearchHeaderView searchHeaderView, View view) {
        this.f43697a = searchHeaderView;
        searchHeaderView.mSearchEt = (SearchView) Utils.findRequiredViewAsType(view, R.id.customer_et_search, "field 'mSearchEt'", SearchView.class);
        searchHeaderView.mBackIv = Utils.findRequiredView(view, R.id.customer_iv_search_home_back, "field 'mBackIv'");
        searchHeaderView.mPlaceHolder = Utils.findRequiredView(view, R.id.customer_view_placeholder, "field 'mPlaceHolder'");
    }

    public void unbind() {
        SearchHeaderView searchHeaderView = this.f43697a;
        if (searchHeaderView != null) {
            this.f43697a = null;
            searchHeaderView.mSearchEt = null;
            searchHeaderView.mBackIv = null;
            searchHeaderView.mPlaceHolder = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
