package com.didi.entrega.order.manager;

import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;

public interface OnceOrderListener {
    void onOnceOrderListener(OrderInfoEntity orderInfoEntity, int i);
}
