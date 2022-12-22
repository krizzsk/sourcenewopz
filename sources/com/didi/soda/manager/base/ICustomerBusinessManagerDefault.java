package com.didi.soda.manager.base;

import com.didi.soda.business.model.BusinessActionParam;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;

public class ICustomerBusinessManagerDefault implements ICustomerBusinessManager {
    public boolean checkBusinessStatusNormal(int i) {
        return false;
    }

    public boolean checkBusinessStatusNormal(BusinessState businessState) {
        return false;
    }

    public boolean checkBusinessStatusNormal(BusinessInfoEntity businessInfoEntity) {
        return false;
    }

    public int getBusinessDistance() {
        return 0;
    }

    public String getManagerName() {
        return null;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void refreshBusinessPage(BusinessActionParam businessActionParam) {
    }
}
