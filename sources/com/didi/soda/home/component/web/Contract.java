package com.didi.soda.home.component.web;

import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;

public interface Contract {

    public static abstract class AbsRecPresenter extends ICustomerPresenter<AbsWebRecView> {
    }

    public static abstract class AbsWebRecView extends ICustomerView<AbsRecPresenter> {
        public abstract void loadUrl(String str);

        public abstract void setPaddingBottom(int i);

        public abstract void setWebVisible(boolean z);
    }
}
