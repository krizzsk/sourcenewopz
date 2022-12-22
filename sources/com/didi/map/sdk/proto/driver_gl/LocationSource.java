package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum LocationSource implements ProtoEnum {
    GPS(0),
    Network(1),
    VDR(2),
    Unknown(999);
    
    private final int value;

    private LocationSource(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
