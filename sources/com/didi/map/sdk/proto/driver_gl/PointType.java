package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum PointType implements ProtoEnum {
    BOARDING(0),
    BREAKOUT(1);
    
    private final int value;

    private PointType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
