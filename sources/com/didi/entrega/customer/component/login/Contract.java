package com.didi.entrega.customer.component.login;

import com.didi.entrega.customer.base.ICustomerPresenter;
import com.didi.entrega.customer.base.ICustomerView;

interface Contract {

    public static abstract class AbsLoginLogicPresenter extends ICustomerPresenter<AbsLoginLogicView> {
    }

    public static abstract class AbsLoginLogicView extends ICustomerView<AbsLoginLogicPresenter> {
    }
}
