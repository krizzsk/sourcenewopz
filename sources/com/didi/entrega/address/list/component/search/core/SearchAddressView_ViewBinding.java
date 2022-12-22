package com.didi.entrega.address.list.component.search.core;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.entrega.address.list.component.search.widget.AddressSearchView;
import com.didi.entrega.customer.widget.abnormal.AbnormalView;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.didi.entrega.customer.widget.loading.SodaLoadingView;
import com.taxis99.R;

public class SearchAddressView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SearchAddressView f19454a;

    public SearchAddressView_ViewBinding(SearchAddressView searchAddressView, View view) {
        this.f19454a = searchAddressView;
        searchAddressView.mSearchAddressRv = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.srv_search_address, "field 'mSearchAddressRv'", NovaRecyclerView.class);
        searchAddressView.mAddressAbnormalView = (AbnormalView) Utils.findRequiredViewAsType(view, R.id.layout_search_abnormal, "field 'mAddressAbnormalView'", AbnormalView.class);
        searchAddressView.mSearchEntrace = (AddressSearchView) Utils.findRequiredViewAsType(view, R.id.customer_custom_search_entrace, "field 'mSearchEntrace'", AddressSearchView.class);
        searchAddressView.mAddressContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_search_address_container, "field 'mAddressContainer'", RelativeLayout.class);
        searchAddressView.mNoResultLayout = Utils.findRequiredView(view, R.id.customer_cl_address_no_result, "field 'mNoResultLayout'");
        searchAddressView.mNoResultTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_address_empty_title, "field 'mNoResultTitle'", TextView.class);
        searchAddressView.mNoResultDes = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_address_empty_des, "field 'mNoResultDes'", TextView.class);
        searchAddressView.mLine = Utils.findRequiredView(view, R.id.customer_v_address_search_line, "field 'mLine'");
        searchAddressView.mLoadingView = (SodaLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_search_loading, "field 'mLoadingView'", SodaLoadingView.class);
        searchAddressView.mCheckLoadingView = (LottieLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_custom_address_loading_up, "field 'mCheckLoadingView'", LottieLoadingView.class);
    }

    public void unbind() {
        SearchAddressView searchAddressView = this.f19454a;
        if (searchAddressView != null) {
            this.f19454a = null;
            searchAddressView.mSearchAddressRv = null;
            searchAddressView.mAddressAbnormalView = null;
            searchAddressView.mSearchEntrace = null;
            searchAddressView.mAddressContainer = null;
            searchAddressView.mNoResultLayout = null;
            searchAddressView.mNoResultTitle = null;
            searchAddressView.mNoResultDes = null;
            searchAddressView.mLine = null;
            searchAddressView.mLoadingView = null;
            searchAddressView.mCheckLoadingView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
