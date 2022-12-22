package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;

public class AlertExtraEntity implements IEntity {
    public PayChannelEntity payChannel;
    public String payChannelRecommendList;
    public PayChannelEntity payFailedChannel;
}
