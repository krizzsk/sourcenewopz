package com.didi.soda.order.component.debtpay;

import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;

public interface Contract {

    public static abstract class AbsDebtOrderPayPresenter extends ICustomerPresenter<AbsDebtOrderPayView> {
        public abstract void closePage();

        public abstract void pay();

        public abstract void selectPayMethod();
    }

    public static abstract class AbsDebtOrderPayView extends ICustomerView<AbsDebtOrderPayPresenter> {
        public abstract void setLoading(boolean z);

        public abstract void setPayInfo(String str, String str2, PayChannelEntity payChannelEntity);
    }
}
