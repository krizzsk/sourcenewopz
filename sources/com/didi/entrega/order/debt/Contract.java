package com.didi.entrega.order.debt;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;

public interface Contract {

    public static abstract class AbsDebtOrderPayPresenter extends IPresenter<AbsDebtOrderPayView> {
        public abstract void closePage();

        public abstract void pay();

        public abstract void selectPayMethod();
    }

    public static abstract class AbsDebtOrderPayView extends IView<AbsDebtOrderPayPresenter> {
        public abstract void setLoading(boolean z);

        public abstract void setPayInfo(String str, String str2, PayChannel payChannel);
    }
}
