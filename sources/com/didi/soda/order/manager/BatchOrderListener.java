package com.didi.soda.order.manager;

import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import java.util.List;

public abstract class BatchOrderListener {
    public abstract void onBatchOrderListener(List<OrderInfoEntity> list);
}
