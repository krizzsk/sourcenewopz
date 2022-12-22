package com.didi.soda.home.component.feed.helper;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeFeedEntity;
import com.didi.soda.customer.repo.CustomerResource;
import java.util.ArrayList;
import java.util.List;

public class FeedActionDispatcher implements IFeedAction {

    /* renamed from: a */
    private final ScopeContext f42591a;

    /* renamed from: b */
    private List<IFeedAction> f42592b = new ArrayList();

    public FeedActionDispatcher(ScopeContext scopeContext) {
        this.f42591a = scopeContext;
    }

    public void addActionList(IFeedAction iFeedAction) {
        this.f42592b.add(iFeedAction);
    }

    public void onReceiveFeedData(CustomerResource<HomeFeedEntity> customerResource) {
        for (IFeedAction onReceiveFeedData : this.f42592b) {
            onReceiveFeedData.onReceiveFeedData(customerResource);
        }
    }
}
