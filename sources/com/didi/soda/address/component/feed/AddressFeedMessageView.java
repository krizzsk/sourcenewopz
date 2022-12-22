package com.didi.soda.address.component.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.soda.address.component.feed.Contract;
import com.didi.soda.address.component.feed.binder.DeliveryAddressBinder;
import com.didi.soda.address.component.feed.binder.DeliveryAddressItemDecorator;
import com.didi.soda.address.component.feed.binder.DeliveryAddressRvModel;
import com.didi.soda.address.component.feed.view.AddressRecyclerView;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalViewBinder;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

class AddressFeedMessageView extends Contract.AbsAddressFeedMessageView {
    @BindView(18614)
    ViewGroup mAddressLoginView;
    @BindView(17918)
    LottieLoadingView mLoadingView;
    @BindView(23144)
    AddressRecyclerView mRecommendAddressRv;

    AddressFeedMessageView() {
    }

    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mRecommendAddressRv;
    }

    public void initItemBinders() {
        registerBinder(new TopGunAbnormalViewBinder());
        registerBinder(new DeliveryAddressBinder(DeliveryAddressItemDecorator.newInstance()) {
            public void onAddressClick(AddressEntity addressEntity, int i, int i2) {
                ((Contract.AbsAddressFeedMessagePresenter) AddressFeedMessageView.this.getPresenter()).onAddressClick(addressEntity, i, i2);
            }

            public void onAddressDeleteClick(DeliveryAddressRvModel deliveryAddressRvModel, int i) {
                ((Contract.AbsAddressFeedMessagePresenter) AddressFeedMessageView.this.getPresenter()).onAddressDeleteClick(deliveryAddressRvModel, i);
            }

            public void onAddressEditClick(DeliveryAddressRvModel deliveryAddressRvModel, int i) {
                ((Contract.AbsAddressFeedMessagePresenter) AddressFeedMessageView.this.getPresenter()).onAddressEditClick(deliveryAddressRvModel, i);
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
        m27365a();
    }

    public void onResume() {
        super.onResume();
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        this.mRecommendAddressRv.setItemDecorationEnable(true);
        this.mRecommendAddressRv.setItemTouchControlEnable(true);
        this.mRecommendAddressRv.setOneOpenToggle(true);
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

    public void showOrHideLoginView() {
        this.mAddressLoginView.setVisibility(LoginUtil.isLogin() ? 8 : 0);
    }

    public void showAddressUnableDeleteDialog() {
        DialogUtil.showAddressUnDeletableDialog(getScopeContext().getNavigator());
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.component_search_recommend_address, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* renamed from: a */
    private void m27365a() {
        this.mAddressLoginView.findViewById(R.id.tv_footer_sign_in).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddressFeedMessageView.this.m27366a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27366a(View view) {
        ((Contract.AbsAddressFeedMessagePresenter) getPresenter()).goLogin();
    }
}
