package com.didi.entrega.manager.base;

import android.app.Activity;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.rpc.entity.IEntity;

public interface ICustomerPayManager extends ICustomerManager {

    public interface BillPayCallback extends IEntity {
        void quitBill(int i);

        void recoverBill(String str, boolean z);

        void refreshBill();

        void updateBusinessAndCart();
    }

    public interface CartPayButtonCallback extends IEntity {
        void fail(String str);

        void hideLoading();

        boolean isLoading();

        void loading();

        void success(String str);
    }

    public interface PayCallback extends IEntity {
        void onThirdPayStart(int i);

        void payFail(int i, String str);

        void paySucceed();
    }

    public static class PayParamEntity implements IEntity {
        public String orderId;
        public String token;
        public String transId;
    }

    void getPayStatus(Activity activity, ScopeContext scopeContext, PayParamEntity payParamEntity, PayCallback payCallback);

    void pay(ScopeContext scopeContext, Activity activity, PayParamEntity payParamEntity, PayCallback payCallback);
}
