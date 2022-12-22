package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum DrawingType implements ProtoEnum {
    Normal(0),
    NoPassing(1),
    NotRecommend(2);
    
    private final int value;

    private DrawingType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
