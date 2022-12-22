package com.didi.soda.address.component.search;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.address.AddressSearchView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.loading.SodaLoadingView;
import com.taxis99.R;

public class SearchAddressView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SearchAddressView f38694a;

    public SearchAddressView_ViewBinding(SearchAddressView searchAddressView, View view) {
        this.f38694a = searchAddressView;
        searchAddressView.mSearchAddressRv = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.srv_search_address, "field 'mSearchAddressRv'", NovaRecyclerView.class);
        searchAddressView.mAddressAbnormalView = (TopGunAbnormalView) Utils.findRequiredViewAsType(view, R.id.layout_search_abnormal, "field 'mAddressAbnormalView'", TopGunAbnormalView.class);
        searchAddressView.mSearchEntrace = (AddressSearchView) Utils.findRequiredViewAsType(view, R.id.customer_custom_search_entrace, "field 'mSearchEntrace'", AddressSearchView.class);
        searchAddressView.mAddressContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_search_address_container, "field 'mAddressContainer'", RelativeLayout.class);
        searchAddressView.mNoticeLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.customer_rl_address_notice_view, "field 'mNoticeLayout'", LinearLayout.class);
        searchAddressView.mNoResultLayout = Utils.findRequiredView(view, R.id.customer_cl_address_no_result, "field 'mNoResultLayout'");
        searchAddressView.mNoResultTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_address_empty_title, "field 'mNoResultTitle'", TextView.class);
        searchAddressView.mNoResultDes = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_address_empty_des, "field 'mNoResultDes'", TextView.class);
        searchAddressView.mLine = Utils.findRequiredView(view, R.id.customer_v_address_search_line, "field 'mLine'");
        searchAddressView.mLoadingView = (SodaLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_search_loading, "field 'mLoadingView'", SodaLoadingView.class);
    }

    public void unbind() {
        SearchAddressView searchAddressView = this.f38694a;
        if (searchAddressView != null) {
            this.f38694a = null;
            searchAddressView.mSearchAddressRv = null;
            searchAddressView.mAddressAbnormalView = null;
            searchAddressView.mSearchEntrace = null;
            searchAddressView.mAddressContainer = null;
            searchAddressView.mNoticeLayout = null;
            searchAddressView.mNoResultLayout = null;
            searchAddressView.mNoResultTitle = null;
            searchAddressView.mNoResultDes = null;
            searchAddressView.mLine = null;
            searchAddressView.mLoadingView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
