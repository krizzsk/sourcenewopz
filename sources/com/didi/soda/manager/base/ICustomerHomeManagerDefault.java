package com.didi.soda.manager.base;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.repo.CustomerResource;

public class ICustomerHomeManagerDefault implements ICustomerHomeManager {
    public void activityInvalidedRefreshHome() {
    }

    public String getManagerName() {
        return null;
    }

    public void locateThenRefreshHome(int i) {
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void refreshHomeByAddress(AddressEntity addressEntity, int i) {
    }

    public void refreshHomeByCityInfo(double d, double d2, String str) {
    }

    public void refreshTab() {
    }

    public void subscribeHomeData(ScopeContext scopeContext, Action1<CustomerResource<HomeEntity>> action1) {
    }

    public void subscribeHomeRefreshMessage(ScopeContext scopeContext, Action<Integer> action) {
    }
}
