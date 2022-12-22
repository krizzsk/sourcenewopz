package com.didi.entrega.manager.base;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.home.component.feed.entity.HomeFeedEntity;

public interface ICustomerHomeManager extends ICustomerManager {
    void fetchFeedIndex(ScopeContext scopeContext, int i);

    void locateThenRefreshHome(int i);

    void refreshHomeByCityInfo();

    void subscribeFeedIndex(ScopeContext scopeContext, Action1<CustomerResource<HomeFeedEntity>> action1);
}
