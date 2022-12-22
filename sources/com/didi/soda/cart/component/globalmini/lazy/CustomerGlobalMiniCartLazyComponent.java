package com.didi.soda.cart.component.globalmini.lazy;

import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.cart.component.globalmini.lazy.Contract;
import com.didi.soda.customer.base.lazycomponent.LazyComponent;
import com.didi.soda.customer.component.provider.ICartProvider;

public class CustomerGlobalMiniCartLazyComponent extends LazyComponent<Contract.AbsGlobalMiniCartView, Contract.AbsGlobalMiniCartPresenter> implements ICartProvider {

    /* renamed from: b */
    private Contract.AbsGlobalMiniCartView f39983b;

    public CustomerGlobalMiniCartLazyComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public boolean isCanShow() {
        if (this.f39983b == null) {
            return false;
        }
        load();
        return this.f39983b.isCanShow();
    }

    public void hideAll() {
        if (this.f39983b != null) {
            load();
            this.f39983b.hideAll();
        }
    }

    public void showAll() {
        if (this.f39983b != null) {
            load();
            this.f39983b.showAll();
        }
    }

    public void setOnClickCartListener(View.OnClickListener onClickListener) {
        if (this.f39983b != null) {
            load();
            this.f39983b.setOnClickCartListener(onClickListener);
        }
    }

    public void hide() {
        if (this.f39983b != null) {
            load();
            this.f39983b.hide();
        }
    }

    public void hideLoading() {
        if (this.f39983b != null) {
            load();
            this.f39983b.hideLoading();
        }
    }

    public void show() {
        if (this.f39983b != null) {
            load();
            this.f39983b.show();
        }
    }

    public void showLoading() {
        if (this.f39983b != null) {
            load();
            this.f39983b.showLoading();
        }
    }

    /* access modifiers changed from: protected */
    public Contract.AbsGlobalMiniCartPresenter onCreatePresenter() {
        return new CustomerGlobalMiniCartLazyPresenter();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsGlobalMiniCartView onCreateView() {
        CustomerGlobalMiniCartLazyView customerGlobalMiniCartLazyView = new CustomerGlobalMiniCartLazyView();
        this.f39983b = customerGlobalMiniCartLazyView;
        return customerGlobalMiniCartLazyView;
    }
}
