package com.didi.entrega.address.list.component.feed.core;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class AddressFeedMessageView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AddressFeedMessageView f19434a;

    public AddressFeedMessageView_ViewBinding(AddressFeedMessageView addressFeedMessageView, View view) {
        this.f19434a = addressFeedMessageView;
        addressFeedMessageView.mRecommendAddressRv = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.soda_srv_recommend_address, "field 'mRecommendAddressRv'", NovaRecyclerView.class);
        addressFeedMessageView.mLoadingView = (LottieLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_custom_address_loading_up, "field 'mLoadingView'", LottieLoadingView.class);
        addressFeedMessageView.mEmptyResultView = Utils.findRequiredView(view, R.id.customer_cl_address_no_nearby_result, "field 'mEmptyResultView'");
    }

    public void unbind() {
        AddressFeedMessageView addressFeedMessageView = this.f19434a;
        if (addressFeedMessageView != null) {
            this.f19434a = null;
            addressFeedMessageView.mRecommendAddressRv = null;
            addressFeedMessageView.mLoadingView = null;
            addressFeedMessageView.mEmptyResultView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
