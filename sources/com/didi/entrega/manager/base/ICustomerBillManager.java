package com.didi.entrega.manager.base;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;

@Deprecated
public interface ICustomerBillManager extends ICustomerManager {
    void dispatchChange(IEntity iEntity);
}
