package com.didi.soda.manager.base;

import com.didi.soda.business.model.BusinessActionParam;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;

public interface ICustomerBusinessManager extends ICustomerManager {
    boolean checkBusinessStatusNormal(int i);

    boolean checkBusinessStatusNormal(BusinessState businessState);

    boolean checkBusinessStatusNormal(BusinessInfoEntity businessInfoEntity);

    int getBusinessDistance();

    void refreshBusinessPage(BusinessActionParam businessActionParam);
}
