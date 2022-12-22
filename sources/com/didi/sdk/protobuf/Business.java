package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum Business implements ProtoEnum {
    Taxi(0),
    GulfStream(1),
    Nova(2);
    
    private final int value;

    private Business(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
