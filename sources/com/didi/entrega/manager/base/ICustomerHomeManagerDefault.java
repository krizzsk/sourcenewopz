package com.didi.entrega.manager.base;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.home.component.feed.entity.HomeFeedEntity;

public class ICustomerHomeManagerDefault implements ICustomerHomeManager {
    public void fetchFeedIndex(ScopeContext scopeContext, int i) {
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

    public void refreshHomeByCityInfo() {
    }

    public void subscribeFeedIndex(ScopeContext scopeContext, Action1<CustomerResource<HomeFeedEntity>> action1) {
    }
}
