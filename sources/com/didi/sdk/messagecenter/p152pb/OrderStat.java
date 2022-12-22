package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.OrderStat */
public enum OrderStat implements ProtoEnum {
    HomePage(1),
    SendOrder(2),
    WaitPick(3),
    OnTrip(4),
    Bubble(5);
    
    private final int value;

    private OrderStat(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
