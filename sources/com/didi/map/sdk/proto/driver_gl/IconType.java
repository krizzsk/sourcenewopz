package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum IconType implements ProtoEnum {
    Non(0),
    Restrict(1),
    Jam(2),
    Close(3);
    
    private final int value;

    private IconType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
