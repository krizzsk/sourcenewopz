package com.didi.entrega.order.manager;

import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import java.util.List;

public abstract class BatchOrderListener {
    public abstract void onBatchOrderListener(List<OrderInfoEntity> list);
}
