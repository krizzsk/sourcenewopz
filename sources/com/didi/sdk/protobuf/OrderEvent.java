package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

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
