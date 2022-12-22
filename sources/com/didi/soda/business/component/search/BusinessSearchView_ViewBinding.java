package com.didi.soda.business.component.search;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.business.component.search.helper.MenuSearchView;
import com.didi.soda.customer.widget.loading.SodaLoadingView;
import com.didi.soda.customer.widget.titlebar.TitleBarView;
import com.didi.soda.home.shimmer.ShimmerRecyclerView;
import com.taxis99.R;

public class BusinessSearchView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessSearchView f39660a;

    public BusinessSearchView_ViewBinding(BusinessSearchView businessSearchView, View view) {
        this.f39660a = businessSearchView;
        businessSearchView.mTitleBarView = (TitleBarView) Utils.findRequiredViewAsType(view, R.id.customer_menu_search_title_view, "field 'mTitleBarView'", TitleBarView.class);
        businessSearchView.mSearchView = (MenuSearchView) Utils.findRequiredViewAsType(view, R.id.customer_menu_search_view, "field 'mSearchView'", MenuSearchView.class);
        businessSearchView.mSearchResultRv = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_menu_search_result, "field 'mSearchResultRv'", NovaRecyclerView.class);
        businessSearchView.mShadowView = Utils.findRequiredView(view, R.id.customer_home_filter_shadow, "field 'mShadowView'");
        businessSearchView.mLoadingView = (SodaLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_search_loading, "field 'mLoadingView'", SodaLoadingView.class);
        businessSearchView.mShimmerView = (ShimmerRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_custom_shimmer, "field 'mShimmerView'", ShimmerRecyclerView.class);
    }

    public void unbind() {
        BusinessSearchView businessSearchView = this.f39660a;
        if (businessSearchView != null) {
            this.f39660a = null;
            businessSearchView.mTitleBarView = null;
            businessSearchView.mSearchView = null;
            businessSearchView.mSearchResultRv = null;
            businessSearchView.mShadowView = null;
            businessSearchView.mLoadingView = null;
            businessSearchView.mShimmerView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
