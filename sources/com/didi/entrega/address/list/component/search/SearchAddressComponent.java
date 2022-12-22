package com.didi.entrega.address.list.component.search;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.entrega.address.list.component.search.core.SearchAddressPresenter;
import com.didi.entrega.address.list.component.search.core.SearchAddressView;

public class SearchAddressComponent extends MvpComponent<SearchAddressView, SearchAddressPresenter> {

    /* renamed from: a */
    SearchAddressView f19438a;

    public interface OnSearchAnimationListener {
        void onAnimationCompleted();
    }

    public SearchAddressComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void showOrHide(boolean z, OnSearchAnimationListener onSearchAnimationListener) {
        if (getPresenter() != null) {
            ((SearchAddressPresenter) getPresenter()).showOrHide(z, onSearchAnimationListener);
        }
    }

    /* access modifiers changed from: protected */
    public SearchAddressView onCreateView() {
        if (this.f19438a == null) {
            this.f19438a = new SearchAddressView();
        }
        return this.f19438a;
    }

    /* access modifiers changed from: protected */
    public SearchAddressPresenter onCreatePresenter() {
        return new SearchAddressPresenter();
    }

    public void setSearchTextHint(String str) {
        this.f19438a.setSearchTextHint(str);
    }
}
