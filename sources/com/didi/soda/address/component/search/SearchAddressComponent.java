package com.didi.soda.address.component.search;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class SearchAddressComponent extends MvpComponent<SearchAddressView, SearchAddressPresenter> {

    /* renamed from: a */
    SearchAddressView f38679a;

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
        if (this.f38679a == null) {
            this.f38679a = new SearchAddressView();
        }
        return this.f38679a;
    }

    /* access modifiers changed from: protected */
    public SearchAddressPresenter onCreatePresenter() {
        return new SearchAddressPresenter();
    }
}
