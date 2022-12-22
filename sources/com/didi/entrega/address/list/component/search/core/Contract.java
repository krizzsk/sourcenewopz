package com.didi.entrega.address.list.component.search.core;

import com.didi.entrega.address.list.component.search.SearchAddressComponent;
import com.didi.entrega.address.list.component.search.model.AddressSearchRvModel;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerView;

interface Contract {

    public static abstract class AbsSearchAddressPresenter extends CustomerRecyclerPresenter<AbsSearchAddressView> {
        /* access modifiers changed from: package-private */
        public abstract void onAddressSelected(AddressSearchRvModel addressSearchRvModel);

        /* access modifiers changed from: package-private */
        public abstract void onRetryAction();

        /* access modifiers changed from: package-private */
        public abstract void onSearchTextChange(String str);
    }

    public static abstract class AbsSearchAddressView extends CustomerRecyclerView<AbsSearchAddressPresenter> {
        /* access modifiers changed from: package-private */
        public abstract void hideCheckLoading();

        /* access modifiers changed from: package-private */
        public abstract void hideLoadError();

        /* access modifiers changed from: package-private */
        public abstract void searchEmptyText();

        /* access modifiers changed from: package-private */
        public abstract void showCheckLoading();

        /* access modifiers changed from: package-private */
        public abstract void showLoadError(String str);

        /* access modifiers changed from: package-private */
        public abstract void showLoadNoResult();

        /* access modifiers changed from: package-private */
        public abstract void showLoadSuccess();

        /* access modifiers changed from: package-private */
        public abstract void showOrHideContent(boolean z, SearchAddressComponent.OnSearchAnimationListener onSearchAnimationListener);

        /* access modifiers changed from: package-private */
        public abstract void showOrHideLoading(boolean z);

        /* access modifiers changed from: package-private */
        public abstract void showOrHideSearchLoading(boolean z);
    }
}
