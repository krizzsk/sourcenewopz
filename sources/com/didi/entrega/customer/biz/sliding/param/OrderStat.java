package com.didi.entrega.customer.biz.sliding.param;

import com.squareup.wire.ProtoEnum;

public enum OrderStat implements ProtoEnum {
    DeliveryGoods(3);
    
    private final int value;

    private OrderStat(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
