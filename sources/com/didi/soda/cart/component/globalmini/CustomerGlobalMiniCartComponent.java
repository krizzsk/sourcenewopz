package com.didi.soda.cart.component.globalmini;

import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.cart.component.globalmini.Contract;
import com.didi.soda.customer.component.provider.ICartProvider;

public class CustomerGlobalMiniCartComponent extends MvpComponent<Contract.AbsGlobalMiniCartView, Contract.AbsGlobalMiniCartPresenter> implements ICartProvider {

    /* renamed from: a */
    private Contract.AbsGlobalMiniCartView f39971a;

    public CustomerGlobalMiniCartComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public boolean isCanShow() {
        Contract.AbsGlobalMiniCartView absGlobalMiniCartView = this.f39971a;
        if (absGlobalMiniCartView != null) {
            return absGlobalMiniCartView.isCanShow();
        }
        return false;
    }

    public void hideAll() {
        Contract.AbsGlobalMiniCartView absGlobalMiniCartView = this.f39971a;
        if (absGlobalMiniCartView != null) {
            absGlobalMiniCartView.hideAll();
        }
    }

    public void showAll() {
        Contract.AbsGlobalMiniCartView absGlobalMiniCartView = this.f39971a;
        if (absGlobalMiniCartView != null) {
            absGlobalMiniCartView.showAll();
        }
    }

    public void setOnClickCartListener(View.OnClickListener onClickListener) {
        Contract.AbsGlobalMiniCartView absGlobalMiniCartView = this.f39971a;
        if (absGlobalMiniCartView != null) {
            absGlobalMiniCartView.setOnClickCartListener(onClickListener);
        }
    }

    public void hide() {
        Contract.AbsGlobalMiniCartView absGlobalMiniCartView = this.f39971a;
        if (absGlobalMiniCartView != null) {
            absGlobalMiniCartView.hide();
        }
    }

    public void hideLoading() {
        Contract.AbsGlobalMiniCartView absGlobalMiniCartView = this.f39971a;
        if (absGlobalMiniCartView != null) {
            absGlobalMiniCartView.hideLoading();
        }
    }

    public void show() {
        Contract.AbsGlobalMiniCartView absGlobalMiniCartView = this.f39971a;
        if (absGlobalMiniCartView != null) {
            absGlobalMiniCartView.show();
        }
    }

    public void showLoading() {
        Contract.AbsGlobalMiniCartView absGlobalMiniCartView = this.f39971a;
        if (absGlobalMiniCartView != null) {
            absGlobalMiniCartView.showLoading();
        }
    }

    /* access modifiers changed from: protected */
    public Contract.AbsGlobalMiniCartPresenter onCreatePresenter() {
        return new CustomerGlobalMiniCartPresenter();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsGlobalMiniCartView onCreateView() {
        CustomerGlobalMiniCartView customerGlobalMiniCartView = new CustomerGlobalMiniCartView();
        this.f39971a = customerGlobalMiniCartView;
        return customerGlobalMiniCartView;
    }
}
