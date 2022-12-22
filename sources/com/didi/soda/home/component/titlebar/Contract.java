package com.didi.soda.home.component.titlebar;

import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;

interface Contract {

    public static abstract class AbsTitleBarPresenter extends ICustomerPresenter<AbsTitleBarView> {
        public abstract void onAddressClick();

        public abstract void onAvatarClick();
    }

    public static abstract class AbsTitleBarView extends ICustomerView<AbsTitleBarPresenter> {
        public abstract void updateAddress(String str);
    }
}
