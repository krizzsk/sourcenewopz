package com.didi.soda.customer.biz.sliding.p163pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.soda.customer.biz.sliding.pb.OrderStat */
public enum OrderStat implements ProtoEnum {
    HomePage(1),
    SendOrder(2),
    WaitPick(3),
    OnTrip(4);
    
    private final int value;

    private OrderStat(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
