package com.didi.soda.address.component.feed;

import com.didi.soda.address.component.feed.listener.OnAddressClickListener;
import com.didi.soda.address.component.feed.listener.OnAddressHandleListener;
import com.didi.soda.address.component.feed.listener.OnAddressLocationListener;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;

interface Contract {

    public static abstract class AbsAddressFeedMessagePresenter extends CustomerRecyclerPresenter<AbsAddressFeedMessageView> implements OnAddressClickListener, OnAddressHandleListener, OnAddressLocationListener {
        /* access modifiers changed from: package-private */
        public abstract void getAddressAllList();

        /* access modifiers changed from: package-private */
        public abstract void goLogin();
    }

    public static abstract class AbsAddressFeedMessageView extends CustomerRecyclerView<AbsAddressFeedMessagePresenter> {
        /* access modifiers changed from: package-private */
        public abstract void hideLoading();

        /* access modifiers changed from: package-private */
        public abstract void showAddressUnableDeleteDialog();

        /* access modifiers changed from: package-private */
        public abstract void showLoading();

        /* access modifiers changed from: package-private */
        public abstract void showOrHideLoginView();
    }
}
