package com.didi.soda.home.component.feed.helper;

import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeFeedEntity;
import com.didi.soda.customer.repo.CustomerResource;

public interface IFeedAction {
    void onReceiveFeedData(CustomerResource<HomeFeedEntity> customerResource);
}
