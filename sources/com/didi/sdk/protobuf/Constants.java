package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum Constants implements ProtoEnum {
    kMagic(22612),
    kNodeTypeMask(15),
    kNodeTypeShiftBits(8);
    
    private final int value;

    private Constants(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
