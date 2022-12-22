package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum WalkScene implements ProtoEnum {
    START(0),
    END(1);
    
    private final int value;

    private WalkScene(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
