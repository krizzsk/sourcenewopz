package com.didi.soda.address.component.feed;

import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.soda.address.component.feed.view.AddressRecyclerView;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class AddressFeedMessageView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AddressFeedMessageView f38657a;

    public AddressFeedMessageView_ViewBinding(AddressFeedMessageView addressFeedMessageView, View view) {
        this.f38657a = addressFeedMessageView;
        addressFeedMessageView.mRecommendAddressRv = (AddressRecyclerView) Utils.findRequiredViewAsType(view, R.id.soda_srv_recommend_address, "field 'mRecommendAddressRv'", AddressRecyclerView.class);
        addressFeedMessageView.mAddressLoginView = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.customer_recommend_address_login, "field 'mAddressLoginView'", ViewGroup.class);
        addressFeedMessageView.mLoadingView = (LottieLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_custom_address_loading_up, "field 'mLoadingView'", LottieLoadingView.class);
    }

    public void unbind() {
        AddressFeedMessageView addressFeedMessageView = this.f38657a;
        if (addressFeedMessageView != null) {
            this.f38657a = null;
            addressFeedMessageView.mRecommendAddressRv = null;
            addressFeedMessageView.mAddressLoginView = null;
            addressFeedMessageView.mLoadingView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
