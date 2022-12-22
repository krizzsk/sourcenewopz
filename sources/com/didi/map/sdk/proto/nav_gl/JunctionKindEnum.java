package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum JunctionKindEnum implements ProtoEnum {
    JunctionKind_Left(0),
    JunctionKind_Right(1);
    
    private final int value;

    private JunctionKindEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
