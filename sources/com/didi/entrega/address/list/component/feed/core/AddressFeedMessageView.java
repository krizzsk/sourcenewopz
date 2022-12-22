package com.didi.entrega.address.list.component.feed.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.entrega.address.list.component.feed.binder.DeliveryAddressBinder;
import com.didi.entrega.address.list.component.feed.binder.DeliveryAddressItemDecorator;
import com.didi.entrega.address.list.component.feed.binder.DeliveryAddressSplitDecoratorBinder;
import com.didi.entrega.address.list.component.feed.binder.DeliveryAddressTitleBinder;
import com.didi.entrega.address.list.component.feed.core.Contract;
import com.didi.entrega.address.list.component.feed.model.DeliveryAddressRvModel;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewBinder;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class AddressFeedMessageView extends Contract.AbsAddressFeedMessageView {
    @BindView(16279)
    View mEmptyResultView;
    @BindView(16288)
    LottieLoadingView mLoadingView;
    @BindView(20357)
    NovaRecyclerView mRecommendAddressRv;

    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mRecommendAddressRv;
    }

    public void initItemBinders() {
        registerBinder(new AbnormalViewBinder());
        registerBinder(new DeliveryAddressTitleBinder());
        registerBinder(new DeliveryAddressSplitDecoratorBinder());
        registerBinder(new DeliveryAddressBinder(DeliveryAddressItemDecorator.newInstance()) {
            public void onAddressDeleteClick(DeliveryAddressRvModel deliveryAddressRvModel) {
                ((Contract.AbsAddressFeedMessagePresenter) AddressFeedMessageView.this.getPresenter()).onAddressDeleteClick(deliveryAddressRvModel);
            }

            public void onAddressClick(DeliveryAddressRvModel deliveryAddressRvModel) {
                ((Contract.AbsAddressFeedMessagePresenter) AddressFeedMessageView.this.getPresenter()).onAddressClick(deliveryAddressRvModel);
            }

            public void onOpenLocationPermission() {
                ((Contract.AbsAddressFeedMessagePresenter) AddressFeedMessageView.this.getPresenter()).onOpenLocationPermission();
            }

            public void onOpenLocation() {
                ((Contract.AbsAddressFeedMessagePresenter) AddressFeedMessageView.this.getPresenter()).onOpenLocation();
            }

            public void onRetryLocation() {
                ((Contract.AbsAddressFeedMessagePresenter) AddressFeedMessageView.this.getPresenter()).onRetryLocation();
            }
        });
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onResume() {
        super.onResume();
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        this.mRecommendAddressRv.setItemDecorationEnable(true);
    }

    public void showLoading() {
        this.mLoadingView.setVisibility(0);
        if (!this.mLoadingView.isAnimating()) {
            this.mLoadingView.start();
        }
    }

    public void hideLoading() {
        this.mLoadingView.setVisibility(8);
        if (this.mLoadingView.isAnimating()) {
            this.mLoadingView.stop();
        }
    }

    /* access modifiers changed from: package-private */
    public void showEmptyNearbyResult() {
        this.mEmptyResultView.setVisibility(0);
        this.mRecommendAddressRv.setVisibility(8);
    }

    public void showLoadSuccess() {
        this.mEmptyResultView.setVisibility(8);
        this.mRecommendAddressRv.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.entrega_component_search_recommend_address, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }
}
