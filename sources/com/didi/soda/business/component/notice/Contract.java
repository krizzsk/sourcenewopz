package com.didi.soda.business.component.notice;

import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;

public interface Contract {

    public static abstract class IDynamicNoticePresenter extends ICustomerPresenter<IDynamicNoticeView> {
    }

    public static abstract class IDynamicNoticeView extends ICustomerView<IDynamicNoticePresenter> {
        public abstract void updateView(String str);
    }
}
