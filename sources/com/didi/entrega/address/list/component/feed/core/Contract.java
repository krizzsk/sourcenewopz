package com.didi.entrega.address.list.component.feed.core;

import com.didi.entrega.address.list.component.feed.listener.OnAddressClickListener;
import com.didi.entrega.address.list.component.feed.listener.OnAddressDeleteClickListener;
import com.didi.entrega.address.list.component.feed.listener.OnAddressLocationListener;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerView;

interface Contract {

    public static abstract class AbsAddressFeedMessagePresenter extends CustomerRecyclerPresenter<AbsAddressFeedMessageView> implements OnAddressClickListener, OnAddressDeleteClickListener, OnAddressLocationListener {
        /* access modifiers changed from: package-private */
        public abstract void getAddressAllList();
    }

    public static abstract class AbsAddressFeedMessageView extends CustomerRecyclerView<AbsAddressFeedMessagePresenter> {
        /* access modifiers changed from: package-private */
        public abstract void hideLoading();

        /* access modifiers changed from: package-private */
        public abstract void showEmptyNearbyResult();

        /* access modifiers changed from: package-private */
        public abstract void showLoadSuccess();

        /* access modifiers changed from: package-private */
        public abstract void showLoading();
    }
}
