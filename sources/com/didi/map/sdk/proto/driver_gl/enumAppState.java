package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum enumAppState implements ProtoEnum {
    Active(0),
    InActive(1),
    Background(2);
    
    private final int value;

    private enumAppState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
