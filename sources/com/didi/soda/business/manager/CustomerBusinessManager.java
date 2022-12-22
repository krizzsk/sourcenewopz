package com.didi.soda.business.manager;

import com.didi.soda.business.model.BusinessActionParam;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.manager.base.ICustomerBusinessManager;

public class CustomerBusinessManager implements ICustomerBusinessManager {

    /* renamed from: a */
    private static final String f39713a = "BusinessManager";

    public String getManagerName() {
        return f39713a;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public boolean checkBusinessStatusNormal(BusinessInfoEntity businessInfoEntity) {
        return BusinessDataHelper.checkBusinessStatusNormal(businessInfoEntity);
    }

    public boolean checkBusinessStatusNormal(BusinessState businessState) {
        return BusinessDataHelper.checkBusinessStatusNormal(businessState.shopStatus);
    }

    public boolean checkBusinessStatusNormal(int i) {
        return BusinessDataHelper.checkBusinessStatusNormal(i);
    }

    public void refreshBusinessPage(BusinessActionParam businessActionParam) {
        ((BusinessActionRepo) RepoFactory.getRepo(BusinessActionRepo.class)).setValue(businessActionParam);
    }

    public int getBusinessDistance() {
        try {
            return ((BusinessEntity) ((CustomerResource) ((BusinessRepo) SingletonFactory.get(BusinessRepo.class)).getValue()).data).shopInfo.distance;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
