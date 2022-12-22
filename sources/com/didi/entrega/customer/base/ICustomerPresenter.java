package com.didi.entrega.customer.base;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.entrega.customer.base.ICustomerView;

public abstract class ICustomerPresenter<V extends ICustomerView> extends IPresenter<V> {
}
