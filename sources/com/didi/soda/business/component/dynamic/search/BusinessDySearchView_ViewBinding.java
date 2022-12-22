package com.didi.soda.business.component.dynamic.search;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.business.component.dynamic.search.helper.MenuSearchDyView;
import com.didi.soda.customer.widget.loading.SodaLoadingView;
import com.didi.soda.home.shimmer.ShimmerRecyclerView;
import com.taxis99.R;

public class BusinessDySearchView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessDySearchView f39525a;

    public BusinessDySearchView_ViewBinding(BusinessDySearchView businessDySearchView, View view) {
        this.f39525a = businessDySearchView;
        businessDySearchView.mBackView = Utils.findRequiredView(view, R.id.customer_iv_page_back, "field 'mBackView'");
        businessDySearchView.mSearchView = (MenuSearchDyView) Utils.findRequiredViewAsType(view, R.id.customer_menu_search_view, "field 'mSearchView'", MenuSearchDyView.class);
        businessDySearchView.mSearchResultRv = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_menu_search_result, "field 'mSearchResultRv'", NovaRecyclerView.class);
        businessDySearchView.mShadowView = Utils.findRequiredView(view, R.id.customer_home_filter_shadow, "field 'mShadowView'");
        businessDySearchView.mLoadingView = (SodaLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_search_loading, "field 'mLoadingView'", SodaLoadingView.class);
        businessDySearchView.mShimmerView = (ShimmerRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_custom_shimmer, "field 'mShimmerView'", ShimmerRecyclerView.class);
        businessDySearchView.search_root = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.search_root, "field 'search_root'", ConstraintLayout.class);
    }

    public void unbind() {
        BusinessDySearchView businessDySearchView = this.f39525a;
        if (businessDySearchView != null) {
            this.f39525a = null;
            businessDySearchView.mBackView = null;
            businessDySearchView.mSearchView = null;
            businessDySearchView.mSearchResultRv = null;
            businessDySearchView.mShadowView = null;
            businessDySearchView.mLoadingView = null;
            businessDySearchView.mShimmerView = null;
            businessDySearchView.search_root = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
