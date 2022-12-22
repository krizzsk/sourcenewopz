package com.didi.soda.order.manager;

import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;

public interface OnceOrderListener {
    void onOnceOrderListener(OrderInfoEntity orderInfoEntity, int i);
}
