package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.ProtoEnum;

public enum EpfOrderType implements ProtoEnum {
    NormalType(0),
    Appointed(1);
    
    private final int value;

    private EpfOrderType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
