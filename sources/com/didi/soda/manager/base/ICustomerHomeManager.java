package com.didi.soda.manager.base;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.repo.CustomerResource;

public interface ICustomerHomeManager extends ICustomerManager {
    void activityInvalidedRefreshHome();

    void locateThenRefreshHome(int i);

    void refreshHomeByAddress(AddressEntity addressEntity, int i);

    void refreshHomeByCityInfo(double d, double d2, String str);

    void refreshTab();

    void subscribeHomeData(ScopeContext scopeContext, Action1<CustomerResource<HomeEntity>> action1);

    void subscribeHomeRefreshMessage(ScopeContext scopeContext, Action<Integer> action);
}
