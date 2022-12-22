package com.didi.soda.customer.component.login;

import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;

interface Contract {

    public static abstract class AbsLoginLogicPresenter extends ICustomerPresenter<AbsLoginLogicView> {
    }

    public static abstract class AbsLoginLogicView extends ICustomerView<AbsLoginLogicPresenter> {
    }
}
