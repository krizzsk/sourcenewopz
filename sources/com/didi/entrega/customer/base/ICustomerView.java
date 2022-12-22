package com.didi.entrega.customer.base;

import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.entrega.customer.base.ICustomerPresenter;

public abstract class ICustomerView<P extends ICustomerPresenter> extends IView<P> {
    /* access modifiers changed from: protected */
    public void onCreate() {
        ButterKnife.bind((Object) this, getView());
        super.onCreate();
    }
}
