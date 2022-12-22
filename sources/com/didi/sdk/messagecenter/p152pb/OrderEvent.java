package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.OrderEvent */
public enum OrderEvent implements ProtoEnum {
    kPGetOn(1),
    kPGetOff(2),
    kDArrive(3);
    
    private final int value;

    private OrderEvent(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
